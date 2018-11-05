package br.pro.ramon.dcs.dao.facenac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoJdbc {

    private String driver;
    private String url;
    private String user;
    private String pass;

    public DaoJdbc(String driver, String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    protected Connection getConnection() throws DaoException {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            throw new DaoException("Driver não encontrado!", ex);
        } catch (SQLException ex) {
            throw new DaoException("Erro ao obter a conexão!", ex);
        }
    }

}
