package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.admin.service.api.IServiceService;
import com.we.sew.locator.admin.web.WebUtil;
import com.we.sew.locator.bean.ServiceBean;
import com.we.sew.locator.db.entity.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebUtil.Mapping.SERVICES)
public class ServicesController extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServicesController.class);

    @Autowired
    private IServiceService serviceService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Service> getAll() {
        return serviceService.getAll();
    }

    @RequestMapping(value = WebUtil.Mapping.ADD, method = RequestMethod.POST)
    public @ResponseBody String addService(@Valid ServiceBean serviceBean, HttpSession session) {
        serviceService.create(serviceBean, curUser(session));

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(serviceBean.getName() + " was created");
        }

        return serviceBean.getName();
    }

}
