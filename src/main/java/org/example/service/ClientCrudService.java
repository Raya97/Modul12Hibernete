package org.example.service;

import org.example.entity.Client;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * The ClientCrudService class provides CRUD (Create, Read, Update, Delete) operations
 * for managing `Client` entities in the database.
 *
 * This service uses Hibernate for interacting with the database and managing transactions.
 */
public class ClientCrudService {
    /**
     * Creates a new client record in the database.
     *
     * @param client The `Client` object to be saved.
     *
     * This method initiates a transaction, saves the client entity, and commits the transaction.
     * If an error occurs, the transaction is rolled back to maintain data integrity.
     */
    public void createClient(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(client); // Saves the client entity to the database.
            transaction.commit(); // Commits the transaction if no errors occur.
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rolls back the transaction in case of an error.
            }
            e.printStackTrace(); // Prints the stack trace for debugging purposes.
        }
    }


    /**
     * Retrieves all client records from the database.
     *
     * @return A list of all `Client` entities.
     *
     * This method opens a session and executes a query to fetch all clients.
     */
    public List<Client> getAllClients() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Client", Client.class).list(); // Fetches all clients.
        }
    }


    /**
     * Deletes all client records from the database.
     *
     * This method starts a transaction, deletes all records in the `Client` table, and commits the transaction.
     * If an error occurs, the transaction is rolled back.
     */
    public void deleteAllClients() {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Client").executeUpdate(); // Deletes all client records.
            transaction.commit(); // Commits the transaction if no errors occur.
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rolls back the transaction in case of an error.
            }
            e.printStackTrace(); // Prints the stack trace for debugging purposes.
        }
    }


    /**
     * Updates an existing client record in the database.
     *
     * @param client The `Client` entity with updated values.
     *
     * This method initiates a transaction, updates the client entity, and commits the transaction.
     * If an error occurs, the transaction is rolled back to prevent inconsistent data.
     */
    public void updateClient(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(client); // Updates the client entity in the database.
            transaction.commit(); // Commits the transaction if no errors occur.
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rolls back the transaction in case of an error.
            }
            e.printStackTrace(); // Prints the stack trace for debugging purposes.
        }
    }
}
