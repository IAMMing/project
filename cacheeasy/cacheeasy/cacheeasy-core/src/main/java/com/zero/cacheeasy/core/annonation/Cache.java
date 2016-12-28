/**
 * 
 */
package com.zero.cacheeasy.core.annonation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import com.zero.cacheeasy.core.enums.CacheContainer;
import com.zero.cacheeasy.core.enums.ValueType;

/**
 * Cache.java
 * 
 * @description 被当前注解修饰会更新缓存值
 * @author ldm
 * @date 2016年12月29日
 * @detail
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {
	/**
	 * 缓存的名称
	 * </p>
	 * 默认会获取，方法的全限定名
	 */
	String key = null;
	/**
	 * 缓存内容的容器
	 * </p>
	 * 默认是内存中的map
	 */
	CacheContainer container = CacheContainer.MAP;
	/**
	 * 缓存内容类型
	 * </p>
	 * 默认以字符串的形式缓存
	 */
	ValueType valueType = ValueType.STRING;
	/**
	 * 缓存失效时间
	 * </p>
	 * 默认时间是20秒
	 */
	int expires = 20000;
	/**
	 * 缓存的时间单位
	 * <p>
	 * 默认单位是 毫秒
	 */
	TimeUnit expiresUnit = TimeUnit.MILLISECONDS;
}
