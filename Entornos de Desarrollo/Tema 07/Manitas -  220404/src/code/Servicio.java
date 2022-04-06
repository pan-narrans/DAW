package code;

import auxiliar.Clase;
import auxiliar.Valido;
	
public class Servicio {
	
// ATRIBUTOS

	private int id = 0;
	private String fecha = "";
	private String descripcion = "";
	private double horas = 0.0;
	private double tarifa = 0.0;

	private	Colaborador colaborador = null;
	private	Cliente cliente = null;
	
// CONSTRUCTORES	
	public Servicio () {};
	
  public Servicio(int id, String fecha, String descripcion, double horas, Colaborador colaborador, Cliente cliente) throws IllegalArgumentException{
  	this.setId(id);
  	this.setFecha(fecha);
  	this.setDescripción(descripcion);
  	this.setHoras(horas);
  	this.setColaborador(colaborador);
  	this.setCliente(cliente);
  	this.setTarifa();}

// GETTERS
  public int getId() {return id;}
  public String getFecha() {return fecha;}
  public String getDescripcion() {return descripcion;}
	public double getHoras() {return horas;}
  public double getTarifa() {return tarifa;}
	public Colaborador getColaborador() {return colaborador;}
	public Cliente getCliente() {return cliente;}	

// SETTERS

	public void setId(int id) {
		if (id <= 0) throw new IllegalArgumentException("Exception: Id <= 0");
		this.id = id;}
	
	public void setFecha(String fecha) throws IllegalArgumentException{
			if (!Valido.validarFecha(fecha))  throw new IllegalArgumentException("Exception: Fecha incorrecta");
			this.fecha = fecha;}
		
	public void setDescripción(String descripcion) {
		if (descripcion == "") throw new IllegalArgumentException("Exception: Descripción vac�a");
		this.descripcion = descripcion;}	
	
	public void setHoras(double horas) throws IllegalArgumentException {
  	if (horas < 0.0) throw new IllegalArgumentException("Exception: Horas < 0.0");
		this.horas = horas;}
	
	private void setTarifa() {this.tarifa = this.tarifaMin();}
  
	public void setColaborador(Colaborador colaborador)  throws IllegalArgumentException {;
		if (colaborador == null) throw new IllegalArgumentException("Exception: Colaborador nulo");
		if (!colaborador.esActivo()) throw new IllegalArgumentException("Exception: El colaborador no est� activo");
		try {this.colaborador = colaborador;}
		catch (IllegalArgumentException e) {throw e;}}
  
	public void setCliente(Cliente cliente) throws IllegalArgumentException {
  	if (cliente == null) throw new IllegalArgumentException("Exception: Cliente nulo");
  	try {this.cliente = cliente;}
		catch (IllegalArgumentException e) {throw e;}}

// TOSTRING
	@Override
  public String toString () {return Clase.imprimeClase(this);}
	
//EQUAL
	@Override
	public boolean equals(Object copia) {return Clase.comparaObjetos(this, copia);}	
	
// M�TODOS	
// tarifaMinima
// El servicio s�lo es viable si su tarifa es superior, con un margen, a la tarifa del colaborador	
  public double tarifaMin () {return this.colaborador.getTarifa() *(1.0 + Constantes.MARGEN);}

// darMargen
  public double darMargen() {return (this.horas*this.colaborador.getTarifa()*Constantes.MARGEN);} // Margen bruto del servicio

// facturaCliente
  public Factura facturaCliente (int id)  throws IllegalArgumentException {
  	if (id <= 0) throw new IllegalArgumentException("Exception: Id <= 0");  	
  	return new Factura(id, this.fecha, Constantes.CIF, this.cliente.getNIF(), this.descripcion + " por " + this.colaborador.getNombre(), this.horas*this.tarifa, Constantes.IVA, 0.0);}

// facturaColaborador
  public Factura facturaColaborador (int id)  throws IllegalArgumentException {
  	if (id <= 0) throw new IllegalArgumentException("Exception: Id <= 0");  	
  	return new Factura(id, this.fecha, this.colaborador.getNIF(), Constantes.CIF, this.descripcion + " para " + this.cliente.getNombre(), this.horas*this.colaborador.getTarifa(), Constantes.IVA, Constantes.RETENCIÓN);}    

// MAIN    
/*
  public static void main(String[] args) {
 		
  		Colaborador pepeGotera = new ColaboradorReal(1,ServicioTipos.FONTANERO,Scoring.BAJO,20.0,true,"A02335577","PEPE GOTERA",777777777,"pepegotera@gmail.com");
  		Cliente rompeTechos = new ClienteReal(2,"111111B","Rompe Techos",777777777,"rompetechos@gmail.com");
  		Servicio chapuza = new Servicio(3,"18/03/2022","Chapuza en casa",10.0,pepeGotera,rompeTechos);
  		
  		System.out.println(chapuza);
  		System.out.println(chapuza.facturaCliente(3));
  		System.out.println(chapuza.facturaColaborador(4)); 		
  } 		
*/  
}