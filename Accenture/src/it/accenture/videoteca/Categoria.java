package it.accenture.videoteca;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private String nomeCategoria;

	private List<Film> listFilm;

	public Categoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
		listFilm = new ArrayList<>();
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<Film> getListFilm() {
		return listFilm;
	}

	public void setListFilm(List<Film> listFilm) {
		this.listFilm = listFilm;
	}

	@Override
	public String toString() {
		return "Genere: " + nomeCategoria;
	}

}
