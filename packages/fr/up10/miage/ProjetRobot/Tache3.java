package fr.up10.miage.ProjetRobot;

public class Tache3 extends Tache {

	@Override
	public void run() {
		System.out.println("débute la tache 3 ");
		tri(genererTableau());
		System.out.println("Tache 3 terminée");
		
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

	@Override
	public void tri(int[] t) {
		{
		    int cpt;
		    int element;
		 
		    for (int i = 1; i < t.length ; i++)
		    {    
		        element = tab[i];
		        cpt = i - 1;
		        while (cpt >= 0 && tab[cpt] > element)
		        {
		           tab[cpt + 1] = tab[cpt];
		           cpt--;
		        }
		        tab[cpt + 1] = element;
		    }
		}
		
	}

}
