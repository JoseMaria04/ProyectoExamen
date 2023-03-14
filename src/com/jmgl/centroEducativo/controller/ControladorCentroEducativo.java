package com.jmgl.centroEducativo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jmgl.centroEducativo.model.CentroEducativo;
import com.jmgl.centroEducativo.utils.ConnectionManager;


public class ControladorCentroEducativo {
	/**
	 * 
	 * @return
	 */
	public static List<CentroEducativo> findAll() {
		List<CentroEducativo> centro = new ArrayList<CentroEducativo>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from centroeducativo");
			
			while (rs.next()) {
				CentroEducativo ce = new CentroEducativo();
				ce = new CentroEducativo();
				ce.setId(rs.getInt("id"));
				ce.setDescripcion(rs.getString("descripcion"));
				centro.add(ce);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return centro;
	}
}
