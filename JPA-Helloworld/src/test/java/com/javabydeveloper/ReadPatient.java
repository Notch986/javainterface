package com.javabydeveloper;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReadPatient {

	public final String SQL = "SELECT * FROM patients";
	public DefaultTableModel model;
	public JScrollPane scrollLista;
	public JTable table;
	
	public ReadPatient() {
		printList();
	}
	public void printList() {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "12345678");
			PreparedStatement ps = conn.prepareStatement(SQL)) {
			ResultSet rs = ps.executeQuery();

			model = new DefaultTableModel();
			model.addColumn("id");
			model.addColumn("dni");
			model.addColumn("nombre");
			model.addColumn("apellido P");
			model.addColumn("apellido M");
			model.addColumn("genero");
			model.addColumn("nacimiento");
			model.addColumn("T. sangre");
			model.addColumn("tamaño");
			model.addColumn("peso");
			model.addColumn("telefono");
			model.addColumn("direccion");
			model.addColumn("correo");
			model.addColumn("otros");
			
			String[] datos = new String[13];
			
			while (rs.next()) {
				for(int i=0; i<datos.length; i++) {
					datos[i]=rs.getString(i+1);
				}
				model.addRow(datos);
			}
			table = new JTable(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			scrollLista = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollLista.setBounds(30, 30, 290, 260);
			Color c = new Color(255,255,255,30);
			scrollLista.getViewport().setBackground(c);
			scrollLista.setOpaque(false);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

