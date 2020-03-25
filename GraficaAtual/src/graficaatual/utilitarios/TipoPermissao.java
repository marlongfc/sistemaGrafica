
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graficaatual.utilitarios;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Projeto X
 */
@Entity
@Table(name="int_tipopermissao")
public class TipoPermissao implements Serializable {
    /*
     * 1 - Sem Acesso
     * 2 - Acesso Personalizado
     * 5 - Administrador do Sistema / Módulo
     * 10 - Administrador Geral
     * 30 - Administrador Projeto
    */
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="CodTipo")
    private Integer codigo;
    @Column(name="Dscricao",length=50,nullable=false)
    private String descricao;

    public Integer getCodigo() {
        if (codigo==null) codigo=0;
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoPermissao other = (TipoPermissao) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    public String toString(){
        return this.descricao.trim();
    }
}
