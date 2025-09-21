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
import Modelo.Sucursal;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//hola

/**
 *
 * @author marcosisaacarayaabarca
 */
public class PanelCrearClaseGrupal extends javax.swing.JPanel {

    private Controlador_ClaseGrupal controlador;
    private Controlador_Instructor controladorInstructor;
    private Controlador_Cliente controladorCliente;
    private DefaultTableModel modeloTabla;
    private List<Sucursal> listaSucursales; // lista de sucursales



    
    /**
     * Creates new form PanelCrearClaseGrupal
     */
    
    /*public PanelCrearClaseGrupal(Controlador_ClaseGrupal controlador,Controlador_Instructor controladorInstructor,Controlador_Cliente controladorCliente) {
    this.controlador = controlador;
    this.controladorInstructor = controladorInstructor;
    this.controladorCliente = controladorCliente; // agregar atributo
    initComponents();
    cargarInstructores();
    inicializarTabla();
}*/
    /* mantener public PanelCrearClaseGrupal(Controlador_ClaseGrupal controlador,
                                 Controlador_Instructor controladorInstructor,
                                 Controlador_Cliente controladorCliente) {
        this.controlador = controlador;
        this.controladorInstructor = controladorInstructor;
        this.controladorCliente = controladorCliente;
        initComponents();
        inicializarTabla();
        inicializarEventos();
    }*/
    public PanelCrearClaseGrupal(Controlador_ClaseGrupal controlador,
                             Controlador_Instructor controladorInstructor,
                             Controlador_Cliente controladorCliente) {
    this.controlador = controlador;
    this.controladorInstructor = controladorInstructor;
    this.controladorCliente = controladorCliente;
    initComponents();
    inicializarTabla();
    inicializarEventos(); // Asegurar que esto se llame después
}
    
