/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import static model.Formulario.myLocale;

/**
 *
 * @author lolcat
 */
@ManagedBean ( name = "tienda" )
@SessionScoped
public class BeanTienda {
    
    public String userdef = "admin" ;
    public String passdef = "admin" ;
    public boolean valida = false;
    public String user = "" ;
    public String pass = "" ;
    public String componente = "" ;
    
    /**
     * Creates a new instance of BeanTienda
     */
    public BeanTienda() {
    }
    public String paginaenvio() {
       FacesContext.getCurrentInstance().getViewRoot().setLocale(myLocale);
        return componente;}
    public String getUser() {return user;}
    public String getPass() {return pass;}
    public String getComponente() {return componente;}
    public void setUser(String user) {this.user = user;}
    public void setPass(String pass) {this.pass = pass;}
    public void setComponente(String componente) {this.componente = componente;}
   
 
    public String pagarp(){
    FacesContext.getCurrentInstance().getViewRoot().setLocale(myLocale);
    return "pago";
    }
    public String finalizar(){
    FacesContext.getCurrentInstance().getViewRoot().setLocale(myLocale);
    return "finalizar";
    }
    public String validar() {
       
       
         FacesContext.getCurrentInstance().getViewRoot().setLocale(myLocale);   
        if((userdef == null ? user == null : userdef.equals(user)) && (pass == null ? passdef == null : pass.equals(passdef)))
        {
             
            return "tienda";
        }else
            return "intro";
        }
}
