package emapa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class compradorDB {
	private Connection conexion;
	
	public compradorDB() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_emapa", "root", "");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	//Creación de una nueva propiedad
	public void agregarComprador(comprador prop) {
		String sql="INSERT INTO comprador (nombre,apellido,ci,direccion,celular) VALUES(?,?,?,?,?)";
		try (PreparedStatement parametro=conexion.prepareStatement(sql)){
			parametro.setString(1, prop.getNombre());
			parametro.setString(2, prop.getApellido());
			parametro.setInt(3, prop.getCi());
			parametro.setString(4, prop.getDireccion());
			parametro.setInt(5, prop.getCelular());
			parametro.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Edición de propiedad
	public void editarComprador(comprador prop, int id) {
        String sql = "UPDATE comprador SET nombre=?, apellido=?,ci=?,direccion=?,celular=? WHERE id = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
        	parametro.setString(1, prop.getNombre());
        	parametro.setString(2, prop.getApellido());
			parametro.setInt(3, prop.getCi());
			parametro.setString(4, prop.getDireccion());
			parametro.setInt(5, prop.getCelular());
            parametro.setInt(6, id);
            parametro.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    // Eliminar una propiedad
    public void eliminarComprador(int id) {
        String sql = "DELETE FROM comprador WHERE id = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, id);
            parametro.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Obtener lista de propiedades
    public comprador obtenerComprador(int id) {
        String sql = "SELECT * FROM comprador WHERE id_comprador = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, id);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {
                return new comprador(rs.getString("nombre"),rs.getString("apellido"),rs.getInt("ci"),rs.getString("direccion"),rs.getInt("celular"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}