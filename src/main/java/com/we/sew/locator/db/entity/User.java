package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.*;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.User.TABLE_NAME)
public class User extends UpdateInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Db.User.ID)
    private String id;
    @Column(name = Db.User.EMAIL, nullable = false)
    private String email;
    @Column(name = Db.User.PASSWORD, nullable = false)
    private String password;
    @Column(name = Db.User.FULL_NAME, nullable = false)
    private String fullName;
    @Column(name = Db.User.BIRTH_DATE, nullable = false)
    private int birthDate;
    @Column(name = Db.User.LAST_LOGIN, nullable = false)
    private int lastLogin;
    @ManyToOne
    @JoinColumn(name = Db.User.ROLE_ID)
    private Role role;

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

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public int getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(int lastLogin) {
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

        User user = (User) o;

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
        result = 31 * result + birthDate;
        result = 31 * result + lastLogin;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
