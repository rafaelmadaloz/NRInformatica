/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados;

import controle.Administrador;
import controle.Cliente;
import controle.Produto;

public final class BancoDeDados {
    
    private static BancoDeDados bd;
    
    public Produto[] produtos;
    public Cliente[] clientes;
    public Administrador adm;
    
    private BancoDeDados() { 
        produtos = new Produto[100];
        clientes = new Cliente[50];
        adm = new Administrador("adm", "adm");
    }
    
    //Padrão Singleton usado para permitir apenas uma instância
    //da classe Banco de Dados
    // usado synchronized para evitar concorrencia na criação da instância
    public static synchronized BancoDeDados getBancoDados() {
        if (bd == null) {
            bd = new BancoDeDados();
        }
        return bd;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public Administrador getAdm() {
        return adm;
    } 
}