package com.clinicapp.libs.handler;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class AbstractHandleProvider<T> {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static<T> T getService(String jndi) {
        final Properties jndiProperties = new Properties();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        try {
            return  (T) new InitialContext(jndiProperties).lookup(jndi);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
