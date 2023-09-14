/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.arvorebinaria;

/**
 *
 * @author anaca
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

class BIntNo {
    int valor;
    BIntNo esq, dir;

    BIntNo(int novoValor) {
        valor = novoValor;
        esq = null;
        dir = null;
    }
}

public class ArvoreBinaria {
    private BIntNo raiz;
    private List<Integer> numerosInseridos;
    private List<Integer> numerosEsquerdo;
    private List<Integer> numerosDireito;

    public ArvoreBinaria() {
        numerosInseridos = new ArrayList<>();
        numerosEsquerdo = new ArrayList<>();
        numerosDireito = new ArrayList<>();
    }

    private BIntNo inserir(BIntNo arvore, int novoValor) {
        if (arvore == null) {
            return new BIntNo(novoValor);
        } else {
            if (novoValor < arvore.valor) {
                arvore.esq = inserir(arvore.esq, novoValor);
            } else {
                arvore.dir = inserir(arvore.dir, novoValor);
            }
        }
        return arvore;
    }

    public void inserirNo(int novoValor) {
        raiz = inserir(raiz, novoValor);
        numerosInseridos.add(novoValor);

        if (novoValor < raiz.valor) {
            numerosEsquerdo.add(novoValor);
            if (numerosEsquerdo.size() > 5) {
                numerosEsquerdo.remove(0); // Limita a 2 números
            }
        } else if (novoValor > raiz.valor) {
            numerosDireito.add(novoValor);
            if (numerosDireito.size() > 5) {
                numerosDireito.remove(0); // Limita a 2 números
            }
        }
    }

    private void exibirEsquerdo(BIntNo arv) {
        if (arv != null) {
            exibirEsquerdo(arv.esq);
            System.out.print(arv.valor + " ");
            exibirEsquerdo(arv.dir);
        }
    }

    private void exibirDireito(BIntNo arv) {
        if (arv != null) {
            exibirDireito(arv.esq);
            System.out.print(arv.valor + " ");
            exibirDireito(arv.dir);
        }
    }

    public void exibirNoEsq() {
        if (!numerosEsquerdo.isEmpty()) {
            System.out.println("Lado Esquerdo:");
            System.out.println(raiz.valor);
            for (int num : numerosEsquerdo) {
                System.out.print(num + " " + "\n");
            }
            System.out.println();
        } else {
            System.out.println("Lado Esquerdo vazio.");
        }
    }

    public void exibirNoDir() {
        if (!numerosDireito.isEmpty()) {
            System.out.println("Lado Direito:");
             System.out.println(raiz.valor);
            for (int num : numerosDireito) {
                System.out.print(num + " " + "\n");
            }
            System.out.println();
        } else {
            System.out.println("Lado Direito vazio.");
        }
    }

    public void exibirNumerosInseridos() {
        System.out.println("Números inseridos:");
        for (int num : numerosInseridos) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void exibirRaizGeral() {
        if (raiz != null) {
            System.out.println("Raiz: " + raiz.valor);
        } else {
            System.out.println("Árvore vazia.");
        }
    }

    public void exibirNo() {
        exibirRaizGeral();
        exibirNoEsq();
        exibirNoDir();
        exibirNumerosInseridos();
    }

    public static void main(String args[]) {

        ArvoreBinaria arv = new ArvoreBinaria();

        JOptionPane.showMessageDialog(null, "Adicione 5 números inteiros para obter a Árvore Binária.");
        arv.inserirNo(Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro")));
        arv.inserirNo(Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro")));
        arv.inserirNo(Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro")));
        arv.inserirNo(Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro")));
        arv.inserirNo(Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro")));

        System.out.println("Árvore Binária");
        arv.exibirNo();

        System.exit(0);
    }
}

