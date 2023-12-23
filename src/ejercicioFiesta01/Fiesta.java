package ejercicioFiesta01;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.*;

public class Fiesta {

	private String tipo;
	private String fechaHora;
	private String direccion;
	private int bebidas;
	private int bocadillos;
	private int invitados;
	final double precioBocadillo=3.0;
	final double precioBebida=2.0;
	final double precioEntrada=5.0;
	
	public Fiesta(String tipo,String fechaHora,String direccion,int bebidas, int bocadillos, int invitados)
	{
		this.tipo="";
		this.fechaHora=fechaHora;
		this.direccion=direccion;
		this.bebidas=100;
		this.bocadillos=200;
		this.invitados=0;
		
	}
	public Fiesta()
	{
		
	}
	public void fechaFiesta()
	{
		Scanner peticion= new Scanner(System.in);
		int dia=0;
		int mes=0;
		int anio=0;
		int hora=0;
		int minuto=0;
		System.out.println("Introduzca el DIA de la fiesta:");
		dia=peticion.nextInt();
		System.out.println("Introduzca el MES de la fiesta:");
		mes=peticion.nextInt();
		System.out.println("Introduzca el ANIO de la fiesta:");
		anio=peticion.nextInt();
		System.out.println("Introduzca el HORA de la fiesta:");
		hora=peticion.nextInt();
		System.out.println("Introduzca el MINUTO de la fiesta:");
		minuto=peticion.nextInt();
		
		LocalDateTime fecha= LocalDateTime.of(anio,mes,dia,hora,minuto,0,0023);
		DateTimeFormatter fechaConvencional= DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss").withLocale(new Locale("es","ES"));
		System.out.println("La fecha de la fiesta es: "+fecha);
		System.out.println("");
		System.out.println("La fecha convencional de la fiesta es: "+fecha.format(fechaConvencional));
		System.out.println("");
		//peticion.close();   //Cierre del objeto
	}
	public String getConsulta()
	{
		return "El tipo de fiesta organizada es: "+this.tipo+", la fecha y hora son: "+this.fechaHora+" la direccion es: "+this.direccion+". El numero de bebidas son: "+this.bebidas+", de bocadillos: "+this.bocadillos+" y los invitados son: "+this.invitados;
	}
	public void setInvitar()
	{
		//SE SUMARA UNA UNIDAD MAS AL CONTADOR DE INVITADOS
		this.invitados=this.invitados+1;
	}
	public void setCancelarInvitacion()
	{
		//SE RESTARA UNA UNIDAD MAS AL CONTADOR DE INVITADOS
		this.invitados=this.invitados-1;
	}
	public double getPrecioFiesta()
	{
		double precioFiesta=0.0;
		precioFiesta=this.invitados*(precioBocadillo+precioBebida+precioEntrada);
		return precioFiesta;
	}
}
