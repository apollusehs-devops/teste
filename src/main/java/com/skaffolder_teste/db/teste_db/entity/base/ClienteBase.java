/* 
* Generated by
* 
*      _____ _          __  __      _     _
*     / ____| |        / _|/ _|    | |   | |
*    | (___ | | ____ _| |_| |_ ___ | | __| | ___ _ __
*     \___ \| |/ / _` |  _|  _/ _ \| |/ _` |/ _ \ '__|
*     ____) |   < (_| | | | || (_) | | (_| |  __/ |
*    |_____/|_|\_\__,_|_| |_| \___/|_|\__,_|\___|_|
*
* The code generator that works in many programming languages
*
*			https://www.skaffolder.com
*
*
* You can generate the code from the command-line
*       https://npmjs.com/package/skaffolder-cli
*
*       npm install -g skaffodler-cli
*
*   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
*
* To remove this comment please upgrade your plan here: 
*      https://app.skaffolder.com/#!/upgrade
*
* Or get up to 70% discount sharing your unique link:
*       https://app.skaffolder.com/#!/register?friend=5ea8cb8382f82d390e77f827
*
* You will get 10% discount for each one of your friends
* 
*/
package com.skaffolder_teste.db.teste_db.entity.base;

/**
 * 
 * 
  _____                      _              _ _ _     _   _     _        __ _ _      
 |  __ \                    | |            | (_) |   | | | |   (_)      / _(_) |     
 | |  | | ___    _ __   ___ | |_    ___  __| |_| |_  | |_| |__  _ ___  | |_ _| | ___ 
 | |  | |/ _ \  | '_ \ / _ \| __|  / _ \/ _` | | __| | __| '_ \| / __| |  _| | |/ _ \
 | |__| | (_) | | | | | (_) | |_  |  __/ (_| | | |_  | |_| | | | \__ \ | | | | |  __/
 |_____/ \___/  |_| |_|\___/ \__|  \___|\__,_|_|\__|  \__|_| |_|_|___/ |_| |_|_|\___|
 
                                                                                   
 * DO NOT EDIT THIS FILE!! 
 *
 *  FOR CUSTOMIZE ClienteBase PLEASE EDIT ../Cliente.java
 * 
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER CODE GENERATION --
 * 
 */
 

/**
 * This is the model of Cliente object
 * 
 */

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import java.util.stream.Collectors;

import com.skaffolder_teste.db.teste_db.entity.Cliente;
// Import relations
import com.skaffolder_teste.db.teste_db.entity.User;




@MappedSuperclass
public class ClienteBase {
	
	@Id
	@GeneratedValue
	private Long _id;
	
	// Attributes
	@Column(nullable=false)
    private String Nome;
	@Column(nullable=false,unique=true)
    private String Telefone;
	
	// Relations Cliente_User
	@ManyToOne(fetch = FetchType.LAZY)
	private User Cliente_User;
	
	
	
	public Long get_id() {
		return _id;
	}

	public void set_id(Long id) {
		this._id = id;
	}
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String Telefone) {
		this.Telefone = Telefone;
	}
    
	public void setUser(String Cliente_User) {
		this.Cliente_User = new User(Cliente_User);
	}

	public User getCliente_User() {
		return Cliente_User;
	}
	

    
}