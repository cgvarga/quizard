package org.quizard.services.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="question")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    private String value;

    @OneToMany(fetch = FetchType.EAGER,
               cascade = CascadeType.PERSIST)
    @JoinColumn(name="parent_id")
    private List<Answer> answers = new ArrayList<>();

   /*  public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    } */
    /*
    public void setValue(String value) {
        this.value = value;
    }

    public String getvalue() {
        return value;
    } */

   /*  protected void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }*/

   public void addAnswer(Answer answer) {
       this.answers.add(answer);
   }


}
