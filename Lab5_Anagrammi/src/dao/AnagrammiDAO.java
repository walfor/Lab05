package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;


	public class AnagrammiDAO {
		private Connection conn;
		
//	public List<String> getTuttiAnagrammi() {
//			
//			
//			List <String> listaParole = new ArrayList<String>();
//	
//			final String sql = "select nome from parola";
//			
//			try {
//				
//				Connection conn = ConnectDB.getConnection();
//				PreparedStatement st = conn.prepareStatement(sql);
//				
//				ResultSet rs = st.executeQuery();
//	
//				while (rs.next()) {
//					
//					listaParole.add(rs.getString("nome"));
//					
//			
//			
//				}
//			}catch (SQLException e) {
//				// e.printStackTrace();
//				throw new RuntimeException("Errore Db");
//			}
//			return listaParole;
//		}


		public AnagrammiDAO(){
			 conn = ConnectDB.getConnection();
			
		}
	
	public boolean isCorrect(String anagramma) {
		
	
		final String sql = "select nome from parola " + 
				"where nome = ? ";
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
	
			while (rs.next()) {
				
				if(rs.getString("nome").equals(anagramma)) {
					return true;
				}
					
				
		
		
			}
			
			
		}catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		return false;
	
	}
	
	
	}

