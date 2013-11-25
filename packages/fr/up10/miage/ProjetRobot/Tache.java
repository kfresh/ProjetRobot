package fr.up10.miage.ProjetRobot;


public abstract class Tache implements Runnable {

	private int[] tab;
	public abstract void run();
	public abstract int[] genererTableau();
	public abstract void tri(int[] t);
}	

