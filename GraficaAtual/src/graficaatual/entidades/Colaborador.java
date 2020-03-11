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
@Table(name = "colaborador")
public class Colaborador implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codColaborador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codColaborador;

    @ManyToOne()
    @JoinColumn(name = "pessoa", nullable = false)
    private Pessoa pessoa;

    @ManyToOne()
    @JoinColumn(name = "cargo", nullable = false)
    private Cargo cargo;

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

    public Colaborador() {
        this.tipoUsuario = 2;
    }

    public Integer getCodColaborador() {
        return codColaborador;
    }

    public void setCodColaborador(Integer codColaborador) {
        this.codColaborador = codColaborador;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
        hash += (codColaborador != null ? codColaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.codColaborador == null && other.codColaborador != null)
                || (this.codColaborador != null && !this.codColaborador.equals(other.codColaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.Usuarios[ codUsuario=" + codColaborador + " ]";
    }

}
