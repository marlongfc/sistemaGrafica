/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades.estoque;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Marlon
 */
@Entity
public class EntradaEstoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codEntradaEstoque")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codEntradaEstoque;

    @Column(name = "tipoEntrada", nullable = false)
    private Integer tipoEntrada;

    @Column(name = "notaFiscal", nullable = true)
    private String notaFiscal;

    @Column(name = "quantidade", nullable = true)
    private Double quantidade;

    @Column(name = "marca", nullable = true)
    private String marca;

    @Column(name = "cor", nullable = true)
    private String cor;

    @Column(name = "Observacao", nullable = true)
    private String observacao;

    @Column(name = "ValorCompra", nullable = true)
    private Double valorCompra;

    @Column(name = "ValorUnitario", nullable = true)
    private Double valorUnitario;

    @Column(name = "metragemLinear", nullable = true)
    private Double metragemLinear;

    @Column(name = "largura", nullable = true)
    private Double largura;

    @Column(name = "altura", nullable = true)
    private Double altura;

    @Column(name = "unidadesChapas", nullable = true)
    private Integer unidadesChapas;

    @Column(name = "unidade", nullable = true)
    private Double unidade;

    @Column(name = "peso", nullable = true)
    private Double peso;

    @Column(name = "litro", nullable = true)
    private Double litro;

    @Column(name = "codMaterial", nullable = false)
    private Long codMaterial;

    @Column(name = "descMaterial", nullable = false)
    private String descMaterial;

    @Column(name = "codFornecedor", nullable = true)
    private Long codFornecedor;

    @Column(name = "descFornecedor", nullable = true)
    private String descFornecedor;

    @Column(name = "cancelada", nullable = false)
    private boolean cancelada;

    @Column(name = "dataValidade", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataValidade;

    @Column(name = "dataCadastro", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;

    @Column(name = "dataAtualizacao", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtualizacao;

    @Column(name = "usuarioCadastro", length = 200)
    private String usuarioCadastro;

    @Column(name = "usuarioAtualizacao", length = 200)
    private String usuarioAtualizacao;

    public EntradaEstoque() {
        //  this.dataCadastro = new Date();
        //  this.usuarioCadastro = ControleAcesso.usuario.getCodUsuario() + " " + ControleAcesso.usuario.getPessoa().getNome();
    }

    public Long getCodEntradaEstoque() {
        return codEntradaEstoque;
    }

    public void setCodEntradaEstoque(Long codEntradaEstoque) {
        this.codEntradaEstoque = codEntradaEstoque;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Integer getUnidadesChapas() {
        return unidadesChapas;
    }

    public void setUnidadesChapas(Integer unidadesChapas) {
        this.unidadesChapas = unidadesChapas;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(Integer tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getMetragemLinear() {
        return metragemLinear;
    }

    public void setMetragemLinear(Double metragemLinear) {
        this.metragemLinear = metragemLinear;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getUnidade() {
        return unidade;
    }

    public void setUnidade(Double unidade) {
        this.unidade = unidade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getLitro() {
        return litro;
    }

    public void setLitro(Double litro) {
        this.litro = litro;
    }

    public String getDescFornecedor() {
        return descFornecedor;
    }

    public void setDescFornecedor(String descFornecedor) {
        this.descFornecedor = descFornecedor;
    }

    public Long getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Long codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getDescMaterial() {
        return descMaterial;
    }

    public void setDescMaterial(String descMaterial) {
        this.descMaterial = descMaterial;
    }

    public Long getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Long codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
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

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEntradaEstoque != null ? codEntradaEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaEstoque)) {
            return false;
        }
        EntradaEstoque other = (EntradaEstoque) object;
        if ((this.codEntradaEstoque == null && other.codEntradaEstoque != null) || (this.codEntradaEstoque != null && !this.codEntradaEstoque.equals(other.codEntradaEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.Material[ id=" + codEntradaEstoque + " ]";
    }

}
