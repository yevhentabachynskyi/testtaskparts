package app.parts.dao;

import app.parts.model.Part;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class PartDaoImp implements PartDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Part> allParts(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Part").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }
    @Override
    public int partsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Part", Number.class).getSingleResult().intValue();
    }
    @Override
    public void add(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(part);
    }

    @Override
    public void delete(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(part);
    }

    @Override
    public void edit(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.update(part);
    }

    @Override
    public Part getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Part.class, id);
    }
//    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);
//    private static Map<Integer, Part> parts = new HashMap<>();
//
//   /* static {
//        Part part1 = new Part();
//        part1.setId(AUTO_ID.getAndIncrement());
//        part1.setName("Шлейф");
//        part1.setNecessity(false);
//        part1.setNumber(10);
//
//
//        Part part2 = new Part();
//        part2.setId(AUTO_ID.getAndIncrement());
//        part2.setName("Блок");
//        part2.setNecessity(false);
//        part2.setNumber(8);
//
//        parts.put(part1.getId(),part1);
//        parts.put(part2.getId(),part2);
//    }*/
//    @Override
//    public List<Part> allParts() {
//        return new ArrayList<>(parts.values());
//    }
//
//    @Override
//    public void add(Part part) {
//        part.setId(AUTO_ID.getAndIncrement());
//        parts.put(part.getId(), part);
//    }
//
//    @Override
//    public void delete(Part part) {
//        parts.remove(part.getId());
//    }
//
//    @Override
//    public void edit(Part part) {
//        parts.put(part.getId(), part);
//    }
//
//    @Override
//    public Part getById(int id) {
//        return parts.get(id);
//    }

}
