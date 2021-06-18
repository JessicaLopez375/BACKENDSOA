package com.edu.iua.business;

import com.edu.iua.business.exception.BusinessException;
import com.edu.iua.business.exception.NotFoundException;
import com.edu.iua.model.Categoria;
import com.edu.iua.model.Registro;

public interface ICategoriaBusiness {
	public Categoria add(Categoria registro) throws BusinessException;

	public Categoria load(Integer id) throws NotFoundException, BusinessException;

	public Categoria asegurarCategoria(Categoria categoria) throws BusinessException;

}
