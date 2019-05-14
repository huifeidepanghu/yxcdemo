package com.sgcc.epri.dataexchangeplatform.Datasource;


public class CustomerContextHolder {
    public static final String DATA_SOURCE_DM7 = "DM7";
    public static final String DATA_SOURCE_DM6= "DM6";
    public static final String DATA_SOURCE_GBASE = "INFORMIX";
    //用ThreadLocal来设置当前线程使用哪个dataSource
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }
    public static String getCustomerType() {
            return contextHolder.get();

    }
    public static void clearCustomerType() {
        contextHolder.remove();
    }
}
