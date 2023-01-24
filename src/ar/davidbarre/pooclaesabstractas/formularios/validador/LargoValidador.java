package ar.davidbarre.pooclaesabstractas.formularios.validador;

import ar.davidbarre.pooclaesabstractas.formularios.validador.mensaje.MensajeFormateable;

public class LargoValidador extends Validador implements MensajeFormateable {
    protected String mensaje = "el campo %s debe tener minimo %d caracteres y maximo %d caracteres";
    private int minimo;
    private int maximo = Integer.MAX_VALUE;

    public LargoValidador() {
    }

    public LargoValidador(int minimo, int maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    @Override
    public void setMensaje(String mensaje) {

    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        //  this.mensaje = String.format(this.mensaje, this.minimo, this.maximo);
        if (valor == null) {
            return true;
        }
        int largo = valor.length();
        return (largo >= minimo && largo <= maximo);
    }


    @Override
    public String getMensajeFormateado(String campo) {
        return this.mensaje = String.format(this.mensaje, campo, this.minimo, this.maximo);
    }
}
