package placeholder.rest;

import placeholder.model.User;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class RestClientDemo {

    AccesoDatosRest restService = ApiRestConfig.getService();

    public void runUsuario() {
        System.out.println("Cliente REST EndPoint Usuario");
        userGetAll();
        userGetById();
        userPost();
        userGetAll();
        userPut();
        userDelete();
        userGetAll();
    }

    private void userGetAll() {
        System.out.println("GET ALL Usuarios");
        try {
            Response<List<User>> response = restService.usuarioGetAll().execute();
            // La hemos obtenido correctamente
            if (response.isSuccessful() && response.body() != null) {
            //if (response.isSuccessful()) {
                System.out.println("Request Done! - Código: " + response.code() + " - Datos obtenidos: " + response.body().size());
                System.out.println(response.body());
                System.out.println("Resultado de GET ALL Usuarios");
                //Método toJSON()
                List<User> u = response.body();
                u.forEach(v->System.out.println(v.toJSON()));
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void userGetById() {
        System.out.println("GET Usuario By ID 9");
        try {
            Response<User> response = restService.usuarioGetById("9").execute();
            // La hemos obtenido correctamente
            if (response.isSuccessful()) {
                System.out.println("Request Done! - Código: " + response.code());
                System.out.println("Resultado de GET By Id");
                User result = response.body();
                System.out.println(result.toJSON());
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void userPost() {
        System.out.println("POST Usuario");
        User user = new User();
        user.setName("usuario Insert");
        user.setUsername("username");
        user.setEmail("correo@.com");
        user.setAddress(null);
        user.setPhone("343459459");
        user.setWebsite("efregwinj");
        user.setCompany(null);


        try {
            Response<User> response = restService.usuarioCreate(user).execute();
            // La hemos obtenido correctamente
            if (response.isSuccessful()) {
                System.out.println("Request Done! - Código: " + response.code());
                System.out.println("Resultado de POST");
                User result = response.body();
                System.out.println(result.toJSON());
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void userPut() {
        System.out.println("PUT Usuario");
        User user = new User();
        user.setName("Usuario Update");
        user.setUsername("usernameNew");
        user.setEmail("correo@.com");
        user.setAddress(null);
        user.setPhone("343459459");
        user.setWebsite("efregwinj");
        user.setCompany(null);

        try {
            Response<User> response = restService.usuarioUpdate("11", user).execute();
            // La hemos obtenido correctamente
            if (response.isSuccessful() && response.body() != null) {
                System.out.println("Request Done! - Código: " + response.code());
                System.out.println("Resultado de PUT");
                User result = response.body();
                System.out.println(result.toJSON());
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void userDelete() {
        System.out.println("DELETE Usuario");
        try {
            Response<User> response = restService.userDelete("11").execute();
            // La hemos obtenido correctamente
            if (response.isSuccessful()) {
                System.out.println("Request Done! - Código: " + response.code());
                System.out.println("Resultado de DELETE");
                User result = response.body();
                System.out.println(result.toJSON());
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
