import java.io.File;
import javax.swing.JFileChooser;
import java.io.StringWriter;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEditor = new javax.swing.JTextArea();
        botonEjecutar = new javax.swing.JButton();
        label3 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtConsola = new javax.swing.JTextArea();
        label4 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        OpcionNuevo = new javax.swing.JMenuItem();
        OpcionAbrir = new javax.swing.JMenuItem();
        OpcionGuardar = new javax.swing.JMenuItem();
        OpcionSalir = new javax.swing.JMenuItem();
        MenuReportes = new javax.swing.JMenu();
        OpcionErrores = new javax.swing.JMenuItem();
        OpcionTokens = new javax.swing.JMenuItem();
        MenuAyuda = new javax.swing.JMenu();
        OpcionAcercaDe = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Bauhaus 93", 0, 48)); // NOI18N
        label1.setText("ELI NOSQL");

        label2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        label2.setText("EDITOR DE TEXTO:");

        txtEditor.setColumns(40);
        txtEditor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEditor.setRows(10);
        jScrollPane1.setViewportView(txtEditor);

        botonEjecutar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        botonEjecutar.setText("EJECUTAR");
        botonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEjecutarActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        label3.setText("CONSOLA:");

        txtConsola.setEditable(false);
        txtConsola.setColumns(40);
        txtConsola.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtConsola.setRows(5);
        jScrollPane2.setViewportView(txtConsola);

        label4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        label4.setText("OUTPUT:");

        txtOutput.setEditable(false);
        txtOutput.setColumns(20);
        txtOutput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtOutput.setRows(5);
        jScrollPane3.setViewportView(txtOutput);

        MenuArchivo.setText("Archivo");

        OpcionNuevo.setText("Nuevo");
        OpcionNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionNuevoActionPerformed(evt);
            }
        });
        MenuArchivo.add(OpcionNuevo);

        OpcionAbrir.setText("Abrir");
        OpcionAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionAbrirActionPerformed(evt);
            }
        });
        MenuArchivo.add(OpcionAbrir);

        OpcionGuardar.setText("Guardar");
        OpcionGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionGuardarActionPerformed(evt);
            }
        });
        MenuArchivo.add(OpcionGuardar);

        OpcionSalir.setText("Salir");
        OpcionSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionSalirActionPerformed(evt);
            }
        });
        MenuArchivo.add(OpcionSalir);

        jMenuBar1.add(MenuArchivo);

        MenuReportes.setText("Reportes");

        OpcionErrores.setText("Errores");
        OpcionErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionErroresActionPerformed(evt);
            }
        });
        MenuReportes.add(OpcionErrores);

        OpcionTokens.setText("Tokens");
        OpcionTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionTokensActionPerformed(evt);
            }
        });
        MenuReportes.add(OpcionTokens);

        jMenuBar1.add(MenuReportes);

        MenuAyuda.setText("Ayuda");

        OpcionAcercaDe.setText("Acerca de");
        MenuAyuda.add(OpcionAcercaDe);

        jMenuBar1.add(MenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(376, 376, 376))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void OpcionSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OpcionSalirActionPerformed

    private void botonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEjecutarActionPerformed

        txtConsola.setText("el boton esta funcionando");
        txtOutput.setText("todo bien");
        javax.swing.JOptionPane.showMessageDialog(this, "boton funcionandoooooo");
    }//GEN-LAST:event_botonEjecutarActionPerformed

    private void OpcionNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionNuevoActionPerformed
        txtEditor.setText("");
        txtConsola.setText("");
        txtOutput.setText("");
    }//GEN-LAST:event_OpcionNuevoActionPerformed

    private void OpcionAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionAbrirActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                String contenido = new String(java.nio.file.Files.readAllBytes(archivo.toPath()));
                txtEditor.setText(contenido);
                txtConsola.setText("Archivo cargado: " + archivo.getName());
            } catch (Exception e) {
                txtConsola.setText("Error al abrir archivo: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_OpcionAbrirActionPerformed

    private void OpcionGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionGuardarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                java.nio.file.Files.write(archivo.toPath(), txtEditor.getText().getBytes());
                txtConsola.setText("Archivo guardado: " + archivo.getName());
            } catch (Exception e) {
                txtConsola.setText("Error al guardar: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_OpcionGuardarActionPerformed

    private void OpcionErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionErroresActionPerformed
        // CREAR VENTANA
        JFrame frameErrores = new JFrame("Reporte de Errores");
        frameErrores.setSize(600, 400);
        
        // Datos de prueba
        String[][] datos = {
            {"1", "Lexico", "El caracter '$' no pertenece al lenguaje", "5", "3"},
            {"2", "Lexico", "La palabra 'Def' no pertenece al lenguaje", "6", "3"},
            {"3", "Lexico", "El caracter '#' no pertenece al lenguaje", "12", "5"}
        };
        
        String[] columnas = {"#", "Tipo", "Descripcion", "Linea", "Columna"};
        
        JTable tabla = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tabla);
        frameErrores.add(scrollPane);
        frameErrores.setVisible(true);
        
    }//GEN-LAST:event_OpcionErroresActionPerformed

    private void OpcionTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionTokensActionPerformed
        // CREAR VENTANA
        JFrame frameTokens = new JFrame("Tabla de Tokens");
        frameTokens.setSize(600, 400);
        
        // Si hay codigo en el editor, analizarlo y mostrar tokens
        String codigo = txtEditor.getText();
        if (codigo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay codigo para analizar");
            return;
        }
        
        try {
            java.io.Reader reader = new java.io.StringReader(codigo);
            eli.compiler.Lexer lexer = new eli.compiler.Lexer(reader);
            
            // PRIMERA PASADA: Contar tokens para crear la matriz
            java.util.ArrayList<String[]> listaTokens = new java.util.ArrayList<>();
            java_cup.runtime.Symbol token;
            int contador = 1;
            
            listaTokens.add(new String[]{"#", "Token", "Lexema", "Linea", "Columna"});
            
            while ((token = lexer.next_token()).sym != eli.compiler.sym.EOF) {
                String nombreToken = eli.compiler.sym.terminalNames[token.sym];
                String lexema = token.value != null ? token.value.toString() : "";
                String linea = String.valueOf(token.left);
                String columna = String.valueOf(token.right);
                
               listaTokens.add(new String[]{
                    String.valueOf(contador++),
                    nombreToken,
                    lexema,
                    linea,
                    columna
                });
            }
        
            // CONVERTIR A MATRIZ PARA LA TABLA
            String[][] datos = listaTokens.toArray(new String[0][0]);
            String[] columnas = datos[0]; // La primera fila son los encabezados
            
            // CREAR TABLA CON LOS DATOS (sin la primera fila de encabezados)
            String[][] datosReales = java.util.Arrays.copyOfRange(datos, 1, datos.length);
            
            JTable tabla = new JTable(datosReales, columnas);
            JScrollPane scrollPane = new JScrollPane(tabla);
            frameTokens.add(scrollPane);
            frameTokens.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al analizar: " + e.getMessage());
        }
    }//GEN-LAST:event_OpcionTokensActionPerformed
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenu MenuAyuda;
    private javax.swing.JMenu MenuReportes;
    private javax.swing.JMenuItem OpcionAbrir;
    private javax.swing.JMenuItem OpcionAcercaDe;
    private javax.swing.JMenuItem OpcionErrores;
    private javax.swing.JMenuItem OpcionGuardar;
    private javax.swing.JMenuItem OpcionNuevo;
    private javax.swing.JMenuItem OpcionSalir;
    private javax.swing.JMenuItem OpcionTokens;
    private javax.swing.JButton botonEjecutar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private javax.swing.JTextArea txtConsola;
    private javax.swing.JTextArea txtEditor;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables
}
