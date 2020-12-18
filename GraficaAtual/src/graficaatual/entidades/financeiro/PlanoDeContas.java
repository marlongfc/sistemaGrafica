/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades.financeiro;

import java.util.Date;
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
 * @author Moisés
 */
@Entity
@Table(name = "planoDeContas")
public class PlanoDeContas implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codPlano")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPlano;

    @Column(length = 300)
    private String descricao;

    @ManyToOne()
    @JoinColumn(name = "centro", nullable = false)
    private CentroDeCustos centro;

    @Column(name = "dataCadastro")
    private Date dataCadastro;

    @Column(name = "dataAtualizacao")
    private Date dataAtualizacao;

    @Column(name = "usuarioCadastro", length = 200)
    private String usuarioCadastro;

    @Column(name = "usuarioAtualizacao", length = 200)
    private String usuarioAtualizacao;

    public Integer getCodPlano() {
        return codPlano;
    }

    public void setCodPlano(Integer codPlano) {
        this.codPlano = codPlano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CentroDeCustos getCentro() {
        return centro;
    }

    public void setCentro(CentroDeCustos centro) {
        this.centro = centro;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public String getUsuarioAtualizacao() {
        return usuarioAtualizacao;
    }

    public void setUsuarioAtualizacao(String usuarioAtualizacao) {
        this.usuarioAtualizacao = usuarioAtualizacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPlano != null ? codPlano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanoDeContas)) {
            return false;
        }
        PlanoDeContas other = (PlanoDeContas) object;
        if ((this.codPlano == null && other.codPlano != null)
                || (this.codPlano != null && !this.codPlano.equals(other.codPlano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.financeiro.PlanoDeContas[ codPlano=" + codPlano + " ]";
    }

}
