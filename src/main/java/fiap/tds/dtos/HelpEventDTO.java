package fiap.tds.dtos;

import fiap.tds.models.Status;

public class HelpEventDTO {
    private String type;
    private String position;
    private Status status;

    public HelpEventDTO() {
    }

    public HelpEventDTO(String type, String position, Status status) {
        this.type = type;
        this.position = position;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
