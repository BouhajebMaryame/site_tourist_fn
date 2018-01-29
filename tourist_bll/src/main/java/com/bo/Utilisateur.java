package com.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nomUser;
    private String prenomUser;
    @Column(unique=true)
    private String mail;
    private String motPasse;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
 		@JoinColumn(name = "user_id")
 	   private List<Destination> destinations;
  
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_fk")
	private Role_tourist role;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getPrenomUser() {
		return prenomUser;
	}
	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public List<Destination> getDestinations() {
		return destinations;
	}
	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}
	public Role_tourist getRole() {
		return role;
	}
	public void setRole(Role_tourist role) {
		this.role = role;
	}
   
	public boolean equals(String email,String pass)
	{
		if(this.mail.equals(email) && this.motPasse.equals(pass))
		{
			return true;
		}
		return false;
	}
        
    
}