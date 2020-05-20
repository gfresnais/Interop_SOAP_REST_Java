package fr.ensim.interop.eval.exo1.Model;

import java.util.Date;

public class Avis {
    private Date date;
    private String refProduit;
    private int note;
    private String commentaire;
    private String pays;
    private String refFournisseur;

    public Avis() {}

    public Avis(Date date, String refProduit, int note, String commentaire, String pays, String refFournisseur) {
        this.date = date;
        this.refProduit = refProduit;
        this.note = note;
        this.commentaire = commentaire;
        this.pays = pays;
        this.refFournisseur = refFournisseur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRefProduit() {
        return refProduit;
    }

    public void setRefProduit(String refProduit) {
        this.refProduit = refProduit;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRefFournisseur() {
        return refFournisseur;
    }

    public void setRefFournisseur(String refFournisseur) {
        this.refFournisseur = refFournisseur;
    }
}
