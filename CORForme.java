package COR;

/**
 * Classe : CORForme 
 * @author JHIDRI MOKHTARI
 */
import Outils.MaFrame;

public abstract class CORForme implements CORExpert {

	private CORForme suivant = null;

	/**
	 * Constructeur d'une Liste de CORForme
	 * 
	 * @param suivant
	 */
	public CORForme(CORForme suivant) {
		this.suivant = suivant;
	}

	/**
	 * renvoi le CORForme Suivant
	 * 
	 * @return CORForme le maillon suivant
	 */
	public CORForme getSuivant() {
		return suivant;

	}

	/**
	 * Compare la description du maillon actuel avec le premier mot de la chaine s
	 * 
	 * @param s
	 *            la chaine qui contient la forme a dessiner exemple "Cercle
	 *            ......."
	 * @return true si la description du maillon est identique au premier mot de s
	 */

	public boolean saitDessiner(String s) {
		String premierMotDeLaChaineS = s.split(" ")[0];
		return getDescription().equals(premierMotDeLaChaineS);
	}

	/**
	 * @return : renvoi la description du maillon
	 */

	public abstract String getDescription();

	/**
	 * dessine la forme geometrique sur le la frame
	 * 
	 * @param s
	 *            : la forme a dessiner en format string
	 * @param f
	 *            : la frame sur la quelle on dessine
	 */
	public abstract void dessine(String s, MaFrame f);

	/**
	 * méthode qui switch entre les maillons pour voir le quel peut dessiner
	 */
	public void dessiner(String chaine, MaFrame f) {

		// si le maillon actuel sait dessiner alors on dessine
		if (saitDessiner(chaine)) {
			dessine(chaine, f);
		} else { // sinon on regarde si le maillon suivant n'est pas nul on lui délégue la tache
					// sinon c'est a dire qu'aucun maillon de la liste n'a pu la dessiner
			if (suivant != null) {
				suivant.dessiner(chaine, f);
			}
		}
	}
}