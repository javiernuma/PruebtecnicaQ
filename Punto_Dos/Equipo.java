import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Equipo {
    private String nombreEquipo;
    private String nombreEstadio;
    private Integer numeroTitulos;
    private List<Jugador> jugadorArrayList;

    public Equipo(String nombreEquipo,
                  String nombreEstadio,
                  Integer numeroTitulos,
                  List<Jugador> jugadorArrayList) {
        this.nombreEquipo = nombreEquipo;
        this.nombreEstadio = nombreEstadio;
        this.numeroTitulos = numeroTitulos;
        this.jugadorArrayList = jugadorArrayList;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public Integer getNumeroTitulos() {
        return numeroTitulos;
    }

    public void setNumeroTitulos(Integer numeroTitulos) {
        this.numeroTitulos = numeroTitulos;
    }

    public List<Jugador> getJugadorArrayList() {
        return jugadorArrayList;
    }

    public void setJugadorArrayList(List<Jugador> jugadorArrayList) {
        this.jugadorArrayList = jugadorArrayList;
    }

    @Override
    public String toString() {
        return "Equipo { \n" +
                "nombre_del_Equipo='" + nombreEquipo + "\n" +
                ", nombre_del_Estadio='" + nombreEstadio + "\n" +
                ", numero_de_Titulos=" + numeroTitulos +"\n"+
                ", numero_de_jugadores=" + jugadorArrayList.size()  +"\n" +
                '}';
    }

    public String reporteDetallado(){
        String numeroDeTitulares  = this.jugadorArrayList.stream()
                .filter(Jugador::getEsTitular)
                .map(Jugador::toString).collect(Collectors.joining(","));

        String suplentes  = this.jugadorArrayList.stream()
                .filter(jugador -> !jugador.getEsTitular()).map(Jugador::toString).collect(Collectors.joining(","));

        return "Equipo{ \n" +
                "nombreEquipo=" + nombreEquipo + "\n" +
                "nombreEstadio=" + nombreEstadio + "\n" +
                "numeroTitulos=" + numeroTitulos + "\n" +
                "Jugadores titulares = {\n " + numeroDeTitulares +"\n}"+
                "Jugadores Suplentes = {\n" + suplentes +"\n}"+
                '}';
    }
}
