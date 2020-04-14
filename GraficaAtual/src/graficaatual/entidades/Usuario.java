/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ProjetoX
 */
///
@Entity
@Table(name = "usuario")
public class Usuario implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codUsuario;

    @OneToOne()
    @JoinColumn(name = "colaborador", nullable = false)
    private Colaborador colaborador;

    @Column(nullable = false, length = 30)
    private String login;

    @Column(nullable = false, length = 20)
    private String senha;

    @Column(name = "DataCadastro", nullable = true)
    private Date data;

    @Column(name = "acessoCadastro", nullable = true)
    private Boolean acessoCadastro;
    
    @Column(name = "acessoPedido", nullable = true)
    private Boolean acessoPedido;
    
    @Column(name = "acessoRelatorios", nullable = true)
    private Boolean acessoRelatorios;
    
    @Column(name = "acessoFinanceiro", nullable = true)
    private Boolean acessoFinanceiro;
    
    @Column(name = "acessoEstoque", nullable = true)
    private Boolean acessoEstoque;
    
    @Column(name = "acessoProducao", nullable = true)
    private Boolean acessoProducao;
    
    @Column(name = "ativo", nullable = true)
    private Boolean ativo;

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    } 

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getAcessoCadastro() {
        return acessoCadastro;
    }

    public void setAcessoCadastro(Boolean acessoCadastro) {
        this.acessoCadastro = acessoCadastro;
    }

    public Boolean getAcessoPedido() {
        return acessoPedido;
    }

    public void setAcessoPedido(Boolean acessoPedido) {
        this.acessoPedido = acessoPedido;
    }

    public Boolean getAcessoRelatorios() {
        return acessoRelatorios;
    }

    public void setAcessoRelatorios(Boolean acessoRelatorios) {
        this.acessoRelatorios = acessoRelatorios;
    }

    public Boolean getAcessoFinanceiro() {
        return acessoFinanceiro;
    }

    public void setAcessoFinanceiro(Boolean acessoFinanceiro) {
        this.acessoFinanceiro = acessoFinanceiro;
    }

    public Boolean getAcessoEstoque() {
        return acessoEstoque;
    }

    public void setAcessoEstoque(Boolean acessoEstoque) {
        this.acessoEstoque = acessoEstoque;
    }

    public Boolean getAcessoProducao() {
        return acessoProducao;
    }

    public void setAcessoProducao(Boolean acessoProducao) {
        this.acessoProducao = acessoProducao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codUsuario == null && other.codUsuario != null)
                || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.Usuarios[ codUsuario=" + codUsuario + " ]";
    }

}
