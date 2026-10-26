package Java_DesignPatterns.Singleton;


public class Main {

    public static void main(String[] args){

        Singleton newObject = Singleton.getInstance();


    }

}

class Singleton {

    private static Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (instance == null){
            return new Singleton();
        }
        return instance;
    }

}
