package org.binu.scores;

import javax.persistence.*;

/**
 * Represents a simple message
 */
@Entity
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
}
