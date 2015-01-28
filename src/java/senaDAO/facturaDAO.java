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
import senaDTO.facturaDTO;

/**
 *
 * @author fabian
 */
public class facturaDAO {
  private Connection cnn = null;
    private PreparedStatement pstm;
    ResultSet rs = null;
    
    String mgSalida; // almacena el msg de salida al usuario
    int equi; // almacena el resultado de la ejecución en la BD
    
    public facturaDAO() {
        cnn =conex.getInstance();  
}
    
      public String crearFactura(facturaDTO newFactura)throws SQLException{
        String salida = "";
        try {

            int resultado = 0;
            pstm = cnn.prepareStatement("INSERT INTO factura VALUES ( ?, ?, ?, ?)");
            pstm.setInt(1, newFactura.getFacnumero());
            pstm.setString(2, newFactura.getNumerolinea());
            pstm.setString(3, newFactura.getFechaemision());
            pstm.setInt(4, newFactura.getFacvalor());
    
           
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
                Logger.getLogger(facturaDAO.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }

        return salida;

    }
public List<facturaDTO> getAll() throws SQLException {
        LinkedList<facturaDTO> listaFacturas = new LinkedList<facturaDTO>();
        try {


            String query = "SELECT  facnumero, numerolinea, fechaemision, facvalor "
                    + " FROM factura ";
            pstm = cnn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                facturaDTO newFactura = new facturaDTO();
                newFactura.setFacnumero(rs.getInt("facnumero"));
                newFactura.setNumerolinea(rs.getString("numerolinea"));
                newFactura.setFechaemision(rs.getString("fechaemision"));
                newFactura.setFacvalor(rs.getInt("facvalor"));                               
                listaFacturas.add(newFactura);
            }
        } catch (SQLException ex) {
           mgSalida="a ocurrido un error" +ex.getMessage();
        }finally{
            pstm.close();
        }

        return listaFacturas;
}
 public ArrayList <facturaDTO> listarTodo () throws SQLException{
    ArrayList <facturaDTO> listarFacturas = new ArrayList ();
    
    try {
        String query = "select facnumero, numerolinea, fechaemision, facvalor from factura";
       pstm = cnn.prepareStatement(query);
       rs = pstm.executeQuery();
       
       while (rs.next()){
           facturaDTO reser = new facturaDTO();
               reser.setFacnumero(rs.getInt("facnumero"));
               reser.setNumerolinea(rs.getString("numerolinea"));
               reser.setFechaemision(rs.getString("fechaemision"));
               reser.setFacvalor(rs.getInt("facvalor"));          
               listarFacturas.add(reser);
       }
       
    }catch (SQLException slqE){
        System.out.println("Ocurrio un error" + slqE.getMessage());
    }finally {
        
    } return listarFacturas;

}  
 public String  ListarUna (facturaDTO Rdao) throws SQLException{
           try  {
               pstm = cnn.prepareStatement("select facnumero, numerolinea, fechaemision, facvalor from factura where facnumero=?;");
               pstm.setInt(1, Rdao.getFacnumero());
               pstm.executeQuery();
               
               rs = pstm.executeQuery();
             
               while(rs.next()){
               Rdao.setFacnumero(rs.getInt("facnumero"));
               Rdao.setNumerolinea(rs.getString("numerolinea"));
               Rdao.setFechaemision(rs.getString("fechaemision"));
               Rdao.setFacvalor(rs.getInt("facvalor"));    
                   
                   
               }
           }catch (SQLException ex){
               mgSalida = "Error " + ex.getMessage() + "Codigo de error" + ex.getErrorCode();
           }
       return "" + Rdao;
       }
     public String eliminar(facturaDTO factura) {
      
        try {
          
            pstm = cnn.prepareStatement("DELETE FROM factura  WHERE facnumero = ?; ");      
            pstm.setInt(1, factura.getFacnumero());
           

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
