package repo.iusis;
//import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import dom.iusis.Estudios;

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
	public Estudios ingresarEstudios(
	@Named("Nombre Estudio")final String nombre,
	@Named("Localidad")final String localidad,
	@Named("Telefono")final String telefono,
	@Named("Direccion")final String direccion)
	{
		final Estudios estudio = container.newTransientInstance(Estudios.class);
	    estudio.setNombre(nombre);
	    estudio.setLocalidad(localidad);
	    estudio.setTelefono(telefono);
	    estudio.setDireccion(direccion);
	    
	    container.persistIfNotAlready(estudio);
	    
		return estudio;
	}
	
	public List<Estudios> listarEstudios() {
        return allMatches(QueryDefault.create(Estudios.class, "listarTodosEstudios"));
    }
	
	@Hidden
    public List<Estudios> autoComplete(String searchPhrase) {        
    	return allMatches(QueryDefault.create(Estudios.class, "estudiosPorNombre","nombre",searchPhrase));
    }
	
	@javax.inject.Inject 
    DomainObjectContainer container;
		
	
}
