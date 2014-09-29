package dom.iusis;

import java.util.List;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;


//import dom.iusis.Estudios;
import repo.iusis.RepositorioPersonas;
import dom.iusis.Persona;


@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("Clientes")

@javax.jdo.annotations.Queries({
	@javax.jdo.annotations.Query(name = "buscarPorDni", language = "JDOQL", value = "SELECT FROM dom.iusis.Clientes WHERE dni== :dni"),
    @javax.jdo.annotations.Query(name = "buscarPorNombre", language = "JDOQL", value = "SELECT FROM dom.simple.Clientes WHERE nombre.startsWith(:nombre)"),
    @javax.jdo.annotations.Query(name = "buscarPorApellido", language = "JDOQL", value = "SELECT FROM dom.simple.Clientes WHERE nombre.startsWith(:apellido)")
})

@AutoComplete(repository = RepositorioPersonas.class, action = "autoComplete")
@Audited

public class ClienteFisico extends Persona {
	
	private String cuit;
	private String observacion;
	//private Estudios estudios;
	private dom.iusis.TipoCliente tipoCliente;
	private TipoPersona tipoPersona;
	private EstadoCivil estadoCivil;
	
    public String iconName() {
        return "clientes";
    }
    
    public String title()
	{
		return this.getNombre().toString()+" "+this.getApellido().toString();
	}
    
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "6")
    public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	@javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "7")
	public dom.iusis.TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(dom.iusis.TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "8")
	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "8")
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	@javax.jdo.annotations.Column(allowsNull="true")
	@MemberOrder(sequence="8")
	//Indica que el campo es multiline y se permiten hasta diez lineas
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	/*
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "9")
    public Estudios getEstudios() {
        return estudios;
    }
    public void setEstudios(Estudios estudios) {
        this.estudios = estudios;
    }*/

///////////////////////////////////////
//Buscar clientes por DNI
////////////////////////////////////////

@MemberOrder(sequence = "9")
@Named ("Buscar por DNI")
public List<ClienteFisico> ListByDni(
final @Named("DNI") String dni){

return listByDni(dni);

}

@Programmatic
public List<ClienteFisico> listByDni(String dni) {
return container.allMatches(new QueryDefault<ClienteFisico>(ClienteFisico.class, "buscarPorDni", "dni", dni));

}

///////////////////////////////////////
//Buscar clientes por Nombre
////////////////////////////////////////

@MemberOrder(sequence = "9")
@Named ("Buscar por Nombre")
public List<ClienteFisico> ListByName(
final @Named("Nombre") String nombre){

return listByName(nombre);

}

@Programmatic
public List<ClienteFisico> listByName(String nombre) {
return container.allMatches(new QueryDefault<ClienteFisico>(ClienteFisico.class, "buscarPorNombre", "nombre", nombre));
}

///////////////////////////////////////
//Buscar clientes por Apellido
////////////////////////////////////////

@MemberOrder(sequence = "9")
@Named ("Buscar por Apellido")
public List<ClienteFisico> ListByLastname(
final @Named("Apellido") String apellido){

return listByName(apellido);

}

@Programmatic
public List<ClienteFisico> listByLastname(String apellido) {
return container.allMatches(new QueryDefault<ClienteFisico>(ClienteFisico.class, "buscarPorApellido", "apellido", apellido));
}

@javax.inject.Inject
private DomainObjectContainer container;	
}