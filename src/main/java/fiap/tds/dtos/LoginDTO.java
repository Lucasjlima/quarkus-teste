package fiap.tds.dtos;

public class LoginDTO {
    public String username;
    public String password;

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
