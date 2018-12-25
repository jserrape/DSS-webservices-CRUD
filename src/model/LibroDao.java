package model;

import java.util.HashMap;
import java.util.Map;

import model.Libro;

public enum LibroDao {
	INSTANCE;

	private Map<String, Libro> content = new HashMap<>();

	private LibroDao() {
		Libro l1 = new Libro("1", "Canción de hielo y fuego", "George R. R. Martin", "HarperCollins");
		this.content.put(l1.getId(), l1);
		Libro l2 = new Libro("2", "Choque de reyes", "George R. R. Martin", "Bantam Spectra");
		this.content.put(l2.getId(), l2);
		Libro l3 = new Libro("3", "Sueño de primavera", "George R. R. Martin", "Bantam Spectra");
		this.content.put(l3.getId(), l3);
	}

	public Map<String, Libro> getModel() {
		return content;
	}
}