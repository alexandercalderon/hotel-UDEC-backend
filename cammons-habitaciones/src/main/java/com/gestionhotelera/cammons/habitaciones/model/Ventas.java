package com.gestionhotelera.cammons.habitaciones.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer idVenta;

    @Temporal( TemporalType.DATE)
    @Column(name = "fec_venta")
    private Date fecVenta;

    @Column(name = "total_venta")
    private Long totalVente;

    @OneToOne(mappedBy = "ventas", cascade = CascadeType.ALL)
    private CheckOut checkOut;

    public CheckOut getCheckOut() {
        return checkOut;
    }

    public void setPago(Pagos pago) {
        this.pago = pago;
    }

    public void setCheckOut(CheckOut checkOut) {
        this.checkOut = checkOut;
    }

    public Pagos getPago() {
        return pago;
    }

    @JsonIgnoreProperties(value = {"venta"}, allowSetters = true)
    @OneToOne(mappedBy = "venta", cascade = CascadeType.ALL)
    private Pagos pago;

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public void setFecVenta(Date fecVenta) {
        this.fecVenta = fecVenta;
    }

    public void setTotalVente(Long totalVente) {
        this.totalVente = totalVente;
    }


    public Integer getIdVenta() {
        return idVenta;
    }

    public Long getTotalVente() {
        return totalVente;
    }

    public Date getFecVenta() {
        return fecVenta;
    }
}
