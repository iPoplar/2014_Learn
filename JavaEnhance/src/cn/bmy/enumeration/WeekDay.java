package cn.bmy.enumeration;

/**
	一些方法在运行时，它需要的数据不能是任意的，而必须是一定范围内的值，
	此类问题在JDK5以前采用自定义带有枚举功能的类解决，Java5以后可以直接使用枚举予以解决。
	JDK 5新增的 enum 关键字用于定义一个枚举类。
==================================================================================
	枚举类具有如下特性：
	
	枚举类也是一种特殊形式的Java类。
	枚举类中声明的每一个枚举值代表枚举类的一个实例对象。
	与java中的普通类一样，在声明枚举类时，也可以声明属性、方法和构造函数，但枚举类的构造函数必须为私有的（这点不难理解）。
	枚举类也可以实现接口、或继承抽象类。
	JDK5中扩展了swith语句，它除了可以接收int, byte, char, short外，还可以接收一个枚举类型。
	若枚举类只有一个枚举值，则可以当作单态设计模式使用。	
==================================================================================	
	Java中声明的枚举类，均是java.lang.Enum类的孩子，它继承了Enum类的所有方法。常用方法：
		name()
		ordinal()
		valueof(Class enumClass, String name)
		values() 此方法虽然在JDK文档中查找不到，但每个枚举类都具有该方法，它遍历枚举类的所有枚举值非常方便。
 */

public enum WeekDay
{
	MON("星期一"),TUE("星期二"),WED("星期三"),THU("星期四"),FRI("星期五"),SAT("星期六"),SUN("星期日");
	
	private String value;
	private WeekDay(String value)
	{
		this.value = value;
	}
	public String getValue() 
	{
		return value;
	}
}
