package com.edu.iua.eventos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.edu.iua.model.Orden;
import com.edu.iua.rest.Constantes;


@Component
public class OrdenEventListener implements ApplicationListener<OrdenEvent>{

	@Autowired
	private SimpMessagingTemplate wSock;
	
	@Override
	public void onApplicationEvent(OrdenEvent event) {

		if (event.getSource() instanceof Orden) {
			
			if(event.getTipo().equals(OrdenEvent.Tipo.TEMPERATURA_MAXIMA))
				manejaEventoExcesoTemperatura((Orden) event.getSource());
		}
	}
	
	private void manejaEventoExcesoTemperatura(Orden orden) {
		String mensaje = String.format("La temperatura de carga de la orden '%s' ha excedido el limite, su temperatura actual es de $ %.2f °C",
				orden.getNroOrden(), orden.getTemperatura());
		
		wSock.convertAndSend(Constantes.TOPIC_SEND_WEBSOCKET_GRAPH,	mensaje);		
		
	}
	
}
