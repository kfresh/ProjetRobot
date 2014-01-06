package fr.up10.miage.ProjetRobot;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Station extends Thread {
	private Robot[] filedAttente;
	private Robot robotEncharge;
	private int nbRobots;
	private String text;

	public Station() {
		this.filedAttente = new Robot[3];
		nbRobots = 0;
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
				text=robotEncharge.getNom()+ " en train de recharger [...]";
				this.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robotEncharge.remplirBatterie();
			System.out.println("Recharge du robot " + robotEncharge.getNom()
					+ " termin�e");
			text +="Recharge du robot " + robotEncharge.getNom()+ " termin�e"+"\r\n";
			nbRobots = nbRobots - 1;
			robotEncharge = filedAttente[0];
			filedAttente[0] = filedAttente[1];
			filedAttente[1] = filedAttente[2];
			filedAttente[2] = null;

			System.out.println(nbRobots + " ROBOTS EN STATION");
			text +=nbRobots + " ROBOTS EN STATION ";
			ecrireFichier(text);
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

	public boolean stationPleine() {
		if (robotEncharge == null && filedAttente[0] == null
				&& filedAttente[1] == null && filedAttente[2] == null) {
			return true;
		} else {
			return false;
		}
	}

	public synchronized void chargerRobot(Robot unRobot) {
		if (nbRobots < 4) {
			if (nbRobots == 0) {

				robotEncharge = unRobot;

				nbRobots++;

			} else {

				filedAttente[nbRobots - 1] = unRobot;

				System.out.println(unRobot.getNom() + " en file d'attente");
				nbRobots++;
			}
		} else {
			System.out.println("La Station est pleine");

		}
	}

	public int getNbRobots() {
		return nbRobots;
	}

	public void ecrireFichier(String t){
		 String nomf = "C:/Users/auangerv/Desktop/robot.txt";
		 try{
			 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nomf)));
			  /*out.println(this.nom +" debute la tache " + this.mesTaches.get(i).getClass().getSimpleName()+"\r\n");
			  out.println("la tache " + this.mesTaches.get(i).getClass().getSimpleName() +" est termin�e par "+ this.nom +"\r\n");
			  out.close();*/
			 
			 out.write(t+"\r\n");
			 out.flush();
			 out.close();
		 }catch(Exception e){
			 e.printStackTrace();
			}

}
	
}
