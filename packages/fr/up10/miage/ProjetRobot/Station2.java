package fr.up10.miage.ProjetRobot;


public class Station2 extends Thread{
	private Robot2[] filedAttente ; // tableau de 3 case pour la fil d'attente
	private Robot2[] base ; // c'est la case ou le robot se charge
	private int nbRobots;
	
	
	
	public Station2(){
		this.filedAttente = new Robot2[3];
		this.base = new Robot2[1];		
		nbRobots = 0;
	}
	public boolean stationPleine(){
		if (base[0] == null && filedAttente[0] == null  && filedAttente[1] == null && filedAttente[2]==null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void chargement(Robot2 rob){
		
		gererChargement(rob);
		
	}
	
		public synchronized void run(Robot2 rob){
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		while (base[0] != null){
			try {
				System.out.println(rob.getNom()+" en train de recharger [...]");
				base[0].sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Recharge du robot " + rob.getNom() + " terminée");
			
			nbRobots = nbRobots--;
			base[0] = filedAttente[0];
			filedAttente[0]=filedAttente[1];
			filedAttente[1]=filedAttente[2];
			filedAttente[2]=null;
			
			if (base[0] == null){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
		
	
	
	public void gererChargement(Robot2 ro){
		if(stationPleine() == false){
			if(base[0]== null){
				base[0] = ro;
				chargement(ro);
			}
			else{
				for(int i=0;i<filedAttente.length;i++){
					if(filedAttente[i] == null )
						filedAttente[i]=ro;
				}
			}
		}
			else{
				if(ro.getnbKac() >= 16){
					System.out.println(ro.getNom() + " peut entamer une nouvelle tache car le rechargement immédiat est indisponible. Il dispose suffisament de Kac.");
					ro.run();
				}
				else{
					ro.run();
				}
				
			}
			
			
			}
}
