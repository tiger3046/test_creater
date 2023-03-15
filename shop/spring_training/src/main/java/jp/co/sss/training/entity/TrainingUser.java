package jp.co.sss.training.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="training_user")
public class TrainingUser {
	
	@Id
	private int id;
	@Column
	private String userId;
	@Column
	private String password;
	
	public Integer getId() {
        return id;
	}
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String name) {
        this.userId = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
