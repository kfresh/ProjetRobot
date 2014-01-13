package fr.up10.miage.ProjetRobot;

import java.util.ArrayList;

public class Station extends Thread {
	private ArrayList<Robot> filedAttente;
	private Robot robotEncharge;
	private String text;
	private Fichier f;

	public Station(Fichier fichier) {

		this.filedAttente = new ArrayList<Robot>();
		this.f = fichier;
	}

	@SuppressWarnings("static-access")
	public void run() {
		while (true) {

			try {
				attendre();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while (!estVide()) {
				robotEncharge = filedAttente.get(0);
				synchronized (robotEncharge) {
					text = robotEncharge.getNom()
							+ " en train de recharger [...]" + "\r\n";
					System.out.println(text);
					f.setText(text);
					try {
						this.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					robotEncharge.remplirBatterie();
					System.out.println("Recharge du robot "
							+ robotEncharge.getNom() + " termin�");
					text = "Recharge du robot " + robotEncharge.getNom()
							+ " terminé" + "\r\n";
					f.setText(text);

					System.out.println("Le robot " + robotEncharge.getNom()
							+ " s'est rechargé " + robotEncharge.getNbCharge()
							+ " fois ");
					text = "Le robot " + robotEncharge.getNom()
							+ " s'est rechargé " + robotEncharge.getNbCharge()
							+ " fois \r\n";
					f.setText(text);
					robotEncharge.notify();
				}
				MAJFile();
			}
		}
	}

	public synchronized void attendre() throws InterruptedException {
		while (estVide()) {
			wait();
		}

	}

	public synchronized boolean estVide() {
		return filedAttente.isEmpty();
	}

	public synchronized void MAJFile() {

		for (int i = 0; i < filedAttente.size(); i++) {
			if (i + 1 != filedAttente.size()) {
				filedAttente.set(i, filedAttente.get(i + 1));
			}

		}
		filedAttente.remove(filedAttente.size() - 1);

	}

	public boolean stationPleine() {
		if (filedAttente.size() == 4) {
			return true;
		} else {
			return false;
		}
	}

	public int getNbRobots() {
		return filedAttente.size();
	}

	public synchronized void ajouter(Robot unRobot) {

		filedAttente.add(unRobot);
		System.out.println(unRobot.getNom() + " en Station");
		System.out.println(filedAttente.size()
				+ " ROBOTS en Station ********************");
		text = unRobot.getNom() + " en Station" + "\r\n" + filedAttente.size()
				+ " ROBOTS en Station ******************** \r\n";
		f.setText(text);
		f.ecrireFichier(f.getText());
		this.notify();

	}

}
