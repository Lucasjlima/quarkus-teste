package fiap.tds.resource;

import fiap.tds.dtos.LoginDTO;
import fiap.tds.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class UserResource {

    @Inject
    UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginDTO loginDTO) {
        boolean sucess = userService.login(loginDTO.username, loginDTO.password );
        if (sucess) {
            return Response.ok("Login efetuado com sucesso!").build();
        }
        else{
            return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciais inválidas!").build();
        }
    }
}
