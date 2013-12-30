package fr.up10.miage.ProjetRobot;


import java.util.ArrayList;


public class Robot {
	
	private int nbKac = 16;
	private String nom ;
	private ArrayList<Tache> mesTaches ;

	public Robot(Tache t ,Tache t2, Tache t3){ // Constructeur
		
		this.mesTaches = new ArrayList<Tache>();
		this.mesTaches.add(t);
		this.mesTaches.add(t2);
		this.mesTaches.add(t3);
	}
	
	public synchronized void travaille(){
		for(int i=0;i<=this.mesTaches.size()-1;i++){
			System.out.println(mesTaches.size());
			System.out.println("iii = "+ i );
			this.mesTaches.get(i).run();
			this.tenteRecharge(); 
			if(i==2){
				i=-1;
			}
			
			}
		notifyAll();
	}
		
	public void tenteRecharge(){} /* plus tard */


}
