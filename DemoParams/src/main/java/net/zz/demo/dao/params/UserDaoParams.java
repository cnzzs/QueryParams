package net.zz.demo.dao.params;

import net.zz.dao.params.Restriction;
import net.zz.dao.params.Where;

import java.util.List;

/**
 * user 请求参数封装类
 * Thu May 07 10:28:37 CST 2015 ZaoSheng
 * 实体对映的DaoParams实现（Demo）。具体可以生成。
 */
public class UserDaoParams extends Where {
    public enum Field {
        userId("user_id"), pid("pid"), status("status");
        private String column;

        private Field(String column) {
            this.column = column;
        }

        public String getColumn() {
            return column;

        }
        public String alias(){
            return "user";
        }
        public static String getSelect()
        {
            return getSelect("d");
        }
        public static String getSelect(String prefix)
        {
            StringBuilder sb = new StringBuilder();
            for ( Field field : Field.values()) {
                sb.append(String.format(" %s.`%s` %s, ", prefix, field.getColumn(), field.name()));
            }
            return sb.toString();
        }
    }

    public void setUserId(String userId) {
        and(Field.userId.name(), userId, "user");
    }

    public void setUserIdLike(String userId) {
        and(Field.userId.name(), userId, Restriction.LIKE, "user");
    }

    public void setUserIdIn(List<Object> userIds) {
        and(Field.userId.name(), userIds, Restriction.IN, "user");
    }

    public List<Object> getUseridIn() {

        return (List<Object>) attrs.get(Field.userId.name());
    }

    public String getUserid() {

        return (String) attrs.get(Field.userId.name());
    }

    public void setPid(String pid) {
        and(Field.pid.name(), pid, "user");
    }

    public String getPid() {
        return (String) attrs.get(Field.pid.name());
    }

    public void setStatus(Byte status) {
        and(Field.status.name(), status, "user");
    }
    public Byte getStatus() {
        return (Byte) attrs.get(Field.status.name());
    }

}

