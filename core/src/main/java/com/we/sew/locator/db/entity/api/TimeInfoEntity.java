package com.we.sew.locator.db.entity.api;

import com.we.sew.locator.db.Db;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @author Vladyslav_Yemelianov
 */
@MappedSuperclass
public abstract class TimeInfoEntity {
    @Column(name = Db.UpdateInfo.CREATE_TIME, nullable = false)
    private long creationTime;

    @Column(name = Db.UpdateInfo.UPDATE_TIME, nullable = false)
    private long updateTime;

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateInfoEntity{");
        sb.append("creationTime=").append(creationTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        return sb.toString();
    }
}
