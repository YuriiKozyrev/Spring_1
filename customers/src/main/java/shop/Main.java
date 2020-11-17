package shop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            //какие товары заказывал клиент
            Customers customer = session.get(Customers.class, 1L);
            System.out.print("Продукты, которые заказывал " + customer.getCustomerName() + ": ");
            for (Products p : customer.getProducts()) {
                System.out.print(p.getProductName() + ", ");
            }

            //какие клиенты купили определенный товар
            Products product = session.get(Products.class, 1L);
            System.out.print("\nКлиенты, которые заказали товар " + product.getProductName() + ": ");
            for (Customers c : product.getCustomers()) {
                System.out.print(c.getCustomerName() + ", ");
            }

            //удаление покупателя
            session.delete(session.get(Customers.class, 3L));
            session.getTransaction().commit();

            //удаление товара
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.delete(session.get(Products.class, 2L));
            session.getTransaction().commit();

        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
