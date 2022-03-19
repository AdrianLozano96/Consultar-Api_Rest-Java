import database.MiMongo;
import org.bson.types.ObjectId;
import placeholder.model.User;
import placeholder.rest.RestClientDemo;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println( "API CLIENT ACCESO A DATOS" );
        MiMongo miMongo = MiMongo.getInstance();
        miMongo.conectar();
        //List<User> users = miMongo.userGetAll();
        //users.stream().forEach(System.out::println);
        miMongo.mostrarDocs();
        miMongo.idUsuario();
        miMongo.buscarUsuario("Shanna@melissa.tv");
        /*
        RestClientDemo restClient = new RestClientDemo();
        restClient.runUsuario();    //Consultas sobre la API
        MiMongo miMongo = MiMongo.getInstance();
        miMongo.conectar();
        miMongo.eliminarColeccion();
        System.out.println("Mongo");
        List<User> usuarios = miMongo.userGetAll(); //Obtengo los Usuarios de la API
        miMongo.insertarVariosUsuarios(usuarios);    //Inserto los datos de la API en la base de datos

         */
        System.out.println("Fin");
        System.exit(0);
    }

}
