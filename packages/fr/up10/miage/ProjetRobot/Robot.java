package fr.up10.miage.ProjetRobot;

import java.io.*;
import java.util.ArrayList;

public class Robot extends Thread {

	private int nbKac = 18;
	private String nom;
	private ArrayList<Tache> mesTaches;
	private Station maStation;

	public Robot(String nom, Station maStation, Tache t, Tache t2, Tache t3) { // Constructeur

		this.nom = nom;

		this.maStation = maStation;
		this.mesTaches = new ArrayList<Tache>();
		this.mesTaches.add(t);
		this.mesTaches.add(t2);
		this.mesTaches.add(t3);
	}

	public void run() {

		while (true) {
			for (int i = 0; i <= this.mesTaches.size() - 1; i++) {

				System.out.println(this.nom + " debute la tache "
						+ this.mesTaches.get(i).getClass().getSimpleName());

				this.mesTaches.get(i).tri();
				this.nbKac = nbKac - 4;
				System.out.println(" la tache "
						+ this.mesTaches.get(i).getClass().getSimpleName()
						+ " est termin�e par " + this.nom);

				this.tenteRecharge();
				/*
				 * if(i==2){ i=-1; }
				 */
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
								+ " peut entamer une nouvelle tache car le rechargement imm�diat est indisponible et quil dispose de suffisament de Kac.");
			}
		}

	} /* plus tard */

	public String getNom() {
		return this.nom;
	}

	public void remplirBatterie() {
		nbKac = 16;
	}

	/*
	 * public void ecrireFichier(){ String nomf =
	 * "C:/Users/auangerv/Desktop/robot.txt"; try{ PrintWriter out = new
	 * PrintWriter(new FileWriter(nomf)); out.println(this.nom
	 * +" debute la tache " +
	 * this.mesTaches.get(i).getClass().getSimpleName()+"\r\n");
	 * out.println("la tache " +
	 * this.mesTaches.get(i).getClass().getSimpleName() +" est termin�e par "+
	 * this.nom +"\r\n"); out.close(); this.tenteRecharge(); }catch(Exception
	 * e){ e.printStackTrace(); }
	 * 
	 * }
	 */
}
