package fr.up10.miage.ProjetRobot;

import java.io.*;

public class Fichier {
	private String t;
	
	public Fichier(){
		this.t=" ************** Sauvegarde d'informations **************** \r\n";
		}

	public void ecrireFichier(String t) {
		String nomf = "robot.txt";
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(nomf)));

			out.write(t + "\r\n");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getText() {
		return this.t;
	}

	public void setText(String te) {
		this.t += te;
	}
}
