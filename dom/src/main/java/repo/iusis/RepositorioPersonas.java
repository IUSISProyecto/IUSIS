package repo.iusis;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MultiLine;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.RegEx;
import org.apache.isis.applib.annotation.TypicalLength;
import org.apache.isis.applib.query.QueryDefault;

import dom.iusis.Abogados;
import dom.iusis.CategoriaFiscal;
import dom.iusis.Clientes;
import dom.iusis.Fiscales;
import dom.iusis.Jueces;
import dom.iusis.Peritos;
import dom.iusis.Estudios;
//import dom.iusis.Programmatic;
import dom.iusis.Testigos;
import dom.iusis.estadoCivil;
import dom.iusis.relacionAbogado;
import dom.iusis.tipoCliente;
import dom.iusis.tipoPersona;

@Named("Personas")
public class RepositorioPersonas extends AbstractFactoryAndRepository {

	public String getId() {
        return "Personas";
    }
//Cambio icono
    public String iconName() {
        return "clientes";
    }
	//Defino nombre etiquetas para la clase
    //@Optional nos define si el campo es obligatorio u opcional
    @MemberOrder(name="Personas", sequence="20.1")//Ordeno la visualizacion del menu
    
    public Clientes ingresarClientes(
	@Named("DNI")final String dni ,
	@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
	@Named("Nombre")final String nombre,
	@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
	@Named("Apellido")final String apellido,
	@TypicalLength(50)
	@Named("Domicilio")final @Optional String domicilio,
	@Named("Estado Civil")final @Optional estadoCivil estadoCivil,
	@Named("Tipo Persona")final @Optional tipoPersona tipoPersona,
	@Named("Fecha Nacimiento")final @Optional Date fechaNacimiento,
	@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
	@Named("Localidad")final @Optional String localidad,
	@Named("Telefono")final @Optional String telefono,
	@Named("Celular")final @Optional String celular,
	@Named("Tipo Cliente")final  @Optional tipoCliente tipoCliente, 
	@MultiLine(numberOfLines=10)//Indica que el campo es multiline y se permiten hasta diez lineas
	@Named("Observaciones")final @Optional String observacion,
	//@Named("Estudio")final @Optional Estudios estudios,
	@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
	@TypicalLength(50)//Defino en 50 caracteres el ancho del campo
	@Named("E-mail")final @Optional String email)

	{
		final Clientes cliente = container.newTransientInstance(Clientes.class);
	   
	    cliente.setDni(dni);
	    cliente.setNombre(nombre);
	    cliente.setApellido(apellido);
	    cliente.setDomicilio(domicilio);
	    cliente.setEstadoCivil(estadoCivil);
	    cliente.setTipoPersona(tipoPersona);
	    cliente.setFechaNacimiento(fechaNacimiento);
	    cliente.setLocalidad(localidad);
	    cliente.setTelefono(telefono);
	    cliente.setCelular(celular);
	    cliente.setTipoCliente(tipoCliente);
	    cliente.setObservacion(observacion);
	    //cliente.setEstudios(estudios);
	    cliente.setEmail(email);

	    container.persistIfNotAlready(cliente);
	    
		return cliente;
	}
	
	//======================================================
		//Defino nombre etiquetas para la clase
	    //@Optional nos define si el campo es obligatorio u opcional
    @MemberOrder(name="Personas", sequence="20.2")//Ordeno la visualizacion del menu
    public Peritos ingresarPeritos(
		
		@Named("DNI")final String dni ,
		@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
		@Named("Nombre")final String nombre,
		@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
		@Named("Apellido")final String apellido,
		@Named("Domicilio")final @Optional String domicilio,
		@Named("Fecha Nacimiento")final @Optional Date fechaNacimiento,
		@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
		@Named("Localidad")final @Optional String localidad,
		@Named("Telefono")final @Optional String telefono,
		@Named("Celular")final @Optional String celular,
		@Named("Tipo Perito")final @Optional String tipoperito,
		@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
		@Named("E-mail")final @Optional String email)
		
		{
			final Peritos perito = container.newTransientInstance(Peritos.class);
			perito.setDni(dni);
		    perito.setNombre(nombre);
		    perito.setApellido(apellido);
		    perito.setDomicilio(domicilio);
		    perito.setFechaNacimiento(fechaNacimiento);
		    perito.setLocalidad(localidad);
		    perito.setTelefono(telefono);
		    perito.setCelular(celular);
		    perito.setTipoPerito(tipoperito);
		    perito.setEmail(email);
		    container.persistIfNotAlready(perito);
		    
			return perito;
		}
    	
    @MemberOrder(name="Personas", sequence="20.3")//Ordeno la visualizacion del menu
	public Abogados ingresarAbogados(
				
				@Named("DNI")final String dni,
				@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
				@Named("Nombre")final String nombre,
				@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
				@Named("Apellido")final String apellido,
				@Named("CUIT")final String cuit,
				@Named("Categoria Fiscal")final CategoriaFiscal CategoriaFiscal,
				@Named("Numero Matricula")final @Optional String numeroMatricula,
				@Named("Domicilio")final @Optional String domicilio,
				@Named("Fecha Nacimiento")final @Optional Date fechaNacimiento,
				@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
				@Named("Localidad")final @Optional String localidad,
				@Named("Telefono")final @Optional String telefono,
				@Named("Celular")final @Optional String celular,
				@Named("Estudio")final @Optional Estudios estudios, 
				@Named("Relacion Abogado")final @Optional relacionAbogado relacionabogado,
				@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
				@Named("E-mail")final @Optional String email)

