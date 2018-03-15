package it.accenture.concessionaria;

import java.util.ArrayList;
import java.util.Collections;
public class GestioneVeicoli {

  private ArrayList<Veicolo>veicoli;
  
  public GestioneVeicoli(){
	veicoli=new ArrayList<Veicolo>();  
  }
  
  public void inserisciVeicolo(Veicolo v){
	  veicoli.add(v);
  }
  /*Ordina Veicoli per Cilindrata*/
  
  public ArrayList<Veicolo> OrdinaVeicoliCilindrata(){
	  Collections.sort(veicoli, new ComparaCilindrata());
	  return veicoli;
	}
  
 /*Estrarre le auto con stato "disponibile" ordinate per tipo*/
  
  public ArrayList<Auto> autoDisponibili(){
	  ArrayList<Auto>auto=new ArrayList<Auto>();
	  for(Veicolo v: veicoli)
		  if(v instanceof Auto){
			Auto a=(Auto)v;
			if(a.getStato().equals(Stato.DISPONIBILE))
				auto.add(a);
			}
	  Collections.sort(auto,new ComparaTipoAuto());
	  return auto;
  }
 
  /*Lista di veicoli ordinati per targa*/
  public ArrayList<Veicolo> VeicoliOrdinatiTarga(){
	  Collections.sort(veicoli);
	  return veicoli;
  }
  
  /*Veicolo con la targa più grande*/
  public Veicolo veicoloTargaMax(){
	  return Collections.max(veicoli);
	  
  }
  
  /*Veicolo con cilindrata minima*/
  public Veicolo veicoloCilindrataMin(){
	  return (Veicolo) Collections.min(veicoli, new ComparaCilindrata());
  }
  /*Auto ordinate secondo un ordine decrescente di immatricolazione*/

  public ArrayList <Auto> autoOrdineImmatricolazione(){
	  ArrayList<Auto> auto=new ArrayList<Auto>();
	  for(Veicolo v: veicoli)
		  if (v instanceof Auto){
			  Auto a = (Auto)v;
			  auto.add(a);			  
		  }
	  Collections.sort(auto, new ComparaAnnoImmatricolazione());
	  return auto;
  }
  public ArrayList<Veicolo> veicoliAssicurati(int annoCorrente){
	  ArrayList<Veicolo>veicoliAss=new ArrayList<Veicolo>();
	  for(Veicolo v: veicoli)
		  if(v.isAssicurato(annoCorrente)==true)
			  veicoliAss.add(v);
	  return veicoliAss;
  }
 
 }