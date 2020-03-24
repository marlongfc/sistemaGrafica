/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades;

import java.sql.Timestamp;
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
@Table(name = "lancamentoCaixa")
public class LancamentoCaixa implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codLancamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codLancamento;

    @Column(nullable = false, length = 300)
    private String descricao;

    @Column(nullable = false)
    private Double valor;

    @ManyToOne()
    @JoinColumn(name = "colaborador", nullable = false)
    private Colaborador colaborador;

    @Column(length = 300)
    private String observacao;

    @Column(name = "dataCadastro")
    private java.sql.Timestamp dataCadastro;

    @Column(name = "dataAtualizacao")
    private java.sql.Timestamp dataAtualizacao;

    @Column(name = "usuarioCadastro", length = 200)
    private String usuarioCadastro;

    @Column(name = "usuarioAtualizacao", length = 200)
    private String usuarioAtualizacao;

    public Integer getCodLancamento() {
        return codLancamento;
    }

    public void setCodLancamento(Integer codLancamento) {
        this.codLancamento = codLancamento;
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

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
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
        hash += (codLancamento != null ? codLancamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LancamentoCaixa)) {
            return false;
        }
        LancamentoCaixa other = (LancamentoCaixa) object;
        if ((this.codLancamento == null && other.codLancamento != null)
                || (this.codLancamento != null && !this.codLancamento.equals(other.codLancamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.LancamentoCaixa[ codLancamento=" + codLancamento + " ]";
    }

}
