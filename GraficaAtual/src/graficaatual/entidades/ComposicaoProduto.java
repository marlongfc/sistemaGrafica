package graficaatual.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Marlon
 */
@Entity
public class ComposicaoProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codComposicaoProduto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codComposicaoProduto;

    @ManyToOne()
    @JoinColumn(name = "material")
    private Material material;

    @Column(name = "codProduto", nullable = false)
    private Long produto;

    @Column(name = "metragemlinear", nullable = true)
    private Double metragemLinear;

    @Column(name = "largura", nullable = true)
    private Double largura;

    @Column(name = "altura", nullable = true)
    private Double altura;

    @Column(name = "peso", nullable = true)
    private Double peso;

    @Column(name = "unidade", nullable = true)
    private Double unidade;

    @Column(name = "litro", nullable = true)
    private Double litro;
    
        @Column(name = "customaterial", nullable = false)
    private Double custoPorMaterial;


    public ComposicaoProduto() {
    }

    public Long getCodComposicaoProduto() {
        return codComposicaoProduto;
    }

    public void setCodComposicaoProduto(Long codComposicaoProduto) {
        this.codComposicaoProduto = codComposicaoProduto;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
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
       
    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getUnidade() {
        return unidade;
    }

    public void setUnidade(Double unidade) {
        this.unidade = unidade;
    }
    
    public Double getLitro() {
        return litro;
    }

    public void setLitro(Double litro) {
        this.litro = litro;
    }

    public Double getCustoPorMaterial() {
        return custoPorMaterial;
    }

    public void setCustoPorMaterial(Double custoPorMaterial) {
        this.custoPorMaterial = custoPorMaterial;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codComposicaoProduto != null ? codComposicaoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComposicaoProduto)) {
            return false;
        }
        ComposicaoProduto other = (ComposicaoProduto) object;
        if ((this.codComposicaoProduto == null && other.codComposicaoProduto != null) || (this.codComposicaoProduto != null && !this.codComposicaoProduto.equals(other.codComposicaoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.ComposicaoProduto[ id=" + codComposicaoProduto + " ]";
    }
}
