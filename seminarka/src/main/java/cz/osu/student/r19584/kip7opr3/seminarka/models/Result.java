package cz.osu.student.r19584.kip7opr3.seminarka.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "results")
@Entity
public class Result {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer ID;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    @Column(name = "winner", nullable = false, length = 4)
    private String winner;

    @Column(name = "steps", nullable = false, length = 62)
    private String steps;

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}