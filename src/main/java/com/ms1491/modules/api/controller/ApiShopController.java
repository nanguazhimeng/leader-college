package com.ms1491.modules.api.controller;


import io.swagger.annotations.Api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ms1491.common.annotation.ApiLog;
import com.ms1491.common.exception.RRException;
import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;
import com.ms1491.common.validator.Assert;
import com.ms1491.modules.api.annotation.AuthIgnore;
import com.ms1491.modules.api.annotation.LoginUser;
import com.ms1491.modules.api.entity.StoreOrderEntity;
import com.ms1491.modules.api.utils.ApiCode;
import com.ms1491.modules.api.utils.Constant.StoreStatus;
import com.ms1491.modules.api.utils.Constant.TemplateCode;
import com.ms1491.modules.api.utils.GoodsListResponse;
import com.ms1491.modules.api.utils.GoodscategoryResponse;
import com.ms1491.modules.api.utils.Item;
import com.ms1491.modules.api.utils.RoleIdContant;
import com.ms1491.modules.appuser.entity.AppUserEntity;
import com.ms1491.modules.oss.cloud.OSSFactory;
import com.ms1491.modules.shop.entity.GoodscategoryEntity;
import com.ms1491.modules.shop.entity.StoreEntity;
import com.ms1491.modules.shop.entity.StoreGoodsEntity;
import com.ms1491.modules.shop.entity.TemplateEntity;
import com.ms1491.modules.shop.service.GoodsService;
import com.ms1491.modules.shop.service.GoodscategoryService;
import com.ms1491.modules.shop.service.OrderService;
import com.ms1491.modules.shop.service.OrdergoodsService;
import com.ms1491.modules.shop.service.StoreGoodsService;
import com.ms1491.modules.shop.service.StoreService;
import com.ms1491.modules.shop.service.TemplateService;

/**
 * 商城
 *
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-27 10:51
 */
@RestController
@RequestMapping("/api/")
@Api(value="商城模块接口")
public class ApiShopController {
	@Autowired
	private StoreService storeService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrdergoodsService ordergoodsService;
	@Autowired
	private StoreGoodsService storeGoodsService;
	@Autowired
	private TemplateService templateService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodscategoryService goodscategoryService;
    /**
     * 我的店铺信息接口
     */
    @GetMapping("/myStoreInfo")
	public R myStoreInfo(@LoginUser AppUserEntity user) {
		// 1.是否有权限 三星级以及以上 2.是否已经有店铺3.店铺信息
		StoreEntity store;
		if (hasCreateStoreRight(user.getRoleId())) {
			store = storeService.queryObjectByUid(user.getUserId());
			if (store != null) {
				store.setStatus(StoreStatus.CREATED.getValue());
			} else {
				store = new StoreEntity();
				store.setStatus(StoreStatus.NO_CREATE.getValue());
			}
		} else {
			store = new StoreEntity();
			store.setStatus(StoreStatus.NO_RIGHT.getValue());
		}
		
		//分类
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("level", 2);
    	List<GoodscategoryEntity> goodscategoryList= goodscategoryService.queryList(params);
		store.setGoodscategoryList(goodscategoryList);
		
		return R.ok().put("data", store);
	}
    /**
     * 创建店铺接口
     */
    @ApiLog("创建店铺")
    @PostMapping("/addStore")
	public R addStore(@LoginUser AppUserEntity user,
			String name,
			String introduction,
			@RequestParam(required = false) MultipartFile icon,
			String phone) {
    	Assert.isBlank(name, "name is null");
    	Assert.isBlank(introduction, "introduction is null");
    	Assert.isBlank(phone, "phone is null");
    	if (hasCreateStoreRight(user.getRoleId())) {
    		String uid=user.getUserId();
    		StoreEntity store = storeService.queryObjectByUid(uid);
    		if(store==null){
    			store = new StoreEntity();
    			store.setStoreId(UUID.randomUUID().toString());
    			store.setIntroduction(introduction);
    			store.setName(name);
    			store.setPhone(phone);
    			store.setUid(uid);
    			store.setTemplateCode(TemplateCode.SHOP001.getValue());
        		if (!icon.isEmpty()) {
    				try {
    					String url = OSSFactory.build().upload(icon.getBytes());
    					store.setIcon(url);
    				} catch (IOException e) {
    					e.printStackTrace();
    					throw new RRException("上传失败",ApiCode.AC_INTERNAL_SERVER_ERROR);
    				}
        		}else{
        			
        		}
    			storeService.save(store);
    			store.setStatus(StoreStatus.CREATED.getValue());
    			return R.ok().put("data", store);
    		}else{
    			throw new RRException("你的店铺已存在！",ApiCode.AC_UNAUTHORIZED);
    		}
    	}else{
    		throw new RRException("对不起，你等级不足，三星级及以上用户才有资格开店",ApiCode.AC_UNAUTHORIZED);
    	}
    }
    /**
     * 修改店铺信息
     */
    @ApiLog("修改店铺")
    @PostMapping("/editStore")
	public R editStore(@LoginUser AppUserEntity user,
			String storeId,
			String name,
			String introduction,
			@RequestParam(required = false) MultipartFile icon,
			String phone) {
       	Assert.isBlank(storeId, "storeId is null");
       	StoreEntity store = storeService.queryObject(storeId);
       	
       	if(store!=null){
    		//上传文件
    		if (icon!=null&&!icon.isEmpty()) {
				try {
					String url = OSSFactory.build().upload(icon.getBytes());
					store.setIcon(url);
				} catch (IOException e) {
					e.printStackTrace();
					throw new RRException("上传失败",ApiCode.AC_INTERNAL_SERVER_ERROR);
				}
    		}
			store.setIntroduction(introduction);
			store.setName(name);
			store.setPhone(phone);
       		storeService.update(store);
       		return R.ok();
       	}else{
       		throw new RRException("你的店铺不存在！",ApiCode.AC_UNAUTHORIZED);
       	}
       	
    }
    
