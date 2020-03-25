
package graficaatual.utilitarios;

import java.awt.Container;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Projeto X
 */
public class Componentes implements java.io.Serializable {

    private JTableBinding ModeloBinding;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup = new org.jdesktop.beansbinding.BindingGroup();
    private JTable Lista = new JTable();
    private JTextField Codigo;
    private JTextArea CodigoTextArea;
    private JTextField Descricao;
    private JTextArea Descricao2;
    private int Altura = 0, Largura = 0, X = 0, Y = 0;
    private Container container;
    private javax.swing.JScrollPane SLista;
    private boolean FvaControle = false, FvaLista = false;
    private Vector<Integer> VetorTamanho = new Vector();

    private boolean Editable = false;

    public Componentes(List ListaDados, boolean Editable, JTextField codigo, JTextField descricao, Container conteinGeral, Container contein, int largura, int altura) {
        Codigo = codigo;
        Descricao = descricao;
        Largura = largura;
        Altura = altura;
        this.container = conteinGeral;
        X = (int) (contein.getBounds().getX() + Descricao.getBounds().getX());
        Y = (int) (contein.getBounds().getY() + Descricao.getBounds().getY() + Descricao.getBounds().getHeight() - 1);
        SLista = new javax.swing.JScrollPane();
        Lista.setBackground(new java.awt.Color(255, 255, 204));
        Lista.setAutoCreateRowSorter(true);
        Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMouseClicked(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                ListaMousePressed(evt);
            }
        });
        Lista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ListaFocusLost(evt);
            }
        });
        Lista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListaKeyPressed(evt);
            }
        });

        SLista.setViewportView(Lista);
        container.add(SLista, 0);
        SLista.setBounds(X, Y, Largura, Altura);
        SLista.setVisible(false);

        Descricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DescricaoFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                DescricaoFocusLost(evt);
            }
        });
        Descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DescricaoKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                DescricaoKeyReleased(evt);
            }
        });

        try {
            this.Editable = Editable;
            ModeloBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, ListaDados, Lista);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar criar tabela de vinculação. Erro: " + e);
            e.printStackTrace();
        }
    }

    public Componentes(List ListaDados, boolean Editable, JTextField codigo, JTextArea descricao2, Container conteinGeral, Container contein, int largura, int altura) {
        Codigo = codigo;
        Descricao2 = descricao2;
        Largura = largura;
        Altura = altura;
        this.container = conteinGeral;
        X = (int) (contein.getBounds().getX() + codigo.getBounds().getX() + 20);
        Y = (int) (contein.getBounds().getY() + codigo.getBounds().getY() + codigo.getBounds().getHeight() - 1);
        SLista = new javax.swing.JScrollPane();
        Lista.setBackground(new java.awt.Color(255, 255, 204));
        Lista.setAutoCreateRowSorter(true);
        Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMouseClicked(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                ListaMousePressed(evt);
            }
        });
        Lista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ListaFocusLost(evt);
            }
        });
        Lista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListaKeyPressed(evt);
            }
        });

        SLista.setViewportView(Lista);
        container.add(SLista, 0);
        SLista.setBounds(X, Y, Largura, Altura);
        SLista.setVisible(false);

        Descricao2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DescricaoFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                DescricaoFocusLost(evt);
            }
        });
        Descricao2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DescricaoKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                DescricaoKeyReleased(evt);
            }
        });

        try {
            this.Editable = Editable;
            ModeloBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, ListaDados, Lista);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar criar tabela de vinculação. Erro: " + e);
            e.printStackTrace();
        }
    }

    public Componentes(List ListaDados, boolean Editable, JTextArea codigo, JTextArea descricao2, Container conteinGeral, Container contein, int largura, int altura, int x, int y) {
        CodigoTextArea = codigo;
        Descricao2 = descricao2;
        Largura = largura;
        Altura = altura;
        this.container = conteinGeral;
        X = (int) (contein.getBounds().getX() + x);
        Y = (int) (contein.getBounds().getY() + y);
        SLista = new javax.swing.JScrollPane();
        Lista.setBackground(new java.awt.Color(255, 255, 204));
        Lista.setAutoCreateRowSorter(true);
        Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaTextAreaMouseClicked(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                ListaMousePressed(evt);
            }
        });
        Lista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ListaFocusLost(evt);
            }
        });
        Lista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListaTextAreaKeyPressed(evt);
            }
        });

        SLista.setViewportView(Lista);
        container.add(SLista, 0);
        SLista.setBounds(X, Y, Largura, Altura);
        SLista.setVisible(false);

        Descricao2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DescricaoFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                DescricaoFocusLost(evt);
            }
        });
        Descricao2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DescricaoKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                DescricaoKeyReleased(evt);
            }
        });

        try {
            this.Editable = Editable;
            ModeloBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, ListaDados, Lista);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar criar tabela de vinculação. Erro: " + e);
            e.printStackTrace();
        }
    }

    public void addCol(int col, String CampoColuna, String TituloColuna, int width, String TipoClasse) {
        JTableBinding.ColumnBinding colunaAdd = ModeloBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${" + CampoColuna + "}"));
        colunaAdd.setColumnName(TituloColuna);
        colunaAdd.setEditable(Editable);
        VetorTamanho.add(width);
        try {
            //colunaAdd.setColumnClass(Class.forName(TipoClasse.getClass().getName()));              
            colunaAdd.setColumnClass(Class.forName(TipoClasse));
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar adicionar coluna de mapeamento. Colune: " + CampoColuna + ". Erro: " + e);
            e.printStackTrace();
        }
    }

    public void addColExpressao(int col, String CampoColuna, String TituloColuna, int width, String TipoClasse) {
        JTableBinding.ColumnBinding colunaAdd = ModeloBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create(CampoColuna));
        colunaAdd.setColumnName(TituloColuna);
        colunaAdd.setEditable(Editable);
        VetorTamanho.add(width);
        try {
            //colunaAdd.setColumnClass(Class.forName(TipoClasse.getClass().getName()));              
            colunaAdd.setColumnClass(Class.forName(TipoClasse));
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar adicionar coluna de mapeamento. Colune: " + CampoColuna + ". Erro: " + e);
            e.printStackTrace();
        }
    }

    public void bind() {
        try {
            bindingGroup.addBinding(ModeloBinding);
            ModeloBinding.bind();
            ModeloBinding.setEditable(Editable);
            for (int a = 0; a < VetorTamanho.size(); a++) {
                Lista.getColumnModel().getColumn(a).setPreferredWidth(VetorTamanho.get(a));
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar startar tabela de vinculação. Erro: " + e);
            e.printStackTrace();
        }
    }

    public void bind(String Entidade) {
        try {
            bindingGroup.addBinding(ModeloBinding);
            ModeloBinding.bind();
            ModeloBinding.setEditable(Editable);
            for (int a = 0; a < VetorTamanho.size(); a++) {
                Lista.getColumnModel().getColumn(a).setPreferredWidth(VetorTamanho.get(a));
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar startar tabela de vinculação. Erro: " + e);
            e.printStackTrace();
        }
    }

    private void ListaMouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() > 1) {
            Codigo.setText("" + Lista.getValueAt(Lista.getSelectedRow(), 0));
            Codigo.requestFocus();
        }
    }

    private void ListaTextAreaMouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() > 1) {
            CodigoTextArea.setText("" + Lista.getValueAt(Lista.getSelectedRow(), 0));
            CodigoTextArea.requestFocus();
        }
    }

    private void ListaMousePressed(java.awt.event.MouseEvent evt) {
        FvaLista = false;
    }

    private void ListaFocusLost(java.awt.event.FocusEvent evt) {
        SLista.setVisible(false);
    }

    private void ListaKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            Codigo.setText("" + Lista.getValueAt(Lista.getSelectedRow(), 0));
            Codigo.requestFocus();
        }
    }

    private void ListaTextAreaKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            CodigoTextArea.setText("" + Lista.getValueAt(Lista.getSelectedRow(), 0));
            CodigoTextArea.requestFocus();
        }
    }

    private void DescricaoKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN && SLista.isVisible()) {
            FvaLista = false;
            FvaControle = false;
            Lista.requestFocus();
        }
    }

    private void DescricaoFocusGained(java.awt.event.FocusEvent evt) {
        FvaLista = true;
        FvaControle = true;
    }

    private void DescricaoFocusLost(java.awt.event.FocusEvent evt) {
        if (FvaLista) {
            SLista.setVisible(false);
            FvaLista = false;
            FvaControle = false;
        }
    }

    private void DescricaoKeyReleased(java.awt.event.KeyEvent evt) {

        if (!FvaLista || !FvaControle) {
            SLista.setVisible(false);
            FvaControle = true;
        } else if (Lista.getRowCount() > 0) {
            SLista.setVisible(true);
        } else {
            SLista.setVisible(false);
        }
    }
}
