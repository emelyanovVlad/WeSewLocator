package com.we.sew.locator.db.entity.feedback;

import com.we.sew.locator.db.Db;
import com.we.sew.locator.db.entity.api.StatusUpdaterInfoEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Vladyslav_Yemelianov
 */
@MappedSuperclass
public abstract class AbstractFeedback extends StatusUpdaterInfoEntity {

    @Column(name = Db.Feedback.BODY, nullable = false)
    private String body;

    @Column(name = Db.Feedback.RATING)
    private int rating;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AbstractFeedback that = (AbstractFeedback) o;

        if (rating != that.rating) return false;
        return body != null ? body.equals(that.body) : that.body == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractFeedback{");
        sb.append("body='").append(body).append('\'');
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}
