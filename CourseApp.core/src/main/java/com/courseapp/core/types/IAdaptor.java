package com.courseapp.core.types;

import com.courseapp.exception.types.BusinessException;
import com.courseapp.exception.types.SystemException;

public interface IAdaptor<R,S> {
	
	public S execute(R request,String operation) throws BusinessException,SystemException;
}
