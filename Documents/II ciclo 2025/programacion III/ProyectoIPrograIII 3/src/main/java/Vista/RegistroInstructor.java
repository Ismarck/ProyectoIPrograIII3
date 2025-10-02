/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;
import AccesoDatos.Coleccion_Instructor;
import AccesoDatos.Coleccion_Sucursal;
import Modelo.Instructor;
import Modelo.Sucursal;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;


/**
 *
 * @author marcosisaacarayaabarca
 */
public class RegistroInstructor extends javax.swing.JPanel {

    /**
     * Creates new form RegistroInstructor
     */
    
    private Coleccion_Instructor Coleccionins;
    private Coleccion_Sucursal coleccionSucursales;
    private Map<String, Sucursal> mapaSucursales = new HashMap<>();
    
    public RegistroInstructor(Coleccion_Instructor Coleccionins, Coleccion_Sucursal coleccionSucursales) {
        initComponents();
         this.Coleccionins = Coleccionins;
         
         this.coleccionSucursales = coleccionSucursales;
         actualizarComboSucursales(); 
    }

     public void actualizarComboSucursales() {
        CombxSucursal.removeAllItems();
        mapaSucursales.clear();

        for (Sucursal s : coleccionSucursales.Listar_Sucursal()) {
            String clave = s.getProvincia() + " - " + s.getCanton();
            CombxSucursal.addItem(clave);
            mapaSucursales.put(clave, s);
        }
    }
     
     public void actualizarComboInstructoresPorSucursal(Sucursal sucursal) {
        CombxSucursal.removeAllItems();
        for (Instructor ins : sucursal.getListaInstructores()) {
            CombxSucursal.addItem(ins.getNombre());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Especialidad = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        FechaNacimiento = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Nombreins = new javax.swing.JTextField();
        FechaNacIns = new javax.swing.JTextField();
        Correoins = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Celularins = new javax.swing.JTextField();
        Sucursal = new javax.swing.JLabel();
        CedulaIns = new javax.swing.JLabel();
        Especialidad3 = new javax.swing.JLabel();
        Cedulains = new javax.swing.JTextField();
        SexoIns = new javax.swing.JTextField();
        jComboBoxExpecialidad = new javax.swing.JComboBox<>();
        NumeroCelIns1 = new javax.swing.JLabel();
        CombxSucursal = new javax.swing.JComboBox<>();

        Especialidad.setText("Especialidad:");

        Nombre.setText("Nombre Completo:");

        FechaNacimiento.setText("Fecha Nacimiento:");

        jLabel4.setText("Correo:");

        Nombreins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreinsActionPerformed(evt);
            }
        });

        FechaNacIns.setText("jTextField1");
        FechaNacIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaNacInsActionPerformed(evt);
            }
        });

        Correoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreoinsActionPerformed(evt);
            }
        });

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Khmer MN", 0, 18)); // NOI18N
        jLabel5.setText("REGISTRO INSTRUCTOR");

        Celularins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CelularinsActionPerformed(evt);
            }
        });

        Sucursal.setText("Sucursal:");

        CedulaIns.setText("Cedula:");

        Especialidad3.setText("Sexo:");

        Cedulains.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CedulainsActionPerformed(evt);
            }
        });

        SexoIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SexoInsActionPerformed(evt);
            }
        });

        jComboBoxExpecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cross Fit", "Pesas", "Yoga", "Zumba", "Cardio", "Spinning", "TRX", "HIIT" }));

        NumeroCelIns1.setText("Numero Celular:");

        CombxSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CombxSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombxSucursalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel4)
                            .addComponent(FechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 360, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(FechaNacIns, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Especialidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cedulains, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombreins, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NumeroCelIns1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CedulaIns, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Celularins, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Correoins, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxExpecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CombxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SexoIns, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumeroCelIns1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Celularins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombreins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CedulaIns, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(FechaNacIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Cedulains, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Especialidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SexoIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Correoins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sucursal)
                    .addComponent(Especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxExpecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CombxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           try {
            String nombre = Nombreins.getText().trim();
            String especialidad = jComboBoxExpecialidad.getSelectedItem().toString();
            String fechaNacimiento = FechaNacIns.getText().trim();
            String correo = Correoins.getText().trim();
            int cedula = Integer.parseInt(Cedulains.getText().trim());
            int numeroCelular = Integer.parseInt(Celularins.getText().trim());
            char sexo = SexoIns.getText().trim().isEmpty() ? 'M' : SexoIns.getText().trim().charAt(0);

            String claveSucursal = CombxSucursal.getSelectedItem().toString();
            Sucursal sucursalSeleccionada = mapaSucursales.get(claveSucursal);
 
            Instructor nuevo = new Instructor(
                    especialidad,
                    nombre,
                    fechaNacimiento,
                    correo,
                    numeroCelular,
                    cedula,
                    sexo,
                    sucursalSeleccionada.getProvincia()
            );

            if (sucursalSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado una sucursal válida.");
                return;
            }

            if (Coleccionins.Insertar_Instructor(nuevo)) {
                sucursalSeleccionada.agregarInstructor(nuevo);
                JOptionPane.showMessageDialog(this, "Instructor registrado y asociado a sucursal.");
                actualizarComboInstructoresPorSucursal(sucursalSeleccionada);
            } else {
                JOptionPane.showMessageDialog(this, "El instructor ya existe.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El número de celular o cédula no es válido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void CelularinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CelularinsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CelularinsActionPerformed

    private void FechaNacInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaNacInsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaNacInsActionPerformed

    private void NombreinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreinsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreinsActionPerformed

    private void CedulainsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CedulainsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CedulainsActionPerformed

    private void SexoInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SexoInsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SexoInsActionPerformed

    private void CorreoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreoinsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorreoinsActionPerformed

    private void CombxSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombxSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CombxSucursalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CedulaIns;
    private javax.swing.JTextField Cedulains;
    private javax.swing.JTextField Celularins;
    private javax.swing.JComboBox<String> CombxSucursal;
    private javax.swing.JTextField Correoins;
    private javax.swing.JLabel Especialidad;
    private javax.swing.JLabel Especialidad3;
    private javax.swing.JTextField FechaNacIns;
    private javax.swing.JLabel FechaNacimiento;
    private javax.swing.JLabel Nombre;
    private javax.swing.JTextField Nombreins;
    private javax.swing.JLabel NumeroCelIns1;
    private javax.swing.JTextField SexoIns;
    private javax.swing.JLabel Sucursal;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxExpecialidad;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
