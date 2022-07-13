package banque.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Virement extends Operation {
	/** beneficiaire */
	@ManyToOne 
	private Compte beneficiaire;
	public Virement() {
		
	}
	public Virement(LocalDateTime date, double montant, String motif, Compte compte,Compte beneficiaire) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}
	/** Getter
	 * @return the beneficiaire
	 */
	public Compte getBeneficiaire() {
		return beneficiaire;
	}
	
	
}
