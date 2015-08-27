package net.zz.dao.params;

import java.util.*;

/**
 * Created by ZaoSheng on 2015/8/5.
 */
public class Where extends QueryParams {
    private String first = null;
    private Map<String, Object[]> wheres = new HashMap<String, Object[]>();
    protected Map<String, Object> attrs = new HashMap<String, Object>();
    protected List<Object> paras = new ArrayList<Object>();

    public Where() {

    }

    public  Where(String propertyName, Object value, String prefix) {
        first = propertyName;
        add(propertyName, value, AndOr.NUL, Restriction.EQ, prefix);
    }

    public  Where(String propertyName, Object value) {
        this(propertyName, value, null);
    }

    public Map<String, Object[]> getWheres() {
        return wheres;
    }


    public QueryParams builderAttrs() {
       if (null != getWhere()) super.builderAttrs();
        else {
           if (null == sql) sql = new StringBuilder();

           sql.append(toSQL());
       }
        return this;
    }

    public QueryParams builderParas() {
        if (null != getWhere()) super.builderAttrs();
        else {
            if (null == sql) sql = new StringBuilder();

            sql.append(toFormatSQL());
        }


        return this;
    }

    public Where and(String propertyName, Object value, Restriction restriction, String prefix) {
        add(propertyName, value, AndOr.AND, restriction, prefix);
        return this;
    }

    public Where and(String propertyName, Object value, Restriction restriction) {
        add(propertyName, value, AndOr.AND, restriction, null);
        return this;
    }

    public Where and(String propertyName, Object value) {
        return and(propertyName, value, Restriction.EQ);
    }

    public Where and(String propertyName, Object value, String prefix) {
        return and(propertyName, value, Restriction.EQ, prefix);
    }

    public Where or(String propertyName, Object value, Restriction restriction) {
        add(propertyName, value, AndOr.OR, restriction, null);
        return this;
    }
    public Where or(String propertyName, Object value, Restriction restriction, String prefix) {
        add(propertyName, value, AndOr.OR, restriction, prefix);
        return this;
    }

    public Where or(String propertyName, Object value) {
        return or(propertyName, value, Restriction.EQ);
    }

    public Where or(String propertyName, Object value, String prefix) {
        return or(propertyName, value, Restriction.EQ, prefix);
    }

    public Where add(String propertyName, Object value) {
        add(propertyName, value, null);
        return this;
    }
    public Where add(String propertyName, Object value, String prefix) {
        if (null == first)  first = propertyName;
        add(propertyName, value, AndOr.NUL, Restriction.EQ, prefix);
        return this;
    }
    protected Where add(String key, Object value, AndOr andor, Restriction restriction, String prefix) {
        switch (restriction) {
            case NULL:
            case NOTNULL:
                wheres.put(key, new Object[]{null, andor, restriction, prefix });
                break;
            default:
                if (null == value || "".equals(value)) {
                        if (key.equals(first)) first = null;
                    wheres.remove(key);
                } else {
                    wheres.put(key, new Object[]{value, andor, restriction, prefix});
                }
        }
        return this;

    }


    public String toSQL() {
        if (wheres.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        if (null != first) setSql(first, wheres.get(first), sb);

        for (String key : wheres.keySet()) {
            if (key.equals(first)) continue;

            Object[] objects = wheres.get(key);
            setSql(key, objects, sb);

        }
        return sb.toString();
    }

    private void setSql(String key, Object[] objects, StringBuilder sb) {
        AndOr andOr = (AndOr) objects[1];
        Restriction restriction = (Restriction) objects[2];
        String prefix = null == objects[3] ? "" : (objects[3] + ".");
        switch (restriction) {
            case LIKE:
            case LLIKE:
            case RLIKE:
                sb.append(andOr.toMatchString(prefix + key, "like :" + key));
                attrs.put(key, restriction.toMatchString(objects[0].toString()));
                break;
            case NULL:
            case NOTNULL:
                sb.append(andOr.toMatchString(prefix, restriction.toMatchString(key)));
                break;
            case BETWEEN:
                System.out.println(restriction.toMatchString(key));
                sb.append(andOr.toMatchString(prefix , restriction.toMatchString(key)));
                Object[] value = (Object[]) objects[0];
                attrs.put(String.format("%s1", key), value[0]);
                attrs.put(String.format("%s2", key), value[1]);
                break;
            default:
                sb.append(andOr.toMatchString(prefix + key, restriction.toMatchString(key)));
                attrs.put(key, objects[0]);
        }
    }

    @Override
    public String toFormatSQL() {
        return toFormatSQL(toSQL(), attrs, paras);
    }




    @Override
    public String toString() {
        return toFormatSQL();
    }

    @Override
    public Map<String, Object> getAttrs() {
        return attrs;
    }

    @Override
    public List<Object> getParas() {
        return paras;
    }

    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();

        Where where = new Where("name", "张三");
        where.or("class", 2);
        where.and("sex", true);
        where.and("no", 10, Restriction.LT);
        where.and("age", new Integer[]{1, 10}, Restriction.BETWEEN);
        List<Object> ids = new ArrayList<Object>();
        ids.add(4);
        ids.add(3);
        where.and("id", ids, Restriction.IN);
        System.out.println(where.toString());
        System.out.println(where.toSQL());

        for (Object value : where.getParas()) {
            System.out.print(String.format("%s ", value));
        }


    }
}
