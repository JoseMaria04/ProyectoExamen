package com.jmgl.centroEducativo.model;

import java.util.Date;

public class Materia {
	private int id;
	private String nombre;
	private int idNivel;
	private String codigo;
	private String urlClassroom;
	private  boolean admiteMatricula;
	private Date fechaInicio;
	
	/**
	 * 
	 */
	public Materia() {
		super();
	}

	/**
	 * @param id
	 * @param nombre
	 * @param idNivel
	 * @param codigo
	 * @param urlClassroom
	 * @param admiteMatricula
	 * @param fechaInicio
	 */
	public Materia(int id, String nombre, int idNivel, String codigo, String urlClassroom, boolean admiteMatricula,
			Date fechaInicio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idNivel = idNivel;
		this.codigo = codigo;
		this.urlClassroom = urlClassroom;
		this.admiteMatricula = admiteMatricula;
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the idNivel
	 */
	public int getIdNivel() {
		return idNivel;
	}

	/**
	 * @param idNivel the idNivel to set
	 */
	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the urlClassroom
	 */
	public String getUrlClassroom() {
		return urlClassroom;
	}

	/**
	 * @param urlClassroom the urlClassroom to set
	 */
	public void setUrlClassroom(String urlClassroom) {
		this.urlClassroom = urlClassroom;
	}

	/**
	 * @return the admiteMatricula
	 */
	public boolean isAdmiteMatricula() {
		return admiteMatricula;
	}

	/**
	 * @param admiteMatricula the admiteMatricula to set
	 */
	public void setAdmiteMatricula(boolean admiteMatricula) {
		this.admiteMatricula = admiteMatricula;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param date the fechaInicio to set
	 */
	public void setFechaInicio(Date date) {
		this.fechaInicio = date;
	}

	@Override
	public String toString() {
		return nombre;
	}
		
}
