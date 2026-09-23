package br.furb.aula.poo.gerenciamentoVendedores;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LojaTest {

    @Test @DisplayName("Construtor: nome nulo, vazio ou branco deve lancar excecao")
    void testConstrutorNomeInvalido() {
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> new Loja(null), "Construtor deveria falhar com nome nulo");
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> new Loja(""), "Construtor deveria falhar com nome vazio");
        IllegalArgumentException ex3 = assertThrows(IllegalArgumentException.class, () -> new Loja("   "), "Construtor deveria falhar com nome em branco");

        assertTrue(ex1.getMessage().equalsIgnoreCase("nome invalido"), "Mensagem incorreta para nome nulo");
        assertTrue(ex2.getMessage().equalsIgnoreCase("nome invalido"), "Mensagem incorreta para nome vazio");
        assertTrue(ex3.getMessage().equalsIgnoreCase("nome invalido"), "Mensagem incorreta para nome em branco");
    }

    @Test @DisplayName("Setter: setNome nulo, vazio ou branco deve lancar excecao")
    void testSetterNomeInvalido() {
        Loja lojaParaTeste = new Loja("Loja Valida");

        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> lojaParaTeste.setNome(null), "setNome deveria falhar com nulo");
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> lojaParaTeste.setNome(""), "setNome deveria falhar com vazio");
        IllegalArgumentException ex3 = assertThrows(IllegalArgumentException.class, () -> lojaParaTeste.setNome("  "), "setNome deveria falhar com espaços");

        assertTrue(ex1.getMessage().equalsIgnoreCase("nome invalido"), "Mensagem do setter incorreta para nulo");
        assertTrue(ex2.getMessage().equalsIgnoreCase("nome invalido"), "Mensagem do setter incorreta para vazio");
        assertTrue(ex3.getMessage().equalsIgnoreCase("nome invalido"), "Mensagem do setter incorreta para espaços");
    }

    @Test @DisplayName("adicionarVendedor: deve lancar excecao para objeto nulo")
    void testAdicionarVendedorNulo() {
        Loja lojaParaTeste = new Loja("Loja Teste");
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,
                () -> lojaParaTeste.adicionarVendedor(null), "Nao deve ser possivel adicionar um vendedor nulo");
        assertTrue(excecao.getMessage().equalsIgnoreCase("vendedor invalido"), "Mensagem deveria ser 'vendedor invalido'");
    }

    @Test @DisplayName("removerVendedor: deve lancar excecao para nulo ou lista vazia")
    void testRemoverVendedorInvalido() {
        Loja lojaParaTeste = new Loja("Loja Teste");
        Endereco enderecoGenerico = new Endereco("Rua", 1, "89123456");
        Vendedor vendedorGenerico = new Vendedor("V", 1500.0, 0, enderecoGenerico);

        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> lojaParaTeste.removerVendedor(null), "Remover nulo deve falhar");
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> lojaParaTeste.removerVendedor(vendedorGenerico), "Remover de lista vazia deve falhar");

        assertTrue(ex1.getMessage().equalsIgnoreCase("vendedor invalido"), "Mensagem incorreta para remocao de nulo");
        assertTrue(ex2.getMessage().equalsIgnoreCase("vendedor invalido"), "Mensagem incorreta para remocao em lista vazia");
    }

    @Test @DisplayName("getVendedores: deve retornar uma copia fiel do conteudo (Encapsulamento)")
    void testGetVendedores() {
        Loja lojaParaTeste = new Loja("Loja Matriz");
        Endereco enderecoExemplo = new Endereco("Rua Alfandega", 100, "89123456");
        Vendedor vendedorInserido = new Vendedor("Vendedor Original", 2000.0, 500.0, enderecoExemplo);

        lojaParaTeste.adicionarVendedor(vendedorInserido);

        List<Vendedor> listaRetornada = lojaParaTeste.getVendedores();

        assertEquals(1, listaRetornada.size(),
                "A copia da lista deveria conter exatamente 1 vendedor");

        assertEquals(vendedorInserido, listaRetornada.get(0),
                "O vendedor dentro da copia deve ser o mesmo objeto que foi inserido previamente");
    }


    @Test @DisplayName("calcularMediaComissao: deve retornar a media correta das comissoes")
    void testCalcularMediaComissao() {
        Loja lojaParaTeste = new Loja("Loja Teste");
        Endereco end = new Endereco("Rua", 1, "89123456");

        lojaParaTeste.adicionarVendedor(new Vendedor("Ana", 1500.0, 1000.0, end)); // Comissao: 100.0
        lojaParaTeste.adicionarVendedor(new Vendedor("Getulio", 1500.0, 3000.0, end)); // Comissao: 300.0

        // Media: (100 + 300) / 2 = 200.0
        assertEquals(200.0, lojaParaTeste.calcularMediaComissao(), 0.001, "A media das comissoes esta incorreta");
    }

    @Test @DisplayName("vendedorMaiorVenda: deve retornar o vendedor com maior valorVendas")
    void testVendedorMaiorVenda() {
        Loja lojaParaTeste = new Loja("Loja Teste");
        Endereco end = new Endereco("Rua", 1, "89123456");

        Vendedor vBaixo = new Vendedor("Baixo", 1500.0, 1000.0, end);
        Vendedor vAlto = new Vendedor("Alto", 1500.0, 9000.0, end);

        lojaParaTeste.adicionarVendedor(vBaixo);
        lojaParaTeste.adicionarVendedor(vAlto);

        assertEquals(vAlto, lojaParaTeste.vendedorMaiorVenda(), "O metodo deveria retornar o vendedor com 9000 em vendas");
    }

    @Test @DisplayName("calcularFolhaPagamento: deve retornar a soma de todos os salarios totais")
    void testCalcularFolhaPagamento() {
        Loja lojaParaTeste = new Loja("Loja Teste");
        Endereco end = new Endereco("Rua", 1, "89123456");


        lojaParaTeste.adicionarVendedor(new Vendedor("Ana", 2000.0, 5000.0, end));

        lojaParaTeste.adicionarVendedor(new Vendedor("Getulio", 1500.0, 1000.0, end));

        double esperado = 4100.0;
        assertEquals(esperado, lojaParaTeste.calcularFolhaPagamento(), 0.001, "A soma total da folha de pagamento esta incorreta");
    }

    @Test @DisplayName("adicionarVendedor: deve aumentar o tamanho da lista ao adicionar com sucesso")
    void testAdicionarVendedorComSucesso() {
        Loja lojaParaTeste = new Loja("Loja Tech");
        Endereco enderecoExemplo = new Endereco("Rua Alfandega", 100, "89123456");
        Vendedor vendedorNovo = new Vendedor("Vendedor Teste", 1500.0, 0.0, enderecoExemplo);

        lojaParaTeste.adicionarVendedor(vendedorNovo);

        int tamanhoEsperado = 1;
        assertEquals(tamanhoEsperado, lojaParaTeste.getVendedores().size(),
                "A lista de vendedores deveria conter exatamente 1 vendedor apos a adicao");

        assertTrue(lojaParaTeste.getVendedores().contains(vendedorNovo),
                "O vendedor adicionado deveria estar presente na lista da loja");
    }

    @Test @DisplayName("removerVendedor: deve diminuir o tamanho da lista ao remover com sucesso")
    void testRemoverVendedorComSucesso() {
        Loja lojaParaTeste = new Loja("Loja Tech");
        Endereco enderecoExemplo = new Endereco("Rua Alfandega", 100, "89123456");
        Vendedor vendedorParaRemover = new Vendedor("Vendedor Saida", 1500.0, 0.0, enderecoExemplo);

        lojaParaTeste.adicionarVendedor(vendedorParaRemover);
        assertEquals(1, lojaParaTeste.getVendedores().size(), "A lista deve comecar com 1 vendedor para o teste de remocao");

        lojaParaTeste.removerVendedor(vendedorParaRemover);

        int tamanhoEsperadoAposRemocao = 0;
        assertEquals(tamanhoEsperadoAposRemocao, lojaParaTeste.getVendedores().size(),
                "A lista de vendedores deveria estar vazia apos a remocao do unico vendedor");

        assertFalse(lojaParaTeste.getVendedores().contains(vendedorParaRemover),
                "O vendedor removido nao deveria mais constar na lista da loja");
    }

    @Test @DisplayName("getNome: deve retornar o nome da loja definido corretamente")
    void testGetNome() {
        String nomeEsperadoOriginal = "Loja Matriz";
        String nomeAlteradoEsperado = "Loja Filial";

        Loja lojaParaTeste = new Loja(nomeEsperadoOriginal);
        assertEquals(nomeEsperadoOriginal, lojaParaTeste.getNome(),
                "O getter getNome nao retornou o nome que foi definido no construtor da loja");

        lojaParaTeste.setNome(nomeAlteradoEsperado);
        assertEquals(nomeAlteradoEsperado, lojaParaTeste.getNome(),
                "O getter getNome nao retornou o nome atualizado apos o uso do setter");
    }
}