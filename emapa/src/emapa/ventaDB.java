package emapa;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ventaDB {
	private Connection conexion;
	
	public ventaDB() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_emapa", "root", "");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	//Creación de una nueva propiedad
	public void agregarVenta(venta prop) {
		String sql="INSERT INTO venta(id_comprador) VALUES(?)";
		try (PreparedStatement parametro=conexion.prepareStatement(sql)){
			parametro.setInt(1, prop.getId_comprador());
			parametro.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Edición de propiedad
	public void editarVenta(venta prop, int id) {
        String sql = "UPDATE venta SET id_comprador=? WHERE id = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
        	parametro.setInt(1, prop.getId_comprador());
            parametro.setInt(2, id);
            parametro.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    // Eliminar una propiedad
    public void eliminarVenta(int id) {
        String sql = "DELETE FROM venta WHERE id = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, id);
            parametro.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Obtener lista de propiedades
    public venta obtenerVenta(int id) {
        String sql = "SELECT * FROM venta WHERE id_venta = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, id);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {
                return new venta(rs.getInt("id_comprador"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}