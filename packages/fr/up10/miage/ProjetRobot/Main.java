package fr.up10.miage.ProjetRobot;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Station laStation = new Station();
		laStation.start();
		Tache1 t1 = new Tache1();
		Tache2 t2 = new Tache2();
		Tache3 t3 = new Tache3();
		Tache4 t4 = new Tache4();
		Tache5 t5 = new Tache5();
		Robot R1 = new Robot("Robot1", laStation,t4,t3,t5);
		Robot R2 = new Robot("Robot2",laStation,t2,t3,t5);
		Robot R3 = new Robot("Robot3",laStation,t1,t4,t5);
		Robot R4 = new Robot("Robot4",laStation, t3,t1,t5);
		Robot R5 = new Robot("Robot5",laStation, t2,t1,t4);
		
		
		
		R1.start();
		R2.start();
		R3.start();
		R4.start();
		R5.start();
	}

}
