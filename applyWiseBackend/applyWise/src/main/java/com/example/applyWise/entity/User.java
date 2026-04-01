package com.example.applyWise.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id ;
	
	private String name ;
	
	@Column(unique = true , nullable=false)
	private String email ;
	
	private String password ;
	
	@Enumerated(EnumType.STRING)
	private Role role ;
	
	@Builder.Default
	private boolean isActive = true;
	
	@Builder.Default
	private LocalDateTime createdAt = LocalDateTime.now() ;

	public User() {
		// TODO Auto-generated constructor stub
	}
	


	public User( String name, String email, String password, Role role, boolean isActive,
			LocalDateTime createdAt) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
		this.createdAt = createdAt;
	}



	public User(String name ,String email2, String password2, Role role2) {
		this.name= name ;
		this.email = email2; 
		this.password = password2 ;
		this.role = role2 ;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", isActive=" + isActive + ", createdAt=" + createdAt + "]";
	}
	
	
	

}

