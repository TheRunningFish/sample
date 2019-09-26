package ltd.pitupi.sample.tests;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@SuppressWarnings({"resource","deprecation"})
public class Test {
	public static InputStream inStream = null;

	public static void main(String[] args) {
		File file = new File("D:/dddddd.txt");
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String str;
			while ((str = in.readLine()) != null) {
				System.out.println(str);
				String enStr = URLEncoder.encode(str);
				// 要访问的图片链接
				URL url = new URL("http://sxpth-x-cn.img.abc188.com/"+enStr+".jpg");
				// 建立网络连接
				URLConnection con = url.openConnection();
				try{
					inStream = con.getInputStream();
					// 中转站，现将图片数据放到outStream中
					ByteArrayOutputStream outStream = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					int len = 0;
					while ((len = inStream.read(buf)) != -1) {
						outStream.write(buf, 0, len);
					}
					inStream.close();
					outStream.close();
					file = new File("D:/dddddd/"+str+".jpg"); // 图片下载的位置
					FileOutputStream op = new FileOutputStream(file);
					op.write(outStream.toByteArray());
					op.close();
				}catch(Exception e){
					System.out.println(str+"发生异常"+e.getMessage());
				}
			}
			System.out.println(str);
		} catch (IOException e) {
		}
	}
}
