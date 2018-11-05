package br.pro.ramon.dcs.dao.facenac.usuarios;

import br.pro.ramon.dcs.dao.facenac.DaoException;
import br.pro.ramon.dcs.dao.facenac.DaoFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UsuarioResourceAutorizationTest {

    @Parameterized.Parameters(name = "{index}: email={0} senha={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            // login autorizado
            {"usuario1@facenac.com.br", "senha1", true},
            {"usuario2@facenac.com.br", "senha2", true},
            {"usuario3@facenac.com.br", "senha3", true},
            {"usuario4@facenac.com.br", "senha4", true},
            // email errado
            {"usuario5@facenac.com.br", "senha1", false},
            {"usuario6@facenac.com.br", "senha2", false},
            {"usuario7@facenac.com.br", "senha3", false},
            {"usuario8@facenac.com.br", "senha4", false},
            // senha errada
            {"usuario1@facenac.com.br", "senha5", false},
            {"usuario2@facenac.com.br", "senha6", false},
            {"usuario3@facenac.com.br", "senha7", false},
            {"usuario4@facenac.com.br", "senha8", false},
            // email e senha errados
            {"usuario5@facenac.com.br", "senha5", false},
            {"usuario6@facenac.com.br", "senha6", false},
            {"usuario7@facenac.com.br", "senha7", false},
            {"usuario8@facenac.com.br", "senha8", false}
        });
    }

    private String email;
    private String senha;
    private boolean autorizacaoEsperada;

    public UsuarioResourceAutorizationTest(String email, String senha, boolean autorizacaoEsperada) {
        this.email = email;
        this.senha = senha;
        this.autorizacaoEsperada = autorizacaoEsperada;
    }

    @Test
    public void testIsAutorizado() throws IOException {
        Resposta resposta = acessaWebService(email, senha);
        if (autorizacaoEsperada) {
            assertThat(resposta.saida, is("Autorizado"));
            assertThat(resposta.statusCode, is(200));
        } else {
            assertThat(resposta.saida, is("Não Autorizado"));
            assertThat(resposta.statusCode, is(401));
        }
    }

    private Resposta acessaWebService(String email, String senha) throws IOException {
        Response response = Jsoup.connect("http://localhost:8080/dcs-dao-facenac/webresources/usuarios/" + email + "/login")
                .data("senha", senha)
                .method(Method.POST)
                .ignoreHttpErrors(true)
                .execute();

        String saida = response.body();
        int statusCode = response.statusCode();

        return new Resposta(saida, statusCode);
    }

}
