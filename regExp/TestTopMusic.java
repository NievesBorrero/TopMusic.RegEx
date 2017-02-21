package estructurasIII.regExp;

/**
 * @author Nieves Borrero
 * @version 1.0
 */
import utiles.*;

public class TestTopMusic {
	static TopMusic topMusic = new TopMusic();

	public static void main(String[] args) {
		Menu menu = new Menu("OPCIONES:", new String[] { "añadir cancion",
				"Mostrar lista", "subir puesto de cancion",
				"Bajar puesto de cancion", "Sacar del Top 10",
				"Mostrar cancion en el puesto numero 1",
				"Eliminar una cancion", "salir" });
		deseaPregenerar();
		int opcion;
		do {
			switch (opcion = menu.gestionar()) {
			case 1:
				annadirCancion();
				break;
			case 2:
				mostrarTop();
				break;
			case 3:
				subirPosicion();
				break;
			case 4:
				bajarPosicion();
				break;
			case 5:
				sacarDelTop();
				break;
			case 6:
				topCancion();
				break;
			case 7:
				EliminarCancion();
				break;
			case 8:
				salir();
				break;
			default:
				System.out.println("Opcion incorrecta"); break;
			}
		} while (opcion != menu.getSalir());
	}// main

	private static void salir() {
		System.out.println("Hasta otra");
	}

	private static void EliminarCancion() {
		if (!isEmpty()) {
			if (!topMusic.remove(Teclado
					.leerEntero("Introduce el indice de la cancion")))
				System.out.println("No se ha podido eliminar");
			else
				System.out.println("Eliminada");
		}

	}

	private static void topCancion() {
		if (!isEmpty())
			System.out.println(topMusic.top());
	}

	private static void sacarDelTop() {
		if (!isEmpty()) {
			if (!topMusic.pullOut(Teclado.leerEntero("Introduce el indice de la cancion")))
				System.out.println("No se ha podido sacar del top");
			else
				System.out.println("La canción ha salido del top10");
		}
	}

	private static void bajarPosicion() {
		if (!isEmpty()) {
			if (!topMusic.down(Teclado.leerEntero("Introduce el indice de la cancion")))
				System.out.println("Imposible bajar de posicion");
			else
				System.out.println("La canción ha bajado de posicion");
		}

	}

	private static void subirPosicion() {
		if (!isEmpty()) {
			if (!topMusic.up(Teclado.leerEntero("Introduce el indice de la cancion")))
				System.out.println("Imposible subir de posicion");
			else
				System.out.println("La canción ha subido de posicion");
		}
	}

	private static boolean isEmpty() {
		if (topMusic.isEmpty()) {
			System.out.println("El top 10 esta vacio");
			return true;
		}
		return false;
	}

	private static void mostrarTop() {
		System.out.println(topMusic);
	}

	private static void annadirCancion() {
		int posicion;
		if (topMusic.isEmpty()) {
			if(topMusic.add(Teclado.leerCadena("Titulo:"), Teclado.leerCadena("Artista o grupo:"), Teclado.leerCadena("año:")))
				System.out.println("Cancion añadida a la lista");
			else
			System.out.println("Imposible añadir cancion");
		} 
		else {
			posicion = Teclado.leerEntero("Introduce la posicion de la cancion a añadir:");
			
			if (indiceEsValido(posicion)){
				if(topMusic.add((posicion),Teclado.leerCadena("Titulo:"), Teclado.leerCadena("Artista o grupo:"), Teclado.leerCadena("año:")))
					System.out.println("Cancion añadida a la lista");
				else
				System.out.println("Imposible añadir cancion");
			}
			
		}
	}

	private static boolean indiceEsValido(int posicion) {
		if (!topMusic.esValido(posicion - 1)) {
			System.out.println("Imposible añadir cancion");
			return false;
		}
		return true;
	}

	/**
	 * Pregunta al usuario si desea obtener un top music pregenerado
	 */
	private static void deseaPregenerar() {
		if (Teclado.deseaContinuar("Desea pregenerar la lista?")) {
			pregenerar();
		}
	}

	/**
	 * Añade canciones ya creadas al topmusic
	 */
	static void pregenerar() {
		topMusic.add("Californication", "Red Hot Chili Peppers",
				"1999");
		topMusic.add("Thunderstruck", "AC/DC", "1990");
		topMusic.add("American Woman", "Lenny Kravitz", "1999");
		topMusic.add("The Trooper", "Iron Maiden", "1983");
		topMusic.add("I Wish I Had an Angel", "Nightwish", "2004");
		topMusic.add("So Payaso", "Extremoduro", "1996");
		topMusic.add("Corazon de Mimbre", "Marea", "2000");
		topMusic.add("Estampida", "Ska-p", "2002");
		topMusic.add("Hit the Road Jack", "Ray Charles", "1961");
		topMusic.add("House of the Rising Sun", "White Buffalo",
				"2011");
		topMusic.add("La Danza del Fuego", "Mago de Oz", "2000");
		topMusic.add("Alas de Cristal", "Avalanch", "2005");
		topMusic.add("Feo, Fuerte y Formal", "Loquillo", "2006");
	}
}
