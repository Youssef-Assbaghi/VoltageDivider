import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * REPASAR Y CONTINUAR DE AQUI
 */
public class VoltageDividerCalculation {
  public static List<VoltageDivider> calculate(double voltageDivision , double coincidence , Series s) {
// why an static method ?
    List<Resistor> resistors = s.getResistors();
    double precision=s.getPrecision();
    List<VoltageDivider> lista_de_voltajes_buenos=new ArrayList<VoltageDivider>(); //NO LINKED LIST
// non-optimized version at the moment and output to console
    //tol = K(100 − c)/100
    // |K − k| ≤ tol
    for (Resistor r1 : resistors) {
      for (Resistor r2 : resistors) {
        double r1r2VoltageDivision;
        double r1r2Coincidence=0;
        r1r2VoltageDivision=r2.getResistance()/( r1.getResistance()+r2.getResistance());
        double calculoVoltage=voltageDivision-r1r2VoltageDivision;
        if (calculoVoltage<0)
          calculoVoltage=-calculoVoltage;

        r1r2Coincidence=100*(1-(calculoVoltage/voltageDivision));

        if(r1r2Coincidence>=coincidence){
          //Collections.sort CUIDADO
          //Creamos la variable resultado de los calculos
          VoltageDivider resultado=new VoltageDivider(r1,r2,r1r2Coincidence);
          //Lo añadimos a la lista de los resistores buenos
          lista_de_voltajes_buenos.add(resultado);



        }


      }
    }
    //Orden de optimizacion en descendente (va en funcion del compareto)
    Collections.sort(lista_de_voltajes_buenos);
    return lista_de_voltajes_buenos;
  }
}

     /*k = r2/(r1+r2)
          if ( K-tol < k < K+tol )
            add r1 and r2 to list of solutions*/