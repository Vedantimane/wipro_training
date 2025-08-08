package hibernate.demo.repo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hibernate.demo.entity.Pan;
import hibernate.demo.util.HibernateUtil;

public class PanRepo {

    // Create new PAN
    public static void createPan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter PAN Holder Name: ");
        String name = scanner.next();
        System.out.print("Enter PAN Number: ");
        String number = scanner.next();

        Pan pan = new Pan(name, number);
        save(pan);
        System.out.println("PAN Created: " + pan);
    }

    // Update PAN
    public static void updatePan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter PAN ID to update: ");
        int id = scanner.nextInt();

        Pan existing = findByPanId(id);
        if (existing == null) {
            System.out.println("PAN not found.");
            return;
        }

        System.out.print("Enter new PAN Holder Name: ");
        String name = scanner.next();
        System.out.print("Enter new PAN Number: ");
        String number = scanner.next();

        existing.setPanholderName(name);
        existing.setPanNumber(number);
        save(existing);
        System.out.println("PAN Updated: " + existing);
    }

    // Save (Insert/Update)
    public static void save(Pan pan) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(pan);
        tx.commit();
    }

    // Delete PAN
    public static void deletePanById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Pan pan = session.find(Pan.class, id);
        if (pan != null) {
            session.remove(pan);
            System.out.println("PAN deleted.");
        } else {
            System.out.println("PAN not found.");
        }
        tx.commit();
    }

    // Find PAN by ID
    public static Pan findByPanId(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Pan pan = session.find(Pan.class, id);
        tx.commit();
        return pan;
    }

    // Find All PAN Records
    public static List<Pan> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Pan> list = session.createQuery("from Pan", Pan.class).list();
        tx.commit();
        return list;
    }

    // Find All PAN Holder Names
    public static List<String> findAllHolderNames() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<String> names = session.createQuery("select panholderName from Pan", String.class).list();
        tx.commit();
        return names;
    }

    // Find PAN by PAN Number
    public static List<Pan> findByPanNumber(String number) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query<Pan> query = session.createQuery("from Pan where panNumber=:pnum", Pan.class);
        query.setParameter("pnum", number);
        List<Pan> list = query.list();
        tx.commit();
        return list;
    }
}
