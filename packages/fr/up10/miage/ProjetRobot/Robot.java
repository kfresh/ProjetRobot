package fr.up10.miage.ProjetRobot;


import java.util.ArrayList;


public class Robot extends Thread{
	
	private int nbKac = 16;
	private String nom ;
	private ArrayList<Tache> mesTaches ;

	public Robot(String nom, Tache t ,Tache t2, Tache t3){ // Constructeur
		
		this.nom=nom;
			
		this.mesTaches = new ArrayList<Tache>();
		this.mesTaches.add(t);
		this.mesTaches.add(t2);
		this.mesTaches.add(t3);
	}
	
	public void run(){
		for(int i=0;i<=this.mesTaches.size()-1;i++){
			System.out.println(this.nom );
			this.mesTaches.get(i).run();
			this.tenteRecharge(); 
			if(i==2){
				i=-1;
			}
			
			}
		notifyAll();
	}
		
	public void tenteRecharge(){
		
		
	} /* plus tard */


}
