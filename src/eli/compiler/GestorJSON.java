package eli.compiler;

import java.io.*;
import java.util.*;

public class GestorJSON {
    
    private String rutaArchivo;
    private Map<String, Object> baseDatos;
    
    public GestorJSON(String ruta) {
        this.rutaArchivo = ruta;
        this.baseDatos = new HashMap<>();
        cargar(); // Para cargar datos existentes si hay
    }
    
    // GUARDAR LA BASE DE DATOS EN UN ARCHIVO JSON
    public void guardar() {
        try {
            // Escribir archivo
            FileWriter writer = new FileWriter(rutaArchivo);
            writer.write(convertirAJSON());
            writer.close();
            System.out.println("Base de datos guardada en: " + rutaArchivo);
        } catch (Exception e) {
            System.out.println("Error al guardar JSON: " + e.getMessage());
        }
    }
    
    // Cargar la base de datos desde un archivo JSON
    public void cargar() {
        try {
            FileReader reader = new FileReader(rutaArchivo);
            Scanner scanner = new Scanner(reader);
            StringBuilder contenido = new StringBuilder();
            while (scanner.hasNextLine()) {
                contenido.append(scanner.nextLine());
            }
            scanner.close();
            reader.close();
            
            // falta que el parser funcioneeeeee
            if (contenido.toString().contains("database")) {
                System.out.println("Base de datos cargada desde: " + rutaArchivo);
            }         
        } catch (Exception e) {
            // El archivo no existe y se empieza vacio
            System.out.println("Creando nueva base de datos en: " + rutaArchivo);
        }
    }
    
    // CONVERTIR A JSON
    private String convertirAJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"database\": \"").append(baseDatos.getOrDefault("nombre", "unknown")).append("\",\n");
        sb.append("  \"tables\": {\n");
        
        Map<String, Map<String, Object>> tablas = (Map<String, Map<String, Object>>) baseDatos.get("tablas");
        if (tablas != null) {
            int tablaCount = 0;
            for (Map.Entry<String, Map<String, Object>> entry : tablas.entrySet()) {
                tablaCount++;
                sb.append("    \"").append(entry.getKey()).append("\": {\n");
                
                Map<String, Object> tabla = entry.getValue();
                
                // SCHEMA
                sb.append("      \"schema\": {\n");
                Map<String, String> schema = (Map<String, String>) tabla.get("schema");
                int fieldCount = 0;
                for (Map.Entry<String, String> field : schema.entrySet()) {
                    fieldCount++;
                    sb.append("        \"").append(field.getKey()).append("\": \"").append(field.getValue()).append("\"");
                    if (fieldCount < schema.size()) sb.append(",");
                    sb.append("\n");
                }
                sb.append("      },\n");
                
                // RECORDS
                sb.append("      \"records\": [\n");
                List<Map<String, Object>> records = (List<Map<String, Object>>) tabla.get("records");
                if (records != null) {
                    int recordCount = 0;
                    for (Map<String, Object> record : records) {
                        recordCount++;
                        sb.append("        {\n");
                        int valueCount = 0;
                        for (Map.Entry<String, Object> field : record.entrySet()) {
                            valueCount++;
                            sb.append("          \"").append(field.getKey()).append("\": ");
                            if (field.getValue() instanceof String) {
                                sb.append("\"").append(field.getValue()).append("\"");
                            } else {
                                sb.append(field.getValue());
                            }
                            if (valueCount < record.size()) sb.append(",");
                            sb.append("\n");
                        }
                        sb.append("        }");
                        if (recordCount < records.size()) sb.append(",");
                        sb.append("\n");
                    }
                }
                sb.append("      ]\n");
                sb.append("    }");
                if (tablaCount < tablas.size()) sb.append(",");
                sb.append("\n");
            }
        } else {
            sb.append("    {}\n");
        }
        
        sb.append("  }\n");
        sb.append("}\n");
        return sb.toString();
    }
    
    // GETTERS Y SETTERS
    public void setNombreBase(String nombre) {
        baseDatos.put("nombre", nombre);
    }
    
    public void agregarTabla(String nombre, Map<String, String> esquema) {
        Map<String, Map<String, Object>> tablas = (Map<String, Map<String, Object>>) baseDatos.get("tablas");
        if (tablas == null) {
            tablas = new HashMap<>();
            baseDatos.put("tablas", tablas);
        }
        
        Map<String, Object> tabla = new HashMap<>();
        tabla.put("schema", esquema);
        tabla.put("records", new ArrayList<>());
        
        tablas.put(nombre, tabla);
        guardar(); // Guardar automaticamente
    }
    
    public void agregarRegistro(String tabla, Map<String, Object> registro) {
        Map<String, Map<String, Object>> tablas = (Map<String, Map<String, Object>>) baseDatos.get("tablas");
        if (tablas != null && tablas.containsKey(tabla)) {
            List<Map<String, Object>> records = (List<Map<String, Object>>) tablas.get(tabla).get("records");
            records.add(registro);
            guardar(); // Guardar automaticamente
        }
    }
    
    // BUSCAR REGISTROS EN TABLA CON FILTRO
    public List<Map<String, Object>> consultar(String nombreTabla, String campoFiltro, String operador, Object valor) {
        List<Map<String, Object>> resultados = new ArrayList<>();
    
        Map<String, Map<String, Object>> tablas = (Map<String, Map<String, Object>>) baseDatos.get("tablas");
        if (tablas != null && tablas.containsKey(nombreTabla)) {
            List<Map<String, Object>> records = (List<Map<String, Object>>) tablas.get(nombreTabla).get("records");
        
            for (Map<String, Object> record : records) {
                if (campoFiltro == null || operador == null || valor == null) {
                    // Sin filtro, agregar todos
                    resultados.add(record);
                    continue;
                }
            
                if (record.containsKey(campoFiltro)) {
                    Object valorCampo = record.get(campoFiltro);
                    boolean cumple = false;
                
                    switch (operador) {
                        case "==":
                            cumple = valorCampo.equals(valor);
                            break;
                        case "!=":
                            cumple = !valorCampo.equals(valor);
                            break;
                        case ">":
                            if (valorCampo instanceof Number && valor instanceof Number) {
                                cumple = ((Number) valorCampo).doubleValue() > ((Number) valor).doubleValue();
                            }
                            break;
                        case "<":
                            if (valorCampo instanceof Number && valor instanceof Number) {
                                cumple = ((Number) valorCampo).doubleValue() < ((Number) valor).doubleValue();
                            }
                            break;
                        case ">=":
                            if (valorCampo instanceof Number && valor instanceof Number) {
                                cumple = ((Number) valorCampo).doubleValue() >= ((Number) valor).doubleValue();
                            }
                            break;
                        case "<=":
                            if (valorCampo instanceof Number && valor instanceof Number) {
                                cumple = ((Number) valorCampo).doubleValue() <= ((Number) valor).doubleValue();
                            }
                            break;
                    }
                    
                    if (cumple) {
                        resultados.add(record);
                    }
                }
            }
        }
        return resultados;
    }

    // OBTENER EL SCHEMA DE UNA TABLA
    public Map<String, String> getSchema(String nombreTabla) {
        Map<String, Map<String, Object>> tablas = (Map<String, Map<String, Object>>) baseDatos.get("tablas");
        if (tablas != null && tablas.containsKey(nombreTabla)) {
            return (Map<String, String>) tablas.get(nombreTabla).get("schema");
        }
        return null;
    }
}