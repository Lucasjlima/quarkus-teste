package fiap.tds.resource;

import fiap.tds.dtos.LoginDTO;
import fiap.tds.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

@Path("/login")
public class LoginResource {

    @Inject
    UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDTO loginDTO) {
        boolean success = userService.login(loginDTO.getUsername(), loginDTO.getPassword());
        if (success) {
            // Obtém o cargo do usuário
            String cargo = userService.getCargo(loginDTO.getUsername());

            // Cria um mapa com o cargo para retornar como JSON
            Map<String, String> resposta = new HashMap<>();
            resposta.put("cargo", cargo);

            return Response.ok(resposta).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Credenciais inválidas!").build();
        }
    }

}


