package repo.iusis;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DescribedAs;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import dom.iusis.Tribunales;
import dom.iusis.listaProvincias;
import dom.iusis.tipoTribunal;

@Named("Administrar Tribunales")
public class RepositorioTribunales extends AbstractFactoryAndRepository {

	public String getId() {
        return "Tribunales";
    }
//Cambio icono
    public String iconName() {
        return "Edificio";
    }
	//Defino nombre etiquetas para la clase
    //@Optional nos define si el campo es obligatorio u opcional
	public Tribunales ingresarTribunales(@Named("nombre")final String nombre ,
	@Named("Tipo Tribunal")final tipoTribunal tipoTribunal,
	@Named("Provincia")final listaProvincias provincia,
	@Named("Ciudad")final String ciudad,
	@Named("Direccion") @DescribedAs("Example: Neuquen")final String direccion,
	@Named("Telefono")@DescribedAs("Example: 299 154 681860")final String telefono,		
	@Named("Juez")final @DescribedAs("Example: Jose Gago") String juez,
	@Named("Fiscal")final String fiscal)
	
				
	{
		final Tribunales tribunal = container.newTransientInstance(Tribunales.class);
		tribunal.setNombre(nombre);
		tribunal.setTipoTribunal(tipoTribunal);
		tribunal.setProvincia(provincia);
		tribunal.setCiudad(ciudad);
		tribunal.setDireccion(direccion);
		tribunal.setTelefono(telefono);
		tribunal.setJuez(juez);
		tribunal.setFiscal(fiscal);
		//tribunal.setLocation(location);
		
	    container.persistIfNotAlready(tribunal);
	    
		return tribunal;
				        
	}
	
	public List<Tribunales> listarTodoslosTribunales() {
        return allMatches(QueryDefault.create(Tribunales.class, "listarTodoslosTribunales"));
    }
	
	@javax.inject.Inject 
    DomainObjectContainer container;
		
	
}
