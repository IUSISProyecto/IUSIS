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

//import dom.iusis.Estudios;
import repo.iusis.RepositorioPersonas;
import dom.iusis.Personas;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
/*@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")*/
@ObjectType("Jueces")


@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(name = "listarTodosClientes", language = "JDOQL", value = "SELECT FROM dom.iusis.Clientes ")})

@AutoComplete(repository = RepositorioPersonas.class, action = "autoComplete")
@Audited
//@AutoComplete(repository = RepositorioClientes.class , action = "autoComplete")
//@AutoComplete(repository = RepositorioEstudios.class , action = "autoCompleteEstudios")

public class Jueces extends Personas {
	
	private String tipoabogado;
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
	public String getTipoAbogado() {
		return tipoabogado;
	}
	public void setTipoAbogado(String tipoabogado) {
		this.tipoabogado = tipoabogado;
	}
	/*
    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "9")
    public Estudios getEstudios() {
        return estudios;
    }
    public void setEstudios(Estudios estudios) {
        this.estudios = estudios;
    }*/

	@javax.inject.Inject
    @SuppressWarnings("unused")

    private DomainObjectContainer container;

	
}
