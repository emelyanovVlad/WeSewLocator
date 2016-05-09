package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.admin.service.api.IBranchService;
import com.we.sew.locator.admin.web.WebUtil;
import com.we.sew.locator.bean.BranchBean;
import com.we.sew.locator.db.entity.Branch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebUtil.Mapping.BRANCHES)
public class BranchController extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BranchController.class);

    @Autowired
    private IBranchService branchService;

    public
    @ResponseBody
    List<Branch> getAll() {
        return branchService.getAll();
    }


    public String addBranch(@Valid BranchBean branchBean, HttpSession session) {
        branchService.create(branchBean, curUser(session));

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(branchBean.getName() + " was created");
        }

        return branchBean.getName() + " was created";
    }
}
