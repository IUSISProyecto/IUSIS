package repo.iusis;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import dom.iusis.Procesos;
import dom.iusis.tipoNivel;

@Named("Procesos")//Nombre del menu
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
	public Procesos agregarProcesos(
	@Named("id de Procesos")final String idProcesos ,
	@Named("Nombre")final String nombre,
	@Named("Descripcion")final String descripcion,
	@Named("Tipo Nivel")final tipoNivel tipoNivel,
	@Named("DomicilioConstituido")final String domicilioConstituido)
	
	{
		final Procesos proceso = container.newTransientInstance(Procesos.class);
	    proceso.setIdProceso(idProcesos);
	    proceso.setNombre(nombre);
	    proceso.setDescripcion(descripcion);
	    proceso.setTipoNivel(tipoNivel);
	    proceso.setDomicilioConstituido(domicilioConstituido);
	 
	    container.persistIfNotAlready(proceso);
	    
		return proceso;
	}
	
	public List<Procesos> verProcesos() {
        return allMatches(QueryDefault.create(Procesos.class, "listarTodoslosProcesos"));
    }
	
	@javax.inject.Inject 
    DomainObjectContainer container;
		
	
}
