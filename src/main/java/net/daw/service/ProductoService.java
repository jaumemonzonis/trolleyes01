package net.daw.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import net.daw.bean.ReplyBean;
import net.daw.bean.UsuarioBean;
import net.daw.bean.ProductoBean;
import net.daw.connection.publicinterface.ConnectionInterface;
import net.daw.constant.ConnectionConstants;
import net.daw.dao.ProductoDao;
import net.daw.dao.UsuarioDao;
import net.daw.factory.ConnectionFactory;
import net.daw.helper.EncodingHelper;

public class ProductoService {

	HttpServletRequest oRequest;
	String ob = null;

	public ProductoService(HttpServletRequest oRequest) {
		super();
		this.oRequest = oRequest;
		ob = oRequest.getParameter("ob");
	}

	public ReplyBean get() throws Exception {
		ReplyBean oReplyBean;
		ConnectionInterface oConnectionPool = null;
		Connection oConnection;
		try {
			Integer id = Integer.parseInt(oRequest.getParameter("id"));
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			ProductoDao oProductoDao = new ProductoDao(oConnection, ob);
			ProductoBean oProductoBean = oProductoDao.get(id);
			Gson oGson = new Gson();
			oReplyBean = new ReplyBean(200, oGson.toJson(oProductoBean));
		} catch (Exception ex) {
			oReplyBean = new ReplyBean(500,
					"ERROR: " + EncodingHelper.escapeQuotes(EncodingHelper.escapeLine(ex.getMessage())));
		} finally {
			oConnectionPool.disposeConnection();
		}

		return oReplyBean;

	}

	public ReplyBean remove() throws Exception {
		ReplyBean oReplyBean;
		ConnectionInterface oConnectionPool = null;
		Connection oConnection;
		try {
			Integer id = Integer.parseInt(oRequest.getParameter("id"));
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			ProductoDao oProductoDao = new ProductoDao(oConnection, ob);
			int iRes = oProductoDao.remove(id);
			oReplyBean = new ReplyBean(200, Integer.toString(iRes));
		} catch (Exception ex) {
			oReplyBean = new ReplyBean(500,
					"ERROR: " + EncodingHelper.escapeQuotes(EncodingHelper.escapeLine(ex.getMessage())));
		} finally {
			oConnectionPool.disposeConnection();
		}
		return oReplyBean;

	}

	public ReplyBean getcount() throws Exception {
		ReplyBean oReplyBean;
		ConnectionInterface oConnectionPool = null;
		Connection oConnection;
		try {
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			ProductoDao oProductoDao = new ProductoDao(oConnection, ob);
			int registros = oProductoDao.getcount();
			Gson oGson = new Gson();
			oReplyBean = new ReplyBean(200, oGson.toJson(registros));
		} catch (Exception ex) {
			oReplyBean = new ReplyBean(500,
					"ERROR: " + EncodingHelper.escapeQuotes(EncodingHelper.escapeLine(ex.getMessage())));
		} finally {
			oConnectionPool.disposeConnection();
		}

		return oReplyBean;

	}

	public ReplyBean create() throws Exception {
		ReplyBean oReplyBean;
		ConnectionInterface oConnectionPool = null;
		Connection oConnection;
		try {
			String strJsonFromClient = oRequest.getParameter("json");
			Gson oGson = new Gson();
			ProductoBean oProductoBean = new ProductoBean();
			oProductoBean = oGson.fromJson(strJsonFromClient, ProductoBean.class);
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			ProductoDao oProductoDao = new ProductoDao(oConnection, ob);
			oProductoBean = oProductoDao.create(oProductoBean);
			oReplyBean = new ReplyBean(200, oGson.toJson(oProductoBean));
		} catch (Exception ex) {
			oReplyBean = new ReplyBean(500,
					"ERROR: " + EncodingHelper.escapeQuotes(EncodingHelper.escapeLine(ex.getMessage())));
		} finally {
			oConnectionPool.disposeConnection();
		}
		return oReplyBean;
	}

