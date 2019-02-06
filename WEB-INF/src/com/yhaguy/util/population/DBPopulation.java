package com.yhaguy.util.population;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.time.DateUtils;

import com.coreweb.domain.Alerta;
import com.coreweb.domain.AlertaDestinos;
import com.coreweb.domain.AutoNumero;
import com.coreweb.domain.Domain;
import com.coreweb.domain.Tipo;
import com.coreweb.domain.Usuario;
import com.coreweb.util.Misc;
import com.coreweb.util.population.DBChistes;
import com.yhaguy.Configuracion;
import com.yhaguy.domain.AccesoApp;
import com.yhaguy.domain.Articulo;
import com.yhaguy.domain.ArticuloCosto;
import com.yhaguy.domain.ArticuloDeposito;
import com.yhaguy.domain.ArticuloGasto;
import com.yhaguy.domain.ArticuloMarcaAplicacion;
import com.yhaguy.domain.ArticuloModeloAplicacion;
import com.yhaguy.domain.ArticuloPrecioReferencia;
import com.yhaguy.domain.ArticuloPresentacion;
import com.yhaguy.domain.ArticuloReferencia;
import com.yhaguy.domain.Banco;
import com.yhaguy.domain.BancoCheque;
import com.yhaguy.domain.BancoCta;
import com.yhaguy.domain.BancoMovimiento;
import com.yhaguy.domain.BancoSucursal;
import com.yhaguy.domain.Caja;
import com.yhaguy.domain.CajaPeriodo;
import com.yhaguy.domain.CentroCosto;
import com.yhaguy.domain.Cliente;
import com.yhaguy.domain.CompraLocalFactura;
import com.yhaguy.domain.CompraLocalFacturaDetalle;
import com.yhaguy.domain.CompraLocalGasto;
import com.yhaguy.domain.CompraLocalOrden;
import com.yhaguy.domain.CompraLocalOrdenDetalle;
import com.yhaguy.domain.Contacto;
import com.yhaguy.domain.ContactoInterno;
import com.yhaguy.domain.CtaCteEmpresa;
import com.yhaguy.domain.CtaCteEmpresaMovimiento;
import com.yhaguy.domain.CtaCteImputacion;
import com.yhaguy.domain.CtaCteLineaCredito;
import com.yhaguy.domain.CuentaContable;
import com.yhaguy.domain.DepartamentoApp;
import com.yhaguy.domain.Deposito;
import com.yhaguy.domain.Empresa;
import com.yhaguy.domain.EmpresaGrupoSociedad;
import com.yhaguy.domain.Funcionario;
import com.yhaguy.domain.Gasto;
import com.yhaguy.domain.GastoDetalle;
import com.yhaguy.domain.ImportacionFactura;
import com.yhaguy.domain.ImportacionFacturaDetalle;
import com.yhaguy.domain.ImportacionPedidoCompra;
import com.yhaguy.domain.ImportacionPedidoCompraDetalle;
import com.yhaguy.domain.ImportacionResumenGastosDespacho;
import com.yhaguy.domain.NotaCredito;
import com.yhaguy.domain.OrdenPedidoGasto;
import com.yhaguy.domain.OrdenPedidoGastoDetalle;
import com.yhaguy.domain.Proveedor;
import com.yhaguy.domain.ProveedorArticulo;
import com.yhaguy.domain.RegisterDomain;
import com.yhaguy.domain.Reparto;
import com.yhaguy.domain.RepartoDetalle;
import com.yhaguy.domain.Reserva;
import com.yhaguy.domain.ReservaDetalle;
import com.yhaguy.domain.SubDiario;
import com.yhaguy.domain.SubDiarioDetalle;
import com.yhaguy.domain.Sucursal;
import com.yhaguy.domain.SucursalApp;
import com.yhaguy.domain.Timbrado;
import com.yhaguy.domain.TipoCambio;
import com.yhaguy.domain.TipoMovimiento;
import com.yhaguy.domain.Transferencia;
import com.yhaguy.domain.TransferenciaDetalle;
import com.yhaguy.domain.Transporte;
import com.yhaguy.domain.Vehiculo;
import com.yhaguy.domain.Venta;
import com.yhaguy.domain.VentaDetalle;
import com.yhaguy.util.migracion.MigracionPlanDeCuentas;

public class DBPopulation {}