public class Fluxo {

    public static void main(String[] args) {
        System.out.println("Ini do main");
        metodo1();
        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Ini do metodo1");
        try {
        	try {
				metodo2();
			} catch (MinhaExcecao e) {
				e.printStackTrace();
			}
		} catch (ArithmeticException | NullPointerException ex) {
			String msg = ex.getMessage();
			ex.printStackTrace();
			System.out.println("deu engronha " + msg);
		}
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() throws MinhaExcecao {
        System.out.println("Ini do metodo2");
        for(int i = 1; i <= 5; i++) {
            System.out.println(i);
            Conta c = null;
            c.depositar();
        	int a = i / 0;
        }
        System.out.println("Fim do metodo2");
    }
}