package fiap.tds.resource;

import fiap.tds.dtos.HelpEventDTO;
import fiap.tds.dtos.TypeEventDTO;
import fiap.tds.models.Status;
import fiap.tds.models.TypeEvent;
import fiap.tds.services.EventService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Path("/solicitar-ajuda")
public class SolicitHelpResource {
    @Inject
    EventService eventService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //This method will return the list of events that only has the status EM_ANDAMENTO
    //and the position that is responsible for the event
    /*
    public List<HelpEventDTO> getAllEvents() {
        var events = eventService.getAllEvents();
        return events.stream()
                .filter(e -> e.getStatus().equals(Status.EM_ANDAMENTO))
                .map(e -> new HelpEventDTO(e.getId(), e.getTypeEvent(), e.getPosition()))
                .collect(Collectors.toList());
    }

     */
    public List<HelpEventDTO> listEvents(){
        var events = eventService.getAllEvents();
        var eventsFiltered = events.stream()
                .filter(e-> e.getStatus().equals(Status.EM_ANDAMENTO))
                .toList();
        return eventsFiltered.stream()
                .map(e -> new HelpEventDTO( e.getTypeEvent().name(), e.getPosition(), e.getStatus()))
                .collect(Collectors.toList());
    }
}
