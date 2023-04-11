package com.jmgl.centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jmgl.centroEducativo.model.Materia;
import com.jmgl.centroEducativo.utils.ConnectionManager;

public class ControladorMateria {
	/**
	 * 
	 * @return
	 */
	public static List<Materia> findAll(int id) {
		List<Materia> materia = new ArrayList<Materia>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from materia where idNivel = " + id);
			
			while (rs.next()) {
				Materia m = new Materia();
				m = new Materia();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setIdNivel(rs.getInt("idNivel"));
				m.setCodigo(rs.getString("codigo"));
				m.setUrlClassroom(rs.getString("urlclassroom"));
				m.setAdmiteMatricula(rs.getBoolean("admiteMatricula"));
				m.setFechaInicio(rs.getDate("FechaInicio"));
				materia.add(m);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return materia;
	}

	public static int modificar(Materia m) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update materia set nombre = ?, codigo = ?, "
					+ "urlClassroom = ?, admiteMatricula = ?, fechaInicio = ? where id = ?");
		
			ps.setString(1, m.getNombre());
			ps.setString(2, m.getCodigo());
			ps.setString(3, m.getUrlClassroom());
			ps.setBoolean(4, m.isAdmiteMatricula());
			ps.setDate(5, new java.sql.Date(m.getFechaInicio().getTime()));
			ps.setInt(6, m.getId());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
