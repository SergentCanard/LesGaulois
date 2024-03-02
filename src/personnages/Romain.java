package personnages;

public class Romain { 
	private String nom; 
	private int force;
	
	private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;
	
	public Romain(String nom, int force) { 
        this.nom = nom;
        assert force > 0 : "La force d'un Romain doit être positive.";
        this.force = force; 
    }
	
	public String getNom() { 
		return nom;
	}
	
	public void parler(String texte) { 
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : "; 
	}
	
	public void recevoirCoup(int forceCoup) { 
		assert force > 0 : "la force est négative";
		int ancienneForce = force ;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe"); 
			} else {
				parler("J'abandonne..."); 
			}
		assert ancienneForce > force : "la force a diminué";
	} 
	
	public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 2:
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + equipement.getNom() + " !");
                } else {
                    ajouterEquipement(equipement);
                }
                break;
            default:
                ajouterEquipement(equipement);
                break;
        }
    }

    private void ajouterEquipement(Equipement equipement) {
        equipements[nbEquipement] = equipement;
        nbEquipement++;
        System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.getNom() + ".");
    }
	
	public static void main(String[] args) {

        Romain romain = new Romain("Romain", 8);

        System.out.println(romain);
        romain.prendreParole();
        romain.parler("salut");
        romain.recevoirCoup(3);
        
       //Romain minus = new Romain("Minus", -6);   
        
        System.out.println("Equipement CASQUE: " + Equipement.CASQUE);
        System.out.println("Equipement BOUCLIER: " + Equipement.BOUCLIER);
        
        Romain minus = new Romain("Minus", 8);
        
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
        
	}
}