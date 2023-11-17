package cccs.hogwarts.howler;

import com.google.common.base.Strings;

public class HowlerUtils {
    public static String defaultStringValue(String value, String envVar, String defaultValue) {
        if (!Strings.isNullOrEmpty(value)) {
            return value;
        }

        String envVarValue = System.getenv(envVar);
        if (!Strings.isNullOrEmpty(envVarValue)) {
            return envVarValue;
        }

        return defaultValue;
    }
}
