package dom.iusis;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Unique;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;

import dom.iusis.CategoriaFiscal;
import dom.iusis.Estudios;
import repo.iusis.RepositorioPersonas;
import dom.iusis.Personas;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("Abogados")

@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(name = "listarTodosAbogados", language = "JDOQL", value = "SELECT FROM dom.iusis.Abogados ")})

@AutoComplete(repository = RepositorioPersonas.class, action = "autoComplete")
@Audited
//@AutoComplete(repository = RepositorioClientes.class , action = "autoComplete")
//@AutoComplete(repository = RepositorioEstudios.class , action = "autoCompleteEstudios")

public class Abogados extends Personas {
	
	private String cuit;
	private CategoriaFiscal CategoriaFiscal;
	private String numeroMatricula;
	private Estudios estudios;//Utiliso clase estudio para relacionarlas
	private dom.iusis.relacionAbogado relacionAbogado;
	
    public String iconName() {
        return "clientes";
    }
    public String title()
	{
		return this.getNombre().toString()+" "+this.getApellido().toString();

	}
    
    @javax.jdo.annotations.Column(allowsNull="false")
	@MemberOrder(sequence="7")
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	@MemberOrder(sequence = "8")
	@javax.jdo.annotations.Column(allowsNull="false")	
	public CategoriaFiscal getCategoriaFiscal() {
		return CategoriaFiscal;
	}
	public void setCategoriaFiscal(CategoriaFiscal CategoriaFiscal) {
		this.CategoriaFiscal = CategoriaFiscal;
	}
	
    @MemberOrder(sequence = "9")
	@javax.jdo.annotations.Column(allowsNull="false")	
	public dom.iusis.relacionAbogado getRelacionAbogado() {
		return relacionAbogado;
	}
	public void setRelacionAbogado(dom.iusis.relacionAbogado relacionAbogado) {
		this.relacionAbogado = relacionAbogado;
	}
	
	@javax.jdo.annotations.Column(allowsNull="false")
	@MemberOrder(sequence="10")
	@Unique //Indica que este campo debe ser unico
	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

    @javax.jdo.annotations.Column(allowsNull="true")
    @MemberOrder(sequence = "11")
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