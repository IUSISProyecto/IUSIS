package dom.iusis;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Unique;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;

import dom.iusis.CategoriaFiscal;
import dom.iusis.Estudio;
import repo.iusis.RepositorioPersonas;
import dom.iusis.Persona;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("Abogados")

@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(name = "listarTodosAbogados", language = "JDOQL", value = "SELECT FROM dom.iusis.Abogados ")})

@AutoComplete(repository = RepositorioPersonas.class, action = "autoComplete")
@Audited
//@AutoComplete(repository = RepositorioClientes.class , action = "autoComplete")
//@AutoComplete(repository = RepositorioEstudios.class , action = "autoCompleteEstudios")

public class Abogado extends Persona {
	
	private String cuit;
	private CategoriaFiscal categoriaFiscal;
	private int tomo;
	private int folio;
	private String numeroMatricula;
	private Estudio estudio;//Utiliso clase estudio para relacionarlas
	private RelacionAbogado relacionAbogado;
	
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
		return categoriaFiscal;
	}
	public void setCategoriaFiscal(CategoriaFiscal categoriaFiscal) {
		this.categoriaFiscal = categoriaFiscal;
	}
	
    @javax.jdo.annotations.Column(allowsNull="false")
	@MemberOrder(sequence="7")
	public int getTomo() {
		return tomo;
	}
	public void setTomo(int tomo) {
		this.tomo = tomo;
	}

    @javax.jdo.annotations.Column(allowsNull="false")
	@MemberOrder(sequence="7")
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}

    @MemberOrder(sequence = "9")
	@javax.jdo.annotations.Column(allowsNull="false")	
	public RelacionAbogado getRelacionAbogado() {
		return relacionAbogado;
	}
	public void setRelacionAbogado(RelacionAbogado relacionAbogado) {
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
    public Estudio getEstudio() {
        return estudio;
    }
    public void setEstudio(Estudio estudios) {
        this.estudio = estudio;
    }
	
	@javax.inject.Inject
    @SuppressWarnings("unused")

    private DomainObjectContainer container;

	
}