package code;

import java.util.EnumMap;
import auxiliar.Clase;
import auxiliar.Valido;

public class Factura {

// ATRIBUTOS
	private int id = 0;
	private String fecha = "";
	private String CIFEmisor = "";
  private String CIFReceptor = "";
	private String descripcion = "";
	private double base = 0.0;
	private double ivaTipo = 0.0;
	private double retencionTipo = 0.0;
	private EnumMap<FacturaImportes,Double> importes = new EnumMap<>(FacturaImportes.class);

// CONSTRUCTOR
	public Factura () {}

	public Factura (
		int id,
		String fecha,
		String CIFEmisor,
		String CIFReceptor,
		String descripcion,
		double base,
		double ivaTipo,
		double retencionTipo) {

		this.setId(id);
		this.setFecha(fecha);
		this.setCIFEmisor(CIFEmisor);
		this.setCIFReceptor(CIFReceptor);
		this.setDescripcion(descripcion);
		this.setBase(base);
		this.setIvaTipo(ivaTipo);
		this.setRetencionTipo(retencionTipo);
		this.calcularFactura();}
		
// GETTERS
	public int getId() {return this.id;}
	public String getFecha() {return this.fecha;}
	public String getCIFEmisor() {return this.CIFEmisor;}
	public String getCIFReceptor() {return this.CIFReceptor;}
	public String getDescripcion() {return this.descripcion;}	
	public double getBase() {return this.base;}
	public double getIvaTipo() {return this.ivaTipo;}
	public double getRetencionTipo() {return this.retencionTipo;}
	public EnumMap<FacturaImportes, Double> getImportes() {return importes;}

// SETTERS	
	public void setId(int id) throws IllegalArgumentException {
		if (id <= 0) throw new IllegalArgumentException("Exception: Id <= 0"); // Mejorable: las facturas tienen que ser consecutivas
		this.id = id;}
	
	public void setFecha(String fecha) throws IllegalArgumentException{

		try {
			if (!Valido.validarFecha(fecha))  throw new IllegalArgumentException("Exception: Fecha incorrecta");
			this.fecha = fecha;}
		catch (IllegalArgumentException e) {}}

	public void setCIFEmisor(String CIFEmisor)  throws IllegalArgumentException {
		try {
			if (!Valido.validarNIF(CIFEmisor)) throw new IllegalArgumentException("Exception: CIF Emisor incorrecto");
			this.CIFEmisor = CIFEmisor;}	
		catch (IllegalArgumentException e) {}}
	
	public void setCIFReceptor(String CIFReceptor)  throws IllegalArgumentException {
		try {
			if (!Valido.validarNIF(CIFReceptor)) throw new IllegalArgumentException("Exception: CIF Receptor incorrecto");
			this.CIFReceptor = CIFReceptor;}
		catch (IllegalArgumentException e) {}}
	
	public void setDescripcion (String descripcion)  throws IllegalArgumentException {
		if (descripcion == "")  throw new IllegalArgumentException("Exception: Descripción vacía");
		this.descripcion = descripcion;}	
	
	public void setBase(double base)   throws IllegalArgumentException {
		if (base <= 0) throw new IllegalArgumentException("Exception: Base <= 0");
		this.base = base;
		this.calcularFactura();}
	
	public void setIvaTipo(double ivaTipo) throws IllegalArgumentException {
		if (ivaTipo < 0.0 || ivaTipo > 1.0) throw new IllegalArgumentException("Exception: IVA incorrecto");
		this.ivaTipo = ivaTipo;
		this.calcularFactura();}
	
	public void setRetencionTipo(double retencionTipo) throws IllegalArgumentException {
		if (retencionTipo < 0.0 || retencionTipo > 1.0) throw new IllegalArgumentException("Exception: Retención incorrecta");
		this.retencionTipo = retencionTipo;
		this.calcularFactura();}

// TOSTRING
	@Override
	public String toString () {return Clase.imprimeClase(this);}
	
// EQUAL
	@Override
	public boolean equals(Object copia) {return Clase.comparaObjetos(this, copia);}

//MÉTODOS	
//calculaFactura
	
	private void calcularFactura () {		
	 	double iva = this.base* this.ivaTipo; // El iva es la base por el tipo de iva
	 	double total = this.base + iva; // El total es la suma de iva y base
	 	double retencion = this.base * this.retencionTipo;	// El total es la suma de iva y base
	 	double facturable = total - retencion;// Lo facturable es el total menos la retención

 	// Mete los valores en el EnumMap
	 	this.importes.put(FacturaImportes.BASE, base);
	 	this.importes.put(FacturaImportes.IVA, iva);
	 	this.importes.put(FacturaImportes.TOTAL, total);
	 	this.importes.put(FacturaImportes.RETENCION, retencion);
	 	this.importes.put(FacturaImportes.FACTURABLE, facturable);}
	
// MAIN	
/*
	public static void main(String[] args) {
		Factura factura = new Factura(1,"19/03/2022","12755355S","06023717V","Rotura de Tuberia",1000,0.21,0.20);
		Factura copia = new Factura(1,"19/03/2022","12755355S","06023717V","Rotura de Tuberia",1000,0.21,0.20);
		
		System.out.println(factura.equals(copia));
		
//		System.out.println(factura);
	}
*/
}