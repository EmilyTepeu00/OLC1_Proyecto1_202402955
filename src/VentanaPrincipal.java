import java.io.File;
import javax.swing.JFileChooser;
import java.io.StringWriter;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Color;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    // VARIABLES DE INSTANCIA
    
    // Lista para almacenar errores lexicos encontrados durante el analisis
    private java.util.ArrayList<String[]> listaErrores = new java.util.ArrayList<>();

    // VARIABLES PARA EXPORT
    // Reultados del ultimo READ
    private List<Map<String, Object>> ultimosResultados = null;
    // Campos mostrados en el ultimo READ
    private String[] ultimosCampos = null;
    // Tabla consultada en el ultimo READ
    private String ultimaTabla = null;
    
    // CONSTRUCTOR
    public VentanaPrincipal() {
        initComponents();
        // Nombre de la ventana
        setTitle("ELI NOSQL");
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
        OpcionAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionAcercaDeActionPerformed(evt);
            }
        });
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
    
    // PARA CERRAR LA ACPLICACION
    private void OpcionSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionSalirActionPerformed
        System.exit(0); // Terminar el programa
    }//GEN-LAST:event_OpcionSalirActionPerformed
    
    // BOTON EJECUTAR: ejecuta el analisis lexico, sintactico y procesa las isntrucciones
    private void botonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEjecutarActionPerformed
        String codigo = txtEditor.getText();
        txtConsola.setText(""); // Limpiar consola
        txtOutput.setText("");  // Limpiar output
        listaErrores.clear();   // Limpiar errores anteriores
        
        // Gestor para persistencia (se inicializa si hay DATABASE)
        eli.compiler.GestorJSON gestor = null;
        
        // VERIFICAR SI HAY DATABASE
        if (codigo.contains("database") && codigo.contains("store at")) {
            // Extraer nombre y ruta de la base de datos
            java.util.regex.Pattern p = java.util.regex.Pattern.compile("database\\s+(\\w+)\\s*\\{\\s*store\\s+at\\s+\"([^\"]+)\"\\s*;\\s*\\}");
            java.util.regex.Matcher m = p.matcher(codigo);
            
            if (m.find()) {
                String nombreBD = m.group(1);
                String rutaJSON = m.group(2);
                
                gestor = new eli.compiler.GestorJSON(rutaJSON);
                gestor.setNombreBase(nombreBD);
                gestor.guardar();
                txtConsola.append("Base de datos guardada en: " + rutaJSON + "\n");
            }
        }
        
        if (codigo.trim().isEmpty()) {
            txtConsola.setText("No hay codigo para ejecutar");
            return;
        }
        
        txtConsola.append("EJECUTANDO CODIGO ELI...\n");
        txtConsola.append("========================================\n\n");
    
        try {
            // MOSTRAR CODIGO EN CONSOLA
            txtConsola.append("CODIGO FUENTE:\n");
            String[] lineas = codigo.split("\n");
            for (int i = 0; i < lineas.length; i++) {
                txtConsola.append(String.format("%3d: %s\n", i+1, lineas[i]));
            }
            txtConsola.append("\n========================================\n\n");
            
            // REDIRIGIR System.err PARA CAPTURAR ERRORES
            java.io.ByteArrayOutputStream errStream = new java.io.ByteArrayOutputStream();
            java.io.PrintStream errPrint = new java.io.PrintStream(errStream);
            java.io.PrintStream originalErr = System.err;
            System.setErr(errPrint);
            
            // ANALIZAR CON EL LEXER (GENERAR TOKENS)
            txtConsola.append("ANALISIS LEXICO:\n");
            java.io.Reader reader = new java.io.StringReader(codigo);
            eli.compiler.Lexer lexer = new eli.compiler.Lexer(reader);
            
            java_cup.runtime.Symbol token;
            int contadorTokens = 0;
            
            while ((token = lexer.next_token()).sym != eli.compiler.sym.EOF) {
                contadorTokens++;
                String nombreToken = eli.compiler.sym.terminalNames[token.sym];
                if (token.value != null) {
                    txtConsola.append(String.format("   Token %3d: %-20s → %s\n", 
                        contadorTokens, nombreToken, token.value));
                } else {
                    txtConsola.append(String.format("   Token %3d: %-20s\n", 
                        contadorTokens, nombreToken));
                }
            }
            
            // RESTAURAR System.err
            System.setErr(originalErr);
            
            // PROCESAR ERRORES LEXICOS CAPTURADOS
            String erroresCapturados = errStream.toString();
            if (!erroresCapturados.isEmpty()) {
                String[] lineasError = erroresCapturados.split("\n");
                for (String error : lineasError) {
                    if (error.contains("Error lexico")) {
                        // Extraer caracter invalido
                        String[] partes = error.split("'");
                        String caracter = partes.length > 1 ? partes[1] : "?";
                        
                        // Extraer linea y columna
                        int linea = 0, columna = 0;
                        java.util.regex.Pattern p = java.util.regex.Pattern.compile("linea (\\d+), columna (\\d+)");
                        java.util.regex.Matcher m = p.matcher(error);
                        if (m.find()) {
                            linea = Integer.parseInt(m.group(1));
                            columna = Integer.parseInt(m.group(2));
                        }
                        
                        listaErrores.add(new String[]{
                            String.valueOf(listaErrores.size() + 1),
                            "Lexico",
                            "Caracter invalido: '" + caracter + "'",
                            String.valueOf(linea),
                            String.valueOf(columna)
                        });
                    }
                }
                txtConsola.append("\nSe encontraron " + listaErrores.size() + " errores lexicos\n");
            } 
            
            // PROCESAR INSTRUCCIONES SI HAY GESTOR
            if (gestor != null) {
                procesarInstrucciones(codigo, gestor);  // TABBLE y ADD
                procesarRead(codigo, gestor);           // READ
            }
            
            // Procesar UPDATE y EXPORT
            if (gestor != null){
                procesarUpdate(codigo, gestor);  // UPDATE
            }
            procesarExport(codigo);  // GESTOR
            
            // MOSTRAR RESUMEN FINAL
            txtConsola.append("\nTotal de tokens: " + contadorTokens + "\n");
            txtConsola.append("\n========================================\n");
            txtConsola.append("ANALISIS COMPLETADO\n");
            
            txtOutput.setText("Analisis completado con exito\n" +
                             "Tokens encontrados: " + contadorTokens + "\n" +
                             "Errores encontrados: " + listaErrores.size());
            
        } catch (Exception e) {
            txtConsola.append("\nERROR DURANTE EL ANALISIS:\n");
            txtConsola.append("   " + e.getMessage() + "\n");
            txtOutput.setText("Error en el analisis");
            e.printStackTrace();
        }
    }//GEN-LAST:event_botonEjecutarActionPerformed

    // OPCION NUEVO ARCHIVO: Limpia el editor, consola y output
    private void OpcionNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionNuevoActionPerformed
        txtEditor.setText("");
        txtConsola.setText("");
        txtOutput.setText("");
    }//GEN-LAST:event_OpcionNuevoActionPerformed

    // OPCION ABRIR ARCHIVO: .code y lo carga al editor
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
    
    // OPCION GUARDAR
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
    
    // REPORTE DE ERRORES LEXICOS
    private void OpcionErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionErroresActionPerformed
        if (listaErrores.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay errores para mostrar");
            return;
        }
        
        // CREAR VENTANA
        JFrame frameErrores = new JFrame("Reporte de Errores - ELI NOSQL");
        frameErrores.setSize(800, 500);
        
        String[][] datos = listaErrores.toArray(new String[0][0]);
        String[] columnas = {"#", "Tipo", "Descripcion", "Linea", "Columna"};
        
        JTable tabla = new JTable(datos, columnas);
        
        // Formato de la tabla
        tabla.setRowHeight(25);
        tabla.setGridColor(new java.awt.Color(200, 200, 200)); // Color de cuadricula
        tabla.setShowGrid(true);
        
        // COLORES Y TEXTO CENTRADO
        tabla.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                // Colores alternados para las filas
                if (!isSelected) {
                    if (row % 2 == 0) {
                        c.setBackground(new java.awt.Color(240, 248, 255));
                    } else {
                        c.setBackground(java.awt.Color.WHITE);
                    }
                }
                
                // Centrar texto
                ((javax.swing.table.DefaultTableCellRenderer) c).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14));
                
                return c;
            }
        });
        
        // Ajustar ancho de columnas
        tabla.getColumnModel().getColumn(0).setPreferredWidth(40);   // #
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);  // Tipo
        tabla.getColumnModel().getColumn(2).setPreferredWidth(350);  // Descripcion
        tabla.getColumnModel().getColumn(3).setPreferredWidth(60);   // Linea
        tabla.getColumnModel().getColumn(4).setPreferredWidth(60);   // Columna
        
        JScrollPane scrollPane = new JScrollPane(tabla);
        frameErrores.add(scrollPane);
        frameErrores.setLocationRelativeTo(this);
        frameErrores.setVisible(true);
    }//GEN-LAST:event_OpcionErroresActionPerformed
    
    // TABLA DE TOKENS
    private void OpcionTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionTokensActionPerformed
        // CREAR VENTANA
        JFrame frameTokens = new JFrame("Tabla de Tokens - ELI NOSQL");
        frameTokens.setSize(800, 600);
        
        // Si hay codigo en el editor, analizarlo y mostrar tokens
        String codigo = txtEditor.getText();
        if (codigo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay codigo para analizar");
            return;
        }
        
        try {
            java.io.Reader reader = new java.io.StringReader(codigo);
            eli.compiler.Lexer lexer = new eli.compiler.Lexer(reader);
            
            java.util.ArrayList<String[]> listaTokens = new java.util.ArrayList<>();
            java_cup.runtime.Symbol token;
            int contador = 1;
            
            // Encabezados
            listaTokens.add(new String[]{"#", "Lexema", "Tipo", "Linea", "Columna"});
            
            while ((token = lexer.next_token()).sym != eli.compiler.sym.EOF) {
                String nombreToken = eli.compiler.sym.terminalNames[token.sym];
                
                // DETERMINAR EL LEXEMA
                String lexema = "";
                
                // Token con valor
                if (token.value != null) {
                    lexema = token.value.toString();
                } 
                // Token sin valor
                else {
                    switch (nombreToken) {
                        // Palabras reservadas
                        case "DATABASE": lexema = "database"; break;
                        case "TABLE": lexema = "table"; break;
                        case "READ": lexema = "read"; break;
                        case "ADD": lexema = "add"; break;
                        case "UPDATE": lexema = "update"; break;
                        case "EXPORT": lexema = "export"; break;
                        case "USE": lexema = "use"; break;
                        case "CLEAR": lexema = "clear"; break;
                        case "FIELDS": lexema = "fields"; break;
                        case "FILTER": lexema = "filter"; break;
                        case "SET": lexema = "set"; break;
                        case "STORE": lexema = "store"; break;
                        case "AT": lexema = "at"; break;
                    
                        // Tipos de datos
                        case "INT": lexema = "int"; break;
                        case "FLOAT": lexema = "float"; break;
                        case "STRING": lexema = "string"; break;
                        case "BOOL": lexema = "bool"; break;
                        case "ARRAY": lexema = "array"; break;
                        case "OBJECT": lexema = "object"; break;
                        case "NULL": lexema = "null"; break;
                        
                        // Operadores relacionales
                        case "EQ": lexema = "=="; break;
                        case "NEQ": lexema = "!="; break;
                        case "GT": lexema = ">"; break;
                        case "LT": lexema = "<"; break;
                        case "GTE": lexema = ">="; break;
                        case "LTE": lexema = "<="; break;
                        
                        // Operadores logicos
                        case "AND": lexema = "&&"; break;
                        case "OR": lexema = "||"; break;
                        case "NOT": lexema = "!"; break;
                        
                        // Signos
                        case "LBRACE": lexema = "{"; break;
                        case "RBRACE": lexema = "}"; break;
                        case "LPAREN": lexema = "("; break;
                        case "RPAREN": lexema = ")"; break;
                        case "LBRACKET": lexema = "["; break;
                        case "RBRACKET": lexema = "]"; break;
                        case "SEMICOLON": lexema = ";"; break;
                        case "COLON": lexema = ":"; break;
                        case "COMMA": lexema = ","; break;
                        case "DOT": lexema = "."; break;
                        case "ASSIGN": lexema = "="; break;
                        case "STAR": lexema = "*"; break;
                        
                        // Identificadores
                        case "IDENTIFICADOR": lexema = "ID"; break;
                        
                        default: lexema = nombreToken.toLowerCase(); break;
                    }
                }
                
                // DETERMINAR EL TIPO
                String tipoToken = "";
                switch (nombreToken) {
                    case "DATABASE": tipoToken = "DATABASE"; break;
                    case "TABLE": tipoToken = "TABLE"; break;
                    case "READ": tipoToken = "READ"; break;
                    case "ADD": tipoToken = "ADD"; break;
                    case "UPDATE": tipoToken = "UPDATE"; break;
                    case "EXPORT": tipoToken = "EXPORT"; break;
                    case "USE": tipoToken = "USE"; break;
                    case "CLEAR": tipoToken = "CLEAR"; break;
                    case "FIELDS": tipoToken = "FIELDS"; break;
                    case "FILTER": tipoToken = "FILTER"; break;
                    case "SET": tipoToken = "SET"; break;
                    case "STORE": tipoToken = "STORE"; break;
                    case "AT": tipoToken = "AT"; break;
                    case "INT": tipoToken = "INT"; break;
                    case "FLOAT": tipoToken = "FLOAT"; break;
                    case "STRING": tipoToken = "STRING"; break;
                    case "BOOL": tipoToken = "BOOL"; break;
                    case "ARRAY": tipoToken = "ARRAY"; break;
                    case "OBJECT": tipoToken = "OBJECT"; break;
                    case "NULL": tipoToken = "NULL"; break;
                    case "IDENTIFICADOR": tipoToken = "ID"; break;
                    case "ENTERO": tipoToken = "INT"; break;
                    case "DECIMAL": tipoToken = "FLOAT"; break;
                    case "STRING_LITERAL": tipoToken = "STRING"; break;
                    case "BOOLEAN": tipoToken = "BOOL"; break;
                    case "EQ": tipoToken = "IGUAL"; break;
                    case "NEQ": tipoToken = "DIFERENTE"; break;
                    case "GT": tipoToken = "MAYOR"; break;
                    case "LT": tipoToken = "MENOR"; break;
                    case "GTE": tipoToken = "MAYORIGUAL"; break;
                    case "LTE": tipoToken = "MENORIGUAL"; break;
                    case "AND": tipoToken = "AND"; break;
                    case "OR": tipoToken = "OR"; break;
                    case "NOT": tipoToken = "NOT"; break;
                    case "LBRACE": tipoToken = "LLAVEIZQ"; break;
                    case "RBRACE": tipoToken = "LLAVEDER"; break;
                    case "LPAREN": tipoToken = "PARENIZQ"; break;
                    case "RPAREN": tipoToken = "PARENDER"; break;
                    case "LBRACKET": tipoToken = "CORCHETEIZQ"; break;
                    case "RBRACKET": tipoToken = "CORCHETEDER"; break;
                    case "SEMICOLON": tipoToken = "PTCOMA"; break;
                    case "COLON": tipoToken = "DOSPUNTOS"; break;
                    case "COMMA": tipoToken = "COMA"; break;
                    case "DOT": tipoToken = "PUNTO"; break;
                    case "ASSIGN": tipoToken = "ASIGNACION"; break;
                    case "STAR": tipoToken = "ASTERISCO"; break;
                    default: tipoToken = nombreToken; break;
                }
                
                String linea = String.valueOf(token.left);
                String columna = String.valueOf(token.right);
                
                listaTokens.add(new String[]{
                    String.valueOf(contador++),
                    lexema,
                    tipoToken,
                    linea,
                    columna
                });
            }
            
            // CONVERTIR A MATRIZ
            String[][] datos = listaTokens.toArray(new String[0][0]);
            String[] columnas = datos[0];
            String[][] datosReales = java.util.Arrays.copyOfRange(datos, 1, datos.length);
            
            JTable tabla = new JTable(datosReales, columnas);
            
            // CENTRAR TEXTO
            tabla.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {{
                setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14)); // Tamaño de letra
            }});
            
            // COLORES DE LA TABLA
            tabla.setRowHeight(25); 
            tabla.setGridColor(new java.awt.Color(200, 200, 200)); // Color de cuadricula
            tabla.setShowGrid(true);
            
            // AJUSTAR ANCHO DE COLUMNAS
            tabla.getColumnModel().getColumn(0).setPreferredWidth(60);  // #
            tabla.getColumnModel().getColumn(1).setPreferredWidth(60);  // Lexema
            tabla.getColumnModel().getColumn(2).setPreferredWidth(60);  // Tipo
            tabla.getColumnModel().getColumn(3).setPreferredWidth(60);  // Linea
            tabla.getColumnModel().getColumn(4).setPreferredWidth(60);  // Columna
            
            // COLORES EN FILAS
            tabla.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
                @Override
                public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                    java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    
                    // Colores alternados para las filas
                    if (!isSelected) {
                        if (row % 2 == 0) {
                            c.setBackground(new java.awt.Color(240, 248, 255)); // Azul claro
                        } else {
                            c.setBackground(java.awt.Color.WHITE);
                        }
                    }
                    
                    // Centrar texto
                    ((javax.swing.table.DefaultTableCellRenderer) c).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14));
                    
                    return c;
                }
            });
            
            JScrollPane scrollPane = new JScrollPane(tabla);
            frameTokens.add(scrollPane);
            frameTokens.setLocationRelativeTo(this);
            frameTokens.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al analizar: " + e.getMessage());
        }
    }//GEN-LAST:event_OpcionTokensActionPerformed

    // ACERCA DE
    private void OpcionAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionAcercaDeActionPerformed
        // Crear un panel con informacion
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Titulo
        JLabel titulo = new JLabel("ELI NOSQL");
        titulo.setFont(new java.awt.Font("Bauhaus 93", java.awt.Font.PLAIN, 36));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(titulo);
        
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio
        
        // Descripcion del proyecto
        JLabel descripcion = new JLabel("<html><center>Interprete para el lenguaje ELI<br>Educational Language Implementation - NoSQL</center></html>");
        descripcion.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        descripcion.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(descripcion);
        
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // Mis datos
        JLabel nombreLabel = new JLabel("Nombre: Emily Maritza Tepeu Guacamaya");
        nombreLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        nombreLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(nombreLabel);
        
        JLabel carnetLabel = new JLabel("Carnet: 202402955");
        carnetLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        carnetLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(carnetLabel);
        
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JLabel version = new JLabel("Proyecto 1");
        version.setFont(new java.awt.Font("Arial", java.awt.Font.ITALIC, 12));
        version.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(version);
        
        // Mostrar en un cuadro de dialogo
        JOptionPane.showMessageDialog(this, panel, "Acerca de ELI NOSQL", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_OpcionAcercaDeActionPerformed
    
    // PROCESAMIENTO DE INSTRUCCIONES
    
    // PROESAR INSTRUCCIONES DE TABLE Y ADD: extrae tablas del codigo y los sguarda en el gestor
    private void procesarInstrucciones(String codigo, eli.compiler.GestorJSON gestor) {
        // BUSCAR TABLAS
        java.util.regex.Pattern pTable = java.util.regex.Pattern.compile("table\\s+(\\w+)\\s*\\{([^}]+)\\}");
        java.util.regex.Matcher mTable = pTable.matcher(codigo);
    
        while (mTable.find()) {
            String nombreTabla = mTable.group(1);
            String camposStr = mTable.group(2);
        
            Map<String, String> esquema = new HashMap<>();
            String[] lineas = camposStr.split(";");
            for (String linea : lineas) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
            
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    String campo = partes[0].trim();
                    String tipo = partes[1].trim();
                    esquema.put(campo, tipo);
                }
            }
        
            gestor.agregarTabla(nombreTabla, esquema);
            txtConsola.append("Tabla creada: " + nombreTabla + "\n");
        }
    
        // Buscar incersiones (ADD)
        java.util.regex.Pattern pAdd = java.util.regex.Pattern.compile("add\\s+(\\w+)\\s*\\{([^}]+)\\}");
        java.util.regex.Matcher mAdd = pAdd.matcher(codigo);
    
        while (mAdd.find()) {
            String nombreTabla = mAdd.group(1);
            String valoresStr = mAdd.group(2);
        
            Map<String, Object> registro = new HashMap<>();
            String[] campos = valoresStr.split(",");
            for (String campo : campos) {
                campo = campo.trim();
                String[] partes = campo.split(":");
                if (partes.length == 2) {
                    String nombreCampo = partes[0].trim();
                    String valorStr = partes[1].trim();
                
                    // Detectar tipo de valor
                    if (valorStr.startsWith("\"")) {
                        registro.put(nombreCampo, valorStr.replace("\"", ""));
                    } else if (valorStr.equals("true") || valorStr.equals("false")) {
                        registro.put(nombreCampo, Boolean.parseBoolean(valorStr));
                    } else if (valorStr.matches("\\d+")) {
                        registro.put(nombreCampo, Integer.parseInt(valorStr));
                    } else if (valorStr.matches("\\d+\\.\\d+")) {
                        registro.put(nombreCampo, Double.parseDouble(valorStr));
                    } else {
                        registro.put(nombreCampo, valorStr);
                    }
                }
            }
        
            gestor.agregarRegistro(nombreTabla, registro);
            txtConsola.append("Registro agregado a: " + nombreTabla + "\n");
        }
    }
    
    // PROCESAR INSTRUCCIONES READ: ejecuta consultas con filtros y muestra resultaos en el output
    private void procesarRead(String codigo, eli.compiler.GestorJSON gestor) {
        java.util.regex.Pattern pRead = java.util.regex.Pattern.compile(
            "read\\s+(\\w+)\\s*\\{\\s*fields:\\s*([^;]+);\\s*(?:filter:\\s*(.+?)\\s*;)?\\s*\\}"
        );
        java.util.regex.Matcher mRead = pRead.matcher(codigo);
        
        while (mRead.find()) {
            String nombreTabla = mRead.group(1);
            String camposStr = mRead.group(2).trim();
            String filterStr = mRead.group(3);
            
            // Determinar campos a mostrar
            String[] camposMostrar;
            if (camposStr.equals("*")) {
                Map<String, String> schema = gestor.getSchema(nombreTabla);
                if (schema == null) {
                    txtOutput.append("Error: Tabla '" + nombreTabla + "' no existe\n");
                    continue;
                }
                camposMostrar = schema.keySet().toArray(new String[0]);
            } else {
                camposMostrar = camposStr.split("\\s*,\\s*");
            }
        
            // Procesar filtro si existe
            List<Map<String, Object>> resultados;
            if (filterStr != null && !filterStr.isEmpty()) {
                // Parsear filter
                String[] filterParts = filterStr.trim().split("\\s+");
                if (filterParts.length == 3) {
                    String campo = filterParts[0];
                    String operador = filterParts[1];
                    String valorStr = filterParts[2];
                
                    // Convertir valor segun el tipo
                    Object valor;
                    if (valorStr.startsWith("\"")) {
                        valor = valorStr.replace("\"", "");
                    } else if (valorStr.equals("true") || valorStr.equals("false")) {
                        valor = Boolean.parseBoolean(valorStr);
                    } else if (valorStr.matches("\\d+")) {
                        valor = Integer.parseInt(valorStr);
                    } else if (valorStr.matches("\\d+\\.\\d+")) {
                        valor = Double.parseDouble(valorStr);
                    } else {
                        valor = valorStr;
                    }
                
                    resultados = gestor.consultar(nombreTabla, campo, operador, valor);
                } else {
                    resultados = gestor.consultar(nombreTabla, null, null, null);
                }
            } else {
                resultados = gestor.consultar(nombreTabla, null, null, null);
            }
            
            // Guardar resultados para el EXPORT
            ultimosResultados = resultados;
            ultimosCampos = camposMostrar;
            ultimaTabla = nombreTabla;
        
            // Mostrar resultados en OUTPUT
            txtOutput.append("\nRESULTADOS DE READ: " + nombreTabla + "\n");
            txtOutput.append("====================================\n");
            
            // Mostrar encabezados
            for (String campo : camposMostrar) {
                txtOutput.append(String.format("%-15s", campo));
            }
            txtOutput.append("\n");
            txtOutput.append("------------------------------------\n");
            
            // Mostrar registros
            if (resultados.isEmpty()) {
                txtOutput.append("   No se encontraron registros\n");
            } else {
                for (Map<String, Object> record : resultados) {
                    for (String campo : camposMostrar) {
                        Object valor = record.get(campo);
                        txtOutput.append(String.format("%-15s", valor != null ? valor.toString() : "null"));
                    }
                    txtOutput.append("\n");
                }
            }
            txtOutput.append("========================================\n");
            txtOutput.append("Total: " + resultados.size() + " registros\n\n");
        }
    }
    
    // PROCESAR INSTRUCCIONES UPDATE: modifica registros que cumplan con el filtro
    private void procesarUpdate(String codigo, eli.compiler.GestorJSON gestor) {
        java.util.regex.Pattern pUpdate = java.util.regex.Pattern.compile(
            "update\\s+(\\w+)\\s*\\{\\s*set:\\s*([^;]+);\\s*(?:filter:\\s*(.+?)\\s*;)?\\s*\\}"
        );
        java.util.regex.Matcher mUpdate = pUpdate.matcher(codigo);
        
        while (mUpdate.find()) {
            String nombreTabla = mUpdate.group(1);
            String setStr = mUpdate.group(2).trim();
            String filterStr = mUpdate.group(3);
            
            // Parsear SET (campo = valor)
            Map<String, Object> nuevosValores = new HashMap<>();
            String[] asignaciones = setStr.split(",");
            for (String asig : asignaciones) {
                String[] partes = asig.trim().split("=");
                if (partes.length == 2) {
                    String campo = partes[0].trim();
                    String valorStr = partes[1].trim();
                    
                    // Convertir valor
                    Object valor;
                    if (valorStr.startsWith("\"")) {
                        valor = valorStr.replace("\"", "");
                    } else if (valorStr.equals("true") || valorStr.equals("false")) {
                        valor = Boolean.parseBoolean(valorStr);
                    } else if (valorStr.matches("\\d+")) {
                        valor = Integer.parseInt(valorStr);
                    } else if (valorStr.matches("\\d+\\.\\d+")) {
                        valor = Double.parseDouble(valorStr);
                    } else {
                        valor = valorStr;
                    }
                    nuevosValores.put(campo, valor);
                }
            }
        
            // Procesar filtro si existe
            int actualizados = 0;
            if (filterStr != null && !filterStr.isEmpty()) {
                String[] filterParts = filterStr.trim().split("\\s+");
                if (filterParts.length == 3) {
                    String campo = filterParts[0];
                    String operador = filterParts[1];
                    String valorStr = filterParts[2];
                    
                    Object valor;
                    if (valorStr.startsWith("\"")) {
                        valor = valorStr.replace("\"", "");
                    } else if (valorStr.matches("\\d+")) {
                        valor = Integer.parseInt(valorStr);
                    } else {
                        valor = valorStr;
                    }
                    
                    actualizados = gestor.actualizar(nombreTabla, campo, operador, valor, nuevosValores);
                }
            } else {
                // Sin filtro, actualizar todos
                Map<String, String> schema = gestor.getSchema(nombreTabla);
                if (schema != null) {
                    List<Map<String, Object>> todos = gestor.consultar(nombreTabla, null, null, null);
                    for (Map<String, Object> reg : todos) {
                        for (Map.Entry<String, Object> entry : nuevosValores.entrySet()) {
                            reg.put(entry.getKey(), entry.getValue());
                        }
                    }
                    actualizados = todos.size();
                    gestor.guardar();
                }
            }
            
            txtConsola.append("UPDATE en " + nombreTabla + ": " + actualizados + " registros actualizados\n");
        }
    }

    // PROCESAR INSTRUCCIONES EXPORT: guarda los resultados del ultimo READ en un JSON
    private void procesarExport(String codigo) {
        java.util.regex.Pattern pExport = java.util.regex.Pattern.compile("export\\s+\"([^\"]+)\"\\s*;");
        java.util.regex.Matcher mExport = pExport.matcher(codigo);
    
        while (mExport.find()) {
            String nombreArchivo = mExport.group(1);
            
            if (ultimosResultados != null && !ultimosResultados.isEmpty()) {
                // gestor para exportar
                eli.compiler.GestorJSON gestorTemp = new eli.compiler.GestorJSON(nombreArchivo);
                gestorTemp.exportarResultados(nombreArchivo, ultimosResultados, ultimosCampos, ultimaTabla);
                txtConsola.append("Resultados exportados a: " + nombreArchivo + "\n");
                txtOutput.append("Resultados exportados a " + nombreArchivo + "\n");
            } else {
                txtConsola.append("No hay resultados de READ para exportar\n");
            }
        }
    }
    
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
