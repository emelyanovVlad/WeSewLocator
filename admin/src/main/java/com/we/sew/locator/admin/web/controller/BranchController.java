package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.admin.service.api.IBranchService;
import com.we.sew.locator.admin.web.WebUtil;
import com.we.sew.locator.bean.BranchBean;
import com.we.sew.locator.db.entity.Branch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@Validated
@RequestMapping(value = WebUtil.Mapping.BRANCHES)
public class BranchController extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BranchController.class);

    @Autowired
    private IBranchService branchService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Branch> getAll() {
        return branchService.getAll();
    }

    @RequestMapping(value = WebUtil.Mapping.ADD, method = RequestMethod.POST)
    public @ResponseBody String addBranch(@Valid @RequestBody BranchBean branchBean, HttpSession session) {
        branchService.create(branchBean, curUser(session));

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(branchBean.getName() + " was created");
        }

        return branchBean.getName();
    }
}
