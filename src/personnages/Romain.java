package personnages;

public class Romain { 
	private String nom; 
	private int force;
	
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
	public static void main(String[] args) {

        Romain romain = new Romain("Romain", 8);

        System.out.println(romain);
        romain.prendreParole();
        romain.parler("salut");
        romain.recevoirCoup(3);
        
       //Romain minus = new Romain("Minus", -6);   
	}
}