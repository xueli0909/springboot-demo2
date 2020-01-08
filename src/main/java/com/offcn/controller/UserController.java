package com.offcn.controller;


import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService us;

    //获取列表数据，跳转列表模板
    @GetMapping("/")
    public String getlist(Model model) {
        List<User> list = us.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    //点击add按钮跳转到新增用户页面
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "useradd";
    }


    @PostMapping("/add")
    public String add(User user) {
        us.add(user);
        return "redirect:/";
    }

    @GetMapping("/toEdit/{id}")
    public String toEdit(Model model,@PathVariable("id") Long id) {
        User user = us.findOne(id);
        model.addAttribute("user", user);
        return "userEdit";
    }

    @RequestMapping("/update")
    private String update(User user) {
        us.update(user);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        us.delete(id);
        return "redirect:/";
    }
}
