package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.Organization.TABLE_NAME)
public class Organization extends UpdaterInfoEntity {
    @Id
    @Column(name = Db.Organization.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = Db.Organization.CATEGORY_ID)
    private Category category;

    @Column(name = Db.Organization.NAME, nullable = false, unique = true)
    private String name;

    @Column(name = Db.Organization.DESCRIPTION, nullable = false)
    private String description;

    @Column(name = Db.Organization.FOUNDED, nullable = false)
    private long foundationDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private List<OrganizationLocation> locations;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = Db.ServiceOrganization.TABLE_NAME,
            joinColumns = @JoinColumn(name = Db.ServiceOrganization.ORG_ID, nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = Db.ServiceOrganization.SERVICE_ID, nullable = false, updatable = false))
    private Set<Service> services;

    @OneToMany(mappedBy = "organization")
    private List<OrganizationFeedback> organizationFeedbacks;

    public Organization() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(long foundationDate) {
        this.foundationDate = foundationDate;
    }

    public List<OrganizationLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<OrganizationLocation> locations) {
        this.locations = locations;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public List<OrganizationFeedback> getOrganizationFeedbacks() {
        return organizationFeedbacks;
    }

    public void setOrganizationFeedbacks(List<OrganizationFeedback> organizationFeedbacks) {
        this.organizationFeedbacks = organizationFeedbacks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (id != that.id) return false;
        if (foundationDate != that.foundationDate) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = (int) (31 * result + foundationDate);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Organization{");
        sb.append("id=").append(id);
        sb.append(", category=").append(category);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", foundationDate=").append(foundationDate);
        sb.append('}');
        return sb.toString();
    }
}
