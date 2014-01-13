package fr.up10.miage.ProjetRobot.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.up10.miage.ProjetRobot.Tache1;
import fr.up10.miage.ProjetRobot.Tache2;
import fr.up10.miage.ProjetRobot.Tache3;
import fr.up10.miage.ProjetRobot.Tache4;
import fr.up10.miage.ProjetRobot.Tache5;

public class TacheTest {

	protected Tache1 t1;
	protected Tache2 t2;
	protected Tache3 t3;
	protected Tache4 t4;
	protected Tache5 t5;
	protected int tab[];

	@Before
	public void setUp() throws Exception {
		t1 = new Tache1();
		t2 = new Tache2();
		t3 = new Tache3();
		t4 = new Tache4();
		t5 = new Tache5();
		this.tab = new int[] { 4, 3, 2, 78, 10 };

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenererTableau() {
		assertEquals(50000, t1.genererTableau().length);
	}

	@Test
	public void testTri1() {
		this.tab = new int[] { 4, 3, 2, 78, 10 };
		t1.tri(tab);
		int[] temp = new int[] { 2, 3, 4, 10, 78 };

		// int[] temp = t1.genererTableau();
		assertEquals(temp[0], tab[0]);
		assertEquals(temp[1], tab[1]);
		assertEquals(temp[2], tab[2]);
		assertEquals(temp[3], tab[3]);
		assertEquals(temp[4], tab[4]);
	}

	@Test
	public void testTri2() {
		this.tab = new int[] { 4, 3, 2, 78, 10 };
		t2.tri(tab);
		int[] temp = new int[] { 2, 3, 4, 10, 78 };

		// int[] temp = t1.genererTableau();
		assertEquals(temp[0], tab[0]);
		assertEquals(temp[1], tab[1]);
		assertEquals(temp[2], tab[2]);
		assertEquals(temp[3], tab[3]);
		assertEquals(temp[4], tab[4]);
	}

	@Test
	public void testTri3() {
		this.tab = new int[] { 4, 3, 2, 78, 10 };
		t3.tri(tab);
		int[] temp = new int[] { 2, 3, 4, 10, 78 };

		// int[] temp = t1.genererTableau();
		assertEquals(temp[0], tab[0]);
		assertEquals(temp[1], tab[1]);
		assertEquals(temp[2], tab[2]);
		assertEquals(temp[3], tab[3]);
		assertEquals(temp[4], tab[4]);
	}

	@Test
	public void testTri5() {
		this.tab = new int[] { 4, 3, 2, 78, 10 };
		t5.tri(tab);
		int[] temp = new int[] { 2, 3, 4, 10, 78 };

		// int[] temp = t1.genererTableau();
		assertEquals(temp[0], tab[0]);
		assertEquals(temp[1], tab[1]);
		assertEquals(temp[2], tab[2]);
		assertEquals(temp[3], tab[3]);
		assertEquals(temp[4], tab[4]);
	}

}
