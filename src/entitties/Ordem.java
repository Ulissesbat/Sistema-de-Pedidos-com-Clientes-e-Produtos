package entitties;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entitties.enums.OrderStatus;

public class Ordem {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date momento;
	private OrderStatus status;
	
	private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Ordem () {
		
	}

	public Ordem(Date momento, OrderStatus status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
		
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemPedido> getItems() {
		return itens; 
	}
	
	public void addItem(ItemPedido item) {
		itens.add(item);
	}

	public void removeItem(ItemPedido item) {
		itens.remove(item);
	}
	public double total() {
		double sum = 0.0;
		for (ItemPedido item : itens) {
			sum += item.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do Pedido: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("status do Pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens do Pedido:\n");
		for (ItemPedido item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Preco total: R$");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
	
	
}
