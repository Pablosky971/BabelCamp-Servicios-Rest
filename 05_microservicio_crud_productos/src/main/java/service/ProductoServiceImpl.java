package service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;


@Service
public class ProductoServiceImpl implements ProductoService {
	
	
	ProductosDao productosDao;

	public ProductoServiceImpl(ProductosDao productosDao) {
		this.productosDao = productosDao;
		
	}
	
	
	
	
}
