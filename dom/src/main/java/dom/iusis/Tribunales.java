package dom.iusis;


import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Optional;

import com.danhaywood.isis.wicket.gmap3.applib.Locatable;
import com.danhaywood.isis.wicket.gmap3.applib.Location;

import repo.iusis.RepositorioPersonas;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("Tribunales")

@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(name = "listarTodoslosTribunales", language = "JDOQL", value = "SELECT FROM dom.iusi.Tribunales ")})

@AutoComplete(repository = RepositorioPersonas.class, action = "autoComplete")
@Audited
//@AutoComplete(repository = RepositorioClientes.class , action = "autoComplete")
//@AutoComplete(repository = RepositorioEstudios.class , action = "autoCompleteEstudios")

public class Tribunales implements Locatable{
	
	private String nombre;
	private tipoTribunal tipoTribunal;
	private listaProvincias provincia;
	private String ciudad;
	private String direccion;
	private String telefono;
	private String juez;
	private String fiscal;

    public String iconName() {
        return "clientes";
    }
    
    @javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence = "1")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    @javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence = "2")
	public dom.iusis.tipoTribunal getTipoTribunal() {
		return tipoTribunal;
	}
	public void setTipoTribunal(dom.iusis.tipoTribunal tipoTribunal) {
		this.tipoTribunal = tipoTribunal;
	}

    @javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence = "3")

    public listaProvincias getProvincia() {
		return provincia;
	}

	public void setProvincia(listaProvincias provincia) {
		this.provincia = provincia;
	}


    @javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence = "4")
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
    @javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence = "5")   
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
    
    @javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence = "6")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

    @javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence = "7")
	public String getJuez() {
		return juez;
	}
	public void setJuez(String juez) {
		this.juez = juez;
	}

    @javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence = "8")
	public String getFiscal() {
		return fiscal;
	}
    
	public void setFiscal(String fiscal) {
		this.fiscal = fiscal;
	}

	
	// {{
    @javax.jdo.annotations.Persistent
    private Location location;
    
    @Optional
    @MemberOrder(sequence="10")
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    // }}

	

	@javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
	
}
