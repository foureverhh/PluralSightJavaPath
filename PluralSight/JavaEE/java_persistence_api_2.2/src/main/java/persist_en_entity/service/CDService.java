package persist_en_entity.service;

import persist_en_entity.CDs;

import javax.persistence.EntityManager;

public class CDService {

    // ======================================
    // =             Attributes             =
    // ======================================

    private EntityManager em;

    // ======================================
    // =            Constructors            =
    // ======================================

    public CDService(EntityManager em) {
        this.em = em;
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public CDs createCD(CDs CDs) {
        em.persist(CDs);
       /* for(Musician musician : cd.getMusicians()){
            em.persist(musician);
        }*/
        return CDs;
    }



    public void removeCD(Long id) {
        CDs CDs = em.find(CDs.class, id);
        if (CDs != null)
            em.remove(CDs);
    }

    public void removeCD(CDs CDs){
        CDs CDtoDelete = em.merge(CDs);
        em.remove(CDtoDelete);
    }
    public CDs findCD(Long id) {
        return em.find(CDs.class, id);
    }
}

/*
public class CDService {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    public CD createCD(Long id,String title,String desc, Float cost, Float duration,String genre){
        CD cd = new CD();
        cd.setGenre(genre);
        cd.setTitle(title);
        cd.setId(id);
        cd.setDescription(desc);
        cd.setUnitCost(cost);
        cd.setTotalDurable(duration);
        entityTransaction.begin();
        entityManager.persist(cd);
        entityTransaction.commit();
        return cd;
    }

    public CD updateCD(CD cd, Float cost){
        CD cdUpdated = entityManager.merge(cd);
        cdUpdated.setUnitCost(cdUpdated.getUnitCost() + cost);
        entityTransaction.begin();
        entityManager.persist(cdUpdated);
        entityTransaction.commit();
        return cdUpdated;
    }

    public CD findCD(Long id){
        return entityManager.find(CD.class,id);
    }

    public void removeCD(Long id){
        CD cd = entityManager.find(CD.class,id);
        if(cd != null){
            try {
                entityTransaction.begin();
                entityManager.remove(cd);
                entityTransaction.commit();
            }catch (Exception e){
                e.printStackTrace();
                entityTransaction.rollback();
            }
        }
    }

    public void closeAll(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
*/
