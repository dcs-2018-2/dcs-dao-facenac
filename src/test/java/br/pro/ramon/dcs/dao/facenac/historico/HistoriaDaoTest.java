package br.pro.ramon.dcs.dao.facenac.historico;

import br.pro.ramon.dcs.dao.facenac.DaoException;
import br.pro.ramon.dcs.dao.facenac.DaoFactory;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class HistoriaDaoTest {

    @Test
    public void testFindByUsuario() throws DaoException {
        Long usuario = 1L;
        int tamanhoPagina = 9;

        HistoriaDao historiaDao = DaoFactory.getHistoriaDao();
        historiaDao.setTamanhoPagina(tamanhoPagina);

        int quantidadePaginas = historiaDao.getTotalPaginas(usuario);
        assertThat(quantidadePaginas, is(4));

        int pagina = 1;
        List<Historia> pagina1 = historiaDao.findByUsuario(usuario, pagina);
        assertThat(pagina1.size(), is(tamanhoPagina));
        assertThat(pagina1.get(0).getTexto(), is("Texto 29 do usuário 1"));
        assertThat(pagina1.get(1).getTexto(), is("Texto 28 do usuário 1"));
        assertThat(pagina1.get(2).getTexto(), is("Texto 27 do usuário 1"));
        assertThat(pagina1.get(3).getTexto(), is("Texto 26 do usuário 1"));
        assertThat(pagina1.get(4).getTexto(), is("Texto 25 do usuário 1"));
        assertThat(pagina1.get(5).getTexto(), is("Texto 24 do usuário 1"));
        assertThat(pagina1.get(6).getTexto(), is("Texto 23 do usuário 1"));
        assertThat(pagina1.get(7).getTexto(), is("Texto 22 do usuário 1"));
        assertThat(pagina1.get(8).getTexto(), is("Texto 21 do usuário 1"));

        pagina = 2;
        List<Historia> pagina2 = historiaDao.findByUsuario(usuario, pagina);
        assertThat(pagina2.size(), is(tamanhoPagina));
        assertThat(pagina2.get(0).getTexto(), is("Texto 20 do usuário 1"));
        assertThat(pagina2.get(1).getTexto(), is("Texto 19 do usuário 1"));
        assertThat(pagina2.get(2).getTexto(), is("Texto 18 do usuário 1"));
        assertThat(pagina2.get(3).getTexto(), is("Texto 17 do usuário 1"));
        assertThat(pagina2.get(4).getTexto(), is("Texto 16 do usuário 1"));
        assertThat(pagina2.get(5).getTexto(), is("Texto 15 do usuário 1"));
        assertThat(pagina2.get(6).getTexto(), is("Texto 14 do usuário 1"));
        assertThat(pagina2.get(7).getTexto(), is("Texto 13 do usuário 1"));
        assertThat(pagina2.get(8).getTexto(), is("Texto 12 do usuário 1"));

        pagina = 3;
        List<Historia> pagina3 = historiaDao.findByUsuario(usuario, pagina);
        assertThat(pagina3.size(), is(tamanhoPagina));
        assertThat(pagina3.get(0).getTexto(), is("Texto 11 do usuário 1"));
        assertThat(pagina3.get(1).getTexto(), is("Texto 10 do usuário 1"));
        assertThat(pagina3.get(2).getTexto(), is("Texto 9 do usuário 1"));
        assertThat(pagina3.get(3).getTexto(), is("Texto 8 do usuário 1"));
        assertThat(pagina3.get(4).getTexto(), is("Texto 7 do usuário 1"));
        assertThat(pagina3.get(5).getTexto(), is("Texto 6 do usuário 1"));
        assertThat(pagina3.get(6).getTexto(), is("Texto 5 do usuário 1"));
        assertThat(pagina3.get(7).getTexto(), is("Texto 4 do usuário 1"));
        assertThat(pagina3.get(8).getTexto(), is("Texto 3 do usuário 1"));

        pagina = 4;
        List<Historia> pagina4 = historiaDao.findByUsuario(usuario, pagina);
        assertThat(pagina4.size(), is(2));
        assertThat(pagina4.get(0).getTexto(), is("Texto 2 do usuário 1"));
        assertThat(pagina4.get(1).getTexto(), is("Texto 1 do usuário 1"));
    }

}
