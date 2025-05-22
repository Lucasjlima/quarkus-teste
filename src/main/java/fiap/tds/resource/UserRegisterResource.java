package fiap.tds.resource;

import fiap.tds.dtos.UserDTO;
import fiap.tds.dtos.UserReponseDTO;
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
    public Response register(UserDTO userDTO) {
        userService.register(userDTO);
        return Response.status(Response.Status.CREATED).entity("Usuário cadastrado com sucesso!").build();
    }


    //I'll test this another variation of the update method
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") Long id, UserDTO userDTO) {
        userService.updateUser(id, userDTO);
        return Response.ok("Usuário foi atualizado com sucesso!").build();
    }



    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        var user = userService.findById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        var response = new UserReponseDTO(user.getUsername(), user.getPosition());
        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") Long id) {
        var user = userService.deleteById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        var response = new UserReponseDTO(user.getUsername(), user.getPosition());
        return Response.noContent().entity(response).build();
    }
}
