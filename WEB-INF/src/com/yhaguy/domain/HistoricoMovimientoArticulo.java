package com.yhaguy.domain;

import java.util.Date;

import com.coreweb.domain.Domain;


@SuppressWarnings("serial")
public class HistoricoMovimientoArticulo extends Domain {
	
	private Date fecha;
	private String codigo;
	private String codigoProveedor;
	private String descripcion;
	private String referencia;
	private String nroParte;
	private String estado;
	private String articulo;
	private String familia;
	private String marca;
	private String linea;
	private String grupo;
	private String ochentaVeinte;
	private String abc;
	private String aplicacion;
	private String modelo;
	private String peso;
	private String volumen;
	private String proveedor;
	private long cantidad;
	private long stock1;
	private long stock2;
	private long stock3;
	private long stock4;
	private long stock5;
	private long stock6;
	private long stock7;
	private long stock8;
	private long stockGral;
	private long stockMinimo;
	private long stockMaximo;
	private String fechaUltimaCompra;
	private String fechaUltimaVenta;
	private String proveedorUltimaCompra;
	private double costoFob;
	private double coeficiente;
	private double tipoCambio;
	private double costoGs;
	private double mayoristaGs;
	private double clienteGral;
	private double clienteMesVigente;
	private long enero;
	private long febrero;
	private long marzo;
	private long abril;
	private long mayo;
	private long junio;
	private long julio;
	private long agosto;
	private long setiembre;
	private long octubre;
	private long noviembre;
	private long diciembre;
	private long total;

	@Override
	public int compareTo(Object o) {
		return -1;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getNroParte() {
		return nroParte;
	}

	public void setNroParte(String nroParte) {
		this.nroParte = nroParte;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public long getStock1() {
		return stock1;
	}

	public void setStock1(long stock1) {
		this.stock1 = stock1;
	}

	public long getStock2() {
		return stock2;
	}

	public void setStock2(long stock2) {
		this.stock2 = stock2;
	}

	public long getStock3() {
		return stock3;
	}

	public void setStock3(long stock3) {
		this.stock3 = stock3;
	}

	public long getStock4() {
		return stock4;
	}

	public void setStock4(long stock4) {
		this.stock4 = stock4;
	}

	public long getStock5() {
		return stock5;
	}

	public void setStock5(long stock5) {
		this.stock5 = stock5;
	}

	public long getStock6() {
		return stock6;
	}

	public void setStock6(long stock6) {
		this.stock6 = stock6;
	}

	public long getStock7() {
		return stock7;
	}

	public void setStock7(long stock7) {
		this.stock7 = stock7;
	}

	public long getStock8() {
		return stock8;
	}

	public void setStock8(long stock8) {
		this.stock8 = stock8;
	}

	public long getStockGral() {
		return stockGral;
	}

	public void setStockGral(long stockGral) {
		this.stockGral = stockGral;
	}

	public long getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(long stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public long getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(long stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public String getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(String fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public String getFechaUltimaVenta() {
		return fechaUltimaVenta;
	}

	public void setFechaUltimaVenta(String fechaUltimaVenta) {
		this.fechaUltimaVenta = fechaUltimaVenta;
	}

	public String getProveedorUltimaCompra() {
		return proveedorUltimaCompra;
	}

	public void setProveedorUltimaCompra(String proveedorUltimaCompra) {
		this.proveedorUltimaCompra = proveedorUltimaCompra;
	}

	public double getCostoFob() {
		return costoFob;
	}

	public void setCostoFob(double costoFob) {
		this.costoFob = costoFob;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}

	public double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public double getCostoGs() {
		return costoGs;
	}

	public void setCostoGs(double costoGs) {
		this.costoGs = costoGs;
	}

	public double getMayoristaGs() {
		return mayoristaGs;
	}

	public void setMayoristaGs(double mayoristaGs) {
		this.mayoristaGs = mayoristaGs;
	}

	public double getClienteGral() {
		return clienteGral;
	}

	public void setClienteGral(double clienteGral) {
		this.clienteGral = clienteGral;
	}

	public double getClienteMesVigente() {
		return clienteMesVigente;
	}

	public void setClienteMesVigente(double clienteMesVigente) {
		this.clienteMesVigente = clienteMesVigente;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOchentaVeinte() {
		return ochentaVeinte;
	}

	public void setOchentaVeinte(String ochentaVeinte) {
		this.ochentaVeinte = ochentaVeinte;
	}

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}

	public long getEnero() {
		return enero;
	}

	public void setEnero(long enero) {
		this.enero = enero;
	}

	public long getFebrero() {
		return febrero;
	}

	public void setFebrero(long febrero) {
		this.febrero = febrero;
	}

	public long getMarzo() {
		return marzo;
	}

	public void setMarzo(long marzo) {
		this.marzo = marzo;
	}

	public long getAbril() {
		return abril;
	}

	public void setAbril(long abril) {
		this.abril = abril;
	}

	public long getMayo() {
		return mayo;
	}

	public void setMayo(long mayo) {
		this.mayo = mayo;
	}

	public long getJunio() {
		return junio;
	}

	public void setJunio(long junio) {
		this.junio = junio;
	}

	public long getJulio() {
		return julio;
	}

	public void setJulio(long julio) {
		this.julio = julio;
	}

	public long getAgosto() {
		return agosto;
	}

	public void setAgosto(long agosto) {
		this.agosto = agosto;
	}

	public long getSetiembre() {
		return setiembre;
	}

	public void setSetiembre(long setiembre) {
		this.setiembre = setiembre;
	}

	public long getOctubre() {
		return octubre;
	}

	public void setOctubre(long octubre) {
		this.octubre = octubre;
	}

	public long getNoviembre() {
		return noviembre;
	}

	public void setNoviembre(long noviembre) {
		this.noviembre = noviembre;
	}

	public long getDiciembre() {
		return diciembre;
	}

	public void setDiciembre(long diciembre) {
		this.diciembre = diciembre;
	}

	public long getTotal() {
		return total;
	}
}