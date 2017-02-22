package regExp;

import java.util.Calendar;

/**
 * Sobre la canción se almacenará el título, artista o grupo y año de grabación.
 * 7.3
 * 
 * @author Nieves Borrero.
 * @version 1.0
 */
public class Cancion {
	private String titulo;
	private String artistaOgrupo;
	private int anio;
	private static final Calendar fecha= Calendar.getInstance();
	private static final int anioActual= fecha.get(Calendar.YEAR);

	/**
	 * Constructor
	 * 
	 * @param titulo
	 * @param artistaOgrupo
	 * @param anio
	 */
	public Cancion(String titulo, String artistaOgrupo, int anio) {
		this.titulo = titulo;
		this.artistaOgrupo = artistaOgrupo;
		this.anio = anio;
	}


	/**
	 * Crea una nueva canción si los argumentos dados cumplen las condiciones, de lo contrario devuelve null.
	 * @param titulo
	 * @param artistaOgrupo
	 * @param anio
	 * @return
	 */

	static Cancion getInstance(String titulo, String artistaOgrupo,int anio) {
		// el matches() de la clase String indica si la cadena coincide con la
		// expresion que le pasamos como argumento.
		if (titulo.matches("^[^\\s].*") && artistaOgrupo.matches("^[^\\s].*")&& anio>1900 && anio<=anioActual)
			return new Cancion(titulo, artistaOgrupo, anio);
		// anio.matches("19\\d{2}|200\\d|201[0-7]")
			else return null;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		if (anio == 0) {
			if (other.anio != 0)
				return false;}
		if (artistaOgrupo == null) {
			if (other.artistaOgrupo != null)
				return false;
		} else if (!artistaOgrupo.equalsIgnoreCase(other.artistaOgrupo))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equalsIgnoreCase(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "titulo:" + titulo + ", artista/grupo:" + artistaOgrupo
				+ ", año:" + anio;
	}

}
