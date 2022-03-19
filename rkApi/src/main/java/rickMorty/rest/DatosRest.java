package rickMorty.rest;

import retrofit2.Call;
import retrofit2.http.*;
import rickMorty.model.Localizacion;
import rickMorty.model.Location;
import rickMorty.model.Result;
import rickMorty.model.RickMorty;

import java.util.List;

public interface DatosRest {

    //Obtener todos personajes
    @GET("character")
    Call<RickMorty> rkGetAll();

    // Obtener uno por ID
    @GET("character/{id}")
    Call<Result> rkGetById(@Path("id") String id);

    // Obtenemos todos los personajes femeninos
    @GET("character/?gender=female")
    Call<List<RickMorty>> rkGetFemale();

    // Obtenemos todos los personajes masculinos vivos
    @GET("character/?gender=male&status=alive")
    Call<List<RickMorty>> rkGetMaleLive();

    //Obtener toda las ubicaciones
    @GET("location")
    Call<List<Location>> locaGetAll();

    // Obtener uno por ID
    @GET("location/{id}")
    Call<Location> locaGetById(@Path("id") String id);

    // Obtenemos todos las ubicaciones por su dimension
    @GET("location/?dimension={id}")
    Call<List<RickMorty>> locaGetDimension(@Path("id") String id);



}
