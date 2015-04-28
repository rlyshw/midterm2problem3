package view;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;


public class DateController {
	@FXML
	private ComboBox<String> Month;
	@FXML
	private ComboBox<String> Day;
	@FXML
	private ComboBox<String> Year;
	
	public DateController(){
	}
	
	@FXML
	private void initialize(){
		List<String> months = Arrays.asList(new DateFormatSymbols().getMonths());
		Month.getItems().addAll(months);
		Month.getItems().remove(Month.getItems().size()-1);
		Month.setValue(Month.getItems().get(Calendar.getInstance().get(Calendar.MONTH)));
		Day.setValue(Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
		Year.setValue(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
		for(int i=-5;i<=5;i++){
			Year.getItems().add(Integer.toString(Calendar.getInstance().get(1)+i));
		}
		for(int i = 1;i<=Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);i++){
			Day.getItems().add(Integer.toString(i));
		}
	}
	
	@FXML
	private void onSelect(){
		if(Day.getValue()==null) Day.setValue("1");
		if(Year.getValue()!=null && Month.getValue()!=null && Day.getValue()!=null){
			Calendar mycal = new GregorianCalendar(
					Integer.parseInt(Year.getValue()),
					Month.getItems().indexOf(Month.getValue()),
					Integer.parseInt(Day.getValue()));
			Day.getItems().remove(0, Day.getItems().size());
			for(int i = 1;i<=mycal.getActualMaximum(Calendar.DAY_OF_MONTH);i++){
				Day.getItems().add(Integer.toString(i));
			}
		}
	}
}