    /**
     * 模板列表
     */
    @GetMapping("/templateList")
	public R templateList(String page,String limit,String storeId) {
    	Assert.isBlank(storeId, "storeId is null");
    	Assert.isBlank(page, "page is null");
    	Assert.isBlank(limit, "limit is null");
    	
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("page", page);
    	params.put("limit", limit);
    	params.put("storeId", storeId);
    	params.put("delete", 0);
        Query query = new Query(params);
		List<TemplateEntity> templateList = templateService.queryList(query);
    	
		return R.ok().put("data", templateList);
    }
    
    
    /**
     * 将模板设置成使用中
     */
    @ApiLog("修改模板")
    @PostMapping("/template/setToUse")
	public R setToUse(@LoginUser AppUserEntity user,String templateCode,String storeId) {
    	Assert.isBlank(storeId, "storeId is null");
    	Assert.isBlank(templateCode, "templateCode is null");
    	
    	StoreEntity store = storeService.queryObject(storeId);
    	store.setTemplateCode(templateCode);
    	
    	storeService.update(store);
    	
    	return R.ok();
    }
    
    /**
     * 我的店铺订单列表
     */
    @GetMapping("/store/orderList")
	public R orderList(String page,String limit,String storeId,String type) {
    	Assert.isBlank(storeId, "storeId is null");
    	Assert.isBlank(page, "page is null");
    	Assert.isBlank(limit, "limit is null");
    	
    	String storeName = storeService.queryObject(storeId).getName();
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("page", page);      
    	params.put("limit", limit);
    	params.put("storeId", storeId);
    	params.put("type", type);
        Query query = new Query(params);
        
        List<StoreOrderEntity> storeOrderList = orderService.queryStoreOrderList(query);
        for (StoreOrderEntity storeOrderEntity : storeOrderList) {
        	storeOrderEntity.setStoreName(storeName);
		}
    	return R.ok().put("data", storeOrderList);
    }
    
