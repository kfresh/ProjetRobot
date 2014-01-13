package fr.up10.miage.ProjetRobot.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.up10.miage.ProjetRobot.Fichier;
import fr.up10.miage.ProjetRobot.Robot;
import fr.up10.miage.ProjetRobot.Station;
import fr.up10.miage.ProjetRobot.Tache1;
import fr.up10.miage.ProjetRobot.Tache2;
import fr.up10.miage.ProjetRobot.Tache3;

public class RobotTest {
	protected Robot R1;
	protected Station s1;

	@Before
	public void setUp() throws Exception {
		Tache1 t1 = new Tache1();
		Tache2 t2 = new Tache2();
		Tache3 t3 = new Tache3();
		s1 = new Station(new Fichier());
		R1 = new Robot("S1", s1, t1, t2, t3, new Fichier());

	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * @Test public void testRecharge() { R1.setNbKac(0); R1.tenteRecharge();
	 * s1.start(); assertEquals(18, R1.getNbCharge()); }
	 */

	@Test
	public void testAjoutListeStation() {
		s1.start();
		R1.tenteRecharge();
		assertEquals(1, s1.getNbRobots());
	}

}
