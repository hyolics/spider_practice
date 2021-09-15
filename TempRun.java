import java.io.*;
import java.net.*;

public class TempRun {

	public void runTemp() throws IOException {
		String wedAddr = "https://tw.news.yahoo.com/weather/台灣/高雄市/高雄市-2306180";

		URL url = new URL(wedAddr);
		URLConnection conn = url.openConnection();
		conn.connect();

		// String urlType = conn.getContentType();
		// System.out.println("[Context] : " + urlType);
		// System.out.println();

		InputStreamReader in = new InputStreamReader(conn.getInputStream(), "UTF-8");
		BufferedReader br = new BufferedReader(in);

		String strFile = "C://Temp.txt";
		FileWriter fw = new FileWriter(strFile);

		String urlData = "";
		String line;
		while ((line = br.readLine()) != null) {

			urlData += line;
			// int counter = 1;
			// System.out.println(counter + " : " + line);
			// counter++;
			// fw.write(line);
			// fw.flush();
		} // end of while

		fw.write(urlData);

		br.close();
		fw.close();

		// key : <span class="Va(t)" data-reactid="37">14</span>
		// length : 38
		String strKey = "<span class=\"Va(t)\" data-reactid=\"37\">";
		// System.out.println(str);

		String tmp = "";
		int start = 0;
		int end = 0;

		// 找到關鍵字之後把索引往後移動一格
		start = urlData.indexOf(strKey, end + 1);
		end = urlData.indexOf("</span>", start + 1);

		// System.out.println("start : " + start);
		// System.out.println("end : " + end);

		tmp = urlData.substring(start + 38, end);

		System.out.println("目前氣溫 : " + tmp + " °C");

	}

	public void runAQI() throws IOException {

		String wedAddr = "http://opendata.epa.gov.tw/webapi/api/rest/datastore/355000000I-001805?sort=SiteName&offset=0&limit=1000";

		URL url = new URL(wedAddr);
		URLConnection conn = url.openConnection();
		conn.connect();

		InputStreamReader in = new InputStreamReader(conn.getInputStream(), "UTF-8");
		BufferedReader br = new BufferedReader(in);

		String strFile = "C://AQI.txt";
		FileWriter fw = new FileWriter(strFile);

		String urlData = "";
		String line;
		while ((line = br.readLine()) != null) {
			urlData += line;
		} // end of while

		fw.write(urlData);

		br.close();
		fw.close();

		String strKey = "前金";

		String tmp = "";
		int start = 0;
		int end = 0;

		start = urlData.indexOf(strKey, end + 1);
		end = urlData.indexOf(",\"SO2", start + 1);

		// System.out.println("start : " + start);
		// System.out.println("end : " + end);

		tmp = urlData.substring(start + 4, end);
		tmp = tmp.replaceAll(",", "\n");

		System.out.println("空氣品質 : \n\n" + tmp);

	}

}// END
