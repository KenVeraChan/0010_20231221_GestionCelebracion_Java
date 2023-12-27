package ejercicioFiesta01;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fiesta {

	private static int dia=0;
	private static int mes=0;
	private static int anio=0;
	private static int hora=0;
	private static int minuto=0;
	private static int opcion=0;
	private static int opcion_vector=0;
	private String tipo[]= new String[]{"boda","cumpleaños","despedida"};
	private String fecha="";
	private String direccion=""; 
	private static int bebidas=0;
	private static int bocadillos=0;
	private static int invitados=0;
	private int max_invitados=0;
	final double precioBocadillo=3.0;
	final double precioBebida=2.0;
	final double precioEntrada=5.0;
	Scanner peticion= new Scanner(System.in);
	
	public Fiesta(String fecha,String direccion,int bebidas, int bocadillos, int invitados)
	{
		this.fecha=fecha;
		this.direccion=direccion;
		bebidas=100;
		bocadillos=200;
		invitados=0;
	}
	public Fiesta()
	{
		
	}
	public void presentacion()
	{
		opcion=0;
		fechaFiesta();   //Ejecuta la fecha de la fiesta
		System.out.println("Introduzca el numero maximo de invitados");
		this.max_invitados=peticion.nextInt();
		do {
			System.out.println("Elegir una de las opciones siguientes:");
			System.out.println("1) Introducir un nuevo invitado.");
			System.out.println("2) Cancelar invitacion.");
			System.out.println("3) Consultar invitados.");
			System.out.println("4) Salir del programa");	
			opcion=peticion.nextInt();
			switch(opcion)
			{
				case 1:
				{
					setInvitar();  //Invitar a uno mas
					break;
				}
				case 2:
				{
					setCancelarInvitacion();  //Invitacion cancelada
					break;
				}
				case 3:
				{
					System.out.println("");
					System.out.println(getConsulta());
					System.out.println("");
					break;
				}
				case 4:
				{
					System.out.println("Ha decidido abandonar el programa");
					//Salida del programa
					break;
				}
			}
		}while(opcion!=4);
	}
	
	public void fechaFiesta()
	{
		do {
		System.out.println("Introduzca el ANIO de la fiesta:");
		anio=peticion.nextInt();
		}while(anio<2000 || anio>2100);
		
		do {
		System.out.println("Introduzca el MES de la fiesta:");
		mes=peticion.nextInt();
		}while(mes<0 || mes>12);
		
		if(mes==1 || mes==3 | mes==5 || mes==7 || mes==8 || mes==10 || mes==12)
		{
			do {
			System.out.println("Introduzca el DIA de la fiesta:");
			dia=peticion.nextInt();
			}while(dia<1 || dia>31);
		}
		if(mes==4 || mes==6 | mes==9 || mes==11)
		{
			do {
			System.out.println("Introduzca el DIA de la fiesta:");
			dia=peticion.nextInt();
			}while(dia<1 || dia>30);
		}
		if(mes==2 && anio%4==0)
		{
			do {
			System.out.println("Introduzca el DIA de la fiesta:");
			dia=peticion.nextInt();
			}while(dia<1 || dia>29);
		}
		if(mes==2 && anio%4!=0)
		{
			do {
			System.out.println("Introduzca el DIA de la fiesta:");
			dia=peticion.nextInt();
			}while(dia<1 || dia>28);
		}
		do {
			System.out.println("Introduzca el HORA de la fiesta:");
			hora=peticion.nextInt();	
		}while(hora<0 || hora>23);

		do {
			System.out.println("Introduzca el MINUTO de la fiesta:");
			minuto=peticion.nextInt();	
		}while(minuto<0 || minuto>59);
		
		do {
			System.out.println("Elegir el tipo de fiesta:");
			for(int i=0;i<tipo.length;i++)
			{
				System.out.println("Introducir numero "+(i+1)+" para:"+tipo[i]);
			}
			opcion_vector=peticion.nextInt()-1;
		}while(opcion_vector<0 || opcion_vector>tipo.length);
		
		
		peticion.nextLine();
		System.out.println("Introduzcala direccion donde se celebrara la fiesta:");
		this.direccion=peticion.nextLine();
		
		LocalDateTime fecha= LocalDateTime.of(anio,mes,dia,hora,minuto,0,0023);
		DateTimeFormatter fechaConvencional= DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' HH:mm:ss a").withLocale(new Locale("es","ES"));
		System.out.println("");
		this.fecha=fecha.format(fechaConvencional);
	}
	public String getConsulta()
	{
		return "La fiesta del tipo: "+tipo[opcion_vector]+" tiene las siguientes caracteristicas: "+"\n"+"Fecha: "+this.fecha+"\n"+"Direccion: "+direccion+"\n"+"Maximo numero de invitados: "+max_invitados+"\n"+"Numero de invitados: "+invitados+"\n"+"Precio de la fiesta: "+getPrecioFiesta()+"€"; 
	}
	public void setInvitar()
	{
		//SE SUMARA UNA UNIDAD MAS AL CONTADOR DE INVITADOS
		invitados=invitados+1;
		if(invitados<=this.max_invitados) 
		{
		bocadillos=bocadillos+2;
		bebidas=bebidas+1;
		}
		else 
		{
		invitados=max_invitados;	
		}
	}
	public void setCancelarInvitacion()
	{
		//SE RESTARA UNA UNIDAD MAS AL CONTADOR DE INVITADOS
		if(invitados<=0)
		{
			//no hace nada
			invitados=0;
		}
		if(invitados>0)
		{
			invitados=invitados-1;	
			bocadillos=bocadillos-2;
			bebidas=bebidas-1;
		}
	}
	public double getPrecioFiesta()
	{
		double precioFiesta=0.0;
		precioFiesta=bocadillos*precioBocadillo+bebidas*precioBebida+precioEntrada*invitados;
		return precioFiesta;
	}
}
