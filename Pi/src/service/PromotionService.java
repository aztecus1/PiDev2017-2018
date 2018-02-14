/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entities.Promotion;
import util.DataSource;



/**
 *
 * @author Guideinfo
 */
public class PromotionService {

    static DataSource ds =DataSource.getInstance(); 
    
    
    public static void insererPromotion (Promotion p)
    {
    String req="INSERT INTO promotion (nom,ref_etab,date_debut,date_fin,description,image,cota,coupon_dispo) VALUES(?,?,?,?,?,?,?,?)" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setString(1,p.getNom()) ; 
            ste.setInt(2,p.getRefEtab()) ; 
            ste.setDate(3,p.getDateDebut());
            ste.setDate(4,p.getDateFin());
            ste.setString(5,p.getDescription());
            ste.setString(6,p.getImage());
            ste.setInt(7,p.getCota()) ; 
            ste.setInt(8,p.getCouponDispo()) ; 
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
     
    public static void updatePromotion (Promotion p )
    {
    String req="UPDATE promotion SET nom=?,ref_etab=?,date_debut=?,date_fin=?,description=?,image=?,cota=?,coupon=? WHERE ref =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setString(1,p.getNom()) ; 
            ste.setInt(2,p.getRefEtab()) ; 
            ste.setDate(3,p.getDateDebut());
            ste.setDate(4,p.getDateFin());
            ste.setString(5,p.getDescription());
            ste.setString(6,p.getImage());
            ste.setInt(7,p.getCota()) ; 
            ste.setInt(8,p.getCouponDispo()) ; 
            
            
            ste.setInt(9,p.getRef()) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
     public static void DeletPromotion (Promotion p)
    {
    String req="DELETE  from promotion where  ref =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setInt(1,p.getRef()) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
      }
     
    public static List<Promotion> selectPromotion ()
    {
        List<Promotion> list =new ArrayList<>() ; 
    String req ; 
        req = "SELECT *  FROM promotion";
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new Promotion(
                                    result.getInt("ref"),
                                    result.getString("nom"),
                                    result.getInt("ref_etab"),
                                    result.getDate("date_debut"),
                                    result.getDate("date_fin"),
                                    result.getString("description"),
                                    result.getString("nom"),
                                    result.getInt("cota"),
                                    result.getInt("coupon_dispo")
            )); 
            }
            
        } catch (SQLException ex) {
            
        }
    return list ; 
      }
     
    
    
    
    
}
