/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades.pedido;

import graficaatual.entidades.Acabamento;
import graficaatual.entidades.Cliente;
import graficaatual.entidades.Endereco;
import graficaatual.entidades.Produto;
import graficaatual.entidades.financeiro.FormaDePagamento;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Moisés
 */
@Entity//(name="graficaatual.entidades.pedido.Orcamento")
@Table(name = "orcamento")
public class Orcamento implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codOrcamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codOrcamento;

    @ManyToOne()
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "endereco")
    private Endereco endereco;

    @Column(name = "dataOrcamento")
    private Date dataOrcamento;

    @Column(name = "validadeOrcamento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date validadeOrcamento; //Até qual data o orçamento é valido

    @Column(name = "prazoEntrega")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date prazoEntrega;

    @ManyToOne()
    @JoinColumn(name = "formaPagamento")
    private FormaDePagamento formaPagamento;

    @ManyToOne()
    @JoinColumn(name = "produto")
    private Produto produto;

    @Column(nullable = true)
    private Boolean situacao;

    @Column(nullable = true)
    private Double descontoProduto;

    @Column(length = 300)
    private String clienteSecundario;

    @Column(length = 20)
    private String telefoneSecundario;

    @Column(length = 300)
    private String enderecoSecundario;

    @Column()
    private Integer tipoDeEntrega;

    @Column(nullable = true)
    private Double descontoGeral;

    @Column(nullable = true)
    private Double descontoGeralPorcentagem;

    @Column(nullable = true)
    private Double acrescimoGeral;

    @Column(nullable = false)
    private Double valorTotal;

    @Column(nullable = true)
    private Boolean etapaSetor;

    @Column(name = "dataCadastro")
    private Date dataCadastro;

    @Column(name = "dataAtualizacao")
    private Date dataAtualizacao;

    @Column(name = "usuarioCadastro", length = 200)
    private String usuarioCadastro;

    @Column(name = "usuarioAtualizacao", length = 200)
    private String usuarioAtualizacao;

    public Integer getCodOrcamento() {
        return codOrcamento;
    }

    
    public void setCodOrcamento(Integer codOrcamento) {
        this.codOrcamento = codOrcamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(Date dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    public Date getValidadeOrcamento() {
        return validadeOrcamento;
    }

    public void setValidadeOrcamento(Date validadeOrcamento) {
        this.validadeOrcamento = validadeOrcamento;
    }

    public Date getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(Date prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public FormaDePagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaDePagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public Double getDescontoProduto() {
        return descontoProduto;
    }

    public void setDescontoProduto(Double descontoProduto) {
        this.descontoProduto = descontoProduto;
    }

    public String getClienteSecundario() {
        return clienteSecundario;
    }

    public void setClienteSecundario(String clienteSecundario) {
        this.clienteSecundario = clienteSecundario;
    }

    public String getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public void setTelefoneSecundario(String telefoneSecundario) {
        this.telefoneSecundario = telefoneSecundario;
    }

    public String getEnderecoSecundario() {
        return enderecoSecundario;
    }

    public void setEnderecoSecundario(String enderecoSecundario) {
        this.enderecoSecundario = enderecoSecundario;
    }

    public Integer getTipoDeEntrega() {
        return tipoDeEntrega;
    }

    public void setTipoDeEntrega(Integer tipoDeEntrega) {
        this.tipoDeEntrega = tipoDeEntrega;
    }

    public Double getDescontoGeral() {
        return descontoGeral;
    }

    public void setDescontoGeral(Double descontoGeral) {
        this.descontoGeral = descontoGeral;
    }

    public Double getAcrescimoGeral() {
        return acrescimoGeral;
    }

    public void setAcrescimoGeral(Double acrescimoGeral) {
        this.acrescimoGeral = acrescimoGeral;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Boolean getEtapaSetor() {
        return etapaSetor;
    }

    public void setEtapaSetor(Boolean etapaSetor) {
        this.etapaSetor = etapaSetor;
    }

    public Double getDescontoGeralPorcentagem() {
        return descontoGeralPorcentagem;
    }

    public void setDescontoGeralPorcentagem(Double descontoGeralPorcentagem) {
        this.descontoGeralPorcentagem = descontoGeralPorcentagem;
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
        hash += (codOrcamento != null ? codOrcamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamento)) {
            return false;
        }
        Orcamento other = (Orcamento) object;
        if ((this.codOrcamento == null && other.codOrcamento != null)
                || (this.codOrcamento != null && !this.codOrcamento.equals(other.codOrcamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.pedido.Orcamento[ codOrcamento=" + codOrcamento + " ]";
    }

}
