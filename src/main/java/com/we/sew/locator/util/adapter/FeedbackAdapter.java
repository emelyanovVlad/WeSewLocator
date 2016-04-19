package com.we.sew.locator.util.adapter;

import com.we.sew.locator.bean.FeedbackBean;
import com.we.sew.locator.db.entity.Feedback;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class FeedbackAdapter implements EntityAdapter<Feedback, FeedbackBean> {


    @Override
    public Feedback adapt(FeedbackBean el) {
        return null;
    }
}
