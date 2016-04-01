package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

/**
 * @author Vladyslav_Yemelianov
 */
@MappedSuperclass
public abstract class UpdateInfoEntity {
    @Column(name = Db.UpdateInfo.CREATE_TIME, nullable = false)
    private int creationTime;
    @Column(name = Db.UpdateInfo.CREATOR_ID, nullable = false)
    private String creatorId;
    @Column(name = Db.UpdateInfo.UPDATE_TIME, nullable = false)
    private int updateTime;
    @Column(name = Db.UpdateInfo.UPDATER_ID, nullable = false)
    private String updaterId;

    public int getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(int creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateInfoEntity{");
        sb.append("creationTime=").append(creationTime);
        sb.append(", creatorId='").append(creatorId).append('\'');
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updaterId=").append(updaterId);
        sb.append('}');
        return sb.toString();
    }
}
