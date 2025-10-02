/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import AccesoDatos.Coleccion_Cliente;
import AccesoDatos.Coleccion_Sucursal;
import Modelo.Cliente;
import Modelo.Instructor;
import Modelo.Sucursal;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
/**
 *
 * @author marcosisaacarayaabarca
 */
public class RegistroCliente extends javax.swing.JPanel {
    
     private Coleccion_Cliente Coleccion;
     private Coleccion_Sucursal coleccionSucursales;
     private Map<String, Sucursal> mapaSucursales = new HashMap<>();
    

    
     
    public RegistroCliente(Coleccion_Cliente Coleccion,Coleccion_Sucursal coleccionSucursales) {
        initComponents();
        this.Coleccion = Coleccion;
        //
        this.coleccionSucursales = coleccionSucursales;
        actualizarComboSucursales(); 
        
        CombxSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarInstructoresDeSucursal(); 
            }
});
    
    }
  
    private void cargarInstructoresDeSucursal() {
    String claveSucursal = (String) CombxSucursal.getSelectedItem();
    Sucursal sucursalSeleccionada = mapaSucursales.get(claveSucursal);

    if (sucursalSeleccionada != null) {
        CombxInstructor.removeAllItems();
        for (Instructor i : sucursalSeleccionada.getListaInstructores()) {
            CombxInstructor.addItem(i);
        }
    }
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
        CombxInstructor.removeAllItems();
        for (Instructor ins : sucursal.getListaInstructores()) {
            CombxInstructor.addItem(ins); 
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Instructor = new javax.swing.JLabel();
        TextoNombre = new javax.swing.JTextField();
        TextoCorreo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TextoFechaN = new javax.swing.JLabel();
        TextoCedula = new javax.swing.JTextField();
        Cedula = new javax.swing.JLabel();
        FechaInscripcion = new javax.swing.JLabel();
        Sucursal = new javax.swing.JLabel();
        TextoFechaNAcimiento = new javax.swing.JTextField();
        TxtCelular = new javax.swing.JTextField();
        CombxSucursal = new javax.swing.JComboBox<>();
        CombxInstructor = new javax.swing.JComboBox<>();

        jLabel1.setText("Nombre Completo:");

        jLabel2.setText("Correo");

        Instructor.setText("Instructor:");

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Khmer MN", 0, 18)); // NOI18N
        jLabel5.setText("REGISTRO CLIENTE");

        TextoFechaN.setText("Fecha Nacimiento:");

        TextoCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoCedulaActionPerformed(evt);
            }
        });

        Cedula.setText("Cedula:");

        FechaInscripcion.setText("Celular");

        Sucursal.setText("Sucursal:");

        TextoFechaNAcimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoFechaNAcimientoActionPerformed(evt);
            }
        });

        TxtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCelularActionPerformed(evt);
            }
        });

        CombxSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CombxSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombxSucursalActionPerformed(evt);
            }
        });

        CombxInstructor.setModel((new javax.swing.DefaultComboBoxModel<Instructor>()));
        CombxInstructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombxInstructorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TextoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                .addComponent(TextoCorreo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Instructor))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(CombxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(CombxInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextoFechaNAcimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextoFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FechaInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoFechaNAcimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Instructor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CombxInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CombxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            String nombre = TextoNombre.getText().trim();
            String fechaNacimiento = TextoFechaNAcimiento.getText().trim();
            String correo = TextoCorreo.getText().trim();
            int cedula = Integer.parseInt(TextoCedula.getText().trim());
            int numeroCelular = Integer.parseInt(TxtCelular.getText().trim());
            char sexo = 'M'; 

            String claveSucursal = (String) CombxSucursal.getSelectedItem();
            Sucursal sucursalSeleccionada = mapaSucursales.get(claveSucursal);

            if (sucursalSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Seleccione una sucursal válida.");
                return;
            }

            Instructor instructorSeleccionado = (Instructor) CombxInstructor.getSelectedItem();
            if (instructorSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "Seleccione un instructor válido.");
                return;
            }

            boolean encontrado = false;
            for (Instructor ins : sucursalSeleccionada.getListaInstructores()) {
                if (ins.equals(instructorSeleccionado)) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "El instructor no pertenece a la sucursal seleccionada.");
                return;
            }

            String fechaInscripcion = java.time.LocalDate.now().toString();

            Cliente nuevo = new Cliente(
                    fechaInscripcion,
                    nombre,
                    fechaNacimiento,
                    correo,
                    numeroCelular,
                    cedula,
                    sexo,
                    instructorSeleccionado,
                    sucursalSeleccionada
            );

            sucursalSeleccionada.getClientes().add(nuevo);

            if (Coleccion.Insertar(nuevo)) {
                JOptionPane.showMessageDialog(this, "Cliente registrado con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "El cliente ya existe.");
            }

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Ingrese números válidos en cédula y celular.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar cliente: " + ex.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void TextoCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoCedulaActionPerformed

    private void TxtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCelularActionPerformed

    private void TextoFechaNAcimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoFechaNAcimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoFechaNAcimientoActionPerformed

    private void CombxSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombxSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CombxSucursalActionPerformed

    private void CombxInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombxInstructorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CombxInstructorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cedula;
    private javax.swing.JComboBox<Instructor> CombxInstructor;
    private javax.swing.JComboBox<String> CombxSucursal;
    private javax.swing.JLabel FechaInscripcion;
    private javax.swing.JLabel Instructor;
    private javax.swing.JLabel Sucursal;
    private javax.swing.JTextField TextoCedula;
    private javax.swing.JTextField TextoCorreo;
    private javax.swing.JLabel TextoFechaN;
    private javax.swing.JTextField TextoFechaNAcimiento;
    private javax.swing.JTextField TextoNombre;
    private javax.swing.JTextField TxtCelular;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
