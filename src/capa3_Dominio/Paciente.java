/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa3_Dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Cristhian
 */
public class Paciente {

    private String dni;
    private String nombre;
    private String direccion;
    private String correo;
    private String telefono;
    private int edad;
    private boolean mayorDeEdad;

    public Paciente() {
    }

    public Paciente(String DNI, String Nombre, String Direccion, String Correo, String Telefono, boolean mayorDeEdad, int edad) {
        this.dni = DNI;
        this.nombre = Nombre;
        this.direccion = Direccion;
        this.correo = Correo;
        this.telefono = Telefono;
        this.edad = edad;
        this.mayorDeEdad = true;
    }

    public Paciente(String dni, String nombre, String direccion, String correo, String telefono, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
    }

    public Paciente(String DNI) {
        this.dni = DNI;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String Telefono) {
        this.telefono = Telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isMayorDeEdad() {
        return mayorDeEdad;
    }

    public void setMayorDeEdad(boolean mayorDeEdad) {
        this.mayorDeEdad = mayorDeEdad;
    }

    public boolean tieneNombreValido() {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre es nulo");
        }

        if (nombre.length() < 15 || nombre.length() > 50) {

            throw new IllegalArgumentException("La longitud del nombre no es válida");

        }

        String patron = "^[A-Za-zÁáÉéÍíÓóÚúÜüÇçÑñ ]+$";
        if (!nombre.matches(patron)) {
            throw new IllegalArgumentException("El nombre contiene caracteres no válidos");
        }

        return true;
    }

    public boolean tieneDireccionValida() {
        if (direccion == null) {
            throw new IllegalArgumentException("La dirección es nula");
        }

        if (direccion.length() < 15 || direccion.length() > 50) {
            throw new IllegalArgumentException("La longitud de la dirección no es válida");
        }

        String patron = "^[A-Za-zÁáÉéÍíÓóÚúÜüÇçÑñ0-9.,\\-\\s]+$";
        if (!direccion.matches(patron)) {
            throw new IllegalArgumentException("La dirección contiene caracteres no válidos");
        }

        return true;
    }

    public boolean tieneDNIValido() {
        if (dni == null) {
            throw new IllegalArgumentException("El DNI es nulo");
        }

        if (!dni.strip().matches("\\d+") || dni.length() != 8) {
            throw new IllegalArgumentException("El DNI no es válido");
        }

        return true;
    }


    public boolean tieneTelefonoValido() {
        if (telefono == null) {
            throw new IllegalArgumentException("El número de teléfono es nulo");
        }

        if (!telefono.strip().matches("\\d+") || telefono.length() != 9) {
            throw new IllegalArgumentException("El número de teléfono no es válido");
        }

        return true;
    }

    public boolean tieneCorreoElectronicoValido() {
        if (correo == null) {
            throw new IllegalArgumentException("El correo electrónico es nulo");
        }

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("El correo electrónico no es válido");
        }

        return true;
    }


    public boolean tieneEdadValida() {
        if (edad < 18 || edad > 120) {
            throw new IllegalArgumentException("La edad no está en el rango válido (debe ser mayor o igual a 18 y menor o igual a 120).");
        }

        return true;
    }

    public boolean esPacienteValido() {
        List<String> errores = new ArrayList<>();

        try {
            if (!tieneNombreValido()) {
                errores.add("El nombre no es válido.");
            }
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        try {
            if (!tieneDireccionValida()) {
                errores.add("La dirección no es válida.");
            }
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        try {
            if (!tieneDNIValido()) {
                errores.add("El DNI no es válido.");
            }
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        try {
            if (!tieneTelefonoValido()) {
                errores.add("El teléfono no es válido.");
            }
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        try {
            if (!tieneCorreoElectronicoValido()) {
                errores.add("El correo electrónico no es válido.");
            }
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        try {
            if (!tieneEdadValida()) {
                errores.add("La edad no es válida.");
            }
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        if (errores.isEmpty()) {
            return true;
        } else {
            System.out.println(errores);
            throw new IllegalArgumentException("Error en el paciente: " + errores);
        }
    }


    @Override
    public String toString() {
        return "Paciente{" + "dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", edad=" + edad + ", mayorDeEdad=" + mayorDeEdad + '}';
    }

}
