package personnages;

public class Gaulois {
	private String nom;
	//private int force;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
    private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) { 
		this.nom = nom;
		this.force = force; 
	}
	
	public String getNom() { 
		return nom;
	}		
	public void parler(String texte) { 
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	//private String prendreParole() {
	//	return "Le gaulois " + nom + " : "; 
	//}

	//public void frapper(Romain romain) {
	//	System.out.println(nom + " envoie un grand coup dans la mâchoire de "+ romain.getNom()); romain.recevoirCoup((force / 3)*effetPotion);
	//}
	
	
	 public void boirePotion(int forcePotion) {
	    effetPotion = forcePotion;
	    System.out.println(nom + " dit : \"Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.\"");
	}
	 
	 
	private String prendreParole() {
        return "Le gaulois " + nom + " : ";
	}
	 
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) {
		               this.trophees[nbTrophees] = trophee[i];
		}
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	

	
	public static void main(String[] args) {

        Gaulois asterix = new Gaulois("Astérix", 8);
        Gaulois obelix = new Gaulois("Obelix", 8);
        
        Romain romain = new Romain("Romain", 8);

        System.out.println(asterix);
        
        asterix.prendreParole();
        asterix.parler("Coucou ");
        asterix.frapper(romain);
        Romain cesar = new Romain("cesar", 8);
        asterix.boirePotion(5);
        asterix.frapper(cesar);
	}
}