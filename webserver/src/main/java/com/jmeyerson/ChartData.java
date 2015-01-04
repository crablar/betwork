package com.jmeyerson;

import java.util.List;

public class ChartData {

	String subjectName;
	String valueType;
	long[] values;
	long[] timestamps;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public long[] getValues() {
		return values;
	}

	public void setValues(long[] values) {
		this.values = values;
	}

	public long[] getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(long[] timestamps) {
		this.timestamps = timestamps;
	}

	public ChartData(String subjectName, ChartSubject.ValueType vType, List<Event> events) {
		timestamps = new long[events.size()];
		values = new long[events.size()];
		for(int i = 0; i < events.size(); i++){
			timestamps[i] = events.get(i).getTimestamp();
			values[i] = events.get(i).getValue();
		}
		setSubjectName(subjectName);
		setValueType(vType.toString());
	} 
	
}