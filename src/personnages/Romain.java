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
	
	public int getForce() { 
		return force;
	}
	
	public void parler(String texte) { 
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : "; 
	}
	
//	public void recevoirCoup(int forceCoup) { 
//		assert force > 0 : "la force est négative";
//		int ancienneForce = force ;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe"); 
//			} else {
//				parler("J'abandonne..."); 
//			}
//		assert ancienneForce > force : "la force a diminué";
//	} 
	
	public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 2:
                System.out.println("Le soldat" + nom + " est déjà bien protégé !");
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
    
    
    public Equipement[] recevoirCoup(int forceCoup) {
        Equipement[] equipementEjecte = null;
        // précondition
        assert force > 0;
        int oldForce = force;
        forceCoup = calculResistanceEquipement(forceCoup);
        force -= forceCoup;
//        if (force > 0) {
//        	parler("Aïe");
//        } else {
//        
//             equipementEjecte = ejecterEquipement();
//             parler("J'abandonne...");
//        }
        if (force == 0) {
            parler("Aïe");
        } else {
            equipementEjecte = ejecterEquipement();
            parler("J'abandonne...");
        }
       // post condition la force a diminuée
       assert force < oldForce;
       return equipementEjecte;
}
    
    private int calculResistanceEquipement(int forceCoup) {
        String texte;
        texte = "Ma force est  de " + this.force + ", et la force ducoup est de " + forceCoup;
        int resistanceEquipement = 0;
        if (nbEquipement != 0) {
             texte += "\nMais heureusement, grace à mon équipement saforce est diminué de ";
             for (int i = 0; i < nbEquipement;i++) {
                  if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
                       resistanceEquipement += 8;
                  } else {
                       System.out.println("Equipement casque");
                       resistanceEquipement += 5;
                  }
             }
             texte += resistanceEquipement + "!";
        }
        parler(texte);
        forceCoup -= resistanceEquipement;
        return forceCoup;
    }
    
    
    private Equipement[] ejecterEquipement() {
    	Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
    	System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
        //TODO
        int nbEquipementEjecte = 0;
        for (int i = 0; i < nbEquipement; i++) {
        	if (equipements[i] == null) {
        	} else {
        		equipementEjecte[nbEquipementEjecte] = equipements[i];
            nbEquipementEjecte++;
            equipements[i] = null;
        	}
        }
        return equipementEjecte;
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