package com.we.sew.locator.web.controller.admin;

import com.we.sew.locator.bean.LocationBean;
import com.we.sew.locator.db.entity.Location;
import com.we.sew.locator.service.app.api.ILocationService;
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
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebUtil.Mapping.ADMIN + WebUtil.Mapping.LOCATIONS)
public class LocationController extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private ILocationService locationService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Location> getAll() {
        return locationService.getAll();
    }

    @RequestMapping(value = WebUtil.Mapping.ADD, method = RequestMethod.POST)
    public @ResponseBody String addLocation(@Valid LocationBean locationBean, HttpSession session) {
        locationService.create(locationBean, curUser(session));
        LOGGER.debug(locationBean.toString() + " created.");
        return locationBean.getName();
    }

    @RequestMapping(value = WebUtil.Mapping.DELETE, method = RequestMethod.POST)
    public @ResponseBody String deleteLocation(@RequestParam String locationId) {
        Location deletedLocation = locationService.delete(locationId);
        LOGGER.warn(deletedLocation.toString() + " was deleted.");
        return deletedLocation.getName();
    }

    @RequestMapping(value = WebUtil.Mapping.EDIT, method = RequestMethod.POST)
    public @ResponseBody String updateLocation(@RequestParam String locationId, @Valid LocationBean locationBean, HttpSession session) {
        Location location = locationService.get(locationId);
        updateOldLocation(location, locationBean);

        locationService.update(location, curUser(session));
        LOGGER.warn(location.toString() + " was updated");
        return location.getName();
    }

    private void updateOldLocation(Location location, LocationBean locationBean) {
        location.setName(locationBean.getName());
        location.setLatitude(locationBean.getLatitude());
        location.setLongitude(locationBean.getLongtitude());
    }

    @RequestMapping(value = WebUtil.Mapping.FIND, method = RequestMethod.GET)
    public List<Location> findBy(@RequestParam String name) {
        if (StringUtils.isBlank(name)) {
            return locationService.getAll();
        }
        return locationService.getAllBy(name);
    }

}
