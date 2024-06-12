public class Utils {
	private Utils() {
	}

	public static boolean isEmpty(java.util.Collection col) {
		return (col == null) || col.isEmpty();
	}

	public static void addNotNull(java.util.Collection col, java.lang.Object obj) {
		if ((col == null) || (obj == null)) {
			return;
		}
		col.add(obj);
	}

	public static void copyProperties(java.lang.Object dest, java.lang.Object orig) {
		try {
			if ((orig != null) && (dest != null)) {
				org.apache.commons.beanutils.BeanUtils.copyProperties(dest, orig);
				org.apache.commons.beanutils.PropertyUtils putils = new org.apache.commons.beanutils.PropertyUtils();
				java.beans.PropertyDescriptor[] origDescriptors = putils.getPropertyDescriptors(orig);
				for (java.beans.PropertyDescriptor origDescriptor : origDescriptors) {
					java.lang.String name = origDescriptor.getName();
					if ("class".equals(name)) {
						continue;
					}
					java.lang.Class propertyType = origDescriptor.getPropertyType();
					if ((!java.lang.Boolean.class.equals(propertyType)) && (!java.lang.Boolean.class.equals(propertyType))) {
						continue;
					}
					if (!putils.isReadable(orig, name)) {
						java.lang.reflect.Method m = orig.getClass().getMethod(("is" + name.substring(0, 1).toUpperCase()) + name.substring(1), ((java.lang.Class<?>[]) (null)));
						java.lang.Object value = m.invoke(orig, ((java.lang.Object[]) (null)));
						if (putils.isWriteable(dest, name)) {
							org.apache.commons.beanutils.BeanUtilsBean.getInstance().copyProperty(dest, name, value);
						}
					}
				}
			}
		} catch (java.lang.Exception e) {
			throw new ar.com.fdvs.dj.core.DJException((("Could not copy properties for shared object: " + orig) + ", message: ") + e.getMessage(), e);
		}
	}

	public static void main(java.lang.String[] args) {
		net.sf.jasperreports.engine.design.JRDesignStyle s1 = new ar.com.fdvs.dj.domain.Style().transform();
		net.sf.jasperreports.engine.design.JRDesignStyle s2 = new ar.com.fdvs.dj.domain.Style().transform();
		s1.setBold(java.lang.Boolean.TRUE);
		s1.setItalic(java.lang.Boolean.TRUE);
		s1.setUnderline(java.lang.Boolean.TRUE);
		ar.com.fdvs.dj.util.Utils.copyProperties(s2, s1);
		java.lang.System.out.println((((s2.isBold() + " - ") + s2.isItalic()) + " - ") + s2.isUnderline());
	}

	public static java.lang.String escapeTextForExpression(java.lang.String text) {
		if (text == null) {
			return null;
		}
		text = text.replaceAll("\\\\", "\\\\\\\\");
		text = text.replaceAll("\"", "\\\\\"");
		return text;
	}

	public static net.sf.jasperreports.engine.design.JRDesignStyle cloneStyle(net.sf.jasperreports.engine.design.JRDesignStyle style) {
		return ((net.sf.jasperreports.engine.design.JRDesignStyle) (style.clone()));
	}

	public static boolean stringSet(java.lang.String string) {
		return (string != null) && (!"".equals(string));
	}

	public static boolean isEmpty(java.lang.String text) {
		return (text == null) || "".equals(text.trim());
	}
}