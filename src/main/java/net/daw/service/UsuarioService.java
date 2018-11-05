package net.daw.service;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import net.daw.bean.ReplyBean;
import net.daw.bean.UsuarioBean;
import net.daw.connection.publicinterface.ConnectionInterface;
import net.daw.constant.ConnectionConstants;
import net.daw.dao.UsuarioDao;
import net.daw.factory.ConnectionFactory;
import net.daw.helper.EncodingHelper;

public class UsuarioService {

	HttpServletRequest oRequest;
	String ob = null;

	public UsuarioService(HttpServletRequest oRequest) {
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
			UsuarioDao oUsuarioDao = new UsuarioDao(oConnection, ob);
			UsuarioBean oUsuarioBean = oUsuarioDao.get(id);
			Gson oGson = new Gson();
			oReplyBean = new ReplyBean(200, oGson.toJson(oUsuarioBean));
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
			UsuarioDao oUsuarioDao = new UsuarioDao(oConnection, ob);
			int iRes = oUsuarioDao.remove(id);
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
			UsuarioDao oUsuarioDao = new UsuarioDao(oConnection, ob);
			int registros = oUsuarioDao.getcount();
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
			UsuarioBean oUsuarioBean = new UsuarioBean();
			oUsuarioBean = oGson.fromJson(strJsonFromClient, UsuarioBean.class);
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			UsuarioDao oUsuarioDao = new UsuarioDao(oConnection, ob);
			oUsuarioBean = oUsuarioDao.create(oUsuarioBean);
			oReplyBean = new ReplyBean(200, oGson.toJson(oUsuarioBean));
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
			UsuarioBean oUsuarioBean = new UsuarioBean();
			oUsuarioBean = oGson.fromJson(strJsonFromClient, UsuarioBean.class);
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			UsuarioDao oUsuarioDao = new UsuarioDao(oConnection, ob);
			iRes = oUsuarioDao.update(oUsuarioBean);
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
			String iCampo = oRequest.getParameter("campo");
			String iOrder = oRequest.getParameter("orden");
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			UsuarioDao oUsuarioDao = new UsuarioDao(oConnection, ob);
			ArrayList<UsuarioBean> alUsuarioBean = oUsuarioDao.getpage(iRpp, iPage, iCampo, iOrder);
			Gson oGson = new Gson();
			oReplyBean = new ReplyBean(200, oGson.toJson(alUsuarioBean));
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
			UsuarioDao oUsuarioDao = new UsuarioDao(oConnection, ob);
			UsuarioBean oUsuarioBean = new UsuarioBean();
			for (int i = 1; i <= number; i++) {			
				oUsuarioBean.setDni("765934875A");
				oUsuarioBean.setNombre("Rigoberto");
				oUsuarioBean.setApe1("P�rez");
				oUsuarioBean.setApe2("G�mez");
				oUsuarioBean.setLogin("ripego");
				oUsuarioBean.setPass("hola");
				oUsuarioBean.setId_tipoUsuario(5);
				oUsuarioBean = oUsuarioDao.create(oUsuarioBean);
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
