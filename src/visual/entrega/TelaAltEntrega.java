/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual.entrega;

/**
 *
 * @author Nelson
 */
public class TelaAltEntrega extends javax.swing.JFrame {

    /**
     * Creates new form TelaAltEntrega
     */
    public TelaAltEntrega() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        planodefundolabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alteração de Entrega");
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel2.setForeground(java.awt.Color.lightGray);
        jLabel2.setText("Cod Entrega:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 10, 70, 30);

        jTextField1.setBackground(new java.awt.Color(18, 18, 20));
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setBorder(null);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(100, 10, 120, 30);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(18, 18, 20));
        jTextField2.setForeground(new java.awt.Color(204, 204, 204));
        jTextField2.setBorder(null);
        jTextField2.setEnabled(false);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(30, 80, 130, 30);

        jTextField5.setBackground(new java.awt.Color(18, 18, 20));
        jTextField5.setForeground(new java.awt.Color(204, 204, 204));
        jTextField5.setBorder(null);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(30, 140, 50, 30);

        jLabel3.setForeground(java.awt.Color.lightGray);
        jLabel3.setText("Nome:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 60, 40, 20);

        jLabel6.setForeground(java.awt.Color.lightGray);
        jLabel6.setText("N:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 120, 20, 20);

        jLabel4.setForeground(java.awt.Color.lightGray);
        jLabel4.setText("Telefone:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(210, 60, 60, 20);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(18, 18, 20));
        jTextField3.setForeground(new java.awt.Color(204, 204, 204));
        jTextField3.setBorder(null);
        jTextField3.setEnabled(false);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(210, 80, 120, 30);

        jLabel7.setForeground(java.awt.Color.lightGray);
        jLabel7.setText("Bairro:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(210, 120, 40, 20);

        jTextField6.setBackground(new java.awt.Color(18, 18, 20));
        jTextField6.setForeground(java.awt.Color.lightGray);
        jTextField6.setBorder(null);
        jPanel1.add(jTextField6);
        jTextField6.setBounds(210, 140, 120, 30);

        jLabel8.setForeground(java.awt.Color.lightGray);
        jLabel8.setText("Cidade:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(390, 120, 50, 20);

        jTextField7.setBackground(new java.awt.Color(18, 18, 20));
        jTextField7.setForeground(new java.awt.Color(204, 204, 204));
        jTextField7.setBorder(null);
        jPanel1.add(jTextField7);
        jTextField7.setBounds(390, 140, 160, 30);

        jLabel5.setForeground(java.awt.Color.lightGray);
        jLabel5.setText("Endereço:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(390, 60, 60, 20);

        jTextField4.setBackground(new java.awt.Color(18, 18, 20));
        jTextField4.setForeground(new java.awt.Color(204, 204, 204));
        jTextField4.setBorder(null);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(390, 80, 160, 30);

        jButton1.setBackground(new java.awt.Color(3, 62, 11));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(java.awt.SystemColor.control);
        jButton1.setText("Procurar");
        jButton1.setToolTipText("procurar pedido");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(230, 10, 90, 30);

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cod Produto", "Produto", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 190, 550, 160);

        jButton2.setBackground(new java.awt.Color(3, 62, 11));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(java.awt.SystemColor.control);
        jButton2.setText("Alterar");
        jButton2.setToolTipText("Confirmar Entrega");
        jButton2.setBorderPainted(false);
        jPanel1.add(jButton2);
        jButton2.setBounds(360, 390, 90, 40);

        jButton3.setBackground(new java.awt.Color(3, 62, 11));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(java.awt.SystemColor.control);
        jButton3.setText("Sair");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(470, 390, 100, 40);

        jLabel10.setForeground(java.awt.Color.lightGray);
        jLabel10.setText("Total a Pagar:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 390, 100, 40);

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(18, 18, 20));
        jTextField9.setForeground(new java.awt.Color(204, 204, 204));
        jTextField9.setBorder(null);
        jTextField9.setEnabled(false);
        jPanel1.add(jTextField9);
        jTextField9.setBounds(100, 390, 90, 40);

        jLabel11.setForeground(java.awt.Color.lightGray);
        jLabel11.setText("CEP:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(100, 120, 23, 20);

        jTextField10.setBackground(new java.awt.Color(18, 18, 20));
        jTextField10.setForeground(new java.awt.Color(204, 204, 204));
        jTextField10.setBorder(null);
        jPanel1.add(jTextField10);
        jTextField10.setBounds(100, 140, 90, 30);

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundocliente1.png"))); // NOI18N
        jLabel38.setText("jLabel30");
        jPanel1.add(jLabel38);
        jLabel38.setBounds(0, 0, 590, 440);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 80, 590, 440);

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FotoJet (20).png"))); // NOI18N
        jLabel1.setText("Alterar Entrega:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 20, 330, 80);

        planodefundolabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/planodefundoapp.png"))); // NOI18N
        planodefundolabel.setText("Fundo");
        getContentPane().add(planodefundolabel);
        planodefundolabel.setBounds(0, 0, 620, 540);

        setSize(new java.awt.Dimension(629, 573));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAltEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAltEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAltEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAltEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAltEntrega().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel planodefundolabel;
    // End of variables declaration//GEN-END:variables
}
