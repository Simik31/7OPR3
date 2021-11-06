package cz.osu.student.r19584.kip7opr3.seminarka.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Result {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS");

    private final int id;
    private final LocalDateTime timestamp;
    private final Winner winner;

    public Result(int id, LocalDateTime timestamp, Winner winner) {
        this.id = id;
        this.timestamp = timestamp;
        this.winner = winner;
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

    public String toString() {
        return String.format("Game #%x | Played: %s | %s",
                getId(),
                getTimestamp().format(dtf),
                (getWinner() == Winner.DRAW) ? "Draw" : "Winner: " + getWinner()
        );
    }
}
