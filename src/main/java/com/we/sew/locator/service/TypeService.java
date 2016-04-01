package com.we.sew.locator.service;

import com.we.sew.locator.db.entity.Type;
import com.we.sew.locator.db.repository.TypeRepository;
import com.we.sew.locator.service.api.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class TypeService implements ITypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> getAll() {
        return typeRepository.findAll();
    }
}
