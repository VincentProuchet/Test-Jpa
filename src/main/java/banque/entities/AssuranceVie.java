package banque.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
/**
 * @author Vincent
 *
 */
@Entity
public class AssuranceVie extends Compte {
	/** date de Fin */
	private LocalDate dateFin;
	/** taux */
	private double taux;
	
	
	public AssuranceVie() {
		
	}


	public AssuranceVie(Integer id, String numero, double solde,LocalDate fin,double taux ) {
		super(id, numero, solde);
		this.dateFin =fin;
		this.taux = taux;
	}


	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}


	/** Getter
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}


	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}


	/** Setter
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}	
