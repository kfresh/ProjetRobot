package fr.up10.miage.ProjetRobot;

public class Tache5 extends Tache {

	public void echanger(int[] t, int i, int j) {

		int a;

		a = t[i];
		t[i] = t[j];
		t[j] = a;
	}

	@Override
	public void tri(int[] t) {
		super.nbTache++;
		for (int i = 0; i < t.length - 1; i++) {
			int min = i;

			for (int j = i + 1; j < t.length; j++)
				if (t[j] < t[min])
					min = j;

			echanger(t, i, min);
		}
	}

}
