package com.wisely.ch7_7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
@Component
public class MessageUtils {
    @Autowired
    private MessageSource messageSource;

    /**
     * 获取当前语言配置
     */
    public static String currentLanguage() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
                .getRequest();
        String language = request.getHeader("language");
        if(StringUtils.isEmpty(language)) {
            language = request.getParameter("language");
        }
        return (language == null) ? "" : language;
    }

    public  String getMessage(String key){
        String language="en_US";
        language=currentLanguage();
        Locale locale=new Locale(language);
        return messageSource.getMessage(key,null,"",locale);
    }

}
