/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import AccesoDatos.Coleccion_Cliente;
import AccesoDatos.Coleccion_Instructor;
import AccesoDatos.Coleccion_Sucursal;
import Modelo.Cliente;
import Modelo.Instructor;
import Modelo.Sucursal;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;


public class RegistroCliente extends javax.swing.JPanel {
    
    private Coleccion_Cliente Coleccion;
    //prueba combobox
    private Coleccion_Sucursal coleccionSucursales;
    private Coleccion_Instructor coleccionInstructores;
    private Map<String, Sucursal> mapaSucursales = new HashMap<>();
    private Map<String, Instructor> mapaInstructores = new HashMap<>();

     
    public RegistroCliente(Coleccion_Cliente Coleccion, Coleccion_Sucursal coleccionSucursales, Coleccion_Instructor coleccionInstructores) {
        initComponents();
        this.Coleccion = Coleccion;
        this.coleccionSucursales = coleccionSucursales;
        this.coleccionInstructores = coleccionInstructores;

        actualizarComboSucursales(); // opcional
        if (!mapaSucursales.isEmpty()) {
            Sucursal primeraSucursal = mapaSucursales.values().iterator().next();
            actualizarComboInstructores(primeraSucursal);
        }
    }

    // Llenar ComboBox de sucursales
    public void actualizarComboSucursales() {
        CombxSucursal.removeAllItems();
        mapaSucursales.clear();

        for (Sucursal s : coleccionSucursales.Listar_Sucursal()) {
            String clave = s.toString(); // "Provincia - Canton (Codigo)"
            CombxSucursal.addItem(clave);
            mapaSucursales.put(clave, s);
        }

        // Seleccionar la primera sucursal y actualizar instructores automáticamente
        if (!mapaSucursales.isEmpty()) {
            CombxSucursal.setSelectedIndex(0);
            actualizarComboInstructores(mapaSucursales.values().iterator().next());
        }
    }
    
    public void actualizarComboInstructores(Sucursal sucursal) {
    CombxInstructor.removeAllItems();
    mapaInstructores.clear();

    boolean hayInstructores = false;

    for (Instructor ins : coleccionInstructores.Listar_Instructor()) {
        if (ins.getSucursal() != null && 
            ins.getSucursal().getCodigo() == sucursal.getCodigo()) { // Comparación por código
            String clave = ins.getNombre() + " - " + ins.getEspecialidad();
            CombxInstructor.addItem(clave);
            mapaInstructores.put(clave, ins);
            hayInstructores = true;
        }
    }

    if (!hayInstructores) {
        CombxInstructor.addItem("No hay instructores en esta sucursal");
    }

    // Selecciona automáticamente el primer instructor si hay alguno
    if (hayInstructores) {
        CombxInstructor.setSelectedIndex(0);
    }
}

    
    /*public void actualizarComboInstructores(Sucursal sucursal) {
    CombxInstructor.removeAllItems();
    mapaInstructores.clear();

    for (Instructor ins : coleccionInstructores.Listar_Instructor()) {
        // Aquí asumimos que Instructor tiene un atributo sucursal
        if (ins.getSucursal() != null && ins.getSucursal().equals(sucursal)) {
            String clave = ins.getNombre() + " - " + ins.getEspecialidad();
            CombxInstructor.addItem(clave);
            mapaInstructores.put(clave, ins);
        }
    }

    // Si no hay instructores en la sucursal
    if (CombxInstructor.getItemCount() == 0) {
        CombxInstructor.addItem("No hay instructores en esta sucursal");
    }
}*/


    
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

        CombxInstructor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
 
