/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades;

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
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codMaterial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codMaterial;

    @Column(name = "descricao", nullable = false, length = 300)
    private String descricao;

    @Column(name = "unidade", nullable = false)
    private int unidade;

    @Column(name = "precoCompra", nullable = true)
    private Double precoCompra;
    
    @Column(name = "precoCustoTotal", nullable = false)
    private Double precoCustoTotal;

    @Column(name = "precoFreteMetro", nullable = true)
    private Double precoFreteMetro;

    @Column(name = "precoFreteQuilo", nullable = true)
    private Double precoFreteQuilo;

    @Column(name = "precoFretePeca", nullable = true)
    private Double precoFretePeca;

    @Column(name = "peso", nullable = true)
    private Double peso;

    @Column(name = "altura", nullable = true)
    private Double altura;

    @Column(name = "largura", nullable = true)
    private Double largura;

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

    public Material() {
        //  this.dataCadastro = new Date();
        //  this.usuarioCadastro = ControleAcesso.usuario.getCodUsuario() + " " + ControleAcesso.usuario.getPessoa().getNome();
    }

    public Long getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Long codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public Double getPrecoFretePeca() {
        return precoFretePeca;
    }

    public void setPrecoFretePeca(Double precoFretePeca) {
        this.precoFretePeca = precoFretePeca;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoCustoTotal() {
        return precoCustoTotal;
    }

    public void setPrecoCustoTotal(Double precoCustoTotal) {
        this.precoCustoTotal = precoCustoTotal;
    }

   

    public Double getPrecoFreteMetro() {
        return precoFreteMetro;
    }

    public void setPrecoFreteMetro(Double precoFreteMetro2) {
        this.precoFreteMetro = precoFreteMetro2;
    }

    public Double getPrecoFreteQuilo() {
        return precoFreteQuilo;
    }

    public void setPrecoFreteQuilo(Double precoFreteQuilo) {
        this.precoFreteQuilo = precoFreteQuilo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMaterial != null ? codMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.codMaterial == null && other.codMaterial != null) || (this.codMaterial != null && !this.codMaterial.equals(other.codMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.Material[ id=" + codMaterial + " ]";
    }

}
