package com.product.api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.exception.ApiException;
import com.product.exception.DBAccessException;
import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.repository.RepoProductImage;
import com.product.common.dto.ApiResponse;
import com.product.api.entity.ProductImage;

@Service
public class SvcProductImageImp implements SvcProductImage {
    @Autowired
    RepoProductImage repo;

    @Value("${app.upload.dir}")
    private String uploadDir;
    
    /**
     * Método para actualizar o crear la imagen de un producto
     * @param in dto con los datos necesario para actualizar o crear la imagen de un producto
     * @return APIResponse con el resultado de la operación
     */
    @Override
    public ResponseEntity<ApiResponse> uploadProductImage(DtoProductImageIn in) {
        try {
            // Elimina el prefijo de base64 de la imagen
            if (in.getImage().startsWith("data:image")) {
                int commaIndex = in.getImage().indexOf(",");
                if (commaIndex != -1) {
                    in.setImage(in.getImage().substring(commaIndex + 1));
                }
            }
            
            // Decodifica la cadena Base64 a bytes
            byte[] imageBytes = Base64.getDecoder().decode(in.getImage());
            // Genera un nombre único para la imagen (se asume extensión PNG)
            String fileName = UUID.randomUUID().toString() + ".png";
            // Construye la ruta completa donde se guardará la imagen
            Path imagePath = Paths.get(uploadDir, "img", "product", fileName);
            // Asegurarse de que el directorio exista
            Files.createDirectories(imagePath.getParent());
            // Escribir el archivo en el sistema de archivos
            Files.write(imagePath, imageBytes);
            // Crear la entidad ProductImage y guardar la URL en la base de datos
            ProductImage productImage = new ProductImage();
            productImage.setProduct_id(in.getProduct_id());
            productImage.setImage("/uploads/img/product/" + fileName);
            productImage.setStatus(1); 
            // Guardar la ruta de la imagen
            repo.save(productImage);

            return new ResponseEntity<>(new ApiResponse("La imagen ha sido actualizada"), HttpStatus.OK);
        }catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
        catch (IOException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el archivo");
        }
    }

    /**
     * Método para borrar la imagen de un producto solicitado
     * @param id id del producto con imagen a borrar
     * @param product_image_id id de la imagen a borrar
     * @return APIResponse con el resultado de la operación
     */
    @Override
    public ResponseEntity<ApiResponse> deleteProductImage(Integer id, Integer product_image_id) {
        try {
            if(repo.findById(product_image_id).isEmpty()){
                throw new ApiException(HttpStatus.NOT_FOUND, "¡id de imagen inexistente!");
            }
            repo.disableProductImage(product_image_id);
            return new ResponseEntity<>(new ApiResponse("La imagen ha sido eliminada"), HttpStatus.OK);
        } catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
    }

    /**
     * Método para obtener las imagenes asociadas a un producto
     * @param id id del producto a obtener las imágenes
     * @return Lista con las imagenes del producto solicitado
     */
    @Override
    public ResponseEntity<List<ProductImage>> getProductImages(Integer id) {
        try{
            List<ProductImage> images = repo.findByProductId(id);
            if (images.isEmpty()) {
                throw new ApiException(HttpStatus.BAD_REQUEST, "Este producto no tiene imagenes");
            }
            return new ResponseEntity<>(images, HttpStatus.OK);
        }catch (DataAccessException e){
            throw new DBAccessException(e);
        }
        
    }
    
}
