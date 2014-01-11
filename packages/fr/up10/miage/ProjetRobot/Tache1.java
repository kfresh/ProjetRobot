package fr.up10.miage.ProjetRobot;


public class Tache1 extends Tache{


	public void permuter(int tableau[], int i, int j){
		int temp; 
		temp = tableau[i];
		tableau[i] = tableau[j]; 
		tableau[j] = temp; 
		}
	
	@Override
	public void tri() {
		super.nbTache++;
		int[] t=genererTableau();
		int fin,i; 
		fin=(t.length -1); 
		boolean permut=true; 
		do { 
			permut=false; 
			for(i=0;i<fin;i++){ 
				if (t[i]>t[i+1]){
					permuter(t,i,i+1); 
					permut=true; 
					} 
				} fin=fin-1; 
				} while((permut==true)&&(fin>=1)); 
		}
	





	


}
