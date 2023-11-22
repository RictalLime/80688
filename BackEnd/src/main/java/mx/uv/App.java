package mx.uv;

import static spark.Spark.*;

import com.google.gson.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //fuente:https://gist.github.com/saeidzebardast/e375b7d17be3e0f4dddf
        options("/*",(request,response)->{
        String accessControlRequestHeaders=request.headers("Access-Control-Request-Headers");
        if(accessControlRequestHeaders!=null){
        response.header("Access-Control-Allow-Headers",accessControlRequestHeaders);
        }
        String accessControlRequestMethod=request.headers("Access-Control-Request-Method");
        if(accessControlRequestMethod!=null){
        response.header("Access-Control-Allow-Methods",accessControlRequestMethod);
        }
        return "OK";
        });
        before((request,response)->response.header("Access-Control-Allow-Origin","*"));

        get("/agregar", (request, response) ->{
                JsonObject respuesta = new JsonObject();
                respuesta.addProperty("agregar", "usuario");
                respuesta.addProperty("nombre", request.queryParams("nombre"));
                respuesta.addProperty("edad", request.queryParams("edad"));
                respuesta.addProperty("peso", request.queryParams("peso"));

                return respuesta;
        });

        get("/eliminar", (request, response) ->{
                JsonObject respuesta = new JsonObject();
                respuesta.addProperty("nombre", request.queryParams("nombre"));
                respuesta.addProperty("edad", request.queryParams("edad"));
                respuesta.addProperty("peso", request.queryParams("peso"));
                String eliminarNombre = request.queryParams("nombre");
                String eliminarEdad = request.queryParams("edad");
                String eliminarPeso = request.queryParams("peso");
                if (eliminarNombre != null) {
                        respuesta.remove("nombre");
                }
                if (eliminarEdad != null) {
                        respuesta.remove("edad");
                }
                if (eliminarPeso != null) {
                        respuesta.remove("peso");
                }

                return respuesta;
        });

        get("/modificar", (request, response) ->{
                JsonObject respuesta = new JsonObject();
                respuesta.addProperty("agregar", "usuario");
                respuesta.addProperty("nombre", request.queryParams("nombre"));
                respuesta.addProperty("edad", request.queryParams("edad"));
                respuesta.addProperty("peso", request.queryParams("peso"));

                modificarNombre(respuesta, request.queryParams("nuevoNombre"));
                modificarEdad(respuesta, request.queryParams("nuevaEdad"));
                modificarPeso(respuesta, request.queryParams("nuevoPeso"));
                
                return respuesta;
        });

        get("/consultar", (request, response) ->{
                JsonObject respuesta = new JsonObject();
                respuesta.addProperty("nombre", request.queryParams("nombre"));
                String consultaNombre = nombreConsultado(respuesta, "nombre");
                System.out.println("Nombre consultado: " + consultaNombre);

                respuesta.addProperty("edad", request.queryParams("edad"));
                String consultaEdad = nombreConsultado(respuesta, "edad");
                System.out.println("Edad consultado: " + consultaEdad);

                respuesta.addProperty("peso", request.queryParams("peso"));
                String consultaPeso = nombreConsultado(respuesta, "peso");
                System.out.println("Peso consultado: " + consultaPeso);

                return respuesta;
        });
    }
    private static void modificarNombre(JsonObject objetoJson, String nuevoNombre) {
        if (objetoJson.has("nombre")) {
            objetoJson.addProperty("nombre", nuevoNombre);
        } else {
            System.out.println("cambiaste el nombre. ");
        }
    }

    private static void modificarEdad(JsonObject objetoJson, String nuevaEdad) {
        if (objetoJson.has("edad")) {
            objetoJson.addProperty("edad", nuevaEdad);
        } else {
            System.out.println("cambiaste la edad. ");
        }
    }

    private static void modificarPeso(JsonObject objetoJson, String nuevoPeso) {
        if (objetoJson.has("peso")) {
            objetoJson.addProperty("peso", nuevoPeso);
        } else {
            System.out.println("cambiaste el peso. ");
        }
    }

    private static String consultarDato(JsonObject objetoJson, String dato) {
        if (objetoJson.has(dato)) {
            return objetoJson.get(dato).getAsString();
        } else {
            System.out.println("No existe.");
            return null;
        }
    }
}