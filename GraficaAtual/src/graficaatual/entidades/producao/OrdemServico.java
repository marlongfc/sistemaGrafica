package graficaatual.entidades.producao;

import graficaatual.entidades.Produto;
import graficaatual.entidades.pedido.*;
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
@Table(name = "OrdemServico")
public class OrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codOrdemServico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codOrdemServico;
    
    @ManyToOne()
    @JoinColumn(name = "orcamento")
    private Orcamento orcamento;
    @Column(name = "dataCadastro")
    private Date dataCadastro;
    @Column(name = "usuarioCadastro", length = 200)
    private String usuarioCadastro;
    
    @Column()
    private Boolean checkCriacao;
    @Column(name = "dataFimCriacao")
    private Date dataFimCriacao;
    @Column(name = "usuarioFimCriacao", length = 200)
    private String usuarioFimCriacao;
   
    @Column()
    private Boolean checkSerralheria;
    @Column(name = "dataFimSerralheria")
    private Date dataFimSerralheria; 
    @Column(name = "usuarioFimSerralheria", length = 200)
    private String usuarioFimSerralheria;

    @Column()
    private Boolean checkProjeto;
    @Column(name = "dataFimProjeto")
    private Date dataFimProjeto; 
    @Column(name = "usuarioFimProjeto", length = 200)
    private String usuarioFimProjeto;
    
    @Column()
    private Boolean checkPintura;
    @Column(name = "dataFimPintura")
    private Date dataFimPintura; 
    @Column(name = "usuarioFimPintura", length = 200)
    private String usuarioFimPintura;
    
    @Column()
    private Boolean checkPlotagem;
    @Column(name = "dataFimPlotagem")
    private Date dataFimPlotagem; 
    @Column(name = "usuarioFimPlotagem", length = 200)
    private String usuarioFimPlotagem;

    @Column()
    private Boolean checkImpressaoDigital;
    @Column(name = "dataFimImpressaoDigital")
    private Date dataFimImpressaoDigital; 
    @Column(name = "usuarioFimImpressaoDigital", length = 200)
    private String usuarioFimImpressaoDigital;

    @Column()
    private Boolean checkRouter;
    @Column(name = "dataFimRouter")
    private Date dataFimRouter; 
    @Column(name = "usuarioFimRouter", length = 200)
    private String usuarioFimRouter;

    @Column()
    private Boolean checkAcabamentoImp;
    @Column(name = "dataFimAcabamentoImp")
    private Date dataFimAcabamentoImp; 
    @Column(name = "usuarioFimAcabamentoImp", length = 200)
    private String usuarioFimAcabamentoImp;

    @Column()
    private Boolean checkFaturamento;
    @Column(name = "dataFimFaturamento")
    private Date dataFimFaturamento; 
    @Column(name = "usuarioFimFaturamento", length = 200)
    private String usuarioFimFaturamento;

    @Column()
    private Boolean checkPloterRecorte;
    @Column(name = "dataFimPloterRecorte")
    private Date dataFimPloterRecorte; 
    @Column(name = "usuarioFimPloterRecorte", length = 200)
    private String usuarioFimPloterRecorte;

    @Column()
    private Boolean checkEntrega;
    @Column(name = "dataFimEntrega")
    private Date dataFimEntrega; 
    @Column(name = "usuarioFimEntrega", length = 200)
    private String usuarioFimEntrega;

    @Column()
    private Boolean checkCaixariaAcabamento;
    @Column(name = "dataFimCaixariaAcabamento")
    private Date dataFimCaixariaAcabamento; 
    @Column(name = "usuarioFimCaixariaAcabamento", length = 200)
    private String usuarioFimCaixariaAcabamento;
    
    @ManyToOne()
    @JoinColumn(name = "equipeEntrega")
    private EquipeEntrega equipeEntrega;
    
    @ManyToOne()
    @JoinColumn(name = "produto")
    private Produto produto; 

    public OrdemServico() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public EquipeEntrega getEquipeEntrega() {
        return equipeEntrega;
    }

    public void setEquipeEntrega(EquipeEntrega equipeEntrega) {
        this.equipeEntrega = equipeEntrega;
    }

    public Integer getCodOrdemServico() {
        return codOrdemServico;
    }

    public void setCodOrdemServico(Integer codOrdemServico) {
        this.codOrdemServico = codOrdemServico;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
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

    public Boolean getCheckCriacao() {
        return checkCriacao;
    }

    public void setCheckCriacao(Boolean checkCriacao) {
        this.checkCriacao = checkCriacao;
    }

    public Date getDataFimCriacao() {
        return dataFimCriacao;
    }

    public void setDataFimCriacao(Date dataFimCriacao) {
        this.dataFimCriacao = dataFimCriacao;
    }

    public String getUsuarioFimCriacao() {
        return usuarioFimCriacao;
    }

    public void setUsuarioFimCriacao(String usuarioFimCriacao) {
        this.usuarioFimCriacao = usuarioFimCriacao;
    }

    public Boolean getCheckSerralheria() {
        return checkSerralheria;
    }

    public void setCheckSerralheria(Boolean checkSerralheria) {
        this.checkSerralheria = checkSerralheria;
    }

    public Date getDataFimSerralheria() {
        return dataFimSerralheria;
    }

    public void setDataFimSerralheria(Date dataFimSerralheria) {
        this.dataFimSerralheria = dataFimSerralheria;
    }

    public String getUsuarioFimSerralheria() {
        return usuarioFimSerralheria;
    }

    public void setUsuarioFimSerralheria(String usuarioFimSerralheria) {
        this.usuarioFimSerralheria = usuarioFimSerralheria;
    }

    public Boolean getCheckProjeto() {
        return checkProjeto;
    }

    public void setCheckProjeto(Boolean checkProjeto) {
        this.checkProjeto = checkProjeto;
    }

    public Date getDataFimProjeto() {
        return dataFimProjeto;
    }

    public void setDataFimProjeto(Date dataFimProjeto) {
        this.dataFimProjeto = dataFimProjeto;
    }

    public String getUsuarioFimProjeto() {
        return usuarioFimProjeto;
    }

    public void setUsuarioFimProjeto(String usuarioFimProjeto) {
        this.usuarioFimProjeto = usuarioFimProjeto;
    }

    public Boolean getCheckPintura() {
        return checkPintura;
    }

    public void setCheckPintura(Boolean checkPintura) {
        this.checkPintura = checkPintura;
    }

    public Date getDataFimPintura() {
        return dataFimPintura;
    }

    public void setDataFimPintura(Date dataFimPintura) {
        this.dataFimPintura = dataFimPintura;
    }

    public String getUsuarioFimPintura() {
        return usuarioFimPintura;
    }

    public void setUsuarioFimPintura(String usuarioFimPintura) {
        this.usuarioFimPintura = usuarioFimPintura;
    }

    public Boolean getCheckPlotagem() {
        return checkPlotagem;
    }

    public void setCheckPlotagem(Boolean checkPlotagem) {
        this.checkPlotagem = checkPlotagem;
    }

    public Date getDataFimPlotagem() {
        return dataFimPlotagem;
    }

    public void setDataFimPlotagem(Date dataFimPlotagem) {
        this.dataFimPlotagem = dataFimPlotagem;
    }

    public String getUsuarioFimPlotagem() {
        return usuarioFimPlotagem;
    }

    public void setUsuarioFimPlotagem(String usuarioFimPlotagem) {
        this.usuarioFimPlotagem = usuarioFimPlotagem;
    }

    public Boolean getCheckImpressaoDigital() {
        return checkImpressaoDigital;
    }

    public void setCheckImpressaoDigital(Boolean checkImpressaoDigital) {
        this.checkImpressaoDigital = checkImpressaoDigital;
    }

    public Date getDataFimImpressaoDigital() {
        return dataFimImpressaoDigital;
    }

    public void setDataFimImpressaoDigital(Date dataFimImpressaoDigital) {
        this.dataFimImpressaoDigital = dataFimImpressaoDigital;
    }

    public String getUsuarioFimImpressaoDigital() {
        return usuarioFimImpressaoDigital;
    }

    public void setUsuarioFimImpressaoDigital(String usuarioFimImpressaoDigital) {
        this.usuarioFimImpressaoDigital = usuarioFimImpressaoDigital;
    }

    public Boolean getCheckRouter() {
        return checkRouter;
    }

    public void setCheckRouter(Boolean checkRouter) {
        this.checkRouter = checkRouter;
    }

    public Date getDataFimRouter() {
        return dataFimRouter;
    }

    public void setDataFimRouter(Date dataFimRouter) {
        this.dataFimRouter = dataFimRouter;
    }

    public String getUsuarioFimRouter() {
        return usuarioFimRouter;
    }

    public void setUsuarioFimRouter(String usuarioFimRouter) {
        this.usuarioFimRouter = usuarioFimRouter;
    }

    public Boolean getCheckAcabamentoImp() {
        return checkAcabamentoImp;
    }

    public void setCheckAcabamentoImp(Boolean checkAcabamentoImp) {
        this.checkAcabamentoImp = checkAcabamentoImp;
    }

    public Date getDataFimAcabamentoImp() {
        return dataFimAcabamentoImp;
    }

    public void setDataFimAcabamentoImp(Date dataFimAcabamentoImp) {
        this.dataFimAcabamentoImp = dataFimAcabamentoImp;
    }

    public String getUsuarioFimAcabamentoImp() {
        return usuarioFimAcabamentoImp;
    }

    public void setUsuarioFimAcabamentoImp(String usuarioFimAcabamentoImp) {
        this.usuarioFimAcabamentoImp = usuarioFimAcabamentoImp;
    }

    public Boolean getCheckFaturamento() {
        return checkFaturamento;
    }

    public void setCheckFaturamento(Boolean checkFaturamento) {
        this.checkFaturamento = checkFaturamento;
    }

    public Date getDataFimFaturamento() {
        return dataFimFaturamento;
    }

    public void setDataFimFaturamento(Date dataFimFaturamento) {
        this.dataFimFaturamento = dataFimFaturamento;
    }

    public String getUsuarioFimFaturamento() {
        return usuarioFimFaturamento;
    }

    public void setUsuarioFimFaturamento(String usuarioFimFaturamento) {
        this.usuarioFimFaturamento = usuarioFimFaturamento;
    }

    public Boolean getCheckPloterRecorte() {
        return checkPloterRecorte;
    }

    public void setCheckPloterRecorte(Boolean checkPloterRecorte) {
        this.checkPloterRecorte = checkPloterRecorte;
    }

    public Date getDataFimPloterRecorte() {
        return dataFimPloterRecorte;
    }

    public void setDataFimPloterRecorte(Date dataFimPloterRecorte) {
        this.dataFimPloterRecorte = dataFimPloterRecorte;
    }

    public String getUsuarioFimPloterRecorte() {
        return usuarioFimPloterRecorte;
    }

    public void setUsuarioFimPloterRecorte(String usuarioFimPloterRecorte) {
        this.usuarioFimPloterRecorte = usuarioFimPloterRecorte;
    }

    public Boolean getCheckEntrega() {
        return checkEntrega;
    }

    public void setCheckEntrega(Boolean checkEntrega) {
        this.checkEntrega = checkEntrega;
    }

    public Date getDataFimEntrega() {
        return dataFimEntrega;
    }

    public void setDataFimEntrega(Date dataFimEntrega) {
        this.dataFimEntrega = dataFimEntrega;
    }

    public String getUsuarioFimEntrega() {
        return usuarioFimEntrega;
    }

    public void setUsuarioFimEntrega(String usuarioFimEntrega) {
        this.usuarioFimEntrega = usuarioFimEntrega;
    }

    public Boolean getCheckCaixariaAcabamento() {
        return checkCaixariaAcabamento;
    }

    public void setCheckCaixariaAcabamento(Boolean checkCaixariaAcabamento) {
        this.checkCaixariaAcabamento = checkCaixariaAcabamento;
    }

    public Date getDataFimCaixariaAcabamento() {
        return dataFimCaixariaAcabamento;
    }

    public void setDataFimCaixariaAcabamento(Date dataFimCaixariaAcabamento) {
        this.dataFimCaixariaAcabamento = dataFimCaixariaAcabamento;
    }

    public String getUsuarioFimCaixariaAcabamento() {
        return usuarioFimCaixariaAcabamento;
    }

    public void setUsuarioFimCaixariaAcabamento(String usuarioFimCaixariaAcabamento) {
        this.usuarioFimCaixariaAcabamento = usuarioFimCaixariaAcabamento;
    }

  


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOrdemServico != null ? codOrdemServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemServico)) {
            return false;
        }
        OrdemServico other = (OrdemServico) object;
        if ((this.codOrdemServico == null && other.codOrdemServico != null) || (this.codOrdemServico != null && !this.codOrdemServico.equals(other.codOrdemServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.OrdemServico.codOrdemServico[ id=" + codOrdemServico + " ]";
    }
}
