package fiap.tds.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URI;
import java.util.Optional;
public class IntegrantesDTO {
    private String name;
    private String rm;
    private String group;
    private URI link;


    public IntegrantesDTO() {
    }

    public IntegrantesDTO(String name, String rm, String group, URI link) {
        this.name = name;
        this.rm = rm;
        this.group = group;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public URI getLink() {
        return link;
    }

    public void setLink(URI link) {
        this.link = link;
    }
}


