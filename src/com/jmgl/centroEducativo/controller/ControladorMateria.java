package com.jmgl.centroEducativo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jmgl.centroEducativo.model.Materia;
import com.jmgl.centroEducativo.model.Nivel;
import com.jmgl.centroEducativo.utils.ConnectionManager;

public class ControladorMateria {
	/**
	 * 
	 * @return
	 */
	public static List<Materia> findAll() {
		List<Materia> materia = new ArrayList<Materia>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from materia ");
			
			while (rs.next()) {
				Materia m = new Materia();
				m = new Materia();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setIdNivel(rs.getInt("idNivel"));
				m.setCodigo(rs.getString("codigo"));
				m.setUrlClassroom(rs.getString("urlclassroom"));
				m.setIdNivel(rs.getInt("idNivel"));
				m.setFechaInicio(rs.getDate("FechaInicio"));
				materia.add(m);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return materia;
	}
}
