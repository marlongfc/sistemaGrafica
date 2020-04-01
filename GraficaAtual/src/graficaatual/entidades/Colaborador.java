/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ProjetoX
 */
@Entity
@Table(name = "colaborador")
public class Colaborador implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codColaborador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codColaborador;

    @OneToOne()
    @JoinColumn(name = "pessoa")
    private Pessoa pessoa;

    @ManyToOne()
    @JoinColumn(name = "cargo", nullable = false)
    private Cargo cargo;
    
    @Column(name = "DataInicio", nullable = true)
    private Date dataInicio;
    
    @Column(name = "ativo", nullable = true)
    private boolean ativo;
    
    @Column(name = "salario", nullable = true)
    private Double salario;
     
    @Column(name = "DataFim", nullable = true)
    private Date dataFim;
    
    @Column(name = "ctps", nullable = true)
    private String ctps;

    @Column(name = "DataCadastro", nullable = true)
    private java.sql.Timestamp data;

    public Colaborador() {
       
    }

    public Integer getCodColaborador() {
        return codColaborador;
    }

    public void setCodColaborador(Integer codColaborador) {
        this.codColaborador = codColaborador;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codColaborador != null ? codColaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.codColaborador == null && other.codColaborador != null)
                || (this.codColaborador != null && !this.codColaborador.equals(other.codColaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.Colaborador[ codUsuario=" + codColaborador + " ]";
    }

}
