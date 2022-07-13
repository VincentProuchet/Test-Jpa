package banque.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Virement extends Operation {
	/** beneficiaire */
	private String beneficiaire;
	public Virement() {
		
	}
	public Virement(LocalDateTime date, double montant, String motif, Compte compte,String beneficiaire) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}
	/** Getter
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}
	
	
}
