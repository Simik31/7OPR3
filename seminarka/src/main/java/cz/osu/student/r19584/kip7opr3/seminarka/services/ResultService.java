package cz.osu.student.r19584.kip7opr3.seminarka.services;

import cz.osu.student.r19584.kip7opr3.seminarka.models.Result;
import cz.osu.student.r19584.kip7opr3.seminarka.models.Winner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultService {
    private static final List<Result> results = new ArrayList<>();

    public static void addResult(Result result) {
        results.add(result);
    }

    public static List<Result> getResults() {
        return new ArrayList<>(results);
    }

    public static List<Result> getResultsWithIds(List<Integer> ids) {
        return results.stream().filter(result -> ids.contains(result.getId())).collect(Collectors.toList());
    }

    public static long getNumberOfWinedGames(Winner winner) {
        return results.stream().filter(result -> result.getWinner() == winner).count();
    }

    public static long getNumberOfGames() {
        return results.size();
    }
}
