package BlogDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ArticleData {

    
    // public void makeNewArticle(ArrayList<Article> articles) {
    public void makeNewArticle() {

        File file = new File("article");
        ArrayList<Article> temp = null;
        
        if(file.exists()){
            temp = readFromDiskArticle();
        }else {
            temp = new ArrayList<>();
        }
        
        String title = "", author = "", contents = "";
        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj tytul: ");
        title = scan.nextLine();
        System.out.println("Podaj autora: ");
        author = scan.nextLine();
        System.out.println("Podaj zawartosc: ");
        contents = scan.nextLine();

        temp.add(new Article( // tworzymy obiekt bezposniednia bez
                                  // przypisaywania go do zmiennej
                title, author, contents));

        saveOnDiskArticle(temp);
    }

    // public void readAllArticle(ArrayList<Article> articles){
    public void readAllArticle() {

        ArrayList<Article> temp = readFromDiskArticle();

        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i)); // syso wywoluje wewnetrzne
                                             // toString
        }
    }

    private static void saveOnDiskArticle(ArrayList<Article> articles) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("article"));
            oos.writeObject(articles);
            oos.close();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Article> readFromDiskArticle() {

        ArrayList<Article> articlesss = null;
        
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(("article")));
            articlesss = (ArrayList<Article>) ois.readObject();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return articlesss;
    }

}
