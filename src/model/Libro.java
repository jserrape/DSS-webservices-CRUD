package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Libro {
	private String id;
	private String titulo;
	private String autor;
	private String editorial;
	private String portada;

	public Libro(String id, String tit, String aut, String edit) {
		this.id = id;
		this.titulo = tit;
		this.autor = aut;
		this.editorial = edit;
	}

	public Libro() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String tit) {
		this.titulo = tit;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String aut) {
		this.autor = aut;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String edit) {
		this.editorial = edit;
	}

	public String getPortada() {
		return this.portada;
	}

	public void setPortada(String por) {
		this.portada = por;
	}
}
