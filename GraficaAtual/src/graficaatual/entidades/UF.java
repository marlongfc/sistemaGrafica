/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Marlon
 */
@Entity
public class UF implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codUF")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codUF;

    @Column(name = "descricao", nullable = false, length = 300)
    private String descricao;

    @Column(name = "abreviatura", nullable = true, length = 2)
    private String abreviatura;

    public UF() {
          }
 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUF != null ? codUF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UF)) {
            return false;
        }
        UF other = (UF) object;
        if ((this.codUF == null && other.codUF != null) || (this.codUF != null && !this.codUF.equals(other.codUF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.UF[ id=" + codUF + " ]";
    }


    public Long getCodUF() {
        return codUF;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setCodUF(Long codUF) {
        this.codUF = codUF;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

}