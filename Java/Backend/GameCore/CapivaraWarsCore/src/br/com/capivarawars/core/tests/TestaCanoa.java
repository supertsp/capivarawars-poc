package br.com.capivarawars.core.tests;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.CorPadrao;
import br.com.capivarawars.core.game.gameobject.Canoa;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.JToggleButton;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 27/09/2019, 18:51:40
 *///</editor-fold>
public class TestaCanoa extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    private Canoa canoa;
    
    private List<JToggleButton> pedacosButton;
    
    private Color COR_PEDACO_ATIVO_BACKGROUND = new Color(0, 102, 51);
    private Color COR_PEDACO_ATIVO_FOREGROUND = new Color(153, 255, 153);
    
    private Color COR_PEDACO_INATIVO_BACKGROUND = new Color(60, 63, 66);
    private Color COR_PEDACO_INATIVO_FOREGROUND = new Color(153, 153, 153);
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructor...">
    public TestaCanoa() {
        initComponents();
        moveJFrameToCenterOfScreen();        
        //your code below
        
        int tamanhoCanoa = 4;        
        canoa =  new Canoa(tamanhoCanoa, CorPadrao.ROXO);
        pedacosButton =  new ArrayList<>(tamanhoCanoa);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="your methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    private void adicionarPedacoNaArray(int indiceNovoPedaco, boolean ativo){
        JToggleButton jtButton = new JToggleButton(String.valueOf(indiceNovoPedaco));
        
        if (ativo) {
            jtButton.setBackground(COR_PEDACO_ATIVO_BACKGROUND);
            jtButton.setForeground(COR_PEDACO_ATIVO_FOREGROUND);
            jtButton.setSelected(false);
        }
        else{
            jtButton.setBackground(COR_PEDACO_INATIVO_BACKGROUND);
            jtButton.setForeground(COR_PEDACO_INATIVO_FOREGROUND);
            jtButton.setSelected(false);
        }
        
        pedacosButton.add(indiceNovoPedaco, jtButton);
    }
    
    private void atualizarPedacosNaTela(){
        for (int i = 0; i < 10; i++) {
            
        }
    }
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
            java.util.logging.Logger.getLogger(TestaCanoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestaCanoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestaCanoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestaCanoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the TestaCanoa, a subclass of JFrame
        java.awt.EventQueue.invokeLater(() -> {
            new TestaCanoa().setVisible(true);
        });

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="generated attributes:...">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaPedaçoCanoa;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel l_modeloPedaco;
    private javax.swing.JToggleButton modeloPedacoAtivo;
    private javax.swing.JToggleButton modeloPedacoInativo;
    // End of variables declaration//GEN-END:variables
    //</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc="generated methods: initComponents() and EVENTS...">
    
    //generated method: initComponents()
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        l_modeloPedaco = new javax.swing.JLabel();
        modeloPedacoAtivo = new javax.swing.JToggleButton();
        modeloPedacoInativo = new javax.swing.JToggleButton();
        areaPedaçoCanoa = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(60, 64, 65));

        l_modeloPedaco.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        l_modeloPedaco.setForeground(new java.awt.Color(255, 255, 255));
        l_modeloPedaco.setText("Modelo Pedaço");

        modeloPedacoAtivo.setBackground(new java.awt.Color(0, 102, 51));
        modeloPedacoAtivo.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        modeloPedacoAtivo.setForeground(new java.awt.Color(153, 255, 153));
        modeloPedacoAtivo.setText("Ativo");
        modeloPedacoAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloPedacoAtivoActionPerformed(evt);
            }
        });

        modeloPedacoInativo.setBackground(new java.awt.Color(60, 63, 66));
        modeloPedacoInativo.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        modeloPedacoInativo.setForeground(new java.awt.Color(153, 153, 153));
        modeloPedacoInativo.setSelected(true);
        modeloPedacoInativo.setText("Desativo");
        modeloPedacoInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloPedacoInativoActionPerformed(evt);
            }
        });

        areaPedaçoCanoa.setBackground(new java.awt.Color(187, 187, 186));
        areaPedaçoCanoa.setForeground(new java.awt.Color(187, 187, 186));

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l_modeloPedaco)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(areaPedaçoCanoa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(modeloPedacoAtivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modeloPedacoInativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(l_modeloPedaco)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(modeloPedacoAtivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modeloPedacoInativo))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(areaPedaçoCanoa, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modeloPedacoAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloPedacoAtivoActionPerformed
        modeloPedacoAtivo.setSelected(false);
    }//GEN-LAST:event_modeloPedacoAtivoActionPerformed

    private void modeloPedacoInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloPedacoInativoActionPerformed
        modeloPedacoInativo.setSelected(true);
    }//GEN-LAST:event_modeloPedacoInativoActionPerformed
        
    //</editor-fold>
        
}
