package COR;
/**
 * Classe : CORExpert  
 * @author JHIDRI MOKHTARI
 * @see awt.Frame
 */

import Outils.MaFrame;

public interface CORExpert {

	/**
	 * méthode qui parse une chaine et qui dessine le résultat sur une forme
	 * 
	 * @param chaine
	 *            la chaine à parser
	 * @param f
	 *            la fenêtre sur le quel dessiner
	 */
	public void dessiner(String chaine, MaFrame f);
}
