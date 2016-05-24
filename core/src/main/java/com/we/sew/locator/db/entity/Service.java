package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;
import com.we.sew.locator.db.entity.api.StatusUpdaterInfoEntity;
import com.we.sew.locator.db.entity.api.UpdaterInfoEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.Service.TABLE_NAME)
public class Service extends StatusUpdaterInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Db.Service.ID)
    private int id;

    @Column(name = Db.Service.NAME)
    private String name;

    @ManyToOne
    @JoinColumn(name = Db.Service.CATEGORY_ID)
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = Db.ServiceOrganization.TABLE_NAME,
            joinColumns = @JoinColumn(name = Db.ServiceOrganization.SERVICE_ID, nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = Db.ServiceOrganization.ORG_ID, nullable = false, updatable = false))
    private Set<Organization> organizations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (id != service.id) return false;
        if (name != null ? !name.equals(service.name) : service.name != null) return false;
        return category != null ? category.equals(service.category) : service.category == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Service{");
        sb.append(super.toString());
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }

}
