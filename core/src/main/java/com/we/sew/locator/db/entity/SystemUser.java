package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.*;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.SystemUser.TABLE_NAME)
public class SystemUser extends TimeInfoEntity {
    @Id
    @Column(name = Db.SystemUser.ID, length = 100)
    private String id;

    @Column(name = Db.SystemUser.EMAIL, nullable = false)
    private String email;

    @Column(name = Db.SystemUser.PASSWORD, nullable = false)
    private String password;

    @Column(name = Db.SystemUser.FULL_NAME, nullable = false)
    private String fullName;

    @Column(name = Db.SystemUser.BIRTH_DATE, nullable = false)
    private long birthDate;

    @Column(name = Db.SystemUser.LAST_LOGIN, nullable = false)
    private long lastLogin;

    @ManyToOne
    @JoinColumn(name = Db.SystemUser.ROLE_ID)
    private Role role;

    public SystemUser() {
    }

    public SystemUser(String id, String email, String password, String fullName, int birthDate, int lastLogin, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.lastLogin = lastLogin;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public long getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemUser user = (SystemUser) o;

        if (birthDate != user.birthDate) return false;
        if (lastLogin != user.lastLogin) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (fullName != null ? !fullName.equals(user.fullName) : user.fullName != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = (int) (31 * result + birthDate);
        result = (int) (31 * result + lastLogin);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SystemUser{");
        sb.append("id='").append(id).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
