package com.we.sew.locator.service.app;

import com.we.sew.locator.db.entity.Type;
import com.we.sew.locator.service.app.api.ITypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class TypeService implements ITypeService {
    @Override
    public Type getBy(String name) {
        return null;
    }

    @Override
    public List<Type> getAllBy(String name) {
        return null;
    }

    @Override
    public void create(Type el) {

    }

    @Override
    public Type get(Integer integer) {
        return null;
    }

    @Override
    public List<Type> getAll() {
        return null;
    }

    @Override
    public void update(Type el) {

    }

    @Override
    public Type delete(Integer el) {
        return null;
    }
}
