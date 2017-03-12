package com.ai.portalhome.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ai.paas.utils.StringUtil;
import com.ai.woego.front.exception.GenericException;
import com.ai.woego.front.util.debug.Debug;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * Title: MVNO-CRM <br>
 * Description: 提供Bean处理的工具类<br>
 * Date: 2014年2月22日 <br>
 * Copyright (c) 2014 AILK <br>
 *
 * @author zhangchao
 */
public class BeanUtil {
	public static final String module = BeanUtil.class.getName();

//	/**
//	 * 将BO数据以字段属性为KEY拷贝到MAP<br>
//	 * 注意:key为要符合java属性命名.如 CHNL_ID的JAVA属性命名为chnlId<br>
//	 * 
//	 * @param orignBo
//	 * @return
//	 * @author zhangchao
//	 */
//	public static JSONObject copyBo2JSONObject(DataStructInterface orignBo) {
//		JSONObject jsonObject = new JSONObject();
//		if (orignBo == null)
//			return jsonObject;
//		String[] filedNames = orignBo.getPropertyNames();
//		if (filedNames != null && filedNames.length > 0) {
//			for (String fieldName : filedNames) {
//				Object orignValue = getFieldValue(orignBo, fieldName);
//				if (orignValue == null) {
//					continue;
//				}
//				String voVarName = getVarName(fieldName);
//				jsonObject.put(voVarName, orignValue);
//			}
//		}
//		return jsonObject;
//	}

//	/**
//	 * 通过JSON序列化方法，将 BO 的内容，深度复制到 对应的类中；
//	 * 
//	 * @param orignBo
//	 *            源BO
//	 * @param clazz
//	 *            目标类；
//	 * @return
//	 * @author yugn
//	 */
//	public static <T> T copyBo2VoDeep(DataStructInterface orignBo,
//			Class<T> clazz) {
//
//		JSONObject object = BeanUtil.copyBo2JSONObject(orignBo);
//
//		return JSONObject.parseObject(object.toJSONString(), clazz);
//
//	}

//	/**
//	 * 从Bean对象单层拷贝数据到VO<br>
//	 * 属性名与类型必须一致<br>
//	 *
//	 * @param destVo
//	 * @param orignBo
//	 * @author choaryzhang
//	 */
//	public static void copyBo2Vo(Object destVo, DataStructInterface orignBo) {
//		/* 1.源对象与目标对象都不能为空 */
//		if (destVo == null || orignBo == null) {
//			throw new GenericException("copyBo2Vo出错:源对象为空或目标对象为空");
//		}
//		/* 2. 获取BO的所有属性 */
//		String[] filedNames = orignBo.getPropertyNames();
//		if (filedNames != null && filedNames.length > 0) {
//			for (int i = 0; i < filedNames.length; i++) {
//				String fieldName = filedNames[i];
//				/* 2.1 获取字段对应的值 */
//				Object orignValue = getFieldValue(orignBo, fieldName);
//				/* 2.2 如果源属性值为空，并且是主属性，则不拷贝值 */
//				if (orignValue == null) {
//					continue;
//				}
//				/* 2.3 根据Bo的FileName(表字段如 CHNL_ID) 转换成VO属性格式 */
//				String voVarName = getVarName(fieldName);
//				/* 2.4 判断VO是否有该属性 */
//				boolean hasProperty = hasProperty(destVo, voVarName);
//				/* 2.5 如果不存在，不进行复制 */
//				if (!hasProperty)
//					continue;
//				/* 2.6 复制信息 */
//				setVoFieldValue(destVo, voVarName, orignValue);
//			}
//		}
//	}

//	/**
//	 * 将vo的值赋值给bo
//	 *
//	 * @param destBo
//	 * @param orignVo
//	 * @author lining5
//	 */
//	public static void copyVo2Bo(DataStructInterface destBo, Object orignVo) {
//		/* 1.源对象与目标对象都不能为空 */
//		if (destBo == null || orignVo == null) {
//			throw new GenericException("copyVo2Bo出错:源对象为空或目标对象为空");
//		}
//		/* 2. 获取vo的所有属性 */
//		Class<?> classType = orignVo.getClass();
//		Field[] fields = classType.getDeclaredFields();
//		if (fields != null && fields.length > 0) {
//			for (int i = 0; i < fields.length; i++) {
//				String fieldName = fields[i].getName();
//				if ("serialVersionUID".equals(fieldName)) {
//					continue;
//				}
//				Object orignValue = getFieldValue(orignVo, fieldName);
//				String setMethod = "set" + toFirstWordUpperCase(fieldName);
//				boolean hasProperty = hasMethod(destBo, setMethod);
//				if (!hasProperty)
//					continue;
//				setVoFieldValue(destBo, fieldName, orignValue);
//			}
//		}
//	}

//	public static void copyVo2BoExceptNullVal(DataStructInterface destBo,
//			Object orignVo) {
//		/* 1.源对象与目标对象都不能为空 */
//		if (destBo == null || orignVo == null) {
//			throw new GenericException("copyVo2Bo出错:源对象为空或目标对象为空");
//		}
//		/* 2. 获取vo的所有属性 */
//		Class<?> classType = orignVo.getClass();
//		Field[] fields = classType.getDeclaredFields();
//		if (fields != null && fields.length > 0) {
//			for (int i = 0; i < fields.length; i++) {
//				String fieldName = fields[i].getName();
//				if ("serialVersionUID".equals(fieldName)) {
//					continue;
//				}
//				Object orignValue = getFieldValue(orignVo, fieldName);
//				if (orignValue != null) {
//					String setMethod = "set" + toFirstWordUpperCase(fieldName);
//					boolean hasProperty = hasMethod(destBo, setMethod);
//					if (!hasProperty)
//						continue;
//					setVoFieldValue(destBo, fieldName, orignValue);
//				}
//			}
//		}
//	}

//	/**
//	 * 将源BEAN中的属性值拷贝到目标BEAN上
//	 *
//	 * @param dest
//	 * @param orign
//	 * @author zhangchao
//	 */
//	public static void copy(DataStructInterface dest, DataStructInterface orign) {
//		/* 1.源对象与目标对象都不能为空 */
//		if (orign == null || dest == null) {
//			throw new GenericException("拷贝BEAN属性值出错:源对象为空或目标对象为空或指定字段为空");
//		}
//		/* 2.获取主键属性与所有字段信息 */
//		String[] filedNames = orign.getPropertyNames();
//		if (filedNames != null && filedNames.length > 0) {
//			for (int i = 0; i < filedNames.length; i++) {
//				String fieldName = filedNames[i];
//				/* 2.1 获取字段对应的值 */
//				Object orignValue = getFieldValue(orign, fieldName);
//				/* 2.2 如果源属性值为空，并且是主属性，则不拷贝值 */
//				if (orignValue == null
//						&& dest.getKeyProperties().containsKey(fieldName)) {
//					continue;
//				}
//				/* 2.3 如果目标对象有指定的字段，则进行拷贝值 */
//				if (hasProperty(dest, fieldName)) {
//					setFieldValue(dest, fieldName, orignValue);
//				}
//			}
//		}
//	}

