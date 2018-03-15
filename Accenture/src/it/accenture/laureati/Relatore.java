package it.accenture.laureati;

public class Relatore {

  private int codiceRelatore;
  private String nome;
  private String cognome;
  private String facolta;

  public Relatore (int cod, String n, String c, String f) {
	codiceRelatore = cod;
	nome = n;
	cognome = c;
	facolta = f;
  }

  public int getCodiceRelatore() {
    return codiceRelatore;
  }

  public String getNome() {
    return nome;
  }

  public String getCognome() {
    return cognome;
  }

  public String getFacolta() {
    return facolta;
  }
}