package dom.iusis;
import java.util.Date;
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

public class Proceso {

	private String idProceso;
	private String caratula;
	private String nombre;
	private String descripcion;
	private String domicilioConstituido;
	private Date fechaInicio;
	private Date fechaFinalizacion;
	private String numeroCarpeta;
	private TipoNivel TipoNivel;
	private TipoInstancia tipoInstancia;
	
	@Title(sequence="1")
	@MemberOrder(sequence="1")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}
	
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
    
    @MemberOrder(sequence="2")
	public String getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(String idProceso) {
		this.idProceso = idProceso;
	}
	
	@javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence="4")
	public TipoNivel getTipoNivel() {
		return TipoNivel;
	}

	public void setTipoNivel(TipoNivel TipoNivel) {
		this.TipoNivel = TipoNivel;
	}

	@javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence="5")
	public TipoInstancia getTipoInstancia() {
		return tipoInstancia;
	}

	public void setTipoInstancia(TipoInstancia tipoInstancia) {
		this.tipoInstancia = tipoInstancia;
	}
	
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getNumeroCarpeta() {
		return numeroCarpeta;
	}

	public void setNumeroCarpeta(String numeroCarpeta) {
		this.numeroCarpeta = numeroCarpeta;
	}


	@javax.jdo.annotations.Column(allowsNull="false")
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	@javax.jdo.annotations.Column(allowsNull="false")
	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}



	@javax.inject.Inject
    @SuppressWarnings("unused")

    private DomainObjectContainer container;
	
}
