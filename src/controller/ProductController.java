package controller;

import model.Product;
import service.IProductService;
import service.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    IProductService productService = new ProductServiceIMPL();
    public List<Product> showListProduct(){
        return productService.findAll();
    }
    public void creatProduct (Product product){
        productService.save(product);
    }
    public List<Product> searchProduct(int id){
        return productService.findById(id);
    }
}