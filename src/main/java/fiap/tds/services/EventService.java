package fiap.tds.services;

import fiap.tds.dtos.EventDTO;
import fiap.tds.models.Event;
import fiap.tds.models.Status;
import fiap.tds.repositores.EventRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class EventService {

    @Inject
    EventRepository eventRepository;

    @Transactional
    //This method will be used to register the event in the database, POST request
    public void reportEvent(EventDTO eventDTO){
        var event = new Event();
        event.setTypeEvent(eventDTO.getTypeEvent());
        event.setLocal_event(eventDTO.getLocal_event());
        event.setDescription(eventDTO.getDescricao());
        event.setPosition(eventDTO.getTypeEvent().getCargoResponsavel());
        event.setDate_event(LocalDateTime.now());
        event.setStatus(Status.SEM_RESPOSTA);
        eventRepository.persistEvent(event);

    }

    //This method will be used to get all events for position, GET request
    public List<Event> getAllEventsByPosition(String position){
        var events = eventRepository.getAllEvents();
        return events.stream()
                .filter(e -> e.getPosition().equals(position))
                .filter(e -> e.getStatus().equals(Status.SEM_RESPOSTA))
                .toList();
    }

    //This method will be used to get events by position and methods that has the status FINALIZADO, GET request
    public List<Event> getAllResolvedEventsByPosition(String position){
        var events = eventRepository.getAllEvents();
        return events.stream()
                .filter(e -> e.getPosition().equals(position)
                        && e.getStatus().equals(Status.FINALIZADO))
                .toList();
    }



    //This method will resolve the event, PUT request
    @Transactional
    public void resolveEvent(Long id){
        var event = eventRepository.findById(id);
        if(event != null){
            event.setStatus(Status.FINALIZADO);
            eventRepository.persistEvent(event);
        }
    }

    //This method will be used to get all events only for ADMIN, GET request
    public List<Event> getAllEvents(){
        var events = eventRepository.getAllEvents();
        return events.stream()
                .toList();
    }



}
