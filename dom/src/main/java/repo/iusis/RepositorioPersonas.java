package repo.iusis;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Hidden;
//import org.apache.isis.applib.annotation.Bookmarkable;
//import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.RegEx;
//import org.datanucleus.store.types.backed.List;
//import java.util.ArrayList;
import org.apache.isis.applib.query.QueryDefault;

import dom.iusis.Personas;
import dom.iusis.Estudios;

@Named("Administrar Personas")
public class RepositorioPersonas extends AbstractFactoryAndRepository {

	public String getId() {
        return "Personas";
    }
//Cambio icono
    public String iconName() {
        return "clientes";
    }
	//Defino nombre etiquetas para la clase
    //@Optional nos define si el campo es obligatorio u opcional
	public Personas ingresarPersonas(
	
	@Named("DNI")final String dni ,
	@RegEx(validation = "[A-Za-z ]+")
	@Named("Nombre")final String nombre,
	@RegEx(validation = "[A-Za-z ]+")
	@Named("Apellido")final String apellido,
	@Named("Direccion")final String direccion,
	@Named("Fecha Nacimiento")final Date fechaNacimiento,
	@RegEx(validation = "[A-Za-z ]+")
	@Named("Localidad")final String localidad,
	@Named("Telefono")final @Optional String telefono,
	@Named("Celular")final @Optional String celular,
	@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
	@Named("E-mail")final @Optional String email,
	@Named("Observaciones")final @Optional String observacion,
	@Named("Estudio")final @Optional Estudios estudio)

	{
		final Personas persona = container.newTransientInstance(Personas.class);
	   
	    persona.setDni(dni);
	    persona.setNombre(nombre);
	    persona.setApellido(apellido);
	    persona.setDireccion(direccion);
	    persona.setFechaNacimiento(fechaNacimiento);
	    persona.setLocalidad(localidad);
	    persona.setTelefono(telefono);
	    persona.setCelular(celular);
	    persona.setEmail(email);
	    persona.setObservacion(observacion);
	    persona.setEstudios(estudio);
	    
	    container.persistIfNotAlready(persona);
	    
		return persona;
	}
	

	@javax.inject.Inject 
    DomainObjectContainer container;
	
	//Listo todos los clientes en el sistema
	public List<Personas> listarPersonas() {
        return allMatches(QueryDefault.create(Personas.class, "listarTodasPersonas"));
	}
	//Lleno el dropdown list segun el nombre del estudio
	@Hidden
    public List<Estudios> autoComplete(final String searchPhrase) { 
    	return allMatches(QueryDefault.create(Estudios.class, "estudiosPorNombre","nombre",searchPhrase));
    }
	
}
