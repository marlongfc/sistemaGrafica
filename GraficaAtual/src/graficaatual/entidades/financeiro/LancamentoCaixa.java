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
@Entity//(name="graficaatual.entidades.financeiro.lancamentoCaixa")
@Table(name = "lancamentoCaixa")
public class LancamentoCaixa implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codLancamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codLancamento;

    @Column(nullable = false, length = 300)
    private String descricao;

    @ManyToOne()
    @JoinColumn(name = "caixa", nullable = false)
    private Caixa caixa;

    @ManyToOne()
    @JoinColumn(name = "planoConta", nullable = false)
    private PlanoDeContas planoConta;

    @Column(nullable = true)
    private Double valorEntrada;

    @Column(nullable = true)
    private Double valorSaida;

    @Column(length = 300)
    private String observacao;

    @Column(name = "dataCadastro")
    private Date dataCadastro;

    @Column(name = "dataAtualizacao")
    private Date dataAtualizacao;

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

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public PlanoDeContas getPlanoConta() {
        return planoConta;
    }

    public void setPlanoConta(PlanoDeContas planoConta) {
        this.planoConta = planoConta;
    }

    public Double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(Double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public Double getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(Double valorSaida) {
        this.valorSaida = valorSaida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
        return "graficaatual.entidades.financeiro.LancamentoCaixa[ codLancamento=" + codLancamento + " ]";
    }

}
