package emapa;

public class comprador {
	private String nombre;
	private String apellido;
	private int ci;
	private String direccion;
	private int celular;
	public comprador() {
		// TODO Auto-generated constructor stub
	}
	public comprador(String nombre, String apellido, int ci, String direccion, int celular) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.direccion = direccion;
		this.celular = celular;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getCi() {
		return ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
