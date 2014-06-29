package dom.iusis;


//import java.util.Date;


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
	@javax.jdo.annotations.Query(name = "listarTodoslosProcesos", language = "JDOQL", value = "SELECT FROM dom.iusi.Procesos ")})

public class Procesos {
	
	
	private String idProceso;
	private String nombre;
	private String descripcion;
	
	
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
    @Title(sequence="1")
    @MemberOrder(sequence="1")
	public String getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(String idProceso) {
		this.idProceso = idProceso;
	}
	

	@javax.inject.Inject
    @SuppressWarnings("unused")

    private DomainObjectContainer container;
	
}
