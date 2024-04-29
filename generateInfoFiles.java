package escenario_java_politecnico_grancolombiano;
import java.io.*;
import java.util.Random;
public class GenerateInfoFiles1 {

	public static void main(String[] args) {
        int salesmanCount = 20; // Number of sellers to generate
        int productsCount = 30; // Number of products to generate
        int salesCountPerSalesman = 30; // Number of sales per seller

        createSalesManInfoFile(salesmanCount);
        createProductsFile(productsCount);
        createSalesFiles(salesmanCount, salesCountPerSalesman);
        
        System.out.println("Archivos generados exitosamente.");
    }	

    public static void createSalesManInfoFile(int salesmanCount) {
        // Seller Database
        String filename = "data vendedores.txt";
       
        
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int i = 1; i < salesmanCount; i++) {
                String salesManLine = "TDCC;" + (i + 1) + ";NombresVendedor" + (i + 1) + ";ApellidosVendedor" + (i + 1) + ";";
                writer.println(salesManLine);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al crear el archivo de información de vendedores.");
            e.printStackTrace();
        }
    }

    public static void createProductsFile(int productsCount) {
        // 	Create a file with pseudo-random product information
        String filename = "data productos.txt";
        
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int i = 0; i < productsCount; i++) {
            	 String productLine = "IDProducto" + (i + 1) + ";NombreProducto" + (i + 1) + ";" + ((i + 1) * 1575) + ";";
                writer.println(productLine);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al crear el archivo de información de productos.");
            e.printStackTrace();
        }
    }

    public static void createSalesFiles(int salesmanCount, int salesCountPerSalesman) {
        // Create pseudo-random sales files for each salesperson
        for (int i = 0; i < salesmanCount; i++) {
            String filename = "sales/" + (i + 1) + ".txt";
            Random random = new Random();
            try (PrintWriter writer = new PrintWriter(filename)) {
                for (int j = 0; j < salesCountPerSalesman; j++) {
                	int randomNumber = random.nextInt(100) + 1;
                    String saleLine = "TDCC;" + (i + 1) + ";IDProducto" + ((j % 20) + 1) + ";" +  randomNumber + ";";
                    writer.println(saleLine);
                }
            } catch (FileNotFoundException e) {
                System.err.println("Error al crear el archivo de ventas para el vendedor " + (i + 1));
                e.printStackTrace();
            }
        }
    }
}
