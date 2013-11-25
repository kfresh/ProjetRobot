package fr.up10.miage.ProjetRobot;

public class Tache4 extends Tache {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] genererTableau() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tri(int[] t) {
		// TODO Auto-generated method stub
		System.out.println("Le robot débute à la tâche 4");
		tri(genererTableau());
		System.out.println("Tache 1 terminé");
	}

	 private static int partition(int tableau[],int deb,int fin)
     {
     int compt=deb;
     int pivot=tableau[deb];
     
     for(int i=deb+1;i<=fin;i++)
         {
         if (tableau[i]<pivot)
             {
             compt++;
             echanger(tableau,compt,i);
             }
         }
     echanger(tableau,deb,compt);
     return(compt);
     }

 private static void triRapide(int tableau[],int deb,int fin)
     {
     if(deb<fin)
         {
         int positionPivot=partition(tableau,deb,fin);
         triRapide(tableau,deb,positionPivot-1);
         triRapide(tableau,positionPivot+1,fin);
         }
     }
 
 private static void echanger(int tableau[],int i,int j)
 {
 int memoire=tableau[i];
 tableau[i]=tableau[j];
 tableau[j]=memoire;
 }
}
