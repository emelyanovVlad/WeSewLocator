package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;
import com.we.sew.locator.db.entity.api.StatusUpdaterInfoEntity;
import com.we.sew.locator.db.entity.feedback.OrganizationLocationFeedback;

import javax.persistence.*;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.OrganizationLocation.TABLE_NAME)
public class OrganizationLocation extends StatusUpdaterInfoEntity {

    @Id
    @Column(name = Db.OrganizationLocation.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = Db.OrganizationLocation.DESCRIPTION)
    private String desc;

    @ManyToOne
    @JoinColumn(name = Db.OrganizationLocation.ORGANIZATION_ID)
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = Db.OrganizationLocation.LOCATION_ID)
    private Location location;

    @OneToMany(mappedBy = "organizationLocation")
    private List<OrganizationLocationFeedback> organizationLocationsFeedback;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<OrganizationLocationFeedback> getOrganizationLocationsFeedback() {
        return organizationLocationsFeedback;
    }

    public void setOrganizationLocationsFeedback(List<OrganizationLocationFeedback> organizationLocationsFeedback) {
        this.organizationLocationsFeedback = organizationLocationsFeedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationLocation that = (OrganizationLocation) o;

        if (id != that.id) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null) return false;
        return location != null ? location.equals(that.location) : that.location == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrganizationLocation{");
        sb.append(super.toString());
        sb.append("id=").append(id);
        sb.append(", desc='").append(desc).append('\'');
        sb.append(", organization=").append(organization);
        sb.append(", location=").append(location);
        sb.append('}');
        return sb.toString();
    }
}
