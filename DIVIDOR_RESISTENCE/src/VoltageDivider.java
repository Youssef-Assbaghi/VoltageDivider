public class VoltageDivider implements Comparable<VoltageDivider>{
  private Resistor resistor1 = null;
  private Resistor resistor2 = null;
  private double coincidence;
  // TODO: three corresponding getters

  public double getCoincidence() {
    return coincidence;
  }

  public Resistor getResistor1() {
    return resistor1;
  }

  public Resistor getResistor2() {
    return resistor2;
  }

  public VoltageDivider(Resistor r1, Resistor r2, double coincidence) {
    resistor1 = r1;
    resistor2 = r2;
    this.coincidence = coincidence;
  }

  /**
   * https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=587:ejercicio-ejemplo-resuelto-interface-comparable-y-metodo-compareto-api-java-comparar-objetos-cu00913c&catid=58&Itemid=180
   * @param o Variable con la que comparamos
   * @return 1 si nuestra coincidencia es mayor y -1 si es menor
   */
  public int compareTo(VoltageDivider o) {

    /*  if (this.edad<o.edad) {   resultado = -1;      }
        else if (this.edad>o.edad) {    resultado = 1;      }*/
    if (this.coincidence>o.getCoincidence()){
      return 1;
    }
    return -1;
  }

  @Override
  public String toString() {
    return resistor1 + ", " + resistor2 + "\nvoltage division "
        + resistor2.getResistance() / (resistor1.getResistance()
        + resistor2.getResistance())
        + "\ncoincidence " + coincidence + "\n";
  }
}

