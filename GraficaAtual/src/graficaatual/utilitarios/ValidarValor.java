package graficaatual.utilitarios;


import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *
 * @author Projeto X
 */
public class ValidarValor {
 

    public enum Tipo {
        Truncamento,
        ArredondamentoParaCima,
        ArredondamentoParaBaixo
    }

    
    public ValidarValor() {
    }

    public static boolean isValor(String valor) {
        boolean FvaRetorno = false;
        try {
            DecimalFormat formatador = new DecimalFormat();
            formatador.applyPattern("###,####,##0.00;-###,###,##0.00");
            double f = formatador.parse(valor.trim()).doubleValue();
            FvaRetorno = true;
        } catch (Exception e) {
            System.out.println("Erro ao tentar validar o valor informado. Erro: " + e);
        }
        return FvaRetorno;
    }

   

    public static double getDouble(String valor) {
        double FvaRetorno = 0.0;
        if (valor.trim().length() > 0) {
            try {
                DecimalFormat formatador = new DecimalFormat();
                formatador.applyPattern("###,####,##0.00;-###,###,##0.00");
                FvaRetorno = formatador.parse(valor.trim()).doubleValue();
            } catch (Exception e) {
                System.out.println("Erro ao tentar converter o valor informado. Erro: " + e);
            }
        }
        return FvaRetorno;
    }

    public static double getDouble3(String valor) {
        double FvaRetorno = 0.0;
        if (valor.trim().length() > 0) {
            try {
                DecimalFormat formatador = new DecimalFormat();
                formatador.applyPattern("###,####,##0.000;-###,###,##0.000");
                FvaRetorno = formatador.parse(valor.trim()).doubleValue();
            } catch (Exception e) {
                System.out.println("Erro ao tentar converter o valor informado. Erro: " + e);
            }
        }
        return FvaRetorno;
    }

    public static double getDouble4casas(String valor) {
        double FvaRetorno = 0.0;
        if (valor.trim().length() > 0) {
            try {
                DecimalFormat formatador = new DecimalFormat();
                formatador.applyPattern("###,####,##0.0000;-###,###,##0.0000");
                FvaRetorno = formatador.parse(valor.trim()).doubleValue();
            } catch (Exception e) {
                System.out.println("Erro ao tentar converter o valor informado. Erro: " + e);
            }
        }
        return FvaRetorno;
    }

    public static double getBigD(String valor) {
        double FvaRetorno = 0.0;
        if (valor.trim().length() > 0) {
            try {
                DecimalFormat formatador = new DecimalFormat();
                formatador.applyPattern("###,####,##0.0000;-###,###,##0.0000");
                FvaRetorno = formatador.parse(valor.trim()).doubleValue();
            } catch (Exception e) {
                System.out.println("Erro ao tentar converter o valor informado. Erro: " + e);
            }
        }
        return FvaRetorno;
    }

    public static String getDouble(double valor) {
        String FvaRetorno = "0,00";
        try {
            DecimalFormat formatador = new DecimalFormat();
            formatador.applyPattern("###,####,##0.00;-###,###,##0.00");
            FvaRetorno = formatador.format(valor);
        } catch (Exception e) {
            System.out.println("Erro ao tentar converter o valor informado. Erro: " + e);
        }
        return FvaRetorno;
    }

    public static String getDouble3Casas(double valor) {
        String FvaRetorno = "0,000";
        try {
            DecimalFormat formatador = new DecimalFormat();
            formatador.applyPattern("###,####,##0.000;-###,###,##0.000");
            FvaRetorno = formatador.format(valor);
        } catch (Exception e) {
            System.out.println("Erro ao tentar converter o valor informado. Erro: " + e);
        }
        return FvaRetorno;
    }
  

    public static Double getParseDouble(String valor) {
        Double FvaRetorno = 0.0;
        try {
            FvaRetorno = Double.parseDouble(valor);
        } catch (Exception e) {
            System.out.println("Erro ao tentar converter o valor informado. [ValidarValor.getParseDouble](valor:" + valor + ")Erro: " + e);
        }
        return FvaRetorno;
    }

    public static int getInt(String valor) {

        int FvaRetorno = 0;
        try {
            FvaRetorno = Integer.parseInt(valor.trim());
        } catch (Exception e) {
            System.out.println("Erro ao tentar converter string em inteiro. [ValidarValor.getInt](valor:" + valor + ") Erro: " + e);
        }
        return FvaRetorno;
    }

