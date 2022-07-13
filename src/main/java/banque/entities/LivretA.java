package banque.entities;

import javax.persistence.Entity;

/**
 * @author Vincent
 *
 */
@Entity
public class LivretA extends Compte {
	/** taux */
	private double taux;
	public LivretA() {
		
	}
	public LivretA(Integer id, String numero, double solde,double taux) {
		super(id, numero, solde);
		this.taux = taux;
	
	}
	/** Getter
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}
	/** Setter
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
}
