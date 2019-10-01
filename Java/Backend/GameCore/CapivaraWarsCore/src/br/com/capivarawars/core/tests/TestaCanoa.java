package br.com.capivarawars.core.tests;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.CorPadrao;
import br.com.capivarawars.core.game.gameobject.Canoa;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
    private int tamanhoCanoa = 4;
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
        
          
        canoa =  new Canoa("Teste", CorPadrao.ROXO, tamanhoCanoa);
        pedacosButton =  new ArrayList<>(tamanhoCanoa);
        for (int cont = 0; cont < tamanhoCanoa; cont++) {
            adicionarNovoButtonPedaco(cont, true);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="your methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    private void adicionarNovoButtonPedaco(int indiceNovoPedaco, boolean ativo){
        JToggleButton jtButton = new JToggleButton(String.valueOf(indiceNovoPedaco));
        jtButton.setSize(new Dimension(90, 34));
        jtButton.setPreferredSize(new Dimension(90, 34));
        
        if (ativo) {
            jtButton.setBackground(COR_PEDACO_ATIVO_BACKGROUND);
            jtButton.setForeground(COR_PEDACO_ATIVO_FOREGROUND);
            jtButton.setSelected(false);
            canoa.getPedaco(indiceNovoPedaco).construir();
        }
        else{
            jtButton.setBackground(COR_PEDACO_INATIVO_BACKGROUND);
            jtButton.setForeground(COR_PEDACO_INATIVO_FOREGROUND);
            jtButton.setSelected(true);
            canoa.getPedaco(indiceNovoPedaco).destruir();
        }
        
        pedacosButton.add(indiceNovoPedaco, jtButton);
        areaPedacoCanoa.add(jtButton);
        
        jtButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            if (!canoa.destruirPedaco(indiceNovoPedaco)) {
                canoa.reconstruirPedaco(indiceNovoPedaco);                
            }
            System.out.println("selected: " + jtButton.isSelected());
            atualizarPedacosNaTela();
            System.out.println("indicePedaco: " + indiceNovoPedaco);
            System.out.println(canoa);
        });
    }
    
    private void setButtonPedacoStatus(int indicePedaco, boolean destruido){
        pedacosButton.get(indicePedaco).setSelected(destruido);
        
        if (destruido) {
            pedacosButton.get(indicePedaco).setBackground(COR_PEDACO_INATIVO_BACKGROUND);
            pedacosButton.get(indicePedaco).setForeground(COR_PEDACO_INATIVO_FOREGROUND);
        }
        else{
            pedacosButton.get(indicePedaco).setBackground(COR_PEDACO_ATIVO_BACKGROUND);
            pedacosButton.get(indicePedaco).setForeground(COR_PEDACO_ATIVO_FOREGROUND);
        }
    }
    
    private void atualizarPedacosNaTela(){
        for (int cont = 0; cont < canoa.lengthOfPedacos(); cont++) {
            pedacosButton.get(cont).setSelected(canoa.getPedaco(cont).isDestruido());
            
            if (pedacosButton.get(cont).isSelected()) {                
                pedacosButton.get(cont).setBackground(COR_PEDACO_INATIVO_BACKGROUND);
                pedacosButton.get(cont).setForeground(COR_PEDACO_INATIVO_FOREGROUND); 
            }
            else{
                pedacosButton.get(cont).setBackground(COR_PEDACO_ATIVO_BACKGROUND);
                pedacosButton.get(cont).setForeground(COR_PEDACO_ATIVO_FOREGROUND);
            }
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
    private javax.swing.JPanel areaPedacoCanoa;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel l_modeloPedaco;
    private javax.swing.JLabel l_modeloPedaco1;
    private javax.swing.JLabel l_modeloPedaco2;
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
        areaPedacoCanoa = new javax.swing.JPanel();
        l_modeloPedaco1 = new javax.swing.JLabel();
        l_modeloPedaco2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(60, 64, 65));

        l_modeloPedaco.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        l_modeloPedaco.setForeground(new java.awt.Color(153, 153, 153));
        l_modeloPedaco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_modeloPedaco.setText("<html>Modelo <br>Pedaço</html>");

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

        areaPedacoCanoa.setBackground(new java.awt.Color(187, 187, 186));
        areaPedacoCanoa.setForeground(new java.awt.Color(187, 187, 186));

        l_modeloPedaco1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        l_modeloPedaco1.setForeground(new java.awt.Color(255, 255, 255));
        l_modeloPedaco1.setText("Canoa");

        l_modeloPedaco2.setForeground(new java.awt.Color(255, 255, 255));
        l_modeloPedaco2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_modeloPedaco2.setText("Player 1");

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(l_modeloPedaco1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(l_modeloPedaco2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(areaPedacoCanoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addComponent(l_modeloPedaco, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(modeloPedacoInativo)
                            .addComponent(modeloPedacoAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(l_modeloPedaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(modeloPedacoAtivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modeloPedacoInativo))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(l_modeloPedaco1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_modeloPedaco2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(areaPedacoCanoa, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
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
    
    private void onClick_buttonPedaco(ActionEvent ev){
        
    }
    
    //</editor-fold>
        
}
