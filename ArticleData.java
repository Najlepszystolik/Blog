package BlogDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ArticleData {

    public void makeNewArticle(ArrayList<Article> articles){
        
        String title = "", author = "", contents = "";
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Podaj tytul: ");
        title = scan.nextLine();
        System.out.println("Podaj autora: ");
        author = scan.nextLine();
        System.out.println("Podaj zawartosc: ");
        contents = scan.nextLine();
        
        articles.add(
                new Article( //tworzymy obiekt bezposniednia bez przypisaywania go do zmiennej
                        title, author, contents
                        )
          );
        
        saveOnDiskArticle(articles);
    }
    
    public void readAllArticle(ArrayList<Article> articles){
        
        for(int i = 0; i < articles.size(); i++){
            System.out.println(readFromDiskArticle().get(i)); // syso wywoluje wewnetrzne toString
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
    
    private static ArrayList<Article> readFromDiskArticle()  {

        ArrayList <Article> articles = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(("article")));
            articles = (ArrayList<Article>) ois.readObject();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }catch(ClassNotFoundException e){}

        return articles;
    }
    
    
    
}
