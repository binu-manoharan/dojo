package org.binu.scores;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Represents a simple message
 */
@Entity
@Component
@Table(name = "playerscores")
public class PlayerScore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "score")
    private int score;

    public PlayerScore() {
    }

    public PlayerScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "PlayerScore [id = " + id + ", name =" + name + ", score =" + score + "]";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
