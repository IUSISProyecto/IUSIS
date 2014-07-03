package dom.iusis;

//import java.util.Date;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;

import repo.iusis.RepositorioEstudios;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@ObjectType("Estudios")

@javax.jdo.annotations.Queries({
	@javax.jdo.annotations.Query(name = "listarTodosEstudios", language = "JDOQL", value = "SELECT FROM dom.iusis.Estudios "),
	@javax.jdo.annotations.Query(name = "estudiosPorNombre", language = "JDOQL", value = "SELECT FROM dom.iusis.Estudios WHERE nombre.startsWith(:nombre) range 0, 4")
	//@javax.jdo.annotations.Query(name = "estudiosPorNombre", language = "JDOQL", value = "SELECT FROM dom.iusis.Estudios WHERE nombre.startsWith(:nombre) range 0, 4")
})
@AutoComplete(repository = RepositorioEstudios.class , action = "autoComplete")

public class Estudios {
	
	private String idEstudio;
	private String nombre;
	private String localidad;
	private String telefono;
	private String direccion;
	
    public String iconName() {
        return "Edificio";
    }
	
    @javax.jdo.annotations.Column(allowsNull="false")
    @Title(sequence="1")
    @MemberOrder(sequence="1")
	public String getIdEstudio() {
		return idEstudio;
	}
	public void setIdEstudio(String idEstudio) {
		this.idEstudio = idEstudio;
	}
	
	@javax.jdo.annotations.Column(allowsNull="false")
	@MemberOrder(sequence="2")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
	@javax.jdo.annotations.Column(allowsNull="false")
	@MemberOrder(sequence="3")
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@javax.jdo.annotations.Column(allowsNull="false")
	@MemberOrder(sequence="4")
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@javax.jdo.annotations.Column(allowsNull="false")
	@MemberOrder(sequence="5")
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	@javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
	
}
