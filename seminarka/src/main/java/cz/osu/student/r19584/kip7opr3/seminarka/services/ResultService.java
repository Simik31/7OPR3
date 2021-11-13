package cz.osu.student.r19584.kip7opr3.seminarka.services;

import cz.osu.student.r19584.kip7opr3.seminarka.models.Result;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ResultService {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("local");

    public static void addResult(Result result) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(result);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Result> getResults() {
        return emf.createEntityManager()
                .createQuery("SELECT result FROM Result result", Result.class)
                .getResultList();
    }

    public static List<Result> getResultsWithIds(List<Integer> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();

        return emf.createEntityManager()
                .createQuery("SELECT result FROM Result result WHERE result.ID in :ids", Result.class)
                .setParameter("ids", ids)
                .getResultList();
    }

    public static long getNumberOfWinedGames(String winner) {
        if (getNumberOfGames() == 0)
            return 0;

        return emf.createEntityManager()
                .createQuery("SELECT result FROM Result result WHERE result.winner = :winner", Result.class)
                .setParameter("winner", winner)
                .getResultList()
                .size();
    }

    public static long getNumberOfGames() {
        return getResults().size();
    }
}
