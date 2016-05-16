package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.*;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.OrganizationFeedback.TABLE_NAME)
public class OrganizationFeedback extends UpdaterInfoEntity {
    @Id
    @Column(name = Db.OrganizationFeedback.ID, length = 100)
    private String id;

    @ManyToOne
    @JoinColumn(name = Db.OrganizationFeedback.ORGANIZATION_ID)
    private Organization organization;

    @Column(name = Db.OrganizationFeedback.BODY, nullable = false)
    private String body;

    @Column(name = Db.OrganizationFeedback.RATING)
    private int rating;

    public OrganizationFeedback() {
    }

    public OrganizationFeedback(String id, String body, int rating) {
        this.id = id;
        this.body = body;
        this.rating = rating;
    }

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

        OrganizationFeedback organizationFeedback = (OrganizationFeedback) o;

        if (rating != organizationFeedback.rating) return false;
        if (id != null ? !id.equals(organizationFeedback.id) : organizationFeedback.id != null) return false;
        if (organization != null ? !organization.equals(organizationFeedback.organization) : organizationFeedback.organization != null) return false;
        return body != null ? body.equals(organizationFeedback.body) : organizationFeedback.body == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Feedback{");
        sb.append("id='").append(id).append('\'');
        sb.append(", organization=").append(organization);
        sb.append(", body='").append(body).append('\'');
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}