    /**
     * 我的店铺商品列表
     */
    @GetMapping("/store/goodsList")
	public R goodsList(String page,String limit,String storeId,Integer salesStatus,String keywords,String goodscategoryId) {
    	Assert.isBlank(storeId, "storeId is null");
    	Assert.isBlank(page, "page is null");
    	Assert.isBlank(limit, "limit is null");
    	
    	Map<String, Object> params = new HashMap<String, Object>();
    	if(StringUtils.isNotEmpty(goodscategoryId)){
        	if("ishot".equals(goodscategoryId)){
        		params.put("ishot", 1);
        	}else if("isnew".equals(goodscategoryId)){
        		params.put("isnew", 1);
        	}else{
        		params.put("goodscategoryId", goodscategoryId);
        	}
    	}
    	params.put("page", page);      
    	params.put("limit", limit);
    	params.put("storeId", storeId);
    	params.put("keywords", keywords);
    	params.put("salesStatus", salesStatus);
        Query query = new Query(params);
    	
        List<StoreGoodsEntity> storeGoodsList = storeGoodsService.queryList(query); 
        
        List<Item> items = new ArrayList<>();
        items.add(new Item("最新", "isnew"));
        items.add(new Item("最热", "ishot"));
        params.put("level", "2");
        
        List<GoodscategoryEntity> goodscategoryList = goodscategoryService.queryList(params);
        for (GoodscategoryEntity goodscategoryEntity : goodscategoryList) {
        	 items.add(new Item(goodscategoryEntity.getName(), goodscategoryEntity.getGoodscategoryId()));
		}
        
		GoodsListResponse goodsListResponse = new GoodsListResponse();
		goodsListResponse.setStoreGoods(storeGoodsList);
		goodsListResponse.setItems(items);
		
        return R.ok().put("data", goodsListResponse);
    }
    
