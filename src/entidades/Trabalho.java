package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelDeFuncao;

public class Trabalho {
	private String nome;
	private NivelDeFuncao nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<HorasDeContrato> contratos = new ArrayList<>();

	public Trabalho() {
	}

	public Trabalho(String nome, NivelDeFuncao nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelDeFuncao getNivel() {
		return nivel;
	}

	public void setNivel(NivelDeFuncao nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HorasDeContrato> getContratos() {
		return contratos;
	}

	public void addContrato(HorasDeContrato contrato) {
		contratos.add(contrato);
	}
	public void removeContrato(HorasDeContrato contrato) {
		contratos.remove(contrato);
	}
	public double renda(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (HorasDeContrato c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
		
	}
	
	
}
