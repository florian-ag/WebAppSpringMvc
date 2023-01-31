package fr.formation.inti.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class Users {

	private Integer userId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date date;
	private String roleName;
//	private Set<Users> roles = new HashSet<Users>(0);

	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Users(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Users(Integer userId, String email, String password, String firstName, String lastName, Date date,
			String roleName) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.roleName = roleName;
	}



	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "UserId", unique = true, nullable = false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "date", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Column(name = "rolename")
	public String getRoleName() {
		return roleName;
	}

	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
//	public Set<Users> getRoles() {
//		return roles;
//	}
//
//	
//	public void setRoles(Set<Users> roles) {
//		this.roles = roles;
//	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", date=" + date + ", roleName=" + roleName + "]";
	}

	
	
	
	
	
}
