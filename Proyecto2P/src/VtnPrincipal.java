/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author ivan
 */
public class VtnPrincipal extends javax.swing.JFrame {

    public static Nodo r=null;
    public Nodo arr[]= new Nodo[2];
    /**
     * Creates new form VtnG1
     */
    public VtnPrincipal() {
        initComponents();
        setTitle("Agenda");
        try
        {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream("Archivo.dat"));
            r = (Nodo) file.readObject();
            file.close();
            if (r != null)
            {
                actualiza();
            }
        } catch (ClassNotFoundException ex)
        {
            System.out.println("La clase no existe o diferente");
        } catch (IOException e)
        {
            System.out.println("No existe el archivo");
        }
        bloquea();
        
    }
    public void bloquea()
    {
        if (r == null)
        {
            BtnE.setEnabled(false);
        } else
        {
            BtnE.setEnabled(true);
        }
    }
    private void actualiza()
    {
        Panel.removeAll();
        if (r != null)
        {
            Nodo aux = r;
            while (aux != null)
            {
                JButton boton = new JButton(aux.getEtq());
                Panel.add(boton);
                boton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        VtnAgendaCont1 per = new VtnAgendaCont1();
                        per.grupo = boton.getText();
                        per.setVisible(true);
                        per.actualiza();
                        per.bloquea();
                    }
                }
                );
                aux = aux.getSiguiente();
            }
        }
        Panel.updateUI();
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Panel = new javax.swing.JPanel();
        BtnA = new javax.swing.JButton();
        BtnE = new javax.swing.JButton();
        BtnS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Panel.setLayout(new java.awt.GridLayout(0, 1, 0, 1));
        jScrollPane1.setViewportView(Panel);

        BtnA.setText("Añadir");
        BtnA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAMouseClicked(evt);
            }
        });
        BtnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAActionPerformed(evt);
            }
        });

        BtnE.setText("Eliminar");
        BtnE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEMouseClicked(evt);
            }
        });

        BtnS.setText("Salir");
        BtnS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSMouseClicked(evt);
            }
        });
        BtnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnA, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnE, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnS, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnA)
                    .addComponent(BtnE))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAActionPerformed
        
    }//GEN-LAST:event_BtnAActionPerformed

    private void BtnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSActionPerformed
        
    }//GEN-LAST:event_BtnSActionPerformed

    private void BtnEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEMouseClicked
        String s = "";
        s = JOptionPane.showInputDialog("Inserte el nombre del grupo a eliminar");
        if (s == null)
        {
            s = "";
        }
        if (s.length() != 0)
        {
            String[] etqs = new String[1];
            etqs[0] = s;
            arr = Multilistas.elimina(r, s, 0, etqs, arr );
            if(arr[0]!=null)
            {
                if(etqs.length == 1)
                {
                    r=arr[1];
                }else
                {
                    String aux[] = new String[etqs.length-1];
                    System.arraycopy(etqs, 0, aux, 0, etqs.length-1);
                    Multilistas.rec(r, aux[aux.length-1], 0, aux, arr[1]);
                }
            }
       }
        actualiza();
        bloquea();
    }//GEN-LAST:event_BtnEMouseClicked

    private void BtnAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAMouseClicked
       String s = "";
        s = JOptionPane.showInputDialog("Insete el nombre del nuevo grupo");
        if (s == null)
        {
            s = "";
        }
        if (s.length() != 0)
        {
            Nodo n= new Nodo(null, s);
            String[] etqs = new String[1];
            etqs[0] = s;
            r = Multilistas.inserta(r, n, 0, etqs);
            actualiza();
            bloquea();
        }
    }//GEN-LAST:event_BtnAMouseClicked

    private void BtnSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSMouseClicked

        try
        {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("Archivo.dat"));
            file.writeObject(r);
            file.close();
        } catch (IOException ex)
        {
            System.out.println("No se pudo guardar");
        }
        dispose();
        System.exit(0);
    }//GEN-LAST:event_BtnSMouseClicked

    
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
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnA;
    private javax.swing.JButton BtnE;
    private javax.swing.JButton BtnS;
    private javax.swing.JPanel Panel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}