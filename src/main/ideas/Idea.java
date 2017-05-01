package main.ideas;

import java.util.List;

/**
 * Created by sebde on 01/05/2017.
 */
public class Idea {

    private String titre;
    private String description;
    private String mail;
    private String nom;
    private List<String> technologies;

    public Idea(String titre, String description, String mail, String nom, List<String> technologies){
        this.titre=titre;
        this.description=description;
        this.mail=mail;
        this.nom=nom;
        this.technologies=technologies;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getMail() {
        return mail;
    }

    public String getNom() {
        return nom;
    }

    public List<String> getTechnologies() {
        return technologies;
    }
}
