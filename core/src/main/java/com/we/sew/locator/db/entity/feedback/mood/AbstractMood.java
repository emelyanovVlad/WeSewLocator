package com.we.sew.locator.db.entity.feedback.mood;

import com.we.sew.locator.db.Db;
import com.we.sew.locator.db.entity.SystemUser;

import javax.persistence.*;

/**
 * @author Vladyslav_Yemelianov
 */
@MappedSuperclass
public abstract class AbstractMood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Db.Mood.ID)
    private int id;

    @ManyToOne
    @JoinColumn(name = Db.Mood.USER_ID)
    private SystemUser user;

    @Column(name = Db.Mood.MOOD)
    private FeedbackMood mood;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }

    public FeedbackMood getMood() {
        return mood;
    }

    public void setMood(FeedbackMood mood) {
        this.mood = mood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractMood that = (AbstractMood) o;

        if (id != that.id) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return mood == that.mood;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (mood != null ? mood.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractMood{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", mood=").append(mood);
        sb.append('}');
        return sb.toString();
    }
}
