package COR;

import java.awt.Color;

import java.awt.Graphics2D;

import java.awt.geom.Ellipse2D;

import Outils.MaFrame;
import Outils.Point;

public class CORCercle extends CORForme {
	public CORCercle(CORForme suivant) {
		super(suivant);
	}

	public void dessine(String s, MaFrame f) {
		// si la chaine s est bien parsé alors on dessine sinon on fait rien
		if (s.matches("^Cercle rayon [0-9]+\\.?[0-9]+ couleur [0-9]+ \\(-?[0-9]+\\.[0-9]+,-?[0-9]+\\.[0-9]+\\)$")) {

			String[] tab = s.split(" ");
			// on recupere le rayon r
			double rayon = Double.parseDouble(tab[2]);
			// on recupere la couleur
			String couleur = tab[4];
			// on recupere le centre
			Point centre = new Point(tab[5]);

			// on récupère le graphics2D de notre Frame
			Graphics2D g2D = f.getGraphics2D();

			// on modifie la couleur du pinceau
			g2D.setColor(new Color(Integer.parseInt(couleur)));
			System.out.println(new Color(Integer.parseInt(couleur)));

			// on dessine le cercle avec un certain décalage pour bien ce centrer sur la
			// fenêtre
			g2D.draw(new Ellipse2D.Double(centre.getX() + f.getCenter().getX() - rayon * 0.5,
										  centre.getY() + f.getCenter().getY() - rayon * 0.5,
										  rayon, rayon)
					);

		}

	}

	/**
	 * renvoi la chaine Cercle etant donner qu'on est dans le maillon CORCercle
	 */

	public String getDescription()

	{
		return "Cercle";

	}
}