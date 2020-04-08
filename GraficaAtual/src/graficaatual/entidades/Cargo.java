/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ProjetoX
 */
@Entity
@Table(name = "cargo")
public class Cargo implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codCargo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCargo;
 
    @Column(name = "descricao",nullable = false, length = 300)
    private String descricao;
    
    @Column(name = "crm", length = 30)
    private String crm;
    
    @Column(name = "funcao",columnDefinition = "text")
    private String funcao;
    
    @Column(name = "especificacao",columnDefinition = "text")
    private String especificacao;

    @ManyToOne()
    @JoinColumn(name = "turno")
    private Turno turno;

    @Column(name = "dataCadastro")
    private Date dataCadastro;
    
     @Column(name = "dataAtualizacao")
    private Date dataAtualizacao;
     
    @Column(name = "UsuarioCadastro")
    private String UsuarioCadastro;
    
    @Column(name = "UsuarioAtualizacao")
    private String UsuarioAtualizacao;
     
    public Cargo() {
       
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Integer getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(Integer codCargo) {
        this.codCargo = codCargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
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
        return UsuarioCadastro;
    }

    public void setUsuarioCadastro(String UsuarioCadastro) {
        this.UsuarioCadastro = UsuarioCadastro;
    }

    public String getUsuarioAtualizacao() {
        return UsuarioAtualizacao;
    }

    public void setUsuarioAtualizacao(String UsuarioAtualizacao) {
        this.UsuarioAtualizacao = UsuarioAtualizacao;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCargo != null ? codCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.codCargo == null && other.codCargo != null)
                || (this.codCargo != null && !this.codCargo.equals(other.codCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.Usuarios[ codUsuario=" + codCargo + " ]";
    }

}
