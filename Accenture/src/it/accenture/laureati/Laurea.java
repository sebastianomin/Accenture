package it.accenture.laureati;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Laurea {

  private String codiceFiscale;
  private int codiceCdL;
  private int voto;
  private boolean lode;
  private Date dataSeduta;
  private String titoloTesi;
  private ArrayList<Integer> codiciRelatori;

  public Laurea (String cf, int codCdL, int v, boolean l,
                 int anno,int mese,int giorno, String t) {
    codiceFiscale = cf;
    codiceCdL = codCdL;
    voto = v;
    lode = l;
    GregorianCalendar g=new GregorianCalendar(anno,mese-1,giorno);
    dataSeduta = g.getTime();
    titoloTesi = t;
    codiciRelatori = new ArrayList<Integer>();
  }

 
  public String getCodiceFiscale() {
    return codiceFiscale;
  }

  public int getCodiceCdL() {
    return codiceCdL;
  }

  public int getVoto() {
    return voto;
  }

  public boolean getLode() {
    return lode;
  }

  public Date getDataSeduta() {
    return dataSeduta;
  }

  public String getTitoloTesi() {
    return titoloTesi;
  }

  public ArrayList<Integer> getCodiciRelatori() {
    return codiciRelatori;
  }


public void setCodiceFiscale(String codiceFiscale) {
	this.codiceFiscale = codiceFiscale;
}


public void setCodiceCdL(int codiceCdL) {
	this.codiceCdL = codiceCdL;
}


public void setVoto(int voto) {
	this.voto = voto;
}


public void setLode(boolean lode) {
	this.lode = lode;
}


public void setDataSeduta(Date dataSeduta) {
	this.dataSeduta = dataSeduta;
}


public void setTitoloTesi(String titoloTesi) {
	this.titoloTesi = titoloTesi;
}


public void setCodiciRelatori(ArrayList<Integer> codiciRelatori) {
	this.codiciRelatori = codiciRelatori;
}
  
  

}