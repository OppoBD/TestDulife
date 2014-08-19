package com.dulife.test;

import com.robotium.solo.Solo;
import junit.framework.TestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

@SuppressWarnings("unchecked")
public class version_1_0_2 extends ActivityInstrumentationTestCase2 {

	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.baidu.wearable.ui.activities.WelcomeActivity";
	private static Class launcherActivityClass;
	static {

		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public version_1_0_2() throws ClassNotFoundException {
		super(launcherActivityClass);
	}

	private Solo solo;

	@Override
	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testLogin() {
		solo.clickOnText("ȷ��");
		solo.sleep(5000);
		//���󻬶�3��
		for(int i =0 ;i < 3; i++) {
			solo.scrollToSide(22);
			solo.sleep(1000);
		}		
		// Enter any integer/decimal value for first editfield, we are writing  10
		solo.clearEditText(0);
		solo.enterText(0, "yanjinghua1102@126.com");
		
		// Enter any integer/decimal value for first editfield, we are writing  20
		solo.clearEditText(1);
		solo.enterText(1, "yanjinghua");
		
		// Click on Multiply button
		int id = solo.getCurrentActivity().getResources().getIdentifier("login", "id", "com.baidu.wearable");
		View v = solo.getView(id);
		solo.clickOnView(v);
		solo.sleep(10000);
		
		//������°汾����ȡ������
		solo.waitForText("�°汾");
		if(solo.searchText("�°汾"))
			solo.clickOnText("ȡ��");
		solo.sleep(2000);
		
		//������Խ�������
		solo.searchText("����");
		if(solo.searchText("����"))
			solo.clickOnText("����");		
		solo.sleep(5000);

		// Verify that resultant of 10 x 20
//		assertTrue(solo.searchText("liwei05test03"));
//		assertTrue(solo.searchText("������"));
		assertTrue(solo.searchText("����豸"));
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
