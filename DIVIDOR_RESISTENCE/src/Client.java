import java.util.List;
public class Client {
  /*LO QUE QUIERO ES % DE COINCIDENCIA VIN VOUT LAS RESISTENCIAS E YA*/
  public static void main(String[] args) {
    int numargs = args.length;

    if (numargs == 3) {


      SeriesCatalog seriesCatalog = new SeriesCatalog();
      /*DEFINIMOS LAS VARIABLES QUE PASAMOS POR PARAMETRO*/
      String name = args[0];
      double K = Double.parseDouble(args[1]);
      double percent = Double.parseDouble(args[2]);
      Series s = seriesCatalog.findSeriesByName(name);

      List<VoltageDivider> VoltajesUtiles = VoltageDividerCalculation.calculate(K, percent, s);

      for (VoltageDivider variable : VoltajesUtiles) {
        System.out.println(variable);
      }
      //PORCENTAJE DE K

      //Puede que vout y vin
      //Puede que K deseada
    }else{
      System.out.println("Failed number of arguments");
    }
  }
}
