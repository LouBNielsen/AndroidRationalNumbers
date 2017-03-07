package dk.cphbusiness.template;

/**
 * Created by AKA on 09/02/2017.
 */

public class Program {

    public static void main(String[] args) {
        Person kurt = new Person("Kurt");
        Pet felix = new Pet("Felix", kurt);
        // ...

        kurt.getPets().clear();

    }
}
