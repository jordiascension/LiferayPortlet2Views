package MyFirstMvcPortlet.portlet;

import MyFirstMvcPortlet.constants.MyFirstMvcPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author admin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MyFirstMvc",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MyFirstMvcPortletKeys.MYFIRSTMVC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user,guest,administrator"
	},
	service = Portlet.class
)
public class MyFirstMvcPortlet extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(MyFirstMvcPortlet.class.getName());
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		super.serveResource(resourceRequest, resourceResponse);
		
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		super.render(renderRequest, renderResponse);
		
	}
	
	@ProcessAction(name = "autoDetailsSubmit")
	public void autoDetailsSubmit(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		System.out.println(">>>>>>>>>>>>>>>>>>>>>Into autoDetailsSubmit");
		ParamUtil.print(actionRequest);
		//actionResponse.sendRedirect(actionRequest.getContextPath()+"viewdetails.jsp");
		
		String bodystyle =ParamUtil.getString(actionRequest, "bodystyle", "");
		System.out.println("bodystyle is" + bodystyle);
		_log.info("bodystyle in log is ==>"+ bodystyle);
		actionResponse.setRenderParameter("bodystyle", bodystyle);
		 actionResponse.setRenderParameter("jspPage","/viewdetails.jsp");
		 
		
		
	}
}