/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import AccesoDatos.Coleccion_Cliente;
import AccesoDatos.Coleccion_Instructor;
import AccesoDatos.Coleccion_Sucursal;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author marcosisaacarayaabarca
*/ 
public class PanelRegistro extends JPanel {
    private Coleccion_Cliente coleccionCliente;
    private Coleccion_Instructor coleccionInstructor;
    private Coleccion_Sucursal coleccionSucursal;

    public PanelRegistro(Coleccion_Cliente coleccionCliente, Coleccion_Instructor coleccionInstructor, Coleccion_Sucursal coleccionSucursal) {
        initComponents();
        this.coleccionCliente = coleccionCliente;
        this.coleccionInstructor = coleccionInstructor;
        this.coleccionSucursal = coleccionSucursal;
    }


    private void ShowPanel(JPanel p) {
        p.setSize(600, 600);
        p.setLocation(0, 0);
        Mostrar.removeAll();
        Mostrar.add(p, BorderLayout.CENTER);
        Mostrar.revalidate();
        Mostrar.repaint();

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Instructor = new javax.swing.JButton();
        Sucursal = new javax.swing.JButton();
        Cliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Mostrar = new javax.swing.JPanel();

        jLabel3.setText("jLabel3");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/WhatsApp Image 2025-09-09 at 10.44.24 PM.jpeg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(765, 404));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 247, 1253));

        jLabel2.setFont(new java.awt.Font("DIN Condensed", 2, 48)); // NOI18N
        jLabel2.setText("REGISTRO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 17, 216, 68));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 73, 519, -1));

        Instructor.setText("Registro Instructor");
        Instructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructorActionPerformed(evt);
            }
        });
        jPanel1.add(Instructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        Sucursal.setText("Registro Sucursal");
        Sucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SucursalActionPerformed(evt);
            }
        });
        jPanel1.add(Sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        Cliente.setText("Registro Cliente");
        Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteActionPerformed(evt);
            }
        });
        jPanel1.add(Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));

        jScrollPane1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jScrollPane1ComponentAdded(evt);
            }
        });

        javax.swing.GroupLayout MostrarLayout = new javax.swing.GroupLayout(Mostrar);
        Mostrar.setLayout(MostrarLayout);
        MostrarLayout.setHorizontalGroup(
            MostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 771, Short.MAX_VALUE)
        );
        MostrarLayout.setVerticalGroup(
            MostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(Mostrar);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 560, 480));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1560, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void InstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstructorActionPerformed
        RegistroInstructor p1 = new RegistroInstructor(this.coleccionInstructor, this.coleccionSucursal);
        ShowPanel(p1);;
    }//GEN-LAST:event_InstructorActionPerformed

    private void SucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SucursalActionPerformed
        RegistroCliente regCliente = new RegistroCliente(this.coleccionCliente, this.coleccionSucursal);
        RegistroSucursal p1 = new RegistroSucursal(this.coleccionSucursal, regCliente);
        ShowPanel(p1);
    }//GEN-LAST:event_SucursalActionPerformed

    private void ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteActionPerformed
        RegistroCliente p1 = new RegistroCliente(coleccionCliente, coleccionSucursal);
        ShowPanel(p1);
    }//GEN-LAST:event_ClienteActionPerformed

    private void jScrollPane1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jScrollPane1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1ComponentAdded

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cliente;
    private javax.swing.JButton Instructor;
    private javax.swing.JPanel Mostrar;
    private javax.swing.JButton Sucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

