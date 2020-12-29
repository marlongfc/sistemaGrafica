/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades.estoque;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class SaidaEstoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codSaidaEstoque")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codSaidaEstoque;

    @Column(name = "tipoSaida", nullable = false)
    private Integer tipoSaida;

    @Column(name = "quantidade", nullable = true)
    private Double quantidade;

    @Column(name = "numeroPedido", nullable = true)
    private Integer numeroPedido;

    @Column(name = "Observacao", nullable = true)
    private String observacao;

    @Column(name = "ValorVendaAvulsa", nullable = true)
    private BigDecimal valorVendaAvulsa;

    @Column(name = "codLocalArmazenamento", nullable = true)
    private Long codLocalArmazenamento;

    @Column(name = "codMaterial", nullable = true)
    private Long codMaterial;

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

    
    /*
    @ManyToOne()
    @JoinColumn(name = "material")
    private Material material;

    @ManyToOne()
    @JoinColumn(name = "fornecedor")
    private Fornecedor fornecedor;
     */
 
    
    public SaidaEstoque() {
        //  this.dataCadastro = new Date();
        //  this.usuarioCadastro = ControleAcesso.usuario.getCodUsuario() + " " + ControleAcesso.usuario.getPessoa().getNome();
    }


    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
  
    public Long getCodLocalArmazenamento() {
        return codLocalArmazenamento;
    }

    public void setCodLocalArmazenamento(Long codLocalArmazenamento) {
        this.codLocalArmazenamento = codLocalArmazenamento;
    }

    public Long getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Long codMaterial) {
        this.codMaterial = codMaterial;
    }

    public Long getCodSaidaEstoque() {
        return codSaidaEstoque;
    }

    public void setCodSaidaEstoque(Long codSaidaEstoque) {
        this.codSaidaEstoque = codSaidaEstoque;
    }

    public Integer getTipoSaida() {
        return tipoSaida;
    }

    public void setTipoSaida(Integer tipoSaida) {
        this.tipoSaida = tipoSaida;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public BigDecimal getValorVendaAvulsa() {
        return valorVendaAvulsa;
    }

    public void setValorVendaAvulsa(BigDecimal valorVendaAvulsa) {
        this.valorVendaAvulsa = valorVendaAvulsa;
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
        hash += (codSaidaEstoque != null ? codSaidaEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaidaEstoque)) {
            return false;
        }
        SaidaEstoque other = (SaidaEstoque) object;
        if ((this.codSaidaEstoque == null && other.codSaidaEstoque != null) || (this.codSaidaEstoque != null && !this.codSaidaEstoque.equals(other.codSaidaEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.Material[ id=" + codSaidaEstoque + " ]";
    }

}
