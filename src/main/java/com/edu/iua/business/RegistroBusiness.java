package com.edu.iua.business;

import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.iua.business.exception.BusinessException;
import com.edu.iua.business.exception.NotFoundException;
import com.edu.iua.model.Registro;
import com.edu.iua.model.persistence.CategoriaRepository;
import com.edu.iua.model.persistence.RegistroRepository;

@Service
public class RegistroBusiness implements IRegistroBusiness{
	@Autowired
	private RegistroRepository registroDAO; 
	
	@Autowired
	private ICategoriaBusiness categoriaService; 
	
	@Autowired
	private ISubCategoriaBusiness subCategoriaService; 
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Registro add(Registro registro) throws BusinessException {
		try {
			
			String s;
			Registro r=new Registro();
			r.setId(registro.getId());
			r.setFechaHora(registro.getFechaHora());
			s=registro.getRawData();
			JSONArray a=new JSONArray(s);
			s=a.toString();
			r.setRawData(s);
			r.setIdentificador(registro.getIdentificador());
			r.setC(categoriaService.asegurarCategoria(registro.getC()));
			r.setSc(registro.getSc());
			
			return registroDAO.save(registro);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public Registro update(Registro registro) throws NotFoundException, BusinessException{
		
		Registro registroNuevo = new Registro();
		Registro registroViejo= load(registro.getId());
		String s;
		s=registro.getRawData();
		JSONObject a=new JSONObject(s);
		s=a.toString();
		
		registroNuevo.setId(registroViejo.getId());
		registroNuevo.setFechaHora(registro.getFechaHora());
		registroNuevo.setRawData(s);
		registroNuevo.setIdentificador(registro.getIdentificador());
		
		registroNuevo.setC(categoriaService.asegurarCategoria(registro.getC()));
		registroNuevo.setSc(subCategoriaService.asegurarSubCategoria(registro.getSc()));

		
		return registroDAO.save(registroNuevo);
	}

	@Override
	public Registro cargar(Registro registro) throws BusinessException {
		
		try {
			log.debug("ENTRO A BUSINESS");
			List<Registro> l=registroDAO.findAll();
			if(l.isEmpty()==true)
				return add(registro);
			else
				return update(registro);
		} catch (Exception e) {
			System.out.print(e);
			throw new BusinessException(e);
		}
	}

	@Override
	public Registro load(Integer id) throws NotFoundException, BusinessException {
		Optional<Registro> registro = null;
		try {
				registro = registroDAO.findById(id);
			
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		return registro.get();
	}

	@Override
	public List<Registro> list() throws BusinessException {
		try {
			System.out.print("ESTOY EN LIST");
			return registroDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
	

}
