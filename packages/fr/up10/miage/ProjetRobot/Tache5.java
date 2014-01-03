package fr.up10.miage.ProjetRobot;

public class Tache5 extends Tache{

	@Override
	public void run() {
		System.out.println("débute la tache 5");
		tri(genererTableau());
		System.out.println("Tache 5 terminée");
		
	}

	@Override
	public int[] genererTableau() {
		super.tab = new int[super.nb];
		for(int i=0;i<super.nb-1;i++){
			int a = (int) Math.random()*100+1;
			tab[i] = a;
		}
		return tab;
		
	}
	public void echanger(int[] t,int i,int j){
		
		int a;
		
		a=t[i];
		t[i]=t[j];
		t[j]=a;
	}

	@Override
	public void tri(int[] t) {
	        
	      for(int i = 0; i < t.length - 1; i++)
	      {
	         int min = i;
	   
	         for(int j = i + 1; j < t.length; j++)
	            if(t[j] < t[min])
	               min = j;
	 
	         echanger(t, i, min);
	      }
	  }
	
	

}
