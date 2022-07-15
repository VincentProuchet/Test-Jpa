package banque;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.type.LocalDateType;

import banque.entities.AssuranceVie;
import banque.entities.Banque;
import banque.entities.Client;
import banque.entities.Compte;
import banque.entities.LivretA;
import banque.entities.Operation;
import banque.entities.Virement;

public class TestBanque {

	public static void main(String[] args) {
		boolean creation = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_banque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		if (creation) {
			Banque banque1 = new Banque("La banque postale");
			em.persist(banque1);
			Banque banque2 = new Banque("BNP Paribas");
			em.persist(banque2);
			Banque banque3 = new Banque("Crédit mutuel");
			em.persist(banque3);

			Client client1 = new Client("Zemekys", "Robert", banque1);
			em.persist(client1);
			Client client2 = new Client("Morgan", "Stéphanie", banque1);
			em.persist(client2);
			Client client3 = new Client("Eric", "Robert", banque3);
			em.persist(client3);

			Compte compte1 = new Compte(200,"0325482" ,client1);
			em.persist(compte1);
			compte1.setClients(client2);

			Compte compte3 = new LivretA(500, 0.5,"0325489", client3);
			em.persist(compte3);
			Compte compte4 = new AssuranceVie(3000, LocalDate.of(2050, 04, 02), 2,"0325489" ,client3);
			em.persist(compte4);
			Virement virement1 = new Virement(LocalDateTime.now(), 100, "aucun", compte3, compte1);
			em.persist(virement1);
			Operation operation1 = new Operation(LocalDateTime.now(), 2000, "J'aivais envie", compte3);
			em.persist(operation1);
		}

//		Banque banque = new Banque("La banque postale");
//		em.persist(banque);

		et.commit();

		em.close();
		emf.close();
	}

}
