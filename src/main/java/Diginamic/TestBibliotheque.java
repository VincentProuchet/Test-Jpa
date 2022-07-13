package Diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Diginamic.entities.Client;
import Diginamic.entities.Emprunt;

public class TestBibliotheque {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_bibliotheque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		Emprunt emprunt = em.find(Emprunt.class, 1);
		
		if(emprunt!=null) {
			System.out.println(emprunt);
		}
		
		Client client = em.find(Client.class,2);
		if(client!=null) {
			for (Emprunt e: client.getEmprunts()) {
				System.out.println(e);
			}
		}
	
		
		
		em.close();
		emf.close();
		
		
		
	}

}
