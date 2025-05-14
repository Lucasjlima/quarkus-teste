package fiap.tds.resource;

import fiap.tds.dtos.EventDTO;
import fiap.tds.services.EventService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/reportar-evento")
public class EventResource {

    @Inject
    EventService eventService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response reportEvent(EventDTO eventDTO){
        eventService.reportEvent(eventDTO);
        return Response.status(Response.Status.CREATED).entity("Evento reportado com sucesso!").build();
    }
}
