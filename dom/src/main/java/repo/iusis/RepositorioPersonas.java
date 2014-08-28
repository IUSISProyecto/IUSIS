package repo.iusis;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MultiLine;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.RegEx;
import org.apache.isis.applib.annotation.TypicalLength;
import org.apache.isis.applib.query.QueryDefault;

import dom.iusis.Abogados;
import dom.iusis.Clientes;
import dom.iusis.Fiscales;
import dom.iusis.Jueces;
import dom.iusis.Peritos;
import dom.iusis.Personas;
import dom.iusis.Estudios;
import dom.iusis.Testigos;
import dom.iusis.relacionAbogado;
import dom.iusis.tipoCliente;

@Named("Administrar Personas")
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
	public Clientes ingresarClientes(
	
	@Named("DNI")final String dni ,
	@RegEx(validation = "[A-Za-z ]+")
	@Named("Nombre")final String nombre,
	@RegEx(validation = "[A-Za-z ]+")
	@Named("Apellido")final String apellido,
	@TypicalLength(50)
	@Named("Direccion")final String direccion,
	@Named("Fecha Nacimiento")final Date fechaNacimiento,
	@RegEx(validation = "[A-Za-z ]+")
	@Named("Localidad")final String localidad,
	@Named("Telefono")final @Optional String telefono,
	@Named("Celular")final @Optional String celular,
	@Named("Tipo Cliente")final  @Optional tipoCliente tipoCliente, 
	@MultiLine(numberOfLines=10)//Indica que el campo es multiline y se permiten hasta diez lineas
	@Named("Observaciones")final @Optional String observacion,
	@Named("Estudio")final @Optional Estudios estudios,
	@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
	@TypicalLength(50)//Defino en 50 caracteres el ancho del campo
	@Named("E-mail")final @Optional String email)

	{
		final Clientes cliente = container.newTransientInstance(Clientes.class);
	   
	    cliente.setDni(dni);
	    cliente.setNombre(nombre);
	    cliente.setApellido(apellido);
	    cliente.setDireccion(direccion);
	    cliente.setFechaNacimiento(fechaNacimiento);
	    cliente.setLocalidad(localidad);
	    cliente.setTelefono(telefono);
	    cliente.setCelular(celular);
	    cliente.setTipoCliente(tipoCliente);
	    cliente.setObservacion(observacion);
	    cliente.setEstudios(estudios);
	    cliente.setEmail(email);

	    container.persistIfNotAlready(cliente);
	    
		return cliente;
	}
	
	//======================================================
		//Defino nombre etiquetas para la clase
	    //@Optional nos define si el campo es obligatorio u opcional
		public Peritos ingresarPeritos(
		
		@Named("DNI")final String dni ,
		@RegEx(validation = "[A-Za-z ]+")
		@Named("Nombre")final String nombre,
		@RegEx(validation = "[A-Za-z ]+")
		@Named("Apellido")final String apellido,
		@Named("Direccion")final String direccion,
		@Named("Fecha Nacimiento")final Date fechaNacimiento,
		@RegEx(validation = "[A-Za-z ]+")
		@Named("Localidad")final String localidad,
		@Named("Telefono")final @Optional String telefono,
		@Named("Celular")final @Optional String celular,
		@Named("Tipo Perito")final String tipoperito,
		@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
		@Named("E-mail")final @Optional String email)
		
		{
			final Peritos perito = container.newTransientInstance(Peritos.class);
			perito.setDni(dni);
		    perito.setNombre(nombre);
		    perito.setApellido(apellido);
		    perito.setDireccion(direccion);
		    perito.setFechaNacimiento(fechaNacimiento);
		    perito.setLocalidad(localidad);
		    perito.setTelefono(telefono);
		    perito.setCelular(celular);
		    perito.setTipoPerito(tipoperito);
		    perito.setEmail(email);
		    container.persistIfNotAlready(perito);
		    
			return perito;
		}
		
		public Abogados ingresarAbogados(
				
				@Named("DNI")final String dni ,
				@RegEx(validation = "[A-Za-z ]+")
				@Named("Nombre")final String nombre,
				@RegEx(validation = "[A-Za-z ]+")
				@Named("Apellido")final String apellido,
				@Named("Numero Matricula")final String numeroMatricula,
				@Named("Direccion")final String direccion,
				@Named("Fecha Nacimiento")final Date fechaNacimiento,
				@RegEx(validation = "[A-Za-z ]+")
				@Named("Localidad")final String localidad,
				@Named("Telefono")final @Optional String telefono,
				@Named("Celular")final @Optional String celular,
				@Named("Relacion Abogado")final @Optional relacionAbogado relacionabogado,
				@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
				@Named("E-mail")final @Optional String email)

				{
					final Abogados abogado = container.newTransientInstance(Abogados.class);
				   
				    abogado.setDni(dni);
				    abogado.setNombre(nombre);
				    abogado.setApellido(apellido);
				    abogado.setDireccion(direccion);
				    abogado.setFechaNacimiento(fechaNacimiento);
				    abogado.setLocalidad(localidad);
				    abogado.setTelefono(telefono);
				    abogado.setCelular(celular);
				    abogado.setRelacionAbogado(relacionabogado);
				    abogado.setNumeroMatricula(numeroMatricula);
				    abogado.setEmail(email);

				    container.persistIfNotAlready(abogado);
				    
					return abogado;
				}
				
				//======================================================
		
