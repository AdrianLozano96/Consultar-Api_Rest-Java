package rickMorty.rest;

public class ConfigRest {

    // IP del servicio
    public static final String API_URL = "https://rickandmortyapi.com/api/";

    private ConfigRest() {
    }

    // Constructor del servicio con los elementos de la interfaz
    public static DatosRest getService() {
        System.out.println("API URL: "+API_URL);
        return RetrofitRest.getClient(API_URL).create(DatosRest.class);
    }

}
