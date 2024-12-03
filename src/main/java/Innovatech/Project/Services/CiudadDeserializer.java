package Innovatech.Project.Services;

import Innovatech.Project.Entity.Ciudad;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class CiudadDeserializer extends JsonDeserializer<Ciudad> {
    @Override
    public Ciudad deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        int id = parser.getIntValue(); // Obtener el ID de la ciudad
        Ciudad ciudad = new Ciudad();
        ciudad.setId(id); // Crear una instancia de Ciudad con solo el ID
        return ciudad;
    }
}
