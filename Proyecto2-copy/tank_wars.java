import java.util.Scanner;

class tank_wars {
    static int tankes;
    static tanke[][] tablero = new tanke[2][2];
    static int disparos;

    static void crearTablero() {
        int aleatorio = (int) (Math.random() * 4) + 1;
        tankes = aleatorio;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++, aleatorio--) {
                if (aleatorio > 0) {
                    tanke a = new tanke();
                    tank_wars.tablero[i][j] = a;
                } else {
                    break;
                }

            }
        }
    }

    static void bombaAtomica() {
        int aleatorior;
        int aleatorio2;
        while (true) {
            aleatorior = (int) Math.round(Math.random());
            aleatorio2 = (int) Math.round(Math.random());
            if (tank_wars.tablero[aleatorior][aleatorio2] != null) {
                if (tank_wars.tablero[aleatorior][aleatorio2].vida > 0) {
                    tank_wars.tablero[aleatorior][aleatorio2].vida = 0;
                    tankes--;
                    break;
                }

            } else {
                continue;
            }
        }
    }
     static int sumar(){
        int suma = 0 ;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if(tank_wars.tablero[i][j] != null){
                suma += tank_wars.tablero[i][j].vida;
                }
            }
        }

        return suma;
     }
    static void activarTankeMutante() {
        int Posmenorx = 0;
        int Posmenory = 0;
        int prueba =  Integer.MAX_VALUE;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tank_wars.tablero[i][j] != null)
                    if (tank_wars.tablero[i][j].vida > 0
                            && tank_wars.tablero[i][j].vida < prueba) {
                               prueba =tank_wars.tablero[i][j].vida;      
                        Posmenorx = i;
                        Posmenory = j;
                    }
            }
        }
        tank_wars.tablero[Posmenorx][Posmenory].vida *= 2;
    }

    static void disparar(int x, int y) {
        if(tank_wars.tablero[x][y] != null){
        if (tank_wars.tablero[x][y].vida > 0 ) {
            if (tank_wars.tablero[x][y].vida <= 5) {
                tank_wars.tablero[x][y].vida = 0;
                disparos++;
                tankes--;
            } else {
                tank_wars.tablero[x][y].vida -= 5;
                disparos++;
            }
        } else {
            System.out.println("ese tanke no existe o ya esta muerto");
        }
    }else{
        System.out.println("no existe");
    }
}

    static void MostrarTablero() {
        System.out.println("--------------");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tank_wars.tablero[i][j] != null) {
                    System.out.print("|" + tank_wars.tablero[i][j].toString() + "|");
                } else {
                    System.out.print("|" + "     " + "|");
                }
            }
            System.out.println();
            System.out.println("--------------");
        }
    }

    static void la_Frase_de_la_abuela() {
        int aleatorio = (int) (Math.random() * 4) + 1;
        switch (aleatorio) {
            case 1:
                System.out.println(
                        "en mis tiempos no teniamos estos tankes !teniamos palos! dos palos y una piedra !Y teniamos que compartir la piedra!  ");
                break;
            case 2:
                System.out.println("VAMOS A PATEAR TANKES ALIENIGENAS");
                break;
            case 3:
                System.out.println("no luches una batalla si no ganas nada con la victoria");
                break;
            case 4:
                System.out.println(" la victoria esta reservada para aquellos que estan dispuestos a pagar su precio");
                break;
            default:
                System.out.println("la guerra nunca es buena mata el alma y la envenena");
                break;
        }
    }

    public static class tanke {
        static int disparos;
        String tipo;
        int vida;

        tanke() {
            int tipo = (int) (Math.random() * 4) + 1;
            if (tipo == 1) {
                this.tipo = "BA";
                this.vida = 20;
            } else {
                this.tipo = "BN";
                this.vida = 10;
            }
        }

        public String toString() {
            return this.tipo + "-" + this.vida;
        }

    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("menu de opciones");
        System.out.println("1) disparar tankes  " + '\n' +
        "2) bombaAtomica" + '\n' +
        "3) la frase de la abuela" + '\n' +
        "4) tanque mutante " + '\n'+"5) cantidad disparos " + '\n'+"6) sumar salud " + '\n'
          );
        int n = scanner.nextInt();
        while (n != 0) {
            switch (n) {
                case 1:
                    System.out.println("digite la posicion x A disparar, entre 0 y 1");
                    int x = scanner.nextInt();
                    System.out.println("digite la posicion y A disparar, entre 0 y 1");
                    int y = scanner.nextInt();
                    if(x > 2 || y > 2 || x < 0 || y < 0 ){
                        System.out.println("no haga trampa :(");
                        break;
                    }else{
                    tank_wars.disparar(x, y);
                    }
                    break;
                case 2:
                    tank_wars.bombaAtomica();
                    break;
                case 3:
                    tank_wars.la_Frase_de_la_abuela();
                    break;
                case 4:
                    tank_wars.activarTankeMutante();
                    break;
                case 5:
                    System.out.println(disparos);
                    break;
                case 6:
                    System.out.println(tank_wars.sumar());    
                default:
                    System.out.println("digite un valor valido");  
                    break;  
            }
            if(tankes == 0){
                break;
            }
            tank_wars.MostrarTablero();
            System.out.println("1) disparar tankes  " + '\n' +
                    "2) bombaAtomica" + '\n' +
                    "3) la frase de la abuela" + '\n' +
                    "4) tanque mutante " + '\n'+"5) cantidad disparos " + '\n'+"6) sumar salud " + '\n'
                      );
            n = scanner.nextInt();

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("digite 1 para empezar el juego");
        int n = scanner.nextInt();
        while(n == 1){
        tank_wars.crearTablero();
        tank_wars.MostrarTablero();
        menu();
        }
        System.out.println("fin del juego");
    }
    

}