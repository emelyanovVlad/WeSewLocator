package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.*;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.BranchQuestion.TABLE_NAME)
public class BranchQuestion extends UpdaterInfoEntity {
    @Id
    @Column(name = Db.BranchQuestion.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = Db.BranchQuestion.BRANCH_ID)
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = Db.BranchQuestion.QUESTION_ID)
    private Question question;

    @Column(name = Db.BranchQuestion.FIRST)
    private boolean first;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchQuestion that = (BranchQuestion) o;

        if (id != that.id) return false;
        if (first != that.first) return false;
        if (branch != null ? !branch.equals(that.branch) : that.branch != null) return false;
        return question != null ? question.equals(that.question) : that.question == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (branch != null ? branch.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (first ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BranchQuestion{");
        sb.append(super.toString());
        sb.append("id=").append(id);
        sb.append(", branch=").append(branch);
        sb.append(", question=").append(question);
        sb.append(", first=").append(first);
        sb.append('}');
        return sb.toString();
    }
}
