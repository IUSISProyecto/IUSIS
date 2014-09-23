package dom.iusis;


//import java.util.Date;
//import java.util.ArrayList;
//import java.util.List;
import javax.jdo.annotations.IdentityType;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.AutoComplete;
//import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;

import repo.iusis.RepositorioPersonas;
import dom.iusis.Persona;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
/*@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")*/
@ObjectType("Peritos")


@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(name = "listarTodosClientes", language = "JDOQL", value = "SELECT FROM dom.iusis.Clientes ")})

@AutoComplete(repository = RepositorioPersonas.class, action = "autoComplete")
@Audited
//@AutoComplete(repository = RepositorioClientes.class , action = "autoComplete")
//@AutoComplete(repository = RepositorioEstudios.class , action = "autoCompleteEstudios")

public class Perito extends Persona {
	
	private String tipoperito;
	//private Estudios estudios;
	
	
    public String iconName() {
        return "clientes";
    }
	
    
    public String title()
	{
		return this.getNombre().toString()+" "+this.getApellido().toString();

	}
    
	@javax.jdo.annotations.Column(allowsNull="true")
	 @MemberOrder(sequence="8")
	public String getTipoPerito() {
		return tipoperito;
	}
	public void setTipoPerito(String tipoperito) {
		this.tipoperito = tipoperito;
	}

	@javax.inject.Inject
    @SuppressWarnings("unused")

    private DomainObjectContainer container;

	
}
