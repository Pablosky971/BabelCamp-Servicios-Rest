package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import dao.ProductosDao;
import model.Producto;


@Service
public class ProductoServiceImpl implements ProductoService {
	
	


	ProductosDao productosDao;
	
	
	public ProductoServiceImpl(@Autowired ProductosDao productosDao) {
		super();
		this.productosDao = productosDao;
	
	}



	public List<Producto> productos() {
		
		return productosDao.findAll();
	}



	@Transactional
	public boolean actualizarProductoStock(int unidadesCompradas, int codigoProducto) {
		
		// Primero, recogemos el producto antes de su actualización.
		Optional<Producto> aux = productosDao.findById(codigoProducto);
		if(aux.isPresent()) {
			
			productosDao.actualizarProductoStock(unidadesCompradas, codigoProducto);
			
			return true;
		}
		
		return false;

	}



	public double precioProducto(int codigoProducto) {
	
		return productosDao.precioProducto(codigoProducto);
	}
	
	


	



	


	

	
}
