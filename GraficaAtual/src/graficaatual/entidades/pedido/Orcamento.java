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
    @JoinColumn(name = "acabamento")
    private Acabamento acabamento;

    @ManyToOne()
    @JoinColumn(name = "produto")
    private Produto produto;

    @Column(nullable = true)
    private Boolean situacao;

    @Column()
    private Integer quantProd;

    @Column(nullable = true)
    private Double descontoProduto;

    @Column()
    private Double valorTotalProduto;

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

    @Column(nullable = true)
    private Double valorTotal;

    @Column(nullable = true)
    private Boolean etapaSetor;

    @Column(length = 10)
    private String medida;

    @Column(length = 10)
    private String unidade;

    @Column()
    private Boolean checkCriacao;

    @Column()
    private Boolean checkSerralheria;

    @Column()
    private Boolean checkProjeto;

    @Column()
    private Boolean checkPintura;

    @Column()
    private Boolean checkPlotagem;

    @Column()
    private Boolean checkAcabamento;

    @Column()
    private Boolean checkImpressaoDigital;

    @Column()
    private Boolean checkRouter;

    @Column()
    private Boolean checkAcabamentoImp;

    @Column()
    private Boolean checkFaturamento;

    @Column()
    private Boolean checkPloterRecorte;

    @Column()
    private Boolean checkEntrega;

    @Column()
    private Boolean checkCaixariaAcabamento;

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

    public Acabamento getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(Acabamento acabamento) {
        this.acabamento = acabamento;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Integer getQuantProd() {
        return quantProd;
    }

    public void setQuantProd(Integer quantProd) {
        this.quantProd = quantProd;
    }

    public Double getDescontoProduto() {
        return descontoProduto;
    }

    public void setDescontoProduto(Double descontoProduto) {
        this.descontoProduto = descontoProduto;
    }

    public Double getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(Double valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
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

    public Boolean getCheckCriacao() {
        return checkCriacao;
    }

    public void setCheckCriacao(Boolean checkCriacao) {
        this.checkCriacao = checkCriacao;
    }

    public Boolean getCheckSerralheria() {
        return checkSerralheria;
    }

    public void setCheckSerralheria(Boolean checkSerralheria) {
        this.checkSerralheria = checkSerralheria;
    }

    public Boolean getCheckProjeto() {
        return checkProjeto;
    }

    public void setCheckProjeto(Boolean checkProjeto) {
        this.checkProjeto = checkProjeto;
    }

    public Boolean getCheckPintura() {
        return checkPintura;
    }

    public void setCheckPintura(Boolean checkPintura) {
        this.checkPintura = checkPintura;
    }

    public Boolean getCheckPlotagem() {
        return checkPlotagem;
    }

    public void setCheckPlotagem(Boolean checkPlotagem) {
        this.checkPlotagem = checkPlotagem;
    }

    public Boolean getCheckAcabamento() {
        return checkAcabamento;
    }

    public void setCheckAcabamento(Boolean checkAcabamento) {
        this.checkAcabamento = checkAcabamento;
    }

    public Boolean getCheckImpressaoDigital() {
        return checkImpressaoDigital;
    }

    public void setCheckImpressaoDigital(Boolean checkImpressaoDigital) {
        this.checkImpressaoDigital = checkImpressaoDigital;
    }

    public Boolean getCheckRouter() {
        return checkRouter;
    }

    public void setCheckRouter(Boolean checkRouter) {
        this.checkRouter = checkRouter;
    }

    public Boolean getCheckAcabamentoImp() {
        return checkAcabamentoImp;
    }

    public void setCheckAcabamentoImp(Boolean checkAcabamentoImp) {
        this.checkAcabamentoImp = checkAcabamentoImp;
    }

    public Boolean getCheckFaturamento() {
        return checkFaturamento;
    }

    public void setCheckFaturamento(Boolean checkFaturamento) {
        this.checkFaturamento = checkFaturamento;
    }

    public Boolean getCheckPloterRecorte() {
        return checkPloterRecorte;
    }

    public void setCheckPloterRecorte(Boolean checkPloterRecorte) {
        this.checkPloterRecorte = checkPloterRecorte;
    }

    public Boolean getCheckEntrega() {
        return checkEntrega;
    }

    public void setCheckEntrega(Boolean checkEntrega) {
        this.checkEntrega = checkEntrega;
    }

    public Boolean getCheckCaixariaAcabamento() {
        return checkCaixariaAcabamento;
    }

    public void setCheckCaixariaAcabamento(Boolean checkCaixariaAcabamento) {
        this.checkCaixariaAcabamento = checkCaixariaAcabamento;
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
