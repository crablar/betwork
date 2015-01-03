package com.jmeyerson;

import com.jmeyerson.ChartData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/charts")
public class JSONController {

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody
	ChartData getShopInJSON(@PathVariable String name) throws Exception {

		MySQLAccess mySQLAccess = new MySQLAccess();
		String[] pathArr = name.split("-");
		String subjectName = pathArr[0];
		ChartSubject.ValueType valueType = ChartSubject.ValueType.valueOf(pathArr[1]);
		List<Event> events = mySQLAccess.getEvents(pathArr[0], valueType);

		ChartData chartData = new ChartData(subjectName, valueType.toString(), events);

		return chartData;

	}

}