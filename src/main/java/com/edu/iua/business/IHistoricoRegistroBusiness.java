package com.edu.iua.business;

import java.util.List;

import com.edu.iua.business.exception.BusinessException;
import com.edu.iua.model.HistoricoRegistro;
import com.edu.iua.model.Registro;


public interface IHistoricoRegistroBusiness {
	public HistoricoRegistro add(Registro registro) throws BusinessException;

	public List<HistoricoRegistro> list() throws BusinessException;
}
