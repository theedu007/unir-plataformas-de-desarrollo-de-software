/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;

/**
 *
 * @author eduar
 */
public class PedidoBean {

    private String NombreMedicamento;
    private String TipoMedicamento;
    private int CantidadMedicamento;
    private String Distribuidor;
    private List<String> SucursalesADistribuir;
    
    public String getNombreMedicamento() {
        return NombreMedicamento;
    }

    public void setNombreMedicamento(String NombreMedicamento) {
        this.NombreMedicamento = NombreMedicamento;
    }

    public String getTipoMedicamento() {
        return TipoMedicamento;
    }

    public void setTipoMedicamento(String TipoMedicamento) {
        this.TipoMedicamento = TipoMedicamento;
    }

    public int getCantidadMedicamento() {
        return CantidadMedicamento;
    }

    public void setCantidadMedicamento(int CantidadMedicamento) {
        this.CantidadMedicamento = CantidadMedicamento;
    }

    public String getDistribuidor() {
        return Distribuidor;
    }

    public void setDistribuidor(String Distribuidor) {
        this.Distribuidor = Distribuidor;
    }

    public List<String> getSucursalesADistribuir() {
        return SucursalesADistribuir;
    }

    public void setSucursalesADistribuir(List<String> SucursalesADistribuir) {
        this.SucursalesADistribuir = SucursalesADistribuir;
    }
}
