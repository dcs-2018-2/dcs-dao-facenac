package br.pro.ramon.dcs.dao.facenac;

import br.pro.ramon.dcs.dao.facenac.historico.HistoriaDao;
import br.pro.ramon.dcs.dao.facenac.historico.HistoriaDaoJdbc;
import br.pro.ramon.dcs.dao.facenac.usuarios.UsuarioDao;
import br.pro.ramon.dcs.dao.facenac.usuarios.UsuarioDaoJdbc;

public abstract class DaoFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/facenac?serverTimezone=America/Sao_Paulo";
    private static final String USER = "root";
    private static final String PASS = "";

    public static UsuarioDao getUsuarioDao() {
        throw new UnsupportedOperationException("Você precisa criar o método getUsuarioDao.");
    }

    public static HistoriaDao getHistoriaDao() {
        throw new UnsupportedOperationException("Você precisa criar o método getHistoriaDao.");
    }

}
