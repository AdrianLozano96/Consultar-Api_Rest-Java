import placeholder.rest.RestClientDemo;

public class Main {

    public static void main(String[] args) {
        System.out.println( "API CLIENT ACCESO A DATOS" );

        RestClientDemo restClient = new RestClientDemo();
        restClient.runUsuario();
        System.out.println("Fin");
        System.exit(0);
    }

}
