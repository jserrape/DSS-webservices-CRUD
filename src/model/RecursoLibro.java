package model;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class RecursoLibro {
	@Context
	UriInfo uri;

	@Context
	Request request;
	String id;

	public RecursoLibro(UriInfo uri, Request request, String id) {
		this.uri = uri;
		this.request = request;
		this.id = id;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public Libro getLibro2() {
		return LibroDao.INSTANCE.getModel().get(id);
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Libro getLibro() {
		return LibroDao.INSTANCE.getModel().get(id);
	}

	@DELETE
	public void borrarLibro() {
		LibroDao.INSTANCE.getModel().remove(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void aniadirLibro(JAXBElement<Libro> libro) {
		if (LibroDao.INSTANCE.getModel().containsKey(libro.getValue().getId())) {
			LibroDao.INSTANCE.getModel().replace(libro.getValue().getId(), libro.getValue());
		} else {
			LibroDao.INSTANCE.getModel().put(libro.getValue().getId(), libro.getValue());
		}
	}

}