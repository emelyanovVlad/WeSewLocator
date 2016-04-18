package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.*;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.Organization.TABLE_NAME)
public class Organization extends UpdateInfoEntity {
    @Id
    @Column(name = Db.Organization.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = Db.Organization.TYPE_ID)
    private Type type;

    @Column(name = Db.Organization.NAME, nullable = false)
    private String name;

    @Column(name = Db.Organization.DESCRIPTION, nullable = false)
    private String description;

    @Column(name = Db.Organization.FOUNDED, nullable = false)
    private int foundationDate;

    public Organization() {
    }

    public Organization(int id, Type type, String name, String description, int foundationDate) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        this.foundationDate = foundationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public int getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(int foundationDate) {
        this.foundationDate = foundationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (id != that.id) return false;
        if (foundationDate != that.foundationDate) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + foundationDate;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Organization{");
        sb.append("id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", foundationDate=").append(foundationDate);
        sb.append('}');
        return sb.toString();
    }
}
