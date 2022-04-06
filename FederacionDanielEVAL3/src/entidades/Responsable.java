package entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;

public class Responsable {
	private long id;
	private String telefonoProf;
	private LocalTime horarioIni;
	private LocalTime horarioFin;
	
	private DatosPersona persona;

	public Responsable() {
		super();
	}

	public Responsable(long id, String telefonoProf, LocalTime horarioIni, LocalTime horarioFin) {
		super();
		this.id = id;
		this.telefonoProf = telefonoProf;
		this.horarioIni = horarioIni;
		this.horarioFin = horarioFin;
	}
	

	public Responsable(long id, String telefonoProf, LocalTime horarioIni, LocalTime horarioFin, DatosPersona persona) {
		super();
		this.id = id;
		this.telefonoProf = telefonoProf;
		this.horarioIni = horarioIni;
		this.horarioFin = horarioFin;
		this.persona = persona;
	}
	public Responsable(Responsable r) {
		super();
		this.id = r.id;
		this.telefonoProf = r.telefonoProf;
		this.horarioIni = r.horarioIni;
		this.horarioFin = r.horarioFin;
		this.persona = r.persona;
	}
	

	public Responsable(long id, String telefonoProf, DatosPersona dp) {
		
	}

	public DatosPersona getPersona() {
		return persona;
	}

	public void setPersona(DatosPersona persona) {
		this.persona = persona;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefonoProf() {
		return telefonoProf;
	}

	public void setTelefonoProf(String telefonoProf) {
		this.telefonoProf = telefonoProf;
	}

	public LocalTime getHorarioIni() {
		return horarioIni;
	}

	public void setHorarioIni(LocalTime horarioIni) {
		this.horarioIni = horarioIni;
	}

	public LocalTime getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(LocalTime horarioFin) {
		this.horarioFin = horarioFin;
	}
	
	// Examen 10 Ejercicio 2
		/***
		 * Función que pregunta al usuario por cada uno de los campos para un nuevo
		 * Responsable, los valida y si son correctos devuelve un objeto Responsable completo
		 * 
		 * @return un objeto Responsable completo válido o null si hubo algún error
		 */
		public static Responsable nuevoResponsable() {
			Responsable ret = null;
			long id = -1;
			String telefonoProf = null;
			DatosPersona dp = null;
			Scanner in;
			boolean valido = false;
			do {
				System.out.println("Introduzca el id del nuevo Responsable:");
				in = new Scanner(System.in);
				id = in.nextInt();
				if (id > 0)
					valido = true;
				else
					System.out.println("Valor incorrecto para el identificador.");
			} while (!valido);

			valido = false;
			do {
				System.out.println("Introduzca elnúmero de teléfono del Responsable:");
				telefonoProf = in.nextLine();
				valido = Validaciones.validarTelefono(telefonoProf);
				if (!valido)
					System.out.println("ERROR: El valor introducido para el nombre no es válido.");
			} while (!valido);

			valido = false;
			do {
				System.out.println("Introduzca la hora inicial:");
				LocalTime horarioIni = Utilidades.leerHora();
				
				if (!valido)
					System.out.println("ERROR: El valor introducido para la hora no es válido.");
			} while (!valido);
			
			valido = false;
			do {
				System.out.println("Introduzca la hora inicial:");
				LocalTime horarioFin = Utilidades.leerHora();
				
				if (!valido)
					System.out.println("ERROR: El valor introducido para la hora no es válido.");
			} while (!valido);
			valido = false;
			System.out.println("Introduzca ahora los datos personales:");
			in = new Scanner(System.in);
			dp = DatosPersona.nuevaPersona();

			ret = new Responsable(id, telefonoProf, dp);
			return ret;
		}

		@Override
		public String toString() {
			return  id + " ." +  persona.getNombre() + "(" + persona.getNifnie() + ")"  + "horario de: " + horarioIni.format(DateTimeFormatter.ofPattern("HH/mm"))
					+ "a" + horarioFin.format(DateTimeFormatter.ofPattern("HH/mm")) + "tfno: " + telefonoProf;
		}

	
	
}
