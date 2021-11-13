package cz.osu.student.r19584.kip7opr3.seminarka.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "results", indexes = {
        @Index(name = "resultID", columnList = "resultID", unique = true)
})
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "resultID", nullable = false)
    private Integer resultID;

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

    public Integer getResultID() {
        return resultID;
    }

    public void setResultID(Integer resultID) {
        this.resultID = resultID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}