package cn.simple.responsibility;

import cn.simple.domain.OperationResult;
/**
 * 流程每个节点的基础处理方法
 * @author ldm
 * @Date 2016年6月21日
 */
public interface IResponsibility {
	OperationResult process();
}
