package emapa;
public class noPerecedero extends producto{
	private String tipo;
	private int id_producto;
	public noPerecedero() {
		// TODO Auto-generated constructor stub
	}
	public noPerecedero(String nombre, double precio, int stock, String tipo) {
		super(nombre, precio, stock);
		this.tipo = tipo;
	}
	public noPerecedero(String nombre, double precio, int stock) {
		super(nombre, precio, stock);
		// TODO Auto-generated constructor stub
	}
	public noPerecedero(String nombre, double precio, int stock, String tipo, int id_producto) {
		super(nombre, precio, stock);
		this.tipo = tipo;
		this.id_producto = id_producto;
	}
	public noPerecedero(String tipo, int id_producto) {
		this.tipo = tipo;
		this.id_producto = id_producto;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double calcularPrecioFinal() {
        return getPrecio(); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
