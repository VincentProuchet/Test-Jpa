package banque.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Vincent
 *
 */
@Entity
public class Banque {
	/** id */
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	/** nom */
	private String nom;
	/** Constructeur
	 * 
	 */
	public Banque() {
		
	}
	/** Constructeur
	 * @param nom
	 */
	public Banque(String nom) {
		this.nom = nom;
	}
	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
