package emapa;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class perecedero extends producto {
    private String fechaCaducidad;
    private int id_producto;
    public perecedero() {
		// TODO Auto-generated constructor stub
	}
    public perecedero(String nombre, double precio, int stock, String fechaCaducidad) {
		super(nombre, precio, stock);
		this.fechaCaducidad = fechaCaducidad;
	}
	public perecedero(String fechaCaducidad, int id_producto) {
		this.fechaCaducidad = fechaCaducidad;
		this.id_producto = id_producto;
	}
	public perecedero(String nombre, double precio, int stock, String fechaCaducidad, int id_producto) {
		super(nombre, precio, stock);
		this.fechaCaducidad = fechaCaducidad;
		this.id_producto = id_producto;
	}

	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
    public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	//
    public double calcularPrecioFinal() {
        double precioBase = this.getPrecio();
        if (estaPorVencer()) {
            precioBase *= 0.8;
        }
        return precioBase;
    }

    public boolean estaPorVencer() {
        String fechaActual = java.time.LocalDate.now().toString();
        String[] partesFechaActual = fechaActual.split("-");
        String[] partesFechaCaducidad = fechaCaducidad.split("-");

        int anioActual = Integer.parseInt(partesFechaActual[0]);
        int mesActual = Integer.parseInt(partesFechaActual[1]);
        int diaActual = Integer.parseInt(partesFechaActual[2]);

        int anioCaducidad = Integer.parseInt(partesFechaCaducidad[0]);
        int mesCaducidad = Integer.parseInt(partesFechaCaducidad[1]);
        int diaCaducidad = Integer.parseInt(partesFechaCaducidad[2]);
        int diferenciaDias = (anioCaducidad - anioActual) * 365 + 
                             (mesCaducidad - mesActual) * 30 + 
                             (diaCaducidad - diaActual);
        return diferenciaDias <= 15;
    }
}