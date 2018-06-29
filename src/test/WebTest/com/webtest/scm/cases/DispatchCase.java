package com.webtest.scm.cases;

import org.testng.annotations.Test;

import com.webtest.scm.base.DispatchBase;
import com.webtest.scm.config.GetTestProperties;


public class DispatchCase extends DispatchBase{
	
	
	
	@Test
	public void dispath() throws Exception {
		
		try {		
			openChainPage();
			
			addPurchaseOrder();
			verifyPurchaseOrder();	
					
			splitDeliveryOrder();
			
			deliveryConfirm();
			goToDeliveryManage();
			verifyStatus("//td[text()='"+DeliveryCode+"']/ancestor::tr//span[@class='ant-badge-status-text']",GetTestProperties.getStatusB());			
		
			deliveryOut();
			verifyStatus("//td[text()='"+DeliveryCode+"']/ancestor::tr//span[@class='ant-badge-status-text']",GetTestProperties.getStatusA());			
			
			deliveryAccept();
			verifyStatus("//td[text()='"+DeliveryCode+"']/ancestor::tr//span[@class='ant-badge-status-text']",GetTestProperties.getStatusY());
						
		}catch(Exception e) {
			e.printStackTrace();
			failAndScreenshot(e);			
		}
		
	}
}
