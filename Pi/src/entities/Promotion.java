/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author mouin
 */
public class Promotion {

    private int _Ref;
    private String _Nom;
    private int Etab;
    private Date _DateDebut;
    private Date _DateFin;
    private String _Description;
    private String _Image;
    private int _Cota;
    private int _CouponDispo;

    public Promotion(int _Ref, String _Nom, int Etab, Date _DateDebut, Date _DateFin, String _Description, String _Image, int _Cota, int _CouponDispo) {
        this._Ref = _Ref;
        this._Nom = _Nom;
        this.Etab = Etab;
        this._DateDebut = _DateDebut;
        this._DateFin = _DateFin;
        this._Description = _Description;
        this._Image = _Image;
        this._Cota = _Cota;
        this._CouponDispo = _CouponDispo;
    }
       public Promotion( String _Nom, int Etab, Date _DateDebut, Date _DateFin, String _Description, String _Image, int _Cota, int _CouponDispo) {
        
        this._Nom = _Nom;
        this.Etab = Etab;
        this._DateDebut = _DateDebut;
        this._DateFin = _DateFin;
        this._Description = _Description;
        this._Image = _Image;
        this._Cota = _Cota;
        this._CouponDispo = _CouponDispo;
    }
    
    

    public int getRef() {
        return _Ref;
    }

    public void setRef(int value) {
        _Ref = value;
    }

    public String getNom() {
        return _Nom;
    }

    public void setNom(String value) {
        _Nom = value;
    }

    public int getRefEtab() {
        return Etab;
    }

    public void setRefEtab(int value) {
        Etab = value;
    }

    public Date getDateDebut() {
        return _DateDebut;
    }

    public void setDateDebut(Date value) {
        _DateDebut = value;
    }

    public Date getDateFin() {
        return _DateFin;
    }

    public void setDateFin(Date value) {
        _DateFin = value;
    }

    public String getDescription() {
        return _Description;
    }

    public void setDescription(String value) {
        _Description = value;
    }

    public String getImage() {
        return _Image;
    }

    public void setImage(String value) {
        _Image = value;
    }

    public int getCota() {
        return _Cota;
    }

    public void setCota(int value) {
        _Cota = value;
    }

    public int getCouponDispo() {
        return _CouponDispo;
    }

    public void setCouponDispo(int value) {
        _CouponDispo = value;
    }

    @Override
    public String toString() {
        return "Promotion{" + "_Ref=" + _Ref + ", _Nom=" + _Nom + ", Etab=" + Etab + ", _DateDebut=" + _DateDebut + ", _DateFin=" + _DateFin + ", _Description=" + _Description + ", _Image=" + _Image + ", _Cota=" + _Cota + ", _CouponDispo=" + _CouponDispo + '}';
    }
    
}
