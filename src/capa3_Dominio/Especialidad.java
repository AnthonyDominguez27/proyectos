/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa3_Dominio;

/**
 *
 * @author Cristhian
 */
public class Especialidad {

    private int especialidadID;
    private String especialidad;
    private Consultorio consultorio;

    public Especialidad(int especialidadID, String nombre, Consultorio consultorio) {
        this.especialidadID = especialidadID;
        this.especialidad = nombre;
        this.consultorio = consultorio;
    }

    public Especialidad(String especialidad, Consultorio consultorio) {
        this.especialidad = especialidad;
        this.consultorio = consultorio;
    }

       
    public Especialidad() {
    }

    public Especialidad(int especialidadID) {
        this.especialidadID = especialidadID;
    }

    public int getEspecialidadID() {
        return especialidadID;
    }

    public void setEspecialidadID(int especialidadID) {
        this.especialidadID = especialidadID;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "especialidadID=" + especialidadID + ", especialidad=" + especialidad + ", consultorio=" + consultorio.getConsultorio() + '}';
    }
    
    
}
