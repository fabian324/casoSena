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
public class lineaDAO {
    private Connection cnn = null;
    private PreparedStatement pstm;
    ResultSet rs = null;
    
    String mgSalida; // almacena el msg de salida al usuario
    int equi; // almacena el resultado de la ejecución en la BD
    
    public lineaDAO() {
        cnn =conex.getInstance();  
}
     public String actualizarLinea(lineaDTO linea) {

        try {
      pstm = cnn.prepareStatement("UPDATE linea SET  perid =?, linestado=?, telefono=?  where numerolinea=?;");
          
            pstm.setInt(1, linea.getPerid());
            pstm.setString(2, linea.getLinestado());
            pstm.setLong(3, linea.getNumerolinea());
            pstm.setInt(4, linea.getTelefono());
            
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
      public String crearLinea(lineaDTO newLinea)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstm = cnn.prepareStatement("INSERT INTO linea VALUES ( ?, ?, ?, ?)");
            pstm.setLong(1, newLinea.getNumerolinea());
            pstm.setInt(2, newLinea.getPerid());
            pstm.setString(3, newLinea.getLinestado());
             pstm.setInt(4, newLinea.getTelefono());
           
            resultado = pstm.executeUpdate();

            if (resultado != 0) {
                salida = "su linea ha sido registrada. ";
            } else {            
                
            }
        } catch (SQLException sqle) {
            salida = "Ocurrió la siguiente exception : " + sqle.getMessage();
        } finally {
            try {
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(lineaDAO.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }

        return salida;

    }
public List<lineaDTO> getAll() throws SQLException {
        LinkedList<lineaDTO> listaLineas = new LinkedList<lineaDTO>();
        try {


            String query = "SELECT  numerolinea, perid, linestado, telefono "
                    + " FROM linea ";
            pstm = cnn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                lineaDTO newLinea = new lineaDTO();
                newLinea.setNumerolinea(rs.getLong("numerolinea"));
                newLinea.setPerid(rs.getInt("perid"));
                newLinea.setLinestado(rs.getString("linestado"));  
                newLinea.setTelefono(rs.getInt("telefono"));
                listaLineas.add(newLinea);
            }
        } catch (SQLException ex) {
           mgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstm.close();
        }

        return listaLineas;
}
 public ArrayList <lineaDTO> listarTodas () throws SQLException{
    ArrayList <lineaDTO> listarLineas = new ArrayList ();
    
    try {
        String query = "select numerolinea, perid, linestado, telefono from linea";
       pstm = cnn.prepareStatement(query);
       rs = pstm.executeQuery();
       
       while (rs.next()){
           lineaDTO reser = new lineaDTO();
                reser.setNumerolinea(rs.getLong("numerolinea"));
                reser.setPerid(rs.getInt("perid"));
                reser.setLinestado(rs.getString("linestado")); 
                reser.setTelefono(rs.getInt("telefono"));
               listarLineas.add(reser);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    } return listarLineas;

}  
 public String  ListarUna (lineaDTO Rdao) throws SQLException{
           try  {
               pstm = cnn.prepareStatement("select  numerolinea, perid, linestado, telefono from linea where numerolinea=?;");
               pstm.setLong(1, Rdao.getNumerolinea());
               pstm.executeQuery();
               
               rs = pstm.executeQuery();
             
                 while(rs.next()){
                 Rdao.setNumerolinea(rs.getLong("numerolinea"));
                 Rdao.setPerid(rs.getInt("perid"));
                 Rdao.setLinestado(rs.getString("linestado")); 
                 Rdao.setTelefono(rs.getInt("telefono"));  
                   
               }
           }catch (SQLException ex){
               mgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }
     public String eliminar(lineaDTO linea) {
      
        try {
          
            pstm = cnn.prepareStatement("DELETE FROM linea  WHERE numerolinea = ?; ");      
            pstm.setLong(1, linea.getNumerolinea());
           

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
     public long validar(long numerolinea) throws SQLException {
       
       long y = 1;
       
       try {

           lineaDTO pde = new lineaDTO();        
        
           
           String sql = "select numerolinea from linea where numerolinea = ?";        
           pstm = cnn.prepareStatement(sql);           
           pstm.setLong(1, numerolinea);           
           rs = pstm.executeQuery();
           
          
           if (rs != null) {
               
               while (rs.next()) {

                   pde.setNumerolinea(rs.getLong("numerolinea"));
                  
                 }
               y = pde.getNumerolinea();
           }
           else {
               y = 0;
           }
       
       
       } catch (SQLException ex) {

          
           
           
       }
return y;
   }
       public int validarSerial(int telefono) throws SQLException {
       
       int y = 1;
       
       try {

           lineaDTO pde = new lineaDTO();        
        
           
           String sql = "select telefono from linea where telefono= ?";        
           pstm = cnn.prepareStatement(sql);           
           pstm.setInt(1, telefono);           
           rs = pstm.executeQuery();
           
          
           if (rs != null) {
               
               while (rs.next()) {

                   pde.setTelefono(rs.getInt("telefono"));
                  
                 }
               y = pde.getTelefono();
           }
           else {
               y = 0;
           }
       
       
       } catch (SQLException ex) {

          
           
           
       }
return y;
   }  
}
