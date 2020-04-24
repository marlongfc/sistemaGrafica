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
@Table(name = "requisicaoFinanceira")
public class RequisicaoFinanceira implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codRequisicao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codRequisicao;

    @Column(length = 500)
    private String descricao;

    @Column(length = 1000)
    private String observacao;

    @Column()
    private Double valor;

    @Column(name = "dataCadastro")
    private Date dataCadastro;

    @Column(name = "dataAtualizacao")
    private Date dataAtualizacao;

    @Column(name = "usuarioCadastro", length = 200)
    private String usuarioCadastro;

    @Column(name = "usuarioAtualizacao", length = 200)
    private String usuarioAtualizacao;

    public Integer getCodRequisicao() {
        return codRequisicao;
    }

    public void setCodRequisicao(Integer codRequisicao) {
        this.codRequisicao = codRequisicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRequisicao != null ? codRequisicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisicaoFinanceira)) {
            return false;
        }
        RequisicaoFinanceira other = (RequisicaoFinanceira) object;
        if ((this.codRequisicao == null && other.codRequisicao != null)
                || (this.codRequisicao != null && !this.codRequisicao.equals(other.codRequisicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.financeiro.RequisicaoFinanceira[ codRequisicao=" + codRequisicao + " ]";
    }

}
