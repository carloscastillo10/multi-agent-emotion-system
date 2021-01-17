package gui;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
*/
public class EvaluatingGUI extends javax.swing.JFrame {
    /**
     * Creates new form Main
     */
    public EvaluatingGUI() {
        initComponents();
        adjustImage();
        setLocationRelativeTo(null);
        
    }
    
    private void adjustImage(){
        ImageIcon originalImage = new ImageIcon(getClass().getResource("/images/evaluating.gif"));
        Image newImage = originalImage.getImage().getScaledInstance(
                this.lblEvaluatingmage.getWidth(), this.lblEvaluatingmage.getHeight(), 
                Image.SCALE_DEFAULT);
        Icon newIcon = new ImageIcon(newImage);
        this.lblEvaluatingmage.setIcon(newIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lblEvaluating = new javax.swing.JLabel();
        lblEvaluatingmage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmotionName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRecomendation = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCauses = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEvaluating.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblEvaluating.setText(" Avalie (Agente Evaluador)");
        jPanel3.add(lblEvaluating, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 240, 40));
        jPanel3.add(lblEvaluatingmage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 230, 300));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("RESULTADOS");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 100, -1));

        jLabel2.setText("Emoción:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, 20));

        txtEmotionName.setEditable(false);
        jPanel3.add(txtEmotionName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 190, 40));

        jLabel3.setText("Posibles causas:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, -1));

        jLabel4.setText("Recomendación:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, -1, -1));

        txtRecomendation.setEditable(false);
        txtRecomendation.setColumns(20);
        txtRecomendation.setRows(5);
        jScrollPane2.setViewportView(txtRecomendation);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 290, 120));

        txtCauses.setEditable(false);
        txtCauses.setColumns(20);
        txtCauses.setRows(5);
        jScrollPane1.setViewportView(txtCauses);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 450, 150));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(EvaluatingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EvaluatingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EvaluatingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EvaluatingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EvaluatingGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEvaluating;
    private javax.swing.JLabel lblEvaluatingmage;
    public javax.swing.JTextArea txtCauses;
    public javax.swing.JTextField txtEmotionName;
    public javax.swing.JTextArea txtRecomendation;
    // End of variables declaration//GEN-END:variables
}