package com.we.sew.locator.service.app.api;

import com.we.sew.locator.util.filler.CreationUpdateInfoEntityFiller;
import com.we.sew.locator.util.filler.EditionUpdateInfoEntityFiller;
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
