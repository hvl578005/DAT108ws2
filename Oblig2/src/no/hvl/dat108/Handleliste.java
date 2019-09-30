package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class Handleliste {
	
	private List <Varer> varer = new ArrayList<>();
	
	public void leggTil(Varer vare) {
		this.varer.add(vare);
	}
	
	public void slettVare (int i) {
		this.varer.remove(i);
	}
	
	public List <Varer> getVarer() {
		return varer;
	}
	
	public int indexOf (Varer vare) {
		return this.varer.indexOf(vare);
	}
	
	

}
