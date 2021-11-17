public class Jugador {
    private String nombre;
    private String posicion;
    private Boolean esTitular;

    public Jugador(String nombre, String posicion, Boolean esTitular) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.esTitular = esTitular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Boolean getEsTitular() {
        return esTitular;
    }

    public void setEsTitular(Boolean esTitular) {
        this.esTitular = esTitular;
    }

    @Override
    public String toString() {
        return "{\n" +
                "nombre=" + nombre + '\n' +
                "posicion=" + posicion + '\n' +
                "Estado de alineacion =" +(esTitular? "Titular" : "Suplente") +  '\n'+
                '}';
    }
}
