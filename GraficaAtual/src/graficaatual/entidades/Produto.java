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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Marlon
 */
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codProduto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProduto;

    @Column(name = "descricao", nullable = false, length = 300)
    private String descricao;

    
    @JoinColumn(name = "composicaoProduto", nullable = false)
    private ComposicaoProduto composicaoProduto;

    @Column(name = "valorProdutoM2", nullable = true, length = 10)
    private Double valorProdutoM2;

    @Column(name = "maoDeObra", nullable = true)
    private Double maoDeObra;

    @Column(name = "custoEmpresa", nullable = true)
    private Double custoEmpresa;

    @Column(name = "custoTotal", nullable = true)
    private Double custoTotal;

    @Column(name = "valorUnitario", nullable = true)
    private Double valorUnitario;

    @Column(name = "margemLucro", nullable = true)
    private Double margemLucro;

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

    public Produto() {
        //   this.dataCadastro = new Date();
        //   this.usuarioCadastro = ControleAcesso.usuario.getCodUsuario() + " " + ControleAcesso.usuario.getPessoa().getNome();
    }

    public Double getValorProdutoM2() {
        return valorProdutoM2;
    }

    public void setValorProdutoM2(Double valorProdutoM2) {
        this.valorProdutoM2 = valorProdutoM2;
    }

    public Double getMaoDeObra() {
        return maoDeObra;
    }

    public void setMaoDeObra(Double maoDeObra) {
        this.maoDeObra = maoDeObra;
    }

    public Double getCustoEmpresa() {
        return custoEmpresa;
    }

    public void setCustoEmpresa(Double custoEmpresa) {
        this.custoEmpresa = custoEmpresa;
    }

    public Double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(Double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public ComposicaoProduto getComposicaoProduto() {
        return composicaoProduto;
    }

    public void setComposicaoProduto(ComposicaoProduto composicaoProduto) {
        this.composicaoProduto = composicaoProduto;
    }
    
    

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(Double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public Long getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Long codProduto) {
        this.codProduto = codProduto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProduto != null ? codProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codProduto == null && other.codProduto != null) || (this.codProduto != null && !this.codProduto.equals(other.codProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.Produto[ id=" + codProduto + " ]";
    }

}
