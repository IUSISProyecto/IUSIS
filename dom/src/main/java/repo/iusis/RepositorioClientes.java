package repo.iusis;


import java.util.Date;





import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;

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
	public Clientes ingresarClientes(@Named("id de Clientes")final String idNetbook ,
	@Named("Nombre")final String modelo,
	@Named("Apellido")final String numeroDeSerie,
	@Named("Telefono")final String numeroLicenciaWindows,
	@Named("Direccion Legal") @Optional final Date fechaDeExpiracion,
	@Named("Direccion Real")final String direccionMac)
	{
		final Clientes netbook = container.newTransientInstance(Clientes.class);
	    netbook.setFechaDeExpiracion(fechaDeExpiracion);
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
