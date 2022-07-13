package banque.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Vincent
 *
 */
/**
 * @author Vincent
 *
 */
@Entity
@Inheritance (strategy =InheritanceType.JOINED )
public class Compte {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** numero */
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String numero;
	/** solde */
	private double solde;
	/** operations */
	@OneToMany (mappedBy = "compte")
	private Set<Operation> operations = new HashSet<>();
	@ManyToMany  
	private Set<Client> clients = new HashSet<>();

	public Compte() {
		
	}

	public Compte(double solde,Client client){
		super();
		
		this.clients.add(client);
		this.solde = solde;
	}

	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Getter
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/** Getter
	 * @return the operations
	 */
	public Set<Operation> getOperations() {
		return operations;
	}

	/** Setter
	 * @param operations the operations to set
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	public void addOperation(Operation operation) {
		this.operations.add(operation);
		
	}

	/** Getter
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/** Setter
	 * @param client the client to add
	 */
	public void setClients(Client client) {
		this.clients.add(client);
		client.setComptes(this);
	}

	/** Getter
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}
	
	
	
}
