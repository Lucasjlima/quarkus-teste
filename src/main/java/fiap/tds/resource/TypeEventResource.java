/*
package fiap.tds.resource;


import fiap.tds.models.TypeEvent;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Path("/tipos-evento")
public class TypeEventResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoEventoResponse> listarTiposEvento() {
        return Arrays.stream(TypeEvent.values())
                .map(t -> new TipoEventoResponse(t.name(), t.getCargoResponsavel()))
                .collect(Collectors.toList());
    }



    //Criar essa classe como record ou DTO e puxar ela dentro do EventResource
    public static class TipoEventoResponse {
        public String titulo;
        public String cargoResponsavel;

        public TipoEventoResponse(String titulo, String cargoResponsavel) {
            this.titulo = titulo;
            this.cargoResponsavel = cargoResponsavel;
        }
    }
}


 */