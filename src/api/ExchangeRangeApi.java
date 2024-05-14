package api;

import model.MonedaRec;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRangeApi {
    public MonedaRec buscarMoneda(String mon_OrigenApi,
                                  String mon_DestinoApi,
                                  Double montoConverApi){
        String apiKey = "d521943a516ba0b5643e394b";

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" +
                        apiKey +"/pair/"+
                        mon_OrigenApi+"/"+
                        mon_DestinoApi+"/"+
                        montoConverApi+"/");

        //System.out.println("DIRECCION ===> "+ direccion);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request,HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),MonedaRec.class);
        }catch (Exception e){
            throw new RuntimeException("Error al convertir Tipo Moneda");
        }
    }
}
