package graficaatual.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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

    @Id
    @ManyToOne()
    @JoinColumn(name = "produto")
    private Produto produto;

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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
