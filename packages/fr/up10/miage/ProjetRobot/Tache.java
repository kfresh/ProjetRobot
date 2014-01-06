package fr.up10.miage.ProjetRobot;


public abstract class Tache{

	
	protected int[] tab;
	protected int nb = 50000;	
	
	public int[] genererTableau() {
			tab = new int[nb];
			for(int i=0;i<nb-1;i++){
				int a = (int) Math.random()*10000+1;
				tab[i] = a;
			}
			return tab;
			
		
	}
	public abstract void tri();
}	

