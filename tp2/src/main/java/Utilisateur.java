
public class Utilisateur {
    private String prenom;
    private String nom;
    private String email;
    private Integer id;

    public Utilisateur(String prenom, String nom, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    // getters & setters
    public String getPrenom() { return prenom; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
}