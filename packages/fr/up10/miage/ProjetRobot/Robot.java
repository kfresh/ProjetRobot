package fr.up10.miage.ProjetRobot;

import java.io.*;
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

				System.out.println(this.nom + " debute la tache "
						+ this.mesTaches.get(i).getClass().getSimpleName());

				text = this.nom + " debute la tache "
						+ this.mesTaches.get(i).getClass().getSimpleName()
						+ "\r\n";

				f.setText(text);

				this.mesTaches.get(i).tri();
				this.nbKac = nbKac - 4;
				System.out.println("la tache "
						+ this.mesTaches.get(i).getClass().getSimpleName()
						+ " est terminé par " + this.nom);

				text = "la tache "
						+ this.mesTaches.get(i).getClass().getSimpleName()
						+ " est terminé par " + this.nom + "\r\n";
				f.setText(text);

				System.out.println("la tache "
						+ this.mesTaches.get(i).getClass().getSimpleName()
						+ " a été réalisé "
						+ this.mesTaches.get(i).getNbTache() + " fois");

				text = "la tache "
						+ this.mesTaches.get(i).getClass().getSimpleName()
						+ " a été réalisé "
						+ this.mesTaches.get(i).getNbTache() + " fois \r\n";
				f.setText(text);

				this.tenteRecharge();

			}
		}
	}

	public void tenteRecharge() {
		synchronized (maStation) {

			if ((maStation.getNbRobots() == 0) || nbKac <= 4) {

				maStation.notify();

				maStation.chargerRobot(this);

			} else {

				System.out
						.println(this.nom
								+ " peut entamer une nouvelle tache car le rechargement immédiat est indisponible et quil dispose de suffisament de Kac.");
				text = this.nom
						+ " peut entamer une nouvelle tache car le rechargement immédiat est indisponible et quil dispose de suffisament de Kac.";
				f.setText(text);
			}
		}

	}

	public String getNom() {
		return this.nom;
	}

	public void remplirBatterie() {
		nbKac = 16;
		this.nbCharge++;
		
	}
	
	public int getNbCharge(){
		return this.nbCharge;
	}

}
