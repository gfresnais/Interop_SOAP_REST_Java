package fr.ensim.interop.eval.exo2.Model;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class Plantation {
    private int id;
    @NotEmpty
    private Date date;
    @NotEmpty
    private String parcelle;
    @NotEmpty
    private String nomCommun;
    @NotEmpty
    private String famille;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getParcelle() {
        return parcelle;
    }

    public void setParcelle(String parcelle) {
        this.parcelle = parcelle;
    }

    public String getNomCommun() {
        return nomCommun;
    }

    public void setNomCommun(String nomCommun) {
        this.nomCommun = nomCommun;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }
}