public Testigos ingresarTestigos(
				
				@Named("DNI")final String dni ,
				@RegEx(validation = "[A-Za-z ]+")
				@Named("Nombre")final String nombre,
				@RegEx(validation = "[A-Za-z ]+")
				@Named("Apellido")final String apellido,
				@Named("Direccion")final String direccion,
				@Named("Fecha Nacimiento")final Date fechaNacimiento,
				@RegEx(validation = "[A-Za-z ]+")
				@Named("Localidad")final String localidad,
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
				    testigo.setDireccion(direccion);
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

public Jueces ingresarJueces(
		
		@Named("DNI")final String dni ,
		@RegEx(validation = "[A-Za-z ]+")
		@Named("Nombre")final String nombre,
		@RegEx(validation = "[A-Za-z ]+")
		@Named("Apellido")final String apellido,
		@Named("Direccion")final String direccion,
		@Named("Fecha Nacimiento")final Date fechaNacimiento,
		@RegEx(validation = "[A-Za-z ]+")
		@Named("Localidad")final String localidad,
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
		    juez.setDireccion(direccion);
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

public Fiscales ingresarFiscales(
		
		@Named("DNI")final String dni ,
		@RegEx(validation = "[A-Za-z ]+")
		@Named("Nombre")final String nombre,
		@RegEx(validation = "[A-Za-z ]+")
		@Named("Apellido")final String apellido,
		@Named("Direccion")final String direccion,
		@Named("Fecha Nacimiento")final Date fechaNacimiento,
		@RegEx(validation = "[A-Za-z ]+")
		@Named("Localidad")final String localidad,
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
		    fiscal.setDireccion(direccion);
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

		//Listo todos los clientes en el sistema
		public List<Personas> listarPersonas() {
	        return allMatches(QueryDefault.create(Personas.class, "listarTodasPersonas")); 
		}
		
		//Listo todos los clientes en el sistema
		public List<Abogados> listarAbogados() {
	        return allMatches(QueryDefault.create(Abogados.class, "listarTodosAbogados")); 
		}
		
		//Lleno el dropdown list segun el nombre del estudio
		@Hidden
	    public List<Estudios> autoComplete(final String searchPhrase) { 
	    	return allMatches(QueryDefault.create(Estudios.class, "estudiosPorNombre","nombre",searchPhrase));
	    }
	@javax.inject.Inject 
	    DomainObjectContainer container;
}
