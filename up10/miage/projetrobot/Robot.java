import java.util.ArrayList;


public class Robot {
	
	private int nbKac = 16;
	private String nom ="R1";
	private ArrayList<Tache> mesTaches ;

	public Robot(Tache t ,Tache t2, Tache t3){ // Constructeur
		this.mesTaches.add(t);
		this.mesTaches.add(t2);
		this.mesTaches.add(t3);
	}
	
	public void synchronized travaille(){
		for(int i=0;i<=this.mesTaches.size();i++){
			this.mesTaches.get(i).init();
			this.tenteRecharge(); 
			if(i==2){
				i=0;
			}
			
			}
		notifyAll();
	}
		
	public void tenteRecharge(){} /* plus tard */


}
