package fr.up10.miage.ProjetRobot;


public class Tache1 extends Tache{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] genererTableau() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tri(int[] t) {

		int fin,ind; 
		fin=N-1; 
		boolean permut=true; 
		do { 
			permut=false; 
			for(ind=0;ind<fin;ind++){ 
				if (tabVal[ind]>tabVal[ind+1]){
					permuter(tabVal,ind,ind+1); 
					permut=true; 
					} 
				} fin=fin-1; 
				} while((permut==true)&&(fin>=1)); 
		}
	public void permuter(int tableau[], int i, int j){
		int temp; 
		temp = tableau;
		tableau = tableau[j]; 
		tableau[j] = temp; 
		}

	Lire plus � propos de bulles sur www.security-helpzone.com


	}


}
