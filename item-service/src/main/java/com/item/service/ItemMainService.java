/**
 * @author kexiaohong
 * @version 1.0 2018年1月30日
 *
 */
package com.item.service;

import com.item.entity.ItemMain;
import com.item.inner.base.service.BaseService;
import com.item.inner.dto.Page;

public interface ItemMainService extends BaseService<ItemMain>{
	public Page<ItemMain> getMainPage(ItemMain main, Page<ItemMain> page);

	public int count(ItemMain main);
}
