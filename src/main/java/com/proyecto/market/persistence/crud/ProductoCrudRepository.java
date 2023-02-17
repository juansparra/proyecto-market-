package com.proyecto.market.persistence.crud;

import com.proyecto.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository  extends CrudRepository<Producto,Integer> {
    List<Producto> findByIdCategoriaOrderByNombre(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock ,Boolean estado);
}
