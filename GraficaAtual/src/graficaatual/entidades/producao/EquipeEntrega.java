package graficaatual.entidades.producao;

import graficaatual.entidades.Colaborador;
import java.io.Serializable;
import java.util.Date;
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
 * @author Danilo Bispo
 */
@Entity
@Table(name = "EquipeEntrega")
public class EquipeEntrega implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codEquipeEntrega")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codEquipeEntrega;
    
   @Column(name = "nome", length = 200)
    private String nome;   
        
   @Column(name = "dataCadastro")
    private Date dataCadastro;
   
    @Column(name = "usuarioCadastro", length = 200)
    private String usuarioCadastro;    
    
    @Column(name = "dataCancelamento")
    private Date dataCancelamento;
   
    @Column(name = "usuarioCancelamento", length = 200)
    private String usuarioCancelamento;    
    
    @Column(name = "telefone1", length = 30)
    private String telefone1;    
    
    @Column(name = "telefone2", length = 30)
    private String telefone2;
    
    @Column(name = "placaCarro", length = 30)
    private String placaCarro;
        
    @Column(name = "modeloCarro", length = 200)
    private String modeloCarro;  
  
    
    @Column(name = "observacao",columnDefinition = "text")
    private String observacao;  
        
    @Column(name = "capacidade")
    private Double capacidade;

    @ManyToOne()
    @JoinColumn(name = "colaborador1")
    private Colaborador colaborador1;

    @ManyToOne()
    @JoinColumn(name = "colaborador2")
    private Colaborador colaborador2;

    @ManyToOne()
    @JoinColumn(name = "colaborador3")
    private Colaborador colaborador3;

    @ManyToOne()
    @JoinColumn(name = "colaborador4")
    private Colaborador colaborador4;

    public EquipeEntrega() {
    }

    public Integer getCodEquipeEntrega() {
        return codEquipeEntrega;
    }

    public void setCodEquipeEntrega(Integer codEquipeEntrega) {
        this.codEquipeEntrega = codEquipeEntrega;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public String getUsuarioCancelamento() {
        return usuarioCancelamento;
    }

    public void setUsuarioCancelamento(String usuarioCancelamento) {
        this.usuarioCancelamento = usuarioCancelamento;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public Double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Double capacidade) {
        this.capacidade = capacidade;
    }

    public Colaborador getColaborador1() {
        return colaborador1;
    }

    public void setColaborador1(Colaborador colaborador1) {
        this.colaborador1 = colaborador1;
    }

    public Colaborador getColaborador2() {
        return colaborador2;
    }

    public void setColaborador2(Colaborador colaborador2) {
        this.colaborador2 = colaborador2;
    }

    public Colaborador getColaborador3() {
        return colaborador3;
    }

    public void setColaborador3(Colaborador colaborador3) {
        this.colaborador3 = colaborador3;
    }

    public Colaborador getColaborador4() {
        return colaborador4;
    }

    public void setColaborador4(Colaborador colaborador4) {
        this.colaborador4 = colaborador4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEquipeEntrega != null ? codEquipeEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipeEntrega)) {
            return false;
        }
        EquipeEntrega other = (EquipeEntrega) object;
        if ((this.codEquipeEntrega == null && other.codEquipeEntrega != null) || (this.codEquipeEntrega != null && !this.codEquipeEntrega.equals(other.codEquipeEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.EquipeEntrega.codEquipeEntrega[ id=" + codEquipeEntrega + " ]";
    }
}
