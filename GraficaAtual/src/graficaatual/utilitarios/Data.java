
package graficaatual.utilitarios;


import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Projeto X
 */
public class Data {

    public static String FORMAT_DATA = "yyyy-MM-dd"; //Formato de data do MySQL
    public static String FORMAT_DATA_BR = "dd/MM/yyyy";
    public static String FORMATO_FUNCAO_DATA = "NOW();"; //GETDATE()
    public static String FORMAT_DATATIME_BR = "dd/MM/yyyy HH:mm:ss";
    public static String FORMAT_DATATIME_USA = "yyyy-MM-dd HH:mm:ss";

    public static String getDataAtual() {
        try {
            DateFormat df = new SimpleDateFormat(FORMAT_DATA);
            Date date = new Date();
            return df.format(date);
        } catch (Exception e) {
            //System.out.println("Ocorreu no mï¿½todo getDate(java.sql.date) ao tentar formatar a data informada. Erro: " + e);
        }
        return null;
    }

    public static String getDataAtual(String pattern) {
        try {
            DateFormat df = new SimpleDateFormat(pattern);
            Date date = new Date();
            return df.format(date);
        } catch (Exception e) {
            //System.out.println("Ocorreu no mï¿½todo getDate(java.sql.date) ao tentar formatar a data informada. Erro: " + e);
        }
        return null;
    }

    public static String getDateTime() {
        try {
            DateFormat df = new SimpleDateFormat(FORMAT_DATA_BR);
            Date date = new Date();
            return df.format(date);
        } catch (Exception e) {
            // System.out.println("Ocorreu no mï¿½todo getDate(java.sql.date) ao tentar formatar a data informada. Erro: " + e);
        }
        return null;
    }

