package fiap.tds.resource;

import fiap.tds.dtos.UserDTO;
import fiap.tds.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
public class UserRegisterResource {

    @Inject
    UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(UserDTO userDTO){
        userService.register(userDTO);
        return Response.status(Response.Status.CREATED).entity("Usuário cadastrado com sucesso!").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") Long id, UserDTO userDTO){
        userService.updateUser(id, userDTO);
        return Response.ok("Usuário foi atualizado com sucesso!").build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") Long id){
        var user = userService.findById(id);
        return Response.ok(user.username).build();
    }
}
