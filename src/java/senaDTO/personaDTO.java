/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package senaDTO;

/**
 *
 * @author fabian
 */
public class personaDTO {
    private int perid;
    private String nombre;
    private String apellido;
    private int telefono;
    private String nacimiento;
    private int cedula;

    /**
     * @return the perid
     */
    public int getPerid() {
        return perid;
    }

    /**
     * @param perid the perid to set
     */
    public void setPerid(int perid) {
        this.perid = perid;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the nacimiento
     */
    public String getNacimiento() {
        return nacimiento;
    }

    /**
     * @param nacimiento the nacimiento to set
     */
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * @return the cedula
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    @Override
    public String toString(){
        return "perid "+this.perid
                +"\nnombre "+this.nombre
                +"\napellido "+this.apellido
                +"\ntelefono "+this.telefono
                +"\nnacimiento "+this.nacimiento
                +"\ncedula "+this.cedula;
    }
}
