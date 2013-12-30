package fr.up10.miage.ProjetRobot;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bless up");
		Tache1 t1 = new Tache1();
		Tache2 t2 = new Tache2();
		Tache3 t3 = new Tache3();
		Tache4 t4 = new Tache4();
		Tache5 t5 = new Tache5();
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
