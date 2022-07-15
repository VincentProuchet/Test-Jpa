package banque;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import banque.entities.Compte;

public class TestBanqueTp6 {
	
	public static final String COMPTES_PERSONNEL = "SELECT c FROM Compte c JOIN c.clients cl WHERE cl.nom= :valeur ";
	public static final String COMPTES_WITH_OPERATION_ABOVE = "SELECT c FROM Compte c JOIN c.operations o WHERE o.montant<:valeur";
	public static final String COMPTES_ACTIFS = "SELECT c FROM Compte c WHERE SIZE(c.operations)>0";
	public static final String COMPTE_DE_LA_BANQUE = "SELECT DISTINCT c FROM Compte c JOIN c.clients cl JOIN cl.banque bq WHERE bq.nom LIKE :valeur";
	public static final String MAGIC_SEPARATOR = "_________________________________________________________";
	public static final String VALEUR_SQL = "valeur";
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_banque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		// rechercher tous les comptes d'une persone donnée
		System.out.println(MAGIC_SEPARATOR);
		System.out.println("Comptes de Robert");
		
		TypedQuery<Compte> comptesDe = em.createQuery(COMPTES_PERSONNEL, Compte.class);
		comptesDe.setParameter(VALEUR_SQL, "Zemekys");
		
		for(Compte c: comptesDe.getResultList()) {
			System.out.println(c);
			
			
		}
		System.out.println(MAGIC_SEPARATOR);
		System.out.println("Comptes de Eric");
		comptesDe.setParameter(VALEUR_SQL, "Eric");
		System.out.println(MAGIC_SEPARATOR);
		for(Compte c: comptesDe.getResultList()) {
			System.out.println(c);
			
			
		}
		
		
		// rechercher tous les comptes d'une banque donnée
		String valeurReccherche = "%"+"postale"+"%" ;
		System.out.println(MAGIC_SEPARATOR);
		System.out.println("Comptes d'une banque");
		TypedQuery<Compte> comptesDeBanque = em.createQuery(COMPTE_DE_LA_BANQUE, Compte.class);
		comptesDeBanque.setParameter(VALEUR_SQL, valeurReccherche);
		
		for(Compte c: comptesDeBanque.getResultList()) {
			System.out.println(c);
			
			
		}
		
		// rechercher tous les comptes ayant une opération de plus de 1000€
		System.out.println(MAGIC_SEPARATOR);
		System.out.println("Comptes avec opération de plus de 1000€");
		
		TypedQuery<Compte> operationsAbove = em.createQuery(COMPTES_WITH_OPERATION_ABOVE, Compte.class);
		operationsAbove.setParameter(VALEUR_SQL, 1000d);
		for(Compte c: operationsAbove.getResultList()) {
			System.out.println(c);
			
			
		}
		// rechercher tous les comptes ayant au moins une opération
		
		System.out.println(MAGIC_SEPARATOR);
		System.out.println("Comptes Actifs");
		TypedQuery<Compte> comptesAtifs = em.createQuery(COMPTES_ACTIFS, Compte.class);
		for(Compte c: comptesAtifs.getResultList()) {
			System.out.println(c);
			
			
		}
		
		
		et.commit();

	}

}
