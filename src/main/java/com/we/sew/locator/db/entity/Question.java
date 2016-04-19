package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.*;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.Question.TABLE_NAME)
public class Question extends UpdateInfoEntity {
    @Id
    @Column(name = Db.Question.ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = Db.Question.HEADER, nullable = false, length = 100)
    private String header;

    @Column(name = Db.Question.BODY, nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = Db.Question.TYPE_ID)
    private Type type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "askedQuestion")
    private List<QuestionAnswer> answers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<QuestionAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<QuestionAnswer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (id != question.id) return false;
        if (header != null ? !header.equals(question.header) : question.header != null) return false;
        if (body != null ? !body.equals(question.body) : question.body != null) return false;
        return type != null ? type.equals(question.type) : question.type == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (header != null ? header.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Question{");
        sb.append("id=").append(id);
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
