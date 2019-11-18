package br.com.capivarawars.core.tests.telas;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.game.component.*;
import br.com.capivarawars.core.game.gameobject.*;
import br.com.capivarawars.core.primitive.*;
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author TPEDROSO, 04/10/2019, 09:18:50
 *///</editor-fold>
public class Inicial extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructor...">
    public Inicial() {
        initComponents();
        moveJFrameToCenterOfScreen();        
        //your code below
        
        
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="your methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    
    //</editor-fold>
    
    //</editor-fold>
    

    //\\ Do not change the lines of code below, except the EVENTS ;) \\//

    //<editor-fold defaultstate="collapsed" desc="methods: getScreenWidth(), getScreenHeight(), moveJFrameToCenterOfScreen()...">
    private static Integer getScreenWidth() {
        return  Toolkit.getDefaultToolkit().getScreenSize().width;
    }
    
    private static Integer getScreenHeight() {
        return Toolkit.getDefaultToolkit().getScreenSize().height;
    }
    
    private void moveJFrameToCenterOfScreen() {
        super.setLocation((getScreenWidth() / 2) - (super.getWidth() / 2),
                (getScreenHeight() / 2) - (super.getHeight() / 2)
        );
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="generated method: main(String args[])...">
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc="Look and feel setting code (Nimbus theme)...">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the Inicial, a subclass of JFrame
        java.awt.EventQueue.invokeLater(() -> {
            new Inicial().setVisible(true);
        });

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="generated attributes:...">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    //</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc="generated methods: initComponents() and EVENTS...">
    
    //generated method: initComponents()
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(60, 64, 65));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 90)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 255));
        jLabel1.setText("capivara");
        backgroundPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 50)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 102));
        jLabel2.setText("WARS");
        backgroundPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 204, 255));
        jButton1.setText("Iniciar");
        jButton1.setBorder(null);
        backgroundPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 200, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    //</editor-fold>
        
}
