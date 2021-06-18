package com.edu.iua.business;

import com.edu.iua.business.exception.BusinessException;
import com.edu.iua.business.exception.NotFoundException;
import com.edu.iua.model.SubCategoria;

public interface ISubCategoriaBusiness {
	public SubCategoria add(SubCategoria subCategoria) throws BusinessException;

	public SubCategoria load(Integer id) throws NotFoundException, BusinessException;

	public SubCategoria asegurarSubCategoria(SubCategoria subCategoria) throws BusinessException;
}
