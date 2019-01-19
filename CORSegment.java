package COR;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import Outils.MaFrame;
import Outils.Point;

public class CORSegment extends CORForme {

	public CORSegment(CORForme suivant) {
		super(suivant);
	}

	public void dessine(String s, MaFrame f) {
		// si la chaine s est bien parsé alors on dessine sinon on fait rien

		if (s.matches(
				"^Segment couleur [0-9]+ \\(-?[0-9]+\\.[0-9]+,-?[0-9]+\\.[0-9]+\\);\\(-?[0-9]+\\.[0-9]+,-?[0-9]+\\.[0-9]+\\)$")) {

			// on récupere la chaine en morceau
			String[] chaineEnMorceau = s.split(" ");
			// on recupere la couleur
			String couleur = chaineEnMorceau[2];

			// on recupere les points2D
			String[] tab = chaineEnMorceau[3].split(";");

			Point p1 = new Point(tab[0]);
			Point p2 = new Point(tab[1]);

			// on récupère le graphics2D de notre Frame
			Graphics2D g2D = f.getGraphics2D();

			// on modifie la couleur du pinceau
			g2D.setColor(new Color(Integer.parseInt(couleur)));
			System.out.println(new Color(Integer.parseInt(couleur)));

			// on dessine la ligne
			g2D.draw(new Line2D.Double(p1.getX() + f.getCenter().getX(),
									   p1.getY() + f.getCenter().getY(),
									   p2.getX() + f.getCenter().getX(),
									   p2.getY() + f.getCenter().getY()));

		}

	}

	/**
	 * renvoi la chaine Segment etant donner qu'on est dans le maillon CORSegment
	 */
	public String getDescription() {
		return "Segment";
	}
}