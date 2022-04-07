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
  private String descripción = "";
  private double base = 0.0;
  private double ivaTipo = 0.0;
  private double retenciónTipo = 0.0;
  private EnumMap<FacturaImportes, Double> importes = new EnumMap<>(FacturaImportes.class);

  // CONSTRUCTOR
  public Factura() {
  }

  public Factura(
      int id,
      String fecha,
      String CIFEmisor,
      String CIFReceptor,
      String descripción,
      double base,
      double ivaTipo,
      double retenciónTipo) throws IllegalArgumentException {

    this.setId(id);
    this.setFecha(fecha);
    this.setCIFEmisor(CIFEmisor);
    this.setCIFReceptor(CIFReceptor);
    this.setDescripción(descripción);
    this.setBase(base);
    this.setIvaTipo(ivaTipo);
    this.setRetenciónTipo(retenciónTipo);
    this.calcularFactura();
  }

  // GETTERS
  public int getId() {
    return this.id;
  }

  public String getFecha() {
    return this.fecha;
  }

  public String getCIFEmisor() {
    return this.CIFEmisor;
  }

  public String getCIFReceptor() {
    return this.CIFReceptor;
  }

  public String getDescripción() {
    return this.descripción;
  }

  public double getBase() {
    return this.base;
  }

  public double getIvaTipo() {
    return this.ivaTipo;
  }

  public double getRetenciónTipo() {
    return this.retenciónTipo;
  }

  public EnumMap<FacturaImportes, Double> getImportes() {
    return importes;
  }

  // SETTERS
  public void setId(int id) throws IllegalArgumentException {
    if (id <= 0)
      throw new IllegalArgumentException("Exception: Id <= 0"); // Mejorable: las facturas tienen que ser consecutivas
    this.id = id;
  }

  public void setFecha(String fecha) throws IllegalArgumentException {
    if (!Valido.validarFecha(fecha))
      throw new IllegalArgumentException("Exception: Fecha incorrecta");
    this.fecha = fecha;
  }

  public void setCIFEmisor(String CIFEmisor) throws IllegalArgumentException {
    if (!Valido.validarNIF(CIFEmisor))
      throw new IllegalArgumentException("Exception: CIF Emisor incorrecto");
    this.CIFEmisor = CIFEmisor;
  }

  public void setCIFReceptor(String CIFReceptor) throws IllegalArgumentException {
    if (!Valido.validarNIF(CIFReceptor))
      throw new IllegalArgumentException("Exception: CIF Receptor incorrecto");
    this.CIFReceptor = CIFReceptor;
  }

  public void setDescripción(String descripción) throws IllegalArgumentException {
    if (descripción == "")
      throw new IllegalArgumentException("Exception: Descripción vacía");
    this.descripción = descripción;
  }

  public void setBase(double base) throws IllegalArgumentException {
    if (base <= 0)
      throw new IllegalArgumentException("Exception: Base <= 0");
    this.base = base;
    this.calcularFactura();
  }

  public void setIvaTipo(double ivaTipo) throws IllegalArgumentException {
    if (ivaTipo < 0.0 || ivaTipo > 1.0)
      throw new IllegalArgumentException("Exception: IVA incorrecto");
    this.ivaTipo = ivaTipo;
    this.calcularFactura();
  }

  public void setRetenciónTipo(double retenciónTipo) throws IllegalArgumentException {
    if (retenciónTipo < 0.0 || retenciónTipo > 1.0)
      throw new IllegalArgumentException("Exception: Retención incorrecta");
    this.retenciónTipo = retenciónTipo;
    this.calcularFactura();
  }

  // TOSTRING
  @Override
  public String toString() {
    return Clase.imprimeClase(this);
  }

  // EQUAL
  @Override
  public boolean equals(Object copia) {
    return Clase.comparaObjetos(this, copia);
  }

  // M�TODOS
  // calculaFactura

  private void calcularFactura() {
    double iva = this.base * this.ivaTipo; // El iva es la base por el tipo de iva
    double total = this.base + iva; // El total es la suma de iva y base
    double retención = this.base * this.retenciónTipo; // El total es la suma de iva y base
    double facturable = total - retención;// Lo facturable es el total menos la retenci�n

    // Mete los valores en el EnumMap
    this.importes.put(FacturaImportes.BASE, base);
    this.importes.put(FacturaImportes.IVA, iva);
    this.importes.put(FacturaImportes.TOTAL, total);
    this.importes.put(FacturaImportes.RETENCIÓN, retención);
    this.importes.put(FacturaImportes.FACTURABLE, facturable);
  }

  // MAIN
  /*
   * public static void main(String[] args) {
   * 
   * Factura factura = new
   * Factura(1,"19/03/2022","12755355S","06023717V","Rotura de Tuberia",1000,0.21,
   * 0.20);
   * Factura copia = new
   * Factura(1,"19/03/2022","12755355S","06023717V","Rotura de tuberia",1000,0.21,
   * 0.20);
   * System.out.println(factura);
   * System.out.println(factura.equals(copia));
   * }
   */
}