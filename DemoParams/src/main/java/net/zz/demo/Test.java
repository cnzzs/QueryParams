package net.zz.demo;

import net.zz.dao.params.Order;
import net.zz.dao.params.QueryParams;
import net.zz.demo.dao.SqlFilter;

import java.util.Map;

/**
 * Created by ZaoSheng on 2015/8/28.
 */
public class Test {
    public static void main(String[] args) {

        SqlFilter filter = new SqlFilter();
        filter.addFilter("QUERY^t#id^|^EQ",1);
        filter.addFilter("QUERY^t#name^!|^EQ","张三");
        filter.setColumn("uid");
        filter.setOrder(Order.OrderAD.DESC);
        filter.setOrder();
        QueryParams queryParams = filter.getQueryParams();
//        queryParams.where();
        System.out.println(queryParams.builderAttrs().getSqlString());
        Map<String, Object> attrs = queryParams.getAttrs();
        for (String key : attrs.keySet()){
            System.out.println(String.format("%s=%s",key, attrs.get(key)));
        }
    }

}
