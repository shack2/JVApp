package filter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import tool.FileTools;

/**
 * Servlet Filter implementation class AcessLogFilter
 */
public class AcessLogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AcessLogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		File logFile=new File(req.getRealPath("/")+"log.txt");
		
		if(!logFile.exists()){	
			logFile.createNewFile();
		}
		HttpServletRequest request=(HttpServletRequest)req;
		
		Map<String, String[]> params = request.getParameterMap();
        String queryString = "";
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                queryString += key + "=" + value + "&";
            }
        }
        // 去掉最后一个空格
        if(queryString!=null&&queryString.length()>0){
        	
        	queryString = queryString.substring(0, queryString.length() - 1);
        }
        

		String data=request.getRequestURI()+"------"+queryString+"----"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		FileTools.apendTextToFile(logFile, data);
		
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
