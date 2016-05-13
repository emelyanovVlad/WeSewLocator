package com.we.sew.locator.admin.service;

import com.we.sew.locator.bean.RoleBean;
import com.we.sew.locator.db.entity.Role;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.RoleRepository;
import com.we.sew.locator.admin.service.api.AbstractService;
import com.we.sew.locator.admin.service.api.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class RoleService extends AbstractService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    private static final String ROLE = "ROLE_";

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
        role.setName(ROLE + el.getName().toUpperCase());
        roleRepository.save(role);
    }

    @Override
    public Role get(Integer id) {
        return roleRepository.getOne(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll().stream().map(role -> {
            role.setName(role.getName().substring(ROLE.length()));
            return role;
        }).collect(Collectors.toList());
    }

    @Override
    public void update(Role el, SystemUser updater) {
        editionUpdaterInfoEntityFiller.fill(el, updater);
        roleRepository.saveAndFlush(el);
    }

    @Override
    public Role delete(Integer id) {
        Role deletedRole = get(id);
        roleRepository.delete(id);
        return deletedRole;
    }
}
