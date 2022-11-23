package Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.function.Function;

public class JPAService {
    private static JPAService instance;
    private final EntityManagerFactory entityManagerFactory;
    public JPAService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("marocship");
    }

    public static JPAService getInstance() {
        return instance == null ? instance = new JPAService() : instance;
    }
    // shutdown the EntityManagerFactory
    public void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
    // method to run a transaction
    public <T> T runInTransaction(Function<EntityManager, T> function) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            T result = function.apply(entityManager);
            entityTransaction.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }
}








