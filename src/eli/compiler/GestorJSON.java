package eli.compiler;

import java.io.*;
import java.util.*;

public class GestorJSON {
    
    private String rutaArchivo;
    private Map<String, Object> baseDatos;
    
    public GestorJSON(String ruta) {
        this.rutaArchivo = ruta;
        this.baseDatos = new HashMap<>();
    }
    
    // GUARDAR LA BASE DE DATOS EN UN ARCHIVO JSON
    public void guardar() {
        try {
            // Crear el objeto JSON
            Map<String, Object> json = new HashMap<>();
            json.put("database", baseDatos.get("nombre"));
            json.put("tables", baseDatos.get("tablas"));
            
            // Convertir a string JSON
            String jsonString = convertirAJSON(json);
            
            // Escribir archivo
            FileWriter writer = new FileWriter(rutaArchivo);
            writer.write(jsonString);
            writer.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Cargar la base de datos desde un archivo JSON
    public void cargar() {
        try {
            FileReader reader = new FileReader(rutaArchivo);
            // faltaaaaaaaa parseaaaaaaaaar el json
            reader.close();
        } catch (Exception e) {
            // el archivo aun no existe
        }
    }
    
    // CONVERTIR A JSON
    private String convertirAJSON(Map<String, Object> mapa) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        
        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
            sb.append("  \"").append(entry.getKey()).append("\": ");
            if (entry.getValue() instanceof Map) {
                sb.append(convertirAJSON((Map)entry.getValue()));
            } else if (entry.getValue() instanceof String) {
                sb.append("\"").append(entry.getValue()).append("\"");
            } else {
                sb.append(entry.getValue());
            }
            sb.append(",\n");
        }
        
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2); // Quitar la ultima coma
        }
        sb.append("\n}");
        return sb.toString();
    }
    
    // GETTERS Y SETTERS
    public void setNombreBase(String nombre) {
        baseDatos.put("nombre", nombre);
    }
    
    public void agregarTabla(String nombre, Map<String, String> esquema) {
        Map<String, Object> tablas = (Map<String, Object>) baseDatos.get("tablas");
        if (tablas == null) {
            tablas = new HashMap<>();
            baseDatos.put("tablas", tablas);
        }
        
        Map<String, Object> tabla = new HashMap<>();
        tabla.put("schema", esquema);
        tabla.put("records", new ArrayList<>());
        
        tablas.put(nombre, tabla);
    }
}