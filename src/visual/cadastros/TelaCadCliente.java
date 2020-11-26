/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual.cadastros;

import data.cliente.ClienteDao;
import data.cliente.Fisico;
import data.cliente.Juridico;
import javax.swing.JOptionPane;

/**
 *
 * @author Nelson
 */
public class TelaCadCliente extends javax.swing.JFrame {

    private ClienteDao clienteDao = new ClienteDao();

    /**
     * Creates new form TelaCadCliente
     */
    public TelaCadCliente() {
        initComponents();
        toogleCpfEntreCnpj();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCpf = new javax.swing.JRadioButton();
        btnCnpj = new javax.swing.JRadioButton();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLagradouro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxEstadoCivil = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        btnCadastrar = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        planodefundolabel = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Cliente - TradeTech 1.0");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("Cadastro de Cliente");
        jPanel1.setLayout(null);

        btnCpf.setForeground(java.awt.Color.lightGray);
        btnCpf.setText("CPF");
        btnCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCpfActionPerformed(evt);
            }
        });
        jPanel1.add(btnCpf);
        btnCpf.setBounds(10, 10, 50, 23);

        btnCnpj.setForeground(java.awt.Color.lightGray);
        btnCnpj.setText("CNPJ");
        btnCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCnpjActionPerformed(evt);
            }
        });
        jPanel1.add(btnCnpj);
        btnCnpj.setBounds(10, 30, 60, 23);

        txtCpf.setBackground(new java.awt.Color(18, 18, 20));
        txtCpf.setBorder(null);
        txtCpf.setForeground(new java.awt.Color(204, 204, 204));
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCpf.setToolTipText("000.000.000-00");
        jPanel1.add(txtCpf);
        txtCpf.setBounds(70, 10, 130, 30);

        jLabel4.setForeground(java.awt.Color.lightGray);
        jLabel4.setText("Nome do Cliente/Empresa:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(230, 10, 140, 30);

        txtNome.setBackground(new java.awt.Color(18, 18, 20));
        txtNome.setForeground(new java.awt.Color(204, 204, 204));
        txtNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNome.setBorder(null);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtNome);
        txtNome.setBounds(370, 10, 180, 30);

        jLabel5.setForeground(java.awt.Color.lightGray);
        jLabel5.setText("Nascimento:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(570, 10, 80, 30);

        txtDataNascimento.setBackground(new java.awt.Color(18, 18, 20));
        txtDataNascimento.setBorder(null);
        txtDataNascimento.setForeground(new java.awt.Color(204, 204, 204));
        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNascimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataNascimento.setToolTipText("Data de Nascimento");
        txtDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascimentoActionPerformed(evt);
            }
        });
        jPanel1.add(txtDataNascimento);
        txtDataNascimento.setBounds(640, 10, 120, 30);
        txtDataNascimento.getAccessibleContext().setAccessibleName("Data de Nascimento");

        jLabel6.setForeground(java.awt.Color.lightGray);
        jLabel6.setText("Logradouro:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 100, 70, 30);

        txtLagradouro.setBackground(new java.awt.Color(18, 18, 20));
        txtLagradouro.setForeground(new java.awt.Color(204, 204, 204));
        txtLagradouro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLagradouro.setBorder(null);
        jPanel1.add(txtLagradouro);
        txtLagradouro.setBounds(80, 100, 110, 30);

        jLabel7.setForeground(java.awt.Color.lightGray);
        jLabel7.setText("Numero:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(230, 100, 50, 30);

        txtNumero.setBackground(new java.awt.Color(18, 18, 20));
        txtNumero.setForeground(new java.awt.Color(204, 204, 204));
        txtNumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumero.setBorder(null);
        jPanel1.add(txtNumero);
        txtNumero.setBounds(280, 100, 70, 30);

        jLabel8.setForeground(java.awt.Color.lightGray);
        jLabel8.setText("CEP:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(370, 100, 30, 30);

        txtCep.setBackground(new java.awt.Color(18, 18, 20));
        txtCep.setBorder(null);
        txtCep.setForeground(new java.awt.Color(204, 204, 204));
        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCep.setToolTipText("00000-000");
        jPanel1.add(txtCep);
        txtCep.setBounds(400, 100, 70, 30);

        jLabel9.setForeground(java.awt.Color.lightGray);
        jLabel9.setText("Bairro:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(500, 100, 40, 30);

        txtBairro.setBackground(new java.awt.Color(18, 18, 20));
        txtBairro.setForeground(new java.awt.Color(204, 204, 204));
        txtBairro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBairro.setBorder(null);
        jPanel1.add(txtBairro);
        txtBairro.setBounds(550, 100, 100, 30);

        jLabel10.setForeground(java.awt.Color.lightGray);
        jLabel10.setText("Estado Civil:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(230, 50, 70, 30);

        cbxEstadoCivil.setBackground(new java.awt.Color(3, 62, 11));
        cbxEstadoCivil.setForeground(java.awt.SystemColor.control);
        cbxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Solteiro(A)", "Casado(A)", "Divorciado(A)", "Viuvo(A)" }));
        cbxEstadoCivil.setBorder(null);
        cbxEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoCivilActionPerformed(evt);
            }
        });
        jPanel1.add(cbxEstadoCivil);
        cbxEstadoCivil.setBounds(300, 50, 90, 30);

        jLabel11.setForeground(java.awt.Color.lightGray);
        jLabel11.setText("Cidade:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(30, 160, 50, 14);

        txtCidade.setBackground(new java.awt.Color(18, 18, 20));
        txtCidade.setForeground(new java.awt.Color(204, 204, 204));
        txtCidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCidade.setBorder(null);
        jPanel1.add(txtCidade);
        txtCidade.setBounds(80, 150, 110, 30);

        jLabel12.setForeground(java.awt.Color.lightGray);
        jLabel12.setText("Estado:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(230, 150, 50, 30);

        cbxEstado.setBackground(new java.awt.Color(3, 62, 11));
        cbxEstado.setForeground(java.awt.SystemColor.control);
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbxEstado.setBorder(null);
        jPanel1.add(cbxEstado);
        cbxEstado.setBounds(270, 150, 70, 30);

        btnCadastrar.setBackground(new java.awt.Color(3, 62, 11));
        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCadastrar.setForeground(java.awt.SystemColor.control);
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastrar);
        btnCadastrar.setBounds(640, 160, 100, 30);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundocliente1.png"))); // NOI18N
        jLabel31.setText("jLabel30");
        jPanel1.add(jLabel31);
        jLabel31.setBounds(0, 0, 780, 230);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 70, 780, 210);
        jPanel1.getAccessibleContext().setAccessibleName("Cadastro de Cliente");

        jLabel1.setForeground(java.awt.Color.lightGray);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cada cliente.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 20, 300, 50);

        planodefundolabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/planodefundoapp.png"))); // NOI18N
        planodefundolabel.setText("Fundo");
        getContentPane().add(planodefundolabel);
        planodefundolabel.setBounds(0, 0, 840, 320);

        setSize(new java.awt.Dimension(848, 353));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCpfActionPerformed
        btnCpf.setSelected(true);
        btnCnpj.setSelected(false);
        txtDataNascimento.setEditable(true);
        cbxEstadoCivil.setEnabled(true);
        
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btnCpfActionPerformed

    private void btnCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCnpjActionPerformed
        btnCpf.setSelected(false);
        btnCnpj.setSelected(true);
        txtDataNascimento.setEditable(false);
        cbxEstadoCivil.setEnabled(false);
        
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btnCnpjActionPerformed

    private void txtDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascimentoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void cbxEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoCivilActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (validaCampos()) {
            if (btnCpf.isSelected()) {
                Fisico cliente = new Fisico();
                
                cliente.setCodigoCliente(clienteDao.consultaProximoCodigo());
                String cpf = txtCpf.getText();
                cpf = cpf.replace(".", "");
                cpf = cpf.replace("-", "");
                
                cliente.setCpf(cpf);
                cliente.setNome(txtNome.getText());
                cliente.setDataNascimento(txtDataNascimento.getText());
                cliente.setLagradouro(txtLagradouro.getText());
                cliente.setNumero(Integer.parseInt(txtNumero.getText()));
                cliente.setBairro(txtBairro.getText());
                cliente.setCep(txtCep.getText());
                cliente.setEstado(cbxEstado.getSelectedItem().toString());
                cliente.setCidade(txtCidade.getText());
                cliente.setEstadoCivil(cbxEstadoCivil.getSelectedItem().toString());
                switch (clienteDao.salvar(cliente)) {
                    case 1: {
                        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
                        break;
                    }
                }
            }else if(btnCnpj.isSelected()){
                Juridico cliente = new Juridico();
                
                cliente.setCodigoCliente(clienteDao.consultaProximoCodigo());
                String cnpj = txtCpf.getText();
                cnpj = cnpj.replace(".", "");
                cnpj = cnpj.replace("-", "");
                cnpj = cnpj.replace("/", "");
                
                cliente.setCnpj(cnpj);
                cliente.setNome(txtNome.getText());
                cliente.setLagradouro(txtLagradouro.getText());
                cliente.setNumero(Integer.parseInt(txtNumero.getText()));
                cliente.setBairro(txtBairro.getText());
                cliente.setCep(txtCep.getText());
                cliente.setEstado(cbxEstado.getSelectedItem().toString());
                cliente.setCidade(txtCidade.getText());
                switch (clienteDao.salvar(cliente)) {
                    case 1: {
                        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private boolean validaCampos() {
        int numero;
        
        if(btnCpf.isSelected()){
            if (txtCpf.getText().equals("   .   .   -  ")) {
                JOptionPane.showMessageDialog(null, "Erro: CPF invalido");
                txtCpf.requestFocus();
                return false;
            }
        }else if(btnCnpj.isSelected()){
            if (txtCpf.getText().equals("  .   .   /    -  ")) {
                JOptionPane.showMessageDialog(null, "Erro: CNPJ invalido");
                txtCpf.requestFocus();
                return false;
            }
        }
        
        if (txtNome.getText().length()<2) {
            JOptionPane.showMessageDialog(null, "Erro: Nome invalido");
            txtNome.requestFocus();
            return false;
        }
        
        if (txtDataNascimento.getText().equals("  /  /    ")&&btnCpf.isSelected()) {
            JOptionPane.showMessageDialog(null, "Erro: Nascimento invalido");
            txtDataNascimento.requestFocus();
            return false;
        }
        
        if (cbxEstadoCivil.getSelectedItem().toString().length()==1&&btnCpf.isSelected()) {
            JOptionPane.showMessageDialog(null, "Erro: Selecione um estado civil");
            cbxEstadoCivil.requestFocus();
            return false;
        }
        
        if (txtLagradouro.getText().length()<2) {
            JOptionPane.showMessageDialog(null, "Erro: Logradouro invalido");
            txtLagradouro.requestFocus();
            return false;
        }
        
        try {
            numero = Integer.parseInt(txtNumero.getText());
        } catch (NumberFormatException e) {
            numero=0;
        }
        if (numero<=0||numero>20000) {
            JOptionPane.showMessageDialog(null, "Erro: Numero invalido");
            txtNumero.requestFocus();
            return false;
        }
        
        if (txtCep.getText().equals("     -   ")) {
            JOptionPane.showMessageDialog(null, "Erro: Cep invalido");
            txtCep.requestFocus();
            return false;
        }
        
        if (txtBairro.getText().length()<2) {
            JOptionPane.showMessageDialog(null, "Erro: Bairro invalido");
            txtBairro.requestFocus();
            return false;
        }
        
        if (txtCidade.getText().length()<2) {
            JOptionPane.showMessageDialog(null, "Erro: Cidade invalida");
            txtCidade.requestFocus();
            return false;
        }
        
        if (cbxEstado.getSelectedItem().toString().length()==1) {
            JOptionPane.showMessageDialog(null, "Erro: Selecione um estado");
            cbxEstado.requestFocus();
            return false;
        }

        return true;
    }

    private void toogleCpfEntreCnpj() {
        if (btnCpf.isSelected()) {
            btnCnpj.setSelected(true);
            btnCpf.setSelected(false);
        } else if (btnCnpj.isSelected()) {
            btnCpf.setSelected(true);
            btnCnpj.setSelected(false);
        } else {
            btnCpf.setSelected(true);
            btnCnpj.setSelected(false);
        }
    }

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
            java.util.logging.Logger.getLogger(TelaCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JRadioButton btnCnpj;
    private javax.swing.JRadioButton btnCpf;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxEstadoCivil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel planodefundolabel;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtLagradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
