package emapa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emapa.perecedero;
public class perecederoDB {
	private Connection conexion;
	
	public perecederoDB() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_emapa", "root", "");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	//Creación de una nueva propiedad
	public void agregarPerecedero(perecedero prop) {
		String sql="INSERT INTO perecedero (fechaCaducidad,id_producto) VALUES(?,?)";
		try (PreparedStatement parametro=conexion.prepareStatement(sql)){
			parametro.setString(1, prop.getFechaCaducidad());
			parametro.setInt(2, prop.getId_producto());
			parametro.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Edición de propiedad
	public void editarPerecedero(perecedero prop, int id) {
        String sql = "UPDATE perecedero SET fechaCaducidad=?, id_producto=? WHERE id = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
        	parametro.setString(1, prop.getFechaCaducidad());
			parametro.setInt(2, prop.getId_producto());
            parametro.setInt(3, id);
            parametro.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    // Eliminar una propiedad
    public void eliminarPerecedero(int id) {
        String sql = "DELETE FROM perecedero WHERE id = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, id);
            parametro.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Obtener lista de propiedades
    public perecedero obtenerPerecedero(int id) {
        String sql = "SELECT * FROM perecedero WHERE id_perecedero = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, id);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {
                return new perecedero(rs.getString("fechaCaducidad"),rs.getInt("id_producto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}