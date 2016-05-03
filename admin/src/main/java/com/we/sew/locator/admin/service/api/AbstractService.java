package com.we.sew.locator.admin.service.api;

import com.we.sew.locator.admin.util.filler.CreationUpdateInfoEntityFiller;
import com.we.sew.locator.admin.util.filler.EditionUpdateInfoEntityFiller;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Vladyslav_Yemelianov
 */
public abstract class AbstractService {
    @Autowired
    protected CreationUpdateInfoEntityFiller creationUpdateInfoEntityFiller;
    @Autowired
    protected EditionUpdateInfoEntityFiller editionUpdateInfoEntityFiller;
}
