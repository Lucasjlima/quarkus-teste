package fiap.tds.dtos;

import java.net.URI;

public class GitHubDTO {
    private URI githubEquipe;

    public GitHubDTO() {
    }

    public GitHubDTO(URI githubEquipe) {
        this.githubEquipe = githubEquipe;
    }

    public URI getGithubEquipe() {
        return githubEquipe;
    }

    public void setGithubEquipe(URI githubEquipe) {
        this.githubEquipe = githubEquipe;
    }
}
