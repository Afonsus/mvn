package cn.mxcorp.mvntest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.ImmutableMap;

/**
 * Created by PC0801 on 2014/7/30.
 */
@Controller
@RequestMapping
public class IndexController {

	@RequestMapping({ "/index", "/home", "", "/" })
	public String home(Model model) {
		model.addAttribute("jsClass", "gm.home.HomeView");
		return "subpage";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("jsClass", "gm.login.UserLoginView");
		return "subpage";
	}

	@RequestMapping({ "/echarts" })
	public void echarts() {
	}

	@RequestMapping("/test")
	@ResponseBody
	public Object test() {
		return ImmutableMap.of("name", "你好");
	}
}
