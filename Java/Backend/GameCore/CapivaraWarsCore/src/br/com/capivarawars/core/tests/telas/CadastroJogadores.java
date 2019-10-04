package br.com.capivarawars.core.tests.telas;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.*;
import br.com.capivarawars.core.game.*;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
public class CadastroJogadores extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    //lb_imagemCapivara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/capivarawars/core/images/capybara_black.png"))); // NOI18N
    public final ImageIcon[] imagensCapivaras = new ImageIcon[]{
        new ImageIcon(getClass().getResource("/br/com/capivarawars/core/images/capybara_black.png")),
        new ImageIcon(getClass().getResource("/br/com/capivarawars/core/images/capybara_blue.png")),
        new ImageIcon(getClass().getResource("/br/com/capivarawars/core/images/capybara_brown.png")),
        new ImageIcon(getClass().getResource("/br/com/capivarawars/core/images/capybara_purple.png")),
        new ImageIcon(getClass().getResource("/br/com/capivarawars/core/images/capybara_red.png")),
        new ImageIcon(getClass().getResource("/br/com/capivarawars/core/images/capybara_white.png")),
        new ImageIcon(getClass().getResource("/br/com/capivarawars/core/images/capybara_yellow.png"))        
    };
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructor...">
    public CadastroJogadores() {
        initComponents();
        moveJFrameToCenterOfScreen();        
        //your code below
        
        iniciarComboBox();
        
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="your methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    private void iniciarComboBox(){
        String[] cores = new String[CorPadrao.values().length - 2];
        for (int cont = 0; cont < cores.length; cont++) {
            cores[cont] = CorPadrao.values()[cont + 2].toString();
        }
        
        cb_coresCapivara.setModel(new DefaultComboBoxModel<>(cores));
        cb_coresCapivara.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(CadastroJogadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroJogadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroJogadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroJogadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        

        // Create and display the Inicial, a subclass of JFrame
        java.awt.EventQueue.invokeLater(() -> {
            new CadastroJogadores().setVisible(true);
        });

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="generated attributes:...">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaInput;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JComboBox<String> cb_coresCapivara;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lb_imagemCapivara;
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
        areaInput = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lb_imagemCapivara = new javax.swing.JLabel();
        cb_coresCapivara = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(51, 51, 51));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 255));
        jLabel1.setText("capivara");
        backgroundPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 102));
        jLabel2.setText("WARS");
        backgroundPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        areaInput.setBackground(new java.awt.Color(60, 64, 65));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Avançar");
        jButton1.setBorder(null);

        jTextField1.setBackground(new java.awt.Color(60, 64, 65));
        jTextField1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(187, 187, 186));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 102, 102)));

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nome");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Jogador");

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(187, 187, 186));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("1");

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nick");

        jTextField2.setBackground(new java.awt.Color(60, 64, 65));
        jTextField2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(187, 187, 186));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 102, 102)));

        jTextField3.setBackground(new java.awt.Color(60, 64, 65));
        jTextField3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(187, 187, 186));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 102, 102)));

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nome da sua Capivara");

        lb_imagemCapivara.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        lb_imagemCapivara.setForeground(new java.awt.Color(187, 187, 186));
        lb_imagemCapivara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/capivarawars/core/images/capybara_black.png"))); // NOI18N

        cb_coresCapivara.setBackground(new java.awt.Color(60, 63, 64));
        cb_coresCapivara.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        cb_coresCapivara.setForeground(new java.awt.Color(187, 187, 186));
        cb_coresCapivara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cores" }));
        cb_coresCapivara.setBorder(null);
        cb_coresCapivara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_coresCapivaraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout areaInputLayout = new javax.swing.GroupLayout(areaInput);
        areaInput.setLayout(areaInputLayout);
        areaInputLayout.setHorizontalGroup(
            areaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, areaInputLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(areaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(areaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(areaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, areaInputLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, areaInputLayout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)))
                    .addGroup(areaInputLayout.createSequentialGroup()
                        .addGroup(areaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_imagemCapivara, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(cb_coresCapivara, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        areaInputLayout.setVerticalGroup(
            areaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(areaInputLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(areaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(areaInputLayout.createSequentialGroup()
                        .addGroup(areaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(lb_imagemCapivara, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(areaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(areaInputLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, areaInputLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(cb_coresCapivara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(areaInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(areaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_coresCapivaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_coresCapivaraActionPerformed
        CorPadrao corAtual = CorPadrao.valueOf(cb_coresCapivara.getSelectedItem().toString());
        
        switch (corAtual) {
            case PRETO:
                lb_imagemCapivara.setIcon(imagensCapivaras[0]);
                break;
            
            case AZUL:
                lb_imagemCapivara.setIcon(imagensCapivaras[1]);
                break;
            
            case MARROM:
                lb_imagemCapivara.setIcon(imagensCapivaras[2]);
                break;
            
            case ROXO:
                lb_imagemCapivara.setIcon(imagensCapivaras[3]);
                break;
            
            case VERMELHO:
                lb_imagemCapivara.setIcon(imagensCapivaras[4]);
                break;
            
            case BRANCO:
                lb_imagemCapivara.setIcon(imagensCapivaras[5]);
                break;
            
            case AMARELO:
                lb_imagemCapivara.setIcon(imagensCapivaras[6]);
                break;
            
            default:
                lb_imagemCapivara.setIcon(imagensCapivaras[2]);
        }
    }//GEN-LAST:event_cb_coresCapivaraActionPerformed
        
    //</editor-fold>
        
}
