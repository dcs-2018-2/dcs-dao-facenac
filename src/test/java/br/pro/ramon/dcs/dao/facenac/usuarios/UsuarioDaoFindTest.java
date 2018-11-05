package br.pro.ramon.dcs.dao.facenac.usuarios;

import br.pro.ramon.dcs.dao.facenac.DaoException;
import br.pro.ramon.dcs.dao.facenac.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UsuarioDaoFindTest {

    @Parameters(name = "{index}: email={0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            // usuários que existem
            {"usuario1@facenac.com.br", new Usuario(1L, "Usuário 1", "usuario1@facenac.com.br", "senha1", null)},
            {"usuario2@facenac.com.br", new Usuario(2L, "Usuário 2", "usuario2@facenac.com.br", "senha2", null)},
            {"usuario3@facenac.com.br", new Usuario(3L, "Usuário 3", "usuario3@facenac.com.br", "senha3", null)},
            {"usuario4@facenac.com.br", new Usuario(4L, "Usuário 4", "usuario4@facenac.com.br", "senha4", null)},
            // usuários que existem
            {"usuario5@facenac.com.br", null},
            {"usuario6@facenac.com.br", null}
        });
    }

    private String email;
    private Usuario usuarioEsperado;

    public UsuarioDaoFindTest(String email, Usuario usuarioEsperado) {
        this.email = email;
        this.usuarioEsperado = usuarioEsperado;
    }

    @Test
    public void testFindByEmail() throws DaoException {
        UsuarioDao usuarioDao = DaoFactory.getUsuarioDao();
        Usuario usuario = usuarioDao.findByEmail(email);

        if (usuarioEsperado == null) {
            assertThat(usuario, is(nullValue()));
        } else {
            assertThat(usuario.getId(), is(usuarioEsperado.getId()));
            assertThat(usuario.getNome(), is(usuarioEsperado.getNome()));
            assertThat(usuario.getEmail(), is(usuarioEsperado.getEmail()));
            assertThat(usuario.getSenha(), is(not(usuarioEsperado.getSenha())));
            assertThat(usuario.getFoto(), is(usuarioEsperado.getFoto()));
        }
    }

}
