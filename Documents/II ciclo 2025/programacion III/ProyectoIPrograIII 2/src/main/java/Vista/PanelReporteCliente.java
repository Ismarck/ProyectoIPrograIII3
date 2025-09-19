/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import javax.swing.table.DefaultTableModel;
import Controlador.Controlador_Cliente;
import Modelo.Cliente;
import java.util.List;


/**
 *
 * @author marcosisaacarayaabarca
 */
public class PanelReporteCliente extends javax.swing.JPanel {
    
    private Controlador_Cliente controlador_Cliente;

    /**
     * Creates new form PanelUsuario
     */
    public PanelReporteCliente(Controlador_Cliente controlador) {
        initComponents();
       
        this.controlador_Cliente = controlador;
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        LabelBusquedaNombre1 = new javax.swing.JLabel();
        jTxtBusquedaporNombre1 = new javax.swing.JTextField();
        btnBusNombre1 = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Sexo", "Nacimiento", "Instructor", "Sucursal", "Correo", "Celular", "Inscripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 85, 762, 185));

        LabelBusquedaNombre1.setText("Nombre Cliente:");
        jPanel1.add(LabelBusquedaNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 100, 28));

        jTxtBusquedaporNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtBusquedaporNombre1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTxtBusquedaporNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 110, -1));

        btnBusNombre1.setText("Buscar");
        btnBusNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusNombre1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBusNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jTxtBusquedaporNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtBusquedaporNombre1ActionPerformed
      
    }//GEN-LAST:event_jTxtBusquedaporNombre1ActionPerformed

    private void btnBusNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusNombre1ActionPerformed
      String nombre = jTxtBusquedaporNombre1.getText();
      Tabla.setModel(controlador_Cliente.obtenerTablaClientesPorNombre(nombre));
    }//GEN-LAST:event_btnBusNombre1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBusquedaNombre1;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnBusNombre1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtBusquedaporNombre1;
    // End of variables declaration//GEN-END:variables
}
