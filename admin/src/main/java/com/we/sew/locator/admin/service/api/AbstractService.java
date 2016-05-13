package com.we.sew.locator.admin.service.api;

import com.we.sew.locator.admin.util.filler.CreationUpdaterInfoEntityFiller;
import com.we.sew.locator.admin.util.filler.EditionUpdaterInfoEntityFiller;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Vladyslav_Yemelianov
 */
public abstract class AbstractService {
    @Autowired
    protected CreationUpdaterInfoEntityFiller creationUpdaterInfoEntityFiller;
    @Autowired
    protected EditionUpdaterInfoEntityFiller editionUpdaterInfoEntityFiller;
}
