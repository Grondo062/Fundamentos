import java.util.ArrayList;
class Sensor {
    public static ArrayList<Sensor> arrayList = new ArrayList<Sensor>();
    public static int Tamano = 8;
    public static Sensor[] sensores = new Sensor[Tamano];
    public static int posAnadir = 0;
    private double valor;
    private String tipo;

    Sensor() {

    }

    Sensor(String t, double v) {
        this.tipo = t;
        this.valor = v;
        sensores[posAnadir] = this;
        posAnadir += 1;
        if(t.equalsIgnoreCase("temperatura")){
            arrayList.add(this);
        }
    }

    public void setValor(int v) {
        this.valor = v;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    public String getTipo() {
        return this.tipo;
    }

    public double getValor() {
        return this.valor;
    }

    public String toString() {
        String informacion = "";
        informacion += " el tipo es: " + this.tipo;
        informacion += " el valor es: " + Double.toString(this.valor);

        return informacion;
    }

    public static String toStringSensores() {
        String informacion = "";
        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i] != null) {
                informacion += " la informacion del sensor : " + (i + 1);
                informacion += " el tipo es : " + sensores[i].getTipo();
                informacion += " el valor es : " + sensores[i].getValor()+"\n";
            } else {
                break;
            }
        }
        return informacion;
    }

    public static String temperatura() {
        String informacion = "";
        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i] != null && sensores[i].getTipo().equalsIgnoreCase("temperatura")){
                informacion += " la informacion del sensor : " + (i + 1);
                informacion += " el tipo es : " + sensores[i].getTipo();
                informacion += " el valor es : " + sensores[i].getValor()+"\n";
            } 
        }
        return informacion;
    }
    

    public static int cantidadSensores() {
        return posAnadir;
    }
    public static ArrayList <Sensor> lista(){
        int n = arrayList.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arrayList.get(j).getValor() > arrayList.get(j + 1).getValor()) {
                
                    Sensor temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j+1,temp);
                }
        return arrayList;
    }
    public static String imprimir(ArrayList ar){
        return ar.toString();
    }
}
