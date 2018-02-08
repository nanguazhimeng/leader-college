package com.ms1491.modules.college.util;

/**
 * 常量
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2016年11月15日 下午1:23:52
 */
public class CollegeConstant {
	/**
	 * 报名资格
	 * @author Administrator
	 *
	 */
    public enum SignupLimit {
        /**
         * 无级别限制
         */
    	LIMIT_0(0),
        /**
         * 直推30个下单客户
         */
    	LIMIT_1(1),
        /**
         * 市代以及以上
         */
    	LIMIT_2(2);

        private int value;

        SignupLimit(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }

}
