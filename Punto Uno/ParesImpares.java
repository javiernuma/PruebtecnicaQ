import java.util.Scanner;

public class ParesImpares {
    static final String QUIPUX = "Quipux";
    static final String NO_QUIPUX = "No Quipux";

    public static void validarNumero(int numero){
        if (numero%2 == 0){
            if(numero >= 2 && numero <5){
                System.out.println(NO_QUIPUX);
            }else if(numero >= 6 && numero <=20) System.out.println(QUIPUX);
            else System.out.println(NO_QUIPUX);
        } else System.out.println(QUIPUX);
    }

    public static void main(String[] args){

        boolean salir = false;
        int opcion;
        int num1;

        Scanner sc = new Scanner(System.in);
        while (!salir) {
            System.out.print("Programa Quipox \n 1. Ingresar numero entero presione 1 \n 2. Salir presione 2 \n");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Bienvenido, vamos a validar un numero que ingreses!");
                    System.out.print("Ingrese un numero: ");
                    num1 = sc.nextInt();
                    validarNumero(num1);
                    break;
                case 2:
                    System.out.print("Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.print("Opcion no valida!");
            }
        }

    }
}
