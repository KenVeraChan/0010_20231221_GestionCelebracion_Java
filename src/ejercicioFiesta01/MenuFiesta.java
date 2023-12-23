package ejercicioFiesta01;
import java.util.Scanner;

public class MenuFiesta {

	public static void main(String[] args) {
	Scanner peticion= new Scanner(System.in);
	Fiesta invitando=new Fiesta();
	int invitados=0;
	int opcion=0;
	invitando.fechaFiesta();   //Ejecuta la fecha de la fiesta
	System.out.println("Introduzca el numero maximo de invitados");
	invitados=peticion.nextInt();
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
				invitando.setInvitar();  //Invitar a uno mas
				break;
			}
			case 2:
			{
				
				break;
			}
			case 3:
			{
				
				break;
			}
			case 4:
			{
				//Salida del programa
				break;
			}
		}
	}while(opcion!=4);
	}
}
