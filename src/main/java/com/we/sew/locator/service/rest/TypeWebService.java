package com.we.sew.locator.service.rest;

import com.we.sew.locator.db.entity.Type;
import com.we.sew.locator.db.repository.TypeRepository;
import com.we.sew.locator.service.rest.api.ITypeWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class TypeWebService implements ITypeWebService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> getAll() {
        return typeRepository.findAll();
    }
}
