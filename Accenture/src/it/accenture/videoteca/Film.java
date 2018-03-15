package it.accenture.videoteca;

import java.util.ArrayList;
import java.util.List;

public class Film {

	private String titolo;

	private int anno;

	private Regista regista;

	private List<Attore> listAttori;

	private Categoria categoria;

	public Film(String titolo, int anno) {
		this.titolo = titolo;
		this.anno = anno;
		listAttori = new ArrayList<>();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public Regista getRegista() {
		return regista;
	}

	public void setRegista(Regista regista) {
		this.regista = regista;
	}

	public List<Attore> getListAttori() {
		return listAttori;
	}

	public void setListAttori(List<Attore> listAttori) {
		this.listAttori = listAttori;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return titolo + ", " + anno + ", " + regista + ", " + categoria + ", Attori: " + listAttori;
	}

}
