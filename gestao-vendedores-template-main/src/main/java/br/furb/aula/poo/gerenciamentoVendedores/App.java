package br.furb.aula.poo.gerenciamentoVendedores;

public class App {

	public static void main(String[] args) {

		Endereco endereco1 = new Endereco("Rua XV de Novembro", 100, "89010-000");

		Endereco endereco2 = new Endereco("Rua Amazonas", 200, "89020-000");

		Vendedor vendedor1 = new Vendedor("Joao", 1412.0, 5000.0, endereco1);

		Vendedor vendedor2 = new Vendedor("Maria", 1800.0, 3000.0, endereco2);

		Loja loja = new Loja("Loja FURB");

		loja.adicionarVendedor(vendedor1);

		loja.adicionarVendedor(vendedor2);

		System.out.println("Nome da loja: " + loja.getNome());

		System.out.println("Quantidade de vendedores: " + loja.getVendedores().size());

		System.out.println("Comissao do Joao: " + vendedor1.calcularComissao());

		System.out.println("Salario do Joao: " + vendedor1.calcularSalario());

		System.out.println("Media das comissoes: " + loja.calcularMediaComissao());

		System.out.println("Maior vendedor: " + loja.vendedorMaiorVenda().getNome());

		System.out.println("Folha de pagamento: " + loja.calcularFolhaPagamento());

	}

}