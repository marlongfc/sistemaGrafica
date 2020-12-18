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
import javax.persistence.Table;

/**
 *
 * @author Moisés
 */
@Entity
@Table(name = "patrimonio")
public class Patrimonio implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codPatrimonio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPatrimonio;

    @Column(nullable = false, length = 300)
    private String descricao;

    @Column(nullable = false)
    private Integer numPatrimonio;

    @Column(nullable = false, length = 100)
    private String marca;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = true)
    private String observacao;

    @Column(name = "dataCadastro")
    private Date dataCadastro;

    @Column(name = "dataAtualizacao")
    private Date dataAtualizacao;

    @Column(name = "usuarioCadastro", length = 200)
    private String usuarioCadastro;

    @Column(name = "usuarioAtualizacao", length = 200)
    private String usuarioAtualizacao;

    @Column(nullable = false)
    private Integer ano;

    public Integer getCodPatrimonio() {
        return codPatrimonio;
    }

    public void setCodPatrimonio(Integer codPatrimonio) {
        this.codPatrimonio = codPatrimonio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNumPatrimonio() {
        return numPatrimonio;
    }

    public void setNumPatrimonio(Integer numPatrimonio) {
        this.numPatrimonio = numPatrimonio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPatrimonio != null ? codPatrimonio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patrimonio)) {
            return false;
        }
        Patrimonio other = (Patrimonio) object;
        if ((this.codPatrimonio == null && other.codPatrimonio != null)
                || (this.codPatrimonio != null && !this.codPatrimonio.equals(other.codPatrimonio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.Patrimonio[ codPatrimonio=" + codPatrimonio + " ]";
    }

}
