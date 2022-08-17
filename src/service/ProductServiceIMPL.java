package service;

import Config.Config;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService {
    public static String Path_Product = "D:\\MD2\\untitled78\\src\\database\\file.txt";
    public static List<Product> productList = new Config().readFile(Path_Product);


    @Override
    public List<Product> findAll() {
        new Config().writeFile(Path_Product, productList);
        return productList;

    }

    @Override
    public void save(Product product) {
        productList.add(product);

    }

    @Override
    public List<Product> findById(int id) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()){
                products.add(productList.get(i));
            }
        }
        return products;
    }
}