package fiap.tds.resource;


import fiap.tds.services.EventService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/historico")
public class HistoryResource {

    @Inject
    EventService eventService;
    //This get will be used to get the history of resolved events by position and status
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{position}")
    public Response getAllResolvedEventsByPosition(@PathParam("position") String position){
        var events = eventService.getAllResolvedEventsByPosition(position);
        return Response.ok(events).build();
    }



    //This get will be used to get the history of all events only for ADMIN
    //@GET
}
