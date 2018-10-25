package action;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

public class TestAction{

	
	public void test() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().print("Test action....");
		
	}
}