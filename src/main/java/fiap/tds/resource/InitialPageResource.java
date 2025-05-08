package fiap.tds.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class InitialPageResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String infoSystem(){
        return "Bem-vindo ao sistema de alertas da CCR!,\n" +
                "Aqui os funcionários podem reportar e acompanhar ocorrências";
    }
}
