package rickMorty;

import rickMorty.rest.ClientRest;

public class Main {

    public static void main(String[] args) {
        ClientRest cr = new ClientRest();
        cr.miRickMorty();
        System.out.println("FIN de las consultas");
        System.exit(0);
    }

}
