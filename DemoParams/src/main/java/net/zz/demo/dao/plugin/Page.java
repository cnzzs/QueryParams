package net.zz.demo.dao.plugin;

import java.util.List;

/**
 * 分页列表，保存了分页内容，当前页，每页记录数，总记录数和页数
 * @author ZaoSheng
 *
 * @param <T>
 */
public class Page<T> {

	private int page = 1; //  当前页
	
	private int rows = 10; // 每页记录数
	
	private int count; // 页数
	
	private Long total; // 所有记录数
	
	private List<T> content; // 当前页内容
	
	/**
	 * 获取当前页
	 * @return
	 */
	public int getPage() {
		return page;
	}
	
	/**
	 * 设置当前页
	 * @param page
	 */
	public void setPage(int page) {
		if (page <= 0)
			page = 1;
		this.page = page;
	}
	
	/**
	 * 获取每页记录数
	 * @return
	 */
	public int getRows() {
		return rows;
	}
	
	/**
	 * 设置每页记录数
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	/**
	 * 获取总页数
	 * @return
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * 设置记录数
	 * @param total
	 */
	public void setTotal(Long total) {
		this.total = total;
		// 根据总的记录数生成分页
        if (total >  0) {
            // 计算总的页数
            if (total % rows == 0) {
                this.count = (int) (total / rows);
            } else {
                this.count = (int) (total / rows + 1);
            }
        }
	}
	
	/**
	 * 获取当前页内容
	 * @return
	 */
	public List<T> getContent() {
		return content;
	}
	
	/**
	 * 设置当前页内容
	 * @param content
	 */
	public void setContent(List<T> content) {
		this.content = content;
	}
	
}
