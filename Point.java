package Outils;

/**
 * Classe : Point2D
 * @author JHIDRI MOKHTARI
 */

public class Point {

	private double x;
	private double y;

	/* Constructeur d'un point 2D à partir d'un couple x et y double */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/*
	 * Constructeur d'un point 2D à partir d'une chaine de caractère de la forme
	 * (x,y)
	 */
	public Point(String s) {

		if (s.matches("\\(-?[0-9]+\\.?[0-9]+,-?[0-9]+\\.?[0-9]+\\)$")) {

			s = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
			String[] tab = s.split(",");

			x = Double.parseDouble(tab[0]);

			y = -Double.parseDouble(tab[1]);

		}
	}

	/* renvoi le x du point2D en question */
	public double getX() {
		return x;
	}

	/* renvoi le y du point2D en question */
	public double getY() {
		return y;
	}
}
