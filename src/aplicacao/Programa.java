package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Departamento;
import entidades.HorasDeContrato;
import entidades.Trabalho;
import entidades.enums.NivelDeFuncao;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do departamento: ");
		String nomeDoDepartamento = sc.nextLine();
		System.out.println("Digite os dados do trabalhador:");
		System.out.print("Nome: ");
		String nomeDoTrabalhador = sc.nextLine();		
		System.out.print("Nivel: ");
		String nivelDaFuncao  = sc.nextLine();
		System.out.print("Base Salarial: ");
		double salarioBase = sc.nextDouble();
		Trabalho trabalho = new Trabalho(nomeDoTrabalhador, NivelDeFuncao.valueOf(nivelDaFuncao), salarioBase, new Departamento(nomeDoDepartamento) );

		System.out.print("Quantos contratos para esse trabalhador? ");
		int n = sc.nextInt();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Digite os dados do contrato nº" + i + ": ");
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataDoContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas =  sc.nextInt();
			HorasDeContrato contrato = new HorasDeContrato(dataDoContrato, valorPorHora, horas);
			trabalho.addContrato(contrato);
			
		} 
		System.out.println();
		System.out.print("Digite o mês e o ano para calcular a renda (MM/yyyy): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: " + trabalho.getNome());
		System.out.println("Departamento: " + trabalho.getDepartamento().getNome());
		System.out.println("Renda para " + mesEAno + ": " + String.format("%.2f",  trabalho.renda(ano, mes)));
		
	
		
		sc.close();
	}

}
