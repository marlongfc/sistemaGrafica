/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades.pedido;

import graficaatual.entidades.Cliente;
import graficaatual.entidades.Colaborador;
import graficaatual.entidades.Endereco;
import graficaatual.entidades.Produto;
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
@Table(name = "orcamento")
public class Orcamento implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codOrcamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codOrcamento;

    @Column(nullable = false, length = 300)
    private String descricao;

    @Column(nullable = true)
    private Double desconto;

    @Column(nullable = false)
    private Double valorTotal;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne()
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "colaborador", nullable = false)
    private Colaborador colaborador;

    @ManyToOne()
    @JoinColumn(name = "produto", nullable = false)
    private Produto produto;

    @ManyToOne()
    @JoinColumn(name = "endereco", nullable = false)
    private Endereco endereco;

    @Column(length = 300)
    private String observacao;

    @Column(name = "validade")
    private java.sql.Timestamp validade; //Até qual data o orçamento é valido

    @Column(name = "dataCadastro")
    private java.sql.Timestamp dataCadastro;

    @Column(name = "dataAtualizacao")
    private java.sql.Timestamp dataAtualizacao;

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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Timestamp getValidade() {
        return validade;
    }

    public void setValidade(Timestamp validade) {
        this.validade = validade;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
