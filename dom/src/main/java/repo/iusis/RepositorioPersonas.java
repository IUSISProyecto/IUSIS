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

import dom.iusis.Abogado;
import dom.iusis.CategoriaFiscal;
import dom.iusis.ClienteFisico;
import dom.iusis.ClienteJuridico;
import dom.iusis.EstadoCivil;
import dom.iusis.Estudio;
import dom.iusis.Fiscal;
import dom.iusis.Juez;
import dom.iusis.Perito;
import dom.iusis.RelacionAbogado;
import dom.iusis.Testigo;
import dom.iusis.TipoCliente;


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
    public ClienteFisico ingresarClienteFisico(
	@Named("DNI")final String dni ,
	@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
	@Named("Nombre")final String nombre,
	@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
	@Named("Apellido")final String apellido,
	@Named("Cuil")final @Optional String cuil,
	@Named("Cuit")final @Optional String cuit,
	@TypicalLength(50)
	@Named("Domicilio")final @Optional String domicilio,
	@Named("Estado Civil")final @Optional EstadoCivil estadoCivil,
	@Named("Fecha Nacimiento")final @Optional Date fechaNacimiento,
	@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
	@Named("Localidad")final @Optional String localidad,
	@Named("Telefono")final @Optional String telefono,
	@Named("Celular")final @Optional String celular,
	@Named("Tipo Cliente")final  @Optional TipoCliente tipoCliente, 
	@MultiLine(numberOfLines=10)//Indica que el campo es multiline y se permiten hasta diez lineas
	@Named("Observaciones")final @Optional String observacion,
	//@Named("Estudio")final @Optional Estudios estudios,
	@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
	@TypicalLength(50)//Defino en 50 caracteres el ancho del campo
	@Named("E-mail")final @Optional String email)

	{
		final ClienteFisico clientefisico = container.newTransientInstance(ClienteFisico.class);
	   
	    clientefisico.setDni(dni);
	    clientefisico.setNombre(nombre);
	    clientefisico.setApellido(apellido);
	    clientefisico.setCuil(cuil);
	    clientefisico.setCuit(cuit);
	    clientefisico.setDomicilio(domicilio);
	    clientefisico.setEstadoCivil(estadoCivil);
	    clientefisico.setFechaNacimiento(fechaNacimiento);
	    clientefisico.setLocalidad(localidad);
	    clientefisico.setTelefono(telefono);
	    clientefisico.setCelular(celular);
	    clientefisico.setTipoCliente(tipoCliente);
	    clientefisico.setObservacion(observacion);
	    //cliente.setEstudios(estudios);
	    clientefisico.setEmail(email);

	    container.persistIfNotAlready(clientefisico);
	    
		return clientefisico;
	}
	
    @MemberOrder(name="Personas", sequence="20.2")//Ordeno la visualizacion del menu
    public ClienteJuridico ingresarClienteJuridico(
    		@Named("DNI")final String dni ,
    		@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
    		@Named("Nombre")final String nombre,
    		@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
    		@Named("Apellido")final String apellido,
    		@Named("Cuil")final @Optional String cuil,
    		@Named("Cuit")final @Optional String cuit,
    		@Named("Razon Social")@Optional String razonsocial,
    		@Named("Tipo Societario")@Optional String tiposocietario,
    		@Named("Domilicio Constituido")@Optional String domicilioconstituido,
    		@Named("Sucursales")@Optional String sucursales,
    		@TypicalLength(50)
    		@Named("Domicilio")final @Optional String domicilio,
    		@Named("Estado Civil")final @Optional EstadoCivil estadoCivil,
    		@Named("Fecha Nacimiento")final @Optional Date fechaNacimiento,
    		@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
    		@Named("Localidad")final @Optional String localidad,
    		@Named("Telefono")final @Optional String telefono,
    		@Named("Celular")final @Optional String celular,
    		@Named("Tipo Cliente")final  @Optional TipoCliente tipoCliente, 
    		@MultiLine(numberOfLines=10)//Indica que el campo es multiline y se permiten hasta diez lineas
    		@Named("Observaciones")final @Optional String observacion,
    		//@Named("Estudio")final @Optional Estudios estudios,
    		@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
    		@TypicalLength(50)//Defino en 50 caracteres el ancho del campo
    		@Named("E-mail")final @Optional String email)

    		{
    			final ClienteJuridico clientejuridico = container.newTransientInstance(ClienteJuridico.class);
    		   
    		    clientejuridico.setDni(dni);
    		    clientejuridico.setNombre(nombre);
    		    clientejuridico.setApellido(apellido);
    		    clientejuridico.setCuil(cuil);
    		    clientejuridico.setCuit(cuit);
    		    clientejuridico.setRazonsocial(razonsocial);
    		    clientejuridico.setTiposocietario(tiposocietario);
    		    clientejuridico.setDomilicioconstituido(domicilioconstituido);
    		    clientejuridico.setSucursales(sucursales);
    		    clientejuridico.setDomicilio(domicilio);
    		    clientejuridico.setEstadoCivil(estadoCivil);
    		    clientejuridico.setFechaNacimiento(fechaNacimiento);
    		    clientejuridico.setLocalidad(localidad);
    		    clientejuridico.setTelefono(telefono);
    		    clientejuridico.setCelular(celular);
    		    clientejuridico.setTipoCliente(tipoCliente);
    		    clientejuridico.setObservacion(observacion);
    		    //cliente.setEstudios(estudios);
    		    clientejuridico.setEmail(email);

    		    container.persistIfNotAlready(clientejuridico);
    		    
    			return clientejuridico;
    		}
    
    @MemberOrder(name="Personas", sequence="20.3")//Ordeno la visualizacion del menu
	public Abogado ingresarAbogados(
				
				@Named("DNI")final String dni,
				@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
				@Named("Nombre")final String nombre,
				@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
				@Named("Apellido")final String apellido,
				@Named("CUIT")final String cuit,
				@Named("Categoria Fiscal")final CategoriaFiscal CategoriaFiscal,
				@Named("Numero Matricula")final @Optional String numeroMatricula,
				@RegEx(validation="\\d{6,8}")//Sirve para delimitar el tipo de caracteres a ingresar
				@Named("Tomo")final @Optional int tomo,
				@RegEx(validation="\\d{6,8}")//Sirve para delimitar el tipo de caracteres a ingresar
				@Named("Folio")final @Optional int folio,
				@Named("Colegio de Abogados")final @Optional String colegioAbogados,
				@Named("Domicilio")final @Optional String domicilio,
				@Named("Fecha Nacimiento")final @Optional Date fechaNacimiento,
				@RegEx(validation = "[a-z A-Záéíóú]+")//Sirve para delimitar el tipo de caracteres a ingresar
				@Named("Localidad")final @Optional String localidad,
				@Named("Telefono")final @Optional String telefono,
				@Named("Celular")final @Optional String celular,
				@Named("Estudio")final @Optional Estudio estudio, 
				@Named("Relacion Abogado")final @Optional RelacionAbogado relacionabogado,
				@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
				@Named("E-mail")final @Optional String email)

				{
					final Abogado abogado = container.newTransientInstance(Abogado.class);
				   
				    abogado.setDni(dni);
				    abogado.setNombre(nombre);
				    abogado.setApellido(apellido);
				    abogado.setCuit(cuit);
				    abogado.setCategoriaFiscal(CategoriaFiscal);
				    abogado.setNumeroMatricula(numeroMatricula);
				    abogado.setTomo(tomo);
				    abogado.setFolio(folio);
				    abogado.setColegioAbogados(colegioAbogados);
				    abogado.setDomicilio(domicilio);
				    abogado.setFechaNacimiento(fechaNacimiento);
				    abogado.setLocalidad(localidad);
				    abogado.setTelefono(telefono);
				    abogado.setCelular(celular);
				    abogado.setEstudio(estudio);
				    abogado.setRelacionAbogado(relacionabogado);
				    abogado.setEmail(email);

				    container.persistIfNotAlready(abogado);
				    
					return abogado;
				}
				
				//======================================================
    
  //======================================================
  		//Defino nombre etiquetas para la clase
  	    //@Optional nos define si el campo es obligatorio u opcional
      @MemberOrder(name="Personas", sequence="20.4")//Ordeno la visualizacion del menu
      public Perito ingresarPeritos(
  		
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
  			final Perito perito = container.newTransientInstance(Perito.class);
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
    
    @MemberOrder(name="Personas", sequence="20.5")//Ordeno la visualizacion del menu
    public Testigo ingresarTestigos(
				
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
					final Testigo testigo = container.newTransientInstance(Testigo.class);
				   
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
    @MemberOrder(name="Personas", sequence="20.6")//Ordeno la visualizacion del menu
public Juez ingresarJueces(
		
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
			final Juez juez = container.newTransientInstance(Juez.class);
		   
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
@MemberOrder(name="Personas", sequence="20.7")//Ordeno la visualizacion del menu
public Fiscal ingresarFiscales(
		
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
			final Fiscal fiscal = container.newTransientInstance(Fiscal.class);
		   
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
	    public List<Estudio> autoComplete(final String searchPhrase) { 
	    	return allMatches(QueryDefault.create(Estudio.class, "estudiosPorNombre","nombre",searchPhrase));
	    }
    
	@javax.inject.Inject 
	    DomainObjectContainer container;
}