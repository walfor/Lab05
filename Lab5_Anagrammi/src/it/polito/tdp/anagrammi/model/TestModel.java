package it.polito.tdp.anagrammi.model;

public class TestModel {

	public static void main(String[] args) {
		 Model modello= new Model();
		 modello.setParola("ciao");
		 modello.recursive(modello.getStep(), modello.getParziale(), modello.getParola());
		 
		System.out.println(modello.getSoluzioni().toString());
		
	}

}
