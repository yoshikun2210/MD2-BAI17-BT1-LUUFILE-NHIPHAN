package Config;

import model.Product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config {

    public static Scanner scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public List<Product> readFile(String pathFile){
        List<Product> tList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tList = (List<Product>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();

        }catch (Exception e){
            e.getMessage();
        }
        return  tList;
    }

    public void writeFile(String pathFile, List<Product> tList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}