/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author luill
 */
public class Metodo {
    private int idReq;
    private String nombre;
    private String modificado;
    private String eliminado;
    private Date fecha;
    
    public Metodo(int idReq, String nombre, String modificado, String eliminado, Date fecha) {
        this.idReq = idReq;
        this.nombre = nombre;
        this.modificado = modificado;
        this.eliminado = eliminado;
        this.fecha = fecha;
    }
    public Metodo() {
    }
    
    public static Vector MostrarDatos(){
        Vector requerimiento=null;
        try {
            conectorBD db=new conectorBD();
            Connection cn=db.conectar();
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("Select * from requerimientos");
            requerimiento=new Vector();
            
            while(rs.next())
                requerimiento.add(new Metodo(rs.getInt("idReq"),rs.getString("nombre"),
                      rs.getString("modificado"),rs.getString("eliminado"),rs.getDate("fecha")));
            return requerimiento;
        } catch (Exception e) {
        }
        return null;    
    }
    public boolean buscar(int idReq){
        boolean requerimiento=false;
        try {
            conectorBD db=new conectorBD();
            Connection cn=db.conectar();
            Statement st=cn.createStatement();
            PreparedStatement ps=cn.prepareStatement("Select * from requerimientos where idReq=?");
            ps.setString(1, idReq+"");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                this.idReq=rs.getInt("idReq");
                this.nombre=rs.getString("nombre");
                this.modificado=rs.getString("modificado");
                this.eliminado=rs.getString("eliminado");
                this.fecha=rs.getDate("fecha");
                requerimiento=true;
            }
        } catch (Exception e) {
        }
        return requerimiento;
    }
    public boolean modificar(int idReq, String nombre, String modificado, String eliminado, String fecha){
        try {
           conectorBD db=new conectorBD();
           Connection cn=db.conectar();
           PreparedStatement ps=cn.prepareStatement("execute modificar @idreq = ?,@nombre=?, @modificado=?, @eliminado=?, @fecha=?");
           ps.setString(5, fecha);
           ps.setString(4, eliminado);
           ps.setString(3, modificado);
           ps.setString(2, nombre);
           ps.setInt(1, idReq);
           
           if(ps.execute()){
               throw new NullPointerException("No se pudo");
           }
        } catch (Exception e) {
            
        }
        return true;
    }
   public int getIdReq() {
        return idReq;
    }

    public void setIdReq(int idReq) {
        this.idReq = idReq;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModificado() {
        return modificado;
    }

    public void setModificado(String modificado) {
        this.modificado = modificado;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }  
    
 
}
