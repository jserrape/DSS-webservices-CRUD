package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/libros")
public class RecursoLibros {
	@Context
	UriInfo uriInfo;

	@Context
	Request request;

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Libro> getLibros() {
		List<Libro> lista = new ArrayList<Libro>();
		lista.addAll(LibroDao.INSTANCE.getModel().values());
		return lista;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Libro> getLibros2() {
		List<Libro> lista = new ArrayList<Libro>();
		lista.addAll(LibroDao.INSTANCE.getModel().values());
		return lista;
	}

	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(LibroDao.INSTANCE.getModel().size());
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void crearLibro(@FormParam("id") String id, @FormParam("titulo") String tit, @FormParam("autor") String aut,
			@FormParam("editorial") String edit, @FormParam("portada") String img,
			@Context HttpServletResponse servletResponse) throws IOException {
		Libro libro=new Libro(id, tit, aut, edit);
		if (img != "") {
			libro.setPortada(img);
		}
		LibroDao.INSTANCE.getModel().put(id, libro);
		servletResponse.sendRedirect("../nuevolibro.html");
	}

	@Path("{libro}")
	public RecursoLibro getBook(@PathParam("libro") String id) {
		return new RecursoLibro(uriInfo, request, id);
	}

}
