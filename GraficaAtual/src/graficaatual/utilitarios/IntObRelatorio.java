package graficaatual.utilitarios;

import java.util.Map;

public interface IntObRelatorio {
	
	public String getSql();
	public String getArquivoJasper();
	public String getTituloRelatorio();
	public Map<String, Object> getParametro();
	
}
