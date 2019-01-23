/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author Lolcathost
 */
@ManagedBean (name = "formulario")
@RequestScoped
@SessionScoped
public class Formulario {

    private String nombre, direccion, telefono, pais, importe;
    private static final String ES = "Español";
    private static final String US = "Ingles";
    private static final String[] NOMBRES_PAIS = {ES, US};
    private static ArrayList paises = null;
    static Locale myLocale=Locale.getDefault();
    private static String miIdioma = myLocale.getLanguage();
    
    public Formulario() {
    }
    
    public ArrayList getPaises() {
        if (paises == null){
            paises = new ArrayList();
            for (int i = 0;i< NOMBRES_PAIS.length;i++){
                paises.add(new SelectItem(NOMBRES_PAIS[i]));
            }
        }
        return paises;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }
    public void cambioPais(ValueChangeEvent e){
     
        miIdioma=e.getNewValue().toString();
        if (US.equals(miIdioma)){
        myLocale = new Locale("en","US");
        } else if(ES.equals(miIdioma)) {
        myLocale = new Locale ("es","ES");
        }
        FacesContext.getCurrentInstance().getViewRoot().setLocale(myLocale);
    }
    
    
    
    
}
