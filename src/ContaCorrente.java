public class ContaCorrente extends Conta {

    private double limiteChequeEspecial;

    public ContaCorrente(Agencia agencia, String numeroConta, double saldo,
                         double limiteChequeEspecial) {
        super(agencia,numeroConta,saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
    
    @Override
    public void saque(double valor) throws ContaException {
        if (valor > 0) {
           if (this.saldo + limiteChequeEspecial >= valor) {
              this.saldo -= valor;
           } else {
              throw new ContaException("Conta sem saldo suficiente: "+this.saldo);
           }
        } else {
              throw new ContaException("Valor inválido para saque "+valor);
        }
     }

}