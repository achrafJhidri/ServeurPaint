package COR;
/**
 * Classe : CORExpert  
 * @author JHIDRI MOKHTARI
 * @see awt.Frame
 */

import Outils.MaFrame;

public interface CORExpert {

	/**
	 * m�thode qui parse une chaine et qui dessine le r�sultat sur une forme
	 * 
	 * @param chaine
	 *            la chaine � parser
	 * @param f
	 *            la fen�tre sur le quel dessiner
	 */
	public void dessiner(String chaine, MaFrame f);
}
