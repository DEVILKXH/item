/**
 * @author kexiaohong
 * @version 1.0 2018年1月30日
 *
 */
package com.item.service.impl;

import org.springframework.stereotype.Service;

import com.item.entity.ItemDetail;
import com.item.inner.base.mapper.BaseMapper;
import com.item.inner.base.serviceimpl.BaseServiceImpl;
import com.item.service.ItemDetailService;

@Service
public class ItemDetailServiceImpl extends BaseServiceImpl<ItemDetail, BaseMapper<ItemDetail>> implements ItemDetailService{

}
