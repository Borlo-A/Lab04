package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public List<Studente> getStudenti(){
		
		final String sql = "SELECT * "
				+ "FROM studente ";
		
		List<Studente> studenti = new LinkedList<Studente>();
		
		try 
		{
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) 
			{
				Integer matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String CDS = rs.getString("CDS");
				
				studenti.add(new Studente(matricola, cognome, nome, CDS));
			}
			conn.close();
			return studenti;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Errore StudenteDAO", e);
		}
		
	}
	
	public List<Studente> getStudentiByCorso(String corso)
	{
		final String sql = "SELECT s.matricola, s.nome, s.cognome, s.CDS "
				+ "FROM  studente s, iscrizione i "
				+ "WHERE s.matricola = i.matricola AND i.codins = ?";

		List<Studente> studenti = new LinkedList<Studente>();
		
		try 
		{
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) 
			{
				Integer matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String CDS = rs.getString("CDS");
				
				studenti.add(new Studente(matricola, cognome, nome, CDS));
			}
			conn.close();
			return studenti;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Errore StudenteDAO2", e);
		}
		
	}
}

