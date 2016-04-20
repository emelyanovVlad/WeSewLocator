package com.we.sew.locator.service.app;

import com.we.sew.locator.bean.RoleBean;
import com.we.sew.locator.db.entity.Role;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.RoleRepository;
import com.we.sew.locator.service.app.api.AbstractService;
import com.we.sew.locator.service.app.api.IRoleService;
import com.we.sew.locator.util.filler.CreationUpdateInfoEntityFiller;
import com.we.sew.locator.util.filler.EditionUpdateInfoEntityFiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class RoleService extends AbstractService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getBy(String name) {
        return roleRepository.findOneByName(name);
    }

    @Override
    public List<Role> getAllBy(String name) {
        return roleRepository.findByNameContaining(name);
    }

    @Override
    public void create(RoleBean el, SystemUser creator) {
        Role role = new Role();
        role.setName(el.getName());
        creationUpdateInfoEntityFiller.fill(role, creator);
        roleRepository.save(role);
    }

    @Override
    public Role get(Integer id) {
        return roleRepository.findOne(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public void update(Role el, SystemUser updater) {
        editionUpdateInfoEntityFiller.fill(el, updater);
        roleRepository.save(el);
    }

    @Override
    public Role delete(Integer id) {
        Role deletedRole = get(id);
        roleRepository.delete(id);
        return deletedRole;
    }
}