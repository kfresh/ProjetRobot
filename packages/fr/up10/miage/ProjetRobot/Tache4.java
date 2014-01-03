package fr.up10.miage.ProjetRobot;

public class Tache4 extends Tache {
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub

		tri(genererTableau());

		
	}

	@Override
	public int[] genererTableau() {
		// TODO Auto-generated method stub
		super.tab = new int[super.nb];
		for(int i=0;i<super.nb-1;i++){
			int a = (int) Math.random()*10000+1;
			tab[i] = a;
		}
		return tab;
	}

	@Override
	public void tri(int[] t) {
		int taille = 74;
		triDeShell(genererTableau(),taille);
		
	}

	public static void triDeShell(int [] tab,int tailleLogique){
		   int pas = 1;
		   while( pas < tailleLogique/9) {
		      pas = pas*3 + 1; // on fixe le premier pas
		   }
		   while (pas > 0) {  // boucle sur les différents pas         
		      for(int s = 0; s <= pas-1; s++) {  // boucle sur les séries
		         int positionEltAInserer = s+ pas;  // tri par insertion
		 
		         while(positionEltAInserer < tailleLogique) {
		            int elementAInserer = tab[positionEltAInserer];
		            int posElemCompare = positionEltAInserer - pas;
		 
		            while ((posElemCompare >= 0) && (elementAInserer < tab[posElemCompare])) {
		               tab[posElemCompare + pas] = tab[posElemCompare];
		               posElemCompare -= pas;
		            }
		            tab [posElemCompare + pas] = elementAInserer;
		            positionEltAInserer += pas;
		         }
		      }        
		   pas = pas/3;
		   }
		}

 

}
