package fiap.tds.resource;

import fiap.tds.dtos.HelpEventDTO;
import fiap.tds.dtos.TypeEventDTO;
import fiap.tds.models.Status;
import fiap.tds.models.TypeEvent;
import fiap.tds.repositores.EventRepository;
import fiap.tds.services.EventService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Path("/solicitar-ajuda")
public class SolicitHelpResource {
    @Inject
    EventService eventService;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HelpEventDTO> listEvents(){
        var events = eventService.getAllEvents();
        var eventsFiltered = events.stream()
                .filter(e-> e.getStatus().equals(Status.EM_ANDAMENTO))
                .toList();
        return eventsFiltered.stream()
                .map(e -> new HelpEventDTO( e.getTypeEvent().name(), e.getPosition(), e.getStatus()))
                .collect(Collectors.toList());
    }

    //I need to create a PUT method to update the status of some event to AJUDA_SOLICITADA
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response requestHelp(@PathParam("id") Long id){
        eventService.requestHelp(id);
        return Response.status(Response.Status.OK).entity("Ajuda solicitada com sucesso!").build();
    }

}
