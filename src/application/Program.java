package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entitties.Cliente;
import entitties.ItemPedido;
import entitties.Ordem;
import entitties.Produto;
import entitties.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Insira os dados do cliente: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data nacimento (DD/MM/YYYY):");
		Date data_nascimento = sdf.parse(sc.next());

		Cliente cliente = new Cliente(nome, email, data_nascimento);

		System.out.println("Insira os dados do pedido: ");
		System.out.println("Estado: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Ordem ordem = new Ordem(new Date(), status, cliente);

		System.out.print("Quantos itens cabem neste pedido? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Digite os dados do item nº" + i + ":");
			System.out.print("Nome do Produto: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preco do Produto: ");
			double precoProduto = sc.nextDouble();

			Produto produto = new Produto(nomeProduto, precoProduto);

			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();

			ItemPedido itemPedido = new ItemPedido(quantidade, precoProduto, produto);
			ordem.addItem(itemPedido);

		}

		System.out.println();
		System.out.println("RESUMO DO PEDIDO:");
		System.out.println(ordem);

		sc.close();
	} 

}
