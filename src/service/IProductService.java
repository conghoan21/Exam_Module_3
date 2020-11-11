package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    boolean addNewProduct(String productName, int price, String color, String description, int categoryID, int amount);

    List<Product> getAllProduct();

    boolean editProduct(Product newProduct);

    boolean deleteProduct(int productID);

    Product getProductByID(int productID);
}
