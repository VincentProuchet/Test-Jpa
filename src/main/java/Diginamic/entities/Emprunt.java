package Diginamic.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Vincent
 *
 */
@Entity
public class Emprunt {
	/** id */
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="ID")
	private Integer id;
	/** date de debut du prêt */
	@Column (name="DATE_DEBUT")
	private LocalDateTime debut;
	/** date de fin du prêt */
	@Column (name="DATE_FIN")
	private LocalDateTime fin;
	/** delai */
	@Column(name="DELAI")
	private Integer delai;
	
	/** client qui emprunte */
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")	
	private Client client;
	
	
	/** livre de l'emprunt */
	@ManyToMany
	@JoinTable(name="COMPO",
		joinColumns=@JoinColumn(name="ID_EMP",referencedColumnName = "ID"),
		inverseJoinColumns=@JoinColumn(name="ID_LIV",referencedColumnName = "ID")
	)	
	private Set<Livre> livre;

	public Emprunt() {
		super();
	}

	public Emprunt(Integer id, LocalDateTime debut, LocalDateTime fin, Integer delai, Client client) {
		super();
		this.id = id;
		this.debut = debut;
		this.fin = fin;
		this.delai = delai;
		this.client = client;
	}

	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Getter
	 * @return the debut
	 */
	public LocalDateTime getDebut() {
		return debut;
	}

	/** Getter
	 * @return the fin
	 */
	public LocalDateTime getFin() {
		return fin;
	}

	/** Getter
	 * @return the delai
	 */
	public Integer getDelai() {
		return delai;
	}

	/** Getter
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Setter
	 * @param debut the debut to set
	 */
	public void setDebut(LocalDateTime debut) {
		this.debut = debut;
	}

	/** Setter
	 * @param fin the fin to set
	 */
	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	/** Setter
	 * @param delai the delai to set
	 */
	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	/** Setter
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/** Getter
	 * @return the livre
	 */
	public Set<Livre> getLivre() {
		return livre;
	}

	/** Setter
	 * @param livre the livre to set
	 */
	public void setLivre(Set<Livre> livre) {
		this.livre = livre;
	}
	public String toString() {
		StringBuilder out = new StringBuilder()
		.append(this.client.toString())
		.append("\n").append(" Debut :");
		if(this.debut!=null) {
			out.append(this.debut.toString());
		}
		else {
			out.append("//////");
		}
		out.append("  fin :");
		if(this.fin!=null) {
			out.append(this.fin.toString());
		}
		else {
			out.append("//////");
		}
		
		
		
		out.append(" delai : ").append(this.delai)
		.append("\n")
		;
		for(Livre l : this.livre) {
			out.append(l.toString()).append("\n");
		}
		
		
		return out.toString();
	}
}
