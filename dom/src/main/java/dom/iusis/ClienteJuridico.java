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
@ObjectType("Cliente Juridico")

@javax.jdo.annotations.Queries({
	@javax.jdo.annotations.Query(name = "buscarPorDni", language = "JDOQL", value = "SELECT FROM dom.iusis.Clientes WHERE dni== :dni"),
    @javax.jdo.annotations.Query(name = "buscarPorNombre", language = "JDOQL", value = "SELECT FROM dom.simple.Clientes WHERE nombre.startsWith(:nombre)"),
    @javax.jdo.annotations.Query(name = "buscarPorApellido", language = "JDOQL", value = "SELECT FROM dom.simple.Clientes WHERE nombre.startsWith(:apellido)")
})

@AutoComplete(repository = RepositorioPersonas.class, action = "autoComplete")
@Audited

public class ClienteJuridico extends Persona {
	
	private String cuit;
	private String razonsocial;
	private String tiposocietario;
	private String domilicioconstituido;
	private String Sucursales;
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
    @MemberOrder(sequence = "1")
    public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	@javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "2")
	public dom.iusis.TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(dom.iusis.TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "3")
	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "4")
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	@javax.jdo.annotations.Column(allowsNull="true")
	@MemberOrder(sequence="5")
	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}	

	@javax.jdo.annotations.Column(allowsNull="true")
	@MemberOrder(sequence="6")
	public String getTiposocietario() {
		return tiposocietario;
	}

	public void setTiposocietario(String tiposocietario) {
		this.tiposocietario = tiposocietario;
	}
	
	@javax.jdo.annotations.Column(allowsNull="true")
	@MemberOrder(sequence="7")
	public String getDomilicioconstituido() {
		return domilicioconstituido;
	}
	
	public void setDomilicioconstituido(String domilicioconstituido) {
		this.domilicioconstituido = domilicioconstituido;
	}
	
	@javax.jdo.annotations.Column(allowsNull="true")
	@MemberOrder(sequence="8")
	public String getSucursales() {
		return Sucursales;
	}

	public void setSucursales(String sucursales) {
		Sucursales = sucursales;
	}
	
	@javax.jdo.annotations.Column(allowsNull="true")
	@MemberOrder(sequence="9")
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
public List<ClienteJuridico> ListByDni(
final @Named("DNI") String dni){

return listByDni(dni);

}


@Programmatic
public List<ClienteJuridico> listByDni(String dni) {
return container.allMatches(new QueryDefault<ClienteJuridico>(ClienteJuridico.class, "buscarPorDni", "dni", dni));

}

///////////////////////////////////////
//Buscar clientes por Nombre
////////////////////////////////////////

@MemberOrder(sequence = "9")
@Named ("Buscar por Nombre")
public List<ClienteJuridico> ListByName(
final @Named("Nombre") String nombre){

return listByName(nombre);

}

@Programmatic
public List<ClienteJuridico> listByName(String nombre) {
return container.allMatches(new QueryDefault<ClienteJuridico>(ClienteJuridico.class, "buscarPorNombre", "nombre", nombre));
}

///////////////////////////////////////
//Buscar clientes por Apellido
////////////////////////////////////////

@MemberOrder(sequence = "9")
@Named ("Buscar por Apellido")
public List<ClienteJuridico> ListByLastname(
final @Named("Apellido") String apellido){

return listByName(apellido);

}

@Programmatic
public List<ClienteJuridico> listByLastname(String apellido) {
return container.allMatches(new QueryDefault<ClienteJuridico>(ClienteJuridico.class, "buscarPorApellido", "apellido", apellido));
}

@javax.inject.Inject
private DomainObjectContainer container;	
}