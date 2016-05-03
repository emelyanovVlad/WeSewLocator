package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.bean.OrganizationLocationBean;
import com.we.sew.locator.db.entity.OrganizationLocation;
import com.we.sew.locator.admin.service.api.IOrganizationLocationService;
import com.we.sew.locator.admin.web.WebUtil;
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
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebUtil.Mapping.ORGANIZATION_LOCATION)
public class OrganizationLocationController extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationLocationController.class);
    private static final String ADD_MSG_FORMAT = "%s added to %s";
    private static final String DELETE_MSG_FORMAT = "%s deleted from %s";

    @Autowired
    private IOrganizationLocationService organizationLocationService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<OrganizationLocation> getAll() {
        return organizationLocationService.getAll();
    }

    @RequestMapping(value = WebUtil.Mapping.ADD, method = RequestMethod.POST)
    public
    @ResponseBody
    String addRelationship(@Valid OrganizationLocationBean organizationLocationBean, HttpSession session) {
        organizationLocationService.create(organizationLocationBean, curUser(session));

        String formattedAddMsg = String.format(ADD_MSG_FORMAT, organizationLocationBean.getLocationName(), organizationLocationBean.getOrganizationName());
        LOGGER.debug(formattedAddMsg);
        return formattedAddMsg;
    }

    @RequestMapping(value = WebUtil.Mapping.DELETE, method = RequestMethod.POST)
    public
    @ResponseBody
    String deleteRel(@RequestParam int orgLocId) {
        OrganizationLocation deletedOrgLoc = organizationLocationService.delete(orgLocId);
        String formattedDeleteMsg = String.format(DELETE_MSG_FORMAT, deletedOrgLoc.getLocation().getName(), deletedOrgLoc.getOrganization().getName());
        LOGGER.warn(formattedDeleteMsg);
        return formattedDeleteMsg;
    }

    @RequestMapping(value = WebUtil.Mapping.EDIT, method = RequestMethod.POST)
    public
    @ResponseBody
    String editRel(@RequestParam int orgLocId, @Valid OrganizationLocationBean organizationLocationBean, HttpSession session) {
        OrganizationLocation organizationLocation = organizationLocationService.get(orgLocId);
        organizationLocation.setDesc(organizationLocationBean.getDescription());

        organizationLocationService.update(organizationLocation, curUser(session));

        LOGGER.debug(organizationLocation.getId() + " updated.");
        return organizationLocation.getOrganization().getName() + " - " + organizationLocation.getLocation().getName() + " updated.";
    }

}
