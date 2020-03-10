/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graficaatual.utilitarios;

import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author Projeto X
 */
public class ConfigMenus extends JMenuBar{
    private Thread linhaExecucao;

    private boolean aplicarEmSeparator = false;

    private static JMenuBar jBarraDeMenu;

    public ConfigMenus(JMenuBar barraDeMenu) {

        jBarraDeMenu = barraDeMenu;
        
    }

    public void aplicar(){
        Runnable r = new Runnable() {

            public void run() {

            menu(jBarraDeMenu.getComponents());

            }
        };

        linhaExecucao = new Thread(r);
        try{
            linhaExecucao.sleep(20);
        }catch(Exception e){e.printStackTrace();}

        linhaExecucao.start();
    }

    private void menu(Component [] cc){
        for(Component c : cc){

            if(c instanceof JMenu){

                setar((JMenu) c);
     
                menu(((JMenu) c).getMenuComponents());

            }else if(c instanceof JSeparator){
                
                if(aplicarEmSeparator){

                    setar(((JSeparator)c));
                    
                }
            }else{

                setar(((JMenuItem) c));
            }


        }
    }

    private void setar(JSeparator s){
        try{ s.setFont(this.getFont());             }catch(Exception e){e.printStackTrace();}
        try{ s.setForeground(this.getForeground()); }catch(Exception e){e.printStackTrace();}
        try{ s.setBackground(this.getBackground()); }catch(Exception e){e.printStackTrace();}
    }

    private void setar(JMenu s){
        try{ s.setFont(this.getFont());          }catch(Exception e){e.printStackTrace();}
        try{ s.setForeground(this.getForeground()); }catch(Exception e){e.printStackTrace();}
        try{ s.setBackground(this.getBackground()); }catch(Exception e){e.printStackTrace();}

    }

    private void setar(JMenuItem s){
        try{ s.setFont(this.getFont());             }catch(Exception e){e.printStackTrace();}
        try{ s.setForeground(this.getForeground()); }catch(Exception e){e.printStackTrace();}
        try{ s.setBackground(this.getBackground()); }catch(Exception e){e.printStackTrace();}
    }

    public boolean isAplicarEmSeparator() {
        return aplicarEmSeparator;
    }

    public void setAplicarEmSeparator(boolean aplicarEmSeparator) {
        this.aplicarEmSeparator = aplicarEmSeparator;
    }

}
