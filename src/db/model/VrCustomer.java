package db.model;

import java.sql.Date;
import java.util.List;

/**
 * 普通用户数据
 * @author Tqq
 *
 */
public class VrCustomer {
	private Integer custId;
	private String custName;
	private String custPassword;
	private String realName;
	private String custPhone;
	private String custEmail;
	private String custAddress;
	private String custZipcode;
	private Date custDatetime;
	private List<VrOrder> orders;
	
	public List<VrOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<VrOrder> orders) {
		this.orders = orders;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustZipcode() {
		return custZipcode;
	}
	public void setCustZipcode(String custZipcode) {
		this.custZipcode = custZipcode;
	}
	public Date getCustDatetime() {
		return custDatetime;
	}
	public void setCustDatetime(Date custDatetime) {
		this.custDatetime = custDatetime;
	}
}
