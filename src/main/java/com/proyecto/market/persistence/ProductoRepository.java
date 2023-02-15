package com.proyecto.market.persistence;

import com.proyecto.market.persistence.crud.ProductoCrudRepository;
import com.proyecto.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
    public List<Producto> getByCategoria (int idCategoria){
        return productoCrudRepository.findByIdCategoriaOOrderByNombre(idCategoria);
    }
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public  Optional<Producto> getProducto (int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save (Producto producto){
        return productoCrudRepository.save(producto);
    }
    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
