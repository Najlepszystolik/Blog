package BlogDemo;

import java.util.ArrayList;

class Blog {

    public static void main(String[] args) throws java.io.IOException {
        char choice, ignore;

        ShowMe sm = new ShowMe();
        for (;;) {
            do {
                sm.showMenu();
                choice = (char) System.in.read();
                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (!sm.isValid(choice));
            if (choice == 'q')
                break;
            System.out.println("\n");
            sm.ShowOn(choice);
        }
        System.out.println();

    }
}

class ShowMe {

    ArticleData articleData = new ArticleData();
    ArrayList<Article> articles = new ArrayList<Article>();
    
    void ShowOn(int what) {
        switch (what) {
        case '1':
            
            articleData.readAllArticle(articles);
            
            System.out.println("Numer 1");
            break;

        case '2':
            articleData.makeNewArticle(articles);
             
            System.out.println("Numer 2");
            break;
        }
    }

    void showMenu() {
        System.out.println(" 1. Zobacz artykuły");
        System.out.println(" 2. Napisz artykuł");
        System.out.print("Wybierz numer instrukcji (lub q aby zakończyć): ");
    }

    boolean isValid(int ch) {
        if (ch < '1' | ch > '2' & ch != 'q')
            return false;
        else
            return true;
    }

}