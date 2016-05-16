package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @author Vladyslav_Yemelianov
 */
@MappedSuperclass
public abstract class UpdaterInfoEntity extends TimeInfoEntity {

    @ManyToOne
    @JoinColumn(name = Db.UpdateInfo.CREATOR_ID)
    private SystemUser creator;

    @ManyToOne
    @JoinColumn(name = Db.UpdateInfo.UPDATER_ID)
    private SystemUser updater;

    public SystemUser getCreator() {
        return creator;
    }

    public void setCreator(SystemUser creator) {
        this.creator = creator;
    }

    public SystemUser getUpdater() {
        return updater;
    }

    public void setUpdater(SystemUser updater) {
        this.updater = updater;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdaterInfoEntity that = (UpdaterInfoEntity) o;

        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;
        return updater != null ? updater.equals(that.updater) : that.updater == null;

    }

    @Override
    public int hashCode() {
        int result = creator != null ? creator.hashCode() : 0;
        result = 31 * result + (updater != null ? updater.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdaterInfoEntity{");
        sb.append("creator=").append(creator);
        sb.append(", updater=").append(updater);
        sb.append('}');
        return sb.toString();
    }
}
