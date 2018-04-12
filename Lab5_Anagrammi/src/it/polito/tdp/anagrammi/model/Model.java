package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;

import dao.AnagrammiDAO;




public class Model {

	private String parola;
	private int step;
	private String parziale ;
	private ArrayList<String> soluzioni;
	private AnagrammiDAO anagrammi;
	
	
	
	
	
	public String getParola() {
		return parola;
	}



	public void setParola(String parola) {
		this.parola = parola;
	}



	public int getStep() {
		return step;
	}



	public void setStep(int step) {
		this.step = step;
	}



	public String getParziale() {
		return parziale;
	}



	public void setParziale(String parziale) {
		this.parziale = parziale;
	}



	public ArrayList<String> getSoluzioni() {
		return soluzioni;
	}



/*	public Model (String parola) {
		this.parola=parola;
		this.step=0;
		this.parziale="";
		this.anagrammi= new AnagrammiDAO();
		
		
		this.soluzioni= new ArrayList<String>();
//		recursive(step,parziale,parola);
		
	}
	*/

	
	public AnagrammiDAO getAnagrammi() {
		return anagrammi;
	}



	public Model() {
		this.step=0;
		this.parziale="";
		this.anagrammi= new AnagrammiDAO();
		this.soluzioni= new ArrayList<String>();
		
	}



	public void recursive(int step,String parziale, String parola) {
	
		
//		condizione di terminazione
//		System.out.println(parziale);
		if(step>=parola.length() ) {
			//soluzione completa da salvare
			this.soluzioni.add(parziale);
			return;
			
			}
			
			
			
		
//			iterazione in cui bisogna scendere di livello creando soluzioni nuove, andando ad applicare un filtro.
		//  il metodo deve essere inoltre in grado di rislaire ai livelli precedenti facendo bactracking.
			for(char c : parola.toCharArray()) {
				if(contaLettere(parziale,c)<contaLettere(parola,c)) {
				
					parziale=parziale+c;
				
					recursive(step+1,parziale,parola);
				
					parziale = parziale.substring(0, parziale.length()-1);
				
				}
				
				
			}
			
			
	}
	


 


		private int contaLettere(String s, char c) {
		  int contatore=0;
		 
			char array[]=s.toCharArray();
			 for(int i=0; i<s.length();i++) {
				 if(array[i]==c) {
					 contatore++;
					 
				 }
			 }	
		 
		 return contatore;
	}
		
	public void cancellaSoluzioniPrecedenti() {
		this.soluzioni.removeAll(soluzioni);
	}
	
}