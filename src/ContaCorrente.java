public class ContaCorrente extends Conta implements Tarifavel {

   private double limiteChequeEspecial;

   public ContaCorrente(Agencia agencia, String numeroConta, double saldo,
         double limiteChequeEspecial) {
      super(agencia, numeroConta, saldo);
      this.limiteChequeEspecial = limiteChequeEspecial;
   }

   @Override
   public void saque(double valor) throws ContaException {
      if (valor > 0) {
         if (this.saldo + limiteChequeEspecial >= valor) {
            this.saldo -= valor;
         } else {
            throw new ContaException("Conta sem saldo suficiente: " + this.saldo);
         }
      } else {
         throw new ContaException("Valor inválido para saque " + valor);
      }
   }

   @Override
   public void cobrarTarifa(double valor) throws ContaException {
      if (valor > 0) {
         if (this.saldo >= valor) {
            this.saldo -= valor;
         } else {
            throw new ContaException("Saldo insuficiente para cobrança de tarifa.");
         }
      } else {
         throw new ContaException("Valor inválido para tarifa " + valor);
      }
   }
}
