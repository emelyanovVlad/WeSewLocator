package com.we.sew.locator.web.controller.admin;

import com.we.sew.locator.bean.OrganizationBean;
import com.we.sew.locator.db.entity.Organization;
import com.we.sew.locator.service.app.api.IOrganizationService;
import com.we.sew.locator.service.app.api.ITypeService;
import com.we.sew.locator.util.adapter.date.DateStringToIntegerAdapter;
import com.we.sew.locator.web.WebUtil;
import com.we.sew.locator.web.controller.AbstractAppController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebUtil.Mapping.ADMIN + WebUtil.Mapping.ORGANIZATIONS)
public class OrganizationController extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private IOrganizationService organizationService;
    @Autowired
    private ITypeService typeService;
    @Autowired
    private DateStringToIntegerAdapter adapter;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Organization> getAll() {
        return organizationService.getAll();
    }

    @RequestMapping(value = WebUtil.Mapping.ADD, method = RequestMethod.POST)
    public @ResponseBody String addOrganization(@Valid OrganizationBean organizationBean, HttpSession session) {
        organizationService.create(organizationBean, curUser(session));
        LOGGER.debug(organizationBean.toString() + " created.");
        return organizationBean.getName();
    }

    @RequestMapping(value = WebUtil.Mapping.EDIT, method = RequestMethod.POST)
    public @ResponseBody String updateOrg(@RequestParam int orgId, @Valid OrganizationBean organizationBean, HttpSession session) {
        Organization organization = organizationService.get(orgId);
        if (organization == null) {
            return "No organization found by id: " + orgId;
        }
        updateOldEntity(organization, organizationBean);
        organizationService.update(organization, curUser(session));
        LOGGER.warn(organization.toString() + " updated");
        return organization.getName();
    }

    private void updateOldEntity(Organization organization, OrganizationBean organizationBean) {
        organization.setName(organizationBean.getName());
        organization.setFoundationDate(adapter.adapt(organizationBean.getFoundationDate()));
        organization.setDescription(organizationBean.getDescription());
        organization.setType(typeService.getBy(organizationBean.getTypeName()));
    }

    @RequestMapping(value = WebUtil.Mapping.DELETE, method = RequestMethod.POST)
    public @ResponseBody String deleteOrg(@RequestParam int orgId) {
        Organization deletedOrg = organizationService.delete(orgId);
        LOGGER.warn(deletedOrg.toString() + " was deleted.");
        return deletedOrg.getName();
    }

    @RequestMapping(value = WebUtil.Mapping.FIND, method = RequestMethod.GET)
    public @ResponseBody List<Organization> find(@RequestParam String name) {
        if (StringUtils.isBlank(name)) {
            return organizationService.getAll();
        }
        return organizationService.getAllBy(name);
    }
}
