package fr.up10.miage.ProjetRobot;


public abstract class Tache implements Runnable {

	
	protected int[] tab;
	protected int nb = 5000;
	public abstract void run();
	public abstract int[] genererTableau();
	public abstract void tri(int[] t);
}	

