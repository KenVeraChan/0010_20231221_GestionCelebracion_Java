package ejercicioFiesta01;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class MenuFiestaMultiple {

	FiestaMultiple fiestas[]= new FiestaMultiple[10]; 
	private static int numero_fiestas=0;
	private String tipo[]=new String[]{"Bautizo","Comunion","Cumpleaños","Boda","Aniversario","Despedida"};
	private int max_invitados=0;
	private int invitados=0;
	private String direccion="";
	private String fecha="";
	private int opcion_vector=0;
	private int dia=0;
	private int mes=0;
	private int anio=0;
	private int hora=0;
	private int minuto=0;
	
	Scanner peticion= new Scanner(System.in);
	
	public MenuFiestaMultiple()
	{
		
	}
	public void elegirFiesta()
	{
		int elegir=0;
		do {
			System.out.println("");
			System.out.println("Elegir una de las siguientes opciones:");
			System.out.println("1) Agregar una fiesta mas.");
			System.out.println("2) Eliminar fiesta.");
			System.out.println("3) Agregar o Eliminar invitados.");
			System.out.println("4) Esquema final fiestas.");
			System.out.println("5) Salir.");
			System.out.println("");
			elegir=peticion.nextInt();

			if(elegir>0 || elegir<6)
			{
				switch(elegir)
				{
					case 1:
					{	//AGREGAR UNA FIESTA NUEVA
						if(numero_fiestas<fiestas.length)
						{
							FiestaMultipleDatos();
							fiestas[numero_fiestas]=new FiestaMultiple(this.max_invitados,this.invitados,this.direccion,this.fecha,this.opcion_vector);
							numero_fiestas=numero_fiestas+1;
						}
						else
						{
							System.out.println("El numero de fiestas ha alcanzado el maximo");
						}
		
						break;
					}
					case 2:
					{	//ELIMINAR UNA FIESTA EXISTENTE
						System.out.println("Indicar la fiesta implicada:");
						int eligiendo=0;
						do{
							for(int i=0;i<numero_fiestas;i++)
							{
								System.out.println("Opcion "+(i)+": "+fiestas[i].getFiesta());
							}
							eligiendo=peticion.nextInt();
						}while(eligiendo<0 || eligiendo>numero_fiestas);
							fiestas[eligiendo]=new FiestaMultiple(0,0,"","",0);
							System.out.println("Fiesta Eliminada");
						break;
					}
					case 3:
					{   //AGREGAR O ELIMINAR INVITADOS
						System.out.println("Indicar la fiesta implicada:");
							int eligiendo=0;
							int eligiendodos=0;
							do{
								for(int i=0;i<numero_fiestas;i++)
								{
									if(fiestas[i].getFiesta().equals("")==false)
									{
									System.out.println("Opcion "+(i)+": "+fiestas[i].getFiesta());
									}
									else
									{
										//No hace nada
									}
								}
								eligiendo=peticion.nextInt();
							}while(eligiendo<0 || eligiendo>numero_fiestas);
							do{
								System.out.println("Indicar si es agregar invitado o eliminar (Eliminar=0 y Agregar=1)");
								eligiendodos=peticion.nextInt();
							}while(eligiendodos!=0 && eligiendodos!=1);
							
							if(eligiendodos==0)
							{
							fiestas[eligiendo].setCancelarInvitacion();
							System.out.println("Invitacion cancelada");
							}
							if(eligiendodos==1)
							{
							fiestas[eligiendo].setInvitar();
							System.out.println("Invitado agregado");
							}
						break;
					}
					case 4:
					{	//ESQUEMA FINAL DE LAS FIESTAS	
						for(int i=0;i<numero_fiestas;i++)
						{
							System.out.println("");
							System.out.println("Fiesta "+(i+1)+": \n"+fiestas[i].getConsulta());
							System.out.println("");
						}
						break;
					}
					case 5:
					{	//SALIR
						System.out.println("Ha decidido salir del programa");
						break;
					}
					default:
					{
						break;
					}
				}
			}
			else
			{
				System.out.println("No ha elegido correctamente");
			}
		}while(elegir!=5);
	}
	public void setNumeroFiestas(int numero)
	{
		numero_fiestas=numero;
	}
	public void FiestaMultipleDatos()
	{
			do {
			System.out.println("Introduzca el ANIO de la fiesta:");
			this.anio=peticion.nextInt();
			}while(this.anio<2000 || this.anio>2100);
			
			do {
			System.out.println("Introduzca el MES de la fiesta:");
			this.mes=peticion.nextInt();
			}while(this.mes<0 || this.mes>12);
			
			if(this.mes==1 || this.mes==3 | this.mes==5 || this.mes==7 || this.mes==8 || this.mes==10 || this.mes==12)
			{
				do {
				System.out.println("Introduzca el DIA de la fiesta:");
				this.dia=peticion.nextInt();
				}while(this.dia<1 || this.dia>31);
			}
			if(this.mes==4 || this.mes==6 | this.mes==9 || this.mes==11)
			{
				do {
				System.out.println("Introduzca el DIA de la fiesta:");
				this.dia=peticion.nextInt();
				}while(this.dia<1 || this.dia>30);
			}
			if(this.mes==2 && this.anio%4==0)
			{
				do {
				System.out.println("Introduzca el DIA de la fiesta:");
				this.dia=peticion.nextInt();
				}while(dia<1 || dia>29);
			}
			if(this.mes==2 && this.anio%4!=0)
			{
				do {
				System.out.println("Introduzca el DIA de la fiesta:");
				this.dia=peticion.nextInt();
				}while(this.dia<1 || this.dia>28);
			}
			do {
				System.out.println("Introduzca el HORA de la fiesta:");
				this.hora=peticion.nextInt();	
			}while(this.hora<0 || this.hora>23);
	
			do {
				System.out.println("Introduzca el MINUTO de la fiesta:");
				this.minuto=peticion.nextInt();	
			}while(this.minuto<0 || this.minuto>59);
			
			do {
				System.out.println("Elegir el TIPO de fiesta:");
				for(int i=0;i<tipo.length;i++)
				{
					System.out.println("Introducir numero "+(i+1)+" para:"+tipo[i]);
				}
				opcion_vector=peticion.nextInt()-1;
			}while(opcion_vector<0 || opcion_vector>tipo.length);
			
			do {
			System.out.println("Introduzca el numero maximo de invitados");
			this.max_invitados=peticion.nextInt();
			}while(this.max_invitados<0 || this.max_invitados>30);
			
			peticion.nextLine();
			System.out.println("Introduzcala direccion donde se celebrara la fiesta:");
			this.direccion=peticion.nextLine();
			
			LocalDateTime fecha= LocalDateTime.of(anio,mes,dia,hora,minuto,0,0023);
			DateTimeFormatter fechaConvencional= DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' HH:mm:ss a").withLocale(new Locale("es","ES"));
			System.out.println("");
			this.fecha=fecha.format(fechaConvencional);
	}

}


