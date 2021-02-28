package cf.dinhthanhphu.model;

public class commentModel extends AbstractModel<commentModel>{
	private String content;
	private long userID;
	private long newID;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public long getNewID() {
		return newID;
	}
	public void setNewID(long newID) {
		this.newID = newID;
	}
}
