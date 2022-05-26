package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	private StudenteDAO studenteDao;

	public Model() {
		this.corsoDao = new CorsoDAO();
		this.studenteDao = new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi()
	{
		return this.corsoDao.getTuttiICorsi();
	}

	public List<Studente> getStudenti()
	{
		return this.studenteDao.getStudenti();
	}
	
	public Studente getStudente(Integer matricola)
	{
		List<Studente> studenti = getStudenti();
		for (Studente s : studenti)
		{
			if (s.matricola.equals(matricola))
			{
				return s;
			}
		}
		return null;
	}
	
	public List<Studente> getStudentiByCorso(Corso corso)
	{
		
		return this.studenteDao.getStudentiByCorso(corso.getCodiceCorso());
	}
	
	public List<Corso> getCorsiByStudente(Studente studente)
	{
		return this.corsoDao.getCorsiByStudente(studente.getMatricola());
	}
}
