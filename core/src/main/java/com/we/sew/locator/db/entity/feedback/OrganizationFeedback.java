package com.we.sew.locator.db.entity.feedback;

import com.we.sew.locator.db.Db;
import com.we.sew.locator.db.entity.Organization;

import javax.persistence.*;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.OrganizationFeedback.TABLE_NAME)
public class OrganizationFeedback extends AbstractFeedback {
    @Id
    @Column(name = Db.OrganizationFeedback.ID, length = 100)
    private String id;

    @ManyToOne
    @JoinColumn(name = Db.OrganizationFeedback.ORGANIZATION_ID)
    private Organization organization;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrganizationFeedback{");
        sb.append(super.toString());
        sb.append("id='").append(id).append('\'');
        sb.append(", organization=").append(organization);
        sb.append('}');
        return sb.toString();
    }
}
