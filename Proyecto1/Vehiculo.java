class Vehiculo {

    public static int Tamano = 10;
    public static Vehiculo[] vehiculos = new Vehiculo[Tamano];
    public static int posAnadir = 0;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;

    Vehiculo() {

    }

    Vehiculo(int mo, String ma, double va) {
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = "verde";
        vehiculos[posAnadir] = this;
        Vehiculo.posAnadir += 1;
    }

    Vehiculo(int mo, String ma, double va, String co) {
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;
        vehiculos[posAnadir] = this;
        Vehiculo.posAnadir += 1;
    }

    public void setModelo(int mo) {
        this.modelo = mo;
    }

    public void setMarca(String ma) {
        this.marca = ma;
    }

    public void setColor(String co) {
        this.color = co;
    }

    public String getcolor() {

        return this.color;
    }

    public int getmodelo() {

        return this.modelo;
    }

    public String getmarca() {

        return this.marca;
    }

    public double getvalorComercial() {
        return this.valorComercial;
    }

    @Override
    public String toString() {
        String informacion = "";
        informacion += " el modelo es : " + Integer.toString(this.modelo);
        informacion += " la marca es : " + this.marca;
        informacion += " el color es : " + this.color;
        informacion += " el valor comercial es : " + Double.toString(this.valorComercial);

        return informacion;
    }

    public static String toStringVehiculos() {
        String informacion = "";
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null) {
                informacion += " la informacion del vehiculo : " + (i + 1);
                informacion += " el modelo es : " + Integer.toString(vehiculos[i].getmodelo());
                informacion += " la marca es : " + vehiculos[i].getmarca();
                informacion += " el color es : " + vehiculos[i].getcolor();
                informacion += " el valor comercial es : " + Double.toString(vehiculos[i].getvalorComercial()) + "\n";
            } else {
                break;
            }

        }

        return informacion;
    }

    public static int cantidadVehiculos() {
        return posAnadir;
    }

    public static String vehiculosNuevos() {
        String informacion = "";
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null && vehiculos[i].getmodelo() >= 2000 && vehiculos[i].getmodelo() <= 2021) {
                informacion += " la informacion del vehiculo: " + (i + 1);
                informacion += " el modelo es: " + Integer.toString(vehiculos[i].getmodelo());
                informacion += " la marca es: " + vehiculos[i].getmarca();
                informacion += " el color es: " + vehiculos[i].getcolor();
                informacion += " el valor comercial es : " + Double.toString(vehiculos[i].getvalorComercial()) + "\n";
            }
        }

        return informacion;
    }

    public static String verdes() {
        String informacion = "";
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null && vehiculos[i].getcolor().equalsIgnoreCase("verde")) {
                informacion += " la informacion del vehiculo : " + (i + 1);
                informacion += " el modelo es: " + Integer.toString(vehiculos[i].getmodelo());
                informacion += " la marca es: " + vehiculos[i].getmarca();
                informacion += " el color es: " + vehiculos[i].getcolor();
                informacion += " el valor comercial es : " + Double.toString(vehiculos[i].getvalorComercial()) + "\n";
            }
        }

        return informacion;

    }

}
