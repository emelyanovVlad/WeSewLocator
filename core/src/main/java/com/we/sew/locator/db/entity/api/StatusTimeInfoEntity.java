package com.we.sew.locator.db.entity.api;

import com.we.sew.locator.db.Db;
import com.we.sew.locator.db.entity.EntityStatus;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @author Vladyslav_Yemelianov
 */
@MappedSuperclass
public abstract class StatusTimeInfoEntity extends TimeInfoEntity {

    @ManyToOne
    @JoinColumn(name = Db.Answer.STATUS_ID)
    private EntityStatus status;

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        StatusTimeInfoEntity that = (StatusTimeInfoEntity) o;

        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StatusTimeInfoEntity{");
        sb.append(super.toString());
        sb.append("status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
