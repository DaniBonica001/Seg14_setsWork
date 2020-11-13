package ui;
import model.MathApp;
import java.util.*;
public class Main{
	public static MathApp objMathApp;
	public final static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		createMathApp();
		boolean menu=true;
		while (menu){
			System.out.println("Seleccione una opcion:"+
								"\n1.Crear un conjunto"+
								"\n2.Remover un conjunto"+
								"\n3.Anadir un elemento a un conjunto"+
								"\n4.Remover elemento de un conjunto"+
								"\n5.Union de dos conjuntos"+
								"\n6.Diferencia de dos conjuntos"+
								"\n7.Interseccion entre dos conjuntos"+
								"\n8.Diferencia simétrica entre conjuntos"+
								"\n9.Ver la informacion de un conjunto"+
								"\n10.Ver la informacion de todos los conjuntos"+
								"\n0.Salir");
			int option=lector.nextInt();
			lector.nextLine();

			switch(option){
				case 1: addSet();
				break;

				case 2: removeSet();
				break;

				case 3: addElementToSet();
				break;

				case 4: removeElementFromSet();
				break;

				case 5: union();
				break;

				case 6: difference();
				break;

				case 7: intersection();
				break;

				case 8: symmetricDifference();
				break;

				case 9: showInfoSet();
				break;

				case 10: System.out.println(objMathApp.showInfoSet());
				break;

				case 0:
				menu=false;
				System.out.println("¡Bye!");
				break;
			}

		}
	}

	public static void createMathApp(){
		objMathApp= new MathApp();
	}

	public static void addSet(){
		System.out.println("Ingrese el nombre del conjunto");
		String name=lector.nextLine();

		//String message="";
		objMathApp.addSet(name);
		//System.out.println(message);
	}

	public static void removeSet(){
		System.out.println("Ingrese el nombre del conjunto que desea borrar");
		String name=lector.nextLine();

		//String message="";
		objMathApp.removeSet(name);
		//System.out.println(message);
	}

	public static void addElementToSet(){
		System.out.println("Ingrese el nombre del conjunto donde desea añadir el elemento");
		String name=lector.nextLine();

		System.out.println("Ingrese el numero a añadir");
		int element=lector.nextInt();
		lector.nextLine();

		//String message="";
		objMathApp.addElementToSet(name,element);
		//System.out.println(message);
	}


	public static void removeElementFromSet(){
		System.out.println("Ingrese el nombre del conjunto donde desea eliminar el elemento");
		String name=lector.nextLine();

		System.out.println("Ingrese el numero a eliminar");
		int element=lector.nextInt();
		lector.nextLine();

		//String message="";
		objMathApp.removeElementFromSet(name,element);
		//System.out.println(message);
	}

	public static void union(){
		System.out.println("Ingrese el nombre del conjunto #1 que desea unir");
		String name1=lector.nextLine();

		System.out.println("Ingrese el nombre del conjunto #2 que desea unir");
		String name2=lector.nextLine();

		System.out.println("Ingrese el nombre del nuevo conjunto");
		String newName=lector.nextLine();

		objMathApp.union(name1,name2,newName);
	}
	
	public static void difference(){
		System.out.println("Ingrese el nombre del conjunto #1 que desea restar");
		String name1=lector.nextLine();

		System.out.println("Ingrese el nombre del conjunto #2 que desea restar");
		String name2=lector.nextLine();

		System.out.println("Ingrese el nombre del nuevo conjunto");
		String newName=lector.nextLine();

		objMathApp.difference(name1,name2,newName);
	}

	public static void intersection(){
		System.out.println("Ingrese el nombre del conjunto #1 que desea aplicar la interseccion");
		String name1=lector.nextLine();

		System.out.println("Ingrese el nombre del conjunto #2 que desea aplicar la interseccion");
		String name2=lector.nextLine();

		System.out.println("Ingrese el nombre del nuevo conjunto");
		String newName=lector.nextLine();

		objMathApp.intersection(name1,name2,newName);
	}

	public static void symmetricDifference(){
		System.out.println("Ingrese el nombre del conjunto #1 que desea aplicar la diferencia simetrica");
		String name1=lector.nextLine();

		System.out.println("Ingrese el nombre del conjunto #2 que desea aplicar la diferencia simetrica");
		String name2=lector.nextLine();

		System.out.println("Ingrese el nombre del nuevo conjunto");
		String newName=lector.nextLine();

		objMathApp.symmetricDifference(name1,name2,newName);
	}	

	public static void showInfoSet(){
		System.out.println("Ingrese el nombre del conjunto que desea ver su informacion");
		String name=lector.nextLine();
		String message="";
		message=objMathApp.showInfoSet(name);
		System.out.println(message);
	}
	
}
