import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void opciones(){
        System.out.println("Hola te doy la bienvenida al sistema de creacion de sensores y vehiculos seleccione un numero"+
        "\n"+"1) crear un nuevo vehiculo "+"\n"+ "2) mostrar todos los vehiculos creados "+
        "\n"+"3) cantidad de vehiculos creados"+"\n"+"4) mostrar los vehiculos verdes "+
        "\n"+"5) mostrar todos los vehiculos entre el 2001 y 2021 "+"\n"+"6) crear un sensor"+"\n"+"7) mostrar todos los sensores "
        +"\n"+"8) saber cuantos sensores se han creado"+"\n"+"9) mostrar todos los sensores de tipo temperatura"+"\n"+
        "666) mostrar todos los sensores de tipo temperatura ordenados por su valor de menor a mayor"+"\n"+"0) para salir");



    }    
    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        opciones();
        int i = sc.nextInt();
        while (i != 0) {
            switch (i) {
                case 0:
                    break;
                case 1:
                    System.out.println("digite los siguientes valores de modelo, marca, valor, y color ");
                    if (Vehiculo.cantidadVehiculos() < 9) {
                        int mo = sc.nextInt();
                        sc.nextLine();
                        String ma = sc.nextLine();
                        double va = sc.nextDouble();
                        sc.nextLine();
                        String co = sc.nextLine();
                        Vehiculo r = new Vehiculo(mo, ma, va, co);
                    }else{
                        System.out.println("BASE DE DATOS LLENA");
                    }
                    break;
                case 2:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
                case 3:
                    System.out.println(Vehiculo.cantidadVehiculos());
                    break;
                case 4:
                    System.out.println(Vehiculo.verdes());
                    break;
                case 5:
                    System.out.println(Vehiculo.vehiculosNuevos());
                    break;
                case 6:
                if (Vehiculo.cantidadVehiculos() < 9) {
                    System.out.println("digite los datos para el sensor el valor y el tipo");
                    double v = sc.nextDouble();
                    String t = sc.next();
                    Sensor r = new Sensor(t, v);
                }else{
                    System.out.println("base de datos llena");
                }
                    break;
                case 7:
                    System.out.println(Sensor.toStringSensores());

                    break;
                case 8:
                    
                    System.out.println(Sensor.cantidadSensores());

                    break;
                case 9:
                    System.out.println(Sensor.temperatura());
                    break;
                case 666:
                    ArrayList lista =  Sensor.lista();
                    System.out.println(Sensor.imprimir(lista));
                    break;
                default:
                    System.out.println("por favor utilice otro numero");
            }
            opciones();
            i = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        mostrarMenu();
    }
}

//Isabella Grondona Puerta y Juan Pablo González Ocampo