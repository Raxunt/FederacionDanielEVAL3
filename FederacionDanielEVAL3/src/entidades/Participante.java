package entidades;

import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;

public class Participante {
	protected long id;
	protected int dorsal; // valor entre 001 y 150
	protected char calle;

	// Ejercicio 2. Exam 11.
	protected Tiempo tiempo;
	protected boolean penalizacion = false; // si es true el campo "otros" se vuelve obligatorio
	protected String otros; // no mas de 500 caracteres

	public Participante(long id, int dorsal, char calle) {
		super();
		this.id = id;
		this.dorsal = dorsal;
		this.calle = calle;
	}

	public Participante(long id, int dorsal, char calle, Tiempo tiempo, boolean penalizacion, String otros) {
		super();
		this.id = id;
		this.dorsal = dorsal;
		this.calle = calle;
		this.tiempo = tiempo;
		this.penalizacion = penalizacion;
		this.otros = otros;
	}

	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	public boolean isPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(boolean penalizacion) {
		this.penalizacion = penalizacion;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public Participante() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public char getCalle() {
		return calle;
	}

	public void setCalle(char calle) {
		this.calle = calle;
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", dorsal=" + dorsal + ", calle=" + calle + ", tiempo=" + tiempo
				+ ", penalizacion=" + penalizacion + ", otros=" + otros + "]";
	}

	public static Participante nuevoParticipante() {
		Participante ret = null;
		Scanner in = new Scanner(System.in);
		boolean valido = false;
		long id = 0;
		int dorsal = 0;
		char calle = ' ';
		
		boolean penalizacion = false;
		String otros = "";
		
		String tfnProf = "";
		java.time.LocalTime horaini;
		java.time.LocalTime horafin;
		do {
			System.out.println("Introduzca el identificador del nuevo participante:");
			id = in.nextLong();
			valido = Validaciones.validarId(id);
			if (!valido) {
				System.out.println(
						"El valor introducido para el identificador del nuevo participante no es correcto: ");
				continue;
			} else
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca el dorsal del nuevo participante:");
			dorsal = in.nextInt();
			valido = Validaciones.validarDorsal(dorsal);
			if (!valido) {
				System.out.println(
						"El valor introducido para el dorsal del nuevo participante no es correcto: ");
				continue;
			} else
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca la calle del nuevo participante:");
			calle = in.next().charAt(calle);
			valido = Validaciones.validarCalle(calle);
			if (!valido) {
				System.out.println(
						"El valor introducido para la calle del nuevo participante no es correcto: ");
				continue;
			} else
				valido = true;
		} while (!valido);
		valido = false;
		Tiempo tiempo = Tiempo.nuevoTiempo();
		if (penalizacion = true) {
			do {
				System.out.println("Introduzca el comentario del nuevo participante:");
				otros = in.nextLine();
				valido = Validaciones.validarOtros(otros);
				if (!valido) {
					System.out.println(
							"El valor introducido para el comentario del nuevo participante no es correcto: ");
					continue;
				} else
					valido = true;
			} while (!valido);
			valido = false;
		} else
			valido = true;

		ret = new Participante(id, dorsal, calle, tiempo, penalizacion, otros);
		return ret;
	}
	
}
