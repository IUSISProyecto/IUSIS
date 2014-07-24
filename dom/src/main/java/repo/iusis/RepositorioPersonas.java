package repo.iusis;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.RegEx;
import org.apache.isis.applib.query.QueryDefault;

import dom.iusis.Clientes;
import dom.iusis.Peritos;
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
	public Clientes ingresarClientes(
	
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
	@Named("Observaciones")final @Optional String observacion,
	@Named("Estudio")final @Optional Estudios estudios,
	@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
	@Named("E-mail")final @Optional String email)

	{
		final Clientes cliente = container.newTransientInstance(Clientes.class);
	   
	    cliente.setDni(dni);
	    cliente.setNombre(nombre);
	    cliente.setApellido(apellido);
	    cliente.setDireccion(direccion);
	    cliente.setFechaNacimiento(fechaNacimiento);
	    cliente.setLocalidad(localidad);
	    cliente.setTelefono(telefono);
	    cliente.setCelular(celular);
	    cliente.setObservacion(observacion);
	    cliente.setEstudios(estudios);
	    cliente.setEmail(email);

	    container.persistIfNotAlready(cliente);
	    
		return cliente;
	}
	
	//======================================================
		//Defino nombre etiquetas para la clase
	    //@Optional nos define si el campo es obligatorio u opcional
		public Peritos ingresarPeritos(
		
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
		@Named("Tipo Perito")final String tipoperito,
		@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
		@Named("E-mail")final @Optional String email)
		
		{
			final Peritos perito = container.newTransientInstance(Peritos.class);
			perito.setDni(dni);
		    perito.setNombre(nombre);
		    perito.setApellido(apellido);
		    perito.setDireccion(direccion);
		    perito.setFechaNacimiento(fechaNacimiento);
		    perito.setLocalidad(localidad);
		    perito.setTelefono(telefono);
		    perito.setCelular(celular);
		    perito.setTipoPerito(tipoperito);
		    perito.setEmail(email);
		    container.persistIfNotAlready(perito);
		    
			return perito;
		}
		//Listo todos los clientes en el sistema
		public List<Personas> listarPersonas() {
	        return allMatches(QueryDefault.create(Personas.class, "listarTodasPersonas")); 
		}
		
		//Lleno el dropdown list segun el nombre del estudio
		@Hidden
	    public List<Estudios> autoComplete(final String searchPhrase) { 
	    	return allMatches(QueryDefault.create(Estudios.class, "estudiosPorNombre","nombre",searchPhrase));
	    }
	@javax.inject.Inject 
	    DomainObjectContainer container;
}
