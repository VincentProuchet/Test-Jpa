package Diginamic.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Vincent
 *
 */
@Entity
public class Client {
	/** id */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	/** nom */
	@Column(name="NOM")
	private String nom;
	/** prenom */
	@Column(name="PRENOM")
	private String prenom;
		
	@OneToMany (mappedBy = "client")
	private Set<Emprunt> emprunts;
	/** Constructeur
	 * @param nom
	 * @param prenom
	 */
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	/** Constructeur
	 * 
	 */
	public Client() {
		super();
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
	/** Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/** Getter
	 * @return the emprunts
	 */
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}
	/** Setter
	 * @param emprunts the emprunts to set
	 */
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	public String toString() {
		return new StringBuilder(this.nom)
				.append("   ").append(this.prenom)
				.toString();
	}
	
}
