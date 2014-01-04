package fr.up10.miage.ProjetRobot;

public class Station extends Thread {
	private Robot[] filedAttente;
	private Robot robotEncharge;
	private int nbRobots;

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
				this.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robotEncharge.remplirBatterie();
			System.out.println("Recharge du robot " + robotEncharge.getNom()
					+ " terminée");

			nbRobots = nbRobots - 1;
			robotEncharge = filedAttente[0];
			filedAttente[0] = filedAttente[1];
			filedAttente[1] = filedAttente[2];
			filedAttente[2] = null;

			System.out.println(nbRobots + " ROBOTS EN STATION");

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

}