	/**
	 * 拷贝VO对象属性，只拷贝基础属性
	 *
	 * @param dest
	 * @param orign
	 * @author zhangchao
	 */
	public static void copyVO(Object destSVO, Object orignSVO) {
		/* 1.源对象与目标对象都不能为空 */
		if (destSVO == null || orignSVO == null) {
			throw new GenericException("拷贝VO属性值出错:源对象为空或目标对象为空");
		}
		/* 2.获取目标对象所有字段 */
		Field[] fields = destSVO.getClass().getDeclaredFields();
		if (fields == null || fields.length == 0)
			return;
		/* 3.依次拷贝每个字段取值 */
		for (Field field : fields) {
			String fieldName = field.getName();
			String fieldType = field.getType().getName();
			if (!"serialVersionUID".equals(fieldName)) {
				try {
					boolean has = hasProperty(orignSVO, fieldName);
					if (has) {
						Field orignfield = orignSVO.getClass()
								.getDeclaredField(fieldName);
						String orignFieldType = orignfield.getType().getName();
						if (orignFieldType.equals(fieldType)) {
							Object orignValue = getVoFieldValue(orignSVO,
									fieldName);
							setVoFieldValue(destSVO, fieldName, orignValue);
						}
					}
				} catch (SecurityException e) {
					throw new GenericException("拷贝VO属性值出错:SecurityException", e);
				} catch (NoSuchFieldException e) {
					throw new GenericException(
							"拷贝VO属性值出错:NoSuchFieldException", e);
				} catch (IllegalArgumentException e) {
					throw new GenericException(
							"拷贝VO属性值出错:IllegalArgumentException", e);
				}

			}
		}
	}

