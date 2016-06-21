package cn.simple.flow;

import cn.simple.domain.OperationResult;

public interface IPay {
	OperationResult executePay();

	boolean callback();
}
