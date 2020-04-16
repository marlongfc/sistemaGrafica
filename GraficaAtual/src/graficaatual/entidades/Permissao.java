
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graficaatual.entidades;



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
import javax.persistence.UniqueConstraint; 

/**
 *
 * @author Projeto X
 * 
 */
@Entity()
@Table(name="permissao",uniqueConstraints=@UniqueConstraint(columnNames={"usuario","formulario"}))
public class Permissao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CodPermissao")
    private Integer codigo;
    
    @ManyToOne
    @JoinColumn(name="usuario",nullable=false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="formulario")
    private Formulario formulario;
    
    @Column(name="DataCadastro")
    private Date data;
    
    @Column(name="Acesso")
    private boolean acesso=false;
    
    @Column(name="Salvar")
    private boolean salvar=true;
    
    @Column(name="Excluir")
    private boolean excluir=true;
    
    @Column(name="Imprimir")
    private boolean imprimir=true;

    public Integer getCodigo() {
        return codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }

    public boolean isExcluir() {
        return excluir;
    }

    public void setExcluir(boolean excluir) {
        this.excluir = excluir;
    }

    public boolean isImprimir() {
        return imprimir;
    }

    public void setImprimir(boolean imprimir) {
        this.imprimir = imprimir;
    }

    public boolean isSalvar() {
        return salvar;
    }

    public void setSalvar(boolean salvar) {
        this.salvar = salvar;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Permissao other = (Permissao) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }
}
