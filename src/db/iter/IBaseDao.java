package db.iter;

import java.io.Serializable;
import java.util.List;

/**
 * 数据访问基层接口
 * @author Tqq
 *
 * @param <T>
 * @param <ID>
 */
public interface IBaseDao<T,ID extends Serializable> {
	void insert(T obj);		// 添加
	void update(T obj); 	// 修改
	void delete(ID id);		// 删除
	T findById(ID id);		// 根据主键查找
	List<T> findAll();		// 查询所有
	List<T> findPage(int pageSize, int pageNo);	// 分页查询所有
	int findCount();		// 查询所有总数
}
