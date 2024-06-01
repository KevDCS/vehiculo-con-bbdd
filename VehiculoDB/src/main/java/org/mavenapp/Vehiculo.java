package org.mavenapp;

import java.util.*;

public class Vehiculo {

    Integer idVehiculo;
    String tipo;
    String marca;
    Integer potencia;
    Date fechaCompra;


    // Constructor Vacio
    public Vehiculo() {
    }

    // Constructor con datos
    public Vehiculo(Integer idVehiculo, String tipo, String marca, Integer potencia, Date fechaCompra) {
        this.idVehiculo = idVehiculo;
        this.tipo = tipo;
        this.marca = marca;
        this.potencia = potencia;
        this.fechaCompra = fechaCompra;
    }

    // Getters y Setters


    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
