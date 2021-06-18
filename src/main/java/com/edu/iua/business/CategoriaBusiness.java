package com.edu.iua.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.iua.business.exception.BusinessException;
import com.edu.iua.business.exception.NotFoundException;
import com.edu.iua.model.Categoria;
import com.edu.iua.model.Registro;
import com.edu.iua.model.persistence.CategoriaRepository;

@Service
public class CategoriaBusiness implements ICategoriaBusiness {

	@Autowired
	private CategoriaRepository categoriaDAO;

	@Override
	public Categoria add(Categoria registro) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria load(Integer id) throws NotFoundException, BusinessException {
		Optional<Categoria> categoria = null;
		try {
			categoria = categoriaDAO.findById(id);

		} catch (Exception e) {
			throw new BusinessException(e);
		}
		return categoria.get();
	}

	@Override
	public Categoria asegurarCategoria(Categoria categoria) throws BusinessException {
		
		Categoria c = null;
		try {
			if (categoriaDAO.findById(categoria.getId()) != null) {
				
				return categoriaDAO.save(categoria);

			} else {
				c = new Categoria();
				c.setId(categoria.getId());
				c.setDescripcion(categoria.getDescripcion());
				return categoriaDAO.save(c);

			}

		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
