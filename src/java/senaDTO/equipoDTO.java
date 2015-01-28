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
public class equipoDTO {
    private int serial;
    private long numerolinea;
    private String marca;
    private String descripcion;
    private String estado;

    /**
     * @return the serial
     */
    public int getSerial() {
        return serial;
    }

    /**
     * @param serial the serial to set
     */
    public void setSerial(int serial) {
        this.serial = serial;
    }

    /**
     * @return the numerolinea
     */
    public long getNumerolinea() {
        return numerolinea;
    }

    /**
     * @param numerolinea the numerolinea to set
     */
    public void setNumerolinea(long numerolinea) {
        this.numerolinea = numerolinea;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString (){
        return "serial "+this.serial
        +"\nnumerolinea "+this.numerolinea
        +"\nmarca "+this.marca
        +"\ndescripcion "+this.descripcion
        +"\nestado "+this.estado;
    }
}
