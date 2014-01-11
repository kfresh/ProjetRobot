package fr.up10.miage.ProjetRobot;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Station extends Thread {
	private Robot[] filedAttente;
	private Robot robotEncharge;
	private int nbRobots;
	private String text;
	private Fichier f;

	public Station(Fichier fichier) {
		this.filedAttente = new Robot[3];
		nbRobots = 0;
		this.f = fichier;
	}

	@SuppressWarnings("static-access")
	public synchronized void run() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (robotEncharge != null) {
			try {

				System.out.println(robotEncharge.getNom()
						+ " en train de recharger [...]");
				text = robotEncharge.getNom() + " en train de recharger [...]"
						+ "\r\n";
				f.setText(text);
				this.sleep(3000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			robotEncharge.remplirBatterie();
			System.out.println("Recharge du robot " + robotEncharge.getNom()
					+ " terminé");
			text += "Recharge du robot " + robotEncharge.getNom() + " terminé"
					+ "\r\n";
			f.setText(text);

			System.out.println("Le robot " + robotEncharge.getNom()
					+ " s'est rechargé " + robotEncharge.getNbCharge()
					+ " fois ");
			text += "Le robot " + robotEncharge.getNom() + " s'est rechargé "
					+ robotEncharge.getNbCharge() + " fois \r\n";
			f.setText(text);

			nbRobots = nbRobots - 1;
			robotEncharge = filedAttente[0];
			filedAttente[0] = filedAttente[1];
			filedAttente[1] = filedAttente[2];
			filedAttente[2] = null;

			System.out.println(nbRobots + " ROBOTS EN STATION");
			text = nbRobots + " ROBOTS EN STATION " + "\r\n";
			f.setText(text);

			if (robotEncharge == null) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	/* Retour true si la station est pleine, false sinon */

	public boolean stationPleine() {
		if (robotEncharge == null && filedAttente[0] == null
				&& filedAttente[1] == null && filedAttente[2] == null) {
			return true;
		} else {
			return false;
		}
	}

	/* */
	public synchronized void chargerRobot(Robot unRobot) {
		if (nbRobots < 4) {
			if (nbRobots == 0) {

				robotEncharge = unRobot;

				nbRobots++;

			} else {

				filedAttente[nbRobots - 1] = unRobot;
				System.out.println(unRobot.getNom() + " en file d'attente");
				nbRobots++;
				text = unRobot.getNom() + " en file d'attente" + "\r\n";
				f.setText(text);
			}
		} else {
			System.out.println("La Station est pleine");
			text = "La Station est pleine" + "\r\n";
			f.setText(text);
		}

		f.ecrireFichier(f.getText());

	}

	public int getNbRobots() {
		return nbRobots;
	}

}
