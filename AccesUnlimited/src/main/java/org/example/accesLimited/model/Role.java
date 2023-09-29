package org.example.accesLimited.model;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Role")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roleId")
	private Integer roleId;

	private String authority;
	
	
		/* Constructeurs*/
	
	public Role() {
		super();
	}

	public Role(String authority) {
		this.authority = authority;
	}

	public Role(Integer roleId, String authority) {
		this.roleId = roleId;
		this.authority = authority;
	}

	
		/* Getters et Setters */
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("unimplmented method 'getAuthority'");
	}

}
