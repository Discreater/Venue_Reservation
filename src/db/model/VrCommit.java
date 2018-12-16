package db.model;

import java.sql.Date;

public class VrCommit {
	private Integer commitId = null;
	/**
	 * pass,wait,reject
	 */
	private String commitState = "wait";
	private String commitContext = null;
	private Date commitSubmitTime = null;
	private Integer cust_id = null;
	private Integer admin_id = null;
	
	
	public Integer getCommitId() {
		return commitId;
	}
	public void setCommitId(Integer commitId) {
		this.commitId = commitId;
	}
	public String getCommitState() {
		return commitState;
	}
	public void setCommitState(String commitState) {
		this.commitState = commitState;
	}
	public String getCommitContext() {
		return commitContext;
	}
	public void setCommitContext(String commitContext) {
		this.commitContext = commitContext;
	}
	public Date getCommitSubmitTime() {
		return commitSubmitTime;
	}
	public void setCommitSubmitTime(Date commitSubmitTime) {
		this.commitSubmitTime = commitSubmitTime;
	}
	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	
	
}
