package struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import struts1.actionform.PersonForm;
import struts1.vo.PersonVO;

public class RegisterAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PersonForm pForm = (PersonForm)form;
		System.out.println(pForm.toString());	// BL호출
		
		//ActionForm의 property를 VO로 copy
		PersonVO pvo = new PersonVO();
		PropertyUtils.copyProperties(pvo, pForm);
		System.out.println(pvo.toString());
		
		ActionForward af = mapping.findForward("success");
		return af;
	}
}
