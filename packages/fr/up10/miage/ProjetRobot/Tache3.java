package fr.up10.miage.ProjetRobot;

public class Tache3 extends Tache {
	@Override
	public void tri(int[] tab) {
		super.nbTache++;

		{
			int cpt;
			int element;

			for (int i = 1; i < tab.length; i++) {
				element = tab[i];
				cpt = i - 1;
				while (cpt >= 0 && tab[cpt] > element) {
					tab[cpt + 1] = tab[cpt];
					cpt--;
				}
				tab[cpt + 1] = element;
			}
		}

	}

}
