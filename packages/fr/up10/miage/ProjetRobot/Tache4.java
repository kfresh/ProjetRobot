package fr.up10.miage.ProjetRobot;

public class Tache4 extends Tache {

	@Override
	public void tri() {
		int taille = 74;
		triDeShell(genererTableau(),taille);
		
	}

	public static void triDeShell(int [] tab,int tailleLogique){
		   int pas = 1;
		   while( pas < tailleLogique/9) {
		      pas = pas*3 + 1; // on fixe le premier pas
		   }
		   while (pas > 0) {  // boucle sur les diff�rents pas         
		      for(int s = 0; s <= pas-1; s++) {  // boucle sur les s�ries
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
