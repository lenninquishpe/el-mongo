/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mongocnx; // Asegúrate de que el paquete sea el correcto

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;

public class ControladorLogin {
    public ConexionMongo conexion;

    public ControladorLogin() {
        this.conexion = new ConexionMongo();
    }

    public int verificarUsuario(Usuario u) {
        // "usuarios" es la colección en MongoDB
        MongoCollection<Document> coleccion = conexion.baseDatos.getCollection("usuarios");
        
        // Buscamos usando u.usuario para que coincida con la clase Usuario
        Document doc = coleccion.find(eq("usuario", u.usuario)).first();
        
        if (doc != null) {
            String passBD = doc.getString("contrasena");
            
            if (passBD.equals(u.contrasena)) {
                return 1; // Login correcto
            }
        }
        
        return 0; // Error de login
    }
}