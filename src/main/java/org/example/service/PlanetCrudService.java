package org.example.service;



import org.example.entity.Planet;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * The PlanetCrudService class provides CRUD (Create, Read, Update, Delete) operations
 * for managing `Planet` entities in the database.
 *
 * This service uses Hibernate for interacting with the database and managing transactions.
 */
public class PlanetCrudService {
    /**
     * Creates a new planet record in the database.
     *
     * @param planet The `Planet` object to be saved.
     *
     * This method starts a transaction, saves the planet entity, and commits the transaction.
     * If an error occurs, the transaction is rolled back to ensure data consistency.
     */
    public void createPlanet(Planet planet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(planet); // Saves the planet entity to the database.
            transaction.commit(); // Commits the transaction if no errors occur.
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rolls back the transaction in case of an error.
            }
            e.printStackTrace(); // Prints the stack trace for debugging purposes.
        }
    }

    /**
     * Retrieves a planet record from the database by its ID.
     *
     * @param id The ID of the planet to be retrieved.
     * @return The `Planet` entity corresponding to the given ID, or null if not found.
     *
     * This method opens a session and fetches the planet entity by its primary key.
     */
    public Planet getPlanet(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Planet.class, id); // Retrieves the planet by its ID.
        }
    }

    /**
     * Retrieves all planet records from the database.
     *
     * @return A list of all `Planet` entities.
     *
     * This method opens a session and executes a query to fetch all planets.
     */
    public List<Planet> getAllPlanets() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Planet", Planet.class).list(); // Fetches all planets.
        }
    }

    /**
     * Updates an existing planet record in the database.
     *
     * @param planet The `Planet` entity with updated values.
     *
     * This method starts a transaction, updates the planet entity, and commits the transaction.
     * If an error occurs, the transaction is rolled back to prevent inconsistent data.
     */
    public void updatePlanet(Planet planet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(planet); // Updates the planet entity in the database.
            transaction.commit(); // Commits the transaction if no errors occur.
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rolls back the transaction in case of an error.
            }
            e.printStackTrace(); // Prints the stack trace for debugging purposes.
        }
    }

    /**
     * Deletes all planet records from the database.
     *
     * This method starts a transaction, deletes all records in the `Planet` table, and commits the transaction.
     * If an error occurs, the transaction is rolled back.
     */
    public void deleteAllPlanets() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Planet").executeUpdate(); // Deletes all planet records.
            transaction.commit(); // Commits the transaction if no errors occur.
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rolls back the transaction in case of an error.
            }
            e.printStackTrace(); // Prints the stack trace for debugging purposes.
        }
    }

    /**
     * Deletes a specific planet record from the database by its ID.
     *
     * @param ven The ID of the planet to be deleted.
     *
     * This method is currently a placeholder and should be implemented with the logic to delete a specific planet by its ID.
     */
    public void deletePlanet(String ven) {
        // Implementation for deleting a specific planet by its ID should go here.
    }
}
