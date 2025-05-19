package fiap.tds.resource;

import fiap.tds.dtos.EventDTO;
import fiap.tds.dtos.TypeEventDTO;
import fiap.tds.models.TypeEvent;
import fiap.tds.services.EventService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeEventDTO> listarTiposEvento() {
        return Arrays.stream(TypeEvent.values())
                .map(t -> new TypeEventDTO(t.name(), t.getCargoResponsavel()))
                .collect(Collectors.toList());
    }


}
