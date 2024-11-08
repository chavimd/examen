package emapa;

public class venta_producto {
	private int id_venta;
	private int id_producto;
	private int cantidad;
	public venta_producto() {
		// TODO Auto-generated constructor stub
	}
	
	public venta_producto(int cantidad) {
		this.cantidad = cantidad;
	}

	public venta_producto(int id_venta, int id_producto, int cantidad) {
		this.id_venta = id_venta;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
	}
	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void realizarVenta(int stock) {
        if (cantidad > stock) {
            System.out.println("No hay suficiente stock para la venta");
           
        } else {
            stock -= cantidad;
            System.out.println("Venta realizada de " + cantidad + " unidades. Stock restante: " + stock);
            
        }
    }
	public void actualizarStock(int stock) {
        if (stock + cantidad < 0) {
            System.out.println("Error: el stock no puede ser negativo" );
        } else {
            stock -= cantidad;
            System.out.println("Stock actualizado. Nuevo stock: " + stock);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
