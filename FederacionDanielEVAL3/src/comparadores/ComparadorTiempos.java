package comparadores;

import java.util.Comparator;

import entidades.Tiempo;

public class ComparadorTiempos implements Comparator<Tiempo>{
	@Override
	public int compare(Tiempo o1, Tiempo o2) {
		return o1.compareTo(o2);
		
	}
}
