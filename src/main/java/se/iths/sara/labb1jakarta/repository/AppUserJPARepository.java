package se.iths.sara.labb1jakarta.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import se.iths.sara.labb1jakarta.entity.AppUser;

import java.util.List;

@ApplicationScoped
public class AppUserJPARepository implements AppUserRepository {
    @PersistenceContext(unitName = "neon_database")
    private EntityManager entityManager;

    @Override
    public AppUser save(AppUser appUser) {
        entityManager.persist(appUser);

        return appUser;
    }

    @Override
    public List<AppUser> findAll() {

        return entityManager.createQuery(
                "SELECT m FROM AppUser m", AppUser.class).getResultList();
    }

    @Override
    public AppUser findByUsername(String username) {
        try {
            return entityManager.createQuery(
                            "SELECT a FROM AppUser a WHERE a.username = :username", AppUser.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