    /*private void cargarInstructores(String sucursalBuscada) {
        /*CombxInstructorclase.removeAllItems();
        for (Instructor ins : controladorInstructor.listar()) {
            CombxInstructorclase.addItem(ins);
        }//
        CombxInstructorclase.removeAllItems();
        DefaultComboBoxModel<Instructor> modelo = new DefaultComboBoxModel<>();

        for (Instructor ins : controladorInstructor.listar()) {
            String suc = ins.getSucursal();
            if (suc != null && suc.trim().equalsIgnoreCase(sucursalBuscada)) {
                modelo.addElement(ins);
            }
        }

        CombxInstructorclase.setModel(modelo);

        if (modelo.getSize() == 0) {
            JOptionPane.showMessageDialog(this, "No se encontraron instructores en la sucursal: " + sucursalBuscada);
        } else {
            CombxInstructorclase.setSelectedIndex(0); // dispara el autocompletado
        }
    }*/
    //borrar si no funciona
    /*private void cargarInstructores(String sucursalBuscada) {
    CombxInstructorclase.removeAllItems();
    DefaultComboBoxModel<Instructor> modelo = new DefaultComboBoxModel<>();

    for (Instructor ins : controladorInstructor.listar()) {
        String suc = ins.getSucursal();
        if (suc != null && suc.trim().equalsIgnoreCase(sucursalBuscada)) {
            modelo.addElement(ins);
        }
    }

    CombxInstructorclase.setModel(modelo);

    if (modelo.getSize() == 0) {
        JOptionPane.showMessageDialog(this, "No se encontraron instructores en la sucursal: " + sucursalBuscada);
    } else {
        CombxInstructorclase.setSelectedIndex(0); // dispara autocompletado
    }
}//hastaaqeui
    */
    private void cargarInstructores(String sucursalBuscada) {
    CombxInstructorclase.removeAllItems();
    DefaultComboBoxModel<Instructor> modelo = new DefaultComboBoxModel<>();

    for (Instructor ins : controladorInstructor.listar()) {
        String suc = ins.getSucursal();
        if (suc != null && suc.trim().equalsIgnoreCase(sucursalBuscada)) {
            modelo.addElement(ins);
        }
    }

    CombxInstructorclase.setModel(modelo);

    if (modelo.getSize() == 0) {
        JOptionPane.showMessageDialog(this, "No se encontraron instructores en la sucursal: " + sucursalBuscada);
    } else {
        CombxInstructorclase.setSelectedIndex(0); // dispara el autocompletado
    }
}
    
    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel(new String[]{"Tipo", "Instructor", "Horario", "Cupo Max", "Disponibles"}, 0);
        jTable2.setModel(modeloTabla);
        actualizarTabla();
        inicializarEventos(); 
    }
    
   /* private void inicializarEventos() {
        // Quitamos listeners previos (si existieran) para no duplicarlos
        for (java.awt.event.ItemListener il : CombxInstructorclase.getItemListeners()) {
            CombxInstructorclase.removeItemListener(il);
        }

        // Autocompletar el tipo de clase cuando se selecciona un instructor
        CombxInstructorclase.addItemListener(e -> {
            if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                Instructor ins = (Instructor) e.getItem();
                if (ins != null && ins.getEspecialidad() != null) {
                    txtTipoClase.setText(ins.getEspecialidad());
                } else {
                    txtTipoClase.setText("");
                }
            }
        });
    }*/
    
    //Eliminar si no funciona 
    private void inicializarEventos() {
    CombxInstructorclase.addItemListener(e -> {
        if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            Instructor ins = (Instructor) e.getItem();
            if (ins != null && ins.getEspecialidad() != null) {
                txtTipoClase.setText(ins.getEspecialidad());
            } else {
                txtTipoClase.setText("");
            }
        }
    });
}
    //
    /*private void inicializarEventos() {
    CombxInstructorclase.addItemListener(e -> {
        if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            Instructor ins = (Instructor) e.getItem();
            if (ins != null && ins.getEspecialidad() != null) {
                txtTipoClase.setText(ins.getEspecialidad());
            } else {
                txtTipoClase.setText("");
            }
        }
    });
}*/

    
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        ClaseGrupal1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Sucursal = new javax.swing.JLabel();
        txtSucursal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        ClaseGrupal.setFont(new java.awt.Font("Gurmukhi MN", 0, 18)); // NOI18N
        ClaseGrupal.setText("Lista De Clases en la Sucursal");

        TipoClase.setText("Tipo Clase:");

        txtTipoClase.setText("jTextField1");
        txtTipoClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoClaseActionPerformed(evt);
            }
        });

        Instructor.setText("Instructor:");

        Horario.setText("Horario:");

        CupoMaximo.setText("Cupo Maximo:");

        txtHorario.setText("jTextField1");

        txtCupoMaximo.setText("jTextField1");

        CombxInstructorclase.setModel(new DefaultComboBoxModel<>());

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

        jButton1.setText("Buscar Sucursal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnLimpiar))
                .addContainerGap())
        );

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
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Horario)
                                    .addComponent(CupoMaximo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCupoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Instructor)
                                            .addComponent(Sucursal))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CombxInstructorclase, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48)
                                                .addComponent(jButton1))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TipoClase)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTipoClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(ClaseGrupal1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(ClaseGrupal, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ClaseGrupal1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sucursal)
                    .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Instructor)
                    .addComponent(CombxInstructorclase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTipoClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TipoClase))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(Horario)
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCupoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CupoMaximo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClaseGrupal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
       /*
        txtTipoClase.setText("");
        txtHorario.setText("");
        txtCupoMaximo.setText("");
        txtSucursal.setText(""); // <-- CAMBIO
        if (CombxInstructorclase.getItemCount() > 0) {
            CombxInstructorclase.setSelectedIndex(0); // <-- CAMBIO
        }*/
    txtTipoClase.setText("");
    txtHorario.setText("");
    txtCupoMaximo.setText("");
    txtSucursal.setText("");
    CombxInstructorclase.removeAllItems(); 
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSucursalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        /*String sucursalBuscada = txtSucursal.getText().trim();
        if (sucursalBuscada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una sucursal para buscar.");
            return;
        }

        if (CombxInstructorclase.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "No se encontraron instructores en la sucursal: " + sucursalBuscada);
        }
        DefaultComboBoxModel<Instructor> modelo = new DefaultComboBoxModel<>();
        for (Instructor ins : controladorInstructor.listar()) {
            String suc = ins.getSucursal();
            if (suc != null && suc.trim().equalsIgnoreCase(sucursalBuscada)) {
                modelo.addElement(ins);
            }
        }
        CombxInstructorclase.setModel(modelo);

        if (modelo.getSize() == 0) {
            JOptionPane.showMessageDialog(this, "No se encontraron instructores en la sucursal: " + sucursalBuscada);
        } else {
            CombxInstructorclase.setSelectedIndex(0); // dispara el autocompletado
        }*/
        
        //Mantener
        /*
        String sucursalBuscada = txtSucursal.getText().trim();

        if (sucursalBuscada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una sucursal para buscar.");
            return;
        }

        // Llamar al método que carga instructores filtrando por sucursal
        //cargarInstructores(sucursalBuscada);*/
        
        /*String sucursalBuscada = txtSucursal.getText().trim();

    if (sucursalBuscada.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese una sucursal para buscar.");
        return;
    }

    cargarInstructores(sucursalBuscada);*/
    String sucursalBuscada = txtSucursal.getText().trim();

    if (sucursalBuscada.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese una sucursal para buscar.");
        return;
    }

    cargarInstructores(sucursalBuscada);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTipoClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoClaseActionPerformed
       // Método vacío: no agregar listeners aquí
    }//GEN-LAST:event_txtTipoClaseActionPerformed


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
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
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
