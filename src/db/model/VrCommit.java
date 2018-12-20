package db.model;

import java.sql.Timestamp;

public class VrCommit {
	private Integer commitId = 0;
	/**
	 * pass,wait,reject
	 */
	private Integer hash = 0;
	private String commitState = "wait";
	private String commitContext = null;
	private Timestamp commitSubmitTime = null;
	private Integer custId = null;
	private Integer adminId = null;
	private String commitType = "short";
	
	
	
	public Integer getHash() {
		return hash;
	}
	public void setHash(Integer hash) {
		this.hash = hash;
	}
	public Timestamp getCommitSubmitTime() {
		return commitSubmitTime;
	}
	public void setCommitSubmitTime(Timestamp commitSubmitTime) {
		this.commitSubmitTime = commitSubmitTime;
	}
	public Integer getCommitId() {
		return commitId;
	}
	public String getCommitType() {
		return commitType;
	}
	public void setCommitType(String commitType) {
		this.commitType = commitType;
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

	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	
	
}
