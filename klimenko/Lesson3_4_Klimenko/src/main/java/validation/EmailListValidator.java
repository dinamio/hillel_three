package validation;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tj on 16.08.16.
 * Email List validator
 */
public class EmailListValidator implements ConstraintValidator<CheckEmail, String> {
    final private Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
    private static java.util.regex.Pattern pattern;
    @Override
    public void initialize(final CheckEmail constraintAnnotation) {
        //for interface
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {

        return !(value == null || value.isEmpty()) && !emailPattern.matcher(value).matches();
//        value.stream().filter(e -> !StringUtils.isNullOrEmpty(e)).filter(e -> emailPattern.matcher(e).matches()).count() == value.size()
    }
}