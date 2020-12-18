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
import javax.persistence.Table;

/**
 *
 * @author Moisés
 */
@Entity
@Table(name = "centroDeCustos")
public class CentroDeCustos implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codCentro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCentro;

    @Column(length = 300)
    private String descricao;

    @Column(name = "tipo", nullable = true)
    private Integer tipo; //Receita - Despesa  

    @Column(name = "dataCadastro")
    private Date dataCadastro;

    @Column(name = "dataAtualizacao")
    private Date dataAtualizacao;

    @Column(name = "usuarioCadastro", length = 200)
    private String usuarioCadastro;

    @Column(name = "usuarioAtualizacao", length = 200)
    private String usuarioAtualizacao;

    public Integer getCodCentro() {
        return codCentro;
    }

    public void setCodCentro(Integer codCentro) {
        this.codCentro = codCentro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
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
        hash += (codCentro != null ? codCentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroDeCustos)) {
            return false;
        }
        CentroDeCustos other = (CentroDeCustos) object;
        if ((this.codCentro == null && other.codCentro != null)
                || (this.codCentro != null && !this.codCentro.equals(other.codCentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.financeiro.CentroDeCustos[ codCentro=" + codCentro + " ]";
    }

}
