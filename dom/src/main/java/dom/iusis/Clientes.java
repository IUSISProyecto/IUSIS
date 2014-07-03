package dom.iusis;


//import java.util.Date;


//import java.util.ArrayList;
//import java.util.List;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
//import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
//import org.apache.isis.applib.annotation.Optional;
//import org.apache.isis.applib.annotation.RegEx;
import org.apache.isis.applib.annotation.Title;

//import org.apache.isis.applib.query.QueryDefault;
//import repo.iusis.RepositorioClientes;
import dom.iusis.Estudios;

//import org.apache.isis.applib.query.QueryDefault;


@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@ObjectType("Clientes")


@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(name = "listarTodosClientes", language = "JDOQL", value = "SELECT FROM dom.iusis.Clientes ")})
@Audited
//@AutoComplete(repository = RepositorioClientes.class , action = "autoComplete")
//@AutoComplete(repository = RepositorioEstudios.class , action = "autoCompleteEstudios")

public class Clientes {
	
	private String idCliente;
	private String nombre;
	private String apellido;
	private String direccion;
	//private Date fecha;
	private String localidad;
	private String telefono;
	private String celular;
	private String email;
	private String observacion;
	private Estudios estudios;
	
	
    public String iconName() {
        return "clientes";
    }
	
	@javax.jdo.annotations.Column(allowsNull="false")
	 @MemberOrder(sequence="2")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@MemberOrder(sequence="3")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@javax.jdo.annotations.Column(allowsNull="false")
	 @MemberOrder(sequence="4")
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	//@javax.jdo.annotations.Column(allowsNull="true")
	//public Date getFecha() {
		//return fecha;
	//}
	//public void setFecha(Date fecha) {
		//this.fecha = fecha;
	//}
	
	@javax.jdo.annotations.Column(allowsNull="false")
	 @MemberOrder(sequence="5")
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@javax.jdo.annotations.Column(allowsNull="true")
	@MemberOrder(sequence="5")
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@javax.jdo.annotations.Column(allowsNull="true")
	 @MemberOrder(sequence="6")
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	@javax.jdo.annotations.Column(allowsNull="true")
	 @MemberOrder(sequence="7")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@javax.jdo.annotations.Column(allowsNull="true")
	 @MemberOrder(sequence="8")
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "9")
    public Estudios getEstudios() {
        return estudios;
    }
    public void setEstudios(Estudios estudios) {
        this.estudios = estudios;
    }

	@javax.jdo.annotations.Column(allowsNull="false")
    @Title(sequence="1")
    @MemberOrder(sequence="1")
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}


	@javax.inject.Inject
    @SuppressWarnings("unused")

    private DomainObjectContainer container;

	
}
