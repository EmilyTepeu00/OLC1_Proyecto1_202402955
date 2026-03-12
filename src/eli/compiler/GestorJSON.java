package eli.compiler;

import java.io.*;
import java.util.*;

// PARA GESTIONAR LA PERSISTENCIA DE LA BASE DE DATOS
public class GestorJSON {
    
    private String rutaArchivo;
    private Map<String, Object> baseDatos;  // Estructura de la BD en memoria
    
    // Constructor: inicializa la ruta y carga datos existentes
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
            
            // Verificar si el archivo tiene estructura de base de datos
            if (contenido.toString().contains("database")) {
                System.out.println("Base de datos cargada desde: " + rutaArchivo);
            }         
        } catch (Exception e) {
            // Si ela rchivo no existe, se creara uno nuevo al guardar
            System.out.println("Creando nueva base de datos en: " + rutaArchivo);
        }
    }
    
    // CONVERTIR LA ESTRUCTURA EN MEMORIA A JSON
    private String convertirAJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"database\": \"").append(baseDatos.getOrDefault("nombre", "unknown")).append("\",\n");
        sb.append("  \"tables\": {\n");
        
        Map<String, Map<String, Object>> tablas = (Map<String, Map<String, Object>>) baseDatos.get("tablas");
        if (tablas != null) {
            int tablaCount = 0;
            // Recorre cada tabla
            for (Map.Entry<String, Map<String, Object>> entry : tablas.entrySet()) {
                tablaCount++;
                sb.append("    \"").append(entry.getKey()).append("\": {\n");
                
                Map<String, Object> tabla = entry.getValue();
                
                // Guardar el esquema (estructura de campos)
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
                
                // Guardar los registros de la tabla
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
                            
                            Object valor = field.getValue();
                            
                            // Para manejar diferentes tipos de datos
                            if (valor == null) {
                                sb.append("null");
                            }
                            else if (valor instanceof String) {
                                sb.append("\"").append(valor).append("\"");
                            }
                            else if (valor instanceof Map) {
                                // Es un objeto anidado (meta, specs, envio, perfil)
                                sb.append("{");
                                Map<String, Object> objeto = (Map<String, Object>) valor;
                                int subCount = 0;
                                for (Map.Entry<String, Object> subField : objeto.entrySet()) {
                                    subCount++;
                                    sb.append("\"").append(subField.getKey()).append("\": ");
                                    if (subField.getValue() instanceof String) {
                                        sb.append("\"").append(subField.getValue()).append("\"");
                                    } else {
                                        sb.append(subField.getValue());
                                    }
                                    if (subCount < objeto.size()) sb.append(", ");
                                }
                                sb.append("}");
                            }
                            else if (valor instanceof List) {
                                // Es un array (preferencias, tags, items, cursos)
                                sb.append("[");
                                List<Object> lista = (List<Object>) valor;
                                for (int i = 0; i < lista.size(); i++) {
                                    if (lista.get(i) instanceof String) {
                                        sb.append("\"").append(lista.get(i)).append("\"");
                                    } else if (lista.get(i) instanceof Map) {
                                        // Array de objetos (como items en ordenes)
                                        Map<String, Object> objArray = (Map<String, Object>) lista.get(i);
                                        sb.append("{");
                                        int subCount = 0;
                                        for (Map.Entry<String, Object> subField : objArray.entrySet()) {
                                            subCount++;
                                            sb.append("\"").append(subField.getKey()).append("\": ");
                                            if (subField.getValue() instanceof String) {
                                                sb.append("\"").append(subField.getValue()).append("\"");
                                            } else {
                                                sb.append(subField.getValue());
                                            }
                                            if (subCount < objArray.size()) sb.append(", ");
                                        }
                                        sb.append("}");
                                    } else {
                                        sb.append(lista.get(i));
                                    }
                                    if (i < lista.size() - 1) sb.append(", ");
                                }
                                sb.append("]");
                            }
                            else {
                                sb.append(valor); // Numeros, booleanos
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
    // NOMBRE DE LA BASE DE DATOS
    public void setNombreBase(String nombre) {
        baseDatos.put("nombre", nombre);
    }
    
    // AGREGAR UNA NUEVA TABLA CON SU ESQUEMA
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
        guardar(); // Guardar automaticamente despues de agregar
    }
    
    // AGREGAR UN NUEVO REGISTRO A UNA TABLA EXISTENTE
    public void agregarRegistro(String tabla, Map<String, Object> registro) {
        Map<String, Map<String, Object>> tablas = (Map<String, Map<String, Object>>) baseDatos.get("tablas");
        if (tablas != null && tablas.containsKey(tabla)) {
            List<Map<String, Object>> records = (List<Map<String, Object>>) tablas.get(tabla).get("records");
            records.add(registro);
            guardar(); // Guardar automaticamente despues de insertar
        }
    }
    
    // BUSCAR REGISTROS EN TABLA CON FILTRO
    public List<Map<String, Object>> consultar(String nombreTabla, String campoFiltro, String operador, Object valor) {
        List<Map<String, Object>> resultados = new ArrayList<>();
    
        Map<String, Map<String, Object>> tablas = (Map<String, Map<String, Object>>) baseDatos.get("tablas");
        if (tablas != null && tablas.containsKey(nombreTabla)) {
            List<Map<String, Object>> records = (List<Map<String, Object>>) tablas.get(nombreTabla).get("records");
        
            for (Map<String, Object> record : records) {
                // Si no hay filtro, agregar todos
                if (campoFiltro == null || operador == null || valor == null) {
                    // Sin filtro, agregar todos
                    resultados.add(record);
                    continue;
                }
            
                if (record.containsKey(campoFiltro)) {
                    Object valorCampo = record.get(campoFiltro);
                    boolean cumple = false;
                
                    // Evaluar segun el operador
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

    // OBTENER EL ESQUEMA DE UNA TABLA
    public Map<String, String> getSchema(String nombreTabla) {
        Map<String, Map<String, Object>> tablas = (Map<String, Map<String, Object>>) baseDatos.get("tablas");
        if (tablas != null && tablas.containsKey(nombreTabla)) {
            return (Map<String, String>) tablas.get(nombreTabla).get("schema");
        }
        return null;
    }
    
    // ACTUALIZAR REGISTROS QUE CUMPLAN CON EL FILTRO
    public int actualizar(String nombreTabla, String campoFiltro, String operador, Object valorFiltro, Map<String, Object> nuevosValores) {
        int contador = 0;
        
        Map<String, Map<String, Object>> tablas = (Map<String, Map<String, Object>>) baseDatos.get("tablas");
        if (tablas != null && tablas.containsKey(nombreTabla)) {
            List<Map<String, Object>> records = (List<Map<String, Object>>) tablas.get(nombreTabla).get("records");
            
            for (Map<String, Object> record : records) {
                if (record.containsKey(campoFiltro)) {
                    Object valorCampo = record.get(campoFiltro);
                    boolean cumple = false;
                    
                    // Evaluar condicion del filtro
                    switch (operador) {
                        case "==": cumple = valorCampo.equals(valorFiltro); break;
                        case "!=": cumple = !valorCampo.equals(valorFiltro); break;
                        case ">": 
                            if (valorCampo instanceof Number && valorFiltro instanceof Number) {
                                cumple = ((Number) valorCampo).doubleValue() > ((Number) valorFiltro).doubleValue();
                            } break;
                        case "<":
                            if (valorCampo instanceof Number && valorFiltro instanceof Number) {
                                cumple = ((Number) valorCampo).doubleValue() < ((Number) valorFiltro).doubleValue();
                            } break;
                    }
                    
                    if (cumple) {
                        // Actualizar campos
                        for (Map.Entry<String, Object> entry : nuevosValores.entrySet()) {
                            record.put(entry.getKey(), entry.getValue());
                        }
                        contador++;
                    }
                }
            }
            guardar(); // Guardar cambios despues de actualizar
        }
        return contador;
    }

    // EXPORTAR RESULTADOS DE UNA CONSULTA A UN JSON
    public void exportarResultados(String nombreArchivo, List<Map<String, Object>> resultados, String[] campos, String nombreTabla) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{\n");
            sb.append("  \"tabla\": \"").append(nombreTabla).append("\",\n");
            sb.append("  \"campos\": [");
            for (int i = 0; i < campos.length; i++) {
                sb.append("\"").append(campos[i]).append("\"");
                if (i < campos.length - 1) sb.append(", ");
            }
            sb.append("],\n");
            sb.append("  \"registros\": [\n");
            
            // Para escribir cada registro
            for (int i = 0; i < resultados.size(); i++) {
                Map<String, Object> reg = resultados.get(i);
                sb.append("    {");
                int j = 0;
                for (String campo : campos) {
                    sb.append("\"").append(campo).append("\": ");
                    Object valor = reg.get(campo);
                    if (valor instanceof String) {
                        sb.append("\"").append(valor).append("\"");
                    } else {
                        sb.append(valor);
                    }
                    if (j < campos.length - 1) sb.append(", ");
                    j++;
                }
                sb.append("}");
                if (i < resultados.size() - 1) sb.append(",");
                sb.append("\n");
            }
            
            sb.append("  ]\n");
            sb.append("}\n");
            
            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write(sb.toString());
            writer.close();
            
            System.out.println("Resultados exportados a: " + nombreArchivo);
            
        } catch (Exception e) {
            System.err.println("Error al exportar: " + e.getMessage());
        }
    }
}