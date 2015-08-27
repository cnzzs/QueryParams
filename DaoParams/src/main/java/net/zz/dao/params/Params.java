package net.zz.dao.params;


/**
 * Created by ZaoSheng on 2015/7/15.
 */
public interface Params {

    String toFormatSQL();

    String toSQL();

    public Page getPage();

    public QueryParams builderAttrs();

    public QueryParams builderParas();

    public String alias();

}
