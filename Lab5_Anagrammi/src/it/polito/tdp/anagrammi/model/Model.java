package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;




public class Model {

	private String parola;
	private int step;
	private String parziale ;
	private ArrayList<String> soluzioni;
	
	
	
	
	
	public ArrayList<String> getSoluzioni() {
		return soluzioni;
	}



	public Model (String parola) {
		this.parola=parola;
		this.step=0;
		this.parziale="";
		
		this.soluzioni= new ArrayList<String>();
		recursive(step,parziale,parola);
		
	}
	

	
	private void recursive(int step,String parziale, String parola) {
	
		
		
//		System.out.println(parziale);
		if(step>=parola.length() ) {
			//soluzione completa da salvare
			this.soluzioni.add(parziale);
			return;
			
			}
			
			
			
		
			
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
		
	
	
}