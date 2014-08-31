package dom.iusis;


import javax.jdo.annotations.IdentityType;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;


import dom.iusis.Estudios;
import repo.iusis.RepositorioPersonas;
import dom.iusis.Personas;


@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("Clientes")

@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(name = "listarTodosClientes", language = "JDOQL", value = "SELECT FROM dom.iusis.Clientes ")})

@AutoComplete(repository = RepositorioPersonas.class, action = "autoComplete")
@Audited
//@AutoComplete(repository = RepositorioClientes.class , action = "autoComplete")
//@AutoComplete(repository = RepositorioEstudios.class , action = "autoCompleteEstudios")

public class Clientes extends Personas {
	
	private String observacion;
	private Estudios estudios;
	private dom.iusis.tipoCliente tipoCliente;
	private dom.iusis.tipoPersona tipoPersona;
	private dom.iusis.estadoCivil estadoCivil;
	
    public String iconName() {
        return "clientes";
    }
    
    public String title()
	{
		return this.getNombre().toString()+" "+this.getApellido().toString();
	}
    
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "7")
	public dom.iusis.tipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(dom.iusis.tipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "8")
	public dom.iusis.tipoPersona getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(dom.iusis.tipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "8")
	public dom.iusis.estadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(dom.iusis.estadoCivil estadoCivil) {
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
	
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "9")
    public Estudios getEstudios() {
        return estudios;
    }
    public void setEstudios(Estudios estudios) {
        this.estudios = estudios;
    }

	@javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
	
}