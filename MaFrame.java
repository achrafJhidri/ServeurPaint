package Outils;

/**
 * Classe : h�rite de Frame
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
		super("Dessin Client n�" + noClient + chaine);

		/* R�cup�ration des dimensions de mon �cran */
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		// int h = (int) dim.getHeight();
		int w = (int) dim.getWidth();

		/* d�fini les dimension de ma fen�tre */
		setBounds(0, 0, w / 4, w / 4);
		/* on la rend visible */
		setVisible(true);
		/* pour ne pas autoris� le redimensionnement par l'utilisateur */
		setResizable(false);
		/* d�sactive l'appel automatique a Pain() */
		setIgnoreRepaint(true);
		/*
		 * l'ajout de l'�venement qui permet de fermer la fen�tre lorsqu'on clique sur
		 * le bouton X
		 */
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				dispose();
			}
		});

		/* je g�n�re un nouveau Buffer */
		createBufferStrategy(1);
		Thread.sleep(150);

		/* je trace un rep�re au centre de ma fen�tre */
		getBufferStrategy().getDrawGraphics().drawLine(getWidth() / 2,0,
													   getWidth() / 2, getHeight());
		getBufferStrategy().getDrawGraphics().drawLine(0, getHeight() / 2,
													   getWidth(), getHeight() / 2);

		
	}

	/* m�thode qui permet d'avoir le centre de ma fen�tre */
	public Point getCenter() {
		return new Point(getWidth() / 2, getHeight() / 2);
	}

	public Graphics2D getGraphics2D() {
		// on recup�re le buffer de la frame
		Graphics g = this.getBufferStrategy().getDrawGraphics();
		// on le cast en Graphics2D pour pouvoir dessiner avec des coordon�es double
		Graphics2D g2D = (Graphics2D) g;
		return g2D;
	}

}
