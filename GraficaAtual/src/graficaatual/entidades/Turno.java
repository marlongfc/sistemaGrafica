/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades;

import graficaatual.utilitarios.TipoPermissao;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ProjetoX
 */
@Entity
@Table(name = "turno")
public class Turno implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codTurno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codTurno;

    @Column(nullable = false, length = 300)
    private String descricao;

    @Column(name = "DataCadastro", nullable = true)
    private java.sql.Timestamp data;

    @Column(name = "tipoUsuario", nullable = false, columnDefinition = "integer default 2")
    private Integer tipoUsuario;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "CodTipo", nullable = true)
    private TipoPermissao tipoPermissao;

    public Turno() {
        this.tipoUsuario = 2;
    }

    public Integer getCodTurno() {
        return codTurno;
    }

    public void setCodTurno(Integer codTurno) {
        this.codTurno = codTurno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    } 

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public TipoPermissao getTipoPermissao() {
        return tipoPermissao;
    }

    public void setTipoPermissao(TipoPermissao tipoPermissao) {
        this.tipoPermissao = tipoPermissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTurno != null ? codTurno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.codTurno == null && other.codTurno != null)
                || (this.codTurno != null && !this.codTurno.equals(other.codTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.Usuarios[ codUsuario=" + codTurno + " ]";
    }

}
