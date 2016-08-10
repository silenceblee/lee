package org.generator;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;

/**
 * 自定义注释生成
 * @author master
 *
 */
public class MyCommentGenerator implements CommentGenerator{

    private Properties properties;
    private boolean suppressDate;
    private boolean suppressAllComments;

    public MyCommentGenerator() {
        super();
        properties = new Properties();
        suppressDate = false;
        suppressAllComments = false;
    }

    public void addJavaFileComment(CompilationUnit compilationUnit) {
        // add no file level comments by default
        return;
    }

    /**
     * 给mapper.xml添加注释
     */
    public void addComment(XmlElement xmlElement) {
        if (suppressAllComments) {
            return;
        }

        xmlElement.addElement(new TextElement("<!--")); //$NON-NLS-1$

        StringBuilder sb = new StringBuilder();
        sb.append("  WARNING - "); //$NON-NLS-1$
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        xmlElement.addElement(new TextElement(sb.toString()));
        xmlElement
                .addElement(new TextElement(
                        "  This element is automatically generated by MyBatis Generator, do not modify.")); //$NON-NLS-1$

        String s = getDateString();
        if (s != null) {
            sb.setLength(0);
            sb.append("  This element was generated on "); //$NON-NLS-1$
            sb.append(s);
            sb.append('.');
            xmlElement.addElement(new TextElement(sb.toString()));
        }

        xmlElement.addElement(new TextElement("-->")); //$NON-NLS-1$
    }

    public void addRootComment(XmlElement rootElement) {
        // add no document level comments by default
        return;
    }

    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        suppressDate = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
        
        suppressAllComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
    }

    /**
     * This method adds the custom javadoc tag for. You may do nothing if you do
     * not wish to include the Javadoc tag - however, if you do not include the
     * Javadoc tag then the Java merge capability of the eclipse plugin will
     * break.
     * 
     * @param javaElement
     *            the java element
     */
    protected void addJavadocTag(JavaElement javaElement,
            boolean markAsDoNotDelete) {
        javaElement.addJavaDocLine(" *"); //$NON-NLS-1$
        StringBuilder sb = new StringBuilder();
        sb.append(" * "); //$NON-NLS-1$
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        if (markAsDoNotDelete) {
            sb.append(" do_not_delete_during_merge"); //$NON-NLS-1$
        }
        String s = getDateString();
        if (s != null) {
            sb.append(' ');
            sb.append(s);
        }
        javaElement.addJavaDocLine(sb.toString());
    }

    /**
     * This method returns a formated date string to include in the Javadoc tag
     * and XML comments. You may return null if you do not want the date in
     * these documentation elements.
     * 
     * @return a string representing the current timestamp, or null
     */
    protected String getDateString() {
        if (suppressDate) {
            return null;
        } else {
        	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sf.format(new Date());
        }
    }

    public void addClassComment(InnerClass innerClass,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        
        StringBuilder sb = new StringBuilder();

        innerClass.addJavaDocLine("/**"); //$NON-NLS-1$
        innerClass.addJavaDocLine(" * generated by MyBatis Generator.<br>");
        sb.append(" * tableName: ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        try {
			innerClass.addJavaDocLine(new String(sb.toString().getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        addJavadocTag(innerClass, false);

        innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    public void addEnumComment(InnerEnum innerEnum,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerEnum.addJavaDocLine("/**"); //$NON-NLS-1$
        innerEnum
                .addJavaDocLine(" * This enum was generated by MyBatis Generator."); //$NON-NLS-1$

        sb.append(" * This enum corresponds to the database table "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerEnum.addJavaDocLine(sb.toString());

        addJavadocTag(innerEnum, false);

        innerEnum.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /**
     * 给字段添加注释
     */
    public void addFieldComment(Field field,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        
        if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
            field.addJavaDocLine("/**");
            try {
				field.addJavaDocLine(" * " + new String(introspectedColumn.getRemarks().getBytes("utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            addJavadocTag(field, false);
            field.addJavaDocLine(" */");
        }
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        field.addJavaDocLine("/**"); //$NON-NLS-1$
        field
                .addJavaDocLine(" * This field was generated by MyBatis Generator."); //$NON-NLS-1$

        sb.append(" * This field corresponds to the database table "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        field.addJavaDocLine(sb.toString());

        addJavadocTag(field, false);

        field.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    public void addGeneralMethodComment(Method method,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
          StringBuilder sb = new StringBuilder(" * ");
          method.addJavaDocLine("/**"); 
          String methodName = method.getName();
          if(methodName == "countByExample"){
        	  sb.append("通过Example条件查询数量 ");
          }else if(methodName == "deleteByExample"){
        	  sb.append("通过Example条件删除数据 ");
          }else if(methodName == "deleteByPrimaryKey"){
        	  sb.append("通过主键删除数据 ");
          }else if(methodName == "insert"){
        	  sb.append("插入数据 ");
          }else if(methodName == "insertSelective"){
        	  sb.append("选择性插入数据 ");
          }else if(methodName == "selectByExample"){
        	  sb.append("通过Examply条件查询数据集合 ");
          }else if(methodName == "selectByPrimaryKey"){
        	  sb.append("通过主键查询数据 ");
          }else if(methodName == "updateByExampleSelective"){
        	  sb.append("通过Example条件选择新更新数据 ");
          }else if(methodName == "updateByExample"){
        	  sb.append("通过Example更新数据 ");
          }else if(methodName == "updateByPrimaryKeySelective"){
        	  sb.append("通过主键选择性更新数据 ");
          }else if(methodName == "updateByPrimaryKey"){
        	  sb.append("通过主键更新数据 ");
          }
//          List<Parameter> parms = method.getParameters();
//          if(parms != null && parms.size() > 0){
//        	  for(Parameter parm : parms ){
//        		  sb.append("  @param ");
//        		  sb.append(parm.getName());
//        		  sb.append("<br>\n");
//        	  }
//          }
          try {
			method.addJavaDocLine(new String(sb.toString().getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          addJavadocTag(method, false);
          method.addJavaDocLine(" */");
//         
    }

    /**
     * get方法添加注释
     */
    public void addGetterComment(Method method,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        if(introspectedColumn.getRemarks() != null && !"".equals(introspectedColumn.getRemarks())){
        	method.addJavaDocLine("/**"); 
        	try {
				method.addJavaDocLine(" * " + new String(introspectedColumn.getRemarks().getBytes("utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	addJavadocTag(method, false);
        	method.addJavaDocLine(" */");
        }
    }

    /**
     * set方法添加注释
     */
    public void addSetterComment(Method method,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

         if(introspectedColumn.getRemarks() != null && !"".equals(introspectedColumn.getRemarks())){
        	 method.addJavaDocLine("/**");
        	 try {
				method.addJavaDocLine(" * "+ new String(introspectedColumn.getRemarks().getBytes("utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 method.addJavaDocLine(" *");
        	 Parameter parm = method.getParameters().get(0);
        	 method.addJavaDocLine(" * @param " + parm.getName() + " "+ parm.getType());
        	 addJavadocTag(method, false);
        	 method.addJavaDocLine(" */");
        	 
         }
         
    }

    public void addClassComment(InnerClass innerClass,
            IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        innerClass.addJavaDocLine("/**"); //$NON-NLS-1$
        innerClass.addJavaDocLine(" * generated by MyBatis Generator.<br>");
        try {
			innerClass.addJavaDocLine(new String(sb.toString().getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        addJavadocTag(innerClass, markAsDoNotDelete);

        innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
        
    }
}