package fr.up10.miage.ProjetRobot;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tache t1 = new Tache1();
		Tache t2 = new Tache2();
		Tache t3 = new Tache3();
		Tache t4 = new Tache4();
		Tache t5 = new Tahce5();
		Robot R1 = new Robot(t1,t3,t4);
		Robot R2 = new Robot(t2,t3,t5);
		Robot R3 = new Robot(t1,t2,t5);
		Robot R4 = new Robot(t3,t4,t5);
		Robot R5 = new Robot(t2,t4,t5);
		
		R1.travaille();
		R2.travaille();
		R3.travaille();
		R4.travaille();
		R5.travaille();
	}

}
