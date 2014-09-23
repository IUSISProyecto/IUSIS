package repo.iusis;
//import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import dom.iusis.Estudio;

@Named("Administrar Estudios")
public class RepositorioEstudios extends AbstractFactoryAndRepository {

	public String getId() {
        return "Estudios";
    }
//Cambio icono
    public String iconName() {
        return "Edificio";
    }
    
	//Defino nombre etiquetas para la clase
    //@Optional nos define si el campo es obligatorio u opcional
	public Estudio ingresarEstudios(
	@Named("Nombre Estudio")final String nombre,
	@Named("Localidad")final String localidad,
	@Named("Telefono")final String telefono,
	@Named("Direccion")final String direccion)
	{
		final Estudio estudio = container.newTransientInstance(Estudio.class);
	    estudio.setNombre(nombre);
	    estudio.setLocalidad(localidad);
	    estudio.setTelefono(telefono);
	    estudio.setDireccion(direccion);
	    
	    container.persistIfNotAlready(estudio);
	    
		return estudio;
	}
	
	public List<Estudio> listarEstudios() {
        return allMatches(QueryDefault.create(Estudio.class, "listarTodosEstudios"));
    }
	
	@Hidden
    public List<Estudio> autoComplete(String searchPhrase) {        
    	return allMatches(QueryDefault.create(Estudio.class, "estudiosPorNombre","nombre",searchPhrase));
    }
	
	@javax.inject.Inject 
    DomainObjectContainer container;
		
	
}
