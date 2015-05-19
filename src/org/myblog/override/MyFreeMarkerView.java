package org.myblog.override;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
/**
 * 该类继承FreeMarker,将需要重写的方法写在此类中即可
 * @author bobmeek
 *
 */
public class MyFreeMarkerView extends FreeMarkerView {
	
	/**项目根路径**/
	private static final String CONTEXT_PATH = "basePath";
	
	/**重写该方法,将项目该路径放到model中,可在ftl文件中直接获取**/
	@Override
	protected void exposeHelpers(Map<String, Object> model,
			HttpServletRequest request) throws Exception {
		model.put(CONTEXT_PATH, request.getContextPath());
		super.exposeHelpers(model, request);
	}

}
