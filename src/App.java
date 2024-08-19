public class App {
    public static void main(String[] args) throws Exception {
        Agencia caixaLuizote = new Agencia("0205-08");
        Conta contaCorrente = new ContaCorrente(caixaLuizote, "1164-9", 500d, 1000);
        Conta contaPoupanca = new ContaPoupanca(caixaLuizote, "1324-9", 700d);
        Conta contaSalario = new ContaSalario(caixaLuizote, "1456-9", 1500d);

        caixaLuizote.addConta(contaPoupanca);
        caixaLuizote.addConta(contaCorrente);
        caixaLuizote.addConta(contaSalario);

        // Saques
        caixaLuizote.saque("1164-9", 100);
        caixaLuizote.saque("1324-9", 200);
        caixaLuizote.saque("1456-9", 300);

        if (contaCorrente instanceof Tarifavel) {
            ((Tarifavel) contaCorrente).cobrarTarifa(20);
        }

        System.out.println("Saldo final da Conta Corrente: " + contaCorrente.getSaldo());
        System.out.println("Saldo final da Conta Poupança: " + contaPoupanca.getSaldo());
        System.out.println("Saldo final da Conta Salário: " + contaSalario.getSaldo());
    }
}
