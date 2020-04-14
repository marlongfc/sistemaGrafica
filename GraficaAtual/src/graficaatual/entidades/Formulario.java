package graficaatual.entidades;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Projeto X
 */
@Entity
@Table(name="formulario")
public class Formulario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CodFormulario")
    private Integer CodFormulario;
    @Column(name="Formulario",length=150,unique=true)
    private String formulario;
    @Column(name="Titulo",length=250)
    private String titulo;
    @Column(name="Modulo",length=250)
    private String Modulo;

    public Integer getCodFormulario() {
        return CodFormulario;
    }

    public void setCodFormulario(Integer CodFormulario) {
        this.CodFormulario = CodFormulario;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModulo() {
        return Modulo;
    }

    public void setModulo(String Modulo) {
        this.Modulo = Modulo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Formulario other = (Formulario) obj;
        if (this.CodFormulario != other.CodFormulario && (this.CodFormulario == null || !this.CodFormulario.equals(other.CodFormulario))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.CodFormulario != null ? this.CodFormulario.hashCode() : 0);
        return hash;
    }

}
