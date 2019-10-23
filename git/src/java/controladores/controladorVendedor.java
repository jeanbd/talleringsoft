/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ControladorDatabase.VendedorFacade;
import Entitys.Vendedor;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class controladorVendedor {

    @EJB
    private VendedorFacade controladorVendedor;

    private List<Vendedor> vendedor;

    private int cedula;
    private String nombre;
    private String apellido;
    private int telefono;
    private String correo;
private String mensaje;

    public List<Vendedor> getVendedor() {
        return vendedor;
    }

    public void setVendedor(List<Vendedor> vendedor) {
        this.vendedor = vendedor;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    private String clave;

    public VendedorFacade getControladorVendedor() {
        return controladorVendedor;
    }

    public void setControladorVendedor(VendedorFacade controladorVendedor) {
        this.controladorVendedor = controladorVendedor;
    }

    public List<Vendedor> getVendecor() {
        return vendedor;
    }

    public void setVendecor(List<Vendedor> vendedor) {
        this.vendedor = vendedor;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void hacerAlgo() {
 try{
        Vendedor obj = new Vendedor();
        obj.setCedula(cedula);
        obj.setNombre(nombre);
        obj.setApellido(apellido);
        obj.setTelefono(telefono);
        obj.setCorreo(correo);
        obj.setClave(clave);

        controladorVendedor.create(obj);

        }catch(Exception e){
            mensaje = "ERROR AL CREAR EL USUARIO";
            System.out.println("Error.....");
        } 
 
   }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
 public String iniciarSeion() {
        
        List<Vendedor> obj = controladorVendedor.iniciarSesion(correo, clave);
        
        if (obj.isEmpty()) {
            return "index.xhtml";  
        } else {
            return "newxhtml.xhtml";
        }
    }

    public void consultar() {

        vendedor = controladorVendedor.findAll();

    }

    public void eliminarVendedor(Vendedor temp) {
        controladorVendedor.remove(temp);
        consultar();
    }

    public void editarVendedor(Vendedor obje) {

        controladorVendedor.edit(obje);

    }

    public String vendedor() {
        return "vendedor.xhtml";
    }

    public String login() {
        return "login.xhtml";
    }

    public String regresar() {
        return "index.xhtml";
    }
    public String principal() {
        return "principal.xhtml";
    }

  
    
   
     
}
