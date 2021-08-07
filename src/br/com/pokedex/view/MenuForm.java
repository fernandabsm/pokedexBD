/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.view;

import javax.swing.JOptionPane;

/**
 *
 * @author nanda
 */
public class MenuForm extends javax.swing.JFrame {

    /**
     * Creates new form MenuForm
     */
    public MenuForm() {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        MenuPokemons = new javax.swing.JMenu();
        MenuAcessoPokemons = new javax.swing.JMenuItem();
        MenuTreinadores = new javax.swing.JMenu();
        MenuAcessoTreinadores = new javax.swing.JMenuItem();
        MenuMudarUsuario = new javax.swing.JMenu();
        MenuTrocarUsuario = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MenuPokemons.setText("Pokémons");

        MenuAcessoPokemons.setText("Acesso aos Pokémons");
        MenuAcessoPokemons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAcessoPokemonsActionPerformed(evt);
            }
        });
        MenuPokemons.add(MenuAcessoPokemons);

        jMenuBar1.add(MenuPokemons);

        MenuTreinadores.setText("Treinadores");

        MenuAcessoTreinadores.setText("Acesso aos Treinadores");
        MenuAcessoTreinadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAcessoTreinadoresActionPerformed(evt);
            }
        });
        MenuTreinadores.add(MenuAcessoTreinadores);

        jMenuBar1.add(MenuTreinadores);

        MenuMudarUsuario.setText("Configurações");

        MenuTrocarUsuario.setText("Trocar de Usuário");
        MenuTrocarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTrocarUsuarioActionPerformed(evt);
            }
        });
        MenuMudarUsuario.add(MenuTrocarUsuario);

        jMenuBar1.add(MenuMudarUsuario);

        MenuSair.setText("Sair");
        MenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuTrocarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTrocarUsuarioActionPerformed
        // Trocar de usuario
        LoginForm login = new LoginForm();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_MenuTrocarUsuarioActionPerformed

    private void MenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSairMouseClicked
        // Sair
        int op;
        op = JOptionPane.showConfirmDialog(null, "Deseja sair?");
        if(op == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_MenuSairMouseClicked

    private void MenuAcessoPokemonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAcessoPokemonsActionPerformed
        //Acesso ao menu de pokemons
        PokemonForm menuPokemons = new PokemonForm();
        menuPokemons.setVisible(true);
    }//GEN-LAST:event_MenuAcessoPokemonsActionPerformed

    private void MenuAcessoTreinadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAcessoTreinadoresActionPerformed
        // TODO add your handling code here:
        TreinadorForm menuTreinadores = new TreinadorForm();
        menuTreinadores.setVisible(true);
    }//GEN-LAST:event_MenuAcessoTreinadoresActionPerformed

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
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuAcessoPokemons;
    private javax.swing.JMenuItem MenuAcessoTreinadores;
    private javax.swing.JMenu MenuMudarUsuario;
    public javax.swing.JMenu MenuPokemons;
    private javax.swing.JMenu MenuSair;
    public javax.swing.JMenu MenuTreinadores;
    private javax.swing.JMenuItem MenuTrocarUsuario;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}