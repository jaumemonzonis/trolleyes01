package net.daw.bean;

import java.util.Date;

import com.google.gson.annotations.Expose;

public class FacturaBean {
	@Expose
	private int id;
	@Expose
	private Date fecha;
	@Expose
	private float iva;
	@Expose(serialize=false)
	private int id_usuario;
	@Expose(deserialize=false)
    private UsuarioBean obj_Usuario;
	
	
	public UsuarioBean getObj_Usuario() {
		return obj_Usuario;
	}
	public void setObj_Usuario(UsuarioBean obj_Usuario) {
		this.obj_Usuario = obj_Usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getIva() {
		return iva;
	}
	public void setIva(float iva) {
		this.iva = iva;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

}
