package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.*;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.Branch.TABLE_NAME)
public class Branch extends UpdateInfoEntity {
    @Id
    @Column(name = Db.Branch.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = Db.Branch.NAME, length = 100, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = Db.Branch.TYPE_ID)
    private Type type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branch")
    private List<BranchQuestion> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<BranchQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<BranchQuestion> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        if (id != branch.id) return false;
        if (name != null ? !name.equals(branch.name) : branch.name != null) return false;
        return type != null ? type.equals(branch.type) : branch.type == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Branch{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append(", questions=").append(questions);
        sb.append('}');
        return sb.toString();
    }
}
