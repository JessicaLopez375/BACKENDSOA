package com.edu.iua.business;

import java.util.List;

import com.edu.iua.business.exception.BusinessException;
import com.edu.iua.business.exception.NotFoundException;
import com.edu.iua.model.Registro;


public interface IRegistroBusiness {

	public Registro add(Registro registro) throws BusinessException;

	public Registro load(Integer id) throws NotFoundException, BusinessException;
	
	public Registro update(Registro registro) throws NotFoundException, BusinessException;

	public Registro cargar(Registro registro) throws BusinessException;
	
	public List<Registro> list() throws BusinessException;
}
