/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades.financeiro;
 
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Moisés
 */
@Entity
@Table(name = "caixa")
public class Caixa implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codCaixa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCaixa;

    @Column(length = 300)
    private String descricao;

    @Column()
    private Double valorInicial; 
    
    @Column()
    private Double valorAberturaDia;
    
    @Column()
    private Double valorFechamentoDia;

    @Column(length = 300)
    private String observacao;

    @Column(name = "dataCadastro")
    private Date dataCadastro;

    @Column(name = "dataAtualizacao")
    private Date dataAtualizacao;

    @Column(name = "usuarioCadastro", length = 200)
    private String usuarioCadastro;

    @Column(name = "usuarioAtualizacao", length = 200)
    private String usuarioAtualizacao;

    public Integer getCodCaixa() {
        return codCaixa;
    }

    public void setCodCaixa(Integer codCaixa) {
        this.codCaixa = codCaixa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorAberturaDia() {
        return valorAberturaDia;
    }

    public void setValorAberturaDia(Double valorAberturaDia) {
        this.valorAberturaDia = valorAberturaDia;
    }

    public Double getValorFechamentoDia() {
        return valorFechamentoDia;
    }

    public void setValorFechamentoDia(Double valorFechamentoDia) {
        this.valorFechamentoDia = valorFechamentoDia;
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
        hash += (codCaixa != null ? codCaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.codCaixa == null && other.codCaixa != null)
                || (this.codCaixa != null && !this.codCaixa.equals(other.codCaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.financeiro.Caixa[ codCaixa=" + codCaixa + " ]";
    }

}
