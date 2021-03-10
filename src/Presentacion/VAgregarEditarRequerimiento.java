/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Apoyo.Validacion;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Harby
 */
public class VAgregarEditarRequerimiento extends javax.swing.JPanel {
    
    private JFrame frame = new JFrame("Agregar Editar Requerimiento");
    private JDialog dialog;
    private PAgregarEditarRequerimiento presentador;
    private Validacion validar = new Validacion();
    
    public VAgregarEditarRequerimiento() {
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

        jPanel4 = new javax.swing.JPanel();
        PanelTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRegistro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboxArea = new javax.swing.JComboBox<>();
        cboxEtapa = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        panelBtnsEditar = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnCancelarModificar = new javax.swing.JButton();
        panelBtnsGuardar = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelarAgregar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 204));

        PanelTitle.setBackground(new java.awt.Color(255, 204, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NUEVO REQUERIMIENTO");

        javax.swing.GroupLayout PanelTitleLayout = new javax.swing.GroupLayout(PanelTitle);
        PanelTitle.setLayout(PanelTitleLayout);
        PanelTitleLayout.setHorizontalGroup(
            PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelTitleLayout.setVerticalGroup(
            PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelRegistro.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Etapa del Requerimiento:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Área de Negocio:");

        cboxArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboxEtapa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/skills.png"))); // NOI18N

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboxEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelBtnsEditar.setBackground(new java.awt.Color(255, 255, 204));

        btnModificar.setBackground(new java.awt.Color(255, 0, 0));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit.png"))); // NOI18N
        btnModificar.setText("Aceptar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCancelarModificar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelarModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelarModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnCancelarModificar.setText("Cancelar");
        btnCancelarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtnsEditarLayout = new javax.swing.GroupLayout(panelBtnsEditar);
        panelBtnsEditar.setLayout(panelBtnsEditarLayout);
        panelBtnsEditarLayout.setHorizontalGroup(
            panelBtnsEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnsEditarLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        panelBtnsEditarLayout.setVerticalGroup(
            panelBtnsEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtnsEditarLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panelBtnsEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        panelBtnsGuardar.setBackground(new java.awt.Color(204, 255, 153));

        btnGuardar.setBackground(new java.awt.Color(204, 245, 153));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/check.png"))); // NOI18N
        btnGuardar.setText("Aceptar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelarAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelarAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnCancelarAgregar.setText("Cancelar");
        btnCancelarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtnsGuardarLayout = new javax.swing.GroupLayout(panelBtnsGuardar);
        panelBtnsGuardar.setLayout(panelBtnsGuardarLayout);
        panelBtnsGuardarLayout.setHorizontalGroup(
            panelBtnsGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnsGuardarLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(btnCancelarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBtnsGuardarLayout.setVerticalGroup(
            panelBtnsGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtnsGuardarLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelBtnsGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCancelarAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBtnsGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBtnsEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBtnsGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBtnsEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (isValidatedForm()) {
            presentador.modificarRequerimiento();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (isValidatedForm()) {
            presentador.guardarRequerimiento();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAgregarActionPerformed
        this.cerrar();
    }//GEN-LAST:event_btnCancelarAgregarActionPerformed

    private void btnCancelarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarModificarActionPerformed
        this.cerrar();
    }//GEN-LAST:event_btnCancelarModificarActionPerformed
    
    public void setPresentador(PAgregarEditarRequerimiento p) {
        presentador = p;
    }

    public void iniciar(){       
        dialog = new JDialog(frame,true);
        dialog.setContentPane(this);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.pack();
        dialog.setSize(650, 400);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);//poner despues del null para centrar
    }
    
    public void cerrar(){
        frame.dispose();
    }
    
    public void deshabilitarBotones(){
        this.panelBtnsEditar.setVisible(false);
        this.panelBtnsGuardar.setVisible(false);
    }
        
    public void habilitarBtnsEmpleadoAgregar(){
        this.panelBtnsGuardar.setVisible(true);
    }
    public void habilitarBtnsEmpleadoModificar(){
        this.panelBtnsEditar.setVisible(true);
    }
    
    public String getEtapaSeleccionada(){
        return this.cboxEtapa.getSelectedItem().toString();
    }
    
    public String getAreaSeleccionada(){
        String idTipo = this.cboxArea.getSelectedItem().toString();
        idTipo = idTipo.split("-")[0];
        return idTipo;
    }
    
    public void setEtapa(String etapa){
        for (int i = 0; i < cboxEtapa.getItemCount(); i++) {
            if (cboxEtapa.getItemAt(i).equals(etapa)) {
                cboxEtapa.setSelectedIndex(i);
            }
        }        
    }
    public void setArea(String id, String area){
        for (int i = 0; i < cboxArea.getItemCount(); i++) {
            if (cboxArea.getItemAt(i).equals(id+"-"+area)) {
                cboxArea.setSelectedIndex(i);
            }
        }        
    }
    
    public void mostrarListaAreas(String[] tipos){
        this.cboxArea.setModel( new DefaultComboBoxModel<>( tipos ) );
    }

    private boolean isValidatedForm(){
       
        if (cboxArea.getSelectedItem()==null) {
            return false;
        }
        
        if (cboxEtapa.getSelectedItem()==null) {
            return false;
        }
        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTitle;
    private javax.swing.JButton btnCancelarAgregar;
    private javax.swing.JButton btnCancelarModificar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cboxArea;
    private javax.swing.JComboBox<String> cboxEtapa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelBtnsEditar;
    private javax.swing.JPanel panelBtnsGuardar;
    private javax.swing.JPanel panelRegistro;
    // End of variables declaration//GEN-END:variables
}
