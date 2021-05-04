package edu.matc.persistence;

import edu.matc.entity.Entry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntryDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public Entry getById(int id) {
        logger.debug("Searching for Id: {}", id);

        Session session = sessionFactory.openSession();
        Entry entry = session.get(Entry.class, id);
        session.close();
        return entry;
    }

    public void saveOrUpdate(Entry entry) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entry);
        transaction.commit();
        session.close();
    }

    public int insert(Entry entry) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entry);
        transaction.commit();
        session.close();
        return id;
    }

    public void delete(Entry entry) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entry);
        transaction.commit();
        session.close();
    }



    public List<Entry> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for entry with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Entry> query = builder.createQuery( Entry.class );
        Root<Entry> root = query.from( Entry.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Entry> entries = session.createQuery( query ).getResultList();
        session.close();
        return entries;
    }

//    public List<Entry> findByPropertyRange(Object value, Object valueTwo) {
//        Session session = sessionFactory.openSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Entry> query = builder.createQuery(Entry.class);
//        Root<Entry> entry = query.from(Entry.class);
////        query.select(root).where(builder.greaterThan(root.get(propertyName), value));
////        query.select(root).where(builder.between(root.get(propertyName), value, valueTwo));
//        List<Entry> dates = new ArrayList<>();
//        query.select(entry);
//        query.where(builder.between(entry.<Entry>get("date"), value, valueTwo));
//        query.orderBy(builder.desc(entry.get("date")));
//
////        query.where(builder.between(root.get(propertyName), value, valueTwo));
//
//
////        query.select(root).where(builder.equal(root.get(propertyName),value));
//
//        return session.createQuery(query).getResultList();
//    }
}
