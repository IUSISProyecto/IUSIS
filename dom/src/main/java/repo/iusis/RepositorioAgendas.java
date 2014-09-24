package repo.iusis;

import java.util.Date;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.MultiLine;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.value.Blob;

import dom.iusis.Agenda;
import dom.iusis.TipoProceso;

public class RepositorioAgendas  extends AbstractFactoryAndRepository {
	public String getId() {
        return "Agenda";
    }
//Cambio icono
    public String iconName() {
        return "agenda";
    }
    
  //@Optional nos define si el campo es obligatorio u opcional
  	public Agenda ingresarAgenda(
  	@Named("Nombre Evento")final String tituloevento,
  	@Named("Lugar")final String lugar,
  	@Named("Fecha")final Date fecha,
  	@Named("Hora")final Date hora,
  	@Named("Tipo Proceso")@Optional TipoProceso tipoProceso,
  	@Named("Responsable")@Optional final String responsable,
  	@Named("Cliente")@Optional final String cliente,
  	@Named("Expediente")@Optional final String expediente,
  	@MultiLine(numberOfLines=10)
  	@Named("Descripcción")final @Optional String descripcion,
  	@Named("Adjunto")final Blob attachment)
  	
  	{
  		
		final Agenda agenda = container.newTransientInstance(Agenda.class);
  	    agenda.setTituloEvento(tituloevento);
  	    agenda.setLugar(lugar);
  	    agenda.setFecha(fecha);
  	    agenda.setHora(hora);
  	    agenda.setTipoProceso(tipoProceso);
  	    agenda.setResponsable(responsable);
  	    agenda.setCliente(cliente);
  	    agenda.setExpediente(expediente);
  	    agenda.setDescripcion(descripcion);
  	    agenda.setAttachment(attachment);
  	      	    
  	    container.persistIfNotAlready(agenda);
  	    
  		return agenda;
  	}
	@javax.inject.Inject 
    DomainObjectContainer container;
}