class FiestaMultiple{
	
	Scanner peticion= new Scanner(System.in);
	private String tipo[]=new String[]{"Bautizo","Comunion","Cumpleaños","Boda","Aniversario","Despedida"};
	private int max_invitados=0;
	private int invitados=0;
	private String direccion="";
	private String fecha="";
	private int opcion_vector=0;
	private int bocadillos=0;
	private int bebidas=0;
	private double precioEntrada=5;
	private double precioBocadillo=3;
	private double precioBebida=2;
	
	public FiestaMultiple(int max_invitados,int invitados,String direccion,String fecha, int opcion_vector)
	{
		this.max_invitados=max_invitados;
		this.invitados=invitados;
		this.direccion=direccion;
		this.fecha=fecha;
		this.opcion_vector=opcion_vector;
	}
	public int getMax_invitados() {
		return max_invitados;
	}
	public int getInvitados() {
		return invitados;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getFecha() {
		return fecha;
	}
	public int getOpcion_vector() {
		return opcion_vector;
	}

	public String getFiesta()
	{
		return this.tipo[opcion_vector];
	}
	public void setInvitar()
	{
		//SE SUMARA UNA UNIDAD MAS AL CONTADOR DE INVITADOS
		this.invitados=this.invitados+1;
		if(invitados<=this.max_invitados) 
		{
		this.bocadillos=this.bocadillos+2;
		this.bebidas=this.bebidas+1;
		}
		else 
		{
		this.invitados=this.max_invitados;	
		}
	}
	public void setCancelarInvitacion()
	{
		//SE RESTARA UNA UNIDAD MAS AL CONTADOR DE INVITADOS
		if(this.invitados<=0)
		{
			//no hace nada
			this.invitados=0;
		}
		if(this.invitados>0)
		{
			this.invitados=this.invitados-1;	
			this.bocadillos=this.bocadillos-2;
			this.bebidas=this.bebidas-1;
		}
	}
	public double getPrecioFiesta()
	{
		double precioFiesta=0.0;
		precioFiesta=bocadillos*precioBocadillo+bebidas*precioBebida+precioEntrada*invitados;
		return precioFiesta;
	}
	public String getConsulta()
	{
		return "La fiesta del tipo: "+tipo[opcion_vector]+" tiene las siguientes caracteristicas: "+"\n"+"Fecha: "+this.fecha+"\n"+"Direccion: "+direccion+"\n"+"Maximo numero de invitados: "+max_invitados+"\n"+"Numero de invitados: "+invitados+"\n"+"Precio de la fiesta: "+getPrecioFiesta()+"€"; 
	}
}