	/**
	 * 获取VO指定属性值
	 *
	 * @param object
	 * @param fieldName
	 * @return
	 * @author zhangchao
	 */
	private static Object getVoFieldValue(Object object, String fieldName) {
		try {
			if (object == null || StringUtil.isBlank(fieldName)) {
				throw new GenericException("底层获取对象指定属性值出错,、对象为空或者指定字段为空");
			}
			String getmethodstr = "get" + setUpperCaseForFirstLetter(fieldName);
			Method getmethod = object.getClass().getMethod(getmethodstr);
			Object obj = getmethod.invoke(object);
			return obj;
		} catch (Exception ex) {
			String retMsg = ex.getCause() == null ? ex.getMessage() : ex
					.getCause().getMessage();
			throw new GenericException("系统错误[BeanCopyUtil.getVoFieldValue]:"
					+ retMsg, ex);
		}
	}

	/**
	 * 设定VO指定属性值
	 *
	 * @param object
	 * @param fieldName
	 * @param fieldValue
	 * @author zhangchao
	 */
	@SuppressWarnings("rawtypes")
	public static void setVoFieldValue(Object object, String fieldName,
			Object fieldValue) {
		try {
			if (fieldValue == null)
				return;
			if (object == null || StringUtil.isBlank(fieldName)) {
				throw new GenericException("设置对象指定属性值出错,对象为空或者指定字段为空");
			}
			String setmethodstr = "set" + setUpperCaseForFirstLetter(fieldName);
			String getmethodstr = "get" + setUpperCaseForFirstLetter(fieldName);
			Method getmethod = object.getClass().getMethod(getmethodstr);
			Method setmethod = object.getClass().getMethod(setmethodstr,
					getmethod.getReturnType());
			//setmethod.invoke(object, fieldValue);
			///考虑到 vo 到 bo 可能出现的类型不匹配的问题，例如：int -->String 之类的，所以采用 setValue 的方法；
			setValue(object,getmethod.getReturnType().getName(),setmethod,fieldValue);

		} catch (Exception ex) {
			String retMsg = ex.getCause() == null ? ex.getMessage()
					+ ",fieldName=" + fieldName : ex.getCause().getMessage()
					+ ",fieldName=" + fieldName;
			Debug.logError(ex, retMsg, module);
			throw new GenericException("系统错误[BeanCopyUtil.setVoFieldValue("
					+ fieldName + ")]:" + retMsg, ex);
		}
	}

	private static String setUpperCaseForFirstLetter(String name) {
		if (name.length() == 1) {
			return name.toUpperCase();
		}
		String firstLetter = name.substring(0, 1);
		String others = name.substring(1, name.length());
		return firstLetter.toUpperCase() + others;
	}

