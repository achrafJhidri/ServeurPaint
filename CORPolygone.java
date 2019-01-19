package COR;

import java.awt.Color;

import java.awt.Graphics2D;

import java.awt.geom.Line2D;
import java.util.ArrayList;

import Outils.MaFrame;
import Outils.Point;

public class CORPolygone extends CORForme {

	public CORPolygone(CORForme suivant) {
		super(suivant);
	}

	public void dessine(String s, MaFrame f) {
		// si la chaine s est bien parsé alors on dessine sinon on fait rien
		if (s.matches("^Polygone couleur [0-9]+ \\{(\\(-?[0-9]+\\.[0-9]+,-?[0-9]+\\.[0-9]+\\);*){1,}\\}$")) {

			// on récupère la couleur du polygone
			String couleur = s.split(" ")[2];

			// on récupère les n points qui composent le polygone
			s = s.substring(s.indexOf("{") + 1, s.indexOf("}"));

			String[] tableauDePointString = s.split(";");

			ArrayList<Double> tabX = new ArrayList<Double>();
			ArrayList<Double> tabY = new ArrayList<Double>();

			// on crée des Point pour chaque case du tableau et on récupère les x et les y
			// dans un ArrayList de double
			for (String element : tableauDePointString) {
				Point p = new Point(element);
				tabX.add(p.getX());
				tabY.add(p.getY());
			}

			// on rajoute le premier point a la fin du tableau pour former une boucle sur le
			// Polygone

			tabX.add(tabX.get(0));
			tabY.add(tabY.get(0));

			int taille = tabX.size();

			// on récupère le graphics2D de notre Frame
			Graphics2D g2D = f.getGraphics2D();

			// on modifie la couleur du pinceau
			g2D.setColor(new Color(Integer.parseInt(couleur)));

			// on dessine le polygone en dessinant des Lignes2D entre le point i et le
			// suivant
			for (int i = 0; i < taille - 1; i++) {
				g2D.draw(new Line2D.Double(tabX.get(i) + f.getCenter().getX(),
										   tabY.get(i) + f.getCenter().getY(),
										   tabX.get(i + 1) + f.getCenter().getX(),
										   tabY.get(i + 1) + f.getCenter().getY())
						);
			}

		}

	}

	/**
	 * renvoi la chaine Polygone etant donner qu'on est dans le maillon CORPolygone
	 */

	public String getDescription()

	{
		return "Polygone";

	}
}