package repo.iusis;


import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import dom.iusis.Procesos;

@Named("Administrar Estudios")
public class RepositorioProcesos extends AbstractFactoryAndRepository {


	public String getId() {
        return "Procesos";
    }
//Cambio icono
    public String iconName() {
        return "procesos";
    }
	//Defino nombre etiquetas para la clase
    //@Optional nos define si el campo es obligatorio u opcional
	public Procesos ingresarProcesos(@Named("id de Procesos")final String idProcesos ,
	@Named("Nombre")final String nombre,
	@Named("Descripcion")final String descripcion)
	
	
	//@Named("Direccion Legal") @Optional final Date fechaDeExpiracion,
	//@Named("Direccion Real")final String direccionMac)
	{
		final Procesos proceso = container.newTransientInstance(Procesos.class);
	   // netbook.setFechaDeExpiracion(fechaDeExpiracion);
	    proceso.setIdProceso(idProcesos);
	    proceso.setNombre(nombre);
	    proceso.setDescripcion(descripcion);
	 
	    
	    //netbook.setSituacionDeNetbook("Entregada");
	    
	    container.persistIfNotAlready(proceso);
	    
		return proceso;
	}
	
	public List<Procesos> listarProcesos() {
        return allMatches(QueryDefault.create(Procesos.class, "listarTodoslosProcesos"));
    }
	
	@javax.inject.Inject 
    DomainObjectContainer container;
		
	
}
