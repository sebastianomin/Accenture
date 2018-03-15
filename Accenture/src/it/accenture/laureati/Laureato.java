package it.accenture.laureati;

import java.util.Date;
import java.util.GregorianCalendar;

public class Laureato {

  private String codiceFiscale;
  private String nome;
  private String cognome;
  private Date dataDiNascita;

  public Laureato (String cf, String n, String c, int anno,int mese,int giorno) {
    codiceFiscale = cf;
    nome = n;
    cognome = c;
    GregorianCalendar g=new GregorianCalendar(anno,mese-1,giorno);
    dataDiNascita = g.getTime();
  }

  public String getCodiceFiscale() {
    return codiceFiscale;
  }

  public String getNome() {
    return nome;
  }

  public String getCognome() {
    return cognome;
  }

  public Date getDataDiNascita() {
    return dataDiNascita;
  }

}