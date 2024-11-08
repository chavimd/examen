package emapa;
import java.util.Date;
import java.util.Scanner;
import java.time.ZoneId;
import java.util.Calendar;
import java.time.LocalDate;
import emapa.*;

public class principal {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		producto prod1=new producto("Detergente",20.0,20);
		productoDB proDB=new productoDB();
		proDB.agregarProducto(prod1);
		perecedero per1=new perecedero("29-10-2024",1);
		perecederoDB perDB=new perecederoDB();
		perDB.agregarPerecedero(per1);
		perecedero per2=new perecedero("Queso",20.0,20,"29-10-2024");
		noPerecedero nper1=new noPerecedero("atun",20.0,20,"29-10-2024");
		perDB.agregarPerecedero(per1);
		System.out.println("El precio es: "+per2.calcularPrecioFinal());
		noPerecedero nop1=new noPerecedero("Escoba",20.0,20,"limpieza");
		System.out.println("El precio es: "+nop1.calcularPrecioFinal());
		venta_producto vp1=new venta_producto(18);
		vp1.realizarVenta(prod1.getStock());
		vp1.actualizarStock(prod1.getStock());
		
		productoDB pro1DB=new productoDB();
		pro1DB.mostrarInventario();
		
				
		try (Scanner leer = new Scanner(System.in)) {
			System.out.print("Ingresa el nombre del comprador: ");
			String c1=leer.nextLine();
			System.out.print("Ingresa el apellido del comprador: ");
			String c11=leer.nextLine();
			System.out.print("Ingresa el ci: ");
			int c111=leer.nextInt();
			leer.nextLine();
			System.out.print("Ingresa la dirección: ");
			String c1111=leer.nextLine();
			System.out.print("Ingresa el celular: ");
			int c11111=leer.nextInt();
			leer.nextLine();
			comprador com1=new comprador(c1,c11,c111,c1111,c11111);
			compradorDB comDB=new compradorDB();
			comDB.agregarComprador(com1);
		}
		
		venta ven1=new venta(1);
		ventaDB venDB=new ventaDB();
		venDB.agregarVenta(ven1);
		
		venta_productoDB vpDB= new venta_productoDB();
		
		boolean ventaExito=vpDB.registrarVenta(40, 1, 30);
		if(ventaExito) {
			System.out.println("La venta se realizó con éxito");
			pro1DB.mostrarStockProducto(40);;
		}
		else
			System.out.println("Hubo un problema al realizar la venta");
	}

}
