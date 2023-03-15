package jp.co.sss.training.Form;

import jp.co.sss.training.entity.TrainingUser;

public class Form {
	private String userId;
	
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TrainingUser getUser() {
	    TrainingUser user = new TrainingUser();
	    user.setUserId(this.userId);
	    user.setPassword(this.password);
	    return user;
	}
}
