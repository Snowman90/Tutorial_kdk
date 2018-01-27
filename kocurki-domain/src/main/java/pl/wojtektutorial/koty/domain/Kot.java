package pl.wojtektutorial.koty.domain;

import java.util.Date;

public class Kot {
	
	private String imie;
	private Date dataUrodzenia;
	private float waga;
	private String imieOpiekuna;
	
	
	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public Date getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public float getWaga() {
		return waga;
	}

	public void setWaga(float waga) {
		this.waga = waga;
	}

	public String getImieOpiekuna() {
		return imieOpiekuna;
	}

	public void setImieOpiekuna(String imieOpiekuna) {
		this.imieOpiekuna = imieOpiekuna;
	}

	
	
	public String przedstawSie() {
		
		return imie + "  " + String.valueOf(dataUrodzenia) + "  " + String.valueOf(waga) + "  " + imieOpiekuna;
	}

}
