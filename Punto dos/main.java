import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main
{

    public static Equipo crearEquipo(String nombreEquipo, String nombreEstadio, Integer cantidadTitulos, List<Jugador> listaJugadores){
        return new Equipo(nombreEquipo, nombreEstadio, cantidadTitulos, listaJugadores);
    }

    public static Jugador crearJugador(String nombreJugador, String posicionJugador, Boolean esTitular){
        return new Jugador(nombreJugador, posicionJugador, esTitular);
    }

    public static Boolean validarListaJugadores(List<Jugador> litaJugadores){
        long numeroDeTitulares  = litaJugadores.stream()
                .filter(Jugador::getEsTitular)
                .count();

        return numeroDeTitulares == 11L;
    }

    private static boolean esNumero(String entrada){
        try {
            Integer.parseInt(entrada);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    public static void main(String[] args) {
        List<Jugador> list = new ArrayList<>();
        Equipo equipo = null;
        boolean salir = false, salirJugador = false;
        String opcion , opcion2;
        int num1, titulos, num2 ;
        String nom, nomEstadio, numtitulos, nomjugador, posJugador, ti;
        boolean titular;

        Scanner sc = new Scanner(System.in);
        /*Bucle que permite repetir el menu*/
        while (!salir) {
            System.out.println("|   MENU DE SELECCION    |");
            System.out.println("Programa Creador de Equipos \n 1. Crear un equipo  precione 1 \n 2. Generar Reporte simple precione 2 \n 3. Generar reporte detallado precione 3 \n 4. Salir presione 4 \n");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.next();
            if (!esNumero(opcion)) opcion =  "5";
            num1 =Integer.parseInt(opcion);
            /*Switch con cada uno de los casos para las diferentes opciones del menu*/
            switch (num1) {
                case 1:
                    list.clear();
                    salirJugador=false;
                    System.out.println("Bienvenido, Vamos a crear un equipo!");
                    System.out.println("Ingrese un nombre para el equipo: ");
                    nom = sc.next();
                    System.out.println("Ingrese un nombre para el estadio del equipo: ");
                    nomEstadio = sc.next();
                    System.out.println("Ingrese el numero de titulos: ");
                    numtitulos = sc.next();
                    if (!esNumero(numtitulos)) numtitulos =  "0";
                    titulos = Integer.parseInt(numtitulos);
                    while(!salirJugador){
                        System.out.println("Crear Jugador \n 1. Crear un jugador presione 1 \n 2. Menu Principal presione 2  \n");
                        opcion2=sc.next();
                        if (!esNumero(opcion)) opcion2 =  "3";
                        num2 = Integer.parseInt(opcion2);
                        switch (num2){
                            case 1:
                                System.out.println("Ingrese nombre de jugador: ");
                                nomjugador =sc.next();
                                System.out.println("Ingrese posicion del jugador: ");
                                posJugador = sc.next();
                                System.out.println("Ingrese es un jugador titular? Si / No : ");
                                ti =sc.next();
                                titular = ti.equalsIgnoreCase("Si");
                                Jugador jugador = crearJugador(nomjugador, posJugador,titular);
                                if (validarListaJugadores(list)){
                                    System.out.println("Ya hay 11 titulares se crea el jugador como suplente ");
                                    jugador.setEsTitular(false);
                                }
                                list.add(jugador);
                                break;
                            case 2:
                                System.out.println("Regresando al menu!");
                                salirJugador = true;//Se pone la variable salir en verdadero para salir del Bucle
                                break;
                            default:
                                System.out.println("Opcion no valida!");
                        }
                    }

                    equipo=crearEquipo(nom, nomEstadio, titulos, list);
                    System.out.println("Se creo el equipo: "+ nom);
                    break;
                case 2:
                    if (list.isEmpty()){
                        System.out.println("###### No se ha creado un Equipo! #######");
                    }else {
                        System.out.println("###### Reporte Basico! #######");
                        assert equipo != null;
                        System.out.println( equipo.toString());
                    }

                    break;
                case 3:
                    if (list.isEmpty()){
                        System.out.println("###### No se ha creado un Equipo! #######");
                    }else {
                        System.out.println("#### Reporte Detallado! ########");
                        assert equipo != null;
                        System.out.println( equipo.reporteDetallado());
                    }
                    break;
                case 4:
                    System.out.println("Hasta luego!");
                    salir = true;//Se pone la variable salir en verdadero para salir del Bucle
                    break;
                default:
                    System.out.println("Opcion no valida!");
            }
        }
    }

}
