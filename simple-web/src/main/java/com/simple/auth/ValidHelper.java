package com.simple.auth;

import java.util.Calendar;

import org.apache.commons.codec.digest.DigestUtils;

import com.sun.istack.internal.logging.Logger;

/**
 * 获取有效的验证时间范围
 * 
 * @author ldm
 * @Date 2016年6月23日
 */
public class ValidHelper {
	Logger logger = Logger.getLogger(getClass());
	/**
	 * 验证有效周期 相当于一个验证码的有效时长
	 */
	private int period = 10;
	/**
	 * 无效波动范围 在有效区间内的先后，无效内不进行验证
	 */
	private int invalid = 0;

	/**
	 * 进行验证所使用的时间
	 */
	private Calendar currentCalendar = Calendar.getInstance();

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getInvalid() {
		return invalid;
	}

	public void setInvalid(int invalid) {
		this.invalid = invalid;
	}

	@SuppressWarnings("unused")
	private ValidHelper() {
		this.currentCalendar=Calendar.getInstance();
	}

	public ValidHelper(Calendar calendar) {
		this.currentCalendar = calendar;
	}

	public boolean valid(String encry) {
		if (isValid()) {
			logger.info("验证客户端...");
			String stamp = getValidStamp();
			logger.info("服务端明文：" + stamp);
			String encryStamp = DigestUtils.md5Hex(stamp);
			logger.info("服务端密文：" + encryStamp);
			return encryStamp.equals(encry);
		}
		return true;
	}

	/**
	 * 获取加密符串
	 * 
	 * @author ldm
	 * @Date 2016年6月23日
	 * @return
	 */
	public String getValidStamp() {

		StringBuilder sbDate = new StringBuilder();

		sbDate.append(currentCalendar.get(Calendar.YEAR));

		sbDate.append(currentCalendar.get(Calendar.MONTH) + 1);
		sbDate.append(currentCalendar.get(Calendar.DAY_OF_MONTH));
		sbDate.append(currentCalendar.get(Calendar.HOUR_OF_DAY));

		int min = currentCalendar.get(Calendar.MINUTE);

		sbDate.append(getValidMinute(min));
		logger.info(sbDate.toString());

		return sbDate.toString();
	}

	/**
	 * 计算出加密分钟值
	 * 
	 * @author ldm
	 * @Date 2016年6月26日
	 * @param minute
	 * @return
	 */
	private int getValidMinute(int minute) {

		return minute / period * period;
	}

	/**
	 * 判断是否进行验证
	 * 
	 * @author ldm
	 * @Date 2016年6月26日
	 * @param minute
	 * @return
	 */
	private boolean isValid(int minute) {
		int validMinute = getValidMinute(minute);
		return Math.abs(minute - validMinute) > invalid;
	}

	/**
	 * 判断是否进行验证
	 * 
	 * @author ldm
	 * @Date 2016年6月26日
	 * @param minute
	 * @return
	 */
	private boolean isValid() {
		int minute = currentCalendar.get(Calendar.MINUTE);
		return isValid(minute);
	}

}
