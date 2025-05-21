package fiap.tds.resource;

import fiap.tds.services.EventService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.*;

@Path("/monitorar-eventos")
public class MonitorEventResource {
    @Inject
    EventService eventService;


    @GET
    @Path("/{position}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEventsByPosition(@PathParam("position") String position){
        var events = eventService.getAllEventsByPosition(position);
        return Response.ok(events).build();
    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response reportEvent(@PathParam("id") Long id){
        eventService.resolveEvent(id);
        return Response.ok("Status do evento foi atualizado com sucesso!").build();
    }




    @GET
    @Path("/admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEvents(){
        var events = eventService.getAllEvents();
        return Response.ok(events).build();
    }



}
