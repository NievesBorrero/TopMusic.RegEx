package regExp;

import java.util.*;

/**
 * 7. TopMusic. Implementa un programa que gestione una lista de las canciones
 * más escuchadas. El usuario podrá: a. Añadir una canción (en una posición) al
 * TopMusic. b. Sacar un elemento del TopMusic. c. Subir un puesto en el
 * TopMusic. d. Bajar un puesto en el TopMusic. e. Mostrar la lista TopMusic. f.
 * Mostrar la canción más escuchada. Sobre la canción se almacenará el título,
 * artista o grupo y año de grabación.
 * 
 * @author Nieves Borrero
 * @version 1.0
 */
public class TopMusic{
	private ArrayList<Cancion> top;
	
	/**
	 * Constructor que crea una lista vacía
	 */
	TopMusic() {
		setTop(new ArrayList<Cancion>());
	}

	private ArrayList<Cancion> getTop() {
		return top;
	}

	private void setTop(ArrayList<Cancion> top) {
		this.top = top;
	}

	/**
	 * Añade una nueva canción al TopMusic en el index señalado.
	 * 
	 * @param index
	 * @param cancion
	 */
	boolean add(int index, String titulo, String artista, int fecha) {
		Cancion cancion=Cancion.getInstance(titulo, artista, fecha);
		if (!esValido(index - 1))
			return false;
		if (getTop().contains(cancion)||cancion==null)
			return false;
		getTop().add(index - 1, cancion);
		return true;
	}

	/**
	 * Añade una cancion al final
	 * 
	 * @param cancion
	 */
	public boolean add(String titulo, String artista, int fecha) {
		Cancion cancion=Cancion.getInstance(titulo, artista, fecha);
		if(cancion==null)
			return false;
		getTop().add(cancion);
		return true;
	}

	/**
	 * Comprueba que el índice introducido sea válido
	 * 
	 * @param index
	 * @return boolean
	 */
	boolean esValido(int index) {
		if (index < 0 || index > getTop().size())
			return false;
		return true;
	}

	/**
	 * Elimina un elemento del TopMusic
	 * 
	 * @param index
	 * @return true o false, en función de si ha sido posible eliminar el
	 *         elemento del index dado por parámetro o no.
	 */
	boolean remove(int index) {
		if (!esValido(index - 1))
			return false;
		getTop().remove(index - 1);
		return true;
	}

	/**
	 * Sube la posición en el top (baja posición de índice)
	 * 
	 * @param index
	 * @return true si modifica la posicion o false, si no puede porque el
	 *         índice introducido como parámetro no es válido.
	 */
	boolean up(int index) {
		if (!esValido(index - 1))
			return false;
		if (index - 2 < 0) // Si al subir la posición se sale de rango
			return false;
		getTop().add(index - 2, getTop().remove(index - 1));
		// Añade en una posición anterior, la canción con el índice introducido
		// borrando esa canción del índice en el que estaba.
		return true;
	}

	/**
	 * Baja la posición en el top (sube la posición de índice)
	 * 
	 * @param index
	 * @return true si modifica la posicion o false, si no puede porque el
	 *         índice introducido como parámetro no es válido.
	 */
	boolean down(int index) {
		if (!esValido(index - 1))
			return false;
		if (index > getTop().size() - 1)
			return false; // Si al bajar la posición se sale de rango
		getTop().add(index, getTop().remove(index - 1));
		// Añade en una posición posterior(el índice introducido le está dando
		// la posición siguiente), borrando
		// esa canción del índice en el que estaba.
		return true;
	}

	/**
	 * Saca fuera del top 10 una canción
	 * 
	 * @param index
	 */
	boolean pullOut(int index) {
		if (!esValido(index - 1) || top.size() < 10)
			return false;
		top.add(10, getTop().remove(index - 1)); // Añade en una posición
													// siguiente al top10,
													// borrando la
													// canción de su lugar.
		return true;
	}

	/**
	 * devuelve la canción con la primera posición.
	 * 
	 * @return una canción
	 */
	Cancion top() {
		if (isEmpty())
			return null;
		return getTop().get(0);
	}

	/**
	 * Verifica si la lista esta vacía o no
	 * 
	 * @return boolean
	 */
	boolean isEmpty() {
		return top.isEmpty();
	}


	@Override
	public String toString() {
		if (top.isEmpty())
			return "El Top Music esta vacio";
		StringBuilder cadena = new StringBuilder();
		int tamanno = 10;
		if (getTop().size() < 10)
			tamanno = getTop().size();
		for (int i = 0; i < tamanno; i++) {
			cadena.append("(" + (i + 1) + ")" + getTop().get(i) + "\n");
		}
		return "TOPMUSIC:\n" + cadena;

	}

}
