package fr.up10.miage.ProjetRobot;


public class Tache1 extends Tache{

	public void run() {
		// TODO Auto-generated method stub
		System.out.println(" d�bute la tache 1");
		tri(genererTableau());
		System.out.println("Tache 1 termin�e");
	}


	@Override
	public int[] genererTableau() {
		super.tab = new int[super.nb];
		for(int i=0;i<super.nb-1;i++){
			int a = (int) Math.random()*10000+1;
			tab[i] = a;
		}
		return tab;
		
		
	}

	public void permuter(int tableau[], int i, int j){
		int temp; 
		temp = tableau[i];
		tableau[i] = tableau[j]; 
		tableau[j] = temp; 
		}
	
	@Override
	public void tri(int[] t) {

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
