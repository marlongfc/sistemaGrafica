/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades.estoque;

import graficaatual.entidades.Fornecedor;
import graficaatual.entidades.Material;
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
public class MaterialEstoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codMaterialEstoque")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codMaterialEstoque;


    @Column(name = "notaFiscal", nullable = false)
    private String unidadeMedida;

    @Column(name = "quantidadeReal", nullable = true)
    private Double quantidadeReal;

    @Column(name = "marca", nullable = true)
    private String marca;

    @Column(name = "cor", nullable = false)
    private String cor;

    @ManyToOne()
    @JoinColumn(name = "material")
    private Material material;

    @ManyToOne()
    @JoinColumn(name = "fornecedor")
    private Fornecedor fornecedor;

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

    public MaterialEstoque() {
        //  this.dataCadastro = new Date();
        //  this.usuarioCadastro = ControleAcesso.usuario.getCodUsuario() + " " + ControleAcesso.usuario.getPessoa().getNome();
    }

    public Long getCodMaterialEstoque() {
        return codMaterialEstoque;
    }

    public void setCodMaterialEstoque(Long codMaterialEstoque) {
        this.codMaterialEstoque = codMaterialEstoque;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getQuantidadeReal() {
        return quantidadeReal;
    }

    public void setQuantidadeReal(Double quantidadeReal) {
        this.quantidadeReal = quantidadeReal;
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMaterialEstoque != null ? codMaterialEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialEstoque)) {
            return false;
        }
        MaterialEstoque other = (MaterialEstoque) object;
        if ((this.codMaterialEstoque == null && other.codMaterialEstoque != null) || (this.codMaterialEstoque != null && !this.codMaterialEstoque.equals(other.codMaterialEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.Material[ id=" + codMaterialEstoque + " ]";
    }

}
