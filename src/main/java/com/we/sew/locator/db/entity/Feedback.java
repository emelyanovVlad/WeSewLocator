package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.*;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.Feedback.TABLE_NAME)
public class Feedback extends UpdateInfoEntity {
    @Id
    @Column(name = Db.Feedback.ID, length = 100)
    private String id;

    @ManyToOne
    @JoinColumn(name = Db.Feedback.ORGANIZATION_ID)
    private Organization organization;

    @Column(name = Db.Feedback.BODY, nullable = false)
    private String body;

    @Column(name = Db.Feedback.RATING)
    private int rating;

    public Feedback() {
    }

    public Feedback(String id, String body, int rating) {
        this.id = id;
        this.body = body;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

        Feedback feedback = (Feedback) o;

        if (rating != feedback.rating) return false;
        if (id != null ? !id.equals(feedback.id) : feedback.id != null) return false;
        return body != null ? body.equals(feedback.body) : feedback.body == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

    @Override
    public java.lang.String toString() {
        final StringBuilder sb = new StringBuilder("Feedback{");
        sb.append("id=").append(id);
        sb.append(", body=").append(body);
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}
