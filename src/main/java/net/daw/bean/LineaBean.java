package net.daw.bean;

import com.google.gson.annotations.Expose;

public class LineaBean {
	@Expose
	private int id;
	@Expose
	private int cantidad;
	@Expose(serialize=false)
	private int id_producto;
	@Expose(deserialize=false)
    private ProductoBean obj_Producto;
	@Expose(serialize=false)
	private int id_factura;
	@Expose(deserialize=false)
    private FacturaBean obj_Factura;
	
	public ProductoBean getObj_Producto() {
		return obj_Producto;
	}
	public void setObj_Producto(ProductoBean obj_Producto) {
		this.obj_Producto = obj_Producto;
	}
	public FacturaBean getObj_Factura() {
		return obj_Factura;
	}
	public void setObj_Factura(FacturaBean obj_Factura) {
		this.obj_Factura = obj_Factura;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public int getId_factura() {
		return id_factura;
	}
	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

}
