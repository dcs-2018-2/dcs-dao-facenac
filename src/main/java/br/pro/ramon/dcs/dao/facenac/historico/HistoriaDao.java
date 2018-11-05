package br.pro.ramon.dcs.dao.facenac.historico;

import br.pro.ramon.dcs.dao.facenac.DaoException;
import java.util.List;

public interface HistoriaDao {

    int getTamanhoDaPagina() throws DaoException;

    void setTamanhoPagina(int tamanhoPagina) throws DaoException;

    int getTotalPaginas(Long usuarioId) throws DaoException;

    List<Historia> findByUsuario(Long usuarioId, int pagina) throws DaoException;

}
