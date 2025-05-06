package fiap.tds.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
//Dentro de resources sao as rotas para as paginas web
@Path("/evento")
public class EventoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test(){
        return ("HELLO");
    }
}
