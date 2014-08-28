package dom.iusis;

import javax.jdo.annotations.IdentityType;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.AutoComplete;
//import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;

import dom.iusis.Estudios;
import repo.iusis.RepositorioPersonas;
import dom.iusis.Personas;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
/*@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")*/
@ObjectType("Abogados")

@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(name = "listarTodosAbogados", language = "JDOQL", value = "SELECT FROM dom.iusis.Abogados ")})

@AutoComplete(repository = RepositorioPersonas.class, action = "autoComplete")
@Audited
//@AutoComplete(repository = RepositorioClientes.class , action = "autoComplete")
//@AutoComplete(repository = RepositorioEstudios.class , action = "autoCompleteEstudios")

public class Abogados extends Personas {
	
	private String numeroMatricula;
	//private Estudios estudios;//Utiliso clase estudio para relacionarlas
	private dom.iusis.relacionAbogado relacionAbogado;
	
    public String iconName() {
        return "clientes";
    }
    public String title()
	{
		return this.getNombre().toString()+" "+this.getApellido().toString();

	}
	
    /*@javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "7")
    public Estudios getEstudios() {
        return estudios;
    }
    public void setEstudios(Estudios estudios) {
        this.estudios = estudios;
    }*/
    @MemberOrder(sequence = "8")
	@javax.jdo.annotations.Column(allowsNull="false")	
	public dom.iusis.relacionAbogado getRelacionAbogado() {
		return relacionAbogado;
	}
	public void setRelacionAbogado(dom.iusis.relacionAbogado relacionAbogado) {
		this.relacionAbogado = relacionAbogado;
	}
	
		@javax.jdo.annotations.Column(allowsNull="true")
	 @MemberOrder(sequence="9")
	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	
	@javax.inject.Inject
    @SuppressWarnings("unused")

    private DomainObjectContainer container;

	
}
