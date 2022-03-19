package rickMorty.rest;

import retrofit2.Response;
import rickMorty.model.Localizacion;
import rickMorty.model.Location;
import rickMorty.model.Result;
import rickMorty.model.RickMorty;

import java.io.IOException;
import java.util.List;

public class ClientRest {

    DatosRest restService = ConfigRest.getService();

    public void miRickMorty() {
        System.out.println("Cliente REST EndPoint Usuario");
        characterGetAll();
        characterGetById();
        femaleGet();
        maleLiveGet();
        localGetAll();
        localGetById();
        localGetDimension();
    }

    private void characterGetAll() {
        System.out.println("GET ALL Personajes");
        try {
            Response<RickMorty> response = restService.rkGetAll().execute();
            // La hemos obtenido correctamente
            if (response.isSuccessful() && response.body() != null) {
                System.out.println("Request Done! - Código: " + response.code());
                System.out.println(response.body());
                System.out.println("Resultado de GET ALL Personajes");
                //Método toJSON()
                RickMorty u = response.body();
                System.out.println(u.toJSON());
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void characterGetById() {
        System.out.println("GET Personaje By ID 9");
        try {
            Response<Result> response = restService.rkGetById("9").execute();
            // La hemos obtenido correctamente
            if (response.isSuccessful()) {
                System.out.println("Request Done! - Código: " + response.code());
                System.out.println("Resultado de GET By Id");
                Result result = response.body();
                System.out.println(result.toJSON());
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void femaleGet() {
        System.out.println("GET Personaje Femeninos");
        try {
            Response<List<RickMorty>> response = restService.rkGetFemale().execute();
            if (response.isSuccessful()) {
                System.out.println("Request Done! - Código: " + response.code());
                System.out.println("Resultado de GET Personaje Femeninos");
                List<RickMorty> result = response.body();
                result.forEach(r -> System.out.println(r.toJSON()));
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void maleLiveGet() {
        System.out.println("GET Personaje Masculinos Vivos");
        try {
            Response<List<RickMorty>> response = restService.rkGetMaleLive().execute();
            // La hemos obtenido correctamente
            if (response.isSuccessful()) {
                System.out.println("Request Done! - Código: " + response.code());
                System.out.println("Resultado de GET Masculinos Vivos");
                List<RickMorty> result = response.body();
                result.forEach(r -> System.out.println(r.toJSON()));
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void localGetAll() {
        System.out.println("GET Todos los lugares");
        try {
            Response<List<Location>> response = restService.locaGetAll().execute();
            // La hemos obtenido correctamente
            if (response.isSuccessful()) {
                System.out.println("Request Done! - Código: " + response.code());
                System.out.println("Resultado de GET Todos los lugares");
                List<Location> result = response.body();
                result.forEach(r -> System.out.println(r.toJSON()));
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void localGetById() {
        System.out.println("GET Lugar By Id 9");
        try {
            Response<Location> response = restService.locaGetById("9").execute();
            // La hemos obtenido correctamente
            if (response.isSuccessful()) {
                System.out.println("Request Done! - Código: " + response.code());
                System.out.println("Resultado de GET Lugar con Id 9");
                Location result = response.body();
                System.out.println(result.toJSON());
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void localGetDimension() {
        System.out.println("GET Dimension 9");
        try {
            Response<List<RickMorty>> response = restService.locaGetDimension("9").execute();
            // La hemos obtenido correctamente
            if (response.isSuccessful()) {
                System.out.println("Request Done! - Código: " + response.code());
                System.out.println("Resultado de GET Dimension 9");
                List<RickMorty> result = response.body();
                result.forEach(r -> System.out.println(r.toJSON()));
            }
            else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
