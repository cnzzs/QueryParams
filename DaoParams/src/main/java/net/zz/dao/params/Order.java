package net.zz.dao.params;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZaoSheng on 2015/8/5.
 */
public class Order extends QueryParams {
    private Map<String, String[]> orders = null;

    public enum OrderAD {
        ASC, DESC
    }

    public Order() {

    }

    public Order(String key, String prefix) {
        add(key, OrderAD.DESC, prefix);
    }

    public Order(String key) {
        add(key, OrderAD.DESC, null);
    }

    public Order DESC(String key) {
        return add(key, OrderAD.DESC, null);
    }
    public Order DESC(String key, String prefix ) {
        return add(key, OrderAD.DESC, prefix);
    }

    public Order ASC(String key, String prefix ) {
        return add(key, OrderAD.ASC, prefix);
    }

    public Order ASC(String key ) {
        return add(key, OrderAD.ASC, null);
    }

    public QueryParams builderAttrs() {
        if (null != getOrder()) super.builderAttrs();
        else {
            if (null == sql) sql = new StringBuilder();

            sql.append(toSQL());
        }
        return this;
    }

    public QueryParams builderParas() {
        if (null != getOrder()) super.builderAttrs();
        else {
            if (null == sql) sql = new StringBuilder();

            sql.append(toFormatSQL());
        }


        return this;
    }

    protected Order add(String key, OrderAD value, String prefix) {
        if (null == orders) orders = new HashMap<String, String[]>();

        if (null == value) {
            orders.remove(key);
        } else {
            orders.put(key, new String[]{value.name(), prefix});

        }

        return this;
    }

    @Override
    public String toFormatSQL() {
        return toSQL();
    }

    @Override
    public String toSQL() {
        if (null == orders || orders.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(" Order by ");
        for (String key : orders.keySet()) {
            String[] value = orders.get(key);
            sb.append(String.format("%s%s %s, ", null == value[1] ? "" : (value[1] + '.'), key, value[0]));
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }


    public Map<String, String[]> getOrders() {
        return orders;
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.ASC("id");
        order.DESC("qq", "t");
        System.out.println(order.toSQL());
    }

}