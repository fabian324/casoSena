/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;
import conexion.conex;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import senaDAO.equipoDAO;
import senaDAO.facturaDAO;
import senaDAO.lineaDAO;
import senaDAO.personaDAO;
import senaDTO.equipoDTO;
import senaDTO.facturaDTO;
import senaDTO.lineaDTO;
import senaDTO.personaDTO;

/**
 *
 * @author fabian
 */
public class prueba {
     public static void main(String[] args) throws SQLException {
         equipoDTO  equ =new equipoDTO();
         equipoDAO  eq = new equipoDAO();
         facturaDTO f = new facturaDTO();
         facturaDAO fa =new facturaDAO();
         lineaDTO l =new lineaDTO();
         lineaDAO li = new lineaDAO();
         personaDTO p =new personaDTO();
         personaDAO pe =new personaDAO();
       Scanner entrada = new Scanner(System.in);
        int respuesta;
        Scanner in = new Scanner(System.in);
        Connection conexion =conex.getInstance();
        if (conexion != null) {
            System.out.println("Conectado");
            System.out.println("digite su opcion");
        }
        respuesta = entrada.nextInt();

        switch (respuesta) {
            case 1:
                System.out.println("para crear un equipo");
                System.out.println("serial");
                equ.setSerial(in.nextInt());
                System.out.println("linea");
                equ.setNumerolinea(in.nextLong());
                System.out.println("marca");
                equ.setMarca(in.next());
                System.out.println("descripcion");
                equ.setDescripcion(in.next());
                System.out.println("estado");
                equ.setEstado(in.next());
                System.out.println(eq.crearEquipo(equ));
                break;
            case 2:
                System.out.println("para actualizar un equipo");
                System.out.println("serial");
                equ.setSerial(in.nextInt());
                System.out.println("linea");
                equ.setNumerolinea(in.nextLong());
                System.out.println("marca");
                equ.setMarca(in.next());
                System.out.println("descripcion");
                equ.setDescripcion(in.next());
                System.out.println("estado");
                equ.setEstado(in.next());
                System.out.println(eq.actualizarRegistro(equ));
                break;
                case 3:
                System.out.println("serial");
                equ.setSerial(in.nextInt());
                System.out.println(eq.eliminar(equ));
                break;
                case 4:
                System.out.println("serial");
                equ.setSerial(in.nextInt());
                System.out.println(eq.ListarUno(equ));
                break;
                case 5:
                ArrayList<equipoDTO> res = new ArrayList();
                res = eq.listarTodo();

                for (equipoDTO c : res) {
                    System.out.println("\n" + c);
                }
                break;
                case 6:
                System.out.println("numero factura");
                f.setFacnumero(in.nextInt());
                System.out.println("linea");
                f.setNumerolinea(in.next());
                System.out.println("fecha");
                f.setFechaemision(in.next());
                System.out.println("valor");
                f.setFacvalor(in.nextInt());
                System.out.println(fa.crearFactura(f));
                break;
                case 7:                 
                System.out.println("numero factura");
                f.setFacnumero(in.nextInt());
                System.out.println(fa.eliminar(f));
                break;
                case 8:
                System.out.println("numero factura");
                f.setFacnumero(in.nextInt());
                System.out.println(fa.ListarUna(f));
                break;
                case 9:
                ArrayList<facturaDTO> fact = new ArrayList();
                fact = fa.listarTodo();

                for (facturaDTO t : fact) {
                    System.out.println("\n" + t);
                }
                break;
                case 10:
                System.out.println("numero linea");
                l.setNumerolinea(in.nextLong());
                System.out.println("perid");
                l.setPerid(in.nextInt());
                System.out.println("estado");
                l.setLinestado(in.next());
                System.out.println(li.crearLinea(l));
                break;
                case 11:
                System.out.println("numero linea");
                l.setNumerolinea(in.nextLong());
                System.out.println("perid");
                l.setPerid(in.nextInt());
                System.out.println("estado");
                l.setLinestado(in.next());
                System.out.println(li.actualizarLinea(l));
                break;  
                case 12:                               
                System.out.println("numero linea");
                l.setNumerolinea(in.nextLong());
                System.out.println(li.eliminar(l));
                break;
                case 13:
                System.out.println("numero linea");
                l.setNumerolinea(in.nextLong());
                System.out.println(li.ListarUna(l));
                break;
                case 14:
                ArrayList<lineaDTO> lin = new ArrayList();
                lin = li.listarTodas();

                for (lineaDTO a : lin) {
                    System.out.println("\n" + a);
                }
                break;
                case 15:
                    System.out.println("digite id");
                    p.setPerid(in.nextInt());
                    System.out.println("nombre");
                    p.setNombre(in.next());
                    System.out.println("apellido");
                    p.setApellido(in.next());
                    System.out.println("telefono");
                    p.setTelefono(in.nextInt());
                    System.out.println("nacimiento");
                    p.setNacimiento(in.next());
                    System.out.println("cedula");
                    p.setCedula(in.nextInt());
                    System.out.println(pe.crearPersona(p));
                    break;
                case 16:
                    System.out.println("digite id");
                    p.setPerid(in.nextInt());
                    System.out.println("nombre");
                    p.setNombre(in.next());
                    System.out.println("apellido");
                    p.setApellido(in.next());
                    System.out.println("telefono");
                    p.setTelefono(in.nextInt());
                    System.out.println("nacimiento");
                    p.setNacimiento(in.next());
                    System.out.println("cedula");
                    p.setCedula(in.nextInt());
                    System.out.println(pe.actualizarRegistro(p));
                    break;
                case 17:                                                 
                System.out.println("id persona");
                p.setPerid(in.nextInt());
                System.out.println(pe.eliminar(p));
                break;
                case 18:
                System.out.println("id persona");
                p.setPerid(in.nextInt());
                System.out.println(pe.ListarUna(p));
                break;
                case 19:
                ArrayList<personaDTO> per = new ArrayList();
                per = pe.listarTodas();

                for (personaDTO a : per) {
                    System.out.println("\n" + a);
                }
                break;
                    
                    
}
}
}