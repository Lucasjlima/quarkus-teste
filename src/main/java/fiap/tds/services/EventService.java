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
        event.setStatus(Status.EM_ANDAMENTO);
        eventRepository.persistEvent(event);

    }
}
