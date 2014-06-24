package repo.iusis;


import java.util.Date;


import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;

import dom.iusis.Estudios;

@Named("Administrar Estudios")
public class RepositorioEstudios extends AbstractFactoryAndRepository {


	public String getId() {
        return "Netbook";
    }
//Cambio icono
    public String iconName() {
        return "Edificio";
    }
	//Defino nombre etiquetas para la clase
    //@Optional nos define si el campo es obligatorio u opcional
	public Estudios ingresarEstudios(@Named("id de Estudio")final String idNetbook ,
	@Named("Nombre Estudio")final String modelo,
	@Named("Localidad")final String numeroDeSerie,
	@Named("Telefono")final String numeroLicenciaWindows,
	//@Named("Direccion Legal") @Optional final Date fechaDeExpiracion,
	@Named("Direccion Real")final String direccionMac)
	{
		final Estudios netbook = container.newTransientInstance(Estudios.class);
	    //netbook.setFechaDeExpiracion(fechaDeExpiracion);
	    netbook.setIdNetbook(idNetbook);
	    netbook.setDireccionMac(direccionMac);
	    
	    netbook.setModelo(modelo);
	    netbook.setNumeroDeSerie(numeroDeSerie);
	    netbook.setNumeroLicenciaWindows(numeroLicenciaWindows);
	    netbook.setSituacionDeNetbook("Entregada");
	    
	    
	    container.persistIfNotAlready(netbook);
	    
		return netbook;
	}
	
	@javax.inject.Inject 
    DomainObjectContainer container;
		
	
}
