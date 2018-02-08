package com.ms1491.modules.api.utils;

/**
 * 常量
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017年09月27日 
 */
public class Constant {
	/**
	 * 商铺状态
	 *
	 */
    public enum StoreStatus {
        /**
         * 无权限
         */
    	NO_RIGHT(0),
        /**
         * 未开店
         */
    	NO_CREATE(1),
        /**
         * 已开店
         */
    	CREATED(2);

        private int value;

        StoreStatus(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }
    public enum  TemplateCode{
    	/**
    	 * 通用模板
    	 */
    	COMMON001("common_001"),
    	/**
    	 * 电商模板001
    	 */
    	SHOP001("shop_001");
    	private String value;

		public String getValue() {
			return value;
		}
		TemplateCode(String value) {
			this.value = value;
		}
    }
	public enum OrderStatus{
		REFUND("-1"),//退款
		INVALID("0"),//无效
		COMPLETE("1"),//完成
		PENDING("2"),//待发货
		ALREADY("3");//待收货
		
		private String value;
        private OrderStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
	}
	
	
}
