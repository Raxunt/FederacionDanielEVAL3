package entidades;

import java.util.Scanner;

import validaciones.Validaciones;

public class Tiempo implements Comparable<Tiempo>{

	private int numhoras;
	private int numminutos;
	private int numsegundos;
	private int numcentsegundo;

	public Tiempo(int numhoras, int numminutos, int numsegundos, int numcentsegundo) {
		super();
		this.numhoras = numhoras;
		this.numminutos = numminutos;
		this.numsegundos = numsegundos;
		this.numcentsegundo = numcentsegundo;
	}

	public int getNumhoras() {
		return numhoras;
	}

	public void setNumhoras(int numhoras) {
		this.numhoras = numhoras;
	}

	public int getNumminutos() {
		return numminutos;
	}

	public void setNumminutos(int numminutos) {
		this.numminutos = numminutos;
	}

	public int getNumsegundos() {
		return numsegundos;
	}

	public void setNumsegundos(int numsegundos) {
		this.numsegundos = numsegundos;
	}

	public int getNumcentsegundo() {
		return numcentsegundo;
	}

	public void setNumcentsegundo(int numcentsegundo) {
		this.numcentsegundo = numcentsegundo;
	}

	public static Tiempo nuevoTiempo() {
		Tiempo ret = null;
		Scanner in = new Scanner(System.in);
		int numhoras = 0;
		int numminutos = 0;
		int numsegundos = 0;
		int numcentsegundo = 00;
		boolean valido = false;

		do {
			System.out.println("Introduzca las horas: ");
			numhoras = in.nextInt();
			valido = Validaciones.validarnumhoras(numhoras);
			if (!valido) {
				System.out.println("El valor introducido para las horas no es correcto: ");
				continue;
			} else
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca los minutos: ");
			numminutos = in.nextInt();
			valido = Validaciones.validarnumminutos(numminutos);
			if (!valido) {
				System.out.println("El valor introducido para los minutos no es correcto: ");
				continue;
			} else
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca los segundos: ");
			numsegundos = in.nextInt();
			valido = Validaciones.validarnumsegundos(numsegundos);
			if (!valido) {
				System.out.println("El valor introducido para los segundos no es correcto: ");
				continue;
			} else
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca las centesimas de segundo: ");
			numcentsegundo = in.nextInt();
			valido = Validaciones.validanumcentsegundo(numcentsegundo);
			if (!valido) {
				System.out.println("El valor introducido para las centesimas de segundo no es correcto: ");
				continue;
			} else
				valido = true;
		} while (!valido);
		valido = false;
		ret = new Tiempo(numhoras, numminutos, numsegundos, numcentsegundo);
		return ret;

	}

	@Override
	public String toString() {
		return numhoras + ":" + numminutos + ":" + numsegundos + "," + numcentsegundo;
	}

	@Override
	public int compareTo(Tiempo o) {
		
		return 0;
	}

}
