package com.product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * Clase que implementa el modelo category
 * @author Martínez Marcelo Ingrid Aylen
 * @author Ramírez Venegas Alexa Paola
 * @author Perez Evaristo Eris
 */
public class Category {
    private Integer category_id; // ID de la categoría
    private String category_name; // Nombre de la categoria
    private String tag; // Etiqueta de la categoria (Categoria = Receta, Tag= Postres)
    private Integer status; // Estado de la categoría

    /**
     * Método constructor vacio
     */
    public Category() {}

    /**
     * Método constructor con parámetros de una categoría
     * @param id categria ID
     * @param category nombre de la categoría
     * @param tag tag de la categoría
     * @param status estado de la categoría
     */
    public Category (Integer id, String category, String tag, Integer status) {
        this.category_id = id;
        this.category_name = category;
        this.tag = tag;
        this.status = status;
    }

    /**
     * Método para obtener el ID de la categoría
     * @return categoría del ID
     */
    public Integer getCategory_id() {
        return category_id;
    }

    /**
     * Método para obtener el nombre de la categoría
     * @return nombre de la categoría
     */
    public String getCategory_name() {
        return category_name;
    }

    /**
     * Método para obtener el tag de la categoría
     * @return tag de la categoría
     */
    public String getCategory_Tag() {
        return tag;
    }

    /**
     * Método para obtener el estado de la categoría
     * @return estado de la categoría
     */
    public Integer getStatus() {
        return status;
    }

    public void setstatus(Integer nuevoStatus){
        this.status = nuevoStatus;
    }

    @Override
    public String toString() {
        return "Categoria: " + category_name + "\n" + "ID: " + category_id + "\nTag: " + tag + "\nStatus: " + status + "\n";
    }
}

/**
 * Clase que crea un objeto Categorias, donde cada uno de ellos es una categoría
 */
class Categorias {
    List<Category> categories; // Lista donde se alamacenan las categorías

    /**
     * Método constructor por defecto
     */
    public Categorias() {
        categories = new ArrayList<>(); // Lista vacía de categorías
    }

    /**
     * Método que recibe una Categoría y la agrega a la lista
     * @param categoriaAgregar Categoria que se agrega
     */
    public void createCategory(Category categoriaAgregar) {
        categories.add(categoriaAgregar);
    }

    /**
     * Método para eliminar una categoría de las categorías
     * @param category_id ID de la cartegoria a eliminar
     */
    public void deleteCategory(Integer category_id) {
        Category categoriaAEliminar = null;
        // Obtenemos la categoría a eliminar, buscando su ID en la lista
        for (Category cat : categories) {
            if (cat.getCategory_id().equals(category_id)) {
                categoriaAEliminar = cat;
            }
        }
        if (categoriaAEliminar != null) {
            categoriaAEliminar.setstatus(0); // La eliminamos si no es null dado que si existe
            System.out.println("Categoría con ID " + category_id + " eliminada.");
        } else {
            // Cuando la categoría no existe
            System.out.println("Categoría con ID " + category_id + " no encontrada.");
        }
    }

    /**
     * Método que muestra una lista con las categorias registradas
     * @return categroias registradas con status = 1
     */
    public String getCategories() {
        String s = "";
        for (Category c : categories) {
            s += c.toString() + "\n";
        }

        if(s.length() == 0){
            return "No existen categorias registradas";
        }

        return s;
    }

    /**
     * Método para revisar si ya existe una categoría con el nombre pasado como parámetro
     * @param category_name nombre de la nueva categoria
     * @return true si no existe, false si ya existe
     */
    public boolean revisarNombre(String category_name){
        for(Category categ : categories) {
            if (categ.getCategory_name().equals(category_name)){
                return false;
            }
        }
        return true;
    }

    /**
     * Método para revisar si ya existe una categoría con el id pasado como parámetro
     * @param category_id id de la nueva categoria
     * @return true si no existe, false si ya existe
     */
    public boolean revisarID(Integer category_id){
        for(Category categ : categories) {
            if (categ.getCategory_id().equals(category_id)){
                return false;
            }
        }
        return true;
    }

    /**
     * Método para revisar si ya existe una categoría con el tag pasado como parámetro
     * @param category_tag nombre de la nueva categoria
     * @return true si no existe, false si ya existe
     */
    public boolean revisarTag(String category_tag){
        for(Category categ : categories) {
            if (categ.getCategory_Tag().equals(category_tag)){
                return false;
            }
        }
        return true;
    }
}

/**
 * Clase main para mostrar el menú
 */
class Main {
    public static void main(String[] args) {
        Categorias categorias = new Categorias(); // Creamos la lista que contiene las categorias (Objeto de Categorias)
        Category a = new Category(1, "Lentes", "Lts", 1);
        Category b = new Category(2, "Relojes", "Rljs", 1);
        categorias.createCategory(a);

        Categorias vacia = new Categorias();

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú de Categorías ---");
            System.out.println("1. Ver Categorías");
            System.out.println("2. Crear Categoría");
            System.out.println("3. Eliminar Categoría");
            System.out.print("Selecciona una opción: ");
            
            int opcion = -1;
            try {
                opcion = s.nextInt();
                s.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ingresa un númerooo");
                s.nextLine();
                continue;
            }

            if (opcion == 1) {
                System.out.println("\n--- Lista de Categorías ---");
                System.out.println("-- caso: si hay categorias a mostrar --");
                System.out.println(categorias.getCategories());
                System.out.println("-- caso: no hay categorias a mostrar --");
                System.out.println(vacia.getCategories());
            } else if (opcion == 2) {
                System.out.println("\n--- Crear Categoría ---");
                // Name
                System.out.print("⭐️ Nombre de la categoría: ");
                String name = s.nextLine();
                // ID
                Integer id = 0;
                System.out.println("⭐️ Opciones ID:");
                System.out.println("1. Generar ID");
                System.out.println("2. Ingresar un ID");
                int opId = s.nextInt();
                s.nextLine();
                
                if (opId == 1){
                    System.out.println("Generando ID...");
                    Random rn = new Random();
                    id = rn.nextInt(900) + 100;
                    System.out.println("ID asignado: " + id);
                } else if (opId == 2) {
                    System.out.println("Ingrese ID: ");
                    id = s.nextInt();
                    s.nextLine();
                }
                // Tag
                System.out.print("⭐️ Ingrese tag: ");
                String tg = s.nextLine();
                // Status
                int st =1 ;
                // Revisión de existencia
                if (!categorias.revisarNombre(name) || !categorias.revisarID(id) || !categorias.revisarTag(tg)){
                    System.out.println("Ya existe la categoria con alguno de esos parámetros. No se ha podido agregar");
                    continue;
                } else {
                    // Creación
                    Category creacionUser = new Category(id, name, tg, st);
                    categorias.createCategory(creacionUser);
                    System.out.println("\nCategoria creada con éxito:");
                    System.out.println(creacionUser);
                }
            } else if (opcion == 3) {
                System.out.print("\n--- Eliminar Categoría ---\n");
                System.out.print("Ingresar ID a eliminar: ");
                try{
                    Integer idElimina = s.nextInt();
                    s.nextLine();
                    categorias.deleteCategory(idElimina);
                } catch(InputMismatchException e){
                    System.out.println(e);
                } 
            } else {
                System.exit(0);
            }
        }
    }
}