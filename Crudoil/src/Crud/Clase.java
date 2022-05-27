package Crud;

import java.util.ArrayList;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Clase {
	@SerializedName("ListaEESSPrecio")
    ArrayList<Gasolinera> gasol = new ArrayList<Gasolinera>();

    public ArrayList<Gasolinera> getGasol() {
        return gasol;
    }

    public void setGasol(ArrayList<Gasolinera> gasol) {
        this.gasol = gasol;
    }


}
class Gasolinera{
	@SerializedName("C.P.")
    String CP;
	@SerializedName("Dirección")
    String Direccion;
    String Horario;
    String Latitud;
    String Localidad;
    @SerializedName("Longitud (WGS84)")
    String Longitud;
    String Margen;
    String Municipio;
    @SerializedName("Precio Biodiesel")
    String PrecioBiodiesel;
    @SerializedName("Precio Bioetanol")
    String PrecioBioetanol;
    @SerializedName("Precio Gas Natural Comprimido")
    String PrecioGasNaturalComprimido;
    @SerializedName("Precio Gasoleo A")
    String PrecioGasoleoA;
    @SerializedName("Precio Gasoleo B")
    String PrecioGasoleoB;
    @SerializedName("Precio Gasoleo Premium")
    String PrecioGasoleoPremium;
    @SerializedName("Precio Gasolina 95 E10")
    String PrecioGasolina95E10;
    @SerializedName("Precio Gasolina 95 E5")
    String PrecioGasolina95E5;
    @SerializedName("Precio Gasolina 95 E5 Premium")
    String PrecioGasolina95E5Premium;
    @SerializedName("Precio Gasolina 98 E10")
    String PrecioGasolina98E10;
    @SerializedName("Precio Gasolina 98 E5")
    String PrecioGasolina98E5;
    @SerializedName("Precio Hidrogeno")
    String PrecioHidrogeno;
    String Provincia;
    @SerializedName("Remisión")
    String Remision;
    @SerializedName("Rótulo")
    String Rotulo;
    @SerializedName("Tipo Venta")
    String TipoVenta;
    String IDEESS;
    String IDMunicipio;
    String IDProvincia;
    String IDCCAA;
    public String getCP() {
        return CP;
    }
    public void setCP(String cP) {
        CP = cP;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDirección(String direccion) {
        Direccion = direccion;
    }
    public String getHorario() {
        return Horario;
    }
    public void setHorario(String horario) {
        Horario = horario;
    }
    public String getLatitud() {
        return Latitud;
    }
    public void setLatitud(String latitud) {
        Latitud = latitud;
    }
    public String getLocalidad() {
        return Localidad;
    }
    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }
    public String getLongitud() {
        return Longitud;
    }
    public void setLongitud(String longitud) {
        Longitud = longitud;
    }
    public String getMargen() {
        return Margen;
    }
    public void setMargen(String margen) {
        Margen = margen;
    }
    public String getMunicipio() {
        return Municipio;
    }
    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }
    public String getPrecioBiodiesel() {
        return PrecioBiodiesel;
    }
    public void setPrecioBiodiesel(String precioBiodiesel) {
        PrecioBiodiesel = precioBiodiesel;
    }
    public String getPrecioBioetanol() {
        return PrecioBioetanol;
    }
    public void setPrecioBioetanol(String precioBioetanol) {
        PrecioBioetanol = precioBioetanol;
    }
    public String getPrecioGasNaturalComprimido() {
        return PrecioGasNaturalComprimido;
    }
    public void setPrecioGasNaturalComprimido(String precioGasNaturalComprimido) {
        PrecioGasNaturalComprimido = precioGasNaturalComprimido;
    }

    public String getPrecioGasoleoA() {
        return PrecioGasoleoA;
    }
    public void setPrecioGasoleoA(String precioGasoleoA) {
        PrecioGasoleoA = precioGasoleoA;
    }
    public String getPrecioGasoleoB() {
        return PrecioGasoleoB;
    }
    public void setPrecioGasoleoB(String precioGasoleoB) {
        PrecioGasoleoB = precioGasoleoB;
    }
    public String getPrecioGasoleoPremium() {
        return PrecioGasoleoPremium;
    }
    public void setPrecioGasoleoPremium(String precioGasoleoPremium) {
        PrecioGasoleoPremium = precioGasoleoPremium;
    }
    public String getPrecioGasolina95E10() {
        return PrecioGasolina95E10;
    }
    public void setPrecioGasolina95E10(String precioGasolina95E10) {
        PrecioGasolina95E10 = precioGasolina95E10;
    }
    public String getPrecioGasolina95E5() {
        return PrecioGasolina95E5;
    }
    public void setPrecioGasolina95E5(String precioGasolina95E5) {
        PrecioGasolina95E5 = precioGasolina95E5;
    }
    public String getPrecioGasolina95E5Premium() {
        return PrecioGasolina95E5Premium;
    }
    public void setPrecioGasolina95E5Premium(String precioGasolina95E5Premium) {
        PrecioGasolina95E5Premium = precioGasolina95E5Premium;
    }
    public String getPrecioGasolina98E10() {
        return PrecioGasolina98E10;
    }
    public void setPrecioGasolina98E10(String precioGasolina98E10) {
        PrecioGasolina98E10 = precioGasolina98E10;
    }
    public String getPrecioGasolina98E5() {
        return PrecioGasolina98E5;
    }
    public void setPrecioGasolina98E5(String precioGasolina98E5) {
        PrecioGasolina98E5 = precioGasolina98E5;
    }
    public String getPrecioHidrogeno() {
        return PrecioHidrogeno;
    }
    public void setPrecioHidrogeno(String precioHidrogeno) {
        PrecioHidrogeno = precioHidrogeno;
    }
    public String getProvincia() {
        return Provincia;
    }
    public void setProvincia(String provincia) {
        Provincia = provincia;
    }
    public String getRemision() {
        return Remision;
    }
    public void setRemision(String remision) {
        Remision = remision;
    }
    public String getRotulo() {
        return Rotulo;
    }
    public void setRotulo(String rotulo) {
        Rotulo = rotulo;
    }
    public String getTipoVenta() {
        return TipoVenta;
    }
    public void setTipoVenta(String tipoVenta) {
        TipoVenta = tipoVenta;
    }
    public String getIDEESS() {
        return IDEESS;
    }
    public void setIDEESS(String iDEESS) {
        IDEESS = iDEESS;
    }
    public String getIDMunicipio() {
        return IDMunicipio;
    }
    public void setIDMunicipio(String iDMunicipio) {
        IDMunicipio = iDMunicipio;
    }
    public String getIDProvincia() {
        return IDProvincia;
    }
    public void setIDProvincia(String iDProvincia) {
        IDProvincia = iDProvincia;
    }
    public String getIDCCAA() {
        return IDCCAA;
    }
    public void setIDCCAA(String iDCCAA) {
        IDCCAA = iDCCAA;
    }
}