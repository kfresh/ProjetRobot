package fr.up10.miage.ProjetRobot;

public class Station extends Thread{
	private Robot[] filedAttente ;
	private Robot robotEncharge;
	private int nbRobots;
	
	public Station(){
		Robot[] FiledAttente = new Robot[3];
		nbRobots = 0;
	}
	
	@SuppressWarnings("static-access")
	public void run(){
		
		if (robotEncharge != null){
			try {
				
				robotEncharge.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Recharge du robot " + robotEncharge.getNom() + " terminée");
			robotEncharge = null;
			
		}
		else{
			if (filedAttente[0] != null){
				
				robotEncharge = filedAttente[0];
				filedAttente[0]=filedAttente[1];
				filedAttente[1]=filedAttente[2];
				filedAttente[2]=null;
				
			}
			else{
				filedAttente[0]=filedAttente[1];
				filedAttente[1]=filedAttente[2];
				filedAttente[2]=null;
			}
		}
	}
	
	public boolean stationPleine(){
		if (robotEncharge == null && filedAttente[0] == null  && filedAttente[1] == null && filedAttente[2]==null){
			return true;
		}
		else{
			return false;
		}
	}
	public void chargerRobot(Robot unRobot){
		if (nbRobots < 4){
			if (nbRobots == 0){
				robotEncharge = unRobot;
				System.out.println(unRobot.getNom()+" en train de recharger");
			}
			else{
				filedAttente[nbRobots-2] = unRobot;
			System.out.println(unRobot.getNom()+" en file d'attente");	
			}
			}
		else{
			System.out.println("La Station est pleine");
				
		}
	}
	
	public int getNbRobots(){
		return nbRobots;
	}
	
}
