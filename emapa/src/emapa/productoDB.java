package emapa;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class productoDB {
	private Connection conexion;
	
	public productoDB() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_emapa", "root", "");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	//Creación de una nueva propiedad
	public void agregarProducto(producto prop) {
		String sql="INSERT INTO producto (nombre,precio,stock) VALUES(?,?,?)";
		try (PreparedStatement parametro=conexion.prepareStatement(sql)){
			parametro.setString(1, prop.getNombre());
			parametro.setDouble(2, prop.getPrecio());
			parametro.setInt(3, prop.getStock());
			parametro.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Edición de propiedad
	public void editarProducto(producto prop, int id) {
        String sql = "UPDATE producto SET nombre=?, precio=?, stock=? WHERE id = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
        	parametro.setString(1, prop.getNombre());
			parametro.setDouble(2, prop.getPrecio());
			parametro.setInt(3, prop.getStock());
            parametro.setInt(4, id);
            parametro.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    // Eliminar una propiedad
    public void eliminarProducto(int id) {
        String sql = "DELETE FROM producto WHERE id = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, id);
            parametro.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Obtener lista de propiedades
    public producto obtenerProducto(int id) {
        String sql = "SELECT * FROM producto WHERE id_producto = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, id);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {
                return new producto(rs.getString("nombre"),rs.getDouble("precio"),rs.getInt("stock"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void mostrarInventario() {
        String sql = "SELECT * FROM producto";
        try (PreparedStatement parametro = conexion.prepareStatement(sql);
             ResultSet rs = parametro.executeQuery()) {
            
            System.out.println("Resumen del Inventario:");
            System.out.println("ID\tNombre\t\tPrecio\t\tStock");
            System.out.println("------------------------------------------------");
            
            while (rs.next()) {
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                
                System.out.printf("%d\t%-10s\t%.2f\t\t%d%n", id, nombre, precio, stock);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void mostrarStockProducto(int idProducto) {
        String sql = "SELECT nombre, stock FROM producto WHERE id_producto = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idProducto);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                int stock = rs.getInt("stock");
                
                System.out.println("Stock actual del producto vendido:");
                System.out.printf("Producto: %s | Stock Actual: %d%n", nombre, stock);
            } else {
                System.out.println("No se encontró el producto con el ID proporcionado.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

