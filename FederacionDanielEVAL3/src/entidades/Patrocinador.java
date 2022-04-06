package entidades;

import java.time.LocalTime;
import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;

public class Patrocinador {
	private long id;
	private String nombre;
	private String web;
	private double dotacion;

	private Responsable responsable;

	public Patrocinador() {
		super();
	}

	public Patrocinador(long id, String nombre, String web, double dotacion, Responsable responsable) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.web = web;
		this.dotacion = dotacion;
		this.responsable = responsable;
	}

	public Patrocinador(Patrocinador p) {
		super();
		this.id = p.id;
		this.nombre = p.nombre;
		this.web = p.web;
		this.dotacion = p.dotacion;
		this.responsable = p.responsable;
	}

	public Patrocinador(long id, String nombre, String web, double dotacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.web = web;
		this.dotacion = dotacion;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public double getDotacion() {
		return dotacion;
	}

	public void setDotacion(double dotacion) {
		this.dotacion = dotacion;
	}

	// Examen 10 Ejercicio 2
	/***
	 * Función que pregunta al usuario por cada uno de los campos para un nuevo
	 * Patrocinador, los valida y si son correctos devuelve un objeto Patrocinador
	 * completo
	 * 
	 * @return un objeto Patrocinador completo válido o null si hubo algún error
	 */
	public static Patrocinador nuevoPatrocinador() {
		Patrocinador ret = null;
		long id = -1;
		String nombre = null;
		String web = null;
		double dotacion = 0.0D;
		Responsable responsable = null;

		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo Patrocinador:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca el Nombre del Patrocinador:");
			nombre = in.nextLine();
			valido = Validaciones.validarNombrePatrocinador(nombre);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el nombre no es válido.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca el Nombre de la web:");
			web = in.nextLine();
			valido = Validaciones.validarNombreWeb(web);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el nombre de la web no es válido.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca la dotación en € del nuevo Patrocinador:");
			dotacion = Utilidades.leerDouble();
			valido = Validaciones.validarDotacion(dotacion);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el peso no es válido.");
		} while (!valido);

		valido = false;

		System.out.println("Introduzca ahora los datos del Responsable:");
		in = new Scanner(System.in);
		responsable = Responsable.nuevoResponsable();

		ret = new Patrocinador(id, nombre, web, dotacion, responsable);
		return ret;
	}

}
