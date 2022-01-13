package pl.coderslab.charity.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DonationDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Donation donation) {
        entityManager.persist(donation);
    }

    public Donation findById(Long id) {
        return entityManager.find(Donation.class, id);
    }

    public void update(Donation donation) {
        entityManager.merge(donation);
    }

    public void delete(Donation donation) {
        entityManager.remove(entityManager.contains(donation) ?
                donation : entityManager.merge(donation));
    }

    public List<Donation> getAll() {
        return entityManager
                .createQuery("select d from Donation d order by d.id")
                .getResultList();
    }

    public void addDonation(Donation donation, int quantity) {
        donation.setQuantity(donation.getQuantity() + quantity);
    }

    public List<Integer> allWorki(){
        return entityManager.createQuery("select distinct SUM(d.quantity) as suma from Donation d ").getResultList();
    }

    public List<Integer> allDonations(){
        return entityManager.createQuery("select distinct max(d.id) from Donation d").getResultList();
    }
}
