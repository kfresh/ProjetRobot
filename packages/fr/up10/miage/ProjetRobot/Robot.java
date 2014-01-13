package fr.up10.miage.ProjetRobot;

import java.util.ArrayList;

public class Robot extends Thread {

	private int nbKac = 18;
	private String nom;
	private ArrayList<Tache> mesTaches;
	private Station maStation;
	private String text;
	private Fichier f;
	private int nbCharge;

	public Robot(String nom, Station maStation, Tache t, Tache t2, Tache t3,
			Fichier fichier) {

		this.nom = nom;
		this.maStation = maStation;
		this.mesTaches = new ArrayList<Tache>();
		this.mesTaches.add(t);
		this.mesTaches.add(t2);
		this.mesTaches.add(t3);
		this.f = fichier;
	}

	public void run() {

		while (true) {
			for (int i = 0; i <= this.mesTaches.size() - 1; i++) {

				System.out.println(this.nom + " NIVEAU de batterie: " + nbKac
						* 100 / 18 + " %");

				text = this.nom + " NIVEAU de batterie: " + nbKac * 100 / 18
						+ " % \r\n";
				f.setText(text);

				if (nbKac <= 4) {
					System.err
							.println(this.nom
									+ " ATTENTION: Energie critique - Impossible d'effectuer une tache");
				} else {

					System.out.println(this.nom + " debute la tache "
							+ this.mesTaches.get(i).getClass().getSimpleName());

					text = this.nom + " debute la tache "
							+ this.mesTaches.get(i).getClass().getSimpleName()
							+ "\r\n";

					f.setText(text);
					this.mesTaches.get(i)
							.tri(mesTaches.get(i).genererTableau());
					this.nbKac = nbKac - 4;
					System.out.println("la tache "
							+ this.mesTaches.get(i).getClass().getSimpleName()
							+ " est terminé par " + this.nom + " \r\n");

					text = "la tache "
							+ this.mesTaches.get(i).getClass().getSimpleName()
							+ " est terminé par " + this.nom + "\r\n";
					f.setText(text);

					System.out
							.println("la tache "
									+ this.mesTaches.get(i).getClass()
											.getSimpleName()
									+ " a été réalisé "
									+ this.mesTaches.get(i).getNbTache()
									+ " fois \r\n");

					text = "la tache "
							+ this.mesTaches.get(i).getClass().getSimpleName()
							+ " a été réalisé "
							+ this.mesTaches.get(i).getNbTache() + " fois \r\n";
					f.setText(text);
				}

				this.tenteRecharge();

			}
		}
	}

	public synchronized void tenteRecharge() {

		if ((maStation.getNbRobots() == 0) || nbKac <= 4) {
			if (maStation.getNbRobots() < 4) {
				maStation.ajouter(this);
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out
						.println("La station est pleine - Le robot utilise sa recharge de secours \r\n");
				text = "La station est pleine - Le robot utilise sa recharge de secours \r\n";
				f.setText(text);

				this.remplirBatterie();
			}

		} else {

			System.out
					.println(this.nom
							+ " peut entamer une nouvelle tache car le rechargement immédiat est indisponible et quil dispose de suffisament de Kac. \r\n");
			text = this.nom
					+ " peut entamer une nouvelle tache car le rechargement immédiat est indisponible et quil dispose de suffisament de Kac.";
			f.setText(text);
		}

	}

	public String getNom() {
		return this.nom;
	}

	public void remplirBatterie() {
		nbKac = 18;
		this.nbCharge++;

	}

	public int getNbCharge() {
		return this.nbCharge;
	}

	public void setNbKac(int k) {
		nbKac = k;
	}

}
