package entity;

import java.util.List;

public class PedidoBean {
	private String NombreMedicamento;
	private String TipoMedicamento;
    private int CantidadMedicamento;
    private String Distribuidor;
    private List<String> SucursalesADistribuir;

    public String getNombreMedicamento() {
		return NombreMedicamento;
	}
	public void setNombreMedicamento(String nombreMedicamento) {
		NombreMedicamento = nombreMedicamento;
	}
	public String getTipoMedicamento() {
		return TipoMedicamento;
	}
	public void setTipoMedicamento(String tipoMedicamento) {
		TipoMedicamento = tipoMedicamento;
	}
	public int getCantidadMedicamento() {
		return CantidadMedicamento;
	}
	public void setCantidadMedicamento(int cantidadMedicamento) {
		CantidadMedicamento = cantidadMedicamento;
	}
	public String getDistribuidor() {
		return Distribuidor;
	}
	public void setDistribuidor(String distribuidor) {
		Distribuidor = distribuidor;
	}
	public List<String> getSucursalesADistribuir() {
		return SucursalesADistribuir;
	}
	public void setSucursalesADistribuir(List<String> sucursalesADistribuir) {
		SucursalesADistribuir = sucursalesADistribuir;
	}
}
