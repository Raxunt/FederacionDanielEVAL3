package gui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import dao.AtletaDAO;
import dao.MetalDAO;
import dao.PatrocinadorDAO;
import dao.PruebaDAO;
import entidades.Atleta;
import entidades.Documentacion;
import entidades.Lugar;
import entidades.Metal;
import entidades.Patrocinador;
import entidades.Prueba;
import entidades.Tiempo;
import utils.ConexBD;
import validaciones.Validaciones;

import javax.swing.JCheckBox;

public class CerrarPrueba extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Prueba nueva = null;
	protected static final Atleta nuevo = null;
	protected static final Tiempo nuevoT = null;
	protected static final Metal nuevoM = null;
	protected static final JComboBox comboBoxPlata = null;
	protected static final JComboBox comboBoxBronce = null;
	protected static final AbstractButton chckbxNewCheckBox = null;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private final ButtonGroup buttonGroupTipo = new ButtonGroup();
	private JTextField textField;
	protected JComboBox comboBoxOro;
	protected JComponent lblEstablecer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int idprueba = 1;
					CerrarPrueba frame = new CerrarPrueba(idprueba);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CerrarPrueba(int idprueba) {
		PruebaDAO pDAO = new PruebaDAO(ConexBD.getCon());
		Prueba prueba = pDAO.buscarPorID(idprueba);
		if(prueba!=null) {
			setTitle("Cerrar Prueba" + idprueba);
		}
		else
		setTitle("Cerrar Prueba INDETERMINADA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Datos de la prueba", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 21, 424, 199);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblIdPrueba = new JLabel("IdPrueba:");
		lblIdPrueba.setBounds(22, 21, 77, 14);
		panel_1.add(lblIdPrueba);

		textField = new JTextField(""+prueba.getId());
		textField.setBounds(86, 14, 86, 20);
		panel_1.add(textField);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 48, 77, 14);
		panel_1.add(lblNombre);

		textFieldNombre = new JTextField(prueba.getNombre());
		textFieldNombre.setBounds(86, 41, 261, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(22, 73, 46, 14);
		panel_1.add(lblFecha);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(200, 73, 46, 14);
		panel_1.add(lblLugar);

		JComboBox comboBoxLugar = new JComboBox();
		comboBoxLugar.setBounds(245, 69, 169, 22);
		panel_1.add(comboBoxLugar);
		comboBoxLugar.setEnabled(false);
		comboBoxLugar.setModel(new DefaultComboBoxModel(Lugar.values()));

		JPanel panel = new JPanel();
		panel.setBounds(22, 98, 210, 52);
		panel_1.add(panel);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Tipo de Prueba:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JRadioButton rbIndividual = new JRadioButton("Individual");
	
		rbIndividual.setEnabled(false);
		buttonGroupTipo.add(rbIndividual);
		panel.add(rbIndividual);

		JRadioButton rbEquipos = new JRadioButton("Por Equipos");
		rbEquipos.setEnabled(false);
		buttonGroupTipo.add(rbEquipos);
		panel.add(rbEquipos);
		if(prueba.isIndividual()) 
			rbIndividual.setSelected(true);
		else
			rbEquipos.setSelected(true);

		JLabel lblPatrocinador = new JLabel("Patrocinador:");
		lblPatrocinador.setBounds(22, 161, 87, 14);
		panel_1.add(lblPatrocinador);

		JLabel lblprimerpuesto = new JLabel("Primer puesto *:");
		lblprimerpuesto.setBounds(27, 231, 109, 14);
		contentPane.add(lblprimerpuesto);

		JLabel lblsegundopuesto = new JLabel("Segundo puesto *:");
		lblsegundopuesto.setBounds(27, 343, 109, 14);
		contentPane.add(lblsegundopuesto);

		JLabel lbltercerpuesto = new JLabel("Tercer puesto *:");
		lbltercerpuesto.setBounds(27, 437, 109, 14);
		contentPane.add(lbltercerpuesto);

		DefaultComboBoxModel<Atleta> atletasModel = new DefaultComboBoxModel<Atleta>();
		AtletaDAO aDAO = new AtletaDAO(ConexBD.getCon());
		ArrayList<Atleta> atletassList = (ArrayList<Atleta>) aDAO.buscarTodos();
		/// Pero el modelo de comboBox básico requiere Strings
		String[] atletasStr = new String[atletassList.size()];
		for (int i = 0; i < atletassList.size(); i++)
			atletasStr[i] = atletassList.get(i).getPersona().data();



		JComboBox<Atleta> comboBoxPuesto1 = new JComboBox<Atleta>();
		comboBoxPuesto1.setModel(new DefaultComboBoxModel(atletasStr));		
		lblprimerpuesto.setLabelFor(comboBoxPuesto1);
		comboBoxPuesto1.setBounds(139, 231, 287, 22);
		contentPane.add(comboBoxPuesto1);

		JComboBox<Atleta> comboBoxPuesto2 = new JComboBox<Atleta>();
		comboBoxPuesto2.setModel(new DefaultComboBoxModel(atletasStr));
		lblsegundopuesto.setLabelFor(comboBoxPuesto2);
		comboBoxPuesto2.setBounds(139, 339, 287, 22);
		contentPane.add(comboBoxPuesto2);

		JComboBox<Atleta> comboBoxPuesto3 = new JComboBox<Atleta>();
		comboBoxPuesto3.setModel(new DefaultComboBoxModel(atletasStr));
		lbltercerpuesto.setLabelFor(comboBoxPuesto3);
		comboBoxPuesto3.setBounds(139, 433, 287, 22);
		contentPane.add(comboBoxPuesto3);

		LocalDate hoyMas1MesLD = LocalDate.now().plusMonths(1);
		java.util.Date hoyMas1Mes = new Date(hoyMas1MesLD.getYear() - 1900, hoyMas1MesLD.getMonthValue() - 1,
				hoyMas1MesLD.getDayOfMonth());

		/// Las siguientes lineas seria lo deseable: trabajar diectamente con objetos en
		/// el model del comboBox
		DefaultComboBoxModel<Patrocinador> patrocinadoresModel = new DefaultComboBoxModel<Patrocinador>();
		JComboBox<Patrocinador> comboBoxPatrocinador = new JComboBox<Patrocinador>(patrocinadoresModel);
		PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
		ArrayList<Patrocinador> patrocinadoresList = (ArrayList<Patrocinador>) patDAO.buscarTodos();
		for (Patrocinador pat : patrocinadoresList)
			comboBoxPatrocinador.addItem(pat);

		/// Pero el modelo de comboBox básico requiere Strings
		String[] patrocinadoresStr = new String[patrocinadoresList.size()];
		for (int i = 0; i < patrocinadoresList.size(); i++)
			patrocinadoresStr[i] = patrocinadoresList.get(i).mostrarBasico();
		comboBoxPatrocinador.setModel(new DefaultComboBoxModel(patrocinadoresStr));
		comboBoxPatrocinador.setBounds(96, 157, 261, 22);
		panel_1.add(comboBoxPatrocinador);
		comboBoxPatrocinador.setEnabled(false);

		JSpinner spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(86, 69, 86, 20);
		panel_1.add(spinnerFecha);
		spinnerFecha.setEnabled(false);
		spinnerFecha.setModel(new SpinnerDateModel(hoyMas1Mes, hoyMas1Mes, null, Calendar.DAY_OF_YEAR));

		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tiempo nuevoT = new Tiempo();
				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";
				/// Tomar cada campo y validarlo. Si alguno no es correcto, avisar al usuario
			String nombre = textFieldNombre.getText();
				valido = Validaciones.validarNombrePrueba(nombre);
				if (!valido) {
					errores += "El nombre de la prueba no es válido (5-150 caracteres).\n";
					lblNombre.setForeground(Color.RED);
				} else
					nueva.setNombre(nombre);
				valido = false;

				java.util.Date fecha = (java.util.Date) spinnerFecha.getValue();
				valido = Validaciones.validarFechaNuevaPrueba(fecha);
				if (!valido) {
					errores += "La fecha de la prueba no es válido (posterior a 1 mes desde hoy).\n";
				lblFecha.setForeground(Color.RED);
				} else {
					LocalDate fechaLD = LocalDate.of(fecha.getYear() + 1900, fecha.getMonth() + 1, fecha.getDate());
				nueva.setFecha(fechaLD);
				}
				valido = false;
				valido = (comboBoxLugar.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe seleccionar el lugar de celebración de la prueba.\n";
					lblLugar.setForeground(Color.RED);
				} else {
					Lugar lugar = (Lugar) comboBoxLugar.getSelectedItem();
					nueva.setLugar(lugar);
				}
				valido = false;
				valido = !(!rbIndividual.isSelected() && !rbEquipos.isSelected())
						|| (rbIndividual.isSelected() && rbEquipos.isSelected());
				if (!valido) {
					errores += "Debe seleccionar si la prueba es individual O por equipos.\n";
					rbIndividual.setForeground(Color.RED);
					rbEquipos.setForeground(Color.RED);
				} else {
					nueva.setIndividual(rbIndividual.isSelected() ? true : false);
				}
				valido = false;
				valido = (comboBoxPatrocinador.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe seleccionar el Patrocinador de la prueba.\n";
					lblPatrocinador.setForeground(Color.RED);
				} else {
					PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
					String seleccionado = (String) comboBoxPatrocinador.getSelectedItem();
					String[] aux = seleccionado.split("\\.");
					long idPat = Long.valueOf(aux[0]);
					Patrocinador patrocinador = patDAO.buscarPorID(idPat);
					ConexBD.cerrarConexion();
					if (patrocinador == null)
						valido = false;
					else
						nueva.setPatrocinador(patrocinador);
				}
				
				valido = (comboBoxPuesto1.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe seleccionar el Atleta del primer puesto.\n";
					lblprimerpuesto.setForeground(Color.RED);
				} else {
					AtletaDAO atl1DAO = new AtletaDAO(ConexBD.getCon());
					String seleccionado = (String) comboBoxPuesto1.getSelectedItem();
					String[] aux = seleccionado.split("\\.");
					long idAtl1 = Long.valueOf(aux[0]);
					Atleta atleta = atl1DAO.buscarPorID(idAtl1);
					ConexBD.cerrarConexion();
					if (atleta == null)
						valido = false;
					else
						nuevo.setAtleta(atleta);
				}
				
				valido = false;
				int hora = (int) nuevoT.getspinnerHora_1();
				valido =  Validaciones.validarnumhoras(hora);
				if (!valido)
					errores += "La hora de la prueba no es válido.\n";

				valido = false;
				
				valido = false;
				int minutos = (int) nuevoT.getspinnerMinutos_1();
				valido =  Validaciones.validarnumminutos(minutos);
				if (!valido)
					errores += "Los minutos de la prueba no es válido.\n";

				valido = false;
				
				valido = false;
				int segundos = (int) nuevoT.getspinnerSegundos_1();
				valido =  Validaciones.validarnumsegundos(segundos);
				if (!valido)
					errores += "Los segundos de la prueba no es válido.\n";

				valido = false;
				
				valido = false;
				int centesimas = (int) nuevoT.getspinnerCentesimas_1();
				valido =  Validaciones.validanumcentsegundo(centesimas);
				if (!valido)
					errores += "Las centésimas de la prueba no es válido.\n";

				valido = false;
				
				valido = (comboBoxPuesto1.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe seleccionar el Oro del primer puesto.\n";
					lblprimerpuesto.setForeground(Color.RED);
				} else {
					MetalDAO oroDAO = new MetalDAO(ConexBD.getCon());
					String seleccionado = (String) comboBoxOro.getSelectedItem();
					String[] aux = seleccionado.split("\\.");
					long idOro = Long.valueOf(aux[0]);
					Metal metal = oroDAO.buscarPorID(idOro);
					ConexBD.cerrarConexion();
					if (metal == null)
						valido = false;
					else
						nuevoM.setMetal(metal);
				} 
					
					
				valido = (comboBoxPuesto2.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe seleccionar el Atleta del primer puesto.\n";
					lblprimerpuesto.setForeground(Color.RED);
				} else {
					AtletaDAO atl1DAO = new AtletaDAO(ConexBD.getCon());
					String seleccionado = (String) comboBoxPuesto2.getSelectedItem();
					String[] aux = seleccionado.split("\\.");
					long idAtl2 = Long.valueOf(aux[0]);
					Atleta atleta = atl1DAO.buscarPorID(idAtl2);
					ConexBD.cerrarConexion();
					if (atleta == null)
						valido = false;
					else
						nuevo.setAtleta(atleta);
				}
				
				valido = false;
				int hora2 = (int) nuevoT.getspinnerHora_2();
				valido =  Validaciones.validarnumhoras(hora2);
				if (!valido)
					errores += "La hora de la prueba no es válido.\n";

				valido = false;
				
				valido = false;
				int minutos2 = (int) nuevoT.getspinnerMinutos_2();
				valido =  Validaciones.validarnumminutos(minutos2);
				if (!valido)
					errores += "Los minutos de la prueba no es válido.\n";

				valido = false;
				
				valido = false;
				int segundos2 = (int) nuevoT.getspinnerSegundos_2();
				valido =  Validaciones.validarnumsegundos(segundos2);
				if (!valido)
					errores += "Los segundos de la prueba no es válido.\n";

				valido = false;
				
				valido = false;
				int centesimas2 = (int) nuevoT.getspinnerCentesimas_2();
				valido =  Validaciones.validanumcentsegundo(centesimas2);
				if (!valido)
					errores += "Las centésimas de la prueba no es válido.\n";

				valido = false;
				
				valido = (comboBoxPuesto2.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe seleccionar el Oro del primer puesto.\n";
					lblprimerpuesto.setForeground(Color.RED);
				} else {
					MetalDAO plataDAO = new MetalDAO(ConexBD.getCon());
					String seleccionado = (String) comboBoxPlata.getSelectedItem();
					String[] aux = seleccionado.split("\\.");
					long idPla = Long.valueOf(aux[0]);
					Metal metal = plataDAO.buscarPorID(idPla);
					ConexBD.cerrarConexion();
					if (metal == null)
						valido = false;
					else
						nuevoM.setMetal(metal);
				}
				
				valido = (comboBoxPuesto3.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe seleccionar el Atleta del primer puesto.\n";
					lbltercerpuesto.setForeground(Color.RED);
				} else {
					AtletaDAO atl3DAO = new AtletaDAO(ConexBD.getCon());
					String seleccionado = (String) comboBoxPuesto3.getSelectedItem();
					String[] aux = seleccionado.split("\\.");
					long idAtl3 = Long.valueOf(aux[0]);
					Atleta atleta = atl3DAO.buscarPorID(idAtl3);
					ConexBD.cerrarConexion();
					if (atleta == null)
						valido = false;
					else
						nuevo.setAtleta(atleta);
				}
				
				valido = false;
				int hora3 = (int) nuevoT.getspinnerHora_3();
				valido =  Validaciones.validarnumhoras(hora3);
				if (!valido)
					errores += "La hora de la prueba no es válido.\n";

				valido = false;
				
				valido = false;
				int minutos3 = (int) nuevoT.getspinnerMinutos_3();
				valido =  Validaciones.validarnumminutos(minutos3);
				if (!valido)
					errores += "Los minutos de la prueba no es válido.\n";

				valido = false;
				
				valido = false;
				int segundos3 = (int) nuevoT.getspinnerSegundos_3();
				valido =  Validaciones.validarnumsegundos(segundos3);
				if (!valido)
					errores += "Los segundos de la prueba no es válido.\n";

				valido = false;
				
				valido = false;
				int centesimas3 = (int) nuevoT.getspinnerCentesimas_3();
				valido =  Validaciones.validanumcentsegundo(centesimas3);
				if (!valido)
					errores += "Las centésimas de la prueba no es válido.\n";

				valido = false;
				
				valido = (comboBoxPuesto3.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe seleccionar el Bronce del tercer puesto.\n";
					lblprimerpuesto.setForeground(Color.RED);
				} else {
					MetalDAO bronceDAO = new MetalDAO(ConexBD.getCon());
					String seleccionado = (String) comboBoxBronce.getSelectedItem();
					String[] aux = seleccionado.split("\\.");
					long idBronce = Long.valueOf(aux[0]);
					Metal metal = bronceDAO.buscarPorID(idBronce);
					ConexBD.cerrarConexion();
					if (metal == null)
						valido = false;
					else
						nuevoM.setMetal(metal);
				}
				
				
				valido = !(!chckbxNewCheckBox.isSelected())
						|| (chckbxNewCheckBox.isSelected());
				if (!valido) {
					errores += "Debe seleccionar si la nueva prueba es individual O por equipos.\n";
					lblEstablecer.setForeground(Color.RED);
				} else {
					nueva.setIndividual(chckbxNewCheckBox.isSelected() ? true : false);
				}
				valido = false;
				
				
				
				valido = errores.isEmpty();

				if (!valido) {
					titulo = "ERROR: Campos inválidos";
					msj = "ERROR: los siguientes campos NO son válidos:\n\n";
					if (!errores.isEmpty())
						msj += errores + "\n";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
					return;
				}

				/// Si todos los datos son correctos, llamar a PruebaDAO para insertar en la BD
//				PruebaDAO pruebadao = new PruebaDAO(ConexBD.establecerConexion());
//				boolean correcto = pruebadao.modificar(prueba);
//				/// Tanto si la inserción de la nueva prueba tiene éxito como si no, avisar al
//				/// usuario
//				if (!correcto) {
//					// hubo error al insertar en BD y no se generó la nueva prueba
//					titulo = "ERROR al cerrar la Prueba en la BD";
//					msj = "Hubo un error y NO se ha cerrado la prueba en la BD.";
//					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
//				} else {
//					titulo = "Prueba "+prueba.getId()+" cerrada en la BD";
//					msj = "Se ha cerrado correctamente la  prueba:\n" + prueba.toString();
//					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);
//					/// Aqui se redirigiría al usuario hacia la pantalla principal
//					/// TODO
//				}
//			}
//		});
				
				
				PruebaDAO pdao = new PruebaDAO(ConexBD.establecerConexion());
				long idpruebanuevo = pdao.insertarSinID(nueva);
				/// Tanto si la inserción de la nueva prueba tiene éxito como si no, avisar al
				/// usuario
				if (idpruebanuevo <= 0) {
					// hubo error al insertar en BD y no se generó la nueva prueba
					titulo = "ERROR al insertar el Nuevo Atleta en la BD";
					msj = "Hubo un error y NO se ha insertado el nuevo atleta en la BD.";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
				} else {
					nueva.setId(idpruebanuevo);
					titulo = "Nueva prueba insertado en la BD";
					msj = "Se ha insertado correctamente la prueba:\n" + nueva.toString();
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);

				
					File f = new File("resultado_prueba"+ nueva.cerrarPrueba(idprueba)+".txt" );
					FileOutputStream fo;
					try {
							fo = new FileOutputStream(f);
							ObjectOutputStream oos = new ObjectOutputStream(fo);
							oos.writeLong(idpruebanuevo);
							oos.writeUTF(nuevo.getPersona().getNombre());
							oos.flush();
							oos.close();
							fo.close();
							titulo = "Nuevo resultado exportado a fichero";
							msj = "Se ha exportado correctamente el nuevo resultado al fichero " + f.getName();
							JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);
							/// Aqui se redirigiría al usuario hacia la pantalla principal
							/// TODO
							System.out.println("Se han exportado los datos del nuevo resultado al fichero "+f.getName());
					} catch (FileNotFoundException exc) {
						System.out.println("Se ha producido una FileNotFoundException:" + exc.getMessage());
						exc.printStackTrace();
					} catch (IOException ex) {
						System.out.println("Se ha producido una IOException:" + ex.getMessage());
						ex.printStackTrace();
					}

				}
				ConexBD.cerrarConexion();
				/// Aqui se redirigiría al usuario hacia la pantalla principal
				/// TODO
			}
		});
		buttonAceptar.setBounds(236, 562, 89, 23);
		contentPane.add(buttonAceptar);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = "Cerrar ventana";
				String msj = "¿Realmente desea cerrar la ventana?";
				int opcion = JOptionPane.showConfirmDialog(null, msj, titulo, JOptionPane.OK_CANCEL_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					/// Aqui se redirigiría al usuario hacia la pantalla principal o se saldria
					System.exit(0); /// SALIR directamente
				}

			}
		});
		
		
		
		
		
		buttonCancelar.setBounds(335, 562, 89, 23);
		contentPane.add(buttonCancelar);
		
		JLabel lblHora_1 = new JLabel("Hora: ");
		lblHora_1.setBounds(27, 276, 36, 14);
		contentPane.add(lblHora_1);
		
		JSpinner spinnerHora_1 = new JSpinner();
		spinnerHora_1.setBounds(65, 276, 30, 20);
		contentPane.add(spinnerHora_1);
		
		JLabel lblMinutos_1 = new JLabel("Minutos: ");
		lblMinutos_1.setBounds(111, 276, 46, 14);
		contentPane.add(lblMinutos_1);
		
		JSpinner spinnerMinutos_1 = new JSpinner();
		spinnerMinutos_1.setBounds(162, 276, 30, 20);
		contentPane.add(spinnerMinutos_1);
		
		JLabel lblSegundos_1 = new JLabel("Segundos: ");
		lblSegundos_1.setBounds(206, 276, 54, 14);
		contentPane.add(lblSegundos_1);
		
		JSpinner spinnerSegundos_1 = new JSpinner();
		spinnerSegundos_1.setBounds(267, 276, 30, 20);
		contentPane.add(spinnerSegundos_1);
		
		JLabel lblCentesimas_1 = new JLabel("Centésimas: ");
		lblCentesimas_1.setBounds(313, 276, 62, 14);
		contentPane.add(lblCentesimas_1);
		
		JSpinner spinnerCentesimas_1 = new JSpinner();
		spinnerCentesimas_1.setBounds(385, 273, 30, 20);
		contentPane.add(spinnerCentesimas_1);
		
		JLabel lblIdoro = new JLabel("Id Oro*: ");
		lblIdoro.setBounds(27, 307, 46, 14);
		contentPane.add(lblIdoro);
		
		JComboBox comboBoxOro = new JComboBox();
		comboBoxOro.setBounds(90, 307, 46, 22);
		contentPane.add(comboBoxOro);
		
		JLabel lblHora_2 = new JLabel("Hora: ");
		lblHora_2.setBounds(27, 377, 36, 14);
		contentPane.add(lblHora_2);
		
		JLabel lblMinutos_2 = new JLabel("Minutos: ");
		lblMinutos_2.setBounds(111, 377, 46, 14);
		contentPane.add(lblMinutos_2);
		
		JSpinner spinnerHora_2 = new JSpinner();
		spinnerHora_2.setBounds(65, 377, 30, 20);
		contentPane.add(spinnerHora_2);
		
		JSpinner spinnerMinutos_2 = new JSpinner();
		spinnerMinutos_2.setBounds(162, 377, 30, 20);
		contentPane.add(spinnerMinutos_2);
		
		JLabel lblSegundos_2 = new JLabel("Segundos: ");
		lblSegundos_2.setBounds(206, 377, 54, 14);
		contentPane.add(lblSegundos_2);
		
		JSpinner spinnerSegundos_2 = new JSpinner();
		spinnerSegundos_2.setBounds(267, 377, 30, 20);
		contentPane.add(spinnerSegundos_2);
		
		JLabel lblCentesimas_2 = new JLabel("Centésimas: ");
		lblCentesimas_2.setBounds(313, 377, 62, 14);
		contentPane.add(lblCentesimas_2);
		
		JSpinner spinnerCentesimas_2 = new JSpinner();
		spinnerCentesimas_2.setBounds(385, 374, 30, 20);
		contentPane.add(spinnerCentesimas_2);
		
		JLabel lblIdPlata = new JLabel("Id Plata*: ");
		lblIdPlata.setBounds(27, 408, 53, 14);
		contentPane.add(lblIdPlata);
		
		JComboBox comboBoxOro_1 = new JComboBox();
		comboBoxOro_1.setBounds(90, 404, 46, 22);
		contentPane.add(comboBoxOro_1);
		
		JLabel lblHora_3 = new JLabel("Hora: ");
		lblHora_3.setBounds(27, 470, 36, 14);
		contentPane.add(lblHora_3);
		
		JLabel lblMinutos_3 = new JLabel("Minutos: ");
		lblMinutos_3.setBounds(111, 470, 46, 14);
		contentPane.add(lblMinutos_3);
		
		JSpinner spinnerHora_3 = new JSpinner();
		spinnerHora_3.setBounds(65, 470, 30, 20);
		contentPane.add(spinnerHora_3);
		
		JSpinner spinnerMinutos_3 = new JSpinner();
		spinnerMinutos_3.setBounds(162, 470, 30, 20);
		contentPane.add(spinnerMinutos_3);
		
		JLabel lblSegundos_3 = new JLabel("Segundos: ");
		lblSegundos_3.setBounds(206, 470, 54, 14);
		contentPane.add(lblSegundos_3);
		
		JSpinner spinnerSegundos_3 = new JSpinner();
		spinnerSegundos_3.setBounds(267, 470, 30, 20);
		contentPane.add(spinnerSegundos_3);
		
		JLabel lblCentsimas_3 = new JLabel("Centésimas: ");
		lblCentsimas_3.setBounds(313, 470, 62, 14);
		contentPane.add(lblCentsimas_3);
		
		JSpinner spinnerCentesimas_3 = new JSpinner();
		spinnerCentesimas_3.setBounds(385, 467, 30, 20);
		contentPane.add(spinnerCentesimas_3);
		
		JLabel lblIdBronce = new JLabel("Id Bronce*: ");
		lblIdBronce.setBounds(27, 501, 68, 14);
		contentPane.add(lblIdBronce);
		
		JComboBox comboBoxOro_2 = new JComboBox();
		comboBoxOro_2.setBounds(90, 495, 46, 22);
		contentPane.add(comboBoxOro_2);
		
		JLabel lblEstablecer = new JLabel("Establecer como DEFINITIVO: ");
		lblEstablecer.setBounds(27, 534, 146, 14);
		contentPane.add(lblEstablecer);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(190, 530, 30, 23);
		contentPane.add(chckbxNewCheckBox);

	}
	
}
