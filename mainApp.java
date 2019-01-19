package Outils;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import COR.CORCercle;
import COR.CORForme;
import COR.CORFormeComplexe;
import COR.CORPolygone;
import COR.CORSegment;

public class mainApp {
	public static CORForme cor;

	public static void main(String[] args) throws Exception {

		initialisationCOR();

		ServerSocket server;
		server = new ServerSocket(9111);

		System.out.println("Serveur Paint démarré: " + server);

		InetAddress localMachine;
		int localPort;
		ThreadGroup groupe;

		localPort = server.getLocalPort();
		localMachine = InetAddress.getLocalHost();

		System.out.println("Adresse IP du serveur Pain " + localMachine.getHostAddress());
		System.out.println("port du serveur " + localPort);

		groupe = new ThreadGroup("ClientsSockets");

		int connexionId = 0;
		while (true) {
			Socket newClientSocket;

			PaintServer dessineur;

			newClientSocket = server.accept();
			++connexionId;
			System.out.println("Connexion n° :" + connexionId + " réussi");

			dessineur = new PaintServer(newClientSocket, groupe, connexionId);
			dessineur.start();

		}

	}

	/* initialise la chaine de résponsabilité Parseuse de Forme */
	public static void initialisationCOR() {
		cor = new CORSegment(null);
		cor = new CORCercle(cor);
		cor = new CORPolygone(cor);
		cor = new CORFormeComplexe(cor);
	}

}
