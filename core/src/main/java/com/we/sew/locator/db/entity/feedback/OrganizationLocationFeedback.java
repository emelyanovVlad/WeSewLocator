package com.we.sew.locator.db.entity.feedback;

import com.we.sew.locator.db.Db;
import com.we.sew.locator.db.entity.OrganizationLocation;

import javax.persistence.*;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.OrganizationLocationFeedback.TABLE_NAME)
public class OrganizationLocationFeedback extends AbstractFeedback {

    @Id
    @Column(name = Db.OrganizationLocationFeedback.ID, length = 100)
    private String id;

    @ManyToOne
    @JoinColumn(name = Db.OrganizationLocationFeedback.ORGANIZATION_LOCATION_ID)
    private OrganizationLocation organizationLocation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrganizationLocation getOrganizationLocation() {
        return organizationLocation;
    }

    public void setOrganizationLocation(OrganizationLocation organizationLocation) {
        this.organizationLocation = organizationLocation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrganizationLocationFeedback{");
        sb.append(super.toString());
        sb.append("id='").append(id).append('\'');
        sb.append(", organizationLocation=").append(organizationLocation);
        sb.append('}');
        return sb.toString();
    }
}
