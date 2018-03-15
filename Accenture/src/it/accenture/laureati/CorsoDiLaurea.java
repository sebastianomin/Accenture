package it.accenture.laureati;

public class CorsoDiLaurea {

  private int codiceCdL;
  private String denominazione;
  private boolean specialistica;

  public CorsoDiLaurea (int c, String d, boolean s) {
    codiceCdL = c;
    denominazione = d;
    specialistica = s;
  }

  public int getCodiceCdL() {
    return codiceCdL;
  }

  public String getDenominazione() {
    return denominazione;
  }

  public boolean getSpecialistica() {
    return specialistica;
  }

}