package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorArchivo {
    public void guardarJson(MonedaRec monedaRec) throws IOException{
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter escritura = new FileWriter("monedaArchivo.json");
        escritura.write(gson.toJson(monedaRec));
        escritura.close();
    }
}
