package br.com.capivarawars.core.tests;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.game.MarcadorDeTempo;
import java.util.List;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author TPEDROSO, 23 de set de 2019, 09:24:48
 *///</editor-fold>
public class TestaMarcadorTempo extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    private MarcadorDeTempo marcadorDeTempo;
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructor...">
    public TestaMarcadorTempo() {
        initComponents();
        moveJFrameToCenterOfScreen();        
        //your code below
        
        marcadorDeTempo = new MarcadorDeTempo(10);
        atualizaMarcadorDeTempoNaTela();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="your methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    private void atualizaMarcadorDeTempoNaTela(){
        int tempoEsperaAtualizaEmMili = 500;
        
        new Thread(()->{
            while (true) {                
                
                lb_tempoDecorrido.setText(marcadorDeTempo.getTempoDecorridoComoInteger().toString());
                
                try {
                    Thread.sleep(tempoEsperaAtualizaEmMili);
                } catch (Exception e) {}
            }
        }).start();
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
            java.util.logging.Logger.getLogger(TestaMarcadorTempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestaMarcadorTempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestaMarcadorTempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestaMarcadorTempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the TestaMarcadorTempo, a subclass of JFrame
        java.awt.EventQueue.invokeLater(() -> {
            new TestaMarcadorTempo().setVisible(true);
        });

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="generated attributes:...">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton bt_iniciar;
    private javax.swing.JButton bt_parar;
    private javax.swing.JButton bt_pausar;
    private javax.swing.JButton bt_reiniciar;
    private javax.swing.JButton bt_retomar;
    private javax.swing.JLabel lb_segundos;
    private javax.swing.JLabel lb_tempoDecorrido;
    private javax.swing.JLabel lb_tempoLimite;
    private javax.swing.JTextField tf_tempoLimite;
    // End of variables declaration//GEN-END:variables
    //</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc="generated methods: initComponents() and EVENTS...">
    
    //generated method: initComponents()
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        lb_tempoDecorrido = new javax.swing.JLabel();
        lb_segundos = new javax.swing.JLabel();
        bt_iniciar = new javax.swing.JButton();
        bt_parar = new javax.swing.JButton();
        bt_reiniciar = new javax.swing.JButton();
        bt_pausar = new javax.swing.JButton();
        bt_retomar = new javax.swing.JButton();
        lb_tempoLimite = new javax.swing.JLabel();
        tf_tempoLimite = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(60, 64, 65));

        lb_tempoDecorrido.setFont(new java.awt.Font("Dialog", 3, 48)); // NOI18N
        lb_tempoDecorrido.setForeground(new java.awt.Color(255, 255, 255));
        lb_tempoDecorrido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tempoDecorrido.setText("10000");
        lb_tempoDecorrido.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lb_segundos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lb_segundos.setForeground(new java.awt.Color(255, 255, 255));
        lb_segundos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_segundos.setText("s");
        lb_segundos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        bt_iniciar.setBackground(new java.awt.Color(60, 63, 64));
        bt_iniciar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bt_iniciar.setForeground(new java.awt.Color(255, 255, 255));
        bt_iniciar.setText("Iniciar");
        bt_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick_iniciar(evt);
            }
        });

        bt_parar.setBackground(new java.awt.Color(60, 63, 64));
        bt_parar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bt_parar.setForeground(new java.awt.Color(255, 255, 255));
        bt_parar.setText("Parar");
        bt_parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick_parar(evt);
            }
        });

        bt_reiniciar.setBackground(new java.awt.Color(60, 63, 64));
        bt_reiniciar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bt_reiniciar.setForeground(new java.awt.Color(255, 255, 255));
        bt_reiniciar.setText("Reiniciar");
        bt_reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick_reiniciar(evt);
            }
        });

        bt_pausar.setBackground(new java.awt.Color(60, 63, 64));
        bt_pausar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bt_pausar.setForeground(new java.awt.Color(255, 255, 255));
        bt_pausar.setText("Pausar");
        bt_pausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick_pausar(evt);
            }
        });

        bt_retomar.setBackground(new java.awt.Color(60, 63, 64));
        bt_retomar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bt_retomar.setForeground(new java.awt.Color(255, 255, 255));
        bt_retomar.setText("Retomar");
        bt_retomar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClick_retomar(evt);
            }
        });

        lb_tempoLimite.setForeground(new java.awt.Color(204, 204, 204));
        lb_tempoLimite.setText("Tempo Limite");

        tf_tempoLimite.setBackground(new java.awt.Color(102, 102, 102));
        tf_tempoLimite.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        tf_tempoLimite.setForeground(new java.awt.Color(255, 255, 255));
        tf_tempoLimite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_tempoLimite.setText("10");
        tf_tempoLimite.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                onFocusLost_tempoLimite(evt);
            }
        });
        tf_tempoLimite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                onKeyPressed_tempoLimite(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(lb_tempoDecorrido, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_segundos))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bt_pausar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_iniciar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_parar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_reiniciar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(lb_tempoLimite, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_retomar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(tf_tempoLimite)
                .addGap(39, 39, 39))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_tempoDecorrido, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_segundos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(bt_pausar))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(bt_iniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_parar)
                        .addGap(18, 18, 18)
                        .addComponent(bt_reiniciar)
                        .addGap(18, 18, 18)
                        .addComponent(lb_tempoLimite)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_tempoLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_retomar))
                .addGap(0, 42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onClick_iniciar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClick_iniciar
         marcadorDeTempo.iniciarTempo();
    }//GEN-LAST:event_onClick_iniciar

    private void onClick_parar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClick_parar
         marcadorDeTempo.pararTempo();
    }//GEN-LAST:event_onClick_parar

    private void onClick_reiniciar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClick_reiniciar
         marcadorDeTempo.reiniciarTempo();
    }//GEN-LAST:event_onClick_reiniciar

    private void onClick_pausar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClick_pausar
         marcadorDeTempo.pausarTempo();
    }//GEN-LAST:event_onClick_pausar

    private void onClick_retomar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClick_retomar
         marcadorDeTempo.retomarTempo();
    }//GEN-LAST:event_onClick_retomar

    private void onFocusLost_tempoLimite(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_onFocusLost_tempoLimite
        System.out.println("onFocusLost_tempoLimite");
        
        int tempoLimite = 0;
        
        try {
            tempoLimite = Integer.parseInt(tf_tempoLimite.getText());
        } catch (Exception e) {
            
        }
        
        marcadorDeTempo = new MarcadorDeTempo(tempoLimite);
        marcadorDeTempo.iniciarTempo();
    }//GEN-LAST:event_onFocusLost_tempoLimite

    private void onKeyPressed_tempoLimite(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onKeyPressed_tempoLimite
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            onFocusLost_tempoLimite(null);
            bt_iniciar.requestFocus();
        }
    }//GEN-LAST:event_onKeyPressed_tempoLimite
        
    //</editor-fold>
        
}
