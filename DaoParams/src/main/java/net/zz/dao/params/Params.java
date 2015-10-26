package net.zz.dao.params;


import java.util.List;
import java.util.Map;

/**
 * Created by ZaoSheng on 2015/7/15.
 */
public interface Params {

    String toFormatSQL();

    String toSQL();

    public Map<String, Object> getAttrs();

    public List<Object> getParas();

    public Page getPage();

    public QueryParams builderAttrs();

    public QueryParams builderParas();

    public String alias();

}
