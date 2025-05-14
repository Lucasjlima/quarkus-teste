package fiap.tds.repositores;

import fiap.tds.models.Event;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EventRepository implements PanacheRepository<Event> {
    public Event findByName(String name) {
        return find("name", name).firstResult();
    }

    public void persistEvent(Event event) {
        event.persist();
    }
}
