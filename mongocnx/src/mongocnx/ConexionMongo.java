/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mongocnx;

/**
 *
 * @author lenni
 */
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ConexionMongo {
    public MongoClient cliente;
    public MongoDatabase baseDatos;

    public ConexionMongo() {
        // Asumiendo que tu MongoDB está en el puerto por defecto de tu máquina
        this.cliente = MongoClients.create("mongodb://localhost:27017");
        
        // Cambia "sistema_db" por el nombre real de tu base de datos
        this.baseDatos = cliente.getDatabase("sistema_db"); 
    }
}