package banque.entities;

import javax.persistence.Entity;

/**
 * @author Vincent
 *
 */
@Entity
public class LivretA extends Compte {
	/** taux */
	private static final String type= "LA";
	private double taux;
	public LivretA() {
		
	}
	public LivretA( double solde,double taux,String numero,Client client) {
		
		super(solde, numero+type ,client );
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
