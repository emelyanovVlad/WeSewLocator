package com.we.sew.locator.db.entity.feedback.mood;

import com.we.sew.locator.db.Db;
import com.we.sew.locator.db.entity.feedback.OrganizationFeedback;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.OrgFeedbackUserMood.TABLE_NAME)
public class OrgFeedbackUserMood extends AbstractMood {

    @ManyToOne
    @JoinColumn(name = Db.OrgFeedbackUserMood.ORG_ID)
    private OrganizationFeedback orgFeedback;

    public OrganizationFeedback getOrgFeedback() {
        return orgFeedback;
    }

    public void setOrgFeedback(OrganizationFeedback orgFeedback) {
        this.orgFeedback = orgFeedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrgFeedbackUserMood that = (OrgFeedbackUserMood) o;

        return orgFeedback != null ? orgFeedback.equals(that.orgFeedback) : that.orgFeedback == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (orgFeedback != null ? orgFeedback.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrgFeedbackUserMood{");
        sb.append(super.toString()).append("orgFeedback=").append(orgFeedback);
        sb.append('}');
        return sb.toString();
    }
}
