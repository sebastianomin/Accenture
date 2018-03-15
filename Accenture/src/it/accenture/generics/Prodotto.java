package it.accenture.generics;

public class Prodotto<T> {
	private T prodotto;

	public Prodotto(T prodotto) {
		super();
		this.prodotto = prodotto;
	}

	public T getProdotto() {
		return prodotto;
	}

	public void setProdotto(T prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public String toString() {
		return "" + prodotto + "";
	}

}
