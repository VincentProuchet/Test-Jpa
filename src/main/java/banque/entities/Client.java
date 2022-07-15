package banque.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Client {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private  LocalDate dateNaissance;
	@Embedded
	private Adresse adresse = new Adresse();
	@ManyToOne
	private Banque banque;
	@ManyToMany (mappedBy = "clients")
	private Set<Compte> comptes = new HashSet<>();
	
	
	/** Constructeur
	 * 
	 */
	public Client() {
		
	}

	/** Constructeur
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adresse
	 */
	public Client( String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}
	/** Constructeur
	 * @param nom
	 * @param prenom
	 */
	public Client(String nom, String prenom, Banque banque) {
		this.nom = nom;
		this.prenom = prenom;
		this.banque = banque;
		
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

	/** Getter
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/** Getter
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
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

	/** Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/** Getter
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/** Getter
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
	}

	/** Setter
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/** Setter
	 * @param comptes the comptes to set
	 */
	public void setComptes(Compte comptes) {
		this.comptes.add(comptes);
	}
	
	
}
