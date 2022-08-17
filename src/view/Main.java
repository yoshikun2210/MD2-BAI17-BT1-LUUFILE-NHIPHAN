package view;

import Config.Config;
import controller.ProductController;
import model.Product;

import java.util.List;


public class Main {
    ProductController productController = new ProductController();
    List<Product> products = productController.showListProduct();
    Main() {
        System.out.println("======Product Manager=======");
        System.out.println("1: Creat Product");
        System.out.println("2: Show List Product");
        System.out.println("3: Search Product");
        System.out.println("0: Exit");
        int choice = Config.scanner().nextInt();
        switch (choice) {
            case 1:
                creatProduct();
                break;
            case 2:
                showListProduct();
                break;
            case 3:
                searchProduct();
                break;


        }
    }

    public void creatProduct() {
        System.out.println("Creat Product");
        while (true) {
            int id;
            if (products.size() == 0) {
                id = 1;
            } else {
                id = products.get(products.size() - 1).getId() + 1;
            }
            System.out.println("Enter name product");
            String name = Config.scanner().nextLine();
            System.out.println("Enter manufacturer product");
            String manufacturer = Config.scanner().nextLine();
            System.out.println("Enter price product");
            int price = Config.scanner().nextInt();
            System.out.println("Enter describe");
            String describe = Config.scanner().nextLine();
            Product product = new Product(id, name, manufacturer, price, describe);
            productController.creatProduct(product);
            System.out.println("Creat success!");
            productController.showListProduct();
            System.out.println("Nhập vào phím bất kì để tiếp tục - Nhập vào Quit để thoát: ");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
                break;
            }

        }
    }
    public void showListProduct(){
        System.out.println("-----Stt-----Name-----Manufacturer-----Price-----Describe-----");
        for (int i = 0; i < products.size(); i++) {
            System.out.println("-----" + products.get(i).getId()+ "-----" + products.get(i).getName()+ "-----" + products.get(i).getManufacturer() + "-----" + products.get(i).getPrice() + "-----" + products.get(i).getDescribe() + "-----");
            productController.showListProduct();
        }
        System.out.println("Nhập vào Quit để thoát: ");
        String backMenu = Config.scanner().nextLine();
        if(backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }
    public void searchProduct() {
        System.out.println("Enter ID Product");
        int id = Config.scanner().nextInt();
        List<Product> products =productController.searchProduct(id);
        if (productController.searchProduct(id) == null) {
            System.out.println("ID does not exist");
        } else {
            System.out.println("-----Stt-----Name-----Manufacturer-----Price-----Describe-----");
            for (int i = 0; i < products.size(); i++) {
                System.out.println("-----" + products.get(i).getId() + "-----" +products.get(i).getName() + "-----" + products.get(i).getManufacturer() + "-----" + products.get(i).getPrice() + "-----" + products.get(i).getDescribe() + "-----");
                productController.showListProduct();
            }
            System.out.println("Nhập vào Quit để thoát: ");
            String backMenu = Config.scanner().nextLine();
            if(backMenu.equalsIgnoreCase("quit")){
                new Main();
            }
        }
    }


    public static void main(String[] args) {
        new Main();
    }
}