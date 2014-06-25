package repo.iusis;


import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Named;

import dom.iusis.Clientes;

@Named("Administrar Clientes")
public class RepositorioClientes extends AbstractFactoryAndRepository {


	public String getId() {
        return "Netbook";
    }
//Cambio icono
    public String iconName() {
        return "clientes";
    }
	//Defino nombre etiquetas para la clase
    //@Optional nos define si el campo es obligatorio u opcional
	public Clientes ingresarClientes(@Named("id de Clientes")final String idCliente ,
	@Named("Nombre")final String nombre,
	@Named("Apellido")final String apellido,
	@Named("Direccion")final String direccion,
	@Named("Localidad")final String localidad,
	@Named("Telefono")final String telefono,
	@Named("Celular")final String celular,
	@Named("E-mail")final String email,
	@Named("Observaciones")final String observacion)
	
	//@Named("Direccion Legal") @Optional final Date fechaDeExpiracion,
	//@Named("Direccion Real")final String direccionMac)
	{
		final Clientes cliente = container.newTransientInstance(Clientes.class);
	   // netbook.setFechaDeExpiracion(fechaDeExpiracion);
	    cliente.setIdCliente(idCliente);
	    cliente.setNombre(nombre);
	    cliente.setApellido(apellido);
	    cliente.setDireccion(direccion);
	    cliente.setLocalidad(localidad);
	    cliente.setTelefono(telefono);
	    cliente.setCelular(celular);
	    cliente.setEmail(email);
	    cliente.setObservacion(observacion);
	    
	    //netbook.setSituacionDeNetbook("Entregada");
	    
	    container.persistIfNotAlready(cliente);
	    
		return cliente;
	}
	
	@javax.inject.Inject 
    DomainObjectContainer container;
		
	
}
