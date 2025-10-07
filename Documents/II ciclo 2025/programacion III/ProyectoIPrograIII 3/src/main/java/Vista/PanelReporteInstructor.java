/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.Controlador_Instructor;

public class PanelReporteInstructor extends javax.swing.JPanel {

    private Controlador_Instructor controlador_Instructor;

    public PanelReporteInstructor(Controlador_Instructor controlador_Instructor) {
        initComponents();
        this.controlador_Instructor = controlador_Instructor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelBusquedaNombre = new javax.swing.JLabel();
        jTxtBusquedaporNombre = new javax.swing.JTextField();
        btnBusNombre = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelBusquedaNombre.setText("Busqueda Por Nombre:");
        jPanel1.add(LabelBusquedaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 151, 28));
        jPanel1.add(jTxtBusquedaporNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 42, 202, -1));

        btnBusNombre.setText("Buscar");
        btnBusNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusNombreActionPerformed(evt);
            }
        });
        jPanel1.add(btnBusNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 42, -1, -1));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusNombreActionPerformed
        String nombreInstructor = jTxtBusquedaporNombre.getText().trim();
        if (!nombreInstructor.isEmpty()) {
            Tabla.setModel(this.controlador_Instructor.obtenerTablaClientesPorInstructor(nombreInstructor));
        }

    }//GEN-LAST:event_btnBusNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBusquedaNombre;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnBusNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtBusquedaporNombre;
    // End of variables declaration//GEN-END:variables
}
