package pl.coderslab.charity.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Institution;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class InstitutionDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Institution institution) {
        entityManager.persist(institution);
    }

    public Institution findById(Long id) {
        return entityManager.find(Institution.class, id);
    }

    public void update(Institution institution) {
        entityManager.merge(institution);
    }

    public void delete(Institution institution) {
        entityManager.remove(entityManager.contains(institution) ?
                institution : entityManager.merge(institution));
    }

    public List<Institution> getAll() {
        return entityManager
                .createQuery("select i from Institution i order by i.id")
                .getResultList();
    }
}
