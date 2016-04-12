package com.hotbitmapgg.ohmybilibili.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ProtocolException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection.Response;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class HttpUtil
{
	public static String cookieName = "";
	public static String cookieValue = "";
	public static String hostBase = "";

	public static String getHtmlString(String urlString)
	{
		try
		{
			URL url = new URL(urlString);
			URLConnection ucon = url.openConnection();
			InputStream instr = ucon.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(instr);
			ByteArrayBuffer baf = new ByteArrayBuffer(500);
			int current = 0;
			while ((current = bis.read()) != -1)
			{
				baf.append((byte) current);
			}
			return EncodingUtils.getString(baf.toByteArray(), "utf-8");
		} catch (Exception e)
		{

			Log.d("win", "lllll" + e.toString());
			return "";
		}
	}

	public static String getXmlDecompress(String urlString)
	{
		Response rsp = null;
		String temp = "";
		try
		{
			rsp = (Response) Jsoup.connect(urlString).execute();
			temp = EncodingUtils.getString(CompressionTools.decompressXML(rsp.bodyAsBytes()), "utf-8");
			Log.d("TAG", "=======>Xml解压成功");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.d("TAG", "=======>Xml解压失败：" + e.toString());
		} catch (DataFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.d("TAG", "=======>Xml解压失败：" + e.toString());
		}
		return temp;
	}

	public static String sendPost(String url, String params)
	{
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try
		{
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(params); // ②
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null)
			{
				result += "\n" + line;
			}
		} catch (Exception e)
		{
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally
		{
			try
			{
				if (out != null)
				{
					out.close();
				}
				if (in != null)
				{
					in.close();
				}
			} catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static String httpGetHost(String url)
	{
		HttpGet httpget = new HttpGet(url);
		String strResult = "";
		BasicHttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
		HttpConnectionParams.setSoTimeout(httpParams, 5000);
		HttpClient httpclient;
		try
		{
			httpclient = new DefaultHttpClient(httpParams);
			HttpResponse response = httpclient.execute(httpget);
			System.out.println(response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == 200)
			{
				strResult = EntityUtils.toString(response.getEntity(), HTTP.UTF_8);
			}
		} catch (ConnectException e)
		{
			e.printStackTrace();
			System.out.println("hosterror");
		} catch (ClientProtocolException e)
		{
			System.out.println("Client");
			e.printStackTrace();
		} catch (IOException e)
		{
			System.out.println("IO");
			e.printStackTrace();
		}
		return strResult;
	}

	public static String httpGet(String url)
	{
		System.out.println("httpGet" + url);
		HttpGet httpget = new HttpGet(url);
		String strResult = null;
		BasicHttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
		HttpConnectionParams.setSoTimeout(httpParams, 10000);

		HttpClient httpclient;
		try
		{
			httpclient = new DefaultHttpClient(httpParams);
			httpget.setHeader("Cookie", cookieName + "=" + cookieValue);
			HttpResponse response = httpclient.execute(httpget);
			System.out.println(response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == 200)
			{
				strResult = EntityUtils.toString(response.getEntity(), HTTP.UTF_8);
				// System.out.println(strResult);
				System.out.println("getFinish");
			}
		} catch (ConnectException e)
		{
			e.printStackTrace();
		} catch (ClientProtocolException e)
		{
			System.out.println("Client");
			e.printStackTrace();
		} catch (IOException e)
		{
			System.out.println("IO");
			e.printStackTrace();
		}
		return strResult;
	}

	public static String httpGetNoResult(String url)
	{
		System.out.println("httpGetNo" + url);
		HttpGet httpget = new HttpGet(hostBase + url);
		String strResult = "";
		BasicHttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
		HttpConnectionParams.setSoTimeout(httpParams, 10000);

		HttpClient httpclient;
		try
		{
			httpclient = new DefaultHttpClient(httpParams);
			httpget.setHeader("Cookie", cookieName + "=" + cookieValue);
			HttpResponse response = httpclient.execute(httpget);
			System.out.println(response.getStatusLine().getStatusCode());
			/*
			 * if(response.getStatusLine().getStatusCode() == 200){ strResult =
			 * EntityUtils.toString(response.getEntity(), HTTP.UTF_8);
			 * System.out.println(strResult); System.out.println("getFinish"); }
			 */
		} catch (Exception e)
		{
			e.printStackTrace();
			strResult = "error";
		}
		return strResult;
	}

	public static Bitmap HttpGetBmp(String url)
	{
		HttpGet httpget = new HttpGet(url);
		BasicHttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
		HttpConnectionParams.setSoTimeout(httpParams, 10000);
		Bitmap bitmap = null;
		try
		{
			HttpClient httpclient = new DefaultHttpClient(httpParams);
			HttpResponse response = httpclient.execute(httpget);
			InputStream is = response.getEntity().getContent();
			byte[] bytes = new byte[1024];
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int count = 0;
			while ((count = is.read(bytes)) != -1)
			{
				System.out.println("readBitmap");
				bos.write(bytes, 0, count);
			}
			byte[] byteArray = bos.toByteArray();
			bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
			is.close();
			bos.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return bitmap;
	}

	public static InputStream HttpGetBmpInputStream(String url)
	{
		HttpGet httpget = new HttpGet(url);
		BasicHttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
		HttpConnectionParams.setSoTimeout(httpParams, 10000);
		InputStream is = null;
		try
		{
			HttpClient httpclient = new DefaultHttpClient(httpParams);
			HttpResponse response = httpclient.execute(httpget);
			is = response.getEntity().getContent();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return is;
	}

	public static Integer GetCookie(String url, String number, String pw, String select, String host)
	{
		System.out.println("GetCookie");
		int result = 4;
		HttpPost httpPost = new HttpPost(hostBase + url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("number", number));
		nvps.add(new BasicNameValuePair("passwd", pw));
		nvps.add(new BasicNameValuePair("select", select));
		BasicHttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
		HttpConnectionParams.setSoTimeout(httpParams, 10000);
		try
		{
			DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);
			httpClient.setRedirectHandler(new RedirectHandler()
			{

				@Override
				public boolean isRedirectRequested(HttpResponse response, HttpContext context)
				{
					return false;
				}

				@Override
				public URI getLocationURI(HttpResponse response, HttpContext context) throws ProtocolException
				{
					return null;
				}
			});
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			HttpResponse response = httpClient.execute(httpPost);
			System.out.println(response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == 200)
			{
				return 2;
			}
			else if (response.getStatusLine().getStatusCode() == 302)
			{
				Header[] headers = response.getHeaders("Location");
				if (headers != null && headers.length > 0)
				{
					List<Cookie> list = httpClient.getCookieStore().getCookies();
					for (Cookie c : list)
					{
						cookieName = c.getName();
						cookieValue = c.getValue();
					}
					System.out.println(cookieName + cookieValue);
					return 3;
				}
			}
			else if (response.getStatusLine().getStatusCode() == 404)
			{
				return -1;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public static String httpGetCookie(String url)
	{
		System.out.println("httpGetCookie" + url);
		HttpGet httpget = new HttpGet(hostBase + url);
		String strResult = "";
		BasicHttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 15000);
		HttpConnectionParams.setSoTimeout(httpParams, 15000);
		try
		{
			DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);
			httpClient.setRedirectHandler(new RedirectHandler()
			{

				@Override
				public boolean isRedirectRequested(HttpResponse response, HttpContext context)
				{
					return false;
				}

				@Override
				public URI getLocationURI(HttpResponse response, HttpContext context) throws ProtocolException
				{
					return null;
				}
			});
			httpget.setHeader("Cookie", cookieName + "=" + cookieValue);
			HttpResponse response = httpClient.execute(httpget);
			if (response.getStatusLine().getStatusCode() == 200)
			{
				strResult = EntityUtils.toString(response.getEntity(), HTTP.UTF_8);
			}
			else if (response.getStatusLine().getStatusCode() == 302)
			{
				strResult = "302"; // cookieʧЧ�������ض����־�������µ�¼��ȡ
			}
			else if (response.getStatusLine().getStatusCode() == 404)
			{
				strResult = "-1";
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			strResult = "4";
		}
		return strResult;
	}

	public static String httpPostCookie(String url, String id, String data)
	{
		System.out.println("httpPostCookie" + url);
		String result = "4";
		HttpPost httpPost = new HttpPost(hostBase + url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("marc_no", id));
		nvps.add(new BasicNameValuePair("r_content", data));
		BasicHttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
		HttpConnectionParams.setSoTimeout(httpParams, 10000);
		try
		{
			DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);
			httpClient.setRedirectHandler(new RedirectHandler()
			{

				@Override
				public boolean isRedirectRequested(HttpResponse response, HttpContext context)
				{
					return false;
				}

				@Override
				public URI getLocationURI(HttpResponse response, HttpContext context) throws ProtocolException
				{
					return null;
				}
			});
			httpPost.setHeader("Cookie", cookieName + "=" + cookieValue);
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			HttpResponse response = httpClient.execute(httpPost);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(EntityUtils.toString(response.getEntity(), HTTP.UTF_8) + "add");
			if (response.getStatusLine().getStatusCode() == 200)
			{
				return "2";
			}
			else if (response.getStatusLine().getStatusCode() == 302)
			{
				Header[] headers = response.getHeaders("Location");
				if (headers != null && headers.length > 0)
				{
					System.out.println(headers[0].getValue());
					return "3";
				}
			}
			else if (response.getStatusLine().getStatusCode() == 404)
			{
				return "-1";
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public static int getCookie(String url)
	{
		System.out.println("getCookie" + url);
		HttpGet httpGet = new HttpGet(hostBase + url);
		try
		{
			DefaultHttpClient httpClient = new DefaultHttpClient();
			httpClient.setRedirectHandler(new RedirectHandler()
			{

				@Override
				public boolean isRedirectRequested(HttpResponse response, HttpContext context)
				{
					return false;
				}

				@Override
				public URI getLocationURI(HttpResponse response, HttpContext context) throws ProtocolException
				{
					return null;
				}
			});
			HttpResponse response = httpClient.execute(httpGet);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(EntityUtils.toString(response.getEntity(), HTTP.UTF_8) + "add");
			if (response.getStatusLine().getStatusCode() == 200)
			{
				Header[] heads = response.getAllHeaders();
				System.out.println(heads.length);
				for (Header header : heads)
				{
					System.out.println(header.getName() + " = " + header.getValue());
				}
				return 2;
			}
			else if (response.getStatusLine().getStatusCode() == 302)
			{
				Header[] headers = response.getHeaders("Location");
				if (headers != null && headers.length > 0)
				{
					System.out.println(headers[0].getValue());
					return 3;
				}
			}
			else if (response.getStatusLine().getStatusCode() == 404)
			{
				return -1;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return 1;
	}
}
