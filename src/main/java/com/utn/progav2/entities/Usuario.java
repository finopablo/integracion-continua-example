package com.utn.progav2.entities;

import javax.persistence.*;

/**
 * Created by pablo on 01/11/16.
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    private int id;
    private String nombreUsuario;
    private String password;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_usuario" , unique = true, nullable=false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="nombre_usuario", nullable = false, length = 30)
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Column(name="password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
