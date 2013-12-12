package brk;

import javax.faces.bean.ManagedBean;

import java.sql.*;
import java.util.ArrayList;

import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.map.LatLng;

import java.io.Serializable;

@ManagedBean(name="bb")
@SessionScoped
public class UyeBeann  {
	
	 
	
	 private String bostzman="5",sicaklik="10000",sogutma="0.9";
	
	 
	 public String getSogutma() {
		return sogutma;
	}

	public void setSogutma(String sogutma) {
		this.sogutma = sogutma;
	}

	public void uyeGirisiniDenetle(){
		
		 
		 
		 
		
	
	
	}
	public String getbostzman() {
		return bostzman;
	}



	public void setbostzman(String uyebostzman, String bostzman) {
		this.bostzman = bostzman;
	}



	public String getsicaklik() {
		return sicaklik;
	}



	public void setsicaklik(String sicaklik) {
		this.sicaklik = sicaklik;
	}



	
	
	
	
}
