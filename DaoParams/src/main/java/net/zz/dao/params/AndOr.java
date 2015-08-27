package net.zz.dao.params;

/**
 * Created by ZaoSheng on 2015/8/5.
 */
public enum AndOr {
    AND{
        @Override
        public String toMatchString(String propertyName, String pattern) {
            return String.format(" and %s%s ", propertyName, pattern);
        }
    }, OR{
        @Override
        public String toMatchString(String propertyName, String pattern) {
            return String.format(" or %s%s ", propertyName, pattern);
        }
    }, NUL{
        @Override
        public String toMatchString(String propertyName, String pattern) {
            return String.format(" %s%s ", propertyName, pattern);
        }
    };
    public abstract String toMatchString(String propertyName, String pattern);

}