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
public class lineaDTO {
    private long numerolinea;
    private int perid;
    private String linestado;
    private int telefono;

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
     * @return the linestado
     */
    public String getLinestado() {
        return linestado;
    }

    /**
     * @param linestado the linestado to set
     */
    public void setLinestado(String linestado) {
        this.linestado = linestado;
    }
    @Override
    public String toString(){
        return "\numerolinea "+this.numerolinea
                +"\nperid "+this.perid
                +"\nlinestado "+this.linestado
                +"\ntelefono "+this.telefono;
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
}
