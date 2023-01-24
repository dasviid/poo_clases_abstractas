package ar.davidbarre.pooclaesabstractas.formularios.elementos;

import ar.davidbarre.pooclaesabstractas.formularios.validador.LargoValidador;
import ar.davidbarre.pooclaesabstractas.formularios.validador.Validador;
import ar.davidbarre.pooclaesabstractas.formularios.validador.mensaje.MensajeFormateable;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm {

    protected String valor;
    protected String nombre;

    private List<Validador> validadores;
    private List<String> errores;


    public ElementoForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public List<String> getErrores() {
        return errores;
    }

    public ElementoForm addValidador(Validador validador) {
        this.validadores.add(validador);
        return this;
    }


    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean esValido() {
        for (Validador v : validadores) {
            if (!v.esValido(valor)) {
                if (v instanceof MensajeFormateable) {
                    this.errores.add(((MensajeFormateable) v).getMensajeFormateado(nombre));
                } else {
                    this.errores.add(String.format(v.getMensaje(), nombre));
                }
            }
        }
        return this.errores.isEmpty();
    }

    abstract public String dibujarHtml();


}