	/**
	 * 对象是否存在指定属性
	 *
	 * @param object
	 * @param fieldName
	 * @return
	 * @author zhangchao
	 */
	private static boolean hasProperty(Object object, String fieldName) {
		Field[] fields = object.getClass().getDeclaredFields();
		if (fields == null || fields.length == 0)
			return false;
		for (Field field : fields) {
			String fieldN = field.getName();
			if (fieldN.equals(fieldName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取指定bean中指定字段的值
	 *
	 * @param bean
	 *            :指定的bean对象,如InterCallLogBean bean
	 * @param fieldName
	 *            :指定的bean中的字段，全部大写，获取方式如:InterCallLogBean.S_InterName获取
	 * @return 对应字段在bean对象中的取值
	 * @author zhangchao
	 */
//	public static Object getFieldValue(DataStructInterface bean,
//			String fieldName) {
//		if (bean == null || StringUtil.isBlank(fieldName)) {
//			throw new GenericException("底层获取bean指定字段值出错,bean对象为空或者指定字段为空");
//		}
//		try {
//			fieldName = fieldName.toLowerCase();
//			char[] objchars = fieldName.toCharArray();
//			for (int j = 0; j < objchars.length; j++) {
//				if (objchars[j] == '_' && j != objchars.length - 1) {
//					objchars[j + 1] = Character.toUpperCase(objchars[j + 1]);
//				}
//				if (j == 0) {
//					objchars[j] = Character.toUpperCase(objchars[j]);
//				}
//			}
//			String str = String.valueOf(objchars);
//			str = str.replaceAll("_", "");
//			String getmethodstr = "get" + str;
//			Method getmethod = bean.getClass().getMethod(getmethodstr);
//			Object obj = getmethod.invoke(bean);
//			return obj;
//		} catch (Exception ex) {
//			String retMsg = ex.getCause() == null ? ex.getMessage() : ex
//					.getCause().getMessage();
//			throw new GenericException("系统错误[getFieldValue][类:"
//					+ bean.getClass().getName() + ";属性:" + fieldName + "]:"
//					+ retMsg, ex);
//		}
//	}

	/**
	 * 根据BO字段名（如CHNL_ID）得到VO属性名（如chnlId）
	 *
	 * @param bofieldName
	 * @return
	 * @author choaryzhang
	 */
	public static String getVarName(String bofieldName) {
		bofieldName = bofieldName.toLowerCase();
		char[] objchars = bofieldName.toCharArray();
		for (int j = 0; j < objchars.length; j++) {
			if (objchars[j] == '_' && j != objchars.length - 1) {
				objchars[j + 1] = Character.toUpperCase(objchars[j + 1]);
			}
			if (j == 0) {
				objchars[j] = Character.toLowerCase(objchars[j]);
			}
		}
		String str = String.valueOf(objchars);
		str = str.replaceAll("_", "");
		return str;
	}

	/**
	 * 设置指定的bean的指定字段的值
	 *
	 * @param bean
	 * @param fieldName
	 * @param fieldValue
	 * @author zhangchao
	 */
	@SuppressWarnings("rawtypes")
//	public static void setFieldValue(DataStructInterface bean,
//			String fieldName, Object fieldValue) {
//		if (bean == null || StringUtil.isBlank(fieldName)) {
//			throw new GenericException("设置bean指定字段值出错,bean对象为空或者指定字段为空");
//		}
//		try {
//			fieldName = fieldName.toLowerCase();
//			char[] objchars = fieldName.toCharArray();
//			for (int j = 0; j < objchars.length; j++) {
//				if (objchars[j] == '_' && j != objchars.length - 1) {
//					objchars[j + 1] = Character.toUpperCase(objchars[j + 1]);
//				}
//				if (j == 0) {
//					objchars[j] = Character.toUpperCase(objchars[j]);
//				}
//			}
//			String str = String.valueOf(objchars);
//			str = str.replaceAll("_", "");
//			String setmethodstr = "set" + str;
//			String getmethodstr = "get" + str;
//			Method getmethod = bean.getClass().getMethod(getmethodstr);
//			Method setmethod = bean.getClass().getMethod(setmethodstr,
//					getmethod.getReturnType());
//			//setmethod.invoke(bean, fieldValue);
//			///考虑到 vo 到 bo 可能出现的类型不匹配的问题，例如：int -->String 之类的，所以采用 setValue 的方法；
//			setValue(bean,getmethod.getReturnType().getName(),setmethod,fieldValue);
//			
//		} catch (Exception ex) {
//			String retMsg = ex.getCause() == null ? ex.getMessage() : ex
//					.getCause().getMessage();
//			throw new GenericException("系统错误[setFieldValue][类:"
//					+ bean.getClass().getName() + ";属性:" + fieldName + "]:"
//					+ retMsg, ex);
//		}
//	}

	/**
	 * 判断对象的BEAN中是否包含对应字段
	 *
	 * @param bean
	 * @param fieldName
	 * @return
	 * @author zhangchao
	 */
//	public static boolean hasProperty(DataStructInterface bean, String fieldName) {
//		/* 1.如果bean对象为空，则报错 */
//		if (bean == null)
//			throw new GenericException("系统错误[hasProperty]:传入的bean对象为null");
//		if (StringUtil.isBlank(fieldName))
//			throw new GenericException("系统错误[hasProperty]:没有传入字段名称");
//		/* 2.获取所有字段属性 */
//		String[] fields = bean.getPropertyNames();
//		if (fields != null && fields.length > 0) {
//			for (String filed : fields) {
//				if (filed.equals(fieldName)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}

	public static Object getFieldValue(Object orignVo, String fieldName) {
		if (orignVo == null || StringUtil.isBlank(fieldName)) {
			throw new GenericException("底层获取vo指定字段值出错,vo对象为空或者指定字段为空");
		}
		try {
			String getMethodName = "get" + toFirstWordUpperCase(fieldName);
			Method getmethod = orignVo.getClass().getDeclaredMethod(
					getMethodName, new Class[] {});
			Object obj = getmethod.invoke(orignVo);
			return obj;
		} catch (Exception ex) {
			throw new GenericException("获取属性值报错", ex);
		}
	}

	public static String toFirstWordUpperCase(String key) {
		if ("".equals(key.trim())) {
			key = "";
		} else if (key.length() == 1) {
			key = key.toUpperCase();
		} else {
			key = key.substring(0, 1).toUpperCase()
					+ key.substring(1, key.length());
		}
		return key;
	}

	/**
	 * 判断类中是否含有指定的方法
	 *
	 * @param destBo
	 * @param setMethod
	 * @return
	 * @author lining5
	 */
	private static boolean hasMethod(Object obj, String methodName) {
		if (!StringUtil.isBlank(methodName)) {
			Method[] methods = obj.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if (methodName.equals(method.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 深度拷贝
	 *
	 * @param destSVO
	 * @param orignSVO
	 * @author choaryzhang
	 */
	public static void copyProperties(Object destSVO, Object orignSVO) {
		/* 1.源对象与目标对象都不能为空 */
		if (destSVO == null || orignSVO == null) {
			throw new GenericException("拷贝VO属性值出错:源对象为空或目标对象为空");
		}
		/* 2.深度拷贝 */
		try {
			PropertyUtils.copyProperties(destSVO, orignSVO);
		} catch (IllegalAccessException e) {
			throw new GenericException(e);
		} catch (GenericException e) {
			throw new GenericException(e);
		} catch (NoSuchMethodException e) {
			throw new GenericException(e);
		} catch (InvocationTargetException e) {
			throw new GenericException(e);
		}
	}
	
	/**
	 * 将fieldValue 值，设置到 对象object；
	 * @param object  待赋值的对象；
	 * @param fieldClazzName  赋值的方法的入参的参数类型；
	 * @param setmethod  对象的 set方法；
	 * @param fieldValue 赋值；
	 * @throws Exception
	 * @author yugn
	 */
	public static void setValue(Object object, String fieldClazzName, Method setmethod, Object fieldValue) throws Exception{
		
		//如果值是 null 的时候，直接调用；
		if(fieldValue == null){
			setmethod.invoke(object,fieldValue);
			return;
		}

		switch (fieldClazzName) {
		case "short":
			setmethod.invoke(object,
					Short.parseShort(fieldValue.toString()));
			break;
		case "java.lang.Short":
			setmethod.invoke(object, Short.valueOf(fieldValue.toString()));
			break;
		case "int":
			setmethod.invoke(object,
					Integer.parseInt(fieldValue.toString()));
			break;
		case "java.lang.Integer":
			setmethod
					.invoke(object, Integer.valueOf(fieldValue.toString()));
			break;
		case "long":
			setmethod.invoke(object, Long.parseLong(fieldValue.toString()));
			break;
		case "java.lang.Long":
			setmethod.invoke(object, Long.valueOf(fieldValue.toString()));
			break;
		case "double":
			setmethod.invoke(object,
					Double.parseDouble(fieldValue.toString()));
			break;
		case "java.lang.Double":
			setmethod.invoke(object, Double.valueOf(fieldValue.toString()));
			break;
		case "float":
			setmethod.invoke(object,
					Float.parseFloat(fieldValue.toString()));
			break;
		case "java.lang.Float":
			setmethod.invoke(object, Float.valueOf(fieldValue.toString()));
			break;
		case "java.lang.String":
			setmethod.invoke(object, fieldValue+"");
			break;
		default:
			setmethod.invoke(object, fieldValue);
		}

	}


}
