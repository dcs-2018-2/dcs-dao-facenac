package br.pro.ramon.dcs.dao.facenac.usuarios;

import br.pro.ramon.dcs.dao.facenac.DaoException;
import br.pro.ramon.dcs.dao.facenac.DaoFactory;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UsuarioDaoCreateDeleteTest {

    private UsuarioDao usuarioDao;

    @Before
    public void setUp() {
        usuarioDao = DaoFactory.getUsuarioDao();
    }

    @Test
    public void testCreate() throws DaoException {
        // dados do novo usuário
        String nome = "Novo Usuário";
        String email = "novo.usuario@facenac.com.br";
        String senha = "novasenha";
        byte[] foto = null;

        // tenta encontrar o usuário que queremos cadastrar e verifica que não existe
        Usuario usuario = usuarioDao.findByEmail(email);
        assertThat(usuario, is(nullValue()));

        // cadastra usuário
        Long id = usuarioDao.create(nome, email, senha, foto);

        // tenta encontrar o usuário que cadastramos e verifica que existe
        usuario = usuarioDao.findByEmail(email);
        assertThat(usuario, is(notNullValue()));

        assertThat(usuario.getId(), is(id));
        assertThat(usuario.getNome(), is(nome));
        assertThat(usuario.getEmail(), is(email));
        assertThat(usuario.getSenha(), is(not(senha)));
        assertThat(usuario.getFoto(), is(foto));

        // vamos remover o usuário que acabamos de cadastrar
        usuarioDao.deleteByEmail(email);
    }

    @Test
    public void testDeleteByEmail() throws DaoException {
        // usuário que sabemos existir e que não tem historico, etc. (para podermos apagar)
        String nome = "Usuário X";
        String email = "usuarioX@facenac.com.br";
        String senha = "senhaX";
        byte[] foto = null;

        // tenta encontrar o usuário e verifica que existe
        Usuario usuario = usuarioDao.findByEmail(email);
        assertThat(usuario, is(notNullValue()));

        // remove usuário
        usuarioDao.deleteByEmail(email);

        // tenta encontrar o usuário novamente e verifica que não existe
        usuario = usuarioDao.findByEmail(email);
        assertThat(usuario, is(nullValue()));

        // vamos inserir o usuário novamente para que, na próxima vez que testarmos aqui, ele ainda exista!
        usuarioDao.create(nome, email, senha, foto);
    }

}
