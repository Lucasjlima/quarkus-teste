package fiap.tds.resource;

import fiap.tds.dtos.GitHubDTO;
import fiap.tds.dtos.IntegrantesDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Path("/integrantes")
public class IntegrantesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIntegrantes() {
        var integrantes = List.of(
                new IntegrantesDTO("Eduardo Osterloh Bindo", "rm559755", "1TDSPA",
                        URI.create("https://www.linkedin.com/in/eduardo-osterloh-bindo-500b02268/")),
                new IntegrantesDTO("Lucas José Lima", "rm561160", "1TDSPA",
                        URI.create("https://www.linkedin.com/in/lucasjos%C3%A9lima/")),
                new IntegrantesDTO("Rangel Bernardi Jordão", "rm560547", "1TDSPA",
                        URI.create("https://www.linkedin.com/in/rangel-jord%C3%A3o-819334234/"))
        );

        var githubDTO = new GitHubDTO(URI.create("https://github.com/signalProteam"));

        return Response.ok(Map.of("github", githubDTO, "integrantes", integrantes)).build();

    }
}