    public static String getCasas(String valor) {

        String FvaRetorno = "";
        try {
            if (ValidarValor.getDouble(valor.trim().substring(valor.length() - 4, valor.length())) > 0.0) {
                FvaRetorno = "" + ValidarValor.getDouble(ValidarValor.getParseDouble(valor));
            } else {
                FvaRetorno = valor.trim().substring(0, valor.length() - 5);
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar converter string em inteiro. Erro: " + e);
        }
        return FvaRetorno;
    }

    public static boolean getBoolean(String valor) {
        boolean FvaRetorno = false;
        try {
            FvaRetorno = Boolean.parseBoolean(valor.trim());
        } catch (Exception e) {
            System.out.println("Erro ao tentar converter string em inteiro. Erro: " + e);
        }
        return FvaRetorno;
    }

    public static long getLong(String valor) {
        long FvaRetorno = 0;
        try {
            FvaRetorno = Long.parseLong(valor.trim());
        } catch (Exception e) {
            System.out.println("Erro ao tentar converter string em long. Erro: " + e);
        }
        return FvaRetorno;
    }

    public static Integer getInteger(String valor) {
        int FvaRetorno = 0;
        try {
            FvaRetorno = Integer.parseInt(valor.trim());
        } catch (Exception e) {
            System.out.println("Erro ao tentar converter string em inteiro. Erro: " + e);
        }
        System.out.println("fvaInt:" + FvaRetorno);
        return FvaRetorno;
    }

    public static boolean isNumeric(String FvaValor) {
        boolean isValido = true;
        FvaValor = ("" + FvaValor).trim();
        if (FvaValor.length() > 0) {
            for (int i = 0; i < FvaValor.length(); i++) {
                Character caracter = FvaValor.charAt(i);
                if (!Character.isDigit(caracter)) {
                    isValido = false;
                }
            }
        } else {
            isValido = false;
        }
        return isValido;
    }

    public static String getFormatadoZE(int FvaValor, String mascara) {
        String FvaRetorno = "";
        DecimalFormat formatador = new DecimalFormat();
        formatador.applyPattern(mascara);
        try {
            FvaRetorno = formatador.format(new java.math.BigDecimal(FvaValor));
        } catch (Exception e) {
            FvaRetorno = "";
        }
        return FvaRetorno;
    }

    public static String getFormatadoZE(Long FvaValor, String mascara) {
        String FvaRetorno = "";
        DecimalFormat formatador = new DecimalFormat();
        formatador.applyPattern(mascara);
        try {
            FvaRetorno = formatador.format(new java.math.BigDecimal(FvaValor));
        } catch (Exception e) {
            FvaRetorno = "";
        }
        return FvaRetorno;
    }

    public static double getArredondamentoOFI(double valor) {  //Utilizado no arredondamento de of parcial 04/06/2012
        valor = valor - 0.001;
        return getArredondamento(valor, 2);
    }

    public static double getArredondamento(double valor) {
        return getArredondamento(valor, 2);
    }

    public static double getArredondamento(double valor, int precisao) {
        valor = valor + 0.000000001;
        BigDecimal bd = new BigDecimal(valor);
        bd = bd.setScale(precisao, BigDecimal.ROUND_HALF_UP);
        valor = bd.doubleValue();
        return valor;
    }

    public static double getArredondamentoDown(double valor, int precisao) {
        valor = valor - 0.001;
        BigDecimal bd = new BigDecimal(valor);
        bd = bd.setScale(precisao, BigDecimal.ROUND_HALF_UP);
        valor = bd.doubleValue();
        return valor;
    }

    public static double getArredondamento(double valor, Tipo tp) {
        return getArredondamento(valor, 2, tp);
    }

    public static double getArredondamento(double valor, int precisao, Tipo tp) {

        int tipo = BigDecimal.ROUND_HALF_UP;
        if (tp == Tipo.Truncamento) {
            tipo = BigDecimal.ROUND_DOWN;
        }
        if (tp == Tipo.ArredondamentoParaCima) {
            tipo = BigDecimal.ROUND_HALF_UP;
        }
        if (tp == Tipo.ArredondamentoParaBaixo) {
            tipo = BigDecimal.ROUND_FLOOR;
        }

        valor = valor + 0.000000001;

        BigDecimal bd = new BigDecimal(valor);
        bd = bd.setScale(precisao, tipo);
        valor = bd.doubleValue();

        return valor;
    }

    public static String getValorFormatadoAB(String vr) {///  654879.60
        String ret = vr.substring(0, (vr.length() - 2)) + "." + vr.substring(vr.length() - 2);
        return ret;
    }

    
}
