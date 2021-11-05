package com.gestionhotelera.cammons.habitaciones.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer idPago;

    @Column(name = "id_transaccion", unique = true)
    private String idTransaccion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pago")
    private Date fechaPago;

    @Column(name = "tipo_pago")
    private String tipoPago;

    @OneToOne
    @JsonIgnoreProperties(value = {"pago"}, allowSetters = true)
    @JoinColumn(name = "id_venta", updatable = false, nullable = false)
    private Ventas venta;

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public Ventas getVenta() {
        return venta;
    }

}
