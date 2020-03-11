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
@Table(name = "cargo")
public class Cargo implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codCargo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCargo;

    @Column(nullable = false, length = 300)
    private String descricao;

    @ManyToOne()
    @JoinColumn(name = "turno", nullable = true)
    private Turno turno;

    @Column(nullable = false, length = 30)
    private String login;

    @Column(nullable = false, length = 20)
    private String senha;

    @Column(name = "DataCadastro", nullable = true)
    private java.sql.Timestamp data;

    @Column(name = "tipoUsuario", nullable = false, columnDefinition = "integer default 2")
    private Integer tipoUsuario;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "CodTipo", nullable = true)
    private TipoPermissao tipoPermissao;

    public Cargo() {
        this.tipoUsuario = 2;
    }

    public Integer getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(Integer codCargo) {
        this.codCargo = codCargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        hash += (codCargo != null ? codCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.codCargo == null && other.codCargo != null)
                || (this.codCargo != null && !this.codCargo.equals(other.codCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.Usuarios[ codUsuario=" + codCargo + " ]";
    }

}
