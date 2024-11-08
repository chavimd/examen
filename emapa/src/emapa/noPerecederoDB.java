package emapa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class noPerecederoDB {
	private Connection conexion;
	
	public noPerecederoDB() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_emapa", "root", "");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	//Creación de una nueva propiedad
	public void agregarNoPerecedero(noPerecedero prop) {
		String sql="INSERT INTO noPerecedero(tipo,id_producto) VALUES(?,?)";
		try (PreparedStatement parametro=conexion.prepareStatement(sql)){
			parametro.setString(1, prop.getTipo());
			parametro.setInt(2, prop.getId_producto());
			parametro.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Edición de propiedad
	public void editarNoPerecedero(noPerecedero prop, int id) {
        String sql = "UPDATE noPerecedero SET tipo=?, id_producto=? WHERE id = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
        	parametro.setString(1, prop.getTipo());
			parametro.setInt(2, prop.getId_producto());
            parametro.setInt(3, id);
            parametro.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    // Eliminar una propiedad
    public void eliminarNoPerecedero(int id) {
        String sql = "DELETE FROM noPerecedero WHERE id = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, id);
            parametro.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Obtener lista de propiedades
    public noPerecedero obtenerNoPerecedero(int id) {
        String sql = "SELECT * FROM noPerecedero WHERE id_noPerecedero = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, id);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {
                return new noPerecedero(rs.getString("tipo"),rs.getInt("id_producto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}