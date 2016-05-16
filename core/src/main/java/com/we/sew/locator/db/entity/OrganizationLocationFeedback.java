package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.*;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.OrganizationLocationFeedback.TABLE_NAME)
public class OrganizationLocationFeedback extends UpdaterInfoEntity {

    @Id
    @Column(name = Db.OrganizationLocationFeedback.ID, length = 100)
    private String id;

    @ManyToOne
    @JoinColumn(name = Db.OrganizationLocationFeedback.ORGANIZATION_LOCATION_ID)
    private OrganizationLocation organizationLocation;

    @Column(name = Db.OrganizationLocationFeedback.BODY, nullable = false)
    private String body;

    @Column(name = Db.OrganizationLocationFeedback.RATING)
    private int rating;

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrganizationLocationFeedback that = (OrganizationLocationFeedback) o;

        if (rating != that.rating) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (organizationLocation != null ? !organizationLocation.equals(that.organizationLocation) : that.organizationLocation != null) return false;
        return body != null ? body.equals(that.body) : that.body == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (organizationLocation != null ? organizationLocation.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrganizationLocationFeedback{");
        sb.append("id='").append(id).append('\'');
        sb.append(", organizationLocation=").append(organizationLocation);
        sb.append(", body='").append(body).append('\'');
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}
