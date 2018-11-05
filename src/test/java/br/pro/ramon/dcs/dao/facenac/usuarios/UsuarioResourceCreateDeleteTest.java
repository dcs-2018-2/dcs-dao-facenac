package br.pro.ramon.dcs.dao.facenac.usuarios;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class UsuarioResourceCreateDeleteTest {

    @Test
    public void testCreateDelete() throws IOException {
        // dados do novo usuário
        String nome = "Novo Usuário";
        String email = "novo.usuario@facenac.com.br";
        String senha = "novasenha";

        // cadastra usuário
        Resposta resposta = acessaWebServiceComPost(nome, email, senha);
        assertThat(resposta.saida, is(""));
        assertThat(resposta.statusCode, is(201)); // https://httpstatuses.com/201
        assertThat(resposta.location, startsWith("http://localhost:8080/dcs-dao-facenac/webresources/usuarios/"));

        // vamos remover o usuário que acabamos de cadastrar
        resposta = acessaWebServiceComDelete(email);
        assertThat(resposta.saida, is(""));
        assertThat(resposta.statusCode, is(200)); // https://httpstatuses.com/200
    }

    @Test
    public void testDeleteUsuarioNaoExistente() throws IOException {
        // dados do usuário que sabemos não existir
        String email = "usuario-nao-existente@facenac.com.br";

        // tenta remover o usuário
        Resposta resposta = acessaWebServiceComDelete(email);
        assertThat(resposta.saida, is(""));
        assertThat(resposta.statusCode, is(404)); // https://httpstatuses.com/404
    }

    private Resposta acessaWebServiceComPost(String nome, String email, String senha) throws IOException {
        Response response = Jsoup.connect("http://localhost:8080/dcs-dao-facenac/webresources/usuarios")
                .data("nome", nome)
                .data("email", email)
                .data("senha", senha)
                .method(Method.POST)
                .ignoreHttpErrors(true)
                .followRedirects(false)
                .execute();

        String saida = response.body();
        int statusCode = response.statusCode();
        String location = response.header("Location");

        return new Resposta(saida, statusCode, location);
    }

    private Resposta acessaWebServiceComDelete(String email) throws IOException {
        Response response = Jsoup.connect("http://localhost:8080/dcs-dao-facenac/webresources/usuarios/" + email)
                .method(Method.DELETE)
                .ignoreHttpErrors(true)
                .execute();

        String saida = response.body();
        int statusCode = response.statusCode();

        return new Resposta(saida, statusCode);
    }

}
