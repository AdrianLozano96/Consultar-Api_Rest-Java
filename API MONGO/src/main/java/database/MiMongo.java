package database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import org.bson.Document;
import org.bson.types.ObjectId;
import placeholder.model.User;
import placeholder.rest.AccesoDatosRest;
import placeholder.rest.ApiRestConfig;
import retrofit2.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;

public class MiMongo {

    private MongoController controller = MongoController.getInstance();
    MongoCollection<User> usuariosCollection = collectionAccess();
    //MongoCollection<Usuarios> usuariosCollection = collectionAccessGenerico("cajero", "usuarios", Usuarios.class);
            //controller.getCollection("cajero", "usuarios", Usuarios.class);
    AccesoDatosRest restService = ApiRestConfig.getService();

    private static MiMongo mongo;
    private MiMongo(){}
    public static MiMongo getInstance(){
        if(mongo == null){mongo = new MiMongo();}
        return mongo;
    }

    //Me conecto a Mongo
    public void conectar(){
        controller.open();
    }

    //Me desconecto de Mongo
    public void desconectarn(){
        controller.close();
    }

    //Se muestran todas las bases de datos
    public void listaDB(){
        // Obtenemos las bases de datos
        Optional<List<Document>> databases = controller.getDataBases();
        System.out.println("Todos las bases de datos existentes");
        databases.ifPresent(documents -> documents.forEach(db -> System.out.println(db.toJson())));
    }


    //Me conecto a una GENERAL
    public <TCollection> MongoCollection<TCollection> collectionAccessGenerico(String dataBaseName,
                                                                       String collectionName,
                                                                       Class<TCollection> collectionClass){
        conectar();
        // Me conecto a la colección de departamentos
        MongoCollection<TCollection> miCollection = controller
                .getCollection(dataBaseName, collectionName, collectionClass);
        return miCollection;
    }

    //Me conecto a una colección
    public MongoCollection<User> collectionAccess(){
        conectar(); //IMPORTANTE
        // Me conecto a la colección de departamentos
        MongoCollection<User> miCollection = controller
                .getCollection("javaMongo", "user", User.class);
        return miCollection;
    }

    //Borra la coleccion
    public void eliminarColeccion(){
        // La borro para tenerla limpia cada colección
        controller.removeCollection("javaMongo", "user");
    }

    public void eliminarDB(){
        // incluso la BD completa
        controller.removeDataBase("javaMongo");
    }


    //CRUD

    public List<User> userGetAll() {
        System.out.println("GET ALL Usuarios");
        List<User> usuarios = null;
        try {
            Response<List<User>> response = restService.usuarioGetAll().execute();
            // La hemos obtenido correctamente
            if (response.isSuccessful()) {
                System.out.println("Request Done! - Código: " + response.code() + " - Datos obtenidos: " + response.body().size());
                System.out.println(response.body());
                System.out.println("Resultado de GET ALL Usuarios");
                //Método toJSON()
                usuarios = response.body();
                usuarios.forEach(v->System.out.println(v.toJSON()));
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }


    public void insertarVariosUsuarios(List<User>nuevosUsuarios) {
        System.out.println("Insertando Usuarios");
        usuariosCollection.insertMany(nuevosUsuarios);
    }

    public void insertarUnUsuario(User usuario){
        System.out.println("Insertar Usuario");
        usuariosCollection.insertOne(usuario);
    }

    public void mostrarDocs(){
        // Recorremos la colección
        System.out.println("Mostrando todos los Usuarios");
        usuariosCollection.find().into(new ArrayList<>()).forEach(System.out::println);
    }

    public void buscarUsuario(String correo){
        System.out.println("Usuario con el correo "+correo);
        System.out.println("Buscando...");
        User usuarioBuscado = usuariosCollection.find(eq("email", correo)).first();
        System.out.println("Encontrado:\t" + usuarioBuscado.toString());
    }

    public void idUsuario(){
        System.out.println("Usuario con el id ");
        System.out.println("Buscando...");
        User usuarioBuscado = usuariosCollection.find(eq("name", "Glenna Reichert")).first();
        //User usuarioBuscado = usuariosCollection.find(eq("_id", 7)).first();
        System.out.println("Encontrado:\t" + usuarioBuscado.toString());
        System.out.println("Encontrado:\t" + usuarioBuscado.toJSON());

    }


    public Optional<User> update(User usuario) throws SQLException {
        try {
            Document filtered = new Document("_id", usuario.getId());
            FindOneAndReplaceOptions returnDoc = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);

            return Optional.ofNullable(usuariosCollection.findOneAndReplace(filtered, usuario, returnDoc));
        } catch (Exception e) {
            throw new SQLException("Error Usuario al actualizar con id: " +
                    usuario.getId() + ": " + e.getMessage());
        } finally {
            //controller.close();
        }
    }



}
