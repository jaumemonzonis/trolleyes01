package net.daw.service;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import net.daw.bean.ReplyBean;
import net.daw.bean.TipousuarioBean;
import net.daw.connection.publicinterface.ConnectionInterface;
import net.daw.constant.ConnectionConstants;
import net.daw.dao.TipousuarioDao;
import net.daw.factory.ConnectionFactory;
import net.daw.helper.EncodingHelper;

public class TipousuarioService {

	HttpServletRequest oRequest ;
	
	
	public TipousuarioService(HttpServletRequest oRequest) {
		super();
		this.oRequest = oRequest;
	}


	public ReplyBean get() throws Exception {
		ReplyBean oReplyBean;
		ConnectionInterface oConnectionPool = null;
		Connection oConnection ;
		try {
			Integer id = Integer.parseInt(oRequest.getParameter("id"));
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			TipousuarioDao oTipousuarioDao=new TipousuarioDao(oConnection);
			TipousuarioBean oTipousuarioBean = oTipousuarioDao.get(id);
			Gson oGson = new Gson();
			oReplyBean = new ReplyBean(200, oGson.toJson(oTipousuarioBean));
		} catch (Exception ex) {
			oReplyBean = new ReplyBean(500, "Bad Connection: " + EncodingHelper.escapeQuotes(EncodingHelper.escapeLine(ex.getMessage())));
		} finally {
			oConnectionPool.disposeConnection();
		}

		return oReplyBean;

	}
	public ReplyBean remove() throws Exception {
		ReplyBean oReplyBean;
		ConnectionInterface oConnectionPool = null;
		Connection oConnection ;
		try {
			Integer id = Integer.parseInt(oRequest.getParameter("id"));
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			TipousuarioDao oTipousuarioDao=new TipousuarioDao(oConnection);
			//TipousuarioBean oTipousuarioBean = oTipousuarioDao.remove(id);
                        boolean oTipousuarioBean = oTipousuarioDao.remove(id);
                        
			Gson oGson = new Gson();
			oReplyBean = new ReplyBean(200, oGson.toJson(oTipousuarioBean));
		} catch (Exception ex) {
			oReplyBean = new ReplyBean(500, "Bad Connection: " + EncodingHelper.escapeQuotes(EncodingHelper.escapeLine(ex.getMessage())));
		} finally {
			oConnectionPool.disposeConnection();
		}

		return oReplyBean;

	}
        	public ReplyBean getCount() throws Exception {
		ReplyBean oReplyBean;
		ConnectionInterface oConnectionPool = null;
		Connection oConnection ;
		try {
			//Integer id = Integer.parseInt(oRequest.getParameter("id"));
			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
			oConnection = oConnectionPool.newConnection();
			TipousuarioDao oTipousuarioDao=new TipousuarioDao(oConnection);
			//TipousuarioBean oTipousuarioBean = oTipousuarioDao.remove(id);
                        int oTipousuarioBean = oTipousuarioDao.getCount();
                        
			Gson oGson = new Gson();
			oReplyBean = new ReplyBean(200, oGson.toJson(oTipousuarioBean));
		} catch (Exception ex) {
			oReplyBean = new ReplyBean(500, "Bad Connection: " + EncodingHelper.escapeQuotes(EncodingHelper.escapeLine(ex.getMessage())));
		} finally {
			oConnectionPool.disposeConnection();
		}

		return oReplyBean;

	}
        	public ReplyBean  insert() throws Exception {
        		ReplyBean oReplyBean;
        		ConnectionInterface oConnectionPool = null;
        		Connection oConnection ;
        		try {
        			//Integer id = Integer.parseInt(oRequest.getParameter("id"));
        
        			String desc = oRequest.getParameter("desc");
        			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
        			oConnection = oConnectionPool.newConnection();
        			TipousuarioDao oTipousuarioDao=new TipousuarioDao(oConnection);
        			//TipousuarioBean oTipousuarioBean = oTipousuarioDao.remove(id);
                     boolean oTipousuarioBean = oTipousuarioDao.insert(desc);
                                
        			Gson oGson = new Gson();
        			oReplyBean = new ReplyBean(200, oGson.toJson(oTipousuarioBean));
        		} catch (Exception ex) {
        			oReplyBean = new ReplyBean(500, "Bad Connection: " + EncodingHelper.escapeQuotes(EncodingHelper.escapeLine(ex.getMessage())));
        		} finally {
        			oConnectionPool.disposeConnection();
        		}

        		return oReplyBean;

        	}
        	public ReplyBean delete() throws Exception {
        		ReplyBean oReplyBean;
        		ConnectionInterface oConnectionPool = null;
        		Connection oConnection ;
        		try {
        			Integer id = Integer.parseInt(oRequest.getParameter("id"));
        			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
        			oConnection = oConnectionPool.newConnection();
        			TipousuarioDao oTipousuarioDao=new TipousuarioDao(oConnection);

                    boolean oTipousuarioBean = oTipousuarioDao.delete(id);
                                
        			Gson oGson = new Gson();
        			oReplyBean = new ReplyBean(200, oGson.toJson(oTipousuarioBean));
        		} catch (Exception ex) {
        			oReplyBean = new ReplyBean(500, "Bad Connection: " + EncodingHelper.escapeQuotes(EncodingHelper.escapeLine(ex.getMessage())));
        		} finally {
        			oConnectionPool.disposeConnection();
        		}

        		return oReplyBean;

        	}
        	
        	public ReplyBean update() throws Exception {
        		ReplyBean oReplyBean;
        		ConnectionInterface oConnectionPool = null;
        		Connection oConnection ;
        		try {
        			Integer id = Integer.parseInt(oRequest.getParameter("id"));
        			String desc = oRequest.getParameter("desc");
        			oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
        			oConnection = oConnectionPool.newConnection();
        			TipousuarioDao oTipousuarioDao=new TipousuarioDao(oConnection);

                    boolean oTipousuarioBean = oTipousuarioDao.update(id,desc);
                                
        			Gson oGson = new Gson();
        			oReplyBean = new ReplyBean(200, oGson.toJson(oTipousuarioBean));
        		} catch (Exception ex) {
        			oReplyBean = new ReplyBean(500, "Bad Connection: " + EncodingHelper.escapeQuotes(EncodingHelper.escapeLine(ex.getMessage())));
        		} finally {
        			oConnectionPool.disposeConnection();
        		}

        		return oReplyBean;

        	}
}
