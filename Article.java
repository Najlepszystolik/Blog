package BlogDemo;

import java.io.Serializable;

public class Article implements Serializable{

    private static final long serialVersionUID = 1L;
    private String title = "";
    private String author = "";
    private String contents = "";
    
    public Article(String title, String author, String contents){
        
        this.title = title;
        this.author = author; 
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    
    @Override
    public String toString(){
        return "Author: " + author + ", Title: " + title + ", Contents: " + contents;
        
    }
}