    public static String getDateTime(Timestamp date) {

        String FvaRetorno = "";
        if (date == null) {
            return "";
        }
        try {
            java.util.Date newDate = new java.util.Date();
            newDate.setTime(date.getTime());

            DateFormat df = new SimpleDateFormat(FORMAT_DATATIME_BR);
            df.setLenient(false);
            FvaRetorno = df.format(newDate);
        } catch (Exception e) {
            //System.out.println("Ocorreu no mï¿½todo getDate(java.sql.date) ao tentar formatar a data informada. Erro: " + e);
//            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public static String getDateTime(Date date) {

        String FvaRetorno = "";
        if (date == null) {
            return "";
        }
        try {
            java.util.Date newDate = new java.util.Date();
            newDate.setTime(date.getTime());

            DateFormat df = new SimpleDateFormat(FORMAT_DATATIME_BR);
            df.setLenient(false);
            FvaRetorno = df.format(newDate);
        } catch (Exception e) {
            //System.out.println("Ocorreu no mï¿½todo getDate(java.sql.date) ao tentar formatar a data informada. Erro: " + e);
//            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public static String getDateTimeSQL(java.sql.Date date) {
        String FvaRetorno = "";
        if (date == null) {
            return "";
        }
        try {
            java.util.Date newDate = new java.util.Date();
            newDate.setTime(date.getTime());

            DateFormat df = new SimpleDateFormat(FORMAT_DATATIME_BR);
            df.setLenient(false);
            FvaRetorno = df.format(newDate);

        } catch (Exception e) {
            //System.out.println("Ocorreu no mï¿½todo getDate(java.sql.date) ao tentar formatar a data informada. Erro: " + e);
//            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public static java.sql.Date getDateTimeSQL(String dataStr) {
        java.sql.Date FvaDataRetorno = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATATIME_BR);
            df.setLenient(false);
            FvaDataRetorno = new java.sql.Date(df.parse(dataStr).getTime());
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro na função getDateParse(String dataStr, String pattern). Erro: " + e);
        }
        return FvaDataRetorno;
    }

    public static java.sql.Date getDateTimeSQLUSA(String dataStr) {
        java.sql.Date FvaDataRetorno = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATATIME_USA);
            df.setLenient(false);
            FvaDataRetorno = new java.sql.Date(df.parse(dataStr).getTime());
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro na fun��o getDateParse(String dataStr, String pattern). Erro: " + e);
        }
        return FvaDataRetorno;
    }

    public static java.util.Date getDateTimeUtilSQLUSA(String dataStr) {
        java.sql.Date FvaDataRetorno = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATATIME_USA);
            df.setLenient(false);
            FvaDataRetorno = new java.sql.Date(df.parse(dataStr).getTime());
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro na fun��o getDateParse(String dataStr, String pattern). Erro: " + e);
        }
        return FvaDataRetorno;
    }

    public static java.util.Date getDateParse(String dataStr, String pattern) {
        java.util.Date FvaDataRetorno = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            df.setLenient(false);
            FvaDataRetorno = df.parse(dataStr);
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro na função getDateParse(String dataStr, String pattern). Erro: " + e);
        }
        return FvaDataRetorno;
    }

    public static String getDateParse(java.util.Date data, String pattern) {
        String FvaDataRetorno = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            df.setLenient(false);
            FvaDataRetorno = df.format(data);
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro na função getDateParse(String dataStr, String pattern). Erro: " + e);
        }
        return FvaDataRetorno;
    }

    private static java.util.Date getDateParse(String dataStr) {
        java.util.Date FvaDataRetorno = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATA_BR);
            df.setLenient(false);
            FvaDataRetorno = df.parse(dataStr);
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro na fun��o getDateParse(String dataStr). Erro: " + e);
        }
        return FvaDataRetorno;
    }

    private static String getDateParse(java.util.Date data) {
        String FvaDataRetorno = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATA_BR);
            df.setLenient(false);
            FvaDataRetorno = df.format(data);
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro na fun��o getDateParse(String dataStr, String pattern). Erro: " + e);
        }
        return FvaDataRetorno;
    }

    public static String dateAdd(String dateStr, int dias) {
        String FvaRetorno = "";
        try {

            SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATA_BR);
            df.setLenient(false);
            java.util.Date dataTemp = df.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataTemp);
            calendar.add(Calendar.DATE, dias);
            FvaRetorno = df.format(calendar.getTime());
        } catch (java.text.ParseException e) {
            //System.out.println("Ocorreu um erro no m�todo dateAdd(String dateStr, int dias, String pattern). Erro: " + e);
        }
        return FvaRetorno;
    }

    public static boolean isDate(String dateStr) {
        dateStr = dateStr + "";
        boolean FvaRetorno = true;
        if (dateStr.equalsIgnoreCase("null") || dateStr.length() == 0) {
            return false;
        }
        try {
            boolean FvaTipoData = true;
            DateFormat df = new SimpleDateFormat(FORMAT_DATA_BR);
            Calendar cal = new GregorianCalendar();
            cal.setTime(df.parse(dateStr));

            String[] data = dateStr.split("/");
            String dia = data[0];
            String mes = data[1];
            String ano = data[2];
            if ((new Integer(dia)).intValue() != (new Integer(cal.get(Calendar.DAY_OF_MONTH))).intValue()) {
                FvaRetorno = false;
            } else if ((new Integer(mes)).intValue() != (new Integer(cal.get(Calendar.MONTH) + 1)).intValue()) {
                FvaRetorno = false;
            } else if ((new Integer(ano)).intValue() != (new Integer(cal.get(Calendar.YEAR))).intValue()) {
                FvaRetorno = false;
            }
        } catch (Exception e) {
            FvaRetorno = false;
            //System.out.println("Ocorreu um erro no m�todo isDate(String dateStr). Erro: " + e);
        }
        return FvaRetorno;
    }

    public static boolean isDateTime(String dateStr) {
        dateStr = dateStr + "";
        boolean FvaRetorno = true;
        if (dateStr.equalsIgnoreCase("null") || dateStr.length() == 0) {
            return false;
        }
        try {
            boolean FvaTipoData = true;
            DateFormat df = new SimpleDateFormat(FORMAT_DATATIME_BR);
            Calendar cal = new GregorianCalendar();
            cal.setTime(df.parse(dateStr));

        } catch (Exception e) {
            FvaRetorno = false;
            System.out.println("Ocorreu um erro no método isDateTime(String dateStr) = " + dateStr + ". Erro: " + e);
            e.printStackTrace();
        }        
        return FvaRetorno;
    }

    public static boolean isDate(String dateStr, String patern) {
        dateStr = dateStr + "";
        boolean FvaRetorno = true;
        if (dateStr.equalsIgnoreCase("null") || dateStr.length() == 0) {
            return false;
        }
        try {
            DateFormat df = new SimpleDateFormat(patern);
            Calendar cal = new GregorianCalendar();
            cal.setTime(df.parse(dateStr));

            DateFormat df2 = new SimpleDateFormat(FORMAT_DATA_BR);
            df2.setLenient(false);
            dateStr = df2.format(cal.getTime());

            String[] data = dateStr.split("/");
            String dia = data[0];
            String mes = data[1];
            String ano = data[2];
            if ((new Integer(dia)).intValue() != (new Integer(cal.get(Calendar.DAY_OF_MONTH))).intValue()) {
                FvaRetorno = false;
            } else if ((new Integer(mes)).intValue() != (new Integer(cal.get(Calendar.MONTH) + 1)).intValue()) {
                FvaRetorno = false;
            } else if ((new Integer(ano)).intValue() != (new Integer(cal.get(Calendar.YEAR))).intValue()) {
                FvaRetorno = false;
            }
        } catch (Exception e) {
            FvaRetorno = false;
            //System.out.println("Ocorreu um erro no m�todo isDate(data) ao tentar verificar se a data infornada � uma data v�lida. Erro: " + e);
        }
        return FvaRetorno;
    }

    public static String getDate() {
        String FvaDataRetorno = "";
        try {
            java.util.Date data = new java.util.Date();
            FvaDataRetorno = getDateParse(data);
        } catch (Exception e) {

        }
        return FvaDataRetorno;
    }

    public static java.util.Date getDateNow() {
        try {
            return new java.util.Date();
        } catch (Exception e) {

        }
        return null;
    }

    public static String getDate(String pattern) {
        String FvaDataRetorno = "";
        try {
            java.util.Date data = new java.util.Date();
            FvaDataRetorno = getDateParse(data, pattern);
        } catch (Exception e) {

        }
        return FvaDataRetorno;
    }

    public static String getDateConvertFormat(String data) {
        String FvaDataRetorno = "";
        try {
            if (isDate(data)) {
                java.util.Date datar = getDateParse(data);
                FvaDataRetorno = getDateParse(datar, FORMAT_DATA);
            }
        } catch (Exception e) {

        }
        return FvaDataRetorno;
    }

    public static String getDateConvertFormat(String data, String patternr) {
        String FvaDataRetorno = "";
        try {
            if (isDate(data)) {
                java.util.Date datar = getDateParse(data);
                FvaDataRetorno = getDateParse(datar, patternr);
            }
        } catch (Exception e) {

        }
        return FvaDataRetorno;
    }

    public static String getDateConvertFormat(String data, String pattern, String patternr) {
        String FvaDataRetorno = "";
        try {
            if (isDate(data, pattern)) {
                java.util.Date datar = getDateParse(data, pattern);
                FvaDataRetorno = getDateParse(datar, patternr);
            }
        } catch (Exception e) {

        }
        return FvaDataRetorno;
    }

    public static String getDate(java.util.Date date) {
        String FvaRetorno = "";
        if (date == null) {
            return "";
        }
        try {
            DateFormat df = new SimpleDateFormat(FORMAT_DATA_BR);
            df.setTimeZone(TimeZone.getTimeZone("GMT -03:00"));
            df.setLenient(false);
            FvaRetorno = df.format(date);
        } catch (Exception e) {
            //System.out.println("Ocorreu no método getDate(java.sql.date) ao tentar formatar a data informada. Erro: " + e);
//            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public static java.sql.Date getDateSQL(String dateStr) {
        java.sql.Date FvaRetorno = null;
        dateStr = dateStr + "";
        if (dateStr.equalsIgnoreCase("null") || dateStr.length() == 0) {
            return null;
        }
        try {
            java.util.Date newDate;
            DateFormat df = new SimpleDateFormat(FORMAT_DATA_BR);
            df.setLenient(false);
            newDate = df.parse(dateStr);

            FvaRetorno = new java.sql.Date(newDate.getTime());
        } catch (Exception e) {

        }
        return FvaRetorno;
    }

    public static java.sql.Date getDateSQL(String dateStr, String formato) {
        java.sql.Date FvaRetorno = null;
        dateStr = dateStr + "";
        if (dateStr.equalsIgnoreCase("null") || dateStr.length() == 0) {
            return null;
        }
        try {

            java.util.Date newDate;
            DateFormat df = new SimpleDateFormat(formato);
            df.setLenient(false);
            newDate = df.parse(dateStr);

            FvaRetorno = new java.sql.Date(newDate.getTime());

        } catch (Exception e) {
           
        }
        return FvaRetorno;
    }

    public static java.sql.Date getDateSQL(java.util.Date newDate) {
        java.sql.Date FvaRetorno = null;

        if (newDate == null) {
            return null;
        }

        try {

            FvaRetorno = new java.sql.Date(newDate.getTime());

        } catch (Exception e) {
        }
        return FvaRetorno;
    }

    public static java.util.Date getDateUtil(String dateStr) {
        java.util.Date FvaRetorno = null;
        dateStr = dateStr + "";
        if (dateStr.equalsIgnoreCase("null") || dateStr.length() == 0) {
            return null;
        }
        try {
            java.util.Date newDate;
            DateFormat df = new SimpleDateFormat(FORMAT_DATA_BR);
            df.setLenient(false);
            newDate = df.parse(dateStr);

            FvaRetorno = new java.util.Date(newDate.getTime());
        } catch (Exception e) {
            // System.out.println("Ocorreu no método getDateSQL(String dateStr) ao tentar formatar a data informada. Erro: " + e);
//            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public static java.sql.Date getDateSQL() {
        java.sql.Date FvaRetorno = null;
        String dateStr = "" + getDate();
        if (dateStr.equalsIgnoreCase("null") || dateStr.length() == 0) {
            return null;
        }
        try {
            java.util.Date newDate;
            DateFormat df = new SimpleDateFormat(FORMAT_DATA_BR);
            df.setLenient(false);
            newDate = df.parse(dateStr);

            FvaRetorno = new java.sql.Date(newDate.getTime());
        } catch (Exception e) {
            // System.out.println("Ocorreu no m�todo getDateSQL(String dateStr) ao tentar formatar a data informada. Erro: " + e);
//            e.printStackTrace();
        }
        return FvaRetorno;
    }


    public static int getDayWeek(String dataStr) {
        int FvaRetorno = -1;
        try {
            if (isDate(dataStr)) {
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(getDateParse(dataStr));
                FvaRetorno = calendar.get(calendar.DAY_OF_WEEK);
            }
        } catch (Exception e) {
            // System.out.println("Ocorreu um erro ao tentar formatar a data para o formato long. Erro: " + e);
        }
        return FvaRetorno;
    }

    public static String getHora() {
        String FvaRetorno = "";
        try {
            DateFormat df = new SimpleDateFormat("HH:mm:ss");
            df.setLenient(false);
            Calendar calendar = new GregorianCalendar();
            FvaRetorno = df.format(calendar.getTime());
        } catch (Exception e) {
            // System.out.println("Ocorreu um erro getHora(). Erro: " + e);
        }
        return FvaRetorno;
    }

    public static String getHora(String pattern) {
        String FvaRetorno = "";
        try {
            DateFormat df = new SimpleDateFormat(pattern);
            df.setLenient(false);
            Calendar calendar = new GregorianCalendar();
            FvaRetorno = df.format(calendar.getTime());
        } catch (Exception e) {
            // System.out.println("Ocorreu um erro getHora(String pattern). Erro: " + e);
        }
        return FvaRetorno;
    }

    public static String getHora(Time time) {
        String FvaRetorno = "";
        try {
            DateFormat df = new SimpleDateFormat("HH:mm:ss");
            df.setLenient(false);
            Calendar calendar = new GregorianCalendar();
            calendar.setTimeInMillis(time.getTime());
            FvaRetorno = df.format(calendar.getTime());
        } catch (Exception e) {
            // System.out.println("Ocorreu um erro getHora(). Erro: " + e);
        }
        return FvaRetorno;
    }

    public static Time getTime(String str) {
        Time retorno = null;
        try {

            SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
            Date data = formatador.parse(str);

            retorno = new Time(data.getTime());

        } catch (Exception e) {

        }
        return retorno;
    }

    public static String getHoraSenSeg(Time time) {
        String FvaRetorno = "";
        try {
            DateFormat df = new SimpleDateFormat("HH:mm");
            df.setLenient(false);
            Calendar calendar = new GregorianCalendar();
            calendar.setTimeInMillis(time.getTime());
            FvaRetorno = df.format(calendar.getTime());
        } catch (Exception e) {
            // System.out.println("Ocorreu um erro getHora(). Erro: " + e);
        }
        return FvaRetorno;
    }

    public static int isDateCompare(String data1, String pattern1, String data2, String pattern2) {
        int FvaRetorno = -2;
        try {
            if (isDate(data1, pattern1) && isDate(data2, pattern2)) {
                java.util.Date dateA = getDateParse(data1, pattern1);
                java.util.Date dateB = getDateParse(data2, pattern2);
                FvaRetorno = dateA.compareTo(dateB);
            }
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro ao tentar formatar a data para o formato long. Erro: " + e);
        }
        return FvaRetorno;
    }

    public static int isDateCompare(String data1, String data2) {
        int FvaRetorno = -2;
        try {
            if (isDate(data1, FORMAT_DATA_BR) && isDate(data2, FORMAT_DATA_BR)) {
                java.util.Date dateA = getDateParse(data1, FORMAT_DATA_BR);
                java.util.Date dateB = getDateParse(data2, FORMAT_DATA_BR);
                FvaRetorno = dateA.compareTo(dateB);
            }
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro ao tentar formatar a data para o formato long. Erro: " + e);
        }
        return FvaRetorno;
    }

    public static int isDateCompare(java.util.Date data1, java.util.Date data2) {
        int FvaRetorno = -2;
        try {
            FvaRetorno = data1.compareTo(data2);
        } catch (Exception e) {
            // System.out.println("Ocorreu um erro ao tentar formatar a data para o formato long. Erro: " + e);
        }
        return FvaRetorno;
    }

    public static int isHoraCompare(String hora1, String hora2) {
        int FvaRetorno = -2;
        try {
            DateFormat df = new SimpleDateFormat("HH:mm:ss");
            df.setLenient(false);
            java.util.Date date1 = df.parse(hora1);
            java.util.Date date2 = df.parse(hora2);
            FvaRetorno = date1.compareTo(date2);
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro ao tentar formatar a data para o formato long. Erro: " + e);
        }
        return FvaRetorno;
    }

    public static String getDate(java.sql.Date data, String formato) {
        String FvaDataRetorno = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat(formato);
            df.setLenient(false);
            FvaDataRetorno = df.format(data);
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro na fun��o getDateParse(String dataStr, String pattern). Erro: " + e);
        }
        return FvaDataRetorno;
    }

    public static String getDataExtenso(String dateStr, String pattern) {

        if (pattern.isEmpty()) {
            pattern = "EEEEEE ',' dd 'de' MMMM 'de' yyyy";
        }
        String FvaRetorno = "";
        try {
            java.util.Date dataTemp = getDateParse(dateStr);
            SimpleDateFormat df = new SimpleDateFormat(pattern, new Locale("pt", "BR"));
            df.setLenient(false);
            FvaRetorno = df.format(dataTemp);
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro no método dataExtenso(String dateStr, String formato). Erro: " + e);
        }
        return FvaRetorno;
    }

    public static String getDataExtenso(java.util.Date dateSql, String pattern) {

        if (pattern.isEmpty()) {
            pattern = "EEEEEE ',' dd 'de' MMMM 'de' yyyy";
        }
        String FvaRetorno = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern, new Locale("pt", "BR"));
            df.setLenient(false);
            FvaRetorno = df.format(dateSql);
        } catch (Exception e) {
            // System.out.println("Ocorreu um erro no método dataExtenso(String dateStr, String formato). Erro: " + e);
        }
        return FvaRetorno;
    }

    public static String getDataExtenso(java.sql.Date dateSql, String pattern) {
        if (pattern.isEmpty()) {
            pattern = "EEEEEE ',' dd 'de' MMMM 'de' yyyy";
        }
        String FvaRetorno = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern, new Locale("pt", "BR"));
            df.setLenient(false);
            FvaRetorno = df.format(new Date(dateSql.getTime()));
        } catch (Exception e) {
            //System.out.println("Ocorreu um erro no método dataExtenso(String dateStr, String formato). Erro: " + e);
        }
        return FvaRetorno;
    }

  
    public static String getDataFormatadaAB(String data, boolean formArq) {
        try {
            data = data.trim(); //aaaammdd
            String d, m, a;
            if (formArq) {
                a = data.substring(0, 4);//aaaammdd
                m = data.substring(4, 6);
                d = data.substring(6, 8);
            } else {
                d = data.substring(0, 2);//ddmmaaaa
                m = data.substring(2, 4);
                a = data.substring(4, 8);
            }
            return a + "-" + m + "-" + d;
        } catch (Exception e) {
            return null;
        }
    }


    public static String getDataFormatadaDMA(String data, boolean formArq) {
        try {
            data = data.trim(); //aaaammdd
            String d, m, a;
            if (formArq) {
                a = data.substring(0, 4);//aaaammdd
                m = data.substring(4, 6);
                d = data.substring(6, 8);
            } else {
                d = data.substring(0, 2);//ddmmaaaa
                m = data.substring(2, 4);
                a = data.substring(4, 8);
            }
            return d + "/" + m + "/" + a;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getDataFormatadaF(String data) {
        try {//1111-22-33
            //33/22/1111
            data = data.trim();
            String d, m, a;
            a = data.substring(0, 4);
            m = data.substring(5, 7);
            //m = data.substring(4, 6);
            d = data.substring(8, 10);
            //d = data.substring(6, 8);
            //JOptionPane.showMessageDialog(null,d +"/"+ m +"/"+ a );        
            return d + "/" + m + "/" + a;
        } catch (Exception e) {
            return "  /  /    ";
        }
    }

    public static String getDataFormatadaF2(String data) {
        try {//1111-22-33
            //33/22/1111
            data = data.trim();
            String d, m, a;
            d = data.substring(0, 2);
            m = data.substring(3, 5);
            //m = data.substring(4, 6);
            a = data.substring(6, 10);
            //d = data.substring(6, 8);
            //JOptionPane.showMessageDialog(null,d +"/"+ m +"/"+ a );        
            return a + "-" + m + "-" + d;
        } catch (Exception e) {
            return "  -  -    ";
        }
    }

    


    public static Integer _getQtdeDias(Date dataInicial, Date dataFinal) {
        if (dataInicial == null || dataFinal == null) {
            return 0;
        }
        if (dataFinal.compareTo(dataInicial) < 0) {
            return 0;
        }

        long milisecInicial = dataInicial.getTime();
        long milisecFinal = dataFinal.getTime();
        long dif = milisecFinal - milisecInicial;

        return (int) (((dif / 1000) / 60) / 60) / 24;
    }


    public static int getQtdeDias(java.util.Date dataLow, java.util.Date dataHigh) {
        GregorianCalendar startTime = new GregorianCalendar();
        GregorianCalendar endTime = new GregorianCalendar();
        GregorianCalendar curTime = new GregorianCalendar();
        GregorianCalendar baseTime = new GregorianCalendar();
        startTime.setTime(dataLow);
        endTime.setTime(dataHigh);
        int dif_multiplier = 1;
        // Verifica a ordem de inicio das datas
        if (dataLow.compareTo(dataHigh) < 0) {
            baseTime.setTime(dataHigh);
            curTime.setTime(dataLow);
            dif_multiplier = 1;
        } else {
            baseTime.setTime(dataLow);
            curTime.setTime(dataHigh);
            dif_multiplier = -1;
        }
        int result_years = 0;
        int result_months = 0;
        int result_days = 0;
        // Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import acumulando
        // no total de dias. Ja leva em consideracao ano bissesto
        while (curTime.get(GregorianCalendar.YEAR) < baseTime.get(GregorianCalendar.YEAR)
                || curTime.get(GregorianCalendar.MONTH) < baseTime.get(GregorianCalendar.MONTH)) {
            int max_day = curTime.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
            result_months += max_day;
            curTime.add(GregorianCalendar.MONTH, 1);
        }
        // Marca que é um saldo negativo ou positivo
        result_months = result_months * dif_multiplier;
        // Retirna a diferenca de dias do total dos meses
        result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime.get(GregorianCalendar.DAY_OF_MONTH));
        return result_years + result_months + result_days;
    }


    public static int getDia(java.util.Date data) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(TimeZone.getTimeZone("GMT -03:00"));
        gc.setTimeInMillis(data.getTime());

        return gc.get(GregorianCalendar.DAY_OF_MONTH);
    }


    public static int getMes(java.util.Date data) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(TimeZone.getTimeZone("GMT -03:00"));
        gc.setTimeInMillis(data.getTime());

        return gc.get(GregorianCalendar.MONTH) + 1;
    }


    public static int getAno(java.util.Date data) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(TimeZone.getTimeZone("GMT -03:00"));
        gc.setTimeInMillis(data.getTime());

        return gc.get(GregorianCalendar.YEAR);
    }


   

    public static Integer getQtdeMinutos(Date dataInicial, Date dataFinal) {
        if (dataFinal.compareTo(dataInicial) < 0) {
            return 0;
        }

        long milisecInicial = dataInicial.getTime();
        long milisecFinal = dataFinal.getTime();
        long dif = milisecFinal - milisecInicial;

        int ret = (int) (((dif / 1000) / 60));
        return ret;
    }


  

}
