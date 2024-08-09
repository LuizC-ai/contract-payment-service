import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import com.example.demo.entities.Contract;
import com.example.demo.entities.Installment;
import com.example.demo.service.ContractService;
import com.example.demo.service.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();

		Contract contract = new Contract(number, date, totalValue);

		System.out.print("Enter number of installments: ");
		int N = sc.nextInt();

		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, N);

		System.out.println("Installments:");
		for (Installment it : contract.getInstallments()) {
			System.out.println(it);
		}

		sc.close();
		
	}

}
