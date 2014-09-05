package dom.iusis;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@ObjectType("Procesos")

@javax.jdo.annotations.Queries({
	//{@javax.jdo.annotations.Query(name = "traerPorId", language = "JDOQL", value = "SELECT FROM dom.iusis.Clientes WHERE idCliente== :idCliente"),
	@javax.jdo.annotations.Query(name = "listarTodoslosProcesos", language = "JDOQL", value = "SELECT FROM dom.iusis.Procesos ")})

public class Procesos {

	private String idProceso;
	private String nombre;
	private String descripcion;
	private String domicilioConstituido;
	private tipoNivel tipoNivel;
	private tipoInstancia tipoInstancia;
	
	
    public String iconName() {
        return "procesos";
    }

	@javax.jdo.annotations.Column(allowsNull="false")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getDomicilioConstituido() {
		return domicilioConstituido;
	}
	public void setDomicilioConstituido(String domicilioConstituido) {
		this.domicilioConstituido = domicilioConstituido;
	}
	
	
	@javax.jdo.annotations.Column(allowsNull="false")
    @Title(sequence="1")
    @MemberOrder(sequence="1")
	public String getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(String idProceso) {
		this.idProceso = idProceso;
	}
	
	@javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence="4")
	public tipoNivel getTipoNivel() {
		return tipoNivel;
	}

	public void setTipoNivel(tipoNivel tipoNivel) {
		this.tipoNivel = tipoNivel;
	}

	@javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence="5")
	public tipoInstancia getTipoInstancia() {
		return tipoInstancia;
	}

	public void setTipoInstancia(tipoInstancia tipoInstancia) {
		this.tipoInstancia = tipoInstancia;
	}


	@javax.inject.Inject
    @SuppressWarnings("unused")

    private DomainObjectContainer container;
	
}
