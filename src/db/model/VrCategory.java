package db.model;

/**
 * 场馆分类数据
 * @author Tqq
 *
 */
public class VrCategory {
	private Integer catId;
	private String catName;
	
	public VrCategory() {
		super();
	}
	
	public VrCategory(Integer catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}

	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
}
