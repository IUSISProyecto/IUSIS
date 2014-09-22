package dom.iusis;

import java.util.Date;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("Agenda")

@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(name = "listarTodosEventos", language = "JDOQL", value = "SELECT FROM dom.iusis.Agenda ")})


public class Agenda {
	private String tituloevento;
	private String lugar;
	private Date fecha;
	private Date hora;
	private tipoProceso tipoProceso;
	private String responsable; /*Unir con abogado propio*/
	private String cliente; /*se podría vincular a un cliente, o cualquier persona (testigo, perito, etc).*/
	private String expediente;
	private String descripcion;

	@javax.jdo.annotations.Column(allowsNull="false")
	@MemberOrder(sequence="1")
	public String getTituloEvento() {
		return tituloevento;
	}
	public void setTituloEvento(String tituloevento) {
		this.tituloevento = tituloevento;
	}
	
	@javax.jdo.annotations.Column(allowsNull="false")
	@MemberOrder(sequence="2")
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
    @javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence = "3")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
    @javax.jdo.annotations.Column(allowsNull="false")
    @MemberOrder(sequence = "4")
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}

    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "5")
	public tipoProceso getTipoProceso() {
		return tipoProceso;
	}
	public void setTipoProceso(tipoProceso tipoProceso) {
	    this.tipoProceso = tipoProceso;
	}
	
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "6")
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "7")
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "8")
	public String getExpediente() {
		return expediente;
	}
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "9")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
