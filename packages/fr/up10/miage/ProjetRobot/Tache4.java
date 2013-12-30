package fr.up10.miage.ProjetRobot;

public class Tache4 extends Tache {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Le robot dÃ©bute la tÃ¢che 4 préééé");
		tri(genererTableau());
		System.out.println("Tache 4 terminÃ©");
		
	}

	@Override
	public int[] genererTableau() {
		// TODO Auto-generated method stub
		super.tab = new int[super.nb];
		for(int i=0;i<super.nb-1;i++){
			int a = (int) Math.random()*100+1;
			tab[i] = a;
		}
		return tab;
	}

	@Override
	public void tri(int[] t) {
		// TODO Auto-generated method stub
		System.out.println("Le robot dÃ©bute Ã  la tÃ¢che 4");
		tri(genererTableau());
		System.out.println("Tache 1 terminÃ©");
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
