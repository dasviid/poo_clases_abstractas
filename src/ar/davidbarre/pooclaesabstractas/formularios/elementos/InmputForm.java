package ar.davidbarre.pooclaesabstractas.formularios.elementos;

public class InmputForm extends ElementoForm {

    private String tipo = "text";

    public InmputForm(String nombre) {
        super(nombre);
    }

    public InmputForm(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String dibujarHtml() {
        return "<input type='" + tipo
                + "' name='" + nombre
                + "' value='" + valor
                + "'>";
    }
}
