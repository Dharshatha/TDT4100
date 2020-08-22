package interfaces;

public interface Named {
	
	void setGivenName(String navn) throws IllegalArgumentException;
	String getGivenName();
	void setFamilyName(String navn) throws IllegalArgumentException;
	String getFamilyName();
	void setFullName(String navn) throws IllegalArgumentException;
	String getFullName();

}
