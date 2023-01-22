package ar.davidbarre.pooclaesabstractas.formularios.validador;

public class LargoValidador extends Validador {
    protected String mensaje = "el campo debe tener minimo %d caracteres y maximo %d caracteres";
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
        return null;
    }

    @Override
    public boolean esValido(String valor) {
        this.mensaje = String.format(this.mensaje, this.minimo, this.maximo);
        if (valor == null) {
            return true;
        }
        int largo = valor.length();
        return (largo >= minimo && largo <= maximo);
    }
}
