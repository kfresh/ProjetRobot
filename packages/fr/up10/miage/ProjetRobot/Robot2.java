package fr.up10.miage.ProjetRobot;

import java.util.ArrayList;



public class Robot2 extends Thread{
	

	private int nbKac = 18;
	private String nom ;
	private ArrayList<Tache> mesTaches ;
	private Station2 maStation2;

	public Robot2(String nom, Station2 maStation, Tache t ,Tache t2, Tache t3){ // Constructeur
		
		this.nom=nom;
		
		this.maStation2 = maStation2;
		this.mesTaches = new ArrayList<Tache>();
		this.mesTaches.add(t);
		this.mesTaches.add(t2);
		this.mesTaches.add(t3);
	}
	
	
	public synchronized void run(){
		for(int i=0;i<=this.mesTaches.size()-1;i++){
			System.out.println(this.nom +" debute la tache " + this.mesTaches.get(i).getClass().getSimpleName());
			this.mesTaches.get(i).run();
			this.nbKac = nbKac - 4 ;
			System.out.println(" la tache " + this.mesTaches.get(i).getClass().getSimpleName() +" est terminée par "+ this.nom);
			this.tenteRecharge(); 
			if(i==2){
				i=-1;
			}
			
			}
		notifyAll();
	}
		
	public synchronized void tenteRecharge(){
			
			maStation2.chargement(this);
			
		}

	public String getNom(){
		return this.nom;
	}
	
	public void remplirBatterie(){
		nbKac = 16;
	}
	public int getnbKac(){
		return this.nbKac;
	}

}

