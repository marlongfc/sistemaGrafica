package graficaatual.entidades.pedido;

import graficaatual.entidades.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Moisés
 */
@Entity
@Table(name = "itemOrcamento")
public class ItemOrcamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codItemOrca")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codItemOrca;

    @ManyToOne()
    @JoinColumn(name = "produto")
    private Produto produto;

    @ManyToOne()
    @JoinColumn(name = "orcamento")
    private Orcamento orcamento;

    @ManyToOne()
    @JoinColumn(name = "acabamento")
    private Acabamento acabamento;

    @Column(nullable = true)
    private Integer quantProd;

    @Column()
    private Double valorTotalProduto;
    
     @Column()
    private Double valorUnitario;

    @Column(length = 10)
    private String medida;

    @Column(length = 10)
    private String unidade;

    public ItemOrcamento() {
    }

    public Integer getCodItemOrca() {
        return codItemOrca;
    }

    public void setCodItemOrca(Integer codItemOrca) {
        this.codItemOrca = codItemOrca;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public Acabamento getAcabamento() {
        return acabamento;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setAcabamento(Acabamento acabamento) {
        this.acabamento = acabamento;
    }

    public Integer getQuantProd() {
        return quantProd;
    }

    public void setQuantProd(Integer quantProd) {
        this.quantProd = quantProd;
    }

    public Double getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(Double valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codItemOrca != null ? codItemOrca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemOrcamento)) {
            return false;
        }
        ItemOrcamento other = (ItemOrcamento) object;
        if ((this.codItemOrca == null && other.codItemOrca != null) || (this.codItemOrca != null && !this.codItemOrca.equals(other.codItemOrca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.pedido.itemOrcamento[ id=" + codItemOrca + " ]";
    }
}
