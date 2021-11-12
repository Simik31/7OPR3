package cz.osu.student.r19584.kip7opr3.seminarka.models;

import cz.osu.student.r19584.kip7opr3.seminarka.Winner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Result {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS");

    private final int id;
    private final LocalDateTime timestamp;
    private final Winner winner;
    private final String steps;

    public Result(int id, LocalDateTime timestamp, Winner winner, String steps) {
        this.id = id;
        this.timestamp = timestamp;
        this.winner = winner;
        this.steps = steps;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Winner getWinner() {
        return winner;
    }

    public String getSteps() {
        return steps;
    }

    public String toString() {
        return String.format("Game #%x | Played: %s | %s",
                getId(),
                getTimestamp().format(dtf),
                (getWinner() == Winner.DRAW) ? "Draw" : "Winner: " + getWinner()
        );
    }
}
