package Outils;

/**
 * Classe : hérite de Frame
 * @author JHIDRI MOKHTARI
 * @see awt.Frame
 */

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MaFrame extends Frame {

	public MaFrame(int noClient, String chaine) throws InterruptedException {
		super("Dessin Client n°" + noClient + chaine);

		/* Récupération des dimensions de mon écran */
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		// int h = (int) dim.getHeight();
		int w = (int) dim.getWidth();

		/* défini les dimension de ma fenêtre */
		setBounds(0, 0, w / 4, w / 4);
		/* on la rend visible */
		setVisible(true);
		/* pour ne pas autorisé le redimensionnement par l'utilisateur */
		setResizable(false);
		/* désactive l'appel automatique a Pain() */
		setIgnoreRepaint(true);
		/*
		 * l'ajout de l'évenement qui permet de fermer la fenêtre lorsqu'on clique sur
		 * le bouton X
		 */
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				dispose();
			}
		});

		/* je génére un nouveau Buffer */
		createBufferStrategy(1);
		Thread.sleep(150);

		/* je trace un repère au centre de ma fenêtre */
		getBufferStrategy().getDrawGraphics().drawLine(getWidth() / 2,0,
													   getWidth() / 2, getHeight());
		getBufferStrategy().getDrawGraphics().drawLine(0, getHeight() / 2,
													   getWidth(), getHeight() / 2);

		
	}

	/* mèthode qui permet d'avoir le centre de ma fenêtre */
	public Point getCenter() {
		return new Point(getWidth() / 2, getHeight() / 2);
	}

	public Graphics2D getGraphics2D() {
		// on recupère le buffer de la frame
		Graphics g = this.getBufferStrategy().getDrawGraphics();
		// on le cast en Graphics2D pour pouvoir dessiner avec des coordonées double
		Graphics2D g2D = (Graphics2D) g;
		return g2D;
	}

}
