package net.zz.dao.params;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZaoSheng on 2015/8/10.
 */
public class Group extends QueryParams {
    private List<String[]> groups = null;

    public Group() {
    }

    public Group(String key) {
        add(key, null);
    }

    public Group(String key, String prefix) {
        add(key, prefix);
    }
    public Group add(String key) {

        return add(key, null);
    }

    public QueryParams builderAttrs() {
        if (null != getGroup()) super.builderAttrs();
        else {
            if (null == sql) sql = new StringBuilder();

            sql.append(toSQL());
        }
        return this;
    }

    public QueryParams builderParas() {
        if (null != getGroup()) super.builderAttrs();
        else {
            if (null == sql) sql = new StringBuilder();

            sql.append(toFormatSQL());
        }


        return this;
    }

    public Group add(String key, String prefix) {
        if (key == null || "".equals(key)) return this;

        if (null == groups) groups = new ArrayList<String[]>();

        groups.add(new String[]{key, prefix});

        return this;
    }

    @Override
    public String toFormatSQL() {
        return toSQL();
    }

    @Override
    public String toSQL() {
        if (null == groups || groups.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(" Group by ");
        for (String[] value : groups) {

            sb.append(String.format("%s%s, ", null == value[1] ? "" : (value[1] + '.'), value[0]));
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }


    public static void main(String[] args) {
        Group group = new Group();
        group.add("id");
        group.add("qq", "t");
        System.out.println(group.toSQL());
    }

}
