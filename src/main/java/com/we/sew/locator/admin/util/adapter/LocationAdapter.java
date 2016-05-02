package com.we.sew.locator.admin.util.adapter;

import com.we.sew.locator.admin.bean.LocationBean;
import com.we.sew.locator.admin.db.entity.Location;
import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class LocationAdapter implements EntityAdapter<Location, LocationBean> {

    @Override
    public Location adapt(LocationBean el) {
        Location location = new Location();
        location.setLatitude(el.getLatitude());
        location.setLongitude(el.getLongtitude());
        location.setName(el.getName());
        return location;
    }
}
