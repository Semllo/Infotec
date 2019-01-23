/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import static model.Formulario.myLocale;

/**
 *
 * @author lolcat
 */
@ManagedBean(name = "componente")
@SessionScoped
public class BeanComponente {

  
    // Obtener los componentes
    String hdisk = null, ram = null, micro = null,  String, grafica = null;
    // Obtener los precios de los Componentes
    int preciomic, preciodisk, precioram, preciograp;
    // Obtener los nombres de los Componentes
    String nombremic, nombredisk, nombreram, nombregrap;
    // Precio total
    int total;

   
   

   //Metodos GET
    public String getGrafica() {return grafica;}
    public String getMicro() {return micro;}
    public String getRam() {return ram;}
    public String getHdisk() {return hdisk;}
    
     
   //Metodos SET - Añade valores
    public void setRam(String ram) {
        precioram = sacaPrecio(ram);
        nombreram = sacaArt(ram); 
        this.ram = ram;
    }
    public void setHdisk(String hdisk) {
        preciodisk = sacaPrecio(hdisk);
        nombredisk = sacaArt(hdisk); 
        this.hdisk = hdisk;
    }
    public void setGrafica(String grafica) {
      
        preciograp = sacaPrecio(grafica);
        nombregrap = sacaArt(grafica); 
        this.grafica = grafica;
    }
    public void setMicro(String micro) {
        preciomic = sacaPrecio(micro);
        nombremic = sacaArt(micro); 
        this.micro = micro;
    }
    
    //Validar si se han seleccionado todos los componentes
    public boolean valida(String a, String b, String c, String d) {
        return a != null && b != null && c != null && d != null;
    }

    public String carro() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(myLocale);
        if (valida(hdisk, ram, micro, grafica)){return "carro";}
        else {return "tienda";}
    }
 
    public String pagar() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(myLocale);
        if (valida(hdisk, ram, micro, grafica)){return "pago";}
        else {return "tienda";}
       
    }
    
    //Sacar los precios de manera individual
    public int sacaPrecio(String entrada){      
        String precio[] = entrada.split("@");
        int valor = Integer.parseInt(precio[1]);
        return valor;        
    }
    
    //Sacar los nombres de manera individual
    public String sacaArt(String entrada){
        String precio[] = entrada.split("@");
        return precio[0];
     }
    
    //Metodos GET para enviar la informacion de los componentes
    public int getPreciomic() {return preciomic;}
    public int getPreciodisk() {return preciodisk;}
    public int getPrecioram() {return precioram;}
    public int getPreciograp() {return preciograp;}
    public String getNombremic() {return nombremic;}
    public String getNombredisk() {return nombredisk;}
    public String getNombreram() {return nombreram;}
    public String getNombregrap() {return nombregrap;}
    //Sumar todos los precios de los componentes elegidos
    public int getTotal() {
        total=sacaPrecio(hdisk)+sacaPrecio(ram)+sacaPrecio(micro)+sacaPrecio(grafica);
        return total;
    }
}
