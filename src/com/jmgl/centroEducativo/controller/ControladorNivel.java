package com.jmgl.centroEducativo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jmgl.centroEducativo.model.Nivel;
import com.jmgl.centroEducativo.utils.ConnectionManager;

public class ControladorNivel {
	/**
	 * 
	 * @return
	 */
	public static List<Nivel> findAll() {
		List<Nivel> nivel = new ArrayList<Nivel>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from nivel ");
			
			while (rs.next()) {
				Nivel n = new Nivel();
				n = new Nivel();
				n.setId(rs.getInt("id"));
				n.setDescripcion(rs.getString("descripcion"));
				n.setIdCentro(rs.getInt("idCentro"));
				nivel.add(n);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return nivel;
	}
}
