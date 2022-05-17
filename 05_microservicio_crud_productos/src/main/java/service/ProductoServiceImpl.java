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

	@Override
	public List<Producto> buscarSeccion(String seccion) {
		
		return productosDao.findBySeccion(seccion);
	}

	@Override
	public void alta(Producto p) {
		productosDao.save(p);
		
	}



	@Override
	public void eliminar(int idProducto) {
		productosDao.deleteById(idProducto);
			
			
		}
		
		
	

	@Override
	public Producto buscarProducto(int idProducto) {
		
		return productosDao.findById(idProducto).get();
	}
	
	
	
	
}
