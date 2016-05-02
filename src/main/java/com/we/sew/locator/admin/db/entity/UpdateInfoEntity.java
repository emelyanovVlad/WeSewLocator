package com.we.sew.locator.admin.db.entity;

import com.we.sew.locator.admin.db.Db;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @author Vladyslav_Yemelianov
 */
@MappedSuperclass
public abstract class UpdateInfoEntity {
    @Column(name = Db.UpdateInfo.CREATE_TIME, nullable = false)
    private int creationTime;

    @ManyToOne
    @JoinColumn(name = Db.UpdateInfo.CREATOR_ID)
    private SystemUser creator;

    @Column(name = Db.UpdateInfo.UPDATE_TIME, nullable = false)
    private int updateTime;

    @ManyToOne
    @JoinColumn(name = Db.UpdateInfo.UPDATER_ID)
    private SystemUser updater;

    public int getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(int creationTime) {
        this.creationTime = creationTime;
    }

    public SystemUser getCreator() {
        return creator;
    }

    public void setCreator(SystemUser creator) {
        this.creator = creator;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public SystemUser getUpdater() {
        return updater;
    }

    public void setUpdater(SystemUser updater) {
        this.updater = updater;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateInfoEntity{");
        sb.append("creationTime=").append(creationTime);
        sb.append(", creator='").append(creator).append('\'');
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updater=").append(updater);
        sb.append('}');
        return sb.toString();
    }
}
