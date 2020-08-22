package app;

import java.io.IOException;

public interface FileManagement {
	public void save(String filename, BMIUtregning calc, Person p) throws IOException;
	public String load(String filename) throws IOException;

}
