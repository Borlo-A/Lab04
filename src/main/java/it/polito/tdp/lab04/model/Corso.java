package it.polito.tdp.lab04.model;

import java.util.Objects;

public class Corso implements Comparable<Corso>{
	
	String codiceCorso;
	int crediti;
	String nomeCorso;
	int periodo;
	
	public Corso(String codiceCorso, int crediti, String nomeCorso, int periodo) {
		super();
		this.codiceCorso = codiceCorso;
		this.crediti = crediti;
		this.nomeCorso = nomeCorso;
		this.periodo = periodo;
	}

	@Override
	public String toString() {
		return nomeCorso + " (" + codiceCorso + ")\n";
	}

	@Override
	public int compareTo(Corso corso) {
		return this.nomeCorso.compareTo(corso.nomeCorso);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codiceCorso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return Objects.equals(codiceCorso, other.codiceCorso);
	}

	public String getCodiceCorso() {
		return codiceCorso;
	}

	public void setCodiceCorso(String codiceCorso) {
		this.codiceCorso = codiceCorso;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}


}
