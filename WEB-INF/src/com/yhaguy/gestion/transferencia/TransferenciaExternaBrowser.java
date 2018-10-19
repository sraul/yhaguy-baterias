package com.yhaguy.gestion.transferencia;

import java.util.ArrayList;
import java.util.List;

import com.coreweb.Config;
import com.coreweb.extras.browser.Browser;
import com.coreweb.extras.browser.ColumnaBrowser;
import com.yhaguy.UtilDTO;
import com.yhaguy.domain.Transferencia;

public class TransferenciaExternaBrowser extends Browser{

	@Override
	public List<ColumnaBrowser> getColumnasBrowser() {
		
		UtilDTO util = (UtilDTO) this.getDtoUtil();
		
		ColumnaBrowser col1 = new ColumnaBrowser();
		ColumnaBrowser col2 = new ColumnaBrowser();
		ColumnaBrowser col3 = new ColumnaBrowser();
		ColumnaBrowser col4 = new ColumnaBrowser();
		ColumnaBrowser col5 = new ColumnaBrowser();
		ColumnaBrowser col6 = new ColumnaBrowser();
		
		col1.setCampo("numero");
		col1.setTitulo("Número");
		col1.setWhere("transferenciaTipo.id = " + util.getTipoTransferenciaExterna().getId());
		
		col2.setCampo("depositoSalida.descripcion");
		col2.setTitulo("Depósito Salida");
		
		col3.setCampo("depositoEntrada.descripcion");
		col3.setTitulo("Depósito Entrada");
		
		col4.setCampo("fechaCreacion");
		col4.setTitulo("Fecha");
		col4.setTipo(Config.TIPO_DATE);
		col4.setComponente(LABEL_DATE);
		
		col5.setCampo("transferenciaEstado.descripcion");
		col5.setTitulo("Estado");
		
		col6.setCampo("numeroRemision");
		col6.setTitulo("Nro. Remision");
		
		List<ColumnaBrowser> columnas = new ArrayList<ColumnaBrowser>();
		columnas.add(col1);
		columnas.add(col2);
		//columnas.add(col3);
		columnas.add(col4);
		columnas.add(col5);
		columnas.add(col6);
		
		return columnas;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getEntidadPrincipal() {
		return Transferencia.class;
	}

	@Override
	public void setingInicial() {
		this.setWidthWindows("1100px");
		this.setHigthWindows("80%");
		this.addOrden("fechaCreacion");
	}

	@Override
	public String getTituloBrowser() {
		return "Transferencias Externas";
	}

}

