package dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import model.Producto;

public interface ProductosDao extends JpaRepository<Producto, Integer> {
	
	@Modifying
	@Query("update Producto p set p.stock=p.stock-?1 where p.codigoProducto=?2")
	void actualizarProductoStock(int unidadesCompradas, int codigoProducto);
	
	@Query("select p.precioUnitario from Producto p where p.codigoProducto=?1")
	double precioProducto(int codigoProducto);

}
