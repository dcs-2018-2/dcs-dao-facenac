package br.pro.ramon.dcs.dao.facenac.historico;

import br.pro.ramon.dcs.dao.facenac.DaoException;
import br.pro.ramon.dcs.dao.facenac.DaoJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoriaDaoJdbc extends DaoJdbc implements HistoriaDao {

    private static final int TAMANHO_PAGINA_DEFAULT = 10;

    private int tamanhoPagina;

    public HistoriaDaoJdbc(String driver, String url, String user, String pass) {
        super(driver, url, user, pass);
        this.tamanhoPagina = TAMANHO_PAGINA_DEFAULT;
    }

    @Override
    public int getTamanhoDaPagina() throws DaoException {
        throw new UnsupportedOperationException("Você precisa criar o método getTamanhoDaPagina.");
    }

    @Override
    public void setTamanhoPagina(int tamanhoPagina) throws DaoException {
        throw new UnsupportedOperationException("Você precisa criar o método setTamanhoPagina.");
    }

    @Override
    public int getTotalPaginas(Long usuarioId) throws DaoException {
        throw new UnsupportedOperationException("Você precisa criar o método getTotalPaginas.");
    }

    @Override
    public List<Historia> findByUsuario(Long usuarioId, int pagina) throws DaoException {
        throw new UnsupportedOperationException("Você precisa criar o método findByUsuario.");
    }

}
