package net.zz.demo.dao;

import net.zz.dao.params.Params;
import net.zz.demo.dao.plugin.Page;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by ZaoSheng on 2015/6/12.
 */
public class BaseDao<T, PK extends Serializable>  {

    public Page<T> queryPageUseHQL(Params params, boolean isPage) {
        Page<T> page = null;
        params.builderAttrs().getSqlString();
        String hql = String.format("from %s %s %s", getTableName(), params.alias());

    /*    if (isPage) {
            page = _queryPage(hql, params.getHqlValue(), params.getPageIndex(), params.getPageSize());
        } else {
            page = _queryPage(hql, params.getHqlValue());
        }*/
        return page;
    }





    protected Page<T> _queryPage(final String hql, Map<String, Object> params, Integer page, Integer rows) {
        page = page == null ? 1 : page;
        rows = rows == null ? 10 : rows;
        int startRow = (page - 1) * rows;
        if (startRow < 0)
            startRow = 0;
        Page<T> result = new Page<T>();
        List<T> list = null;

        result.setContent(list);
        result.setPage(page);
        result.setRows(rows);
//        result.setTotal(lo);
        return result;
    }

    /**
     * 得到泛型类型
     *
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    private Class<Object> getGenericType(Integer index) {
        Type genType = getClass().getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            throw new RuntimeException("Index outof bounds");
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class<Object>) params[index];
    }
    protected String getTableName()
    {
        return getGenericType(0).getName();
    }
 /*   private String getPrimaryKey(Class<Object> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Id.class) != null) {
                return field.getName();
            }
        }
        return null;
    }*/
}
