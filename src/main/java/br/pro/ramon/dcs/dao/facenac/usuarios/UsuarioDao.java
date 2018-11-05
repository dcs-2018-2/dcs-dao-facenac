package br.pro.ramon.dcs.dao.facenac.usuarios;

import br.pro.ramon.dcs.dao.facenac.DaoException;

public interface UsuarioDao {

    Long create(String nome, String email, String senha, byte[] foto) throws DaoException;

    Usuario findByEmail(String email) throws DaoException;

    boolean isAutorizado(String email, String senha) throws DaoException;

    boolean deleteByEmail(String email) throws DaoException;

}
