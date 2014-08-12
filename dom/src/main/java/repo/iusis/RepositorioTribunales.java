package repo.iusis;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import com.danhaywood.isis.wicket.gmap3.applib.Location;

import dom.iusis.Procesos;
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
	@Named("Direccion")final String direccion,
	@Named("Telefono")final String telefono,		
	@Named("Juez")final String juez,
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
		tribunal.setLocation(
	            //new Location(37.1953+random(-0.05, +0.05), 12.2149 + random(-0.05, +0.05)));
				new Location(37.195382,12.214927));
	    container.persistIfNotAlready(tribunal);
	    //37.195382,12.214927 coordenadas campus apple
		return tribunal;
	}
	
    private static double random(double from, double to) {
        return Math.random() * (to-from) + from;
    }
	
	public List<Tribunales> listarTodoslosTribunales() {
        return allMatches(QueryDefault.create(Tribunales.class, "listarTodoslosTribunales"));
    }
	
	@javax.inject.Inject 
    DomainObjectContainer container;
		
	
}
