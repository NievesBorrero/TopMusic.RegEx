package regExp;

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
	private String anio;

	/**
	 * Constructor
	 * 
	 * @param titulo
	 * @param artistaOgrupo
	 * @param anio
	 */
	public Cancion(String titulo, String artistaOgrupo, String anio) {
		this.titulo = titulo;
		this.artistaOgrupo = artistaOgrupo;
		this.anio = anio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anio == null) ? 0 : anio.hashCode());
		result = prime * result
				+ ((artistaOgrupo == null) ? 0 : artistaOgrupo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	/**
	 * Crea una nueva canción si los argumentos dados cumplen las condiciones, de lo contrario devuelve null.
	 * @param titulo
	 * @param artistaOgrupo
	 * @param anio
	 * @return
	 */

	static Cancion getInstance(String titulo, String artistaOgrupo,String anio) {
		// el matches() de la clase String indica si la cadena coincide con la
		// expresion que le pasamos como argumento.
		if (titulo.matches("[^\\s]{1,}") && artistaOgrupo.matches("[^\\s]{1,}")
				&& anio.matches("1[89]\\d{2}|200\\d|201[0-7]"))
			return new Cancion(titulo, artistaOgrupo, anio);
		
		return null;

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
		if (anio == null) {
			if (other.anio != null)
				return false;
		} else if (!anio.equals(other.anio))
			return false;
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
