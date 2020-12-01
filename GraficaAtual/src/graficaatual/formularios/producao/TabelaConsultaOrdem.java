package graficaatual.formularios.producao;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Danilo Bispo
 */
public class TabelaConsultaOrdem extends JTable {

    public TabelaConsultaOrdem() {
        super();
    }
 
    @Override
    public Component prepareRenderer(
            TableCellRenderer renderer,
            int rowIndex,
            int vColIndex) {

        try {
            Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
            
            if (isCellSelected(rowIndex, vColIndex)) {
                if (getSelectedColumn() == vColIndex) {
                    c.setBackground(new Color(0, 160, 200));
                    
                } else {
                    c.setBackground(new Color(0, 160, 255));
                }
                c.setForeground(Color.WHITE);
            } else if (getValueAt(rowIndex, vColIndex).equals("")) {
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
            } else if (getValueAt(rowIndex, vColIndex).equals("À Fazer")) {
                c.setBackground(Color.YELLOW);
                c.setForeground(Color.BLACK);
            } else {
                c.setBackground(Color.GREEN);
                c.setForeground(Color.BLACK);
            }
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
