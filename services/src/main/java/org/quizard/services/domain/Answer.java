package org.quizard.services.domain;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
@Table(name="answer")
public class Answer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String value;
    private Boolean correct;

    public Answer(){}

    public Answer(String value, Boolean correct) {
        this.value = value;
        this.correct = correct;
    }

}
