package com.jmgl.centroEducativo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jmgl.centroEducativo.controller.ControladorCentroEducativo;
import com.jmgl.centroEducativo.controller.ControladorMateria;
import com.jmgl.centroEducativo.controller.ControladorNivel;
import com.jmgl.centroEducativo.model.CentroEducativo;
import com.jmgl.centroEducativo.model.Materia;
import com.jmgl.centroEducativo.model.Nivel;
import com.jmgl.centroEducativo.utils.CacheImagenes;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class VentanaGestionMateria extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfCodigo;
	private JTextField jtfUrl;
	private JTextField jtfFechaDeInicio;
	JComboBox<CentroEducativo> jcbCentro;
	JComboBox<Nivel> jcbNivel;
	JComboBox<Materia> jcbMateria;
	private JCheckBox checkAdmiteMatricula;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private CacheImagenes cacheImagenes;
	public static BufferedImage iconoApp;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGestionMateria frame = new VentanaGestionMateria();
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
	public VentanaGestionMateria() {
		cacheImagenes = new CacheImagenes();
		iconoApp = cacheImagenes.getImagen("nave.gif");
		this.setIconImage(iconoApp);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{87, 270};
//		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_10 = new JLabel("Gestion de Materias");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.gridwidth = 2;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 0;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JLabel lblNewLabel = new JLabel("Centro: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		 jcbCentro = new JComboBox<CentroEducativo>();
		 jcbCentro.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(jcbCentro.getSelectedItem() != null) {
		 			CentroEducativo c =	(CentroEducativo) jcbCentro.getSelectedItem();
		 			cargarNivel(c.getId());
		 		}
		 	}
		 });
		GridBagConstraints gbc_jcbCentro = new GridBagConstraints();
		gbc_jcbCentro.weightx = 1.0;
		gbc_jcbCentro.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCentro.gridx = 1;
		gbc_jcbCentro.gridy = 1;
		contentPane.add(jcbCentro, gbc_jcbCentro);
		
		JLabel lblNewLabel_1 = new JLabel("Nivel: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		 jcbNivel = new JComboBox<Nivel>();
		 jcbNivel.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(jcbNivel.getSelectedItem() != null) {
		 			Nivel c =	(Nivel) jcbNivel.getSelectedItem();
		 			cargarMaterias(c.getId());
		 		}
		 	}
		 });
		GridBagConstraints gbc_jcbNivel = new GridBagConstraints();
		gbc_jcbNivel.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNivel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNivel.gridx = 1;
		gbc_jcbNivel.gridy = 2;
		contentPane.add(jcbNivel, gbc_jcbNivel);
		
		JLabel lblNewLabel_2 = new JLabel("Materia: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		 jcbMateria = new JComboBox<Materia>();
		 jcbMateria.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(jcbMateria.getSelectedItem() != null) {
		 			Materia m =	(Materia) jcbMateria.getSelectedItem();
		 			cargarDatosMateria(m);
		 		}
		 	}
		 });
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 3;
		contentPane.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_3 = new JLabel("Datos de la materia");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Id: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 5;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 6;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Codigo: ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfCodigo = new JTextField();
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 7;
		contentPane.add(jtfCodigo, gbc_jtfCodigo);
		jtfCodigo.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("URL Clasroom: ");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfUrl = new JTextField();
		GridBagConstraints gbc_jtfUrl = new GridBagConstraints();
		gbc_jtfUrl.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUrl.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUrl.gridx = 1;
		gbc_jtfUrl.gridy = 8;
		contentPane.add(jtfUrl, gbc_jtfUrl);
		jtfUrl.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Fecha de Inicio");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfFechaDeInicio = new JTextField();
		GridBagConstraints gbc_jtfFechaDeInicio = new GridBagConstraints();
		gbc_jtfFechaDeInicio.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaDeInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaDeInicio.gridx = 1;
		gbc_jtfFechaDeInicio.gridy = 9;
		contentPane.add(jtfFechaDeInicio, gbc_jtfFechaDeInicio);
		jtfFechaDeInicio.setColumns(10);
		
		checkAdmiteMatricula = new JCheckBox("");
		GridBagConstraints gbc_checkAdmiteMatricula = new GridBagConstraints();
		gbc_checkAdmiteMatricula.anchor = GridBagConstraints.EAST;
		gbc_checkAdmiteMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_checkAdmiteMatricula.gridx = 0;
		gbc_checkAdmiteMatricula.gridy = 10;
		contentPane.add(checkAdmiteMatricula, gbc_checkAdmiteMatricula);
		
		JLabel lblNewLabel_9 = new JLabel("Admite matricula");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 10;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 11;
		contentPane.add(panel, gbc_panel);
		
		JButton btnNewButton_3 = new JButton("Guardar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarMateria();
			}
		});
		panel.add(btnNewButton_3);
		
		cargarCentro();
	}
	
	/**
	 * 
	 */
	private void cargarCentro() {
		List<CentroEducativo> centro = ControladorCentroEducativo.findAll();
		for (CentroEducativo centro1 : centro) {
			this.jcbCentro.addItem(centro1);
		}
	}
	
	/**
	 * 
	 * @param idCentro
	 */
	private void cargarNivel(int idCentro ) {
		this.jcbNivel.removeAllItems();
		List<Nivel> nivel = ControladorNivel.findAll(idCentro);
		for (Nivel nivel1 : nivel) {
			this.jcbNivel.addItem(nivel1);
		}
	}

	/**
	 * 
	 */
	private void cargarMaterias(int idNivel) {
		
		this.jcbMateria.removeAllItems();
		List<Materia> materias = ControladorMateria.findAll( idNivel);
		for (Materia m : materias) {
			this.jcbMateria.addItem(m);
		}
	}
	
	/**
	 * 
	 */
	private void cargarDatosMateria(Materia m) {
		
		if (m != null) {
			this.jtfId.setText("" + m.getId());
			this.jtfNombre.setText("" + m.getId());
			this.jtfCodigo.setText(m.getCodigo());
			this.jtfNombre.setText(m.getNombre());
			this.jtfUrl.setText(m.getUrlClassroom());
			this.jtfFechaDeInicio.setText(sdf.format(m.getFechaInicio()));
			this.checkAdmiteMatricula.setSelected(m.isAdmiteMatricula());
		}
	}
	
	/**
	 * 
	 */
	private void guardarMateria() {
		
		if (!isCodigoValido()) {
			JOptionPane.showMessageDialog(null, "El código indicado no tiene al menos tres letras");
			return;
		}
		
		if (!isUrlValida()) {
			JOptionPane.showMessageDialog(null, "La url debe comenzar por http o https");
			return;
		}
		
		Materia m = new Materia();
		
		m.setId(Integer.parseInt(this.jtfId.getText()));
		m.setCodigo(this.jtfCodigo.getText());
		m.setNombre(this.jtfNombre.getText());
		m.setUrlClassroom(this.jtfUrl.getText());
		try {
			m.setFechaInicio(sdf.parse(this.jtfFechaDeInicio.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		m.setAdmiteMatricula(this.checkAdmiteMatricula.isSelected());
		
		if (ControladorMateria.modificar(m) == 1) {
			JOptionPane.showMessageDialog(null, "Modificado correctamente", "Guardar",JOptionPane.INFORMATION_MESSAGE, cacheImagenes.getIcono("goku.png"));
		}
		else {
			JOptionPane.showMessageDialog(null, "NO se ha modificado correctamente");			
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isCodigoValido () {
		String codigo = this.jtfCodigo.getText();
		int contLetras = 0;
		
		for (int i = 0; i < codigo.length(); i++) {
			if (Character.isLetter(codigo.charAt(i))) {
				contLetras++;
			}
		}
		
		if (contLetras > 2) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isUrlValida() {
		String url = this.jtfUrl.getText().toUpperCase();
		if (url.startsWith("HTTP") || url.startsWith("HTTPS")) {
			return true;
		}
		return false;
	}
}
