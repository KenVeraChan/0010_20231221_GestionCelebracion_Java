package ejercicioFiesta01;
import java.util.Scanner;

public class MenuFiesta {

	public static void main(String[] args) {
		int eleccion=0;
		Scanner decision= new Scanner(System.in);
		do {
			System.out.println("Elige un modo de ejecucion (1-2-3):");
			System.out.println("Ejecutar el MODO 1");
			System.out.println("Ejecutar el MODO 2");
			System.out.println("Salir");
			eleccion=decision.nextInt();
		}while(eleccion!=1 && eleccion!=2 && eleccion!=3);
		if(eleccion==1)
		{
			System.out.println("Ejecutando el MODO 1");
			Fiesta invitando=new Fiesta();
			invitando.presentacion();
		}
		if(eleccion==2)
		{
			System.out.println("Ejecutando el MODO 2");
			MenuFiestaMultiple invitando=new MenuFiestaMultiple();
			invitando.elegirFiesta();
		}
		if(eleccion==3)
		{
			System.out.println("Fin del programa");
		}
		decision.close();
	}
}
