package Repository;

import Model.Frete;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FreteRepository {

    private final EntityManager manager;

    public FreteRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Frete create(Frete f) {
        manager.getTransaction().begin();

        manager.persist(f);

        manager.getTransaction().commit();

        return f;
    }

    public Frete read(Integer id){
        Query query = manager.createQuery("SELECT f FROM Frete f WHERE f.id = " + id);
        Frete f = (Frete) query.getSingleResult();

        return f;
    }

}
