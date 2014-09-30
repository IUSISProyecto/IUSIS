package repo.iusis;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.MultiLine;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import dom.iusis.Proceso;
import dom.iusis.TipoNivel;
import dom.iusis.TipoInstancia;

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
	public Proceso agregarProcesos(
	@Named("id de Procesos")final String idProcesos ,
	@MultiLine(numberOfLines=6)//Indica que el campo es multiline y se permiten hasta seis lineas
	@Named("Caratula")final  String caratula,
	@Named("Nombre")final String nombre,
	@Named("Descripcion")final String descripcion,
	@Named("Tipo Nivel")final TipoNivel tipoNivel,
	@Named("N Carpeta")final String numeroCarpeta,
	@Named("Instancia")final TipoInstancia tipoInstancia,
	@Named("DomicilioConstituido")final String domicilioConstituido)
	
	{
		final Proceso proceso = container.newTransientInstance(Proceso.class);
	    proceso.setIdProceso(idProcesos);
	    proceso.setCaratula(caratula);
	    proceso.setNombre(nombre);
	    proceso.setDescripcion(descripcion);
	    proceso.setNumeroCarpeta(numeroCarpeta);
	    proceso.setTipoNivel(tipoNivel);
	    proceso.setTipoInstancia(tipoInstancia);
	    proceso.setDomicilioConstituido(domicilioConstituido);
	 
	    container.persistIfNotAlready(proceso);
	    
		return proceso;
	}
	
	public List<Proceso> verProcesos() {
        return allMatches(QueryDefault.create(Proceso.class, "listarTodoslosProcesos"));
    }
	
	@javax.inject.Inject 
    DomainObjectContainer container;
		
	
}
