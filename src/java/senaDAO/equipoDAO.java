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

/**
 *
 * @author fabian
 */
public class equipoDAO {
  private Connection cnn = null;
    private PreparedStatement pstm;
    ResultSet rs = null;
    
    String mgSalida; // almacena el msg de salida al usuario
    int equi; // almacena el resultado de la ejecución en la BD
    
    public equipoDAO() {
        cnn =conex.getInstance();  
}
     public String actualizarRegistro(equipoDTO equipo) {

        try {
    pstm = cnn.prepareStatement("UPDATE equipo SET  numerolinea =?, marca=?, descripcion=?, estado=?  where serial=?;");
          
            pstm.setLong(1, equipo.getNumerolinea());
            pstm.setString(2, equipo.getMarca());
            pstm.setString(3, equipo.getDescripcion());
            pstm.setString(4, equipo.getEstado());
            pstm.setInt(5, equipo.getSerial());
            
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
      public String crearEquipo(equipoDTO newEquipo)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstm = cnn.prepareStatement("INSERT INTO equipo VALUES ( ?, ?, ?, ?)");
            pstm.setInt(1, newEquipo.getSerial());
            pstm.setLong(2, newEquipo.getNumerolinea());
            pstm.setString(3, newEquipo.getMarca());
            pstm.setString(4, newEquipo.getDescripcion());
            
           
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
                Logger.getLogger(equipoDAO.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }

        return salida;

    }
public List<equipoDTO> getAll() throws SQLException {
        LinkedList<equipoDTO> listaEquipos = new LinkedList<equipoDTO>();
        try {


            String query = "SELECT  serial, numerolinea, marca, descripcion, estado "
                    + " FROM equipo ";
            pstm = cnn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                equipoDTO newEquipo = new equipoDTO();
                newEquipo.setSerial(rs.getInt("serial"));
                newEquipo.setNumerolinea(rs.getLong("numerolinea"));
                newEquipo.setMarca(rs.getString("marca"));
                newEquipo.setDescripcion(rs.getString("descripcion"));
                newEquipo.setEstado(rs.getString("estado"));                
                listaEquipos.add(newEquipo);
            }
        } catch (SQLException ex) {
           mgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstm.close();
        }

        return listaEquipos;
}
 public ArrayList <equipoDTO> listarTodo () throws SQLException{
    ArrayList <equipoDTO> listarEquipos = new ArrayList ();
    
    try {
        String query = "select serial, numerolinea, marca, descripcion, estado from equipo";
       pstm = cnn.prepareStatement(query);
       rs = pstm.executeQuery();
       
       while (rs.next()){
           equipoDTO reser = new equipoDTO();
               reser.setSerial(rs.getInt("serial"));
               reser.setNumerolinea(rs.getLong("numerolinea"));
               reser.setMarca(rs.getString("marca"));
               reser.setDescripcion(rs.getString("descripcion"));
               reser.setEstado(rs.getString("estado"));
               listarEquipos.add(reser);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    } return listarEquipos;

}  
 public String  ListarUno (equipoDTO Rdao) throws SQLException{
           try  {
               pstm = cnn.prepareStatement("select serial, numerolinea, marca, descripcion, estado from equipo where serial=?;");
               pstm.setInt(1, Rdao.getSerial());
               pstm.executeQuery();
               
               rs = pstm.executeQuery();
             
                 while(rs.next()){
                   Rdao.setSerial(rs.getInt("serial"));
                   Rdao.setNumerolinea(rs.getLong("numerolinea"));
                   Rdao.setMarca(rs.getString("marca"));
                   Rdao.setDescripcion(rs.getString("descripcion"));
                   Rdao.setEstado(rs.getString("estado"));
                   
                   
               }
           }catch (SQLException ex){
               mgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }
     public String eliminar(equipoDTO equipo) {
      
        try {
          
            pstm = cnn.prepareStatement("DELETE FROM equipo  WHERE serial = ?; ");      
            pstm.setInt(1, equipo.getSerial());
           

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
}