package com.we.sew.locator.admin.service.app;

import com.we.sew.locator.bean.TypeBean;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.entity.Type;
import com.we.sew.locator.db.repository.TypeRepository;
import com.we.sew.locator.admin.service.app.api.AbstractService;
import com.we.sew.locator.admin.service.app.api.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class TypeService extends AbstractService implements ITypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type getBy(String name) {
        return typeRepository.findOneByName(name);
    }

    @Override
    public List<Type> getAllBy(String name) {
        return typeRepository.findByNameContaining(name);
    }

    @Override
    public void create(TypeBean el, SystemUser creator) {
        Type type = new Type();
        type.setName(el.getName());

        creationUpdateInfoEntityFiller.fill(type, creator);
        typeRepository.save(type);
    }

    @Override
    public Type get(Integer id) {
        return typeRepository.getOne(id);
    }

    @Override
    public List<Type> getAll() {
        return typeRepository.findAll();
    }

    @Override
    public void update(Type el, SystemUser updater) {
        editionUpdateInfoEntityFiller.fill(el, updater);

        typeRepository.saveAndFlush(el);
    }

    @Override
    public Type delete(Integer id) {
        Type deletedType = get(id);
        typeRepository.delete(id);
        return deletedType;
    }
}
