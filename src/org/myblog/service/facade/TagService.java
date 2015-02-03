package org.myblog.service.facade;

import java.util.List;

import org.myblog.base.BaseDao;
import org.myblog.model.TagVO;

public interface TagService extends BaseDao<TagVO, Integer>
{
	/**
	 * 保存标签对象
	 * @param tag
	 */
	public void addTag(TagVO tag);
	
	/**
	 * 根据文章id查询标签对象，由于一篇文章有可能存在多个标签，故返回一个List标签对象
	 * @param id: 标签id
	 * @return
	 */
	public List<TagVO> findById2(Integer id);
	
	/**
	 * 条件查询标签
	 * @param keyword: 搜索关键字
	 * @return
	 */
	public List<TagVO> searchTags(String keyword);
	
	/**
	 * 批量删除标签
	 */
	public void bulk_delete(List<Integer> id);
	
	/**
	 * 批量删除文章标签
	 */
	public void bulk_delete2(List<Integer> id);
}