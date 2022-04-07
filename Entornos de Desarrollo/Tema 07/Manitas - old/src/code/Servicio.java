package code;

import auxiliar.Clase;
	
public class Servicio {
	
// ATRIBUTOS

	private int id = 0;
	private String fecha = "";
	private String nombre = "";
	private double horas = 0.0;
	private double tarifa = 0.0;

	private	Colaborador colaborador = null;
	private	Cliente cliente = null;
	
// CONSTRUCTORES	
	public Servicio () {};
	
  public Servicio(int id, String fecha, String nombre, double horas, Colaborador colaborador, Cliente cliente) {
  	this.setId(id);
  	this.setFecha(fecha);
  	this.setNombre(nombre);
  	this.setHoras(horas);
  	this.setColaborador(colaborador);
  	this.setCliente(cliente);
  	this.setTarifa();}

// GETTERS
  public int getId() {return id;}
  public String getFecha() {return fecha;}
  public String getNombre() {return nombre;}
	public double getHoras() {return horas;}
  public double getTarifa() {return tarifa;}
	public Colaborador getColaborador() {return colaborador;}
	public Cliente getCliente() {return cliente;}	

// SETTERS

	public void setId(int id) {
		if (id <= 0) throw new IllegalArgumentException("Exception: id <= 0");
		this.id = id;}
	public void setFecha(String fecha) {
		if (fecha == "") throw new IllegalArgumentException("Exception: Fecha vacía");
		this.fecha = fecha;}
	public void setNombre(String nombre) {
		if (nombre == "") throw new IllegalArgumentException("Exception: Nombre vacío");
		this.nombre = nombre;}	
	public void setHoras(double horas) throws IllegalArgumentException {
  	if (horas < 0.0) throw new IllegalArgumentException("Exception: Horas < 0.0");
		this.horas = horas;}
	private void setTarifa() {
		this.tarifa = this.tarifaMin();}
  public void setColaborador(Colaborador colaborador)  throws IllegalArgumentException {;
		if (colaborador == null) throw new IllegalArgumentException("Exception: Colaborador nulo");
		if (!colaborador.esActivo()) throw new IllegalArgumentException("Exception: El colaborador no está activo");
		this.colaborador = colaborador;}
  public void setCliente(Cliente cliente) throws IllegalArgumentException {
  	if (cliente == null) throw new IllegalArgumentException("Exception: Cliente nulo");
  	this.cliente = cliente;}

// TOSTRING
	public String toString () {return Clase.imprimeClase(this);}
	
// MÉTODOS	
// tarifaMinima
// El servicio sólo es viable si su tarifa es superior, con un margen, a la tarifa del colaborador	
    public double tarifaMin () {return this.colaborador.getTarifa() *(1.0 + Constantes.MARGEN);}

// darMargen
    public double darMargen() {return (this.tarifa/this.colaborador.getTarifa() -1 );} // El margen es la diferencia de tarifas en % 		

// facturaCliente
    public Factura facturaCliente (int id)  throws IllegalArgumentException {
    	if (id <= 0) throw new IllegalArgumentException("Exception: id <= 0");  	
    	return new Factura(id, this.fecha, Constantes.CIF, this.cliente.getNIF(), this.nombre + " por " + this.colaborador.getNombre(), this.horas*this.tarifa, Constantes.IVA, 0.0);}

// facturaColaborador
    public Factura facturaColaborador (int id)  throws IllegalArgumentException {
    	if (id <= 0) throw new IllegalArgumentException("Exception: id <= 0");  	
    	return new Factura(id, this.fecha, this.colaborador.getNIF(), Constantes.CIF, this.nombre + " para " + this.cliente.getNombre(), this.horas*this.colaborador.getTarifa(), Constantes.IVA, Constantes.RETENCION);}    
// MAIN    

    public static void main(String[] args) {
  		
  		Colaborador pepeGotera = new ColaboradorReal(1,ServicioTipos.FONTANERO,Scoring.BAJO,20.0,true,"A02335577","PEPE GOTERA",777777777,"pepegotera@gmail.com");
  		Cliente rompeTechos = new ClienteReal(2,"111111B","Rompe Techos",777777777,"rompetechos@gmail.com");
  		Servicio chapuza = new Servicio(3,"18/03/2022","Chapuza en casa",10.0,pepeGotera,rompeTechos);
  		
  		System.out.println(chapuza);
  		System.out.println(chapuza.facturaCliente(3));
  		System.out.println(chapuza.facturaColaborador(4));}
  		
}