        /*try {
            String Nombre = TextoNombre.getText();
            String Fecha_Nacimiento = TextoFechaNAcimiento.getText();
            String clave = (String) CombxSucursal.getSelectedItem();
            Sucursal sucursalSeleccionada = mapaSucursales.get(clave);
            String Correo = TextoCorreo.getText();
            String claveInstructor = (String) CombxInstructor.getSelectedItem();
            Instructor instructorSeleccionado = mapaInstructores.get(claveInstructor);

            int  numeroCelular = Integer.parseInt(TxtCelular.getText());
            int cedula = Integer.parseInt(TextoCedula.getText());

            // Otros datos que tu constructor pide
            String fechaInscripcion = java.time.LocalDate.now().toString(); // hoy
            char sexo = 'M'; // o 'F', según quieras implementarlo
            
            
            Instructor instructor1 = new Instructor(
            "CrossFit",
             "Benji",
            "2000-12-07",
            "benjacol@gmail.com",
            88776655,
            123456789,
            'M',
            );
            // Crear el objeto Cliente
            Cliente nuevo = new Cliente(
                    fechaInscripcion,
                    Nombre,
                    Fecha_Nacimiento,
                    Correo,
                    numeroCelular,
                    cedula,
                    sexo,
                    instructorSeleccionado,
                    sucursalSeleccionada
            );

            // Insertar con el controlador
            if (Coleccion.Insertar(nuevo)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Cliente registrado con éxito");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "El cliente ya existe");
            }

        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }*/
        
        
        /*
    try {
        String nombre = TextoNombre.getText().trim();
        String fechaNacimiento = TextoFechaNAcimiento.getText().trim();
        String correo = TextoCorreo.getText().trim();
        int numeroCelular = Integer.parseInt(TxtCelular.getText().trim());
        int cedula = Integer.parseInt(TextoCedula.getText().trim());

        // 🔹 Sucursal seleccionada
        String claveSucursal = (String) CombxSucursal.getSelectedItem();
        Sucursal sucursalSeleccionada = mapaSucursales.get(claveSucursal);

        // 🔹 Instructor seleccionado
        String claveInstructor = (String) CombxInstructor.getSelectedItem();
        Instructor instructorSeleccionado = mapaInstructores.get(claveInstructor);

        // Otros datos
        String fechaInscripcion = java.time.LocalDate.now().toString();
        char sexo = 'M'; // O desde un campo de texto

        // 👇 Crear Cliente
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

        if (sucursalSeleccionada != null) {
            nuevo.setSucursal(sucursalSeleccionada);
            sucursalSeleccionada.getClientes().add(nuevo);
        }

        if (Coleccion.Insertar(nuevo)) {
            JOptionPane.showMessageDialog(this, "Cliente registrado con éxito");
        } else {
            JOptionPane.showMessageDialog(this, "El cliente ya existe");
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El celular o cédula debe ser numérico.");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }  */
        
          try {
            String nombre = TextoNombre.getText().trim();
            String fechaNacimiento = TextoFechaNAcimiento.getText().trim();
            String correo = TextoCorreo.getText().trim();
            int numeroCelular = Integer.parseInt(TxtCelular.getText().trim());
            int cedula = Integer.parseInt(TextoCedula.getText().trim());

            String claveSucursal = (String) CombxSucursal.getSelectedItem();
            Sucursal sucursalSeleccionada = mapaSucursales.get(claveSucursal);

            String claveInstructor = (String) CombxInstructor.getSelectedItem();
            Instructor instructorSeleccionado = mapaInstructores.get(claveInstructor);

            if (sucursalSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Seleccione una sucursal válida.");
                return;
            }

            // Sexo opcional, por ahora 'M'
            char sexo = 'M';
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

            // Asignar cliente a la sucursal
            sucursalSeleccionada.getClientes().add(nuevo);

            if (Coleccion.Insertar(nuevo)) {
                JOptionPane.showMessageDialog(this, "Cliente registrado con éxito");
            } else {
                JOptionPane.showMessageDialog(this, "El cliente ya existe");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El celular o cédula debe ser numérico.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
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
        //String claveSucursal = (String) CombxSucursal.getSelectedItem();
        //Sucursal sucursalSeleccionada = mapaSucursales.get(claveSucursal);
        //if (sucursalSeleccionada != null) {
        //    actualizarComboInstructores(sucursalSeleccionada);
        //}
        String claveSucursal = (String) CombxSucursal.getSelectedItem();
        Sucursal sucursalSeleccionada = mapaSucursales.get(claveSucursal);
        if (sucursalSeleccionada != null) {
        actualizarComboInstructores(sucursalSeleccionada);
        }
    }//GEN-LAST:event_CombxSucursalActionPerformed

    private void CombxInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombxInstructorActionPerformed
    CombxInstructor.removeAllItems();
    mapaInstructores.clear();

    // 🔹 Obtener la sucursal seleccionada
    String claveSucursal = (String) CombxSucursal.getSelectedItem();
    Sucursal sucursalSeleccionada = mapaSucursales.get(claveSucursal);

    if (sucursalSeleccionada != null) {
        for (Instructor ins : coleccionInstructores.Listar_Instructor()) {
            if (ins.getSucursal() != null &&
                ins.getSucursal().getCodigo() == sucursalSeleccionada.getCodigo()) {
                String clave = ins.getNombre() + " - " + ins.getEspecialidad();
                CombxInstructor.addItem(clave);
                mapaInstructores.put(clave, ins);
            }
        }
    }

    if (CombxInstructor.getItemCount() == 0) {
        CombxInstructor.addItem("No hay instructores en esta sucursal");
    }
    }//GEN-LAST:event_CombxInstructorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cedula;
    private javax.swing.JComboBox<String> CombxInstructor;
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
