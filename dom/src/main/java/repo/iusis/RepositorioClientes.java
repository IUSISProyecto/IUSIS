package repo.iusis;

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
import dom.iusis.Clientes;
import dom.iusis.Estudios;

@Named("Administrar Clientes")
public class RepositorioClientes extends AbstractFactoryAndRepository {

	public String getId() {
        return "Clientes";
    }
//Cambio icono
    public String iconName() {
        return "clientes";
    }
	//Defino nombre etiquetas para la clase
    //@Optional nos define si el campo es obligatorio u opcional
	public Clientes ingresarClientes(
	
	@Named("id de Clientes")final String idCliente ,
	@RegEx(validation = "[A-Za-z ]+")
	@Named("Nombre")final String nombre,
	@RegEx(validation = "[A-Za-z ]+")
	@Named("Apellido")final String apellido,
	@Named("Direccion")final String direccion,
	@RegEx(validation = "[A-Za-z ]+")
	@Named("Localidad")final String localidad,
	@Named("Telefono")final @Optional String telefono,
	@Named("Celular")final @Optional String celular,
	@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
	@Named("E-mail")final @Optional String email,
	@Named("Observaciones")final @Optional String observacion,
	@Named("Estudio")final @Optional Estudios estudio)
	
	//@Named("Direccion Legal") @Optional final Date fechaDeExpiracion,
	//@Named("Direccion Real")final String direccionMac)
	{
		final Clientes cliente = container.newTransientInstance(Clientes.class);
	   
	    cliente.setIdCliente(idCliente);
	    cliente.setNombre(nombre);
	    cliente.setApellido(apellido);
	    cliente.setDireccion(direccion);
	    cliente.setLocalidad(localidad);
	    cliente.setTelefono(telefono);
	    cliente.setCelular(celular);
	    cliente.setEmail(email);
	    cliente.setObservacion(observacion);
	    cliente.setEstudios(estudio);
	    
	    container.persistIfNotAlready(cliente);
	    
		return cliente;
	}
	

	@javax.inject.Inject 
    DomainObjectContainer container;
	
	//Listo todos los clientes en el sistema
	public List<Clientes> listarClientes() {
        return allMatches(QueryDefault.create(Clientes.class, "listarTodosClientes"));
	}
	//Lleno el dropdown list segun el nombre del estudio
	@Hidden
    public List<Estudios> autoComplete(String searchPhrase) { 
    	return allMatches(QueryDefault.create(Estudios.class, "estudiosPorNombre","nombre",searchPhrase));
    }
	
}