    /**
     * 上架商品
     */
    @ApiLog("上架商品")
    @PostMapping("store/goods/up")
	public R up(@LoginUser AppUserEntity user,String goodsId,String storeId) {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("storeId", storeId);
    	params.put("goodsId", goodsId);
    	StoreGoodsEntity storeGoods = storeGoodsService.queryObjectByStoreIdAndGoodsId(params);
    	if(storeGoods==null){
    		storeGoods = new  StoreGoodsEntity();
    		storeGoods.setStoreGoodsId(UUID.randomUUID().toString());
    		storeGoods.setGoodsId(goodsId);
    		storeGoods.setStoreId(storeId);
    		storeGoodsService.save(storeGoods);
    	}else{
    		throw new RRException("商品不存在或已上架",ApiCode.AC_OTHER_ERROR);
    	}
    	return R.ok();
    }
    /**
     * 下架商品
     */
    @ApiLog("下架商品")
    @PostMapping("store/goods/off")
	public R off(@LoginUser AppUserEntity user,String goodsId,String storeId) {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("storeId", storeId);
    	params.put("goodsId", goodsId);
    	StoreGoodsEntity storeGoods = storeGoodsService.queryObjectByStoreIdAndGoodsId(params);
    	if(storeGoods!=null){
    		storeGoodsService.delete(storeGoods.getStoreGoodsId());
    	}else{
    		throw new RRException("商品不存在或已下架",ApiCode.AC_OTHER_ERROR);
    	}
    	return R.ok();
    }
    /**
     * 商城首页
     */
    @GetMapping("/shop/index")
	public R index(@LoginUser AppUserEntity user) {
//    	@LoginUser AppUserEntity user
    	//是否有导师
    	//首页信息：分类，店铺信息，商品数量（全部商品，上新个数）
    	if(RoleIdContant.HUIYUAN.equals(user.getRoleId())&&"1".equals(user.getPuid())){
    		throw new RRException("权限不足，尚未拜师",ApiCode.AC_UNAUTHORIZED);
    	}
    	String pstoreId = user.getPstoreId();
    	if(StringUtils.isEmpty(pstoreId)){
    		pstoreId = "1";//总店
    	}
    	StoreEntity store = storeService.queryObject(pstoreId);//
    	String templateCode = store.getTemplateCode();
    	
    	if(TemplateCode.COMMON001.getValue().equals(templateCode)){
        	Map<String, Object> params = new HashMap<String, Object>();
        	params.put("isrecommand", 1);
        	params.put("storeId", pstoreId);
        	params.put("salesStatus", 1);
        	List<StoreGoodsEntity> storeGoodsList = storeGoodsService.queryList(params); 
    	    List<GoodscategoryResponse> categoryList = storeGoodsService.queryCategoryList(params);
    	    for (GoodscategoryResponse goodscategoryResponse : categoryList) {
    	    	List<StoreGoodsEntity> storeGoods = new ArrayList<StoreGoodsEntity>();
    	    	for (StoreGoodsEntity storeGoodsEntity : storeGoodsList) {
    				if(storeGoodsEntity.getGoodscategoryId().equals(goodscategoryResponse.getGoodscategoryId())){
    					storeGoods.add(storeGoodsEntity);
    				}
    			}
    	    	goodscategoryResponse.setStoreGoods(storeGoods);
    		}
    	    store.setStoreGoodscategoryList(categoryList);
    	}else if(TemplateCode.SHOP001.getValue().equals(templateCode)){
    		//轮播 分类  
        	Map<String, Object> params = new HashMap<String, Object>();
        	params.put("storeId", pstoreId);
        	params.put("salesStatus", 1);
    	    List<GoodscategoryResponse> categoryList = storeGoodsService.queryCategoryList(params);
    	    store.setStoreGoodscategoryList(categoryList);
    	    
    	    params.put("ishot", 1);
    	    List<StoreGoodsEntity> storeHotGoodsList = storeGoodsService.queryList(params); 
    	    store.setStoreHotGoodsList(storeHotGoodsList);
    	    params.remove("ishot");
    	    params.put("isrecommand", 1);
    	    List<StoreGoodsEntity> storeRecommandGoodsList = storeGoodsService.queryList(params); 
    	    store.setStoreRecommandGoodsList(storeRecommandGoodsList);
    	}
    	return R.ok().put("data", store);
    }
    /**
     * 商城首页-游客身份
     */
    @AuthIgnore
    @GetMapping("/shop/guest")
	public R guest() {
    	String	pstoreId = "f820ad41-6b79-414b-b93d-2ca4011968f0";//总店
    	StoreEntity store = storeService.queryObject(pstoreId);//
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("isrecommand", 1);
    	params.put("storeId", pstoreId);
    	params.put("salesStatus", 1);
    	List<StoreGoodsEntity> storeGoodsList = storeGoodsService.queryList(params); 
	    List<GoodscategoryResponse> categoryList = storeGoodsService.queryCategoryList(params);
	    for (GoodscategoryResponse goodscategoryResponse : categoryList) {
	    	List<StoreGoodsEntity> storeGoods = new ArrayList<StoreGoodsEntity>();
	    	for (StoreGoodsEntity storeGoodsEntity : storeGoodsList) {
				if(storeGoodsEntity.getGoodscategoryId().equals(goodscategoryResponse.getGoodscategoryId())){
					storeGoods.add(storeGoodsEntity);
				}
			}
	    	goodscategoryResponse.setStoreGoods(storeGoods);
		}
	    store.setStoreGoodscategoryList(categoryList);
    	return R.ok().put("data", store);
    }
    /**
     * 二级页面
     */
    @GetMapping("/shop/index2")
	public R index2(@LoginUser AppUserEntity user,String page,String limit,String keywords,String goodscategoryId) {
    	Assert.isBlank(page, "page is null");
    	Assert.isBlank(limit, "limit is null");
    	
    	String pstoreId = user.getPstoreId();
    	if(StringUtils.isEmpty(pstoreId)){
    		pstoreId = "1";//总店
    	}
    	
    	Map<String, Object> params = new HashMap<String, Object>();
    	if(StringUtils.isNotEmpty(goodscategoryId)){
        	if("ishot".equals(goodscategoryId)){
        		params.put("ishot", 1);
        	}else if("isnew".equals(goodscategoryId)){
        		params.put("isnew", 1);
        	}else{
        		params.put("goodscategoryId", goodscategoryId);
        	}
    	}
    	params.put("page", page);      
    	params.put("limit", limit);
    	params.put("storeId", pstoreId);
    	params.put("keywords", keywords);
    	params.put("salesStatus", 1);
        Query query = new Query(params);
    	
        List<StoreGoodsEntity> storeGoodsList = storeGoodsService.queryList(query); 
		
        return R.ok().put("data", storeGoodsList);
    }
    
    /**
     * 是否有开店的权限
     * @param roleId
     * @return
     */
	private boolean hasCreateStoreRight(String roleId){
    	if(RoleIdContant.JINGXIAOSHANG.equals(roleId)||
    		RoleIdContant.QUDAI.equals(roleId)||
    		RoleIdContant.SHIDAI.equals(roleId)||
			RoleIdContant.SHENGDAI.equals(roleId)||
			RoleIdContant.DONGSHI_D.equals(roleId)||
			RoleIdContant.DONGSHI_C.equals(roleId)||
			RoleIdContant.DONGSHI_B.equals(roleId)||
			RoleIdContant.DONGSHI_A.equals(roleId)||
			RoleIdContant.ZHIDAOSHI.equals(roleId)||
			RoleIdContant.QUYU_ZONGJINGLI.equals(roleId)||
			RoleIdContant.ZONGJINGLI.equals(roleId)){
    		return true;
    	}else{
    		return false;
    	}
    }
	
	
}