				{
					final Abogados abogado = container.newTransientInstance(Abogados.class);
				   
				    abogado.setDni(dni);
				    abogado.setNombre(nombre);
				    abogado.setApellido(apellido);
				    abogado.setCuit(cuit);
				    abogado.setCategoriaFiscal(CategoriaFiscal);
				    abogado.setDomicilio(domicilio);
				    abogado.setFechaNacimiento(fechaNacimiento);
				    abogado.setLocalidad(localidad);
				    abogado.setTelefono(telefono);
				    abogado.setCelular(celular);
				    abogado.setEstudios(estudios);
				    abogado.setRelacionAbogado(relacionabogado);
				    abogado.setNumeroMatricula(numeroMatricula);
				    abogado.setEmail(email);

				    container.persistIfNotAlready(abogado);
				    
					return abogado;
				}
				
				//======================================================
    @MemberOrder(name="Personas", sequence="20.4")//Ordeno la visualizacion del menu
    public Testigos ingresarTestigos(
				
				@Named("DNI")final String dni ,
				@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
				@Named("Nombre")final String nombre,
				@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
				@Named("Apellido")final String apellido,
				@Named("Domicilio")final @Optional String domicilio,
				@Named("Fecha Nacimiento")final @Optional Date fechaNacimiento,
				@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
				@Named("Localidad")final @Optional String localidad,
				@Named("Telefono")final @Optional String telefono,
				@Named("Celular")final @Optional String celular,
				@Named("Tipo Abogado")final @Optional String tipoabogado,
				@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
				@Named("E-mail")final @Optional String email)

				{
					final Testigos testigo = container.newTransientInstance(Testigos.class);
				   
				    testigo.setDni(dni);
				    testigo.setNombre(nombre);
				    testigo.setApellido(apellido);
				    testigo.setDomicilio(domicilio);
				    testigo.setFechaNacimiento(fechaNacimiento);
				    testigo.setLocalidad(localidad);
				    testigo.setTelefono(telefono);
				    testigo.setCelular(celular);
				    testigo.setTipoAbogado(tipoabogado);
				    testigo.setEmail(email);

				    container.persistIfNotAlready(testigo);
				    
					return testigo;
				}
				
				//======================================================
    @MemberOrder(name="Personas", sequence="20.5")//Ordeno la visualizacion del menu
public Jueces ingresarJueces(
		
		@Named("DNI")final String dni ,
		@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
		@Named("Nombre")final String nombre,
		@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
		@Named("Apellido")final String apellido,
		@Named("Domicilio")final @Optional String domicilio,
		@Named("Fecha Nacimiento")final @Optional Date fechaNacimiento,
		@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
		@Named("Localidad")final @Optional String localidad,
		@Named("Telefono")final @Optional String telefono,
		@Named("Celular")final @Optional String celular,
		@Named("Tipo Abogado")final @Optional String tipoabogado,
		@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
		@Named("E-mail")final @Optional String email)

		{
			final Jueces juez = container.newTransientInstance(Jueces.class);
		   
		    juez.setDni(dni);
		    juez.setNombre(nombre);
		    juez.setApellido(apellido);
		    juez.setDomicilio(domicilio);
		    juez.setFechaNacimiento(fechaNacimiento);
		    juez.setLocalidad(localidad);
		    juez.setTelefono(telefono);
		    juez.setCelular(celular);
		    juez.setTipoAbogado(tipoabogado);
		    juez.setEmail(email);

		    container.persistIfNotAlready(juez);
		    
			return juez;
		}
		
		//======================================================
    @MemberOrder(name="Personas", sequence="20.6")//Ordeno la visualizacion del menu
public Fiscales ingresarFiscales(
		
		@Named("DNI")final String dni ,
		@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
		@Named("Nombre")final String nombre,
		@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
		@Named("Apellido")final String apellido,
		@Named("Domicilio")final @Optional String domicilio,
		@Named("Fecha Nacimiento")final @Optional Date fechaNacimiento,
		@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
		@Named("Localidad")final @Optional String localidad,
		@Named("Telefono")final @Optional String telefono,
		@Named("Celular")final @Optional String celular,
		@Named("Tipo Abogado")final @Optional String tipoabogado,
		@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
		@Named("E-mail")final @Optional String email)

		{
			final Fiscales fiscal = container.newTransientInstance(Fiscales.class);
		   
		    fiscal.setDni(dni);
		    fiscal.setNombre(nombre);
		    fiscal.setApellido(apellido);
		    fiscal.setDomicilio(domicilio);
		    fiscal.setFechaNacimiento(fechaNacimiento);
		    fiscal.setLocalidad(localidad);
		    fiscal.setTelefono(telefono);
		    fiscal.setCelular(celular);
		    fiscal.setTipoAbogado(tipoabogado);
		    fiscal.setEmail(email);

		    container.persistIfNotAlready(fiscal);
		    
			return fiscal;
		}
		
		//======================================================
    /*
		//Listo todos los clientes en el sistema
		public List<Personas> listarPersonas() {
	        return allMatches(QueryDefault.create(Personas.class, "listarTodasPersonas")); 
		}
		
		//Listo todos los clientes en el sistema
		public List<Abogados> listarAbogados() {
	        return allMatches(QueryDefault.create(Abogados.class, "listarTodosAbogados")); 
		}
		*/
		//Lleno el dropdown list segun el nombre del estudio
		@Hidden
	    public List<Estudios> autoComplete(final String searchPhrase) { 
	    	return allMatches(QueryDefault.create(Estudios.class, "estudiosPorNombre","nombre",searchPhrase));
	    }
    
	@javax.inject.Inject 
	    DomainObjectContainer container;
}