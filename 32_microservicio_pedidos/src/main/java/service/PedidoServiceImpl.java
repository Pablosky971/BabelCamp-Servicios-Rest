package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import dao.PedidosDao;
import model.Pedido;


@Service
public class PedidoServiceImpl implements PedidoService {
	
	
	RestTemplate template;
	String urlBase="http://servicio-productos/";

	PedidosDao pedidosDao;
	
	
	public PedidoServiceImpl(@Autowired PedidosDao pedidosDao, @Autowired RestTemplate template) {
		super();
		this.pedidosDao = pedidosDao;
		this.template = template;
	}




	@Transactional
	public void altaPedido(Pedido pedido) {
		ResponseEntity<String> response = template.exchange(urlBase + "ActualizarProducto/" + pedido.getUnidades() + "/" + pedido.getCodigoProducto(), HttpMethod.PUT,null 
				,String.class);
		
		String cuerpo = response.getBody();
		
		if(cuerpo.equals("true")) {
			double precio = template.getForObject(urlBase + "PrecioProducto/" + pedido.getCodigoProducto(), Double.class);
			pedido.setTotal(pedido.getUnidades() * precio);
			pedido.setFechaPedido(new Date());
			pedidosDao.save(pedido);
		}

		pedidosDao.save(pedido);

		
	}




	public List<Pedido> pedidos() {
	
		return pedidosDao.findAll();
	}



	



	


	

	
}
