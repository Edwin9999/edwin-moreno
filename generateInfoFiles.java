import java.io.*;

public class GenerateInfoFiles {
    public static void main(String[] args) {
        int salesmanCount = 20; // Número de vendedores para generar
        int productsCount = 30; // Número de productos para generar
        int salesCountPerSalesman = 30; // Número de ventas por vendedor

        createSalesManInfoFile(salesmanCount);
        createProductsFile(productsCount);
        createSalesFiles(salesmanCount, salesCountPerSalesman);
        
        System.out.println("Archivos generados exitosamente.");
    }	

    public static void createSalesManInfoFile(int salesmanCount) {
        // Creo un archivo con información de vendedores
        String filename = "sales_info.txt";

        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int i = 0; i < salesmanCount; i++) {
                String salesManLine = "TipoDocumento;" + (i + 1) + ";NombresVendedor" + (i + 1) + ";ApellidosVendedor" + (i + 1) + ";";
                writer.println(salesManLine);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al crear el archivo de información de vendedores.");
            e.printStackTrace();
        }
    }

    public static void createProductsFile(int productsCount) {
        // Creo un archivo con información pseudoaleatoria de productos
        String filename = "products.txt";

        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int i = 0; i < productsCount; i++) {
                String productLine = "IDProducto" + (i + 1) + ";NombreProducto" + (i + 1) + ";" + ((i + 1) * 10) + ";";
                writer.println(productLine);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al crear el archivo de información de productos.");
            e.printStackTrace();
        }
    }

    public static void createSalesFiles(int salesmanCount, int salesCountPerSalesman) {
        // Creo archivos pseudoaleatorios de ventas para cada vendedor
        for (int i = 0; i < salesmanCount; i++) {
            String filename = "sales/vendedor_" + (i + 1) + ".txt";
            try (PrintWriter writer = new PrintWriter(filename)) {
                for (int j = 0; j < salesCountPerSalesman; j++) {
                    String saleLine = "TipoDocumentoVendedor;" + (i + 1) + ";IDProducto" + ((j % 20) + 1) + ";" + ((j % 5) + 1) + ";";
                    writer.println(saleLine);
                }
            } catch (FileNotFoundException e) {
                System.err.println("Error al crear el archivo de ventas para el vendedor " + (i + 1));
                e.printStackTrace();
            }
        }
    }
}
