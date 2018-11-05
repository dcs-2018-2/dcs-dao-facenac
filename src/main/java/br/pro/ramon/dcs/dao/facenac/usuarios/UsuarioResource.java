package br.pro.ramon.dcs.dao.facenac.usuarios;

import br.pro.ramon.dcs.dao.facenac.DaoException;
import br.pro.ramon.dcs.dao.facenac.DaoFactory;
import java.net.URI;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

@Path("/usuarios")
public class UsuarioResource {

    @POST
    public Response post(@FormParam("nome") String nome, @FormParam("email") String email, @FormParam("senha") String senha) {
        throw new UnsupportedOperationException("Você precisa criar o método post.");
    }

    @POST
    @Path("/{email}/login")
    public Response isAutorizado(@PathParam("email") String email, @FormParam("senha") String senha) {
        throw new UnsupportedOperationException("Você precisa criar o método isAutorizado.");
    }

    @DELETE
    @Path("/{email}")
    public Response delete(@PathParam("email") String email) {
        throw new UnsupportedOperationException("Você precisa criar o método delete.");
    }
}
