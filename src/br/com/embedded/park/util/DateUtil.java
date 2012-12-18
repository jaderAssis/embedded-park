package br.com.embedded.park.util;

import java.util.Calendar;
import java.util.Date;

import br.com.embedded.park.enuns.DiaDaSemana;

public class DateUtil {

	/**
	 * 
	 * @author Jader Assis
	 * @since 05/08/2012 19:00:40
	 *
	 * @param data
	 * @return
	 */
	public static Date dataSemHora(Date data) { 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		return calendar.getTime();
	}
	
	
	public static String diaSemanaPorExtenso(int diaSemanaRecebido) {  
		String diaSemana = null;  

		switch (diaSemanaRecebido) {  
			case 1: {  
				diaSemana = DiaDaSemana.DOMINGO.getDescricao();  
				break;  
			}  
			case 2: {  
				diaSemana = DiaDaSemana.SEGUNDA.getDescricao();  
				break;  
			}  
			case 3: {  
				diaSemana = DiaDaSemana.TERCA.getDescricao();  
				break;  
			}  
			case 4: {  
				diaSemana = DiaDaSemana.QUARTA.getDescricao();  
				break;  
			}  
			case 5: {  
				diaSemana = DiaDaSemana.QUINTA.getDescricao();
				break;  
			}  
			case 6: {  
				diaSemana = DiaDaSemana.SEXTA.getDescricao();
				break;  
			}  
			case 7: {  
				diaSemana = DiaDaSemana.SABADO.getDescricao();
				break;  
			}  

		}  
		return diaSemana;  
	}  
}
