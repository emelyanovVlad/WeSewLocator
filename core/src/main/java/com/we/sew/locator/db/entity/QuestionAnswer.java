package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;
import com.we.sew.locator.db.entity.api.StatusUpdaterInfoEntity;

import javax.persistence.*;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.QuestionAnswer.TABLE_NAME)
public class QuestionAnswer extends StatusUpdaterInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Db.QuestionAnswer.ID, nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = Db.QuestionAnswer.QUESTION_ID, nullable = false)
    private Question askedQuestion;

    @ManyToOne
    @JoinColumn(name = Db.QuestionAnswer.ANSWER_ID, nullable = false)
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = Db.QuestionAnswer.NEXT_QUESTION_ID)
    private Question nextQuestion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getAskedQuestion() {
        return askedQuestion;
    }

    public void setAskedQuestion(Question askedQuestion) {
        this.askedQuestion = askedQuestion;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Question getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(Question nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionAnswer that = (QuestionAnswer) o;

        if (id != that.id) return false;
        if (askedQuestion != null ? !askedQuestion.equals(that.askedQuestion) : that.askedQuestion != null) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        return nextQuestion != null ? nextQuestion.equals(that.nextQuestion) : that.nextQuestion == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (askedQuestion != null ? askedQuestion.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (nextQuestion != null ? nextQuestion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("QuestionAnswer{").append("id=").append(id);
        sb.append(", askedQuestion=").append(askedQuestion);
        sb.append(", answer=").append(answer);
        sb.append(", nextQuestion=").append(nextQuestion);
        sb.append('}');
        return sb.toString();
    }
}
