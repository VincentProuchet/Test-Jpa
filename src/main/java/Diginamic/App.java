package Diginamic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Diginamic.entities.Livre;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_bibliotheque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		// read
		Livre livre = em.find(Livre.class, 5);
			System.out.println(livre.getId() + livre.getTitre());
			if (livre != null) {
				// UPDATE
				livre.setTitre("Du plaisir dans la cuisine");
		}
		// read by titre
		TypedQuery<Livre> query3 = em.createQuery("Select l from Livre l where l.auteur='Emile Zola' ", Livre.class);
		Livre livre3 = query3.getSingleResult();
		if (livre3 != null) 
			System.out.println(livre3);
		
		// Create 
		Livre nouveauLivre = new Livre();
		nouveauLivre.setTitre("Le vieil homme et la guerre");
		nouveauLivre.setAuteur("Jhon Scalzi");
		em.persist(nouveauLivre);
		et.commit();
		// read from titre
		TypedQuery<Livre> query2 = em.createQuery("Select l from Livre l where l.titre='Le vieil homme et la guerre' ",
				Livre.class);
		Livre livre2 = query2.getSingleResult();
		if (livre2 != null) 
			System.out.println(livre2);

		et.begin();
		// Delete 
		TypedQuery<Livre> queryDelete = em
				.createQuery("Select l from Livre l where l.titre='Le vieil homme et la guerre' ", Livre.class);

		for (Livre l : queryDelete.getResultList()) {
			em.remove(l);

		}

		et.commit();

		TypedQuery<Livre> queryAll = em.createQuery("Select l from Livre l", Livre.class);

		for (Livre l : queryAll.getResultList()) {
			System.out.println(l);
		}

		em.close();
		emf.close();

	}
}
