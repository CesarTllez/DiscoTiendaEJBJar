/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.dto.UsuarioDto;
import co.edu.unicundi.discotiendaejbjar.entidad.Rol;
import co.edu.unicundi.discotiendaejbjar.entidad.Token;
import co.edu.unicundi.discotiendaejbjar.entidad.Usuario;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceNotFoundException;
import co.edu.unicundi.discotiendaejbjar.repositorio.ITokenRep;
import co.edu.unicundi.discotiendaejbjar.repositorio.IUsuarioRep;
import co.edu.unicundi.discotiendaejbjar.servicio.IUsuarioServicio;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jasypt.util.text.AES256TextEncryptor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

/**
 * Clase que permite acceder a los métodos que operan la base de datos y
 * valida los datos que proporciona el api.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Stateless
public class UsuarioServicioImp implements IUsuarioServicio{
    
    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private IUsuarioRep repositorio;
    
    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private ITokenRep repositorioToken;
    
    /**
     * Método que retorna el token para el inicio de sesión.
     * @param apodo
     * @param contrasena
     * @return token
     */
    @Override
    public Token login(String apodo, String contrasena) {
        if(this.repositorio.validarExistenciaPorApodo(apodo) == 1){
            if(this.desencriptarContrasena(
                    this.repositorio.buscarPorApodo(apodo).getContrasena())
                    .equals(contrasena)){
                //Llave del token.
                String llaveToken = "pW8xqK91$nBlOCEPD420876@tczH";
                //Fecha cuando se crea el token.
                long fecha = System.currentTimeMillis();
                
                //Restringir servicios por roles.
                Map<String, Object> permisosRol = new HashMap<>();
                permisosRol.put(
                        this.repositorio.buscarPorApodo(apodo).getRol().getId().toString(), 
                        this.repositorio.buscarPorApodo(apodo).getRol().getNombre());
                
                //Creación del token.
                String token = Jwts.builder()
                        .signWith(SignatureAlgorithm.HS512, llaveToken)
                        .setSubject(apodo)
                        .setIssuedAt(new Date( fecha ))
                        .setExpiration(new Date( fecha + 600000 ))
                        .claim("permisos", permisosRol)
                        .compact();
                Token objToken = new Token();
                objToken.setContenido(token);
                this.repositorioToken.registrar(objToken);
                return objToken;
            }else{
                //Crear excepción personalizada - 401 No autorizado
                System.out.println("Excepcion: La contrasena ingresada es incorrecta.");
            }
        }else{
            System.out.println("Excepcion: El apodo ingresado no existe en la base de datos.");
        }
        /*Eliminar cuando se implementen las excepciones.
        */Token t = new Token();
        return t;
        //----------------------------------------------
    }

    /**
     * Método que comprueba si el id existe, si es así, busca el usuario.
     * Además, se hace uso del ModelMapper para cambiar la contraseña
     * encripatada a la original.
     * @param id
     * @return 
     */
    @Override
    public UsuarioDto buscarPorId(Integer id) throws ResourceNotFoundException{
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            UsuarioDto usuarioDto = new UsuarioDto();
            ModelMapper mapper = new ModelMapper();
            mapper.map(this.repositorio.buscarPorId(id), usuarioDto);
            usuarioDto.setContrasena(this.desencriptarContrasena(this.repositorio.buscarPorId(id).getContrasena()));
            usuarioDto.setIdRol(this.repositorio.buscarPorId(id).getRol().getId());
            return usuarioDto;
        }else{
            throw new ResourceNotFoundException("Ese id no existe en la base de datos.");
        }
    }
    
    /**
     * Método que comprueba si el correo existe, si es así, busca el usuario.
     * Además, se hace uso del ModelMapper para cambiar la contraseña
     * encripatada a la original.
     * @param correo
     * @return 
     */
    @Override
    public UsuarioDto buscarPorCorreo(String correo)throws ResourceNotFoundException{
        if(this.repositorio.validarExistenciaPorCorreo(correo) == 1){
            UsuarioDto usuarioDto = new UsuarioDto();
            ModelMapper mapper = new ModelMapper();
            mapper.map(this.repositorio.buscarPorCorreo(correo), usuarioDto);
            usuarioDto.setContrasena(this.desencriptarContrasena(this.repositorio.buscarPorCorreo(correo).getContrasena()));
            usuarioDto.setIdRol(this.repositorio.buscarPorCorreo(correo).getRol().getId());
            return usuarioDto;
        }else{
            throw new ResourceNotFoundException("Ese correo no existe en la base de datos.");

        }

    }

    /**
     * Método que comprueba si la cédula existe, si es así, busca el usuario.
     * Además, se hace uso del ModelMapper para cambiar la contraseña
     * encripatada a la original.
     * @param cedula
     * @return 
     */
    @Override
    public UsuarioDto buscarPorCedula(String cedula)throws ResourceNotFoundException{
        if(this.repositorio.validarExistenciaPorCedula(cedula) == 1){
            UsuarioDto usuarioDto = new UsuarioDto();
            ModelMapper mapper = new ModelMapper();
            mapper.map(this.repositorio.buscarPorCedula(cedula), usuarioDto);
            usuarioDto.setContrasena(this.desencriptarContrasena(this.repositorio.buscarPorCedula(cedula).getContrasena()));
            usuarioDto.setIdRol(this.repositorio.buscarPorCedula(cedula).getRol().getId());
            return usuarioDto;
        }else{
            throw new ResourceNotFoundException("Esa cedula no existe en la base de datos.");
        }
    }

    /**
     * Método que busca a todos los usuarios. Además, se hace uso 
     * del ModelMapper para cambiar la contraseña encripatada a la original.
     * @return 
     */
    @Override
    public List<UsuarioDto> buscarTodo() {
        ModelMapper mapper = new ModelMapper();
        
        //Mapeo de listas con TypeToken.
        List<UsuarioDto> usuarioDto = mapper.map(
                this.repositorio.buscarTodo(), 
                new TypeToken<List<UsuarioDto>>(){}.getType());
        
        for (UsuarioDto usuarioDtoAux : usuarioDto) {
            usuarioDtoAux.setContrasena(
                    this.desencriptarContrasena(
                            this.repositorio.buscarPorId(usuarioDtoAux.getId()).getContrasena()));
            usuarioDtoAux.setIdRol(this.repositorio.buscarPorId(usuarioDtoAux.getId()).getRol().getId());
        }
        return usuarioDto;
    }

    /**
     * Método que comprueba si los datos proporcionados (cédula y correo) no 
     * están registrados con otro usuario, si es así, permite efectur el registro.
     * @param objeto 
     */
    @Override
    public void registrar(Usuario objeto) {
        if(this.repositorio.validarExistenciaPorCedula(objeto.getCedula()) == 1 &&
                this.repositorio.validarExistenciaPorCorreo(objeto.getCorreo()) == 1){
             System.out.println("Excepcion: Actualmente hay un usuario registrado con esa cedula y ese correo.");
        }else{
            if(this.repositorio.validarExistenciaPorCorreo(objeto.getCorreo()) == 1){
                System.out.println("Excepcion: Actualmente hay un usuario registrado con ese correo.");
            }else{
                if(this.repositorio.validarExistenciaPorCedula(objeto.getCedula()) == 1){
                    System.out.println("Excepcion: Actualmente hay un usuario registrado con esa cedula.");
                }else{
                    Rol rol = new Rol();
                    rol.setId(objeto.getIdRol());
                    objeto.setRol(rol);
                    objeto.setContrasena(this.encriptarContrasena(objeto.getContrasena()));
                    this.repositorio.registrar(objeto);
                }
            }
        }
    }

    /**
     * Método que comprueba si el id existe y los datos proporcionados (cédula y correo) no 
     * están registrados con otro usuario, si es así, permite modificar el cliente.
     * @param objeto 
     */
    @Override
    public void actualizar(Usuario objeto) {
        if((objeto.getId() != null)){
            if(this.repositorio.validarExistenciaPorId(objeto.getId()) == 1){
                if((!objeto.getCedula().equals(this.repositorio.buscarPorId(objeto.getId()).getCedula()))){
                    if(this.repositorio.validarExistenciaPorCedula(objeto.getCedula()) == 1){
                        System.out.println("Excepcion: Actualmente, hay un usuario registrado con esa cedula.");
                    }else{
                        objeto.setContrasena(this.encriptarContrasena(objeto.getContrasena()));
                        this.repositorio.actualizar(objeto);
                    }
                }else{
                    System.out.println("Excepcion: No ingreso una cedula diferente.");
                }
            }else{
                System.out.println("Excepcion: No existe ese id en la base de datos.");
            }
        }else{
            System.out.println("Excepcion: Es necesario ingresar un id.");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede
     * a eliminar el usuario por dicho id (JPQL).
     * @param id 
     */
    @Override
    public void eliminarJPQL(Integer id)throws ResourceNotFoundException{
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            this.repositorio.eliminarJPQL(id);
        }else{
          throw new ResourceNotFoundException("No existe ese id en la base de datos.");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede
     * a eliminar el usuario por dicho id (SQL).
     * @param id 
     */
    @Override
    public void eliminarSQL(Integer id)throws ResourceNotFoundException {
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            this.repositorio.eliminarSQL(id);
        }else{
            throw new ResourceNotFoundException("No existe ese id en la base de datos.");
        }
    }
    
    /**
     * Método que permite encriptar la contrasena haciendo uso de
     * la librería Jasypt.
     * @param contrasena
     * @return 
     */
    private String encriptarContrasena(String contrasena){
        AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
        aesEncryptor.setPassword("/CEJD/");
        String contrasenaEncriptada = aesEncryptor.encrypt(contrasena);
        return contrasenaEncriptada;
    }
    
    /**
     * Método que permite desencriptar la contrasena haciendo uso de
     * la librería Jasypt.
     * @param contrasena
     * @return 
     */
    private String desencriptarContrasena(String contrasena){
        AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
        aesEncryptor.setPassword("/CEJD/");
        String contrasenaDesencriptada = aesEncryptor.decrypt(contrasena);
        return contrasenaDesencriptada;
    }
    
}
