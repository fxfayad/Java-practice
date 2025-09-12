public class Book {
    String title,author;
    double price;
    Book (String t,String a, double p) {
        title = t; author = a; price = p;
    }
    void display(){
        System.out.println(title + author + price );
    }
}
class Test{
    public static void main(String[] args){
        Book b = new Book(" oop ", " dc ",  100 );
        b.display();
    }
}

