package emapa;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class venta_productoDB {
	private Connection conexion;
	
	public venta_productoDB() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_emapa", "root", "");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	//Creación de una nueva propiedad
	public void agregarVenta_producto(venta_producto prop) {
		String sql="INSERT INTO venta_producto(id_venta,id_producto, cantidad) VALUES(?,?,?)";
		try (PreparedStatement parametro=conexion.prepareStatement(sql)){
			parametro.setInt(1, prop.getId_venta());
			parametro.setInt(2, prop.getId_producto());
			parametro.setInt(3, prop.getCantidad());
			parametro.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Edición de propiedad
	public void editarVenta_producto(venta_producto prop, int id) {
        String sql = "UPDATE venta_producto SET id_comprador=? WHERE id = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
        	parametro.setInt(1, prop.getId_venta());
			parametro.setInt(2, prop.getId_producto());
			parametro.setInt(3, prop.getCantidad());
            parametro.setInt(4, id);
            parametro.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    // Eliminar una propiedad
    public void eliminarVenta_producto(int id) {
        String sql = "DELETE FROM venta_producto WHERE id = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, id);
            parametro.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Obtener lista de propiedades
    public venta obtenerVenta_producto(int id) {
        String sql = "SELECT * FROM venta_producto WHERE id_ventaProducto = ?";
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
    public boolean registrarVenta(int idProducto, int idVenta, int cantidad) {
        String sqlVenta = "INSERT INTO venta_producto (id_producto, id_venta, cantidad) VALUES (?, ?, ?)";
        String sqlActualizarStock = "UPDATE producto SET stock = stock - ? WHERE id_producto = ?";
        
        try (PreparedStatement ventaStmt = conexion.prepareStatement(sqlVenta);
             PreparedStatement stockStmt = conexion.prepareStatement(sqlActualizarStock)) {
            
            // Registrar la venta
            ventaStmt.setInt(1, idProducto);
            ventaStmt.setInt(2, idVenta);
            ventaStmt.setInt(3, cantidad);
            ventaStmt.executeUpdate();
            
            // Actualizar el stock del producto
            stockStmt.setInt(1, cantidad);
            stockStmt.setInt(2, idProducto);
            int filasActualizadas = stockStmt.executeUpdate();
            
            if (filasActualizadas > 0) {
                System.out.println("Venta registrada y stock actualizado correctamente.");
                return true;
            } else {
                System.out.println("No se pudo actualizar el stock. Verifica el ID del producto y la cantidad disponible.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
