package COR;

import Outils.MaFrame;
import Outils.mainApp;

public class CORFormeComplexe extends CORForme {

	public CORFormeComplexe(CORForme suivant) {
		super(suivant);
	}

	public void dessine(String s, MaFrame f) {
		// si la chaine s est bien parsé alors on dessine sinon on fait rien
		if (s.matches("^FormeComplexe couleur [0-9]+ [.*")) {
			// on rècupère les formes qui sont dans la formeCompose
			s = s.substring(s.indexOf("[") + 1, s.lastIndexOf("]"));

			// on la décompose en sous forme
			if (s.indexOf("|") != -1) {
				String[] tab = s.split("\\|");

				for (String forme : tab) {
					mainApp.cor.dessiner(forme, f);
				}

			} else {
				mainApp.cor.dessiner(s, f);
			}
		}
	}

	/**
	 * renvoi la chaine FormeComplexe etant donner qu'on est dans le maillon
	 * CORFormeComplexe
	 */

	public String getDescription() {
		return "FormeComplexe";
	}
};