/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import bancoDeDados.BancoDeDados;
import java.util.Scanner;

/**
 *
 * @author rafael
 */
public class Cadastros {
    
    BancoDeDados bd = new BancoDeDados();
    Scanner scanner = new Scanner(System.in);
    
    public void novoProduto(){
        System.out.println("Nome do produto: ");
        String nome = scanner.next();
        System.out.println("Código do Produto (>1000): ");
        int codigo = scanner.nextInt();
        System.out.println("Quantidade no estoque: ");
        int quantidade = scanner.nextInt();
        System.out.println("Preço a ser vendido: ");
        float preco = scanner.nextFloat();
        String endereco_imagem = "sem endereco";
        System.out.println("Descriçao do produto: ");
        String descricao = scanner.next();
        
        Produto produto = new Produto(codigo, quantidade, preco, nome, endereco_imagem, descricao);
        adicionarProduto(produto);
        
    }
        
        public void  adicionarProduto(Produto produto){
            for( int i = 0; i < bd.produtos.length; i++){
                if (bd.produtos[i] == null ) {
                    bd.produtos[i] = produto;
                    System.out.println("Produto Adicionado com sucesso.");
                    break;
                }
            }
        }
    
        public void removerProduto(Produto produto){
            for(int i = 0; i < bd.produtos.length; i++){
                if (produto.getCodigo() == bd.produtos[i].getCodigo()){
                    bd.produtos[i] = null;
                    System.out.println("Produto removido com sucesso");
                }
            }
        }
        
        public void verProdutosCadastrados(){
            for(int i = 0; i < bd.produtos.length; i++){
                if (bd.produtos[i] != null){
                    System.out.println("Produto "+ i + " | Nome: "+bd.produtos[i].getNome()+""
                        + " | Código: "+bd.produtos[i].getCodigo() + " | Quantidade: "+bd.produtos[i].getQuantidade());
                }
            }
        }
    
}