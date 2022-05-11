package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.EquipoDAO;
import entidades.Atleta;
import entidades.Equipo;
import entidades.Lugar;
import entidades.Patrocinador;
import entidades.Prueba;
import utils.ConexBD;
import validaciones.Validaciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class NuevoAtleta extends JFrame {


	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoAtleta frame = new NuevoAtleta();
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
	public NuevoAtleta() {
		setTitle("Nuevo Atleta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre*:");
		lblNewLabel.setBounds(32, 25, 94, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBackground(Color.ORANGE);
		
		textField = new JTextField();
		textField.setBounds(136, 22, 375, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSeleccioneLaOpcin = new JLabel("Seleccione la opción e indique su valor*:");
		lblSeleccioneLaOpcin.setBounds(28, 66, 219, 14);
		panel.add(lblSeleccioneLaOpcin);
		lblSeleccioneLaOpcin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSeleccioneLaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneLaOpcin.setBackground(Color.ORANGE);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("NIF");
		rdbtnNewRadioButton.setBounds(291, 62, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("NIE");
		rdbtnNewRadioButton_1.setBounds(417, 62, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(280, 91, 219, 20);
		panel.add(textField_1);
		
		JLabel lblDatosPersonales = new JLabel("Datos Personales:");
		lblDatosPersonales.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDatosPersonales.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosPersonales.setBackground(Color.ORANGE);
		lblDatosPersonales.setBounds(28, 0, 94, 14);
		panel.add(lblDatosPersonales);
		
		JLabel lblDocumentacin = new JLabel("Documentación:");
		lblDocumentacin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDocumentacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocumentacin.setBackground(Color.ORANGE);
		lblDocumentacin.setBounds(28, 50, 94, 14);
		panel.add(lblDocumentacin);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTelfono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelfono.setBackground(Color.ORANGE);
		lblTelfono.setBounds(32, 143, 76, 14);
		panel.add(lblTelfono);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento*:");
		lblFechaDeNacimiento.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeNacimiento.setBackground(Color.ORANGE);
		lblFechaDeNacimiento.setBounds(283, 143, 137, 14);
		panel.add(lblFechaDeNacimiento);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(107, 140, 137, 20);
		panel.add(textField_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1652220000000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(430, 140, 96, 20);
		panel.add(spinner);
		
		JLabel lblDatosFsicos = new JLabel("Datos Físicos:");
		lblDatosFsicos.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDatosFsicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosFsicos.setBackground(Color.ORANGE);
		lblDatosFsicos.setBounds(32, 209, 94, 14);
		panel.add(lblDatosFsicos);
		
		JLabel lblAltura = new JLabel("Altura*:");
		lblAltura.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setBackground(Color.ORANGE);
		lblAltura.setBounds(42, 234, 94, 14);
		panel.add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso*:");
		lblPeso.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setBackground(Color.ORANGE);
		lblPeso.setBounds(42, 273, 94, 14);
		panel.add(lblPeso);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(118, 231, 76, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(118, 270, 76, 20);
		panel.add(textField_4);
		
		JLabel lblMEnFormato = new JLabel("m (en formato xx,xx)");
		lblMEnFormato.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMEnFormato.setHorizontalAlignment(SwingConstants.CENTER);
		lblMEnFormato.setBackground(Color.ORANGE);
		lblMEnFormato.setBounds(204, 234, 137, 14);
		panel.add(lblMEnFormato);
		
		JLabel lblKg = new JLabel("Kg (en formato xx,xx)");
		lblKg.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKg.setHorizontalAlignment(SwingConstants.CENTER);
		lblKg.setBackground(Color.ORANGE);
		lblKg.setBounds(204, 273, 137, 14);
		panel.add(lblKg);
		
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setBackground(Color.ORANGE);
		lblEquipo.setBounds(32, 337, 76, 14);
		panel.add(lblEquipo);
		
		DefaultComboBoxModel<Equipo> equiposModel = new DefaultComboBoxModel<Equipo>();
		JComboBox<Equipo> comboBoxEquipo = new JComboBox<Equipo>(equiposModel);
		EquipoDAO patDAO = new EquipoDAO(ConexBD.getCon());
		ArrayList<Equipo> equipoList = (ArrayList<Equipo>) patDAO.buscarTodos();
		for (Equipo pat : equipoList)
			comboBoxEquipo.addItem(pat);

//		/// Pero el modelo de comboBox básico requiere Strings
//		String[] equiposStr = new String[equiposList.size()];
//		for (int i = 0; i < equiposList.size(); i++)
//			equiposStr[i] = equiposList.get(i).mostrarBasico();
//		comboBoxEquipo.setModel(new DefaultComboBoxModel(equiposStr));
		
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "¿Deseas cancelar y cerrar la ventana?", "Salir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				System.exit(ABORT);
			}
		});
		btnNewButton.setBounds(538, 372, 89, 23);
		panel.add(btnNewButton);
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atleta nueva = new Atleta();
				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";
				/// Tomar cada campo y validarlo. Si alguno no es correcto, avisar al usuario
				String nombre = textField.getText();
				valido = Validaciones.validarNombre(nombre);
				if (!valido) {
					errores += "El nombre del atleta no es válido (5-150 caracteres).\n";
					lblNewLabel.setForeground(Color.RED);
				} else
					nueva.getPersona().getNombre();
				valido = false;

				String nifnie = textField_1.getText();
				valido = Validaciones.validarNIF(nifnie);
				if (!valido) {
					errores += "El Nif/Nie del atleta no es válido.\n";
					lblSeleccioneLaOpcin.setForeground(Color.RED);
				} else
					nueva.getPersona().getNifnie();
				valido = false;
				
				String telef = textField_1.getText();
				valido = Validaciones.validarTelefono(telef);
				if (!valido) {
					errores += "El teléfono del atleta no es válido.\n";
					lblSeleccioneLaOpcin.setForeground(Color.RED);
				} else
					nueva.getPersona().getTelefono();
				valido = false;
				
			
				java.util.Date fech = (java.util.Date) spinner.getValue();
				valido =  Validaciones.validarFechaNuevaPrueba(fech);
				if (!valido) {
					errores += "La fecha de la prueba no es válido (posterior a 1 mes desde hoy).\n";
					lblFechaDeNacimiento.setForeground(Color.RED);
				} else {
					LocalDate FechaDeNacimiento = LocalDate.of(fech.getYear() + 1900, fech.getMonth() + 1, fech.getDate());
					nueva.getPersona().getFechaNac();
				}
				valido = false;
				
//				String altura = textField.getText();
//				valido = Validaciones.validarAltura(altura);
//				if (!valido) {
//					errores += "El nombre del atleta no es válido (5-150 caracteres).\n";
//					lblNewLabel.setForeground(Color.RED);
//				} else
//					nueva.getPersona().getNombre();
//				valido = false;
//				
//				valido = (comboBoxLugar.getSelectedIndex() != -1);
//				if (!valido) {
//					errores += "Debe seleccionar el lugar de celebración de la nueva prueba.\n";
//					lblLugar.setForeground(Color.RED);
//				} else {
//					Lugar lugar = (Lugar) comboBoxLugar.getSelectedItem();
//					nueva.setLugar(lugar);
//				}
//				valido = false;
//				valido = !(!rbIndividual.isSelected() && !rbEquipos.isSelected())
//						|| (rbIndividual.isSelected() && rbEquipos.isSelected());
//				if (!valido) {
//					errores += "Debe seleccionar si la nueva prueba es individual O por equipos.\n";
//					rbIndividual.setForeground(Color.RED);
//					rbEquipos.setForeground(Color.RED);
//				} else {
//					nueva.setIndividual(rbIndividual.isSelected() ? true : false);
//				}
//				valido = false;
//				valido = (comboBoxPatrocinador.getSelectedIndex() != -1);
//				if (!valido) {
//					errores += "Debe seleccionar el Patrocinador de la nueva prueba.\n";
//					lblPatrocinador.setForeground(Color.RED);
//				} else {
//					PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
//					String seleccionado = (String) comboBoxPatrocinador.getSelectedItem();
//					String[] aux = seleccionado.split("\\.");
//					long idPat = Long.valueOf(aux[0]);
//					Patrocinador patrocinador = patDAO.buscarPorID(idPat);
//					ConexBD.cerrarConexion();
//					if (patrocinador == null)
//						valido = false;
//					else
//						nueva.setPatrocinador(patrocinador);
//				}
				valido = errores.isEmpty();

				if (!valido) {
					titulo = "ERROR: Campos inválidos";
					msj = "ERROR: los siguientes campos de Nueva Prueba NO son válidos:\n\n";
					if (!errores.isEmpty())
						msj += errores + "\n";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
					return;
				}

				/// Si todos los datos son correctos, llamar a PruebaDAO para insertar en la BD
				//PruebaDAO pruebadao = new PruebaDAO(ConexBD.establecerConexion());
				//long idpruebanuevo = pruebadao.insertarSinID(nueva);
				/// Tanto si la inserción de la nueva prueba tiene éxito como si no, avisar al
				/// usuario
				//if (idpruebanuevo <= 0) {
					// hubo error al insertar en BD y no se generó la nueva prueba
					titulo = "ERROR al insertar la Nueva Prueba en la BD";
					msj = "Hubo un error y NO se ha insertado la nueva prueba en la BD.";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
//				} else {
//					nueva.setId(idpruebanuevo);
//					titulo = "Nueva Prueba insertada en la BD";
//					msj = "Se ha insertado correctamente la nueva prueba:\n" + nueva.toString();
//					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);
//					///Aqui se redirigiría al usuario hacia la pantalla principal
//					///TODO
//				}
			}
		});
		
		
		buttonAceptar.setBounds(417, 372, 89, 23);
		panel.add(buttonAceptar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(121, 333, 405, 22);
		panel.add(comboBox);
	}
}
