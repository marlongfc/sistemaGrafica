/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades.financeiro;

import graficaatual.entidades.Cliente;
import graficaatual.entidades.Fornecedor;
import graficaatual.entidades.pedido.Orcamento;
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
@Table(name = "contasAPagar")
public class ContasAPagar implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codContasPag")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codContasPag;

    @Column(nullable = true, length = 300)
    private String descricao;

    @ManyToOne()
    @JoinColumn(name = "caixa", nullable = true)
    private Caixa caixa;

    @ManyToOne()
    @JoinColumn(name = "orcamento")
    private Orcamento orcamento;

    @ManyToOne()
    @JoinColumn(name = "fornecedor")
    private Fornecedor fornecedor;

    @ManyToOne()
    @JoinColumn(name = "planoContas")
    private PlanoDeContas planoContas;

    @ManyToOne()
    @JoinColumn(name = "formaPagamento")
    private FormaDePagamento formaPagamento;

    @Column()
    private Double valorTotal;

    @Column()
    private Double valorPago;

    @Column()
    private Double valorPagar;

    @Column(name = "dataPrevista")
    private Date dataPrevista;

    @Column(name = "dataPagamento")
    private Date dataPagamento;

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

    public Integer getCodContasPag() {
        return codContasPag;
    }

    public void setCodContasPag(Integer codContasPag) {
        this.codContasPag = codContasPag;
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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(Double valorPagar) {
        this.valorPagar = valorPagar;
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

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public PlanoDeContas getPlanoContas() {
        return planoContas;
    }

    public void setPlanoContas(PlanoDeContas planoContas) {
        this.planoContas = planoContas;
    }

    public FormaDePagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaDePagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codContasPag != null ? codContasPag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContasAPagar)) {
            return false;
        }
        ContasAPagar other = (ContasAPagar) object;
        if ((this.codContasPag == null && other.codContasPag != null)
                || (this.codContasPag != null && !this.codContasPag.equals(other.codContasPag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.financeiro.ContasAPagar[ codContasPag=" + codContasPag + " ]";
    }

}
