package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.*;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.Location.TABLE_NAME)
public class Location extends UpdateInfoEntity {
    @Id
    @Column(name = Db.Location.ID, nullable = false, length = 100)
    private String id;

    @Column(name = Db.Location.NAME, nullable = false, unique = true)
    private String name;

    @Column(name = Db.Location.LATITUDE, nullable = false)
    private double latitude;

    @Column(name = Db.Location.LONGITUDE, nullable = false)
    private double longitude;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private List<OrganizationLocation> organizations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<OrganizationLocation> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<OrganizationLocation> organizations) {
        this.organizations = organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != location.id) return false;
        if (Double.compare(location.latitude, latitude) != 0) return false;
        if (Double.compare(location.longitude, longitude) != 0) return false;
        return name != null ? name.equals(location.name) : location.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Location{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append('}');
        return sb.toString();
    }
}
