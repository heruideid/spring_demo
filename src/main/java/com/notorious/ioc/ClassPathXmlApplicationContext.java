package com.notorious.ioc;

import com.notorious.ioc.ApplicationContext;
import com.sun.javaws.IconUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private Map<String,Object> ioc=new HashMap<String,Object>();

    public ClassPathXmlApplicationContext(String path){
        try {
            SAXReader reader=new SAXReader();
            Document document=reader.read(path);
            //System.out.println(document);
            Element root=document.getRootElement();
            //System.out.println(root);
            Iterator<Element> iterator=root.elementIterator();
            while(iterator.hasNext()){
                Element element=iterator.next();
                String id=element.attributeValue("id");
                String className=element.attributeValue("class");
                //System.out.println(id);
                //System.out.println(className);
                //通过反射机制获取对象
                try {
                    Class clazz=Class.forName(className);
                    Constructor constructor=clazz.getConstructor();
                    Object obj=constructor.newInstance();
                    //给目标对象成员变量赋值
                    Iterator<Element> beanIteror=element.elementIterator();
                    while(beanIteror.hasNext()){
                        Element property=beanIteror.next();
                        String name=property.attributeValue("name");
                        String valueStr=property.attributeValue("value");
                        String ref=property.attributeValue("ref");
                        if(ref==null){
                            String methodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
                            Field field=clazz.getDeclaredField(name);
                            Method method=clazz.getDeclaredMethod(methodName,field.getType());
                            //根据成员变量数据类型，将value进行转换
                            Object value=null;
                            if(field.getType().getName()=="long"){
                                value=Long.parseLong(valueStr);
                            }
                            else if(field.getType().getName()=="java.lang.String"){
                                value=valueStr;
                            }
                            else if(field.getType().getName()=="int"){
                                value=Integer.parseInt(valueStr);
                            }
                            method.invoke(obj,value);
                        }
                        else{
                            Object refObj=ioc.get(ref);
                            String methodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
                            Field field=clazz.getDeclaredField(name);
                            Method method=clazz.getDeclaredMethod(methodName,field.getType());
                            method.invoke(obj,refObj);
                        }
                    }
                    ioc.put(id,obj);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }catch(NoSuchMethodException e){
                    e.printStackTrace();
                }catch(InstantiationException e){
                    e.printStackTrace();
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String id) {
        return ioc.get(id);
    }
}
