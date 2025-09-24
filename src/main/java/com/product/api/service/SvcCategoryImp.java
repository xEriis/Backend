package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private RepoCategory repo;

    SvcCategoryImp(){}

    @Override
    public ResponseEntity<List<Category>> getCategories() {
        try {
            return new ResponseEntity<>(repo.getCategories(), HttpStatus.OK);
        } catch (DataAccessException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consultar las categorías de la base de datos.");
        }
    }

    @Override
    public List<Category> findAll() throws DBAccessException {
        try {
            return repo.findAll();
        }catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
    }

    @Override
    public List<Category> findActive() {
        try {
            return repo.findByStatusOrderByCategoryAsc(1);
        } catch (DataAccessException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consultar las categorías de la base de datos.");
        }
    }

    @Override
    public ApiResponse create(DtoCategoryIn in) throws ApiException {
        try {
            repo.create(in.getCategory(), in.getTag());
            return new ApiResponse("La categoria ha sido registrada");
        }catch (DataAccessException e) {
            if (e.getLocalizedMessage().contains("ux_category"))  throw new ApiException(HttpStatus.CONFLICT, "El nombre de la categoria ya está registrado");
            if (e.getLocalizedMessage().contains("ux_tag")) throw new ApiException(HttpStatus.CONFLICT, "El tag de la categoria ya está registrado");

            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Error inesperado: " + e.getMessage());
        }
    }

    @Override
    public ApiResponse update(DtoCategoryIn in, Integer id) {
        try {
            repo.update(id, in.getCategory(), in.getTag());
            return new ApiResponse("La región ha sido actualizada");
        } catch (DataAccessException e) {
            if(repo.findById(id).isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, "El id de la región no existe");

            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al actualizar la categoria.");
        }
    }

    @Override
    public ApiResponse enable(Integer id) {
        try {
            validateCategoryId(id);
            repo.updateStatus(id,1);
            return new ApiResponse("La región ha sido activada");
        } catch (DataAccessException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al  activar la categoria.");
        }

    }

    @Override
    public ApiResponse disable(Integer id) {
        try {
            validateCategoryId(id);
            repo.updateStatus(id,0);
            return new ApiResponse("La región ha sido activada");
        } catch (DataAccessException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al  desactivar la categoria.");
        }
    }

    private void validateCategoryId(Integer id) {
		try {
			if(repo.findById(id).isEmpty()) {
				throw new ApiException(HttpStatus.NOT_FOUND, "El id de la categoría no existe");
			}
		}catch (DataAccessException e) {
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
                "Error al consultar las categorías de la base de datos.");
		}
	}

}