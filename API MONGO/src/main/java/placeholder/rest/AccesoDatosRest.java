package placeholder.rest;

import placeholder.model.Company;
import placeholder.model.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AccesoDatosRest {


    // Obtener todos
    @GET("users")
    Call<List<User>> usuarioGetAll();

    // Obtener uno por ID
    @GET("users/{id}")
    Call<User> usuarioGetById(@Path("id") String id);

    // Obtenemos todos los algo de la clase
    @GET("users/{id}/company")
    Call<List<Company>> usuarioGetcompany(@Path("id") String id);

    // POST
    @POST("users")
    Call<User> usuarioCreate(@Body User user);

    // PUT
    @PUT("users/{id}")
    Call<User> usuarioUpdate(@Path("id") String id, @Body User user);

    // DELETE
    @DELETE("users/{id}")
    Call<User> userDelete(@Path("id") String id);

}
