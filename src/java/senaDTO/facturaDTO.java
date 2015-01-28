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
public class facturaDTO {
    private int facnumero;
    private String numerolinea;
    private String fechaemision;
    private int facvalor;

    /**
     * @return the facnumero
     */
    public int getFacnumero() {
        return facnumero;
    }

    /**
     * @param facnumero the facnumero to set
     */
    public void setFacnumero(int facnumero) {
        this.facnumero = facnumero;
    }

    /**
     * @return the numerolinea
     */
    public String getNumerolinea() {
        return numerolinea;
    }

    /**
     * @param numerolinea the numerolinea to set
     */
    public void setNumerolinea(String numerolinea) {
        this.numerolinea = numerolinea;
    }

    /**
     * @return the fechaemision
     */
    public String getFechaemision() {
        return fechaemision;
    }

    /**
     * @param fechaemision the fechaemision to set
     */
    public void setFechaemision(String fechaemision) {
        this.fechaemision = fechaemision;
    }

    /**
     * @return the facvalor
     */
    public int getFacvalor() {
        return facvalor;
    }

    /**
     * @param facvalor the facvalor to set
     */
    public void setFacvalor(int facvalor) {
        this.facvalor = facvalor;
    }
    @Override
    public String toString(){
        return "facnumero "+this.facnumero
                +"\nnumerolinea "+this.numerolinea
                +"\nfechaemision "+this.fechaemision
                +"\nfacvalor "+this.facvalor;
    }
}