	public ReplyBean update() throws Exception {
		int iRes = 0;
		ReplyBean oReplyBean = null;
		ConnectionInterface oConnectionPool = null;
		Connection oConnection;
		try {
			String strJsonFromClient = oRequest.getParameter("json");
			Gson oGson = new Gson();
			ProductoBean oProductoBean = new ProductoBean();
			oProductoBean = oGson.fromJson(strJsonFromClient, ProductoBean.class);
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			ProductoDao oProductoDao = new ProductoDao(oConnection, ob);
			iRes = oProductoDao.update(oProductoBean);
			oReplyBean.setStatus(200);
			oReplyBean.setJson(Integer.toString(iRes));
		} catch (Exception ex) {
			oReplyBean = new ReplyBean(500,
					"ERROR: " + EncodingHelper.escapeQuotes(EncodingHelper.escapeLine(ex.getMessage())));
		} finally {
			oConnectionPool.disposeConnection();
		}
		return oReplyBean;
	}

	public ReplyBean getpage() throws Exception {
		ReplyBean oReplyBean;
		ConnectionInterface oConnectionPool = null;
		Connection oConnection;
		try {
			Integer iRpp = Integer.parseInt(oRequest.getParameter("rpp"));
			Integer iPage = Integer.parseInt(oRequest.getParameter("page"));
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			ProductoDao oProductoDao = new ProductoDao(oConnection, ob);
			ArrayList<ProductoBean> alProductoBean = oProductoDao.getpage(iRpp, iPage);
			Gson oGson = new Gson();
			oReplyBean = new ReplyBean(200, oGson.toJson(alProductoBean));
		} catch (Exception ex) {
			oReplyBean = new ReplyBean(500,
					"ERROR: " + EncodingHelper.escapeQuotes(EncodingHelper.escapeLine(ex.getMessage())));
		} finally {
			oConnectionPool.disposeConnection();
		}

		return oReplyBean;

	}

	public ReplyBean fill() throws Exception {
		ReplyBean oReplyBean;
		ConnectionInterface oConnectionPool = null;
		Connection oConnection;
		try {
			Integer number = Integer.parseInt(oRequest.getParameter("number"));
			Gson oGson = new Gson();
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			ProductoDao oProductoDao = new ProductoDao(oConnection, ob);
			ProductoBean oProductoBean = new ProductoBean();
			for (int i = 1; i <= number; i++) {			

				// rellenar CODIGO 5 numeros
				String codigo = String.valueOf((int) (100000 * Math.random()));
				oProductoBean.setCodigo(codigo);
				
				String[] desc1 = { "Util", "utensilio", "aparejo", "instrumento", "aparato", "artefacto", "material",
						"trebejo", "mecanismo", "chirimbolo" };
				
				String[] desc2 = { "Util", "utensilio", "aparejo", "instrumento", "aparato", "artefacto", "material",
						"trebejo", "mecanismo", "chirimbolo" };
				
				//String[] desc2 = {"acerado","afilado","agudo","aguzado","cortante","dinamico","automatico","movil","tactil","maciza"};
				
				
				
				String[] desc3 = {"para cortar","para romper","para unir","para copiar","para untar","para colar","para diseñar","para corrosionar","para digitalizar","para mezclar"};
				
				String desc1union = desc1[(int) (Math.random() * 10) + 1];
				String desc2union = desc2[(int) (Math.random() * 10) + 1];
				String desc3union = desc3[(int) (Math.random() * 10) + 1];
				String desc = desc1union + " " + desc2union + " " + desc3union;
				oProductoBean.setDesc(desc);

				// rellenar EXISTENCIAS
				Integer existencias = (int) (Math.random() * 20) + 1;
				oProductoBean.setExistencias(existencias);
				
				// rellenar PRECIO
				Float precio = (float) (Math.random() * 10) + 1;
				oProductoBean.setPrecio(precio);
				
				// rellenar FOTO
				String[] listaFotos = { "Estandar", "Formato DNI", "No disponible", "Disponible" };
				int posicion = (int) (Math.random() * listaFotos.length);
				String foto = listaFotos[posicion];
				oProductoBean.setFoto(foto);
				
				// rellenar ID_TIPOPRODUCTO
				Random generadorAleatorios = new Random();
				Integer id_tipoProducto = 1 + generadorAleatorios.nextInt(2);
				oProductoBean.setId_tipoProducto(id_tipoProducto);
				
				oProductoBean = oProductoDao.create(oProductoBean);
			}
			oReplyBean = new ReplyBean(200, oGson.toJson(number));
		} catch (Exception ex) {
			throw new Exception("ERROR: Service level: create method: " + ob + " object", ex);
		} finally {
			oConnectionPool.disposeConnection();
		}
		return oReplyBean;
}
}