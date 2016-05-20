package com.we.sew.locator.db.entity.feedback.mood;

import com.we.sew.locator.db.Db;
import com.we.sew.locator.db.entity.feedback.OrganizationLocationFeedback;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.OrgLocFeedbackUserMood.TABLE_NAME)
public class OrgLocFeedbackUserMood extends AbstractMood {

    @ManyToOne
    @JoinColumn(name = Db.OrgLocFeedbackUserMood.ORG_LOC_ID)
    private OrganizationLocationFeedback orgLocFeedback;

    public OrganizationLocationFeedback getOrgLocFeedback() {
        return orgLocFeedback;
    }

    public void setOrgLocFeedback(OrganizationLocationFeedback orgLocFeedback) {
        this.orgLocFeedback = orgLocFeedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrgLocFeedbackUserMood that = (OrgLocFeedbackUserMood) o;

        return orgLocFeedback != null ? orgLocFeedback.equals(that.orgLocFeedback) : that.orgLocFeedback == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (orgLocFeedback != null ? orgLocFeedback.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrgLocUserMood{");
        sb.append(super.toString()).append("orgLocFeedback=").append(orgLocFeedback);
        sb.append('}');
        return sb.toString();
    }
}
