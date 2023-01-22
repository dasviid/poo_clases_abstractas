package ar.davidbarre.pooclaesabstractas.formularios;

import ar.davidbarre.pooclaesabstractas.formularios.elementos.*;
import ar.davidbarre.pooclaesabstractas.formularios.elementos.select.Opcion;


import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InmputForm usernames = new InmputForm("usernames");
        InmputForm password = new InmputForm("clave", "password");
        InmputForm email = new InmputForm("email", "email");
        InmputForm edad = new InmputForm("edad", "number");

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addOpcion(new Opcion("1", "java").setSelected())
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "PHP"));

        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "< input disable name= \" " + this.nombre + " \" value=\"" + valor + "\">";
            }
        };

        saludar.setValor("Hola que tal este campo esta deshabilitado");
        usernames.setValor("john.doe");
        password.setValor("12345");
        email.setValor("john.doe@correos.com");
        edad.setValor("26");
        experiencia.setValor("... mas de 10 años de experiencia...");
        //java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(usernames,
                password,
                email,
                experiencia,
                lenguaje,
                saludar);


     /*   for (ElementoForm e: elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }*/

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });


    }
}
