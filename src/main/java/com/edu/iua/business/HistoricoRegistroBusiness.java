package com.edu.iua.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.iua.business.exception.BusinessException;
import com.edu.iua.model.HistoricoRegistro;
import com.edu.iua.model.Registro;
import com.edu.iua.model.persistence.HistoricoRegistroRepository;

@Service
public class HistoricoRegistroBusiness implements IHistoricoRegistroBusiness{

	@Autowired
	private HistoricoRegistroRepository historicoRegistroDAO; 
	
	@Autowired
	private ICategoriaBusiness categoriaService; 
	
	@Override
	public HistoricoRegistro add(Registro registro) throws BusinessException {
		try {
			HistoricoRegistro hr=new HistoricoRegistro();
			hr.setFechaHora(registro.getFechaHora());
			hr.setRawData(registro.getRawData());
			hr.setIdentificador(registro.getIdentificador());
			hr.setC(registro.getC());
			hr.setSc(registro.getSc());
			
			return historicoRegistroDAO.save(hr);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
	
	@Override
	public List<HistoricoRegistro> list() throws BusinessException {
		try {
			return historicoRegistroDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
