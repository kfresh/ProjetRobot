package fr.up10.miage.ProjetRobot;


import java.util.ArrayList;


public class Robot extends Thread{
	
	private int nbKac = 16;
	private String nom ;
	private ArrayList<Tache> mesTaches ;
	private Station maStation;

	public Robot(String nom, Station maStation, Tache t ,Tache t2, Tache t3){ // Constructeur
		
		this.nom=nom;
		
		this.maStation = maStation;
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
		if ((maStation.getNbRobots() == 0) || nbKac <= 4){
			maStation.chargerRobot(this);
		}
		else {
			System.out.println(this.nom + " peut entamer une nouvelle tache.");
		}
		
	} /* plus tard */

	public String getNom(){
		return this.nom;
	}

}
