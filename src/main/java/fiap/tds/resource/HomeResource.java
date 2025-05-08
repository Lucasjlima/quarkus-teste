package fiap.tds.resource;

import fiap.tds.dtos.HomeDTO;
import fiap.tds.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ccr-alertas")
public class HomeResource {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response showHome(@QueryParam("username") String username){
        var name = userService.searchUserName(username);
        if(name == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado!").build();
        }
        HomeDTO homeDTO = new HomeDTO();
        homeDTO.message = "Bem-Vindo ao site de alertas da CCR!";
        homeDTO.user = name;
        return Response.ok(homeDTO).build();
    }
}
