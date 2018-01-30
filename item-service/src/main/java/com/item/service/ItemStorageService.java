/**
 * @author kexiaohong
 * @version 1.0 2018年1月29日
 *
 */
package com.item.service;

import com.item.entity.ItemStorage;
import com.item.inner.base.service.BaseService;
import com.item.inner.dto.Page;

public interface ItemStorageService extends BaseService<ItemStorage>{
	public Page<ItemStorage> getStoragePage(ItemStorage storage, Page<ItemStorage> page);

	public int count(ItemStorage storage);
}
