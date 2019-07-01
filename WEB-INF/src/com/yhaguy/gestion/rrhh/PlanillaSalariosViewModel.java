package com.yhaguy.gestion.rrhh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Window;

import com.coreweb.control.SimpleViewModel;
import com.coreweb.util.MyArray;
import com.yhaguy.domain.RRHHPlanillaSalarios;
import com.yhaguy.domain.RegisterDomain;
import com.yhaguy.gestion.reportes.formularios.ReportesViewModel;
import com.yhaguy.util.Utiles;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class PlanillaSalariosViewModel extends SimpleViewModel {

	private String selectedMes = "";
	private String selectedAnho = "";
	private RRHHPlanillaSalarios selectedPlanilla;
	
	private List<Object[]> selectedFuncionarios;
	private List<RRHHPlanillaSalarios> planillas;
	
	private Window win;
	
	@Init(superclass = true)
	public void init() {
		try {
			this.selectedAnho = Utiles.getAnhoActual();
			this.selectedMes = (String) Utiles.getMesCorriente(this.selectedAnho).getPos2();
			this.planillas = this.getPlanillas_();
		} catch (Exception e) {
		}
	}
	
	@AfterCompose(superclass = true)
	public void afterCompose() {
	}
	
	@Command
	@NotifyChange("*")
	public void generarPlanilla(@BindingParam("comp") Popup comp) throws Exception {
		RegisterDomain rr = RegisterDomain.getInstance();
		for (Object[] func : this.selectedFuncionarios) {
			RRHHPlanillaSalarios pl = new RRHHPlanillaSalarios();
			pl.setMes(this.selectedMes);
			pl.setAnho(this.selectedAnho);
			pl.setFuncionario((String) func[1]);
			rr.saveObject(pl, this.getLoginNombre());
			comp.close();
		}
		this.planillas = this.getPlanillas_();
	}
	
	@Command
	@NotifyChange({ "totales" })
	public void saveItem(@BindingParam("item") RRHHPlanillaSalarios item) throws Exception {
		RegisterDomain rr = RegisterDomain.getInstance();
		rr.saveObject(item, this.getLoginNombre());
	}
	
	@Command
	@NotifyChange({ "planillas", "totales" })
	public void selectPeriodo() throws Exception {
		this.planillas = this.getPlanillas_();
	}
	
	@Command
	public void imprimir() throws Exception {
		this.imprimirLiquidacion();
	}
	
	/**
	 * Despliega el Reporte de liquidacion de salario..
	 */
	private void imprimirLiquidacion() throws Exception {		
		String source = ReportesViewModel.SOURCE_LIQUIDACION_SALARIO;
		Map<String, Object> params = new HashMap<String, Object>();
		JRDataSource dataSource = new LiquidacionSalarioDataSource(this.selectedPlanilla);
		params.put("Fecha", Utiles.getDateToString(this.selectedPlanilla.getModificado(), Utiles.DD_MM_YYYY));
		params.put("Funcionario", this.selectedPlanilla.getFuncionario());
		params.put("Cargo", this.selectedPlanilla.getCargo());
		params.put("Periodo", this.selectedPlanilla.getMes() + " " +  this.selectedPlanilla.getAnho());
		params.put("Usuario", getUs().getNombre());
		this.imprimirComprobante(source, params, dataSource, ReportesViewModel.FORMAT_PDF);
	}
	
	/**
	 * Despliega el comprobante en un pdf para su impresion..
	 */
	private void imprimirComprobante(String source,
			Map<String, Object> parametros, JRDataSource dataSource, Object[] format) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("source", source);
		params.put("parametros", parametros);
		params.put("dataSource", dataSource);
		params.put("format", format);

		this.win = (Window) Executions.createComponents(
				ReportesViewModel.ZUL_REPORTES, this.mainComponent, params);
		this.win.doModal();
	}
	
	/**
	 * DataSource del Servicio Tecnico..
	 */
	class LiquidacionSalarioDataSource implements JRDataSource {

		List<MyArray> dets = new ArrayList<MyArray>();
		double totalImporteGs = 0;

		public LiquidacionSalarioDataSource(RRHHPlanillaSalarios liquidacion) {
			this.totalImporteGs = liquidacion.getTotalACobrar();
			if (liquidacion.getSalarios() > 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.SALARIOS,
						Utiles.getNumberFormat(liquidacion.getSalarios()),
						Utiles.getNumberFormat(0.0)));
			}
			if (liquidacion.getComision() > 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.COMISION,
						Utiles.getNumberFormat(liquidacion.getComision()),
						Utiles.getNumberFormat(0.0)));
			}
			if (liquidacion.getAnticipo() < 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.ANTICIPO,
						Utiles.getNumberFormat(0.0),
						Utiles.getNumberFormat(liquidacion.getAnticipo())));
			}
			if (liquidacion.getBonificacion() > 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.BONIFICACION,
						Utiles.getNumberFormat(liquidacion.getBonificacion()),
						Utiles.getNumberFormat(0.0)));
			}
			if (liquidacion.getOtrosHaberes() > 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.OTROS_HABERES,
						Utiles.getNumberFormat(liquidacion.getOtrosHaberes()),
						Utiles.getNumberFormat(0.0)));
			}
			if (liquidacion.getPrestamos() < 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.PRESTAMOS,
						Utiles.getNumberFormat(0.0),
						Utiles.getNumberFormat(liquidacion.getPrestamos())));
			}
			if (liquidacion.getAdelantos() < 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.ADELANTOS,
						Utiles.getNumberFormat(0.0),
						Utiles.getNumberFormat(liquidacion.getAdelantos())));
			}
			if (liquidacion.getOtrosDescuentos() < 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.OTROS_DESCUENTOS,
						Utiles.getNumberFormat(0.0),
						Utiles.getNumberFormat(liquidacion.getOtrosDescuentos())));
			}
			if (liquidacion.getCorporativo() < 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.CORPORATIVO,
						Utiles.getNumberFormat(0.0),
						Utiles.getNumberFormat(liquidacion.getCorporativo())));
			}
			if (liquidacion.getUniforme() < 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.UNIFORME,
						Utiles.getNumberFormat(0.0),
						Utiles.getNumberFormat(liquidacion.getUniforme())));
			}
			if (liquidacion.getRepuestos() < 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.REPUESTOS,
						Utiles.getNumberFormat(0.0),
						Utiles.getNumberFormat(liquidacion.getRepuestos())));
			}
			if (liquidacion.getSeguro() < 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.SEGURO,
						Utiles.getNumberFormat(0.0),
						Utiles.getNumberFormat(liquidacion.getSeguro())));
			}
			if (liquidacion.getEmbargo() < 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.EMBARGO,
						Utiles.getNumberFormat(0.0),
						Utiles.getNumberFormat(liquidacion.getEmbargo())));
			}
			if (liquidacion.getIps() < 0) {
				this.dets.add(new MyArray("  ", 
						RRHHPlanillaSalarios.IPS,
						Utiles.getNumberFormat(0.0),
						Utiles.getNumberFormat(liquidacion.getIps())));
			}
		}

		private int index = -1;

		@Override
		public Object getFieldValue(JRField field) throws JRException {
			Object value = null;
			String fieldName = field.getName();
			MyArray item = this.dets.get(index);
			if ("TituloDetalle".equals(fieldName)) {
				value = item.getPos1();
			} else if ("Descripcion".equals(fieldName)) {
				value = item.getPos2();
			} else if ("Haberes".equals(fieldName)) {
				value = item.getPos3();
			} else if ("Descuentos".equals(fieldName)) {
				value = item.getPos4();
			} else if ("TotalImporteGs".equals(fieldName)) {
				value = Utiles.getNumberFormat(this.totalImporteGs);
			} else if ("ImporteLetras".equals(fieldName)) {
				double importe = this.totalImporteGs > 0 ? this.totalImporteGs : 0.0;
				value = m.numberToLetter(importe);
			}
			return value;
		}

		@Override
		public boolean next() throws JRException {
			if (index < dets.size() - 1) {
				index++;
				return true;
			}
			return false;
		}
	}
	
	/**
	 * GETS / SETS 
	 */
	public Object[] getTotales() {
		Object[] out = new Object[]{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		if (this.planillas != null) {
			for (RRHHPlanillaSalarios item : this.planillas) {
				double sal = (double) out[0]; double com = (double) out[1];			
				double ant = (double) out[2]; double bon = (double) out[3];			
				double hab = (double) out[4]; double dto = (double) out[5];			
				double cor = (double) out[6]; double uni = (double) out[7];			
				double rep = (double) out[8]; double seg = (double) out[9];			
				double emb = (double) out[10]; double ips = (double) out[11];
				double tco = (double) out[12]; double tde = (double) out[13];
				double pre = (double) out[14]; double ade = (double) out[15];
				sal += item.getSalarios(); com += item.getComision();
				ant += item.getAnticipo(); bon += item.getBonificacion();
				hab += item.getOtrosHaberes(); dto += item.getOtrosDescuentos();
				cor += item.getCorporativo(); uni += item.getUniforme();
				rep += item.getRepuestos(); seg += item.getSeguro();
				emb += item.getEmbargo(); ips += item.getIps();
				tco += item.getTotalACobrar(); tde += item.getTotalADescontar();
				pre += item.getPrestamos(); ade += item.getAdelantos();
				out = new Object[]{ sal, com, ant, bon, hab, dto, cor, uni, rep, seg, emb, ips, tco, tde, pre, ade };
			}
		}
		return out;
	}
	
	/**
	 * @return las planillas..
	 */
	public List<RRHHPlanillaSalarios> getPlanillas_() throws Exception {
		RegisterDomain rr = RegisterDomain.getInstance();
		List<RRHHPlanillaSalarios> out = rr.getPlanillaSalarios(this.selectedMes, this.selectedAnho);
		return out;
	}
	
	public List<Object[]> getFuncionarios() throws Exception {
		RegisterDomain rr = RegisterDomain.getInstance();
		return rr.getFuncionarios_();
	}
	
	public List<String> getMeses() {
		return Utiles.getMeses_();
	}
	
	public List<String> getAnhos() {
		return Utiles.getAnhos();
	}

	public List<Object[]> getSelectedFuncionarios() {
		return selectedFuncionarios;
	}

	public void setSelectedFuncionarios(List<Object[]> selectedFuncionarios) {
		this.selectedFuncionarios = selectedFuncionarios;
	}

	public String getSelectedMes() {
		return selectedMes;
	}

	public void setSelectedMes(String selectedMes) {
		this.selectedMes = selectedMes;
	}

	public String getSelectedAnho() {
		return selectedAnho;
	}

	public void setSelectedAnho(String selectedAnho) {
		this.selectedAnho = selectedAnho;
	}

	public List<RRHHPlanillaSalarios> getPlanillas() {
		return planillas;
	}

	public void setPlanillas(List<RRHHPlanillaSalarios> planillas) {
		this.planillas = planillas;
	}

	public RRHHPlanillaSalarios getSelectedPlanilla() {
		return selectedPlanilla;
	}

	public void setSelectedPlanilla(RRHHPlanillaSalarios selectedPlanilla) {
		this.selectedPlanilla = selectedPlanilla;
	}
}