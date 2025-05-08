package fiap.tds.resource;

import fiap.tds.dtos.LoginDTO;
import fiap.tds.dtos.UserDTO;
import fiap.tds.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class UserResource {

    @Inject
    UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
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
