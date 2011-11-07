package com.yunex.springrecipes.sequence;

import java.util.Map;
import java.util.Properties;

/**
 * Map 객체를 사용한 예
 * @author User
 *
 */
public class SequenceGenerator {

	private String prefix;
	private String suffix;
	private int initial;
	private int counter;
	
	private Map<Object, Object> suffixes;
	private Properties suffixes2;

	public SequenceGenerator() {
	}
	
	public SequenceGenerator(String prefix, String suffix, int initial) {
		this.prefix = prefix;
		this.suffix = suffix;
		this.initial = initial;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}
	
	public void setSuffixes(Map<Object, Object> suffixes) {
		this.suffixes = suffixes;
	}
	
	public void setSuffixes2(Properties suffixes2) {
		this.suffixes2 = suffixes2;
	}
	
	public synchronized String getSequence() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(prefix);
		buffer.append(initial + counter++);
		buffer.append(suffix);
		
		for (Map.Entry entry : suffixes.entrySet()) {
			buffer.append("-");
			buffer.append(entry.getKey());
			buffer.append("@");
			buffer.append(entry.getValue());
		}
		
		return buffer.toString();
	}
	
	/**
	 * Properties 타입도 Map과 동일하게 얻는다.
	 * @return
	 */
	public synchronized String getSequence2() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(prefix);
		buffer.append(initial + counter++);
		buffer.append(suffix);
		
		for (Map.Entry entry : suffixes.entrySet()) {
			buffer.append("-");
			buffer.append(entry.getKey());
			buffer.append("@");
			buffer.append(entry.getValue());
		}
		
		return buffer.toString();
	}
}
