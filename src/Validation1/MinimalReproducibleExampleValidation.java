package Validation1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MinimalReproducibleExampleValidation {

public static void main(String[] args) {

    boolean saveToDatabase = true;

    String name = "Richard";
    String idCard = "123456789";
    String address = "Main Street 454";

    Entity entity = new Entity ();

    /// Name Validation
    if (saveToDatabase) {
        ValidationEntity nameValidation = new ValidationEntity(ValidationEntity.Regex.Alphabetic, name, "Name Validação", 0, 13);
        saveToDatabase = nameValidation.isValid();
        entity.setName(name);
    }
    
    /// ID Card Validation
    if (saveToDatabase) {
        ValidationEntity idCardValidator = new ValidationEntity(ValidationEntity.Regex.Numerical, idCard, "ID Card", 0, 13);
        saveToDatabase = idCardValidator.isValid();
        entity.setIdCard(idCard);
    }
    
    /// EMail Validation
    if (saveToDatabase) {
        ValidationEntity emailValidator = new ValidationEntity(ValidationEntity.Regex.AlphaNumerical, address, "Address", 1, 30);
        saveToDatabase = emailValidator.isValid();
        entity.setAddress(address);
    }
    // If every field is valid, save
    if (saveToDatabase) {
        new EntityDao().save(entity);
    }
}
}

class ValidationEntity {

    private Regex regex;
    private String input;
    private String errorMessage;
    private Integer minimum;
    private Integer maximum;

public ValidationEntity(Regex regex, String input, String errorMessage, int minimum, int maximum) {
    this.regex = regex;
    this.input = input;
    this.errorMessage = errorMessage;
    this.minimum = minimum;
    this.maximum = maximum;
}

public boolean isValid() {
	
    Pattern pattern = Pattern.compile(getRegexFormat(), Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(input);
    
    System.out.println(input);
    System.out.println(pattern);
    System.out.println(matcher);
    System.out.println(matcher.matches());
    
    return matcher.matches();
}

public String getRegexFormat() {
    return "^" + regex.getRegex() + "{" + minimum + "," + maximum + "}";
}

public enum Regex {
    LowercaseAlphabetic("[a-z]"), UppercaseAlphabetic("[A-Z]"), Numerical("[0-9]"), Alphabetic("[a-zA-Z]"),
    AlphaNumerical("^[A-Za-z0-9_ ]*$");

    public String regexValue;
    
    String getRegex() {
    	return this.regexValue;
    }

    Regex(String regexValue) {
        this.regexValue = regexValue;
    }
}
}

class EntityDao {
public void save(Entity entity) {
    System.out.println("Saving the model!");
}
}

class Entity {

private String name;
private String idCard;
private String address;

public void setIdCard(String idCard) {
    this.idCard = idCard;
}

public void setName(String name) {
    this.name = name;
}

public void setAddress(String address) {
    this.address = address;
}

public String getIdCard() {
    return idCard;
}

public String getIdName() {
    return name;
}

public String getAddress() {
    return address;
}
}