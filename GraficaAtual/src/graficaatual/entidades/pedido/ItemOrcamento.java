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
