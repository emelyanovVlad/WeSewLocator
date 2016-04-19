package com.we.sew.locator.service.app;

import com.we.sew.locator.db.entity.Role;
import com.we.sew.locator.service.app.api.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class RoleService implements IRoleService {
    @Override
    public Role getBy(String name) {
        return null;
    }

    @Override
    public List<Role> getAllBy(String name) {
        return null;
    }

    @Override
    public void create(Role el) {

    }

    @Override
    public Role get(Integer integer) {
        return null;
    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public void update(Role el) {

    }

    @Override
    public Role delete(Integer el) {
        return null;
    }
}
