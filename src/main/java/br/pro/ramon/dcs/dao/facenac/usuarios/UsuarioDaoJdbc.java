package br.pro.ramon.dcs.dao.facenac.usuarios;

import br.pro.ramon.dcs.dao.facenac.DaoException;
import br.pro.ramon.dcs.dao.facenac.DaoJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDaoJdbc extends DaoJdbc implements UsuarioDao {

    public UsuarioDaoJdbc(String driver, String url, String user, String pass) {
        super(driver, url, user, pass);
    }

    @Override
    public Long create(String nome, String email, String senha, byte[] foto) throws DaoException {
        throw new UnsupportedOperationException("Você precisa criar o método create.");
    }

    @Override
    public Usuario findByEmail(String email) throws DaoException {
        throw new UnsupportedOperationException("Você precisa criar o método findByEmail.");
    }

    @Override
    public boolean isAutorizado(String email, String senha) throws DaoException {
        throw new UnsupportedOperationException("Você precisa criar o método isAutorizado.");
    }

    @Override
    public boolean deleteByEmail(String email) throws DaoException {
        throw new UnsupportedOperationException("Você precisa criar o método deleteByEmail.");
    }

}
