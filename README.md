# QueryParams
针对sql,hql进行包装，不需要自己写sql，全自动生成对应实体的DaoQueryParam，只需要简单的set便可实现sql的生成
认为不应该再把时间浪费在繁琐的where语句这边(也让其刚入门的友友减少对sql难度)，我认为可以直接用做实体进行实体与表的关联。接下来整合JFianl或者Hibernate，然后一边开发一边完善，作为个人的开发，也希望能有志同道合的一起来完善。

下面是自动生成的具体DaoParam(将其当作实体，待测试)

package com.huodou.dao.params;
import java.sql.Timestamp;
import net.zz.dao.params.*;
import java.util.List;

   /**
    * mn_member 请求参数封装类
    * Thu Oct 15 18:11:09 CST 2015 ZaoSheng
    */ 

//@Table(name = "mn_member")
//@Entity
public class MnMemberDaoParams extends Where{
	public MnMemberDaoParams() {
		alias = "mn_member";
	}
	public enum Field {
		mid("mid"),userId("user_id"),deviceId("device_id"),deviceType("device_type"),deviceToken("device_token"),mtype("mtype"),os("os"),version("version"),lastLoginTime("last_login_time"),ip("IP");
		private String column;

		private Field(String column) {
			this.column = column;
		}
		public String getColumn() {
			return column;
			
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
			sb.deleteCharAt(sb.length() - 2);
			return sb.toString();
		}
	}
	public MnMemberDaoParams setmid(Long mid){
		and(Field.mid.name(), mid, alias);
		return this;
	}
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "mid")
	public Long getmid(){
		return (Long) attrs.get(Field.mid.name());
	}
	public MnMemberDaoParams setmidBetween(Long[] mid) {
		and(Field.mid.name(), mid, Restriction.BETWEEN, alias);
		return this;
	}
	public MnMemberDaoParams setmidNE(Long mid) {
		and(Field.mid.name(), mid, Restriction.NE, alias);
		return this;
	}
	public MnMemberDaoParams setmidGE(Long mid) {
		and(Field.mid.name(), mid, Restriction.GE, alias);
		return this;
	}
	public MnMemberDaoParams setmidGT(Long mid) {
		and(Field.mid.name(), mid, Restriction.GT, alias);
		return this;
	}
	public MnMemberDaoParams setmidIn(List<Object> mid) {
		and(Field.mid.name(), mid, Restriction.IN, alias);
		return this;
	}
	public MnMemberDaoParams setmidNIn(List<Object> mid) {
		and(Field.mid.name(), mid, Restriction.NIN, alias);
		return this;
	}
	public MnMemberDaoParams setmidNull() {
		and(Field.mid.name(), null, Restriction.NULL, alias);
		return this;
	}
	public MnMemberDaoParams setmidNotNull() {
		and(Field.mid.name(), null, Restriction.NOTNULL, alias);
		return this;
	}
	public MnMemberDaoParams setuserId(String userId){
		and(Field.userId.name(), userId, alias);
		return this;
	}
	//@Column(name = "user_id")
	public String getuserId(){
		return (String) attrs.get(Field.userId.name());
	}
	public MnMemberDaoParams setuserIdLLike(String userId) {
		and(Field.userId.name(), userId, Restriction.LLIKE, alias);
		return this;
	}
	public MnMemberDaoParams setuserIdRLike(String userId) {
		and(Field.userId.name(), userId, Restriction.RLIKE, alias);
		return this;
	}
	public MnMemberDaoParams setuserIdLike(String userId) {
		and(Field.userId.name(), userId, Restriction.LIKE, alias);
		return this;
	}
	public MnMemberDaoParams setuserIdIn(List<Object> userId) {
		and(Field.userId.name(), userId, Restriction.IN, alias);
		return this;
	}
	public MnMemberDaoParams setuserIdNIn(List<Object> userId) {
		and(Field.userId.name(), userId, Restriction.NIN, alias);
		return this;
	}
	public MnMemberDaoParams setuserIdNull() {
		and(Field.userId.name(), null, Restriction.NULL, alias);
		return this;
	}
	public MnMemberDaoParams setuserIdNotNull() {
		and(Field.userId.name(), null, Restriction.NOTNULL, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceId(String deviceId){
		and(Field.deviceId.name(), deviceId, alias);
		return this;
	}
	//@Column(name = "device_id")
	public String getdeviceId(){
		return (String) attrs.get(Field.deviceId.name());
	}
	public MnMemberDaoParams setdeviceIdLLike(String deviceId) {
		and(Field.deviceId.name(), deviceId, Restriction.LLIKE, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceIdRLike(String deviceId) {
		and(Field.deviceId.name(), deviceId, Restriction.RLIKE, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceIdLike(String deviceId) {
		and(Field.deviceId.name(), deviceId, Restriction.LIKE, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceIdIn(List<Object> deviceId) {
		and(Field.deviceId.name(), deviceId, Restriction.IN, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceIdNIn(List<Object> deviceId) {
		and(Field.deviceId.name(), deviceId, Restriction.NIN, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceIdNull() {
		and(Field.deviceId.name(), null, Restriction.NULL, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceIdNotNull() {
		and(Field.deviceId.name(), null, Restriction.NOTNULL, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceType(Integer deviceType){
		and(Field.deviceType.name(), deviceType, alias);
		return this;
	}
	//@Column(name = "device_type")
	public Integer getdeviceType(){
		return (Integer) attrs.get(Field.deviceType.name());
	}
	public MnMemberDaoParams setdeviceTypeBetween(Integer[] deviceType) {
		and(Field.deviceType.name(), deviceType, Restriction.BETWEEN, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTypeNE(Integer deviceType) {
		and(Field.deviceType.name(), deviceType, Restriction.NE, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTypeGE(Integer deviceType) {
		and(Field.deviceType.name(), deviceType, Restriction.GE, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTypeGT(Integer deviceType) {
		and(Field.deviceType.name(), deviceType, Restriction.GT, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTypeIn(List<Object> deviceType) {
		and(Field.deviceType.name(), deviceType, Restriction.IN, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTypeNIn(List<Object> deviceType) {
		and(Field.deviceType.name(), deviceType, Restriction.NIN, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTypeNull() {
		and(Field.deviceType.name(), null, Restriction.NULL, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTypeNotNull() {
		and(Field.deviceType.name(), null, Restriction.NOTNULL, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceToken(String deviceToken){
		and(Field.deviceToken.name(), deviceToken, alias);
		return this;
	}
	//@Column(name = "device_token")
	public String getdeviceToken(){
		return (String) attrs.get(Field.deviceToken.name());
	}
	public MnMemberDaoParams setdeviceTokenLLike(String deviceToken) {
		and(Field.deviceToken.name(), deviceToken, Restriction.LLIKE, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTokenRLike(String deviceToken) {
		and(Field.deviceToken.name(), deviceToken, Restriction.RLIKE, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTokenLike(String deviceToken) {
		and(Field.deviceToken.name(), deviceToken, Restriction.LIKE, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTokenIn(List<Object> deviceToken) {
		and(Field.deviceToken.name(), deviceToken, Restriction.IN, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTokenNIn(List<Object> deviceToken) {
		and(Field.deviceToken.name(), deviceToken, Restriction.NIN, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTokenNull() {
		and(Field.deviceToken.name(), null, Restriction.NULL, alias);
		return this;
	}
	public MnMemberDaoParams setdeviceTokenNotNull() {
		and(Field.deviceToken.name(), null, Restriction.NOTNULL, alias);
		return this;
	}
	public MnMemberDaoParams setmtype(Integer mtype){
		and(Field.mtype.name(), mtype, alias);
		return this;
	}
	//@Column(name = "mtype")
	public Integer getmtype(){
		return (Integer) attrs.get(Field.mtype.name());
	}
	public MnMemberDaoParams setmtypeBetween(Integer[] mtype) {
		and(Field.mtype.name(), mtype, Restriction.BETWEEN, alias);
		return this;
	}
	public MnMemberDaoParams setmtypeNE(Integer mtype) {
		and(Field.mtype.name(), mtype, Restriction.NE, alias);
		return this;
	}
	public MnMemberDaoParams setmtypeGE(Integer mtype) {
		and(Field.mtype.name(), mtype, Restriction.GE, alias);
		return this;
	}
	public MnMemberDaoParams setmtypeGT(Integer mtype) {
		and(Field.mtype.name(), mtype, Restriction.GT, alias);
		return this;
	}
	public MnMemberDaoParams setmtypeIn(List<Object> mtype) {
		and(Field.mtype.name(), mtype, Restriction.IN, alias);
		return this;
	}
	public MnMemberDaoParams setmtypeNIn(List<Object> mtype) {
		and(Field.mtype.name(), mtype, Restriction.NIN, alias);
		return this;
	}
	public MnMemberDaoParams setmtypeNull() {
		and(Field.mtype.name(), null, Restriction.NULL, alias);
		return this;
	}
	public MnMemberDaoParams setmtypeNotNull() {
		and(Field.mtype.name(), null, Restriction.NOTNULL, alias);
		return this;
	}
	public MnMemberDaoParams setos(String os){
		and(Field.os.name(), os, alias);
		return this;
	}
	//@Column(name = "os")
	public String getos(){
		return (String) attrs.get(Field.os.name());
	}
	public MnMemberDaoParams setosLLike(String os) {
		and(Field.os.name(), os, Restriction.LLIKE, alias);
		return this;
	}
	public MnMemberDaoParams setosRLike(String os) {
		and(Field.os.name(), os, Restriction.RLIKE, alias);
		return this;
	}
	public MnMemberDaoParams setosLike(String os) {
		and(Field.os.name(), os, Restriction.LIKE, alias);
		return this;
	}
	public MnMemberDaoParams setosIn(List<Object> os) {
		and(Field.os.name(), os, Restriction.IN, alias);
		return this;
	}
	public MnMemberDaoParams setosNIn(List<Object> os) {
		and(Field.os.name(), os, Restriction.NIN, alias);
		return this;
	}
	public MnMemberDaoParams setosNull() {
		and(Field.os.name(), null, Restriction.NULL, alias);
		return this;
	}
	public MnMemberDaoParams setosNotNull() {
		and(Field.os.name(), null, Restriction.NOTNULL, alias);
		return this;
	}
	public MnMemberDaoParams setversion(String version){
		and(Field.version.name(), version, alias);
		return this;
	}
	//@Column(name = "version")
	public String getversion(){
		return (String) attrs.get(Field.version.name());
	}
	public MnMemberDaoParams setversionLLike(String version) {
		and(Field.version.name(), version, Restriction.LLIKE, alias);
		return this;
	}
	public MnMemberDaoParams setversionRLike(String version) {
		and(Field.version.name(), version, Restriction.RLIKE, alias);
		return this;
	}
	public MnMemberDaoParams setversionLike(String version) {
		and(Field.version.name(), version, Restriction.LIKE, alias);
		return this;
	}
	public MnMemberDaoParams setversionIn(List<Object> version) {
		and(Field.version.name(), version, Restriction.IN, alias);
		return this;
	}
	public MnMemberDaoParams setversionNIn(List<Object> version) {
		and(Field.version.name(), version, Restriction.NIN, alias);
		return this;
	}
	public MnMemberDaoParams setversionNull() {
		and(Field.version.name(), null, Restriction.NULL, alias);
		return this;
	}
	public MnMemberDaoParams setversionNotNull() {
		and(Field.version.name(), null, Restriction.NOTNULL, alias);
		return this;
	}
	public MnMemberDaoParams setlastLoginTime(Timestamp lastLoginTime){
		and(Field.lastLoginTime.name(), lastLoginTime, alias);
		return this;
	}
	//@Column(name = "last_login_time")
	public Timestamp getlastLoginTime(){
		return (Timestamp) attrs.get(Field.lastLoginTime.name());
	}
	public MnMemberDaoParams setlastLoginTimeBetween(Timestamp[] lastLoginTime) {
		and(Field.lastLoginTime.name(), lastLoginTime, Restriction.BETWEEN, alias);
		return this;
	}
	public MnMemberDaoParams setlastLoginTimeNE(Timestamp lastLoginTime) {
		and(Field.lastLoginTime.name(), lastLoginTime, Restriction.NE, alias);
		return this;
	}
	public MnMemberDaoParams setlastLoginTimeGE(Timestamp lastLoginTime) {
		and(Field.lastLoginTime.name(), lastLoginTime, Restriction.GE, alias);
		return this;
	}
	public MnMemberDaoParams setlastLoginTimeGT(Timestamp lastLoginTime) {
		and(Field.lastLoginTime.name(), lastLoginTime, Restriction.GT, alias);
		return this;
	}
	public MnMemberDaoParams setlastLoginTimeIn(List<Object> lastLoginTime) {
		and(Field.lastLoginTime.name(), lastLoginTime, Restriction.IN, alias);
		return this;
	}
	public MnMemberDaoParams setlastLoginTimeNIn(List<Object> lastLoginTime) {
		and(Field.lastLoginTime.name(), lastLoginTime, Restriction.NIN, alias);
		return this;
	}
	public MnMemberDaoParams setlastLoginTimeNull() {
		and(Field.lastLoginTime.name(), null, Restriction.NULL, alias);
		return this;
	}
	public MnMemberDaoParams setlastLoginTimeNotNull() {
		and(Field.lastLoginTime.name(), null, Restriction.NOTNULL, alias);
		return this;
	}
	public MnMemberDaoParams setip(String ip){
		and(Field.ip.name(), ip, alias);
		return this;
	}
	//@Column(name = "IP")
	public String getip(){
		return (String) attrs.get(Field.ip.name());
	}
	public MnMemberDaoParams setipLLike(String ip) {
		and(Field.ip.name(), ip, Restriction.LLIKE, alias);
		return this;
	}
	public MnMemberDaoParams setipRLike(String ip) {
		and(Field.ip.name(), ip, Restriction.RLIKE, alias);
		return this;
	}
	public MnMemberDaoParams setipLike(String ip) {
		and(Field.ip.name(), ip, Restriction.LIKE, alias);
		return this;
	}
	public MnMemberDaoParams setipIn(List<Object> ip) {
		and(Field.ip.name(), ip, Restriction.IN, alias);
		return this;
	}
	public MnMemberDaoParams setipNIn(List<Object> ip) {
		and(Field.ip.name(), ip, Restriction.NIN, alias);
		return this;
	}
	public MnMemberDaoParams setipNull() {
		and(Field.ip.name(), null, Restriction.NULL, alias);
		return this;
	}
	public MnMemberDaoParams setipNotNull() {
		and(Field.ip.name(), null, Restriction.NOTNULL, alias);
		return this;
	}
}
//接下来就是对应的简单测试，生成where语句

	public static void main(String[] args) {
		MemberDaoParams params1 = new MemberDaoParams();
		params1.setdeviceId("设备id").setversion("2.0").setuserIdNotNull().or(GoodsOwerDaoParams.Field.cityName.name(), "厦门", "mn_goods_ower");
		System.out.println("----------------这里是key,value形式-------------");
		//这里是key,value形式
		System.out.println(params1.builderAttrs().getSqlString());
		for(String p : params1.getAttrs().keySet())
		{
			System.out.println(String.format("p:%s_____value:%s", p, params1.getAttrs().get(p).toString()));
			
		}
		
		//没有对内部存储进行重置,这里需要手动重置。不然后面会导致前面key、value连接在一起(一般不会像我这样同时写两个形式的啦。。。这里是测试，不过接下来还是要修复的)
		params1.sql.setLength(0);
		System.out.println("----------------这里是?代替形式-------------");
		//这里是?代替形式
		System.out.println(params1.builderParas().getSqlString());
		int i = 0;
		for(Object p : params1.getParas())
		{
			System.out.println(String.format("第%s个？的值：%s", ++i, p.toString()));
			
		}
	}

	输出结果：
----------------这里是key,value形式-------------
mn_member.deviceId= :deviceId  or mn_goods_ower.cityName= :cityName  and mn_member.userId is not null  and mn_member.version= :version
p:cityName_____value:厦门
p:deviceId_____value:设备id	
p:version_____value:2.0  
----------------这里是?代替形式------------- 
mn_member.deviceId= ?  or mn_goods_ower.cityName= ?  and mn_member.userId is not null  and mn_member.version= ?
第1个？的值：设备id
第2个？的值：厦门
第3个？的值：2.0 






	
