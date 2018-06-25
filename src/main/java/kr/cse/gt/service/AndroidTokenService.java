package kr.cse.gt.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import kr.cse.gt.dao.AndroidTokenDao;
import kr.cse.gt.model.AndroidToken;
import kr.cse.gt.model.Sensor;

@Service
public class AndroidTokenService {

	@Autowired
	private AndroidTokenDao androidTokenDao;
	
	@Autowired
	private SensorService sensorService;
	
	
	
	public void saveAndFlush(AndroidToken androidToken) {
		androidTokenDao.saveAndFlush(androidToken);
		
	}
	
	public List<AndroidToken> findAll(){
		return androidTokenDao.findAll();
	}
	
	
	
	
	@Scheduled(cron = "0 0 0/1 1/1 * ?")
	public void testGcm() throws Exception {

		final String apiKey = "AAAAqUCoyvE:APA91bHmlrKM1M4MWkfxlKwQiBzKOvpfutmn8I5ybU-PqHeJ7eWjP8wauEt1FvIuoUhLv6ZoUcr0yTufi3KvHxY9FFHCn60_P-KTRlln_TfJJuhzf1QPj5-UlxsPWq5BYqLCWEjY1qKU";
		List<AndroidToken> tokens = this.findAll();

		URL url = new URL("https://fcm.googleapis.com/fcm/send");

		for (int i = 0; i < tokens.size(); i++) {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "key=" + apiKey);

			conn.setDoOutput(true);

			

			// 이렇게 보내면 주제를 ALL로 지정해놓은 모든 사람들한테 알림을 날려준다.
			// String input = "{\"notification\" : {\"title\" : \"여기다 제목 넣기 \", \"body\" :
			// \"여기다 내용 넣기\"}, \"to\":\"/topics/ALL\"}";

			// 이걸로 보내면 특정 토큰을 가지고있는 어플에만 알림을 날려준다 위에 둘중에 한개 골라서 날려주자
			
			Sensor sensor = sensorService.mostRecentlyData();
			
			
			String tem = sensorService.verifyTemperautre(sensor);
			String hum = sensorService.verifyHumidity(sensor);
			
			String input = "{\"notification\" : {\"title\" : \" 온도 : "+ sensor.getTemperature() +" / 습도 : "+ sensor.getHumidity() +" \", \"body\" : \"온도 위험도 : "+tem+" / 습도 위험도 : "+hum+" \"}, \"to\":\""
					+ tokens.get(i).getToken() + "\"}";
			
//			String input = "{\"notification\" : {\"title\" : \" abc \", \"body\" : \"bc \"}, \"to\":\""
//					+ tokens.get(i).getToken() + "\"}";

			OutputStream os = conn.getOutputStream();

			// 서버에서 날려서 한글 깨지는 사람은 아래처럼 UTF-8로 인코딩해서 날려주자
			os.write(input.getBytes("UTF-8"));
			os.flush();
			os.close();

			int responseCode = conn.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + input);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
		}
		

	}
}
