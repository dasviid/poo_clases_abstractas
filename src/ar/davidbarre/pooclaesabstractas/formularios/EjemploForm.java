package ar.davidbarre.pooclaesabstractas.formularios;

import ar.davidbarre.pooclaesabstractas.formularios.elementos.*;
import ar.davidbarre.pooclaesabstractas.formularios.elementos.select.Opcion;
import ar.davidbarre.pooclaesabstractas.formularios.validador.*;


import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InmputForm usernames = new InmputForm("usernames");
        usernames.addValidador(new RequeridoValidador());
        InmputForm password = new InmputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));
        InmputForm email = new InmputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());
        InmputForm edad = new InmputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());
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
        password.setValor("1234567");
        email.setValor("john.doe@correos.com");
        edad.setValor("asdf");
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

        elementos.forEach(e -> {
            if (!e.esValido()) {
                e.getErrores().forEach(System.out::println);
            }
        });


    }
}
