package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;


public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);
		asterix.parler("Bonjour à tous ");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
		//scénario 2
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		Gaulois obelix = new Gaulois("Obélix", 25);
		panoramix.booster(obelix,25);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix,6 );
		asterix.parler("Bonjour ");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);

	}

}
