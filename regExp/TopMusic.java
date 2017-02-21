package estructurasIII.regExp;

import java.util.*;

/**
 * 7. TopMusic. Implementa un programa que gestione una lista de las canciones
 * m�s escuchadas. El usuario podr�: a. A�adir una canci�n (en una posici�n) al
 * TopMusic. b. Sacar un elemento del TopMusic. c. Subir un puesto en el
 * TopMusic. d. Bajar un puesto en el TopMusic. e. Mostrar la lista TopMusic. f.
 * Mostrar la canci�n m�s escuchada. Sobre la canci�n se almacenar� el t�tulo,
 * artista o grupo y a�o de grabaci�n.
 * 
 * @author Nieves Borrero
 * @version 1.0
 */
public class TopMusic{
	private ArrayList<Cancion> top;
	
	/**
	 * Constructor que crea una lista vac�a
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
	 * A�ade una nueva canci�n al TopMusic en el index se�alado.
	 * 
	 * @param index
	 * @param cancion
	 */
	boolean add(int index, String titulo, String artista, String fecha) {
		Cancion cancion=Cancion.getInstance(titulo, artista, fecha);
		if (!esValido(index - 1))
			return false;
		if (getTop().contains(cancion)||cancion==null)
			return false;
		getTop().add(index - 1, cancion);
		return true;
	}

	/**
	 * A�ade una cancion al final
	 * 
	 * @param cancion
	 */
	public boolean add(String titulo, String artista, String fecha) {
		Cancion cancion=Cancion.getInstance(titulo, artista, fecha);
		if(cancion==null)
			return false;
		getTop().add(cancion);
		return true;
	}

	/**
	 * Comprueba que el �ndice introducido sea v�lido
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
	 * @return true o false, en funci�n de si ha sido posible eliminar el
	 *         elemento del index dado por par�metro o no.
	 */
	boolean remove(int index) {
		if (!esValido(index - 1))
			return false;
		getTop().remove(index - 1);
		return true;
	}

	/**
	 * Sube la posici�n en el top (baja posici�n de �ndice)
	 * 
	 * @param index
	 * @return true si modifica la posicion o false, si no puede porque el
	 *         �ndice introducido como par�metro no es v�lido.
	 */
	boolean up(int index) {
		if (!esValido(index - 1))
			return false;
		if (index - 2 < 0) // Si al subir la posici�n se sale de rango
			return false;
		getTop().add(index - 2, getTop().remove(index - 1));
		// A�ade en una posici�n anterior, la canci�n con el �ndice introducido
		// borrando esa canci�n del �ndice en el que estaba.
		return true;
	}

	/**
	 * Baja la posici�n en el top (sube la posici�n de �ndice)
	 * 
	 * @param index
	 * @return true si modifica la posicion o false, si no puede porque el
	 *         �ndice introducido como par�metro no es v�lido.
	 */
	boolean down(int index) {
		if (!esValido(index - 1))
			return false;
		if (index > getTop().size() - 1)
			return false; // Si al bajar la posici�n se sale de rango
		getTop().add(index, getTop().remove(index - 1));
		// A�ade en una posici�n posterior(el �ndice introducido le est� dando
		// la posici�n siguiente), borrando
		// esa canci�n del �ndice en el que estaba.
		return true;
	}

	/**
	 * Saca fuera del top 10 una canci�n
	 * 
	 * @param index
	 */
	boolean pullOut(int index) {
		if (!esValido(index - 1) || top.size() < 10)
			return false;
		top.add(10, getTop().remove(index - 1)); // A�ade en una posici�n
													// siguiente al top10,
													// borrando la
													// canci�n de su lugar.
		return true;
	}

	/**
	 * devuelve la canci�n con la primera posici�n.
	 * 
	 * @return una canci�n
	 */
	Cancion top() {
		if (isEmpty())
			return null;
		return getTop().get(0);
	}

	/**
	 * Verifica si la lista esta vac�a o no
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
