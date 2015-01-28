/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package senaDAO;

import conexion.conex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import senaDTO.equipoDTO;
import senaDTO.lineaDTO;
import senaDTO.personaDTO;

/**
 *
 * @author fabian
 */
public class personaDAO {
    private Connection cnn = null;
    private PreparedStatement pstm;
    ResultSet rs = null;
    
    String mgSalida; // almacena el msg de salida al usuario
    int equi; // almacena el resultado de la ejecución en la BD
    
    public personaDAO() {
        cnn =conex.getInstance();  
}
     public String actualizarRegistro(personaDTO persona) {

        try {
    pstm = cnn.prepareStatement("UPDATE persona SET  nombre =?, apellido=?, telefono=?, nacimiento=?, cedula=?  where perid=?;");
          
            pstm.setString(1, persona.getNombre());
            pstm.setString(2, persona.getApellido());
            pstm.setInt(3, persona.getTelefono());
            pstm.setString(4, persona.getNacimiento());
            pstm.setInt(5, persona.getCedula());
            pstm.setInt(6, persona.getPerid());
            
            equi= pstm.executeUpdate();
            if (equi > 0) {
                mgSalida = "se modificaron (" + equi + ") registros";
            } else {
                mgSalida = "NO se pudo actualizar el registro";
            }
            
        } catch (SQLException ex) {
        mgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();
        
        }
        return mgSalida;
 
  } 
      public String crearPersona(personaDTO newPersona)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstm = cnn.prepareStatement("INSERT INTO persona VALUES ( ?, ?, ?, ?, ?, ?)");
            pstm.setInt(1, newPersona.getPerid());
            pstm.setString(2, newPersona.getNombre());
            pstm.setString(3, newPersona.getApellido());
            pstm.setInt(4, newPersona.getTelefono());
            pstm.setString(5, newPersona.getNacimiento());
            pstm.setInt(6, newPersona.getCedula());
           
            resultado = pstm.executeUpdate();

            if (resultado != 0) {
                salida = "El usuario a sido registrado exitosamente. " + resultado + "filas afectadas";
            } else {            
                
            }
        } catch (SQLException sqle) {
            salida = "Ocurrió la siguiente exception : " + sqle.getMessage();
        } finally {
            try {
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }

        return salida;

    }
public List<personaDTO> getAll() throws SQLException {
        LinkedList<personaDTO> listaPersonas = new LinkedList<personaDTO>();
        try {


            String query = "SELECT  perid, nombre, apellido, telefono, nacimiento, cedula "
                    + " FROM persona ";
            pstm = cnn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                personaDTO newPersona = new personaDTO();
                newPersona.setPerid(rs.getInt("perid"));
                newPersona.setNombre(rs.getString("nombre"));
                newPersona.setApellido(rs.getString("apellido"));
                newPersona.setTelefono(rs.getInt("telefono"));
                newPersona.setNacimiento(rs.getString("nacimiento")); 
                newPersona.setCedula(rs.getInt("cedula"));
                listaPersonas.add(newPersona);
            }
        } catch (SQLException ex) {
           mgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstm.close();
        }

        return listaPersonas;
}
 public ArrayList <personaDTO> listarTodas () throws SQLException{
    ArrayList <personaDTO> listarPersonas = new ArrayList ();
    
    try {
        String query = "select perid, nombre, apellido, telefono, nacimiento, cedula from persona";
       pstm = cnn.prepareStatement(query);
       rs = pstm.executeQuery();
       
       while (rs.next()){
           personaDTO reser = new personaDTO();
               reser.setPerid(rs.getInt("perid"));
               reser.setNombre(rs.getString("nombre"));
               reser.setApellido(rs.getString("apellido"));
               reser.setTelefono(rs.getInt("telefono"));
               reser.setNacimiento(rs.getString("nacimiento")); 
               reser.setCedula(rs.getInt("cedula"));
               listarPersonas.add(reser);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    } return listarPersonas;

}  
 public String  ListarUna (personaDTO rdao) throws SQLException{
           try  {
               pstm = cnn.prepareStatement("select perid, nombre, apellido, telefono, nacimiento, cedula from persona where perid=?;");
               pstm.setInt(1, rdao.getPerid());
               pstm.executeQuery();
               
               rs = pstm.executeQuery();
             
                 while(rs.next()){
                rdao.setPerid(rs.getInt("perid"));
                rdao.setNombre(rs.getString("nombre"));
                rdao.setApellido(rs.getString("apellido"));
                rdao.setTelefono(rs.getInt("telefono"));
                rdao.setNacimiento(rs.getString("nacimiento")); 
                rdao.setCedula(rs.getInt("cedula"));
                   
                   
               }
           }catch (SQLException ex){
               mgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + rdao;
       }
     public String eliminar(personaDTO persona) {
      
        try {
          
            pstm = cnn.prepareStatement("DELETE FROM persona  WHERE perid = ?; ");      
            pstm.setInt(1, persona.getPerid());
           

            equi = pstm.executeUpdate();
            if (equi > 0) {
                mgSalida = "se eliminaron (" + equi + ") registros";
            } else {
                mgSalida = "NO se pudo eliminar  el registro";
            }
        } catch (SQLException ex) {
            mgSalida = "Error al ejecutar la operación : " + ex.getSQLState() + " " + ex.getMessage();

        }

        return mgSalida;
    }
       public int validarUsuario(int cedula) throws SQLException {
       
       int y = 1;
       
       try {

           personaDTO pde = new personaDTO();        
        
           
           String sql = "select cedula from persona where cedula = ?";        
           pstm = cnn.prepareStatement(sql);           
           pstm.setInt(1, cedula);           
           rs = pstm.executeQuery();
           
          
           if (rs != null) {
               
               while (rs.next()) {

                   pde.setCedula(rs.getInt("cedula"));
                  
                 }
               y = pde.getCedula();
           }
           else {
               y = 0;
           }
       
       
       } catch (SQLException ex) {

          
           
           
       }
return y;
   }  
      
}
