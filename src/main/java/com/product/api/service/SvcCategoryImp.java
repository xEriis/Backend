package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.api.dto.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;
import com.product.commons.dto.ApiResponse;
import com.product.exception.ApiException;
import com.product.exception.DBAccessException;

/**
 * Clase SvcCategoryImp
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */
@Service
public class SvcCategoryImp implements SvcCategory{

    // Para hacer uso de inyección de dependencias:
    @Autowired
    RepoCategory repo;

    @Override
    public List<Category> findAll() throws DBAccessException{
        try {
            return repo.findAll();
	    }catch (DataAccessException e) {
        	throw new DBAccessException(e);
        }
    }

    @Override
    public List<Category> findActive() throws DBAccessException{
        try {
            return repo.findByStatusOrderByCategoryAsc(1);
        }catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
    }

    @Override
    public ApiResponse create(DtoCategoryIn in) throws ApiException{
        try {
            repo.create(in.getCategory(), in.getTag());
            return new ApiResponse("La categoria ha sido registrada");
        }catch (DataAccessException e) {
            if (e.getLocalizedMessage().contains("ux_category")) 
            throw new ApiException(HttpStatus.CONFLICT, "El nombre de la categoria ya está registrado");
            if (e.getLocalizedMessage().contains("ux_tag"))
            throw new ApiException(HttpStatus.CONFLICT, "El tag de la categoria ya está registrado");
        }
    }

    @Override
    public ApiResponse update(DtoCategoryIn in, Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ApiResponse enable(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enable'");
    }

    @Override
    public ApiResponse disable(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'disable'");
    }

}
