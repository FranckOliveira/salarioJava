package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Empregado;


public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Empregado> list = new ArrayList<>();
		
		System.out.print("Quantos funcionários serão cadastrados?");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Empregado nº " +i +": ");
			
			System.out.println("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("ID já informado. Tente novamente: ");
				id = sc.nextInt();
			}
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			list.add(new Empregado(id, name, salario));
		}
		
		System.out.println();
		System.out.println("Informe o ID do funcionário que receberá aumento de salário:  ");
		int id = sc.nextInt();
		Empregado emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null){
			System.out.println("Id não exite!");
		}
		else {
			System.out.print("Informe o percentual: ");
			double percentual = sc.nextDouble();
			emp.aumentaSalario(percentual);
		}
		
		System.out.println();
		System.out.println("Lista de funcionários");
		for (Empregado obj : list) {
			System.out.println(obj);
		}
		
		sc.close();

	}
	
	public static boolean hasId(List<Empregado> list, int id) {
		Empregado emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
