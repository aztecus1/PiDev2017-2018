/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author mouin
 */
public class Etablissement {
    private int ref_etab=2;
    private String nom="hotel" ;

    public int getRef_etab() {
        return ref_etab;
    }

    public String getNom() {
        return nom;
    }

    public void setRef_etab(int ref_etab) {
        this.ref_etab = ref_etab;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    

}
