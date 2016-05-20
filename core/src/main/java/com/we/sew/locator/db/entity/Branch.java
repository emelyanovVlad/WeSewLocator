package com.we.sew.locator.db.entity;

import com.we.sew.locator.db.Db;

import javax.persistence.*;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Entity
@Table(name = Db.Branch.TABLE_NAME)
public class Branch extends UpdaterInfoEntity {
    @Id
    @Column(name = Db.Branch.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = Db.Branch.NAME, length = 100, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = Db.Branch.CATEGORY_ID)
    private Category category;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "branch")
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        return category != null ? category.equals(branch.category) : branch.category == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Branch{");
        sb.append(super.toString());
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", category=").append(category);
        sb.append(", questions=").append(questions);
        sb.append('}');
        return sb.toString();
    }
}
