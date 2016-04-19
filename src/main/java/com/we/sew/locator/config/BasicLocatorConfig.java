package com.we.sew.locator.config;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.provider.BinaryDataProvider;
import org.apache.cxf.jaxrs.spring.SpringResourceFactory;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.ws.rs.Path;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.we.sew.locator")
@EntityScan("com.we.sew.locator.db.entity")
@EnableJpaRepositories("com.we.sew.locator.db.repository")
@ImportResource({"classpath:META-INF/cxf/cxf.xml", "classpath:META-INF/cxf/cxf-servlet.xml"})
@Import({SecurityConfig.class})
public class BasicLocatorConfig {

    @Autowired
    private ApplicationContext ctx;
    @Value("${application.mapping}")
    private String appMapping;
    @Value("${application.server.ctxpath}")
    private String ctxPath;
    @Value("${application.port}")
    private int port;

    public static void main(String[] args) {
        SpringApplication.run(BasicLocatorConfig.class, args);
    }

    @Bean
    public ServletRegistrationBean cxfServletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new CXFServlet(), appMapping);
        registrationBean.setAsyncSupported(true);
        registrationBean.setLoadOnStartup(1);
        registrationBean.setName("CXFServlet");
        return registrationBean;
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        return new JettyEmbeddedServletContainerFactory(ctxPath, port);
    }

    @Bean
    public Server jaxRsServer() {
        List<ResourceProvider> resourceProviders = new LinkedList<>();
        for (String beanName : ctx.getBeanDefinitionNames()) {
            if (ctx.findAnnotationOnBean(beanName, Path.class) != null) {
                SpringResourceFactory factory = new SpringResourceFactory(beanName);
                factory.setApplicationContext(ctx);
                resourceProviders.add(factory);
            }
        }
        if (resourceProviders.size() > 0) {
            JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
            factoryBean.setBus(ctx.getBean(SpringBus.class));
            factoryBean.setResourceProviders(resourceProviders);
            setProviders(factoryBean);
            return factoryBean.create();
        }
        return null;
    }

    private void setProviders(JAXRSServerFactoryBean factoryBean) {
        JacksonJsonProvider jsonProvider = new JacksonJsonProvider();
        BinaryDataProvider<InputStream> binaryDataProvider = new BinaryDataProvider<>();
        factoryBean.setProviders(Arrays.asList(jsonProvider, binaryDataProvider));
    }

}
