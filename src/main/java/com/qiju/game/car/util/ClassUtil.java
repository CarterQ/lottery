package com.qiju.game.car.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ClassUtil {

	/**
	 * 获取同一路径下所有子类或接口实现类
	 * 
	 * @param intf
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static List<Class<?>> getAllAssignedClass(Class<?> cls) throws IOException, ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (Class<?> c : getClasses(cls)) {
			if (cls.isAssignableFrom(c) && !cls.equals(c)) {
				classes.add(c);
			}
		}
		return classes;
	}

	/**
	 * 取得当前类路径下的所有类
	 * 
	 * @param cls
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static List<Class<?>> getClasses(Class<?> cls) throws IOException, ClassNotFoundException {
		String pk = cls.getPackage().getName();
		String path = pk.replace('.', '/');
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource(path);
		String filePath = getRootPath(url);
		//生产环境中是jar文件形式，加这个判断是为了开发环境中可以正常使用
		if (filePath.endsWith(".jar")) {
			JarInputStream jarIn = new JarInputStream(new FileInputStream(filePath));
			try {
				JarEntry entry = jarIn.getNextJarEntry();
				List<Class<?>> list = new ArrayList<Class<?>>();
				while (null != entry) {
					String name = entry.getName();
					if (name.startsWith(path) && name.endsWith(".class")) {
						String className = name.replace('/', '.');
						className = className.substring(0, name.length() - 6);
						list.add(classloader.loadClass(className));
					}
					entry = jarIn.getNextJarEntry();
				}
				return list;
			} finally {
				jarIn.close();
			}
		}
		//开发环境中会用下面的方式获取所有class
		return getClasses(new File(url.getFile()), pk);
	}

	/**
	 * 迭代查找类
	 * 
	 * @param dir
	 * @param pk
	 * @return
	 * @throws ClassNotFoundException
	 */
	private static List<Class<?>> getClasses(File dir, String pk) throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (!dir.exists()) {
			return classes;
		}
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				classes.addAll(getClasses(f, pk + "." + f.getName()));
			}
			String name = f.getName();
			if (name.endsWith(".class")) {
				classes.add(Class.forName(pk + "." + name.substring(0, name.length() - 6)));
			}
		}
		return classes;
	}

	private static String getRootPath(URL url) {
		String fileUrl = url.getFile();
		int pos = fileUrl.indexOf('!');

		if (-1 == pos) {
			return fileUrl;
		}

		return fileUrl.substring(5, pos);
	}

	public static void main(String[] args) throws Exception {
		
	}

}
