/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades;
 
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Moisés
 */
@Entity
@Table(name = "itemOrcamento")
public class itemDoOrcamento implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codItemOrcamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codItemOrcamento;
 

    @Column(nullable = true)
    private Double desconto;

    @Column(nullable = false)
    private Double valorUnitario;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne()
    @JoinColumn(name = "produto", nullable = false)
    private Produto produto;

    public Integer getCodItemOrcamento() {
        return codItemOrcamento;
    }

    public void setCodItemOrcamento(Integer codItemOrcamento) {
        this.codItemOrcamento = codItemOrcamento;
    }

 

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codItemOrcamento != null ? codItemOrcamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof itemDoOrcamento)) {
            return false;
        }
        itemDoOrcamento other = (itemDoOrcamento) object;
        if ((this.codItemOrcamento == null && other.codItemOrcamento != null)
                || (this.codItemOrcamento != null && !this.codItemOrcamento.equals(other.codItemOrcamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.itemDoOrcamento[ codOrcamento=" + codItemOrcamento + " ]";
    }

}
