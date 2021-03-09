package cf.dinhthanhphu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "status")
	private Integer status;

	//EAGER là chạy lấy nhựng quan hệ bên trong, vd bên dưới là khi load user thì nó load lun role cũng lúc đó
	// nếu dữ liệu lớn thì load sâu vào bên trong thxì hiệu năng sẽ giảm.
	// nên sử dụng lazy thì khi load user thì role chưa load
	//theo quy tắc n-n sẽ tạo ra bảng mới lầy khóa chính 2 bảng về làm khóa chính
	//ở đầy sẽ tạo ra bảng có tên là user_role, @JoinColumn là tên 2 cột trong bảng 
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"),//joincolums là sẽ nối với bảng đang đứng
								   inverseJoinColumns = @JoinColumn(name = "roleid"))// inverseJoinColumns là sẽ nối với bảng mappedBy tới
	private List<RoleEntity> roles = new ArrayList<>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

}
