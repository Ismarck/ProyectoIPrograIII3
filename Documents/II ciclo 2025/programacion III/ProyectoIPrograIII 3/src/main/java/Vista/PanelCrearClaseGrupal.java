/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Modelo.ClaseGrupal;
import Modelo.Instructor;
import Controlador.Controlador_ClaseGrupal;
import Controlador.Controlador_Cliente;
import Controlador.Controlador_Instructor;
import Modelo.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author marcosisaacarayaabarca
 */
public class PanelCrearClaseGrupal extends javax.swing.JPanel {

    private Controlador_ClaseGrupal controlador;
    private Controlador_Instructor controladorInstructor;
    private Controlador_Cliente controladorCliente;
    private DefaultTableModel modeloTabla;
    
    /**
     * Creates new form PanelCrearClaseGrupal
     */
    
    public PanelCrearClaseGrupal(Controlador_ClaseGrupal controlador,Controlador_Instructor controladorInstructor,Controlador_Cliente controladorCliente) {
    this.controlador = controlador;
    this.controladorInstructor = controladorInstructor;
    this.controladorCliente = controladorCliente; // agregar atributo
    initComponents();
    cargarInstructores();
    inicializarTabla();
}
    private void cargarInstructores() {
        CombxInstructorclase.removeAllItems();
        for (Instructor ins : controladorInstructor.listar()) {
            CombxInstructorclase.addItem(ins);
        }
    }
    
    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel(new String[]{"Tipo", "Instructor", "Horario", "Cupo Max", "Disponibles"}, 0);
        jTable2.setModel(modeloTabla);
        actualizarTabla();
    }
    
    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (ClaseGrupal c : controlador.listarClases()) {
            modeloTabla.addRow(new Object[]{
                    c.getTipoClase(),
                    c.getInstructor().getNombre(),
                    c.getHorario(),
                    c.getCupoMaximo(),
                    c.getCuposDisponibles()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ClaseGrupal = new javax.swing.JLabel();
        TipoClase = new javax.swing.JLabel();
        txtTipoClase = new javax.swing.JTextField();
        Instructor = new javax.swing.JLabel();
        Horario = new javax.swing.JLabel();
        CupoMaximo = new javax.swing.JLabel();
        txtHorario = new javax.swing.JTextField();
        txtCupoMaximo = new javax.swing.JTextField();
        CombxInstructorclase = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        ClaseGrupal1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Sucursal = new javax.swing.JLabel();
        txtSucursal = new javax.swing.JTextField();

        ClaseGrupal.setFont(new java.awt.Font("Gurmukhi MN", 0, 18)); // NOI18N
        ClaseGrupal.setText("Lista De Clases en la Sucursal");

        TipoClase.setText("Tipo Clase:");

        txtTipoClase.setText("jTextField1");

        Instructor.setText("Instructor:");

        Horario.setText("Horario:");

        CupoMaximo.setText("Cupo Maximo:");

        txtHorario.setText("jTextField1");

        txtCupoMaximo.setText("jTextField1");

        CombxInstructorclase.setModel(new DefaultComboBoxModel<Instructor>());

        btnCrear.setText("Crear Clase");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        ClaseGrupal1.setFont(new java.awt.Font("Gurmukhi MN", 0, 18)); // NOI18N
        ClaseGrupal1.setText("Crear Clase Grupal (Sucursal)");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Instructor", "Horario", "Cupo", "Disponible"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        Sucursal.setText("Sucursal:");

        txtSucursal.setText("jTextField1");
        txtSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSucursalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCrear)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(Instructor)
                                                    .addComponent(TipoClase)
                                                    .addComponent(Horario))
                                                .addGap(27, 27, 27))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(CupoMaximo)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCupoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CombxInstructorclase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtTipoClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(Sucursal)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(ClaseGrupal1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(ClaseGrupal, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ClaseGrupal1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TipoClase)
                            .addComponent(txtTipoClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Sucursal)
                        .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Instructor)
                    .addComponent(CombxInstructorclase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Horario)
                        .addGap(18, 18, 18)
                        .addComponent(CupoMaximo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCupoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClaseGrupal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        ClaseGrupal.getAccessibleContext().setAccessibleName("Crear Clase Grupal (Sucursal)");
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        try {
            String tipo = txtTipoClase.getText().trim();
            Instructor ins = (Instructor) CombxInstructorclase.getSelectedItem();
            String horario = txtHorario.getText().trim();
            int cupo = Integer.parseInt(txtCupoMaximo.getText().trim());
            String sucursal = txtSucursal.getText().trim();

            // Validar máximo 8 clases por sucursal
            if (controlador.contarClasesPorSucursal(sucursal) >= 8) {
                JOptionPane.showMessageDialog(this, "Ya se alcanzó el máximo de 8 clases en esta sucursal.");
                return;
            }

            ClaseGrupal clase = new ClaseGrupal(tipo, ins, horario, cupo, sucursal);
            controlador.crearClaseGrupal(clase);
            actualizarTabla();
            JOptionPane.showMessageDialog(this, "Clase creada con éxito.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtTipoClase.setText("");
        txtHorario.setText("");
        txtCupoMaximo.setText("");
        CombxInstructorclase.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSucursalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClaseGrupal;
    private javax.swing.JLabel ClaseGrupal1;
    private javax.swing.JComboBox<Instructor> CombxInstructorclase;
    private javax.swing.JLabel CupoMaximo;
    private javax.swing.JLabel Horario;
    private javax.swing.JLabel Instructor;
    private javax.swing.JLabel Sucursal;
    private javax.swing.JLabel TipoClase;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtCupoMaximo;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtSucursal;
    private javax.swing.JTextField txtTipoClase;
    // End of variables declaration//GEN-END:variables
}
